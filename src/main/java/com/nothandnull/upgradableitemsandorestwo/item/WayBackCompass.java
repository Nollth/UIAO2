package com.nothandnull.upgradableitemsandorestwo.item;

import com.nothandnull.upgradableitemsandorestwo.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.Random;

public class WayBackCompass extends Item {
    private static final String TAG_MAGHEMITE_POS = "MaghemitePos";
    private static final String TAG_ANGLE = "angle";
    private static final String TAG_TRACKING = "Tracking";
    private static final Random RANDOM = new Random();
    private static final String TAG_LAST_ANGLE = "LastAngle";

    public WayBackCompass(Properties properties) {
        super(properties);
    }

    private void teleportToMaghemite(Level level, Player player, ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null && tag.getBoolean(TAG_TRACKING) && tag.contains(TAG_MAGHEMITE_POS)) {
            BlockPos maghemitePos = BlockPos.of(tag.getLong(TAG_MAGHEMITE_POS));

            if (level.getBlockState(maghemitePos).getBlock() == ModBlocks.MAGHEMITE.get()) {
                if (!level.isClientSide) {
                    player.teleportTo(
                            maghemitePos.getX() + 0.5D,
                            maghemitePos.getY() + 1.0D,
                            maghemitePos.getZ() + 0.5D
                    );

                    tag.remove(TAG_MAGHEMITE_POS);
                    tag.putBoolean(TAG_TRACKING, false);

                    player.displayClientMessage(Component.literal("Teleported")
                            .withStyle(ChatFormatting.GREEN), true);
                }

                if (level.isClientSide) {
                    level.playSound(
                            player,
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            SoundEvents.ENDERMAN_TELEPORT,
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                    );

                    for (int i = 0; i < 32; ++i) {
                        level.addParticle(
                                ParticleTypes.PORTAL,
                                player.getX(),
                                player.getY() + player.getRandom().nextDouble() * 2.0D,
                                player.getZ(),
                                player.getRandom().nextGaussian() * 0.02D,
                                0.0D,
                                player.getRandom().nextGaussian() * 0.02D
                        );
                    }

                    for (int i = 0; i < 32; ++i) {
                        level.addParticle(
                                ParticleTypes.PORTAL,
                                maghemitePos.getX() + 0.5D,
                                maghemitePos.getY() + player.getRandom().nextDouble() * 2.0D,
                                maghemitePos.getZ() + 0.5D,
                                player.getRandom().nextGaussian() * 0.02D,
                                0.0D,
                                player.getRandom().nextGaussian() * 0.02D
                        );
                    }

                    level.playSound(
                            null,
                            maghemitePos,
                            SoundEvents.ENDERMAN_TELEPORT,
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                    );
                }
            }
        }
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
        if (entity instanceof Player player) {
            int useDuration = getUseDuration(stack) - remainingUseDuration;

            if (useDuration >= 100) {
                teleportToMaghemite(level, player, stack);
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (itemstack.getOrCreateTag().getBoolean(TAG_TRACKING)) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }

        return InteractionResultHolder.pass(itemstack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        CompoundTag tag = stack.getOrCreateTag();

        if (!level.isClientSide && entity instanceof Player player) {
            if (tag.getBoolean(TAG_TRACKING) && tag.contains(TAG_MAGHEMITE_POS)) {
                BlockPos maghemitePos = BlockPos.of(tag.getLong(TAG_MAGHEMITE_POS));

                if (!level.getBlockState(maghemitePos).is(ModBlocks.MAGHEMITE.get())) {
                    tag.remove(TAG_MAGHEMITE_POS);
                    tag.putBoolean(TAG_TRACKING, false);
                    player.displayClientMessage(Component.literal("Broken ")
                            .withStyle(ChatFormatting.RED), true);
                }
            }
        }

        if (level.isClientSide() && entity instanceof Player player) {
            if (tag.getBoolean(TAG_TRACKING) && tag.contains(TAG_MAGHEMITE_POS)) {
                BlockPos maghemitePos = BlockPos.of(tag.getLong(TAG_MAGHEMITE_POS));
                double targetAngle = getAngleToMaghemite(player, maghemitePos);
                float currentAngle = tag.contains(TAG_LAST_ANGLE) ?
                        tag.getFloat(TAG_LAST_ANGLE) : (float) targetAngle;

                double diff = targetAngle - currentAngle;

                if (diff > 0.5) diff -= 1.0;
                if (diff < -0.5) diff += 1.0;

                float newAngle = currentAngle + (float)(diff * 0.1);

                if (newAngle >= 1.0F) newAngle -= 1.0F;
                if (newAngle < 0.0F) newAngle += 1.0F;

                tag.putFloat(TAG_ANGLE, newAngle);
                tag.putFloat(TAG_LAST_ANGLE, newAngle);
            } else {
                float currentAngle = tag.getFloat(TAG_ANGLE);
                float randomSpeed = (float) (RANDOM.nextFloat() * 0.01 + 0.05);
                currentAngle += randomSpeed;
                if (currentAngle > 1.0F) currentAngle -= 1.0F;
                tag.putFloat(TAG_ANGLE, currentAngle);
                tag.putFloat(TAG_LAST_ANGLE, currentAngle);
            }
        }
    }

    private double getAngleToMaghemite(Player player, BlockPos target) {
        double playerX = player.getX();
        double playerZ = player.getZ();
        double targetX = target.getX() + 0.5D;
        double targetZ = target.getZ() + 0.5D;

        double deltaX = targetX - playerX;
        double deltaZ = targetZ - playerZ;

        double angleToTarget = Math.atan2(deltaZ, deltaX);

        double playerRotation = player.getYRot() * Math.PI / 180.0D;

        double angleDiff = angleToTarget - playerRotation;

        while (angleDiff > Math.PI) angleDiff -= 2.0D * Math.PI;
        while (angleDiff < -Math.PI) angleDiff += 2.0D * Math.PI;


        double finalAngle = (angleDiff / (2.0D * Math.PI) + 0.75D) % 1.0D;
        if (finalAngle < 0) finalAngle += 1.0D;

        return finalAngle;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        ItemStack itemStack = context.getItemInHand();
        Player player = context.getPlayer();

        if (level.getBlockState(pos).getBlock() == ModBlocks.MAGHEMITE.get()) {
            CompoundTag tag = itemStack.getOrCreateTag();

            if (tag.getBoolean(TAG_TRACKING)) {
                if (isTracking(tag, pos)) {
                    tag.remove(TAG_MAGHEMITE_POS);
                    tag.putBoolean(TAG_TRACKING, false);

                    if (player != null && level.isClientSide) {
                        player.displayClientMessage(Component.literal("Turned Off")
                                .withStyle(ChatFormatting.WHITE), true);
                    }
                    return InteractionResult.SUCCESS;
                } else {
                    if (player != null && level.isClientSide) {
                        player.displayClientMessage(Component.literal("Already Turned")
                                .withStyle(ChatFormatting.YELLOW), true);
                    }
                    return InteractionResult.PASS;
                }
            }

            tag.putBoolean(TAG_TRACKING, true);
            tag.putLong(TAG_MAGHEMITE_POS, pos.asLong());

            if (player != null && level.isClientSide) {
                String coords = String.format("X: %d, Y: %d, Z: %d",
                        pos.getX(), pos.getY(), pos.getZ());
                player.displayClientMessage(Component.literal(coords)
                        .withStyle(ChatFormatting.WHITE), true);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private double calculateAngle(Player player, BlockPos target) {
        double playerX = player.getX();
        double playerZ = player.getZ();
        double targetX = target.getX() + 0.5;
        double targetZ = target.getZ() + 0.5;

        return Math.atan2(targetZ - playerZ, targetX - playerX);
    }

    private boolean isTracking(CompoundTag tag, BlockPos pos) {
        return tag.contains(TAG_MAGHEMITE_POS) && tag.getLong(TAG_MAGHEMITE_POS) == pos.asLong();
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.SPEAR;
    }
}
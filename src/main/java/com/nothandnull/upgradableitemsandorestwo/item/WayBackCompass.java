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
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class WayBackCompass extends Item {
    public static final String TAG_MAGHEMITE_POS = "MaghemitePos";
    public static final String TAG_ANGLE = "angle";
    public static final String TAG_TRACKING = "Tracking";
    public static final String TAG_LAST_USE = "LastUse";
    public static final Random RANDOM = new Random();
    public static final String TAG_LAST_ANGLE = "LastAngle";
    public static final int COOLDOWN_TICKS = 300;

    public WayBackCompass(Properties properties) {
        super(properties);
    }

    private void teleportToMaghemite(Level level, Player player, ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null && tag.getBoolean(TAG_TRACKING) && tag.contains(TAG_MAGHEMITE_POS)) {
            if (!level.dimension().equals(Level.OVERWORLD)) {
                player.displayClientMessage(Component.literal("Try At The Overworld.")
                        .withStyle(ChatFormatting.RED), true);
                return;
            }

            BlockPos maghemitePos = BlockPos.of(tag.getLong(TAG_MAGHEMITE_POS));
            BlockPos playerPos = player.blockPosition();

            if (!level.isClientSide) {
                level.getChunkAt(maghemitePos);
                level.getChunkAt(playerPos);
            }

            if (level.getBlockState(maghemitePos).getBlock() == ModBlocks.MAGHEMITE.get()) {
                spawnPortalParticles(level, playerPos, 0.5);

                if (!level.isClientSide) {
                    player.stopUsingItem();

                    player.teleportTo(
                            maghemitePos.getX() + 0.5D,
                            maghemitePos.getY() + 1.0D,
                            maghemitePos.getZ() + 0.5D
                    );

                    tag.putLong(TAG_LAST_USE, level.getGameTime());

                    player.displayClientMessage(Component.literal("Teleported.")
                            .withStyle(ChatFormatting.GREEN), true);
                }

                spawnPortalParticles(level, maghemitePos, 1.0);
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

    private void spawnPortalParticles(Level level, BlockPos pos, double yOffset) {
        if (level.isClientSide) {
            for (int i = 0; i < 50; i++) {
                double angle = i * (Math.PI * 2) / 20;
                double radius = Math.sin(i * 0.1) * 0.5;
                double x = pos.getX() + 0.5 + Math.cos(angle) * radius;
                double y = pos.getY() - 0.5 + (i * 0.05);
                double z = pos.getZ() + 0.5 + Math.sin(angle) * radius;

                level.addParticle(
                        ParticleTypes.PORTAL,
                        x, y, z,
                        Math.cos(angle) * 0.01,
                        0.2,
                        Math.sin(angle) * 0.01
                );
            }

            for (int i = 0; i < 30; i++) {
                double angle = Math.random() * Math.PI * 2;
                double radius = Math.random() * 0.5;
                double x = pos.getX() + 0.5 + Math.cos(angle) * radius;
                double y = pos.getY() - 0.5 + Math.random() * 2.0;
                double z = pos.getZ() + 0.5 + Math.sin(angle) * radius;

                level.addParticle(
                        ParticleTypes.PORTAL,
                        x, y, z,
                        Math.cos(angle) * 0.1,
                        Math.random() * 0.1,
                        Math.sin(angle) * 0.1
                );
            }

            level.playLocalSound(
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    SoundEvents.ENDERMAN_TELEPORT,
                    SoundSource.PLAYERS,
                    1.0F,
                    0.8F,
                    false
            );
        }
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        CompoundTag tag = itemstack.getOrCreateTag();

        if (tag.contains(TAG_LAST_USE)) {
            long lastUse = tag.getLong(TAG_LAST_USE);
            long currentTime = level.getGameTime();

            if (currentTime - lastUse < COOLDOWN_TICKS) {
                int remainingSeconds = (int)((COOLDOWN_TICKS - (currentTime - lastUse)) / 20);
                player.displayClientMessage(Component.literal("Wait before using it again (" + remainingSeconds + ")")
                        .withStyle(ChatFormatting.RED), true);
                return InteractionResultHolder.fail(itemstack);
            }
        }

        if (tag.getBoolean(TAG_TRACKING) && !level.dimension().equals(Level.OVERWORLD)) {
            player.displayClientMessage(Component.literal("Can not be used outside the Overworld.")
                    .withStyle(ChatFormatting.RED), true);
            return InteractionResultHolder.fail(itemstack);
        }

        if (itemstack.getOrCreateTag().getBoolean(TAG_TRACKING)) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }

        return InteractionResultHolder.pass(itemstack);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        CompoundTag tag = stack.getOrCreateTag();

        if (!level.isClientSide && entity instanceof Player player) {
            if (tag.getBoolean(TAG_TRACKING) && tag.contains(TAG_MAGHEMITE_POS)) {
                BlockPos maghemitePos = BlockPos.of(tag.getLong(TAG_MAGHEMITE_POS));

                if (level.dimension().equals(Level.OVERWORLD) &&
                        !level.getBlockState(maghemitePos).is(ModBlocks.MAGHEMITE.get())) {
                    tag.remove(TAG_MAGHEMITE_POS);
                    tag.putBoolean(TAG_TRACKING, false);
                    player.displayClientMessage(Component.literal("Broken.")
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

            if (!tag.getBoolean(TAG_TRACKING) && !level.dimension().equals(Level.OVERWORLD)) {
                if (player != null && level.isClientSide) {
                    player.displayClientMessage(Component.literal("Impossible to attach outside the Overworld.")
                            .withStyle(ChatFormatting.RED), true);
                }
                return InteractionResult.FAIL;
            }

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

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        CompoundTag tag = stack.getTag();
        if (tag != null && tag.getBoolean(TAG_TRACKING) && tag.contains(TAG_MAGHEMITE_POS)) {
            BlockPos pos = BlockPos.of(tag.getLong(TAG_MAGHEMITE_POS));
            String coords = String.format("§l§o§fMaghemite: X: %d, Y: %d, Z: %d§r",
                    pos.getX(), pos.getY(), pos.getZ());
            tooltip.add(Component.literal(coords));
        }
    }
}
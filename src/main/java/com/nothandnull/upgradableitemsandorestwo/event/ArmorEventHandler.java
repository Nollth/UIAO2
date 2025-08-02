package com.nothandnull.upgradableitemsandorestwo.event;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import com.nothandnull.upgradableitemsandorestwo.item.ModItems;
import com.nothandnull.upgradableitemsandorestwo.item.UnbreakableArmor;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = UpgradableItemsAndOresTwo.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ArmorEventHandler {
    private static final String TAG_VERIFIED = "OwUVerified";
    private static final String TAG_IS_MOB = "OwUMob";
    private static final String TAG_IS_SEMI_MOB = "OwUSemiMob";

    private static void updateArmorState(LivingEntity entity) {
        if (entity == null) return;

        boolean isPlayer = entity instanceof Player;
        boolean isArmorStand = entity instanceof ArmorStand;

        entity.getPersistentData().remove(TAG_VERIFIED);
        entity.getPersistentData().remove(TAG_IS_MOB);
        entity.getPersistentData().remove(TAG_IS_SEMI_MOB);

        ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chestplate = entity.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack leggings = entity.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack boots = entity.getItemBySlot(EquipmentSlot.FEET);

        boolean hasCorrectHelmet = !helmet.isEmpty() &&
                helmet.getItem().equals(ModItems.OWU_HELMET.get()) &&
                helmet.getItem() instanceof UnbreakableArmor;

        boolean hasCorrectChestplate = !chestplate.isEmpty() &&
                chestplate.getItem().equals(ModItems.OWU_CHESTPLATE.get()) &&
                chestplate.getItem() instanceof UnbreakableArmor;

        boolean hasCorrectLeggings = !leggings.isEmpty() &&
                leggings.getItem().equals(ModItems.OWU_LEGGINGS.get()) &&
                leggings.getItem() instanceof UnbreakableArmor;

        boolean hasCorrectBoots = !boots.isEmpty() &&
                boots.getItem().equals(ModItems.OWU_BOOTS.get()) &&
                boots.getItem() instanceof UnbreakableArmor;

        boolean hasFullSet = hasCorrectHelmet && hasCorrectChestplate &&
                hasCorrectLeggings && hasCorrectBoots;

        if (hasFullSet) {
            if (isPlayer) {
                entity.getPersistentData().putBoolean(TAG_VERIFIED, true);
            } else if (!isArmorStand) {
                entity.getPersistentData().putBoolean(TAG_IS_MOB, true);
            }
        } else if (!isPlayer && !isArmorStand && (hasCorrectHelmet || hasCorrectChestplate ||
                hasCorrectLeggings || hasCorrectBoots)) {
            entity.getPersistentData().putBoolean(TAG_IS_SEMI_MOB, true);
        }
    }

    private static boolean isVerified(LivingEntity entity) {
        return entity != null && entity.getPersistentData().getBoolean(TAG_VERIFIED);
    }

    private static boolean isMob(LivingEntity entity) {
        return entity != null && entity.getPersistentData().getBoolean(TAG_IS_MOB);
    }

    private static boolean isSemiMob(LivingEntity entity) {
        return entity != null && entity.getPersistentData().getBoolean(TAG_IS_SEMI_MOB);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        updateArmorState(entity);

        if (isMob(entity) || isSemiMob(entity)) {
            if (!entity.level().isClientSide) {
                String entityName = entity.getName().getString();
                Component message = Component.literal("(OwU) - ")
                        .append(entityName)
                        .append(" Has Been Obliterated.")
                        .withStyle(ChatFormatting.DARK_RED);

                entity.level().players().forEach(player ->
                        player.sendSystemMessage(message));
            }

            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                    entity.setItemSlot(slot, ItemStack.EMPTY);
                }
            }
            entity.kill();
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        updateArmorState(player);

        boolean wasAllow = player.getAbilities().mayfly;
        boolean wasInv = player.isInvulnerable();


        if (!isVerified(player)) {
            if (!player.isCreative() && !player.isSpectator() && !wasAllow && !wasInv) {
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
                player.setInvulnerable(false);
                player.onUpdateAbilities();
            }
            return;
        }

        player.setInvulnerable(true);
        player.clearFire();
        player.setRemainingFireTicks(0);
        player.setAirSupply(player.getMaxAirSupply());
        player.setHealth(player.getMaxHealth());
        player.removeAllEffects();
        player.getAbilities().mayfly = true;
        player.getFoodData().setFoodLevel(20);
        player.getFoodData().setSaturation(20f);
        player.onUpdateAbilities();
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingHurt(LivingHurtEvent event) {
        if (isVerified(event.getEntity())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onFall(LivingFallEvent event) {
        if (isVerified(event.getEntity())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPotionAdded(MobEffectEvent.Added event) {
        if (isVerified(event.getEntity())) {
                MobEffect effect = event.getEffectInstance().getEffect();
                if (effect.getCategory() == MobEffectCategory.HARMFUL) {
                    event.setCanceled(true);
                }
            }
        }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
        LivingEntity entity = event.getEntity();
        updateArmorState(entity);

        if (isMob(entity) || isSemiMob(entity)) {
            if (!entity.level().isClientSide) {
                String entityName = entity.getName().getString();
                Component message = Component.literal("(OwU) - ")
                        .append(entityName)
                        .append(" Has Been Obliterated.")
                        .withStyle(ChatFormatting.DARK_RED);

                entity.level().players().forEach(player ->
                        player.sendSystemMessage(message));
            }

            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                    entity.setItemSlot(slot, ItemStack.EMPTY);
                }
            }
            entity.kill();
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onItemSpawn(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof ItemEntity itemEntity) {
            ItemStack stack = itemEntity.getItem();
            if (stack.getItem() instanceof UnbreakableArmor armor && !armor.hasBindingCurse(stack)) {
                stack.enchant(Enchantments.BINDING_CURSE, 1);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        ItemStack stack = event.getCrafting();
        if (stack.getItem() instanceof UnbreakableArmor armor && !armor.hasBindingCurse(stack)) {
            stack.enchant(Enchantments.BINDING_CURSE, 1);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onItemPickup(EntityItemPickupEvent event) {
        ItemStack stack = event.getItem().getItem();
        if (stack.getItem() instanceof UnbreakableArmor armor && !armor.hasBindingCurse(stack)) {
            stack.enchant(Enchantments.BINDING_CURSE, 1);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onMobTarget(LivingChangeTargetEvent event) {
        if (isVerified(event.getEntity())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (isVerified(event.getEntity())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingDeath(LivingDeathEvent event) {
        if (isVerified(event.getEntity())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onProjectileImpact(ProjectileImpactEvent event) {
        if (event.getRayTraceResult() instanceof EntityHitResult entityHit) {
            if (entityHit.getEntity() instanceof Player player) {
                updateArmorState(player);
                if (isVerified(player)) {
                    event.setCanceled(true);
                    event.getProjectile().discard();
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onAnyDamage(LivingDamageEvent event) {
        if (isVerified(event.getEntity())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingAttack(LivingAttackEvent event) {
        if (isVerified(event.getEntity())) {
            event.setCanceled(true);
        }
    }
}
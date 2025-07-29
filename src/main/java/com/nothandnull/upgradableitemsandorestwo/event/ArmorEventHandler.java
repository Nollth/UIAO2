package com.nothandnull.upgradableitemsandorestwo.event;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
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

    private static boolean isWearingAnyArmorPiece(LivingEntity entity) {
        if (entity == null) return false;
        for (ItemStack stack : entity.getArmorSlots()) {
            if (!stack.isEmpty() && stack.getItem() instanceof UnbreakableArmor) {
                return true;
            }
        }
        return false;
    }

    private static boolean isWearingFullSet(Player player) {
        if (player == null) return false;
        int equippedPieces = 0;
        for (ItemStack stack : player.getArmorSlots()) {
            if (stack.isEmpty()) return false;
            if (!(stack.getItem() instanceof UnbreakableArmor)) return false;
            equippedPieces++;
        }
        return equippedPieces == 4;
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onFall(LivingFallEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getEntity() instanceof Player player && isWearingFullSet(player)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onSuffocation(LivingEvent.LivingTickEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getEntity() instanceof Player player && isWearingFullSet(player)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPotionAdded(MobEffectEvent.Added event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getEntity() instanceof Player player && isWearingFullSet(player)) {
            MobEffect effect = event.getEffectInstance().getEffect();
            if (effect.getCategory() == MobEffectCategory.HARMFUL) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;

        boolean wasAllowFlying = player.getAbilities().mayfly;
        boolean wasFlying = player.getAbilities().flying;

        if (isWearingFullSet(player)) {
            player.setInvulnerable(true);
            player.clearFire();
            player.setRemainingFireTicks(0);
            player.setAirSupply(player.getMaxAirSupply());
            player.setHealth(player.getMaxHealth());
            player.removeAllEffects();
            player.getAbilities().mayfly = true;
            player.getFoodData().setFoodLevel(20);
            player.getFoodData().setSaturation(20f);
            if (wasFlying) {
                player.getAbilities().flying = true;
            }
        } else {
            if (!player.isCreative() && !player.isSpectator() && !wasAllowFlying && !isWearingFullSet(player)) {
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
            }
        }

        if (wasAllowFlying != player.getAbilities().mayfly ||
                wasFlying != player.getAbilities().flying) {
            player.onUpdateAbilities();
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player || event.getEntity() instanceof ArmorStand) {
            return;
        }

        if (event.getTo().getItem() instanceof UnbreakableArmor) {
            event.setCanceled(true);
            String entityName = event.getEntity().getName().getString();
            if (!event.getEntity().level().isClientSide) {
                Component message = Component.literal("(OwU) - ")
                        .append(entityName)
                        .append(" Has Been Obliterated.")
                        .withStyle(ChatFormatting.DARK_RED);

                for (Player player : event.getEntity().level().players()) {
                    player.sendSystemMessage(message);
                }
            }

            event.getEntity().kill();
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                    event.getEntity().setItemSlot(slot, ItemStack.EMPTY);
                }
            }
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
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        if (event.getEntity() instanceof Player || event.getEntity() instanceof ArmorStand) {
            return;
        }

        if (isWearingAnyArmorPiece(event.getEntity())) {
            event.setCanceled(true);
            String entityName = event.getEntity().getName().getString();

            if (!event.getEntity().level().isClientSide) {
                Component message = Component.literal("(OwU) - ")
                        .append(entityName)
                        .append(" Has Been Obliterated.")
                        .withStyle(ChatFormatting.DARK_RED);

                for (Player player : event.getEntity().level().players()) {
                    player.sendSystemMessage(message);
                }
            }

            event.getEntity().kill();
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                    event.getEntity().setItemSlot(slot, ItemStack.EMPTY);
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onMobTarget(LivingChangeTargetEvent event) {
            if (event.getNewTarget() instanceof Player player && isWearingFullSet(player)) {
            event.setCanceled(true);
            }
        }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getTarget() instanceof Player player && isWearingFullSet(player)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingHurt(LivingHurtEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getEntity() instanceof Player player && isWearingFullSet(player)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getEntity() instanceof Player player && isWearingFullSet(player)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onProjectileImpact(ProjectileImpactEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getEntity() instanceof Player player && isWearingFullSet(player)) {
            if (event.getRayTraceResult() instanceof EntityHitResult entityHit) {
            if (entityHit.getEntity() instanceof Player) {
                event.setCanceled(true);
                event.getProjectile().discard();
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onAnyDamage(LivingDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getEntity() instanceof Player player && isWearingFullSet(player)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingDamage(LivingDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getEntity() instanceof Player player && isWearingFullSet(player)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingAttack(LivingAttackEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getEntity() instanceof Player player && isWearingFullSet(player)) {
            event.setCanceled(true);
        }
    }
}
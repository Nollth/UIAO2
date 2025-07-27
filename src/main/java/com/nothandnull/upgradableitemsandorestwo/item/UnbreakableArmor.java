package com.nothandnull.upgradableitemsandorestwo.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class UnbreakableArmor extends ArmorItem {
    public UnbreakableArmor(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
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

    private boolean isAlternativeMode(ItemStack stack) {
        if (stack.hasTag()) {
            CompoundTag tag = stack.getTag();
            return tag.getBoolean("alternative_mode");
        }
        return false;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if (slot == EquipmentSlot.LEGS) {
            return "upgradableitemsandorestwo:textures/models/armor/owu_layer_2.png";
        } else {
            return "upgradableitemsandorestwo:textures/models/armor/owu_layer_1.png";
        }
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            if (isWearingFullSet(player)) {
                player.setInvulnerable(true);
                player.getAbilities().mayfly = true;
                player.setAirSupply(player.getMaxAirSupply());
                player.clearFire();
                player.setRemainingFireTicks(0);
                player.removeAllEffects();
                player.setHealth(player.getMaxHealth());
                player.getFoodData().setFoodLevel(20);
                player.getFoodData().setSaturation(20f);
            } else {
                player.setInvulnerable(false);
            }
        }
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
            return 0;
    }


    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public int getDefense() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }
}

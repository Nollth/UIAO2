package com.nothandnull.upgradableitemsandorestwo.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class UnbreakableArmor extends ArmorItem {
    public UnbreakableArmor(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    private boolean isAlternativeMode(ItemStack stack) {
        if (stack.hasTag()) {
            CompoundTag tag = stack.getTag();
            if (tag != null) {
                return tag.getBoolean("alternative_mode");
            }
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
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
            return 0;
    }

    private void addBindingCurse(ItemStack stack) {
        stack.enchant(Enchantments.BINDING_CURSE, 1);
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        addBindingCurse(stack);
        return stack;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.BINDING_CURSE, 1);
        }
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        super.onCraftedBy(stack, level, player);
        addBindingCurse(stack);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return !hasBindingCurse(stack);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.BINDING_CURSE;
    }

    public boolean hasBindingCurse(ItemStack stack) {
        return stack.getEnchantmentLevel(Enchantments.BINDING_CURSE) == 1;
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

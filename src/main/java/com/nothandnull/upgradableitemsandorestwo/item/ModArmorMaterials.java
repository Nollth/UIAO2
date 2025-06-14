package com.nothandnull.upgradableitemsandorestwo.item;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    REINFORCED_IRON("reinforced_iron", 30, new int[]{ 4, 12, 10, 4 },
            18, SoundEvents.ARMOR_EQUIP_IRON, 1f, 0.1f,
            () -> Ingredient.of(ModItems.REINFORCED_IRON_INGOT.get())),

    GOLREON("golreon", 22, new int[]{ 4, 11, 8, 3 },
            34, SoundEvents.ARMOR_EQUIP_GOLD, 1f, 0.1f,
            () -> Ingredient.of(ModItems.GOLREON_INGOT.get())),

    REINFORCED_GOLD("reinforced_gold", 14, new int[]{ 4, 10, 6, 2 },
            50, SoundEvents.ARMOR_EQUIP_GOLD, 1f, 0.1f,
            () -> Ingredient.of(ModItems.REINFORCED_GOLD_INGOT.get())),

    NETHORIDEN("nethoriden", 44, new int[]{ 5, 13, 9, 4 },
            40, SoundEvents.ARMOR_EQUIP_NETHERITE, 3f, 0.1f,
            () -> Ingredient.of(ModItems.NETHORIDEN_INGOT.get())),

    REINFORCED_NETHERITE("reinforced_netherite", 74, new int[]{ 6, 16, 12, 6 },
            30, SoundEvents.ARMOR_EQUIP_NETHERITE, 6f, 0.2f,
            () -> Ingredient.of(ModItems.REINFORCED_NETHERITE_INGOT.get())),

    NETHERITOND("netheritond", 70, new int[]{ 6, 16, 12, 6 },
            25, SoundEvents.ARMOR_EQUIP_NETHERITE, 5f, 0.1f,
            () -> Ingredient.of(ModItems.NETHERITOND_INGOT.get())),

    REINFORCED_DIAMOND("reinforced_diamond", 66, new int[]{ 6, 16, 12, 6 },
            20, SoundEvents.ARMOR_EQUIP_DIAMOND, 4f, 0.1f,
            () -> Ingredient.of(ModItems.REINFORCED_DIAMOND.get())),

    DIAMRON("diamron", 18, new int[]{ 5, 14, 11, 5 },
            19, SoundEvents.ARMOR_EQUIP_DIAMOND, 2f, 0.1f,
            () -> Ingredient.of(ModItems.DIAMRON_INGOT.get())),

    HEAVY_IRON("heavy_iron", 60, new int[]{ 8, 24, 20, 8 },
            36, SoundEvents.ARMOR_EQUIP_IRON, 2f, 0.2f,
            () -> Ingredient.of(ModItems.HEAVY_IRON_INGOT.get())),

    NETTHRION("netthrion", 52, new int[]{ 5, 14, 11, 5 },
            24, SoundEvents.ARMOR_EQUIP_NETHERITE, 3f, 0.1f,
            () -> Ingredient.of(ModItems.NETTHRION_INGOT.get())),

    HEAVY_GOLD("heavy_gold", 28, new int[]{ 8, 20, 12, 4 },
            100, SoundEvents.ARMOR_EQUIP_GOLD, 2f, 0.2f,
            () -> Ingredient.of(ModItems.HEAVY_GOLD_INGOT.get())),

    GOALDMOND("goaldmond", 40, new int[]{ 5, 13, 9, 4 },
            35, SoundEvents.ARMOR_EQUIP_GOLD, 2f, 0.1f,
            () -> Ingredient.of(ModItems.GOALDMOND.get())),

    HEAVY_NETHERITE("heavy_netherite", 148, new int[]{ 12, 32, 24, 12 },
            60, SoundEvents.ARMOR_EQUIP_NETHERITE, 12f, 0.4f,
            () -> Ingredient.of(ModItems.HEAVY_NETHERITE_INGOT.get())),

    HEAVY_DIAMOND("heavy_diamond", 132, new int[]{ 12, 32, 24, 12 },
            40, SoundEvents.ARMOR_EQUIP_DIAMOND, 8f, 0.2f,
            () -> Ingredient.of(ModItems.HEAVY_DIAMOND.get()));


    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return UpgradableItemsAndOresTwo.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

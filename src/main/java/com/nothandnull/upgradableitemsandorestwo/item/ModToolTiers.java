package com.nothandnull.upgradableitemsandorestwo.item;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import com.nothandnull.upgradableitemsandorestwo.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier REINFORCED_IRON = TierSortingRegistry.registerTier(
            new ForgeTier(4, 500, 12.0F, 4.0F, 28,
                    ModTags.Blocks.NEEDS_REINFORCED_IRON_TOOL, () -> Ingredient.of(ModItems.REINFORCED_IRON_INGOT.get())),
                    new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "reinforced_iron"), List.of(Tiers.IRON), List.of());

    public static final Tier GOLREON = TierSortingRegistry.registerTier(
            new ForgeTier(2, 282, 18.0F, 2.0F, 36,
                    ModTags.Blocks.NEEDS_GOLREON_TOOL, () -> Ingredient.of(ModItems.GOLREON_INGOT.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "golreon"), List.of(Tiers.IRON), List.of());

    public static final Tier REINFORCED_GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(0, 64, 24.0F, 0.0F, 44,
                    ModTags.Blocks.NEEDS_REINFORCED_GOLD_TOOL, () -> Ingredient.of(ModItems.REINFORCED_GOLD_INGOT.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "reinforced_gold"), List.of(Tiers.GOLD), List.of());

    public static final Tier DIAMRON = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1811, 14.0F, 5.0F, 24,
                    ModTags.Blocks.NEEDS_DIAMRON_TOOL, () -> Ingredient.of(ModItems.DIAMRON_INGOT.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "diamron"), List.of(Tiers.DIAMOND), List.of());

    public static final Tier REINFORCED_DIAMOND = TierSortingRegistry.registerTier(
            new ForgeTier(6, 3122, 16.0F, 6.0F, 20,
                    ModTags.Blocks.NEEDS_REINFORCED_DIAMOND_TOOL, () -> Ingredient.of(ModItems.REINFORCED_DIAMOND.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "reinforced_diamond"), List.of(Tiers.DIAMOND), List.of());

    public static final Tier GOALDMOND = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1593, 20.0F, 3.0F, 32,
                    ModTags.Blocks.NEEDS_GOALDMOND_TOOL, () -> Ingredient.of(ModItems.GOALDMOND.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "goaldmond"), List.of(Tiers.DIAMOND), List.of());

    public static final Tier REINFORCED_NETHERITE = TierSortingRegistry.registerTier(
            new ForgeTier(8, 4062, 18.0F, 8.0F, 30,
                    ModTags.Blocks.NEEDS_REINFORCED_NETHERITE_TOOL, () -> Ingredient.of(ModItems.REINFORCED_NETHERITE_INGOT.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "reinforced_netherite"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier NETHORIDEN = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2063, 21.0F, 4.0F, 17,
                    ModTags.Blocks.NEEDS_NETHORIDEN_TOOL, () -> Ingredient.of(ModItems.NETHORIDEN_INGOT.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "nethoriden"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier HEAVY_IRON = TierSortingRegistry.registerTier(
            new ForgeTier(8, 1000, 24.0F, 8.0F, 56,
                    ModTags.Blocks.NEEDS_HEAVY_IRON_TOOL, () -> Ingredient.of(ModItems.HEAVY_IRON_INGOT.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "heavy_iron"), List.of(Tiers.DIAMOND), List.of());

    public static final Tier NETTHRION = TierSortingRegistry.registerTier(
            new ForgeTier(6, 2281, 15.0F, 6.0F, 29,
                    ModTags.Blocks.NEEDS_NETTHRION_TOOL, () -> Ingredient.of(ModItems.NETTHRION_INGOT.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "netthrion"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier HEAVY_GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(0, 128, 48.0F, 0.0F, 88,
                    ModTags.Blocks.NEEDS_HEAVY_GOLD_TOOL, () -> Ingredient.of(ModItems.HEAVY_GOLD_INGOT.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "heavy_gold"), List.of(Tiers.IRON), List.of());

    public static final Tier NETHERITOND = TierSortingRegistry.registerTier(
            new ForgeTier(7, 3592, 17.0F, 7.0F, 25,
                    ModTags.Blocks.NEEDS_NETHERITOND_TOOL, () -> Ingredient.of(ModItems.NETHERITOND_INGOT.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "netheritond"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier HEAVY_DIAMOND = TierSortingRegistry.registerTier(
            new ForgeTier(6, 6244, 32.0F, 12.0F, 40,
                    ModTags.Blocks.NEEDS_HEAVY_DIAMOND_TOOL, () -> Ingredient.of(ModItems.HEAVY_DIAMOND.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "heavy_diamond"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier HEAVY_NETHERITE = TierSortingRegistry.registerTier(
            new ForgeTier(16, 8124, 36.0F, 16.0F, 60,
                    ModTags.Blocks.NEEDS_HEAVY_NETHERITE_TOOL, () -> Ingredient.of(ModItems.HEAVY_NETHERITE_INGOT.get())),
            new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "heavy_netherite"), List.of(Tiers.NETHERITE), List.of());

}

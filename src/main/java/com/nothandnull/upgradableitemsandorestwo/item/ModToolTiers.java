package com.nothandnull.upgradableitemsandorestwo.item;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import com.nothandnull.upgradableitemsandorestwo.util.ModTags;
import com.sun.jna.platform.unix.Resource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier REINFORCED_IRON = TierSortingRegistry.registerTier(
            new ForgeTier(5, 500, 5f, 5f, 50,
                    ModTags.Blocks.NEEDS_REINFORCED_IRON_TOOL, () -> Ingredient.of(ModItems.REINFORCED_IRON_INGOT.get())),
                    new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, "reinforced_iron"), List.of(Tiers.IRON), List.of());
}

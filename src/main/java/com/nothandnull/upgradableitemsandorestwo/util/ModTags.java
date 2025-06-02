package com.nothandnull.upgradableitemsandorestwo.util;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_REINFORCED_IRON_TOOL = tag("needs_reinforced_iron_tool");
        public static final TagKey<Block> NEEDS_REINFORCED_GOLD_TOOL = tag("needs_reinforced_gold_tool");
        public static final TagKey<Block> NEEDS_REINFORCED_DIAMOND_TOOL = tag("needs_reinforced_diamond_tool");
        public static final TagKey<Block> NEEDS_REINFORCED_NETHERITE_TOOL = tag("needs_reinforced_netherite_tool");
        public static final TagKey<Block> NEEDS_HEAVY_IRON_TOOL = tag("needs_heavy_iron_tool");
        public static final TagKey<Block> NEEDS_HEAVY_GOLD_TOOL = tag("needs_heavy_gold_tool");
        public static final TagKey<Block> NEEDS_HEAVY_DIAMOND_TOOL = tag("needs_heavy_diamond_tool");
        public static final TagKey<Block> NEEDS_HEAVY_NETHERITE_TOOL = tag("needs_heavy_netherite_tool");


        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TEST_ITEM = tag("test_item");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(UpgradableItemsAndOresTwo.MOD_ID, name));
        }
    }
}
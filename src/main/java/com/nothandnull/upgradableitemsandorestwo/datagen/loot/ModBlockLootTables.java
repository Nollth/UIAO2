package com.nothandnull.upgradableitemsandorestwo.datagen.loot;

import com.nothandnull.upgradableitemsandorestwo.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.DIAMRON_BLOCK.get());
        this.dropSelf(ModBlocks.GOLREON_BLOCK.get());
        this.dropSelf(ModBlocks.GOALDMOND_BLOCK.get());
        this.dropSelf(ModBlocks.NETTHRION_BLOCK.get());
        this.dropSelf(ModBlocks.NETHERITOND_BLOCK.get());
        this.dropSelf(ModBlocks.NETHORIDEN_BLOCK.get());
        this.dropSelf(ModBlocks.REINFORCED_DIAMOND_BLOCK.get());
        this.dropSelf(ModBlocks.REINFORCED_IRON_BLOCK.get());
        this.dropSelf(ModBlocks.REINFORCED_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.REINFORCED_NETHERITE_BLOCK.get());
        this.dropSelf(ModBlocks.HEAVY_DIAMOND_BLOCK.get());
        this.dropSelf(ModBlocks.HEAVY_IRON_BLOCK.get());
        this.dropSelf(ModBlocks.HEAVY_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.HEAVY_NETHERITE_BLOCK.get());
        this.dropSelf(ModBlocks.MAGHEMITE.get());

        this.dropSelf(ModBlocks.UNSTABLE_OBSIDIAN.get());
    }

    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

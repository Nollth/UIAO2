package com.nothandnull.upgradableitemsandorestwo.block;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import com.nothandnull.upgradableitemsandorestwo.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UpgradableItemsAndOresTwo.MOD_ID);

    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));

    public static final RegistryObject<Block> TEST_BLOCK_TWO = registerBlock("test_block_two",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));

    public static final RegistryObject<Block> DIAMRON_BLOCK = registerBlock("diamron_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    public static final RegistryObject<Block> GOALDMOND_BLOCK = registerBlock("goaldmond_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));

    public static final RegistryObject<Block> GOLREON_BLOCK = registerBlock("golreon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));

    public static final RegistryObject<Block> HEAVY_DIAMOND_BLOCK = registerBlock("heavy_diamond_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    public static final RegistryObject<Block> HEAVY_GOLD_BLOCK = registerBlock("heavy_gold_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));

    public static final RegistryObject<Block> HEAVY_IRON_BLOCK = registerBlock("heavy_iron_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> HEAVY_NETHERITE_BLOCK = registerBlock("heavy_netherite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> KITTY_BLOCK = registerBlock("kitty_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRYING_OBSIDIAN)));

    public static final RegistryObject<Block> NETHERITOND_BLOCK = registerBlock("netheritond_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> NETHORIDEN_BLOCK = registerBlock("nethoriden_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> NETTHRION_BLOCK = registerBlock("netthrion_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> OXIDIZED_HEAVY_COPPER = registerBlock("oxidized_heavy_copper",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER)));

    public static final RegistryObject<Block> OXIDIZED_REINFORCED_COPPER = registerBlock("oxidized_reinforced_copper",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER)));

    public static final RegistryObject<Block> REINFORCED_DIAMOND_BLOCK = registerBlock("reinforced_diamond_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    public static final RegistryObject<Block> REINFORCED_GOLD_BLOCK = registerBlock("reinforced_gold_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));

    public static final RegistryObject<Block> REINFORCED_IRON_BLOCK = registerBlock("reinforced_iron_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> REINFORCED_NETHERITE_BLOCK = registerBlock("reinforced_netherite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
     BLOCKS.register(eventBus);
    }
}

package com.nothandnull.upgradableitemsandorestwo.block.entity;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import com.nothandnull.upgradableitemsandorestwo.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, UpgradableItemsAndOresTwo.MOD_ID);

    public static final RegistryObject<BlockEntityType<CountingTableBlockEntity>> COUNTING_TABLE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("counting_table_block_entity", () ->
                    BlockEntityType.Builder.of(CountingTableBlockEntity::new, ModBlocks.UNSTABLE_OBSIDIAN.get()).build(null));

    public static void register(IEventBus eventBus) {
           BLOCK_ENTITIES.register(eventBus);
        }
}

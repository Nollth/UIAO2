package com.nothandnull.upgradableitemsandorestwo.villager;

import com.google.common.collect.ImmutableSet;
import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import com.nothandnull.upgradableitemsandorestwo.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, UpgradableItemsAndOresTwo.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, UpgradableItemsAndOresTwo.MOD_ID);

    public static final RegistryObject<PoiType> COIN_POI = POI_TYPES.register("coin_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.UNSTABLE_OBSIDIAN.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> COIN_POLISHER =
        VILLAGER_PROFESSIONS.register("coinpolisher", () -> new VillagerProfession("coinpolisher",
                holder -> holder.get() == COIN_POI.get(), holder -> holder.get() == COIN_POI.get(),
                ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_CELEBRATE));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}

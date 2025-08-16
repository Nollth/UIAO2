package com.nothandnull.upgradableitemsandorestwo;

import com.mojang.logging.LogUtils;
import com.nothandnull.upgradableitemsandorestwo.block.ModBlocks;
import com.nothandnull.upgradableitemsandorestwo.item.ModCreativeModTabs;
import com.nothandnull.upgradableitemsandorestwo.item.ModItems;
import com.nothandnull.upgradableitemsandorestwo.datagen.ModPoiTypeTagsProvider;
import com.nothandnull.upgradableitemsandorestwo.villager.ModVillagers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod(UpgradableItemsAndOresTwo.MOD_ID)
public class UpgradableItemsAndOresTwo {
    public static final String MOD_ID = "upgradableitemsandorestwo";
    private static final Logger LOGGER = LogUtils.getLogger();

    public UpgradableItemsAndOresTwo() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        ModVillagers.register(modEventBus);

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = UpgradableItemsAndOresTwo.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ItemProperties.register(ModItems.WAY_BACK_COMPASS.get(),
                        new ResourceLocation("angle"),
                        (stack, level, entity, seed) -> {
                            if (entity == null) {
                                return 0.0F;
                            }
                            return stack.getOrCreateTag().getFloat("angle");
                        });
            });
        }
    }
}

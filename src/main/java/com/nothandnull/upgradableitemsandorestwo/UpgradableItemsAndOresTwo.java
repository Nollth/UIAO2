package com.nothandnull.upgradableitemsandorestwo;

import com.mojang.logging.LogUtils;
import com.nothandnull.upgradableitemsandorestwo.block.ModBlocks;
import com.nothandnull.upgradableitemsandorestwo.block.entity.ModBlockEntities;
import com.nothandnull.upgradableitemsandorestwo.event.WayBackCompassEvents;
import com.nothandnull.upgradableitemsandorestwo.item.ModCreativeModTabs;
import com.nothandnull.upgradableitemsandorestwo.item.ModItems;
import com.nothandnull.upgradableitemsandorestwo.item.WayBackCompass;
import com.nothandnull.upgradableitemsandorestwo.screen.CountingTableMenu;
import com.nothandnull.upgradableitemsandorestwo.screen.CountingTableScreen;
import com.nothandnull.upgradableitemsandorestwo.screen.ModMenuTypes;
import com.nothandnull.upgradableitemsandorestwo.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(UpgradableItemsAndOresTwo.MOD_ID)
public class UpgradableItemsAndOresTwo {
    public static final String MOD_ID = "upgradableitemsandorestwo";

    static {
        LogUtils.getLogger();
    }

    public UpgradableItemsAndOresTwo() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        ModVillagers.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new WayBackCompassEvents());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ItemProperties.register(ModItems.WAY_BACK_COMPASS.get(),
                        new ResourceLocation("angle"),
                        (stack, level, entity, seed) -> {
                            if (entity == null || stack == null) {
                                return 0.0F;
                            }
                            CompoundTag tag = stack.getOrCreateTag();
                            return tag.contains(WayBackCompass.TAG_ANGLE) ?
                                    tag.getFloat(WayBackCompass.TAG_ANGLE) : 0.0F;
                        });
            });
            MenuScreens.register(ModMenuTypes.COUNTING_TABLE_MENU.get(), CountingTableScreen::new);
        }
    }
}

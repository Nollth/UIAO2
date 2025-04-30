package com.nothandnull.upgradableitemsandorestwo.event;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import com.nothandnull.upgradableitemsandorestwo.item.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = UpgradableItemsAndOresTwo.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.ARMORER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.IRON_COIN.get(), 9),
                    new ItemStack(ModItems.REINFORCED_IRON_INGOT.get(), 1),
                    9, 10, 0.05F));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.GOLD_COIN.get(), 9),
                    new ItemStack(ModItems.REINFORCED_GOLD_INGOT.get(), 1),
                    9, 10, 0.05F));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                    new ItemStack(ModItems.REINFORCED_DIAMOND.get(), 1),
                    9, 10, 0.05F));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                    new ItemStack(ModItems.REINFORCED_NETHERITE_INGOT.get(), 1),
                    9, 10, 0.05F));
            
        }
    }
}

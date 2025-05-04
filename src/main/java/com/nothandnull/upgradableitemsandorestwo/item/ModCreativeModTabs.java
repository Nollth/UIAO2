package com.nothandnull.upgradableitemsandorestwo.item;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import com.nothandnull.upgradableitemsandorestwo.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UpgradableItemsAndOresTwo.MOD_ID);

   public static final RegistryObject<CreativeModeTab> UIAOTWO_BLOCKS =
           CREATIVE_MODE_TABS.register("uiaotwo_blocks", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.KITTY_BLOCK.get()))
                   .title(Component.translatable("creativetab.uiaotwo_blocks"))
                   .displayItems((itemDisplayParameters, output) -> {
                       output.accept(ModBlocks.TEST_BLOCK.get());
                       output.accept(ModBlocks.TEST_BLOCK_TWO.get());
                       output.accept(ModBlocks.KITTY_BLOCK.get());
                       output.accept(ModBlocks.HEAVY_DIAMOND_BLOCK.get());
                       output.accept(ModBlocks.REINFORCED_DIAMOND_BLOCK.get());
                       output.accept(ModBlocks.OXIDIZED_HEAVY_COPPER.get());
                       output.accept(ModBlocks.OXIDIZED_REINFORCED_COPPER.get());
                       output.accept(ModBlocks.HEAVY_GOLD_BLOCK.get());
                       output.accept(ModBlocks.REINFORCED_GOLD_BLOCK.get());
                       output.accept(ModBlocks.HEAVY_NETHERITE_BLOCK.get());
                       output.accept(ModBlocks.REINFORCED_NETHERITE_BLOCK.get());
                       output.accept(ModBlocks.HEAVY_IRON_BLOCK.get());
                       output.accept(ModBlocks.REINFORCED_IRON_BLOCK.get());
                       output.accept(ModBlocks.NETHERITOND_BLOCK.get());
                       output.accept(ModBlocks.NETHORIDEN_BLOCK.get());
                       output.accept(ModBlocks.NETTHRION_BLOCK.get());
                       output.accept(ModBlocks.GOALDMOND_BLOCK.get());
                       output.accept(ModBlocks.DIAMRON_BLOCK.get());
                       output.accept(ModBlocks.GOLREON_BLOCK.get());
                   })
                   .build());

    public static final RegistryObject<CreativeModeTab> UIAOTWO_TOOLS =
            CREATIVE_MODE_TABS.register("uiaotwo_tools", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KITTY_MASTER.get()))
                    .title(Component.translatable("creativetab.uiaotwo_tools"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.KITTY_AXE.get());
                        output.accept(ModItems.KITTY_PICKAXE.get());
                        output.accept(ModItems.KITTY_SHOVEL.get());
                        output.accept(ModItems.KITTY_SWORD.get());
                        output.accept(ModItems.KITTY_HOE.get());
                        output.accept(ModItems.KITTY_MASTER.get());
                        output.accept(ModItems.HEAVY_DIAMOND_AXE.get());
                        output.accept(ModItems.HEAVY_DIAMOND_PICKAXE.get());
                        output.accept(ModItems.HEAVY_DIAMOND_SHOVEL.get());
                        output.accept(ModItems.HEAVY_DIAMOND_SWORD.get());
                        output.accept(ModItems.HEAVY_DIAMOND_HOE.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_AXE.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_PICKAXE.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_SHOVEL.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_SWORD.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_HOE.get());
                        output.accept(ModItems.HEAVY_IRON_AXE.get());
                        output.accept(ModItems.HEAVY_IRON_PICKAXE.get());
                        output.accept(ModItems.HEAVY_IRON_SHOVEL.get());
                        output.accept(ModItems.HEAVY_IRON_SWORD.get());
                        output.accept(ModItems.HEAVY_IRON_HOE.get());
                        output.accept(ModItems.REINFORCED_IRON_AXE.get());
                        output.accept(ModItems.REINFORCED_IRON_PICKAXE.get());
                        output.accept(ModItems.REINFORCED_IRON_SHOVEL.get());
                        output.accept(ModItems.REINFORCED_IRON_SWORD.get());
                        output.accept(ModItems.REINFORCED_IRON_HOE.get());
                        output.accept(ModItems.HEAVY_GOLDEN_AXE.get());
                        output.accept(ModItems.HEAVY_GOLDEN_PICKAXE.get());
                        output.accept(ModItems.HEAVY_GOLDEN_SHOVEL.get());
                        output.accept(ModItems.HEAVY_GOLDEN_SWORD.get());
                        output.accept(ModItems.HEAVY_GOLDEN_HOE.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_AXE.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_PICKAXE.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_SHOVEL.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_SWORD.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_HOE.get());
                        output.accept(ModItems.HEAVY_NETHERITE_AXE.get());
                        output.accept(ModItems.HEAVY_NETHERITE_PICKAXE.get());
                        output.accept(ModItems.HEAVY_NETHERITE_SHOVEL.get());
                        output.accept(ModItems.HEAVY_NETHERITE_SWORD.get());
                        output.accept(ModItems.HEAVY_NETHERITE_HOE.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_AXE.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_PICKAXE.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_SHOVEL.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_SWORD.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_HOE.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_AXE.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_PICKAXE.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_SHOVEL.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_SWORD.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_HOE.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_AXE.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_PICKAXE.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_SHOVEL.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_SWORD.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_HOE.get());
                        output.accept(ModItems.OXIDIZED_COPPER_AXE.get());
                        output.accept(ModItems.OXIDIZED_COPPER_PICKAXE.get());
                        output.accept(ModItems.OXIDIZED_COPPER_SHOVEL.get());
                        output.accept(ModItems.OXIDIZED_COPPER_SWORD.get());
                        output.accept(ModItems.OXIDIZED_COPPER_HOE.get());
                        output.accept(ModItems.NETHORIDEN_AXE.get());
                        output.accept(ModItems.NETHORIDEN_PICKAXE.get());
                        output.accept(ModItems.NETHORIDEN_SHOVEL.get());
                        output.accept(ModItems.NETHORIDEN_SWORD.get());
                        output.accept(ModItems.NETHORIDEN_HOE.get());
                        output.accept(ModItems.NETTHRION_AXE.get());
                        output.accept(ModItems.NETTHRION_PICKAXE.get());
                        output.accept(ModItems.NETTHRION_SHOVEL.get());
                        output.accept(ModItems.NETTHRION_SWORD.get());
                        output.accept(ModItems.NETTHRION_HOE.get());
                        output.accept(ModItems.NETHERITOND_AXE.get());
                        output.accept(ModItems.NETHERITOND_PICKAXE.get());
                        output.accept(ModItems.NETHERITOND_SHOVEL.get());
                        output.accept(ModItems.NETHERITOND_SWORD.get());
                        output.accept(ModItems.NETHERITOND_HOE.get());
                        output.accept(ModItems.GOALDMOND_AXE.get());
                        output.accept(ModItems.GOALDMOND_PICKAXE.get());
                        output.accept(ModItems.GOALDMOND_SHOVEL.get());
                        output.accept(ModItems.GOALDMOND_SWORD.get());
                        output.accept(ModItems.GOALDMOND_HOE.get());
                        output.accept(ModItems.GOLREON_AXE.get());
                        output.accept(ModItems.GOLREON_PICKAXE.get());
                        output.accept(ModItems.GOLREON_SHOVEL.get());
                        output.accept(ModItems.GOLREON_SWORD.get());
                        output.accept(ModItems.GOLREON_HOE.get());
                        output.accept(ModItems.DIAMRON_AXE.get());
                        output.accept(ModItems.DIAMRON_PICKAXE.get());
                        output.accept(ModItems.DIAMRON_SHOVEL.get());
                        output.accept(ModItems.DIAMRON_SWORD.get());
                        output.accept(ModItems.DIAMRON_HOE.get());
                        output.accept(ModItems.SWEET_AXE.get());
                        output.accept(ModItems.SWEET_PICKAXE.get());
                        output.accept(ModItems.SWEET_SHOVEL.get());
                        output.accept(ModItems.SWEET_SWORD.get());
                        output.accept(ModItems.SWEET_HOE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> UIAOTWO_FOODS =
            CREATIVE_MODE_TABS.register("uiaotwo_foods", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FLESH.get()))
                    .title(Component.translatable("creativetab.uiaotwo_foods"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TEST_FOOD.get());
                        output.accept(ModItems.FLUFFY_CANDY.get());
                        output.accept(ModItems.CHUBBY_FLUFFY_MIX.get());
                        output.accept(ModItems.WARM_MILK_BUCKET.get());
                        output.accept(ModItems.FLESH.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_APPLE.get());
                        output.accept(ModItems.HEAVY_GOLDEN_APPLE.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_CARROT.get());
                        output.accept(ModItems.HEAVY_GOLDEN_CARROT.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> UIAOTWO_FUELS =
            CREATIVE_MODE_TABS.register("uiaotwo_fuels", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DEATH_STAR.get()))
                    .title(Component.translatable("creativetab.uiaotwo_fuels"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TEST_FUEL.get());
                        output.accept(ModItems.BURNING_SOULS.get());
                        output.accept(ModItems.TORMENTED_SOULS.get());
                        output.accept(ModItems.WHISPER_DESPAIR.get());
                        output.accept(ModItems.SOUL_FLAMES.get());
                        output.accept(ModItems.BURNING_HOPE.get());
                        output.accept(ModItems.CHAINED_SOULS.get());
                        output.accept(ModItems.MAGMA_BUCKET.get());
                        output.accept(ModItems.DEATH_STAR.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> UIAOTWO_COINS =
            CREATIVE_MODE_TABS.register("uiaotwo_coins", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.IRON_COIN.get()))
                    .title(Component.translatable("creativetab.uiaotwo_coins"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.IRON_COIN.get());
                        output.accept(ModItems.GOLD_COIN.get());
                        output.accept(ModItems.DIAMOND_COIN.get());
                        output.accept(ModItems.NETHERITE_COIN.get());
                        output.accept(ModItems.REINFORCED_IRON_COIN.get());
                        output.accept(ModItems.REINFORCED_GOLD_COIN.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_COIN.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_COIN.get());
                    })
                    .build());


    public static final RegistryObject<CreativeModeTab> UIAOTWO_ARMORS =
            CREATIVE_MODE_TABS.register("uiaotwo_armors", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KITTY_BOOTS.get()))
                    .title(Component.translatable("creativetab.uiaotwo_armors"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.KITTY_BOOTS.get());
                        output.accept(ModItems.KITTY_LEGGINGS.get());
                        output.accept(ModItems.KITTY_CHESTPLATE.get());
                        output.accept(ModItems.KITTY_HELMET.get());
                        output.accept(ModItems.SWEET_BOOTS.get());
                        output.accept(ModItems.SWEET_LEGGINGS.get());
                        output.accept(ModItems.SWEET_CHESTPLATE.get());
                        output.accept(ModItems.SWEET_HELMET.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_BOOTS.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_LEGGINGS.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_CHESTPLATE.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_HELMET.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_HORSE_ARMOR.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_BOOTS.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_LEGGINGS.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_CHESTPLATE.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_HELMET.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_HORSE_ARMOR.get());
                        output.accept(ModItems.OXIDIZED_COPPER_BOOTS.get());
                        output.accept(ModItems.OXIDIZED_COPPER_LEGGINGS.get());
                        output.accept(ModItems.OXIDIZED_COPPER_CHESTPLATE.get());
                        output.accept(ModItems.OXIDIZED_COPPER_HELMET.get());
                        output.accept(ModItems.OXIDIZED_COPPER_HORSE_ARMOR.get());
                        output.accept(ModItems.HEAVY_DIAMOND_BOOTS.get());
                        output.accept(ModItems.HEAVY_DIAMOND_LEGGINGS.get());
                        output.accept(ModItems.HEAVY_DIAMOND_CHESTPLATE.get());
                        output.accept(ModItems.HEAVY_DIAMOND_HELMET.get());
                        output.accept(ModItems.HEAVY_DIAMOND_HORSE_ARMOR.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_BOOTS.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_LEGGINGS.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_CHESTPLATE.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_HELMET.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_HORSE_ARMOR.get());
                        output.accept(ModItems.HEAVY_GOLDEN_BOOTS.get());
                        output.accept(ModItems.HEAVY_GOLDEN_LEGGINGS.get());
                        output.accept(ModItems.HEAVY_GOLDEN_CHESTPLATE.get());
                        output.accept(ModItems.HEAVY_GOLDEN_HELMET.get());
                        output.accept(ModItems.HEAVY_GOLDEN_HORSE_ARMOR.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_BOOTS.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_LEGGINGS.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_CHESTPLATE.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_HELMET.get());
                        output.accept(ModItems.REINFORCED_GOLDEN_HORSE_ARMOR.get());
                        output.accept(ModItems.HEAVY_IRON_BOOTS.get());
                        output.accept(ModItems.HEAVY_IRON_LEGGINGS.get());
                        output.accept(ModItems.HEAVY_IRON_CHESTPLATE.get());
                        output.accept(ModItems.HEAVY_IRON_HELMET.get());
                        output.accept(ModItems.HEAVY_IRON_HORSE_ARMOR.get());
                        output.accept(ModItems.REINFORCED_IRON_BOOTS.get());
                        output.accept(ModItems.REINFORCED_IRON_LEGGINGS.get());
                        output.accept(ModItems.REINFORCED_IRON_CHESTPLATE.get());
                        output.accept(ModItems.REINFORCED_IRON_HELMET.get());
                        output.accept(ModItems.REINFORCED_IRON_HORSE_ARMOR.get());
                        output.accept(ModItems.HEAVY_NETHERITE_BOOTS.get());
                        output.accept(ModItems.HEAVY_NETHERITE_LEGGINGS.get());
                        output.accept(ModItems.HEAVY_NETHERITE_CHESTPLATE.get());
                        output.accept(ModItems.HEAVY_NETHERITE_HELMET.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_BOOTS.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_LEGGINGS.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_CHESTPLATE.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_HELMET.get());
                        output.accept(ModItems.DIAMRON_BOOTS.get());
                        output.accept(ModItems.DIAMRON_LEGGINGS.get());
                        output.accept(ModItems.DIAMRON_CHESTPLATE.get());
                        output.accept(ModItems.DIAMRON_HELMET.get());
                        output.accept(ModItems.DIAMRON_HORSE_ARMOR.get());
                        output.accept(ModItems.GOLREON_BOOTS.get());
                        output.accept(ModItems.GOLREON_LEGGINGS.get());
                        output.accept(ModItems.GOLREON_CHESTPLATE.get());
                        output.accept(ModItems.GOLREON_HELMET.get());
                        output.accept(ModItems.GOLREON_HORSE_ARMOR.get());
                        output.accept(ModItems.GOALDMOND_BOOTS.get());
                        output.accept(ModItems.GOALDMOND_LEGGINGS.get());
                        output.accept(ModItems.GOALDMOND_CHESTPLATE.get());
                        output.accept(ModItems.GOALDMOND_HELMET.get());
                        output.accept(ModItems.GOALDMOND_HORSE_ARMOR.get());
                        output.accept(ModItems.NETHORIDEN_BOOTS.get());
                        output.accept(ModItems.NETHORIDEN_LEGGINGS.get());
                        output.accept(ModItems.NETHORIDEN_CHESTPLATE.get());
                        output.accept(ModItems.NETHORIDEN_HELMET.get());
                        output.accept(ModItems.NETHERITOND_BOOTS.get());
                        output.accept(ModItems.NETHERITOND_LEGGINGS.get());
                        output.accept(ModItems.NETHERITOND_CHESTPLATE.get());
                        output.accept(ModItems.NETHERITOND_HELMET.get());
                        output.accept(ModItems.NETTHRION_BOOTS.get());
                        output.accept(ModItems.NETTHRION_LEGGINGS.get());
                        output.accept(ModItems.NETTHRION_CHESTPLATE.get());
                        output.accept(ModItems.NETTHRION_HELMET.get());
                        output.accept(ModItems.LOETHEN_BOOTS.get());
                        output.accept(ModItems.LOETHEN_LEGGINGS.get());
                        output.accept(ModItems.LOETHEN_CHESTPLATE.get());
                        output.accept(ModItems.LOETHEN_HELMET.get());
                        output.accept(ModItems.LOETHEN_HORSE_ARMOR.get());
                        output.accept(ModItems.LIATHROND_BOOTS.get());
                        output.accept(ModItems.LIATHROND_LEGGINGS.get());
                        output.accept(ModItems.LIATHROND_CHESTPLATE.get());
                        output.accept(ModItems.LIATHROND_HELMET.get());
                        output.accept(ModItems.LIATHROND_HORSE_ARMOR.get());
                        output.accept(ModItems.LEATHERITE_BOOTS.get());
                        output.accept(ModItems.LEATHERITE_LEGGINGS.get());
                        output.accept(ModItems.LEATHERITE_CHESTPLATE.get());
                        output.accept(ModItems.LEATHERITE_HELMET.get());
                        output.accept(ModItems.LITHERON_BOOTS.get());
                        output.accept(ModItems.LITHERON_LEGGINGS.get());
                        output.accept(ModItems.LITHERON_CHESTPLATE.get());
                        output.accept(ModItems.LITHERON_HELMET.get());
                        output.accept(ModItems.LITHERON_HORSE_ARMOR.get());
                        output.accept(ModItems.CHINMRON_BOOTS.get());
                        output.accept(ModItems.CHINMRON_LEGGINGS.get());
                        output.accept(ModItems.CHINMRON_CHESTPLATE.get());
                        output.accept(ModItems.CHINMRON_HELMET.get());
                        output.accept(ModItems.CHAINMOND_BOOTS.get());
                        output.accept(ModItems.CHAINMOND_LEGGINGS.get());
                        output.accept(ModItems.CHAINMOND_CHESTPLATE.get());
                        output.accept(ModItems.CHAINMOND_HELMET.get());
                        output.accept(ModItems.CHAINETHARILE_BOOTS.get());
                        output.accept(ModItems.CHAINETHARILE_LEGGINGS.get());
                        output.accept(ModItems.CHAINETHARILE_CHESTPLATE.get());
                        output.accept(ModItems.CHAINETHARILE_HELMET.get());
                        output.accept(ModItems.CHAINMOLDEN_BOOTS.get());
                        output.accept(ModItems.CHAINMOLDEN_LEGGINGS.get());
                        output.accept(ModItems.CHAINMOLDEN_CHESTPLATE.get());
                        output.accept(ModItems.CHAINMOLDEN_HELMET.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> UIAOTWO_ITEMS =
            CREATIVE_MODE_TABS.register("uiaotwo_items", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KITTYS_MYSTIC_BOTTLE.get()))
                    .title(Component.translatable("creativetab.uiaotwo_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TEST_ITEM.get());
                        output.accept(ModItems.TEST_ITEM_TWO.get());
                        output.accept(ModItems.WARM_WATER_BUCKET.get());
                        output.accept(ModItems.COLD_WATER_BUCKET.get());
                        output.accept(ModItems.COLD_WET_SWEET_SLIMY.get());
                        output.accept(ModItems.GRISTLES.get());
                        output.accept(ModItems.LOVED_DUST.get());
                        output.accept(ModItems.SWEET_SLIMY.get());
                        output.accept(ModItems.MASHED_GRISTLES.get());
                        output.accept(ModItems.WEIRD_LOVED_MIX.get());
                        output.accept(ModItems.WARM_FLUFFY_MIX.get());
                        output.accept(ModItems.LOVED_MIX.get());
                        output.accept(ModItems.COMPRESSED_LOVED_MIX.get());
                        output.accept(ModItems.SWEET_WATER_BUCKET.get());
                        output.accept(ModItems.WARM_WATER_BUCKET.get());
                        output.accept(ModItems.COLD_WET_SWEET_SLIMY.get());
                        output.accept(ModItems.FLUFFY_MIX.get());
                        output.accept(ModItems.CREASED_LEATHER.get());
                        output.accept(ModItems.KITTYS_MYSTIC_BOTTLE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> UIAOTWO_ORES =
            CREATIVE_MODE_TABS.register("uiaotwo_ores", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GOALDMOND.get()))
                    .title(Component.translatable("creativetab.uiaotwo_ores"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.NETHORIDEN_INGOT.get());
                        output.accept(ModItems.NETTHRION_INGOT.get());
                        output.accept(ModItems.NETHERITOND_INGOT.get());
                        output.accept(ModItems.LOETHEN.get());
                        output.accept(ModItems.LIATHROND.get());
                        output.accept(ModItems.LITHERON.get());
                        output.accept(ModItems.LEATHERITE.get());
                        output.accept(ModItems.CHAINMOLDEN.get());
                        output.accept(ModItems.CHINMRON.get());
                        output.accept(ModItems.CHAINETHARILE.get());
                        output.accept(ModItems.CHAINMOND.get());
                        output.accept(ModItems.COPPER_NUGGET.get());
                        output.accept(ModItems.KITTY_INGOT.get());
                        output.accept(ModItems.DIAMRON_INGOT.get());
                        output.accept(ModItems.GOLREON_INGOT.get());
                        output.accept(ModItems.GOALDMOND.get());
                        output.accept(ModItems.DIAMOND_DROP.get());
                        output.accept(ModItems.NETHERITE_SPALL.get());
                        output.accept(ModItems.OXIDIZED_COPPER_INGOT.get());
                        output.accept(ModItems.OXIDIZED_COPPER_NUGGET.get());
                        output.accept(ModItems.REINFORCED_DIAMOND.get());
                        output.accept(ModItems.REINFORCED_DIAMOND_DROP.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_INGOT.get());
                        output.accept(ModItems.REINFORCED_NETHERITE_SPALL.get());
                        output.accept(ModItems.REINFORCED_IRON_INGOT.get());
                        output.accept(ModItems.REINFORCED_IRON_NUGGET.get());
                        output.accept(ModItems.REINFORCED_GOLD_INGOT.get());
                        output.accept(ModItems.REINFORCED_GOLD_NUGGET.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_INGOT.get());
                        output.accept(ModItems.OXIDIZED_REINFORCED_COPPER_NUGGET.get());
                        output.accept(ModItems.HEAVY_DIAMOND.get());
                        output.accept(ModItems.HEAVY_DIAMOND_DROP.get());
                        output.accept(ModItems.HEAVY_NETHERITE_INGOT.get());
                        output.accept(ModItems.HEAVY_NETHERITE_SPALL.get());
                        output.accept(ModItems.HEAVY_IRON_INGOT.get());
                        output.accept(ModItems.HEAVY_IRON_NUGGET.get());
                        output.accept(ModItems.HEAVY_GOLD_INGOT.get());
                        output.accept(ModItems.HEAVY_GOLD_NUGGET.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_INGOT.get());
                        output.accept(ModItems.OXIDIZED_HEAVY_COPPER_NUGGET.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

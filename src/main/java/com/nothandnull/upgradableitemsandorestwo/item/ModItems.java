package com.nothandnull.upgradableitemsandorestwo.item;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import com.nothandnull.upgradableitemsandorestwo.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UpgradableItemsAndOresTwo.MOD_ID);

    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TEST_ITEM_TWO = ITEMS.register("test_item_two",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TEST_FOOD = ITEMS.register("test_food",
            () -> new Item(new Item.Properties().food(ModFoods.TEST_FOOD)));

    public static final RegistryObject<Item> TEST_FUEL = ITEMS.register("test_fuel",
            () -> new FuelItem(new Item.Properties(),1024000));

    public static final RegistryObject<Item> IRON_COIN = ITEMS.register("iron_coin",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_COIN = ITEMS.register("diamond_coin",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_COIN = ITEMS.register("netherite_coin",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BURNING_HOPE = ITEMS.register("burning_hope",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BURNING_SOULS = ITEMS.register("burning_souls",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINED_SOULS = ITEMS.register("chained_souls",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINETHARILE = ITEMS.register("chainetharile",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINETHARILE_BOOTS = ITEMS.register("chainetharile_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINETHARILE_CHESTPLATE = ITEMS.register("chainetharile_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINETHARILE_HELMET = ITEMS.register("chainetharile_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINETHARILE_LEGGINGS = ITEMS.register("chainetharile_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINMOLDEN = ITEMS.register("chainmolden",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINMOLDEN_BOOTS = ITEMS.register("chainmolden_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINMOLDEN_CHESTPLATE = ITEMS.register("chainmolden_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINMOLDEN_HELMET = ITEMS.register("chainmolden_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINMOLDEN_LEGGINGS = ITEMS.register("chainmolden_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINMOND = ITEMS.register("chainmond",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINMOND_BOOTS = ITEMS.register("chainmond_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINMOND_CHESTPLATE = ITEMS.register("chainmond_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINMOND_HELMET = ITEMS.register("chainmond_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINMOND_LEGGINGS = ITEMS.register("chainmond_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHINMRON = ITEMS.register("chinmron",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHINMRON_BOOTS = ITEMS.register("chinmron_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHINMRON_CHESTPLATE = ITEMS.register("chinmron_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHINMRON_HELMET = ITEMS.register("chinmron_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHINMRON_LEGGINGS = ITEMS.register("chinmron_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHUBBY_FLUFFY_MIX = ITEMS.register("chubby_fluffy_mix",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COLD_WATER_BUCKET = ITEMS.register("cold_water_bucket",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COLD_WET_SWEET_SLIMY = ITEMS.register("cold_wet_sweet_slimy",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COMPRESSED_LOVED_MIX = ITEMS.register("compressed_loved_mix",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CREASED_LEATHER = ITEMS.register("creased_leather",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DEATH_STAR = ITEMS.register("death_star",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_DROP = ITEMS.register("diamond_drop",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMRON_AXE = ITEMS.register("diamron_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMRON_BOOTS = ITEMS.register("diamron_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMRON_CHESTPLATE = ITEMS.register("diamron_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMRON_HELMET = ITEMS.register("diamron_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMRON_HOE = ITEMS.register("diamron_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMRON_HORSE_ARMOR = ITEMS.register("diamron_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMRON_INGOT = ITEMS.register("diamron_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMRON_LEGGINGS = ITEMS.register("diamron_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMRON_PICKAXE = ITEMS.register("diamron_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMRON_SHOVEL = ITEMS.register("diamron_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMRON_SWORD = ITEMS.register("diamron_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLESH = ITEMS.register("flesh",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLUFFY_CANDY = ITEMS.register("fluffy_candy",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLUFFY_MIX = ITEMS.register("fluffy_mix",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOALDMOND = ITEMS.register("goaldmond",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOALDMOND_AXE = ITEMS.register("goaldmond_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOALDMOND_BOOTS = ITEMS.register("goaldmond_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOALDMOND_CHESTPLATE = ITEMS.register("goaldmond_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOALDMOND_HELMET = ITEMS.register("goaldmond_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOALDMOND_HOE = ITEMS.register("goaldmond_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOALDMOND_HORSE_ARMOR = ITEMS.register("goaldmond_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOALDMOND_LEGGINGS = ITEMS.register("goaldmond_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOALDMOND_PICKAXE = ITEMS.register("goaldmond_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOALDMOND_SHOVEL = ITEMS.register("goaldmond_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOALDMOND_SWORD = ITEMS.register("goaldmond_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLREON_BOOTS = ITEMS.register("golreon_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLREON_CHESTPLATE = ITEMS.register("golreon_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLREON_HELMET = ITEMS.register("golreon_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLREON_HOE = ITEMS.register("golreon_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLREON_HORSE_ARMOR = ITEMS.register("golreon_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLREON_INGOT = ITEMS.register("golreon_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLREON_LEGGINGS = ITEMS.register("golreon_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLREON_PICKAXE = ITEMS.register("golreon_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLREON_SHOVEL = ITEMS.register("golreon_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLREON_SWORD = ITEMS.register("golreon_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLREON_AXE = ITEMS.register("golreon_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GRISTLES = ITEMS.register("gristles",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND = ITEMS.register("heavy_diamond",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND_AXE = ITEMS.register("heavy_diamond_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND_BOOTS = ITEMS.register("heavy_diamond_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND_CHESTPLATE = ITEMS.register("heavy_diamond_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND_DROP = ITEMS.register("heavy_diamond_drop",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND_HELMET = ITEMS.register("heavy_diamond_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND_HOE = ITEMS.register("heavy_diamond_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND_HORSE_ARMOR = ITEMS.register("heavy_diamond_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND_LEGGINGS = ITEMS.register("heavy_diamond_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND_PICKAXE = ITEMS.register("heavy_diamond_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND_SHOVEL = ITEMS.register("heavy_diamond_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_DIAMOND_SWORD = ITEMS.register("heavy_diamond_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLD_INGOT = ITEMS.register("heavy_gold_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLD_NUGGET = ITEMS.register("heavy_gold_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_APPLE = ITEMS.register("heavy_golden_apple",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_AXE = ITEMS.register("heavy_golden_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_BOOTS = ITEMS.register("heavy_golden_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_CARROT = ITEMS.register("heavy_golden_carrot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_CHESTPLATE = ITEMS.register("heavy_golden_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_HELMET = ITEMS.register("heavy_golden_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_HOE =  ITEMS.register("heavy_golden_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_HORSE_ARMOR =  ITEMS.register("heavy_golden_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_LEGGINGS =  ITEMS.register("heavy_golden_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_PICKAXE =  ITEMS.register("heavy_golden_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_SHOVEL =  ITEMS.register("heavy_golden_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_GOLDEN_SWORD =  ITEMS.register("heavy_golden_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_AXE =  ITEMS.register("heavy_iron_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_BOOTS =  ITEMS.register("heavy_iron_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_CHESTPLATE =  ITEMS.register("heavy_iron_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_HELMET =  ITEMS.register("heavy_iron_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_HOE =  ITEMS.register("heavy_iron_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_HORSE_ARMOR =  ITEMS.register("heavy_iron_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_INGOT =  ITEMS.register("heavy_iron_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_LEGGINGS =  ITEMS.register("heavy_iron_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_NUGGET =  ITEMS.register("heavy_iron_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_PICKAXE =  ITEMS.register("heavy_iron_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_SHOVEL =  ITEMS.register("heavy_iron_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_IRON_SWORD =  ITEMS.register("heavy_iron_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_NETHERITE_AXE =  ITEMS.register("heavy_netherite_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_NETHERITE_BOOTS =  ITEMS.register("heavy_netherite_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_NETHERITE_CHESTPLATE =  ITEMS.register("heavy_netherite_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_NETHERITE_HELMET =  ITEMS.register("heavy_netherite_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_NETHERITE_HOE =  ITEMS.register("heavy_netherite_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_NETHERITE_INGOT =  ITEMS.register("heavy_netherite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_NETHERITE_LEGGINGS =  ITEMS.register("heavy_netherite_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_NETHERITE_PICKAXE =  ITEMS.register("heavy_netherite_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_NETHERITE_SHOVEL =  ITEMS.register("heavy_netherite_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_NETHERITE_SPALL =  ITEMS.register("heavy_netherite_spall",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_NETHERITE_SWORD =  ITEMS.register("heavy_netherite_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTY_AXE =  ITEMS.register("kitty_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTY_BOOTS =  ITEMS.register("kitty_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTY_CHESTPLATE =  ITEMS.register("kitty_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTY_HELMET =  ITEMS.register("kitty_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTY_HOE =  ITEMS.register("kitty_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTY_INGOT =  ITEMS.register("kitty_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTY_LEGGINGS =  ITEMS.register("kitty_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTY_MASTER =  ITEMS.register("kitty_master",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTY_PICKAXE =  ITEMS.register("kitty_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTY_SHOVEL =  ITEMS.register("kitty_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTY_SWORD =  ITEMS.register("kitty_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITTYS_MYSTIC_BOTTLE =  ITEMS.register("kittys_mystic_bottle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEATHERITE =  ITEMS.register("leatherite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEATHERITE_BOOTS =  ITEMS.register("leatherite_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEATHERITE_CHESTPLATE =  ITEMS.register("leatherite_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEATHERITE_HELMET =  ITEMS.register("leatherite_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEATHERITE_HORSE_ARMOR =  ITEMS.register("leatherite_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEATHERITE_LEGGINGS =  ITEMS.register("leatherite_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIATHROND =  ITEMS.register("liathrond",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIATHROND_BOOTS =  ITEMS.register("liathrond_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIATHROND_CHESTPLATE =  ITEMS.register("liathrond_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIATHROND_HELMET =  ITEMS.register("liathrond_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIATHROND_HORSE_ARMOR =  ITEMS.register("liathrond_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIATHROND_LEGGINGS =  ITEMS.register("liathrond_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LITHERON =  ITEMS.register("litheron",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LITHERON_BOOTS =  ITEMS.register("litheron_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LITHERON_CHESTPLATE =  ITEMS.register("litheron_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LITHERON_HELMET =  ITEMS.register("litheron_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LITHERON_HORSE_ARMOR =  ITEMS.register("litheron_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LITHERON_LEGGINGS =  ITEMS.register("litheron_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LOETHEN =  ITEMS.register("loethen",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LOETHEN_BOOTS =  ITEMS.register("loethen_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LOETHEN_CHESTPLATE =  ITEMS.register("loethen_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LOETHEN_HELMET =  ITEMS.register("loethen_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LOETHEN_HORSE_ARMOR =  ITEMS.register("loethen_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LOETHEN_LEGGINGS =  ITEMS.register("loethen_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LOVED_DUST =  ITEMS.register("loved_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LOVED_MIX =  ITEMS.register("loved_mix",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGMA_BUCKET =  ITEMS.register("magma_bucket",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MASHED_GRISTLES =  ITEMS.register("mashed_gristles",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_SPALL =  ITEMS.register("netherite_spall",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHORIDEN_AXE =  ITEMS.register("nethoriden_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHORIDEN_BOOTS =  ITEMS.register("nethoriden_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHORIDEN_CHESTPLATE =  ITEMS.register("nethoriden_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHORIDEN_HELMET =  ITEMS.register("nethoriden_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHORIDEN_HOE =  ITEMS.register("nethoriden_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHORIDEN_INGOT =  ITEMS.register("nethoriden_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHORIDEN_LEGGINGS =  ITEMS.register("nethoriden_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHORIDEN_PICKAXE =  ITEMS.register("nethoriden_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHORIDEN_SHOVEL =  ITEMS.register("nethoriden_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHORIDEN_SWORD =  ITEMS.register("nethoriden_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITOND_AXE =  ITEMS.register("netheritond_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITOND_BOOTS =  ITEMS.register("netheritond_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITOND_CHESTPLATE =  ITEMS.register("netheritond_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITOND_HELMET =  ITEMS.register("netheritond_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITOND_HOE =  ITEMS.register("netheritond_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITOND_INGOT =  ITEMS.register("netheritond_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITOND_LEGGINGS =  ITEMS.register("netheritond_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITOND_PICKAXE =  ITEMS.register("netheritond_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITOND_SHOVEL =  ITEMS.register("netheritond_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITOND_SWORD =  ITEMS.register("netheritond_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETTHRION_AXE =  ITEMS.register("netthrion_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETTHRION_BOOTS =  ITEMS.register("netthrion_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETTHRION_CHESTPLATE =  ITEMS.register("netthrion_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETTHRION_HELMET =  ITEMS.register("netthrion_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETTHRION_HOE =  ITEMS.register("netthrion_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETTHRION_INGOT =  ITEMS.register("netthrion_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETTHRION_LEGGINGS =  ITEMS.register("netthrion_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETTHRION_PICKAXE =  ITEMS.register("netthrion_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETTHRION_SHOVEL =  ITEMS.register("netthrion_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETTHRION_SWORD =  ITEMS.register("netthrion_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_AXE =  ITEMS.register("oxidized_copper_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_BOOTS =  ITEMS.register("oxidized_copper_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_CHESTPLATE =  ITEMS.register("oxidized_copper_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_HELMET =  ITEMS.register("oxidized_copper_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_HOE =  ITEMS.register("oxidized_copper_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_HORSE_ARMOR =  ITEMS.register("oxidized_copper_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_INGOT =  ITEMS.register("oxidized_copper_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_LEGGINGS =  ITEMS.register("oxidized_copper_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_NUGGET =  ITEMS.register("oxidized_copper_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_PICKAXE =  ITEMS.register("oxidized_copper_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_SHOVEL =  ITEMS.register("oxidized_copper_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_COPPER_SWORD =  ITEMS.register("oxidized_copper_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_AXE =  ITEMS.register("oxidized_heavy_copper_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_BOOTS =  ITEMS.register("oxidized_heavy_copper_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_CHESTPLATE =  ITEMS.register("oxidized_heavy_copper_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_HELMET =  ITEMS.register("oxidized_heavy_copper_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_HOE =  ITEMS.register("oxidized_heavy_copper_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_HORSE_ARMOR =  ITEMS.register("oxidized_heavy_copper_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_INGOT =  ITEMS.register("oxidized_heavy_copper_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_LEGGINGS =  ITEMS.register("oxidized_heavy_copper_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_NUGGET =  ITEMS.register("oxidized_heavy_copper_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_PICKAXE =  ITEMS.register("oxidized_heavy_copper_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_SHOVEL =  ITEMS.register("oxidized_heavy_copper_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_HEAVY_COPPER_SWORD =  ITEMS.register("oxidized_heavy_copper_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_AXE =  ITEMS.register("oxidized_reinforced_copper_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_BOOTS =  ITEMS.register("oxidized_reinforced_copper_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_CHESTPLATE =  ITEMS.register("oxidized_reinforced_copper_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_HELMET =  ITEMS.register("oxidized_reinforced_copper_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_HOE =  ITEMS.register("oxidized_reinforced_copper_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_HORSE_ARMOR =  ITEMS.register("oxidized_reinforced_copper_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_INGOT =  ITEMS.register("oxidized_reinforced_copper_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_LEGGINGS =  ITEMS.register("oxidized_reinforced_copper_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_NUGGET =  ITEMS.register("oxidized_reinforced_copper_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_PICKAXE =  ITEMS.register("oxidized_reinforced_copper_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_SHOVEL =  ITEMS.register("oxidized_reinforced_copper_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OXIDIZED_REINFORCED_COPPER_SWORD =  ITEMS.register("oxidized_reinforced_copper_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND =  ITEMS.register("reinforced_diamond",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND_AXE =  ITEMS.register("reinforced_diamond_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND_BOOTS =  ITEMS.register("reinforced_diamond_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND_CHESTPLATE =  ITEMS.register("reinforced_diamond_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND_DROP =  ITEMS.register("reinforced_diamond_drop",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND_HELMET =  ITEMS.register("reinforced_diamond_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND_HOE =  ITEMS.register("reinforced_diamond_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND_HORSE_ARMOR =  ITEMS.register("reinforced_diamond_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND_LEGGINGS =  ITEMS.register("reinforced_diamond_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND_PICKAXE =  ITEMS.register("reinforced_diamond_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND_SHOVEL =  ITEMS.register("reinforced_diamond_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_DIAMOND_SWORD =  ITEMS.register("reinforced_diamond_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLD_INGOT =  ITEMS.register("reinforced_gold_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLD_NUGGET =  ITEMS.register("reinforced_gold_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_APPLE =  ITEMS.register("reinforced_golden_apple",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_AXE =  ITEMS.register("reinforced_golden_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_BOOTS =  ITEMS.register("reinforced_golden_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_CARROT =  ITEMS.register("reinforced_golden_carrot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_CHESTPLATE =  ITEMS.register("reinforced_golden_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_HELMET =  ITEMS.register("reinforced_golden_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_HOE =  ITEMS.register("reinforced_golden_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_HORSE_ARMOR =  ITEMS.register("reinforced_golden_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_LEGGINGS =  ITEMS.register("reinforced_golden_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_PICKAXE =  ITEMS.register("reinforced_golden_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_SHOVEL =  ITEMS.register("reinforced_golden_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_GOLDEN_SWORD =  ITEMS.register("reinforced_golden_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_AXE =  ITEMS.register("reinforced_iron_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_BOOTS =  ITEMS.register("reinforced_iron_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_CHESTPLATE =  ITEMS.register("reinforced_iron_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_HELMET =  ITEMS.register("reinforced_iron_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_HOE =  ITEMS.register("reinforced_iron_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_HORSE_ARMOR =  ITEMS.register("reinforced_iron_horse_armor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_INGOT =  ITEMS.register("reinforced_iron_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_LEGGINGS =  ITEMS.register("reinforced_iron_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_NUGGET =  ITEMS.register("reinforced_iron_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_PICKAXE =  ITEMS.register("reinforced_iron_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_SHOVEL =  ITEMS.register("reinforced_iron_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_IRON_SWORD =  ITEMS.register("reinforced_iron_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_NETHERITE_AXE =  ITEMS.register("reinforced_netherite_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_NETHERITE_BOOTS =  ITEMS.register("reinforced_netherite_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_NETHERITE_CHESTPLATE =  ITEMS.register("reinforced_netherite_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_NETHERITE_HELMET =  ITEMS.register("reinforced_netherite_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_NETHERITE_HOE =  ITEMS.register("reinforced_netherite_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_NETHERITE_INGOT =  ITEMS.register("reinforced_netherite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_NETHERITE_LEGGINGS =  ITEMS.register("reinforced_netherite_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_NETHERITE_PICKAXE =  ITEMS.register("reinforced_netherite_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_NETHERITE_SHOVEL =  ITEMS.register("reinforced_netherite_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_NETHERITE_SPALL =  ITEMS.register("reinforced_netherite_spall",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_NETHERITE_SWORD =  ITEMS.register("reinforced_netherite_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOUL_FLAMES =  ITEMS.register("soul_flames",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SWEET_AXE =  ITEMS.register("sweet_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SWEET_BOOTS =  ITEMS.register("sweet_boots",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SWEET_CHESTPLATE =  ITEMS.register("sweet_chestplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SWEET_HELMET =  ITEMS.register("sweet_helmet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SWEET_HOE =  ITEMS.register("sweet_hoe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SWEET_LEGGINGS =  ITEMS.register("sweet_leggings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SWEET_PICKAXE =  ITEMS.register("sweet_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SWEET_SHOVEL =  ITEMS.register("sweet_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SWEET_SLIMY =  ITEMS.register("sweet_slimy",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SWEET_SWORD =  ITEMS.register("sweet_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SWEET_WATER_BUCKET =  ITEMS.register("sweet_water_bucket",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TORMENTED_SOULS =  ITEMS.register("tormented_souls",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WARM_FLUFFY_MIX =  ITEMS.register("warm_fluffy_mix",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WARM_MILK_BUCKET =  ITEMS.register("warm_milk_bucket",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WARM_WATER_BUCKET =  ITEMS.register("warm_water_bucket",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WEIRD_LOVED_MIX =  ITEMS.register("weird_loved_mix",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WHISPER_DESPAIR =  ITEMS.register("whisper_despair",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

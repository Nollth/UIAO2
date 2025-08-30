package com.nothandnull.upgradableitemsandorestwo.event;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import com.nothandnull.upgradableitemsandorestwo.block.ModBlocks;
import com.nothandnull.upgradableitemsandorestwo.item.ModItems;
import com.nothandnull.upgradableitemsandorestwo.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber(modid = UpgradableItemsAndOresTwo.MOD_ID)
public class ModEvents {



    private static final Map<UUID, Long> playerBlockInteractionTime = new HashMap<>();
    private static final long AGGRO_DURATION = 20 * 10;
    private static final int DETECTION_RANGE = 4;

    private static final Set<Item> SAFE_ITEMS = Set.of(
            Items.BLAST_FURNACE,
            Items.SMOKER,
            Items.CARTOGRAPHY_TABLE,
            Items.BREWING_STAND,
            Items.COMPOSTER,
            Items.BARREL,
            Items.FLETCHING_TABLE,
            Items.CAULDRON,
            Items.LECTERN,
            Items.STONECUTTER,
            Items.LOOM,
            Items.SMITHING_TABLE,
            Items.GRINDSTONE,
            Items.EMERALD,
            Items.COAL,
            Items.IRON_INGOT,
            Items.IRON_NUGGET,
            Items.IRON_BLOCK,
            Items.IRON_HELMET,
            Items.IRON_CHESTPLATE,
            Items.IRON_LEGGINGS,
            Items.IRON_BOOTS,
            Items.IRON_SWORD,
            Items.IRON_PICKAXE,
            Items.IRON_AXE,
            Items.IRON_SHOVEL,
            Items.IRON_HOE,
            Items.GOLD_INGOT,
            Items.GOLD_NUGGET,
            Items.GOLD_BLOCK,
            Items.GOLDEN_HELMET,
            Items.GOLDEN_CHESTPLATE,
            Items.GOLDEN_LEGGINGS,
            Items.GOLDEN_BOOTS,
            Items.GOLDEN_SWORD,
            Items.GOLDEN_PICKAXE,
            Items.GOLDEN_AXE,
            Items.GOLDEN_SHOVEL,
            Items.GOLDEN_HOE,
            Items.DIAMOND,
            Items.DIAMOND_BLOCK,
            Items.DIAMOND_HELMET,
            Items.DIAMOND_CHESTPLATE,
            Items.DIAMOND_LEGGINGS,
            Items.DIAMOND_BOOTS,
            Items.DIAMOND_SWORD,
            Items.DIAMOND_PICKAXE,
            Items.DIAMOND_AXE,
            Items.DIAMOND_SHOVEL,
            Items.DIAMOND_HOE,
            Items.NETHERITE_SCRAP,
            Items.ANCIENT_DEBRIS,
            Items.BELL,
            Items.CHAINMAIL_HELMET,
            Items.CHAINMAIL_CHESTPLATE,
            Items.CHAINMAIL_LEGGINGS,
            Items.CHAINMAIL_BOOTS,
            Items.CHAIN,
            Items.LAVA_BUCKET,
            Items.WATER_BUCKET,
            Items.TROPICAL_FISH_BUCKET,
            Items.TADPOLE_BUCKET,
            Items.SALMON_BUCKET,
            Items.PUFFERFISH_BUCKET,
            Items.COD_BUCKET,
            Items.AXOLOTL_BUCKET,
            Items.BUCKET,
            Items.LEATHER,
            Items.LEATHER_HELMET,
            Items.LEATHER_CHESTPLATE,
            Items.LEATHER_LEGGINGS,
            Items.LEATHER_BOOTS,
            Items.LEAD,
            Items.SADDLE,
            Items.DIAMOND_HORSE_ARMOR,
            Items.GOLDEN_HORSE_ARMOR,
            Items.LEATHER_HORSE_ARMOR,
            Items.IRON_HORSE_ARMOR,
            Items.SHIELD,
            Items.BOW,
            Items.ARROW,
            Items.SPECTRAL_ARROW,
            Items.TIPPED_ARROW,
            Items.CROSSBOW,
            Items.POTION,
            Items.LINGERING_POTION,
            Items.SPLASH_POTION,
            Items.PORKCHOP,
            Items.COOKED_PORKCHOP,
            Items.CHICKEN,
            Items.COOKED_CHICKEN,
            Items.RABBIT_STEW,
            Items.RABBIT_FOOT,
            Items.RABBIT_HIDE,
            Items.COOKED_RABBIT,
            Items.RABBIT,
            Items.MUTTON,
            Items.COOKED_MUTTON,
            Items.BEEF,
            Items.COOKED_BEEF,
            Items.SUSPICIOUS_STEW,
            Items.SUSPICIOUS_GRAVEL,
            Items.SUSPICIOUS_SAND,
            Items.GOLDEN_CARROT,
            Items.CARROT,
            Items.CARROT_ON_A_STICK,
            Items.WARPED_FUNGUS_ON_A_STICK,
            Items.GOLDEN_APPLE,
            Items.ENCHANTED_GOLDEN_APPLE,
            Items.GLISTERING_MELON_SLICE,
            Items.PAPER,
            Items.BOOK,
            Items.BOOKSHELF,
            Items.ENCHANTED_BOOK,
            Items.CHISELED_BOOKSHELF,
            Items.WRITABLE_BOOK,
            Items.KNOWLEDGE_BOOK,
            Items.WRITTEN_BOOK,
            Items.MAP,
            Items.FILLED_MAP,
            Items.COMPASS,
            Items.GLASS_PANE,
            Items.BLACK_STAINED_GLASS_PANE,
            Items.BLUE_STAINED_GLASS_PANE,
            Items.BROWN_STAINED_GLASS_PANE,
            Items.LIGHT_BLUE_STAINED_GLASS_PANE,
            Items.GREEN_STAINED_GLASS_PANE,
            Items.GRAY_STAINED_GLASS_PANE,
            Items.CYAN_STAINED_GLASS_PANE,
            Items.LIGHT_GRAY_STAINED_GLASS_PANE,
            Items.LIME_STAINED_GLASS_PANE,
            Items.MAGENTA_STAINED_GLASS_PANE,
            Items.ORANGE_STAINED_GLASS_PANE,
            Items.PINK_STAINED_GLASS_PANE,
            Items.PURPLE_STAINED_GLASS_PANE,
            Items.RED_STAINED_GLASS_PANE,
            Items.WHITE_STAINED_GLASS_PANE,
            Items.YELLOW_STAINED_GLASS_PANE,
            Items.GLASS_BOTTLE,
            Items.HONEY_BOTTLE,
            Items.EXPERIENCE_BOTTLE,
            Items.BLACK_BANNER,
            Items.BLUE_BANNER,
            Items.BROWN_BANNER,
            Items.LIGHT_BLUE_BANNER,
            Items.GREEN_BANNER,
            Items.GRAY_BANNER,
            Items.CYAN_BANNER,
            Items.LIGHT_GRAY_BANNER,
            Items.LIME_BANNER,
            Items.MAGENTA_BANNER,
            Items.ORANGE_BANNER,
            Items.PINK_BANNER,
            Items.PURPLE_BANNER,
            Items.RED_BANNER,
            Items.WHITE_BANNER,
            Items.YELLOW_BANNER,
            Items.BLACK_WOOL,
            Items.BLUE_WOOL,
            Items.BROWN_WOOL,
            Items.LIGHT_BLUE_WOOL,
            Items.GREEN_WOOL,
            Items.GRAY_WOOL,
            Items.CYAN_WOOL,
            Items.LIGHT_GRAY_WOOL,
            Items.LIME_WOOL,
            Items.MAGENTA_WOOL,
            Items.ORANGE_WOOL,
            Items.PINK_WOOL,
            Items.PURPLE_WOOL,
            Items.RED_WOOL,
            Items.WHITE_WOOL,
            Items.YELLOW_WOOL,
            Items.BLACK_CARPET,
            Items.BLUE_CARPET,
            Items.BROWN_CARPET,
            Items.LIGHT_BLUE_CARPET,
            Items.GREEN_CARPET,
            Items.GRAY_CARPET,
            Items.CYAN_CARPET,
            Items.LIGHT_GRAY_CARPET,
            Items.LIME_CARPET,
            Items.MAGENTA_CARPET,
            Items.ORANGE_CARPET,
            Items.PINK_CARPET,
            Items.PURPLE_CARPET,
            Items.RED_CARPET,
            Items.WHITE_CARPET,
            Items.YELLOW_CARPET,
            Items.BLACK_DYE,
            Items.BLUE_DYE,
            Items.BROWN_DYE,
            Items.LIGHT_BLUE_DYE,
            Items.GREEN_DYE,
            Items.GRAY_DYE,
            Items.CYAN_DYE,
            Items.LIGHT_GRAY_DYE,
            Items.LIME_DYE,
            Items.MAGENTA_DYE,
            Items.ORANGE_DYE,
            Items.PINK_DYE,
            Items.PURPLE_DYE,
            Items.RED_DYE,
            Items.WHITE_DYE,
            Items.YELLOW_DYE,
            Items.BLACK_BED,
            Items.BLUE_BED,
            Items.BROWN_BED,
            Items.LIGHT_BLUE_BED,
            Items.GREEN_BED,
            Items.GRAY_BED,
            Items.CYAN_BED,
            Items.LIGHT_GRAY_BED,
            Items.LIME_BED,
            Items.MAGENTA_BED,
            Items.ORANGE_BED,
            Items.PINK_BED,
            Items.PURPLE_BED,
            Items.RED_BED,
            Items.WHITE_BED,
            Items.YELLOW_BED,
            Items.BLACK_TERRACOTTA,
            Items.BLUE_TERRACOTTA,
            Items.BROWN_TERRACOTTA,
            Items.LIGHT_BLUE_TERRACOTTA,
            Items.GREEN_TERRACOTTA,
            Items.GRAY_TERRACOTTA,
            Items.CYAN_TERRACOTTA,
            Items.LIGHT_GRAY_TERRACOTTA,
            Items.LIME_TERRACOTTA,
            Items.MAGENTA_TERRACOTTA,
            Items.ORANGE_TERRACOTTA,
            Items.PINK_TERRACOTTA,
            Items.PURPLE_TERRACOTTA,
            Items.RED_TERRACOTTA,
            Items.WHITE_TERRACOTTA,
            Items.YELLOW_TERRACOTTA,
            Items.BLACK_GLAZED_TERRACOTTA,
            Items.BLUE_GLAZED_TERRACOTTA,
            Items.BROWN_GLAZED_TERRACOTTA,
            Items.LIGHT_BLUE_GLAZED_TERRACOTTA,
            Items.GREEN_GLAZED_TERRACOTTA,
            Items.GRAY_GLAZED_TERRACOTTA,
            Items.CYAN_GLAZED_TERRACOTTA,
            Items.LIGHT_GRAY_GLAZED_TERRACOTTA,
            Items.LIME_GLAZED_TERRACOTTA,
            Items.MAGENTA_GLAZED_TERRACOTTA,
            Items.ORANGE_GLAZED_TERRACOTTA,
            Items.PINK_GLAZED_TERRACOTTA,
            Items.PURPLE_GLAZED_TERRACOTTA,
            Items.RED_GLAZED_TERRACOTTA,
            Items.WHITE_GLAZED_TERRACOTTA,
            Items.YELLOW_GLAZED_TERRACOTTA,
            Items.CREEPER_BANNER_PATTERN,
            Items.FLOWER_BANNER_PATTERN,
            Items.GLOBE_BANNER_PATTERN,
            Items.MOJANG_BANNER_PATTERN,
            Items.PIGLIN_BANNER_PATTERN,
            Items.SKULL_BANNER_PATTERN,
            Items.ROTTEN_FLESH,
            Items.REDSTONE,
            Items.REDSTONE_BLOCK,
            Items.REDSTONE_TORCH,
            Items.REDSTONE_LAMP,
            Items.TORCH,
            Items.SOUL_TORCH,
            Items.LAPIS_BLOCK,
            Items.LAPIS_LAZULI,
            Items.SCUTE,
            Items.ENDER_PEARL,
            Items.ENDER_EYE,
            Items.ENDER_CHEST,
            Items.CHEST,
            Items.FURNACE,
            Items.TRAPPED_CHEST,
            Items.NETHER_WART,
            Items.TURTLE_HELMET,
            Items.WHEAT,
            Items.WHEAT_SEEDS,
            Items.PUMPKIN_SEEDS,
            Items.BEETROOT_SEEDS,
            Items.MELON_SEEDS,
            Items.TORCHFLOWER_SEEDS,
            Items.BEETROOT,
            Items.MELON,
            Items.TORCHFLOWER,
            Items.POTATO,
            Items.POISONOUS_POTATO,
            Items.BAKED_POTATO,
            Items.VINE,
            Items.TWISTING_VINES,
            Items.WEEPING_VINES,
            Items.GLOW_LICHEN,
            Items.GLOWSTONE,
            Items.GLOWSTONE_DUST,
            Items.GLOW_BERRIES,
            Items.GLOW_INK_SAC,
            Items.NETHERRACK,
            Items.BREAD,
            Items.PUMPKIN,
            Items.PUMPKIN_PIE,
            Items.CARVED_PUMPKIN,
            Items.MELON_SLICE,
            Items.APPLE,
            Items.COOKIE,
            Items.CAKE,
            Items.STRING,
            Items.COD,
            Items.COOKED_COD,
            Items.SALMON,
            Items.COOKED_SALMON,
            Items.CAMPFIRE,
            Items.SOUL_CAMPFIRE,
            Items.PUFFERFISH,
            Items.TROPICAL_FISH,
            Items.FISHING_ROD,
            Items.BIRCH_BOAT,
            Items.BIRCH_CHEST_BOAT,
            Items.ACACIA_BOAT,
            Items.ACACIA_CHEST_BOAT,
            Items.CHERRY_BOAT,
            Items.CHERRY_CHEST_BOAT,
            Items.DARK_OAK_BOAT,
            Items.DARK_OAK_CHEST_BOAT,
            Items.JUNGLE_BOAT,
            Items.JUNGLE_CHEST_BOAT,
            Items.MANGROVE_BOAT,
            Items.MANGROVE_CHEST_BOAT,
            Items.OAK_BOAT,
            Items.OAK_CHEST_BOAT,
            Items.SPRUCE_BOAT,
            Items.SPRUCE_CHEST_BOAT,
            Items.STICK,
            Items.FLINT,
            Items.FLINT_AND_STEEL,
            Items.FEATHER,
            Items.TRIPWIRE_HOOK,
            Items.LANTERN,
            Items.SOUL_LANTERN,
            Items.SEA_LANTERN,
            Items.JACK_O_LANTERN,
            Items.NAME_TAG,
            Items.BRICKS,
            Items.CLAY,
            Items.CLAY_BALL,
            Items.PISTON,
            Items.STICKY_PISTON,
            Items.STONE,
            Items.COBBLESTONE,
            Items.CRAFTING_TABLE,
            Items.STONE_SWORD,
            Items.STONE_PICKAXE,
            Items.STONE_AXE,
            Items.STONE_SHOVEL,
            Items.STONE_HOE,
            Items.SAND,
            Items.DANDELION,
            Items.POPPY,
            Items.BLUE_ORCHID,
            Items.ALLIUM,
            Items.AZURE_BLUET,
            Items.CORNFLOWER,
            Items.OXEYE_DAISY,
            Items.LILY_OF_THE_VALLEY,
            Items.WITHER_ROSE,
            Items.SUNFLOWER,
            Items.LILAC,
            Items.ROSE_BUSH,
            Items.PEONY,
            Items.RED_TULIP,
            Items.ORANGE_TULIP,
            Items.WHITE_TULIP,
            Items.PINK_TULIP,
            Items.SUGAR_CANE,
            Items.SUGAR,
            Items.SHULKER_SHELL,
            Items.SHULKER_BOX,
            Items.ACACIA_SAPLING,
            Items.BIRCH_SAPLING,
            Items.SPRUCE_SAPLING,
            Items.CHERRY_SAPLING,
            Items.OAK_SAPLING,
            Items.DARK_OAK_SAPLING,
            Items.JUNGLE_SAPLING,
            Items.AZALEA,
            Items.FLOWERING_AZALEA,
            Items.MANGROVE_PROPAGULE,
            Items.BONE,
            Items.BONE_BLOCK,
            Items.BONE_MEAL,
            Items.COCOA_BEANS,
            Items.INK_SAC,
            Items.CACTUS,
            Items.BAMBOO,
            Items.BRAIN_CORAL,
            Items.BUBBLE_CORAL,
            Items.FIRE_CORAL,
            Items.TUBE_CORAL,
            Items.HORN_CORAL,
            Items.BRAIN_CORAL_BLOCK,
            Items.BUBBLE_CORAL_BLOCK,
            Items.FIRE_CORAL_BLOCK,
            Items.TUBE_CORAL_BLOCK,
            Items.HORN_CORAL_BLOCK,
            Items.BRAIN_CORAL_FAN,
            Items.BUBBLE_CORAL_FAN,
            Items.FIRE_CORAL_FAN,
            Items.TUBE_CORAL_FAN,
            Items.HORN_CORAL_FAN,
            Items.DEAD_BRAIN_CORAL,
            Items.DEAD_BUBBLE_CORAL,
            Items.DEAD_FIRE_CORAL,
            Items.DEAD_TUBE_CORAL,
            Items.DEAD_HORN_CORAL,
            Items.DEAD_BRAIN_CORAL_BLOCK,
            Items.DEAD_BUBBLE_CORAL_BLOCK,
            Items.DEAD_FIRE_CORAL_BLOCK,
            Items.DEAD_TUBE_CORAL_BLOCK,
            Items.DEAD_HORN_CORAL_BLOCK,
            Items.DEAD_BRAIN_CORAL_FAN,
            Items.DEAD_BUBBLE_CORAL_FAN,
            Items.DEAD_FIRE_CORAL_FAN,
            Items.DEAD_TUBE_CORAL_FAN,
            Items.DEAD_HORN_CORAL_FAN,
            Items.VILLAGER_SPAWN_EGG,
            Items.NAUTILUS_SHELL,
            Items.CLOCK,
            Items.OBSIDIAN,
            Items.CRYING_OBSIDIAN,
            Items.GUNPOWDER,
            Items.TNT,
            Items.MUSIC_DISC_5,
            Items.MUSIC_DISC_11,
            Items.MUSIC_DISC_13,
            Items.MUSIC_DISC_BLOCKS,
            Items.MUSIC_DISC_CAT,
            Items.MUSIC_DISC_CHIRP,
            Items.MUSIC_DISC_FAR,
            Items.MUSIC_DISC_MALL,
            Items.MUSIC_DISC_MELLOHI,
            Items.MUSIC_DISC_OTHERSIDE,
            Items.MUSIC_DISC_PIGSTEP,
            Items.MUSIC_DISC_RELIC,
            Items.MUSIC_DISC_STAL,
            Items.MUSIC_DISC_STRAD,
            Items.MUSIC_DISC_WAIT,
            Items.MUSIC_DISC_WARD,
            Items.DISC_FRAGMENT_5,
            Items.RAIL,
            Items.ACTIVATOR_RAIL,
            Items.DETECTOR_RAIL,
            Items.POWERED_RAIL,
            Items.CHARCOAL,
            Items.FIRE_CHARGE,
            Items.TOTEM_OF_UNDYING,
            Items.HEART_OF_THE_SEA,
            Items.BLAZE_ROD,
            Items.BLAZE_POWDER,
            Items.QUARTZ,
            Items.CHORUS_FLOWER,
            Items.CHORUS_FRUIT,
            Items.CHORUS_PLANT,
            Items.POPPED_CHORUS_FRUIT,
            Items.ELYTRA,
            Items.DIRT,
            Items.DIRT_PATH,
            Items.COARSE_DIRT,
            Items.ROOTED_DIRT,
            Items.GRASS,
            Items.GRASS_BLOCK,
            Items.TALL_GRASS,
            Items.SEAGRASS,
            Items.HAY_BLOCK,
            Items.PITCHER_PLANT,
            Items.DEAD_BUSH,
            Items.CONDUIT,
            Items.FARMLAND,
            Items.PODZOL
    );

    private static final Set<Block> SAFE_BLOCKS = Set.of(
            Blocks.DEAD_BUSH,
            Blocks.GRASS,
            Blocks.GRASS_BLOCK,
            Blocks.TALL_GRASS,
            Blocks.SEAGRASS,
            Blocks.TALL_SEAGRASS,
            Blocks.IRON_BLOCK,
            Blocks.GOLD_BLOCK,
            Blocks.DIAMOND_BLOCK,
            Blocks.GLASS,
            Blocks.GLASS_PANE,
            Blocks.BLACK_STAINED_GLASS_PANE,
            Blocks.BLUE_STAINED_GLASS_PANE,
            Blocks.BROWN_STAINED_GLASS_PANE,
            Blocks.LIGHT_BLUE_STAINED_GLASS_PANE,
            Blocks.GREEN_STAINED_GLASS_PANE,
            Blocks.GRAY_STAINED_GLASS_PANE,
            Blocks.CYAN_STAINED_GLASS_PANE,
            Blocks.LIGHT_GRAY_STAINED_GLASS_PANE,
            Blocks.LIME_STAINED_GLASS_PANE,
            Blocks.MAGENTA_STAINED_GLASS_PANE,
            Blocks.ORANGE_STAINED_GLASS_PANE,
            Blocks.PINK_STAINED_GLASS_PANE,
            Blocks.PURPLE_STAINED_GLASS_PANE,
            Blocks.RED_STAINED_GLASS_PANE,
            Blocks.WHITE_STAINED_GLASS_PANE,
            Blocks.YELLOW_STAINED_GLASS_PANE,
            Blocks.PODZOL,
            Blocks.FARMLAND,
            Blocks.DIRT,
            Blocks.DIRT_PATH,
            Blocks.COARSE_DIRT,
            Blocks.ROOTED_DIRT,
            Blocks.TRAPPED_CHEST,
            Blocks.CHEST,
            Blocks.FURNACE,
            Blocks.BLAST_FURNACE,
            Blocks.SMOKER,
            Blocks.CARTOGRAPHY_TABLE,
            Blocks.BREWING_STAND,
            Blocks.COMPOSTER,
            Blocks.BARREL,
            Blocks.FLETCHING_TABLE,
            Blocks.CAULDRON,
            Blocks.LECTERN,
            Blocks.STONECUTTER,
            Blocks.LOOM,
            Blocks.SMITHING_TABLE,
            Blocks.GRINDSTONE,
            Blocks.ENDER_CHEST,
            Blocks.BLACK_WOOL,
            Blocks.BLUE_WOOL,
            Blocks.BROWN_WOOL,
            Blocks.LIGHT_BLUE_WOOL,
            Blocks.GREEN_WOOL,
            Blocks.GRAY_WOOL,
            Blocks.CYAN_WOOL,
            Blocks.LIGHT_GRAY_WOOL,
            Blocks.LIME_WOOL,
            Blocks.MAGENTA_WOOL,
            Blocks.ORANGE_WOOL,
            Blocks.PINK_WOOL,
            Blocks.PURPLE_WOOL,
            Blocks.RED_WOOL,
            Blocks.WHITE_WOOL,
            Blocks.YELLOW_WOOL,
            Blocks.BLACK_CARPET,
            Blocks.BLUE_CARPET,
            Blocks.BROWN_CARPET,
            Blocks.LIGHT_BLUE_CARPET,
            Blocks.GREEN_CARPET,
            Blocks.GRAY_CARPET,
            Blocks.CYAN_CARPET,
            Blocks.LIGHT_GRAY_CARPET,
            Blocks.LIME_CARPET,
            Blocks.MAGENTA_CARPET,
            Blocks.ORANGE_CARPET,
            Blocks.PINK_CARPET,
            Blocks.PURPLE_CARPET,
            Blocks.RED_CARPET,
            Blocks.WHITE_CARPET,
            Blocks.YELLOW_CARPET,
            Blocks.BLACK_TERRACOTTA,
            Blocks.BLUE_TERRACOTTA,
            Blocks.BROWN_TERRACOTTA,
            Blocks.LIGHT_BLUE_TERRACOTTA,
            Blocks.GREEN_TERRACOTTA,
            Blocks.GRAY_TERRACOTTA,
            Blocks.CYAN_TERRACOTTA,
            Blocks.LIGHT_GRAY_TERRACOTTA,
            Blocks.LIME_TERRACOTTA,
            Blocks.MAGENTA_TERRACOTTA,
            Blocks.ORANGE_TERRACOTTA,
            Blocks.PINK_TERRACOTTA,
            Blocks.PURPLE_TERRACOTTA,
            Blocks.RED_TERRACOTTA,
            Blocks.WHITE_TERRACOTTA,
            Blocks.YELLOW_TERRACOTTA,
            Blocks.BLACK_GLAZED_TERRACOTTA,
            Blocks.BLUE_GLAZED_TERRACOTTA,
            Blocks.BROWN_GLAZED_TERRACOTTA,
            Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA,
            Blocks.GREEN_GLAZED_TERRACOTTA,
            Blocks.GRAY_GLAZED_TERRACOTTA,
            Blocks.CYAN_GLAZED_TERRACOTTA,
            Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA,
            Blocks.LIME_GLAZED_TERRACOTTA,
            Blocks.MAGENTA_GLAZED_TERRACOTTA,
            Blocks.ORANGE_GLAZED_TERRACOTTA,
            Blocks.PINK_GLAZED_TERRACOTTA,
            Blocks.PURPLE_GLAZED_TERRACOTTA,
            Blocks.RED_GLAZED_TERRACOTTA,
            Blocks.WHITE_GLAZED_TERRACOTTA,
            Blocks.YELLOW_GLAZED_TERRACOTTA,
            Blocks.BLACK_BANNER,
            Blocks.BLUE_BANNER,
            Blocks.BROWN_BANNER,
            Blocks.LIGHT_BLUE_BANNER,
            Blocks.GREEN_BANNER,
            Blocks.GRAY_BANNER,
            Blocks.CYAN_BANNER,
            Blocks.LIGHT_GRAY_BANNER,
            Blocks.LIME_BANNER,
            Blocks.MAGENTA_BANNER,
            Blocks.ORANGE_BANNER,
            Blocks.PINK_BANNER,
            Blocks.PURPLE_BANNER,
            Blocks.RED_BANNER,
            Blocks.WHITE_BANNER,
            Blocks.YELLOW_BANNER,
            Blocks.BLACK_WALL_BANNER,
            Blocks.BLUE_WALL_BANNER,
            Blocks.BROWN_WALL_BANNER,
            Blocks.LIGHT_BLUE_WALL_BANNER,
            Blocks.GREEN_WALL_BANNER,
            Blocks.GRAY_WALL_BANNER,
            Blocks.CYAN_WALL_BANNER,
            Blocks.LIGHT_GRAY_WALL_BANNER,
            Blocks.LIME_WALL_BANNER,
            Blocks.MAGENTA_WALL_BANNER,
            Blocks.ORANGE_WALL_BANNER,
            Blocks.PINK_WALL_BANNER,
            Blocks.PURPLE_WALL_BANNER,
            Blocks.RED_WALL_BANNER,
            Blocks.WHITE_WALL_BANNER,
            Blocks.YELLOW_WALL_BANNER,
            Blocks.BLACK_BED,
            Blocks.BLUE_BED,
            Blocks.BROWN_BED,
            Blocks.LIGHT_BLUE_BED,
            Blocks.GREEN_BED,
            Blocks.GRAY_BED,
            Blocks.CYAN_BED,
            Blocks.LIGHT_GRAY_BED,
            Blocks.LIME_BED,
            Blocks.MAGENTA_BED,
            Blocks.ORANGE_BED,
            Blocks.PINK_BED,
            Blocks.PURPLE_BED,
            Blocks.RED_BED,
            Blocks.WHITE_BED,
            Blocks.YELLOW_BED,
            Blocks.SAND,
            Blocks.DANDELION,
            Blocks.POPPY,
            Blocks.BLUE_ORCHID,
            Blocks.ALLIUM,
            Blocks.AZURE_BLUET,
            Blocks.CORNFLOWER,
            Blocks.OXEYE_DAISY,
            Blocks.LILY_OF_THE_VALLEY,
            Blocks.WITHER_ROSE,
            Blocks.SUNFLOWER,
            Blocks.LILAC,
            Blocks.ROSE_BUSH,
            Blocks.PEONY,
            Blocks.RED_TULIP,
            Blocks.ORANGE_TULIP,
            Blocks.WHITE_TULIP,
            Blocks.PINK_TULIP,
            Blocks.SUGAR_CANE,
            Blocks.COBBLESTONE,
            Blocks.CRAFTING_TABLE,
            Blocks.STONE,
            Blocks.TORCH,
            Blocks.TORCHFLOWER,
            Blocks.TORCHFLOWER_CROP,
            Blocks.SOUL_TORCH,
            Blocks.REDSTONE_TORCH,
            Blocks.REDSTONE_WALL_TORCH,
            Blocks.SOUL_WALL_TORCH,
            Blocks.WALL_TORCH,
            Blocks.MELON,
            Blocks.MELON_STEM,
            Blocks.ATTACHED_MELON_STEM,
            Blocks.PUMPKIN,
            Blocks.PUMPKIN_STEM,
            Blocks.CARVED_PUMPKIN,
            Blocks.ATTACHED_PUMPKIN_STEM,
            Blocks.JACK_O_LANTERN,
            Blocks.SOUL_LANTERN,
            Blocks.SEA_LANTERN,
            Blocks.LANTERN,
            Blocks.TNT,
            Blocks.SWEET_BERRY_BUSH,
            Blocks.GLOWSTONE,
            Blocks.PITCHER_PLANT,
            Blocks.CAVE_VINES_PLANT,
            Blocks.CHORUS_PLANT,
            Blocks.KELP_PLANT,
            Blocks.TWISTING_VINES_PLANT,
            Blocks.WEEPING_VINES_PLANT,
            Blocks.BAMBOO,
            Blocks.WHEAT,
            Blocks.COCOA,
            Blocks.BEETROOTS,
            Blocks.CARROTS,
            Blocks.HAY_BLOCK,
            Blocks.POTATOES,
            Blocks.PITCHER_CROP
    );

    private static boolean isSafeItem(Item item) {
        return SAFE_ITEMS.contains(item);
    }

    private static boolean isUnsafeItem(Item item) {
        return !isSafeItem(item);
    }

    private static boolean isSafeBlock(BlockState state) {
        return SAFE_BLOCKS.contains(state.getBlock())
                || state.is(ModBlocks.UNSTABLE_OBSIDIAN.get());
    }

    private static boolean isUnsafeBlock(BlockState state) {
        return !isSafeBlock(state);
    }


    private static boolean isUnsafeArmor(Player player) {
        for (ItemStack armorPiece : player.getArmorSlots()) {
            if (!armorPiece.isEmpty() && isUnsafeItem(armorPiece.getItem())) {
                return true;
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void onEntitySpawn(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Mob mob) {
            mob.targetSelector.getAvailableGoals().removeIf(goal ->
                    goal.getGoal() instanceof NearestAttackableTargetGoal);

            mob.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(mob, Player.class, true,
                    ModEvents::shouldAttackPlayer));
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        handleBlockInteraction(event.getPlayer(), event.getPos());
    }

    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        if (event.getEntity() instanceof Player player) {
            handleBlockInteraction(player, event.getPos());
        }
    }

    private static void handleBlockInteraction(Player player, BlockPos pos) {
        if (player == null || player.level().isClientSide()) return;

        BlockState state = player.level().getBlockState(pos);

        if (isUnsafeBlock(state)) {
            long gameTime = player.level().getGameTime();
            playerBlockInteractionTime.put(player.getUUID(), gameTime);
        }
    }

    private static boolean isSafeArmor(Player player) {
        for (ItemStack armorPiece : player.getArmorSlots()) {
            if (!armorPiece.isEmpty() && isSafeItem(armorPiece.getItem())) {
                return true;
            }
        }
        return false;
    }

    private static boolean shouldAttackPlayer(LivingEntity target) {
        if (!(target instanceof Player player)) return true;

        Item mainHand = player.getMainHandItem().getItem();
        Item offHand = player.getOffhandItem().getItem();

        boolean hasAnySafe = isSafeItem(mainHand) || isSafeItem(offHand) || isSafeArmor(player);
        if (hasAnySafe) {
            return false;
        }

        boolean holdingOrEquipedUnsafe =
                (!player.getMainHandItem().isEmpty() && isUnsafeItem(mainHand)) ||
                        (!player.getOffhandItem().isEmpty() && isUnsafeItem(offHand) ||
                                isUnsafeArmor(player));
        if (holdingOrEquipedUnsafe) {
            return true;
        }

        Long lastTime = playerBlockInteractionTime.get(player.getUUID());
        if (lastTime != null) {
            long now = player.level().getGameTime();
            long elapsed = now - lastTime;
            if (elapsed <= AGGRO_DURATION) {
                return true;
            } else {
                playerBlockInteractionTime.remove(player.getUUID());
            }
        }
        return false;
    }

    public static void cleanupOldEntries() {
        long currentTime = System.currentTimeMillis();
        playerBlockInteractionTime.entrySet().removeIf(entry -> currentTime >= entry.getValue());
    }

    @SubscribeEvent
    public static void addCoinTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.COIN_POLISHER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.IRON_COIN.get(), 9),
                    new ItemStack(ModItems.REINFORCED_IRON_INGOT.get(), 3),
                    64, 10, 0.05F));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.GOLD_COIN.get(), 9),
                    new ItemStack(ModItems.REINFORCED_GOLD_INGOT.get(), 3),
                    64, 10, 0.05F));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                    new ItemStack(ModItems.REINFORCED_DIAMOND.get(), 3),
                    64, 10, 0.05F));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                    new ItemStack(ModItems.REINFORCED_NETHERITE_INGOT.get(), 3),
                    64, 10, 0.05F));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.REINFORCED_IRON_COIN.get(), 9),
                    new ItemStack(ModItems.HEAVY_IRON_INGOT.get(), 3),
                    64, 10, 0.05F));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.REINFORCED_GOLD_COIN.get(), 9),
                    new ItemStack(ModItems.HEAVY_GOLD_INGOT.get(), 3),
                    64, 10, 0.05F));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.REINFORCED_DIAMOND_COIN.get(), 9),
                    new ItemStack(ModItems.HEAVY_DIAMOND.get(), 3),
                    64, 10, 0.05F));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.REINFORCED_NETHERITE_COIN.get(), 9),
                    new ItemStack(ModItems.HEAVY_NETHERITE_INGOT.get(), 3),
                    64, 10, 0.05F));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                    new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                    new ItemStack(ModItems.NETHERITOND_INGOT.get(), 6),
                    64, 10, 0.05F));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                    new ItemStack(ModItems.IRON_COIN.get(), 9),
                    new ItemStack(ModItems.NETTHRION_INGOT.get(), 6),
                    64, 10, 0.05F));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                    new ItemStack(ModItems.GOLD_COIN.get(), 9),
                    new ItemStack(ModItems.NETHORIDEN_INGOT.get(), 6),
                    64, 10, 0.05F));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                    new ItemStack(ModItems.GOLD_COIN.get(), 9),
                    new ItemStack(ModItems.GOALDMOND.get(), 6),
                    64, 10, 0.05F));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.IRON_COIN.get(), 9),
                    new ItemStack(ModItems.GOLD_COIN.get(), 9),
                    new ItemStack(ModItems.GOLREON_INGOT.get(), 6),
                    64, 10, 0.05F));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.IRON_COIN.get(), 9),
                    new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                    new ItemStack(ModItems.DIAMRON_INGOT.get(), 6),
                    64, 10, 0.05F));
        }
    }
}
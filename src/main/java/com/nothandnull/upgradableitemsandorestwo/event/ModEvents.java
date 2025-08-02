package com.nothandnull.upgradableitemsandorestwo.event;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import com.nothandnull.upgradableitemsandorestwo.item.ModItems;
import com.nothandnull.upgradableitemsandorestwo.item.UnbreakableArmor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = UpgradableItemsAndOresTwo.MOD_ID)
public class ModEvents {

    private static final Map<UUID, Long> playerBlockInteractionTime = new HashMap<>();
    private static final long AGGRO_DURATION = 20 * 15;
    private static final int DETECTION_RANGE = 8;

    private static boolean isWearingFullSet2(Player player) {

        int equippedPieces = 0;
        for (ItemStack stack : player.getArmorSlots()) {
            if (stack.isEmpty()) return false;
            if (!(stack.getItem() instanceof UnbreakableArmor)) return false;
            equippedPieces++;
        }
        return equippedPieces == 4;
    }

    private static boolean isWearingOneOrMore2(Player player) {

        int equippedPiece = 0;
        for (ItemStack stack : player.getArmorSlots()) {
            if (stack.isEmpty()) return false;
            if (!(stack.getItem() instanceof UnbreakableArmor)) return false;
            equippedPiece++;
        }
        return equippedPiece >= 1 && equippedPiece <= 4;
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
        player.level().getEntitiesOfClass(Mob.class,
                player.getBoundingBox().inflate(DETECTION_RANGE)).forEach(mob -> {
            if (mob.distanceToSqr(pos.getX(), pos.getY(), pos.getZ()) <= DETECTION_RANGE * DETECTION_RANGE) {
                playerBlockInteractionTime.put(player.getUUID(),
                        player.level().getGameTime() + AGGRO_DURATION);
            }
        });
    }

    private static boolean shouldAttackPlayer(LivingEntity target) {

        Player players = (Player) target;

        if (!(target instanceof Player) || isWearingFullSet2(players) && isWearingOneOrMore2(players)) {
            return false;
        }

        Long aggroTime = playerBlockInteractionTime.get(players.getUUID());
        if (aggroTime != null && players.level().getGameTime() < aggroTime) {
            return true;
        }

        if (aggroTime != null && players.level().getGameTime() >= aggroTime) {
            playerBlockInteractionTime.remove(players.getUUID());
        }

        for (ItemStack armorPiece : players.getArmorSlots()) {
            if (!armorPiece.isEmpty()) {
                return true;
            }
        }

        return !players.getMainHandItem().isEmpty() || !players.getOffhandItem().isEmpty();
    }

    public static void cleanupOldEntries() {
        long currentTime = System.currentTimeMillis();
        playerBlockInteractionTime.entrySet().removeIf(entry -> currentTime >= entry.getValue());
    }

    @SubscribeEvent
    public static void addCustomTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.IRON_COIN.get(), 9),
                new ItemStack(ModItems.REINFORCED_IRON_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.REINFORCED_IRON_COIN.get(), 9),
                new ItemStack(ModItems.HEAVY_IRON_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.REINFORCED_GOLD_COIN.get(), 9),
                new ItemStack(ModItems.HEAVY_GOLD_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.REINFORCED_DIAMOND_COIN.get(), 9),
                new ItemStack(ModItems.HEAVY_DIAMOND.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.REINFORCED_NETHERITE_COIN.get(), 9),
                new ItemStack(ModItems.HEAVY_NETHERITE_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.GOLD_COIN.get(), 9),
                new ItemStack(ModItems.REINFORCED_GOLD_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                new ItemStack(ModItems.REINFORCED_DIAMOND.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                new ItemStack(ModItems.REINFORCED_NETHERITE_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                new ItemStack(ModItems.NETHERITOND_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                new ItemStack(ModItems.IRON_COIN.get(), 9),
                new ItemStack(ModItems.NETTHRION_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                new ItemStack(ModItems.GOLD_COIN.get(), 9),
                new ItemStack(ModItems.NETHORIDEN_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                new ItemStack(ModItems.GOLD_COIN.get(), 9),
                new ItemStack(ModItems.GOALDMOND.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.IRON_COIN.get(), 9),
                new ItemStack(ModItems.GOLD_COIN.get(), 9),
                new ItemStack(ModItems.GOLREON_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.IRON_COIN.get(), 9),
                new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                new ItemStack(ModItems.DIAMRON_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.IRON_COIN.get(), 9),
                new ItemStack(ModItems.REINFORCED_IRON_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.REINFORCED_IRON_COIN.get(), 9),
                new ItemStack(ModItems.HEAVY_IRON_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.REINFORCED_GOLD_COIN.get(), 9),
                new ItemStack(ModItems.HEAVY_GOLD_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.REINFORCED_DIAMOND_COIN.get(), 9),
                new ItemStack(ModItems.HEAVY_DIAMOND.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.REINFORCED_NETHERITE_COIN.get(), 9),
                new ItemStack(ModItems.HEAVY_NETHERITE_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.GOLD_COIN.get(), 9),
                new ItemStack(ModItems.REINFORCED_GOLD_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                new ItemStack(ModItems.REINFORCED_DIAMOND.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                new ItemStack(ModItems.REINFORCED_NETHERITE_INGOT.get(), 6),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                new ItemStack(ModItems.NETHERITOND_INGOT.get(), 12),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                new ItemStack(ModItems.IRON_COIN.get(), 9),
                new ItemStack(ModItems.NETTHRION_INGOT.get(), 12),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.NETHERITE_COIN.get(), 9),
                new ItemStack(ModItems.GOLD_COIN.get(), 9),
                new ItemStack(ModItems.NETHORIDEN_INGOT.get(), 12),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                new ItemStack(ModItems.GOLD_COIN.get(), 9),
                new ItemStack(ModItems.GOALDMOND.get(), 12),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.IRON_COIN.get(), 9),
                new ItemStack(ModItems.GOLD_COIN.get(), 9),
                new ItemStack(ModItems.GOLREON_INGOT.get(), 12),
                64, 10, 0.05F));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.IRON_COIN.get(), 9),
                new ItemStack(ModItems.DIAMOND_COIN.get(), 9),
                new ItemStack(ModItems.DIAMRON_INGOT.get(), 12),
                64, 10, 0.05F));
    }
}

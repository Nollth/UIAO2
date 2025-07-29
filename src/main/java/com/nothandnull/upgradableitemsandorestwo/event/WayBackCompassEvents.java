package com.nothandnull.upgradableitemsandorestwo.event;

import com.nothandnull.upgradableitemsandorestwo.item.WayBackCompass;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

import static com.nothandnull.upgradableitemsandorestwo.item.WayBackCompass.TAG_MAGHEMITE_POS;

public class WayBackCompassEvents {
    private static final Map<Player, Long> holdingTimes = new HashMap<>();
    private static final int TELEPORT_DELAY_TICKS = 100;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        if (player == null || player.level().isClientSide()) return;

        ItemStack heldItem = player.getMainHandItem();
        if (heldItem.isEmpty() || !(heldItem.getItem() instanceof WayBackCompass)) {
            holdingTimes.remove(player);
            return;
        }

        if (player.isUsingItem()) {
            holdingTimes.putIfAbsent(player, System.currentTimeMillis());

            long holdTime = System.currentTimeMillis() - holdingTimes.get(player);
            if (holdTime >= 5000) {
                CompoundTag tag = heldItem.getOrCreateTag();
                if (tag.contains(TAG_MAGHEMITE_POS)) {
                    try {
                        long pos = tag.getLong(TAG_MAGHEMITE_POS);
                        BlockPos targetPos = BlockPos.of(pos);
                        if (targetPos != null) {
                            player.teleportTo(targetPos.getX() + 0.5, targetPos.getY() + 1, targetPos.getZ() + 0.5);
                        }
                    } catch (Exception e) {
                        if (tag.contains(TAG_MAGHEMITE_POS)) {
                            tag.remove(TAG_MAGHEMITE_POS);
                        }
                    }
                }
                holdingTimes.remove(player);
            }
        } else {
            holdingTimes.remove(player);
        }
    }
}
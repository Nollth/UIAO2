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

public class WayBackCompassEvents {
    private static final Map<Player, Long> holdingTimes = new HashMap<>();
    private static final int TELEPORT_DELAY_TICKS = 100;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        ItemStack heldItem = player.getMainHandItem();

        if (heldItem.getItem() instanceof WayBackCompass && player.isUsingItem()) {
            if (!holdingTimes.containsKey(player)) {
                holdingTimes.put(player, System.currentTimeMillis());
            }

            long holdTime = System.currentTimeMillis() - holdingTimes.get(player);
            if (holdTime >= 5000) {
                CompoundTag tag = heldItem.getTag();
                if (tag != null && tag.contains("LodestonePos")) {
                    BlockPos targetPos = BlockPos.of(tag.getLong("LodestonePos"));
                    player.teleportTo(targetPos.getX() + 0.5, targetPos.getY() + 1, targetPos.getZ() + 0.5);
                    holdingTimes.remove(player);
                }
            }
        } else {
            holdingTimes.remove(player);
        }
    }
}
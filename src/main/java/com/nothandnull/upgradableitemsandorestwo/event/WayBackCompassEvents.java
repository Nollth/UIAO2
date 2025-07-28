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
                CompoundTag tag = heldItem.getTag();
                if (tag != null && tag.contains("LodestonePos")) {
                    try {
                        long pos = tag.getLong("LodestonePos");
                        BlockPos targetPos = BlockPos.of(pos);
                        if (targetPos != null) {
                            player.teleportTo(targetPos.getX() + 0.5, targetPos.getY() + 1, targetPos.getZ() + 0.5);
                        }
                    } catch (Exception e) {
                        CompoundTag newTag = heldItem.getOrCreateTag();
                        if (newTag.contains("LodestonePos")) {
                            newTag.remove("LodestonePos");
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
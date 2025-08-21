package com.nothandnull.upgradableitemsandorestwo.item;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class InvulnerableBlockItem extends BlockItem {
    public InvulnerableBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        if (!entity.isInvulnerable()) {
            entity.setInvulnerable(true);
        }
        if (entity.isOnFire()) {
            entity.clearFire();
        }
        return false;
    }
}
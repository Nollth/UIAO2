package com.nothandnull.upgradableitemsandorestwo.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class UnbreakableItem extends Item {
    public UnbreakableItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }
}
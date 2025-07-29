package com.nothandnull.upgradableitemsandorestwo.event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.nothandnull.upgradableitemsandorestwo.item.UnbreakableArmor;

import java.util.Map;

@Mod.EventBusSubscriber
public class BindingCurseHandler {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (left.getItem() instanceof UnbreakableArmor) {
            if (!isBindingCurseOnly(right)) {
                event.setCanceled(true);
            }
        }
    }

    private static boolean isBindingCurseOnly(ItemStack stack) {
        if (stack.isEmpty()) return false;

        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stack);
        if (enchantments.size() != 1) return false;

        return enchantments.containsKey(Enchantments.BINDING_CURSE);
    }
}
package com.nothandnull.upgradableitemsandorestwo.recipe;

import com.nothandnull.upgradableitemsandorestwo.UpgradableItemsAndOresTwo;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, UpgradableItemsAndOresTwo.MOD_ID);

    public static final RegistryObject<RecipeSerializer<CountingTableRecipe>> COUNTING_TABLE_SERIALIZER =
            SERIALIZERS.register("counting_table", () -> CountingTableRecipe.Serializer.INSTANCE);

    public static void register (IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}

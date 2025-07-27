package com.nothandnull.upgradableitemsandorestwo.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TEST_FOOD = new FoodProperties.Builder().fast().alwaysEat().nutrition(20).saturationMod(20).build();

    public static final FoodProperties REINFORCED_GOLDEN_CARROT = new FoodProperties.Builder().nutrition(12).saturationMod(2.4f).build();

    public static final FoodProperties HEAVY_GOLDEN_CARROT = new FoodProperties.Builder().nutrition(24).saturationMod(4.8f).build();

    public static final FoodProperties REINFORCED_GOLDEN_APPLE = new FoodProperties.Builder().alwaysEat().nutrition(8).saturationMod(2.4f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 4800, 1), 1)
            .build();

    public static final FoodProperties HEAVY_GOLDEN_APPLE = new FoodProperties.Builder().alwaysEat().nutrition(16).saturationMod(4.8f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 2), 1)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 5600, 2), 1)
            .build();

    public static final FoodProperties REINFORCED_ENCHANTED_GOLDEN_APPLE = new FoodProperties.Builder().alwaysEat().nutrition(8).saturationMod(2.4f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 800, 2), 1)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 4800, 4), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 12000, 1), 1)
            .build();

    public static final FoodProperties HEAVY_ENCHANTED_GOLDEN_APPLE = new FoodProperties.Builder().alwaysEat().nutrition(16).saturationMod(4.8f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1600, 3), 1)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 5600, 5), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 24000, 2), 1)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 24000, 2), 1)
            .build();
}

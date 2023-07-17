package com.zepsun.aberrance.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties PARSNIP = new FoodProperties.Builder().nutrition(3).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 200),0.2f).build();
}

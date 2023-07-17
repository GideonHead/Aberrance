package com.zepsun.aberrance.recipe;

import com.zepsun.aberrance.Aberrance;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Aberrance.MOD_ID);

    public static final RegistryObject<RecipeSerializer<SeedMakingRecipe>> SEED_MAKING_SERIALIZER =
            SERIALIZERS.register("seed_making", () -> SeedMakingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}

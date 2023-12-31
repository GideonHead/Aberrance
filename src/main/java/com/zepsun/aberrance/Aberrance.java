package com.zepsun.aberrance;

import com.mojang.logging.LogUtils;
import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.block.entity.ModBlockEntities;
import com.zepsun.aberrance.item.ModItems;
import com.zepsun.aberrance.recipe.ModRecipes;
import com.zepsun.aberrance.screen.ModMenuTypes;
import com.zepsun.aberrance.screen.SeedMakerScreen;
import com.zepsun.aberrance.sound.ModSounds;
import com.zepsun.aberrance.tab.ModCreativeModeTabs;
import com.zepsun.aberrance.worldgen.ModTrunkPlacerTypes;
import com.zepsun.aberrance.worldgen.biome.ModTerraBlenderApi;
import com.zepsun.aberrance.worldgen.biome.surface.ModSurfaceRules;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Aberrance.MOD_ID)
public class Aberrance
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "aberrance";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Aberrance()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModSounds.register(modEventBus);

        ModTrunkPlacerTypes.register(modEventBus);

        ModTerraBlenderApi.registerRegions();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

            MenuScreens.register(ModMenuTypes.SEED_MAKER_MENU.get(), SeedMakerScreen::new);

        }
    }
}

package com.mikanbox55.brokencity;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import terrablender.api.Regions;

@Mod(BrokenCityEntryPoint.MODID)
@Mod.EventBusSubscriber(modid = BrokenCityEntryPoint.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BrokenCityEntryPoint {
    public static final String MODID = "brokencity";

    public static List<DeferredRegister<?>> FORGEREGISTRIES = new ArrayList<>();
    private static final Logger LOGGER = LogManager.getLogger();


    public BrokenCityEntryPoint() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCallBack);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMCCallBack);

        Configuration.loadConfig(Configuration.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("MagicalForest-common.toml"));
    }


    private void setupCallBack(final FMLCommonSetupEvent event)
    {
        if (!Configuration.biomeWeightForest.get().equals(0)){
            // Given we only add one biome, we should keep our weight relatively low.
            Regions.register(new BrokenCityRegionProvider(new ResourceLocation(MODID, "overworld"), Configuration.biomeWeightForest.get()));
        }
        else LOGGER.info("Magical Forest biome is disabled in the config! Please change 0 to something bigger to re-enable it.");
    }

    private void processIMCCallBack(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
}

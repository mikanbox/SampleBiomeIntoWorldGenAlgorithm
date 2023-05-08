package com.mikanbox55.brokencity.registry;

import com.mikanbox55.brokencity.BrokenCityBiomeInitializer;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BiomeRegistry {

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();

        registry.register(BrokenCityBiomeDecorator.decorateMagicalForest().setRegistryName(BrokenCityBiomeInitializer.BROKEN_CITY.location()));
    }
}
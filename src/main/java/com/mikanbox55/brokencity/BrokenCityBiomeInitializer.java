package com.mikanbox55.brokencity;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BrokenCityBiomeInitializer {
    public static final ResourceKey<Biome> BROKEN_CITY = register("broken_city");

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registry.BIOME_REGISTRY,
                new ResourceLocation(BrokenCityEntryPoint.MODID, name));
    }
}

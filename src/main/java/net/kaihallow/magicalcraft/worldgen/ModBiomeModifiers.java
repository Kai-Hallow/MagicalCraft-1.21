package net.kaihallow.magicalcraft.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.core.registries.Registries.*;
import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

public class ModBiomeModifiers
{
    public static void bootstrap(BootstrapContext<BiomeModifier> context){
        var placedFeature = context.lookup(PLACED_FEATURE);
        var biomes = context.lookup(BIOME);
    }

    private static ResourceKey<BiomeModifier> registerKey(String name){
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
    }
}

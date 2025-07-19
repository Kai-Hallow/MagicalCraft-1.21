package net.kaihallow.magicalcraft.datagen;

import net.kaihallow.magicalcraft.worldgen.ModBiomeModifiers;
import net.kaihallow.magicalcraft.worldgen.ModConfiguredFeatures;
import net.kaihallow.magicalcraft.worldgen.ModPlacedFeatures;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static net.kaihallow.magicalcraft.MagicalCraft.MODID;

public class ModDataPackEntries extends DatapackBuiltinEntriesProvider
{
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModDataPackEntries(PackOutput output, CompletableFuture<RegistrySetBuilder.PatchedRegistries> registries) {
        super(output, registries, Set.of(MODID));
    }
}

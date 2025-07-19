package net.kaihallow.magicalcraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.kaihallow.magicalcraft.MagicalCraft.MODID;
import static net.kaihallow.magicalcraft.block.ModBlocks.*;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BLUE_CRYSTAL_BLOCK.get())
                .add(DEEPSLATE_LIGHTNING_CRYSTAL_ORE.get())
                .add(LIGHTNING_CRYSTAL_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BLUE_CRYSTAL_BLOCK.get())
                .add(DEEPSLATE_LIGHTNING_CRYSTAL_ORE.get())
                .add(LIGHTNING_CRYSTAL_ORE.get());
    }
}

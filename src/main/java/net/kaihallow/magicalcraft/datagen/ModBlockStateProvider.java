package net.kaihallow.magicalcraft.datagen;

import net.kaihallow.magicalcraft.MagicalCraft;
import net.kaihallow.magicalcraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static net.kaihallow.magicalcraft.block.ModBlocks.*;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper){
        super(output, MagicalCraft.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BLUE_CRYSTAL_BLOCK);

        blockWithItem(LIGHTNING_CRYSTAL_ORE);
        blockWithItem(DEEPSLATE_LIGHTNING_CRYSTAL_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

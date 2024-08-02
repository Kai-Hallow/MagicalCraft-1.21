package net.kaihallow.magicalcraft.item;

import net.kaihallow.magicalcraft.MagicalCraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MagicalCraft.MODID);

    public static final RegistryObject<Item> SCEPTER = ITEMS.register("scepter",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLUE_CRYSTAL = ITEMS.register("blue_crystal",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

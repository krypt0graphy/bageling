package com.kryptography.bageling;

import com.kryptography.bageling.client.ClientEvents;
import com.kryptography.bageling.init.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;


@Mod(Bageling.MODID)
public class Bageling {
    public static final String MODID = "bageling";

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public Bageling(IEventBus bus) {
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModEntityTypes.ENTITTIES.register(bus);
        ModSounds.SOUNDS.register(bus);

        bus.addListener(ModData::addCreative);
        bus.addListener(ClientEvents::registerRenderers);
    }

}
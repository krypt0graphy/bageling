package com.kryptography.bageling;

import com.kryptography.bageling.client.ClientEvents;
import com.kryptography.bageling.init.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;


@Mod(Bageling.MODID)
public class Bageling {
    public static final String MODID = "bageling";

    public Bageling(IEventBus bus) {
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModEntityTypes.ENTITTIES.register(bus);
        ModSounds.SOUNDS.register(bus);

        bus.addListener(ClientEvents::registerRenderers);
    }

}
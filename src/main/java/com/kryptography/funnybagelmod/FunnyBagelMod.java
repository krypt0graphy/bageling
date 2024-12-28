package com.kryptography.funnybagelmod;

import com.kryptography.funnybagelmod.data.Loot;
import com.kryptography.funnybagelmod.data.Recipe;
import com.kryptography.funnybagelmod.initialization.BlockInit;
import com.kryptography.funnybagelmod.initialization.EntityInit;
import com.kryptography.funnybagelmod.initialization.ItemInit;
import com.kryptography.funnybagelmod.sound.FunnyBagelSound;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;


@Mod(FunnyBagelMod.MODID)
public class FunnyBagelMod {
    public static final String MODID = "funnybagelmod";

    public FunnyBagelMod(IEventBus bus) {
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        EntityInit.ENTITTIES.register(bus);
        FunnyBagelSound.SOUNDS.register(bus);

        bus.addListener(this::registerRenderers);
        bus.addListener(this::gatherData);



    }
    private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.THROWABLE_BAGEL.get(), ThrownItemRenderer::new);
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        boolean includeServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        generator.addProvider(includeServer, new Loot(generator.getPackOutput(), event.getLookupProvider()));
        generator.addProvider(includeServer, new Recipe(generator.getPackOutput(), event.getLookupProvider()));

    }

}
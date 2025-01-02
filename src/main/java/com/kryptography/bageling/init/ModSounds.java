package com.kryptography.bageling.init;

import com.kryptography.bageling.Bageling;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


import java.util.function.Supplier;


public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Bageling.MODID);

    public static final Supplier<SoundEvent> BONK = SOUNDS.register("bonk", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Bageling.MODID, "bonk")));
    public static final Supplier<SoundEvent> THROW = SOUNDS.register("throw", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Bageling.MODID, "throw")));
}
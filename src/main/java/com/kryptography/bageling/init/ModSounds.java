package com.kryptography.bageling.init;

import com.kryptography.bageling.Bageling;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Bageling.MODID);

    public static final Supplier<SoundEvent> BONK = SOUNDS.register("bonk", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Bageling.MODID, "bonk")));
    public static final Supplier<SoundEvent> THROW = SOUNDS.register("throw", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Bageling.MODID, "throw")));
}
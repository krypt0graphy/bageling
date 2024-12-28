package com.kryptography.funnybagelmod.sound;

import com.kryptography.funnybagelmod.FunnyBagelMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class FunnyBagelSound {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, FunnyBagelMod.MODID);


    public static final Supplier<SoundEvent> BONK = SOUNDS.register("bonk", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(FunnyBagelMod.MODID, "bonk")));


}
package com.kryptography.bageling.init;


import net.minecraft.resources.ResourceLocation;
import com.kryptography.bageling.Bageling;
import com.kryptography.bageling.common.entity.projectile.ThrowableBagel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITTIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Bageling.MODID);


    public static final DeferredHolder<EntityType<?>, EntityType<ThrowableBagel>> THROWABLE_BAGEL = ENTITTIES.register("throwable_bagel", () ->
            EntityType.Builder.<ThrowableBagel>of(ThrowableBagel::new, MobCategory.MISC).sized(0.25F, 0.25F).build(ResourceLocation.fromNamespaceAndPath(Bageling.MODID, "throwable_bagel").toString())
    );

    public static void register(IEventBus modEventBus) {
        ENTITTIES.register(modEventBus);
    }


}

package com.kryptography.bageling.init;


import net.minecraft.resources.ResourceLocation;
import com.kryptography.bageling.Bageling;
import com.kryptography.bageling.common.entity.projectile.ThrowableBagel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITTIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Bageling.MODID);


    public static final RegistryObject<EntityType<ThrowableBagel>> THROWABLE_BAGEL = ENTITTIES.register("throwable_bagel", () ->
            EntityType.Builder.<ThrowableBagel>of(ThrowableBagel::new, MobCategory.MISC).sized(0.25F, 0.25F).build(ResourceLocation.fromNamespaceAndPath(Bageling.MODID, "throwable_bagel").toString())
    );

    public static void register(IEventBus modEventBus) {
        ENTITTIES.register(modEventBus);
    }


}

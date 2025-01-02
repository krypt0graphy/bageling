package com.kryptography.bageling.integration;

import net.minecraftforge.fml.ModList;


import java.util.Optional;
import java.util.function.Supplier;

public enum Mods {
    FARMERSDELIGHT,
    CREATE;
    public final String id;

    Mods() {
        id = name().toLowerCase();
    }

    public boolean isLoaded() {
        return ModList.get().isLoaded(id);
    }


    public <T> Optional<T> runIfInstalled(Supplier<T> toRun) {
        if (isLoaded())
            return Optional.of(toRun.get());
        return Optional.empty();
    }
    public void executeIfInstalled(Supplier<Runnable> toExecute) {
        if (isLoaded()) {
            toExecute.get().run();
        }
    }

    public String id() {
        return id;
    }
}
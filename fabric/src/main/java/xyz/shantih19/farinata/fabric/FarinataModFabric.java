package xyz.shantih19.farinata.fabric;

import net.fabricmc.api.ModInitializer;

import xyz.shantih19.farinata.FarinataMod;

public final class FarinataModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        FarinataMod.init();
    }
}

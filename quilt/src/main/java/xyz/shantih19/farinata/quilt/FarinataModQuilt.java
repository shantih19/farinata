package xyz.shantih19.farinata.quilt;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import xyz.shantih19.farinata.FarinataMod;

public final class FarinataModQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        // Run our common setup.
        FarinataMod.init();
    }


}

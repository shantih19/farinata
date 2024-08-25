package xyz.shantih19.farinata.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import xyz.shantih19.farinata.FarinataMod;

@Mod(FarinataMod.MOD_ID)
public final class FarinataModForge {
    public FarinataModForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(FarinataMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        FarinataMod.init();
    }
}

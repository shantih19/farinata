package xyz.shantih19.farinata.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import xyz.shantih19.farinata.FarinataMod;
import xyz.shantih19.farinata.registries.BlockRegistries;

public final class FarinataModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                BlockRegistries.CHICKPEA_CROP.get());
    }
}

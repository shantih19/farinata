package xyz.shantih19.farinata.quilt.client;

import net.minecraft.client.renderer.RenderType;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;
import xyz.shantih19.farinata.registries.BlockRegistries;

public class FarinataModQuiltClient implements ClientModInitializer {

    @Override
    public void onInitializeClient(ModContainer mod) {
        BlockRenderLayerMap.put(RenderType.cutout(), BlockRegistries.CHICKPEA_CROP.get());
    }
}

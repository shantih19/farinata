package xyz.shantih19.farinata.registries;

import dev.architectury.core.fluid.ArchitecturyFlowingFluid;
import dev.architectury.core.fluid.ArchitecturyFluidAttributes;
import dev.architectury.core.fluid.SimpleArchitecturyFluidAttributes;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import xyz.shantih19.farinata.FarinataMod;

public class FluidRegistries {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(FarinataMod.MOD_ID, Registries.FLUID);

    public static final ArchitecturyFluidAttributes CHICKPEA_SLURRY_ATTRIBUTES = SimpleArchitecturyFluidAttributes.
            ofSupplier( () -> FluidRegistries.CHICKPEA_SLURRY_FLOWING, () -> FluidRegistries.CHICKPEA_SLURRY)
            .density(1350)
            .viscosity(1800)
            .blockSupplier(() -> BlockRegistries.CHICKPEA_SLURRY_BLOCK)
            .bucketItemSupplier(() -> ItemRegistries.CHICKPEA_SLURRY_BUCKET)
            .color(0xf2df5e)
            .sourceTexture(new ResourceLocation(FarinataMod.MOD_ID, "block/fluid/chickpea_slurry_still"))
            .flowingTexture(new ResourceLocation(FarinataMod.MOD_ID, "block/fluid/chickpea_slurry_flow"));

    public static final RegistrySupplier<FlowingFluid> CHICKPEA_SLURRY = FLUIDS.register(new ResourceLocation(FarinataMod.MOD_ID, "chickpea_slurry"),
            () -> new ArchitecturyFlowingFluid.Source(CHICKPEA_SLURRY_ATTRIBUTES));

    public static final RegistrySupplier<FlowingFluid> CHICKPEA_SLURRY_FLOWING = FLUIDS.register(new ResourceLocation(FarinataMod.MOD_ID, "chickpea_slurry_flowing"),
            () -> new ArchitecturyFlowingFluid.Flowing(CHICKPEA_SLURRY_ATTRIBUTES));
}

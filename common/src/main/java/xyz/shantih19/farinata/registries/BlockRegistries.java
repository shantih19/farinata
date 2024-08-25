package xyz.shantih19.farinata.registries;

import dev.architectury.core.block.ArchitecturyLiquidBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import xyz.shantih19.farinata.FarinataMod;
import xyz.shantih19.farinata.block.ChickpeaCropBlock;
import xyz.shantih19.farinata.block.FarinataBlock;

public class BlockRegistries {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(FarinataMod.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<Block> FARINATA = BLOCKS.register(new ResourceLocation(FarinataMod.MOD_ID, "farinata"),
            () -> new FarinataBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).dynamicShape().mapColor(MapColor.COLOR_YELLOW).pushReaction(PushReaction.DESTROY).instabreak()));


    public static final RegistrySupplier<Block> CHICKPEA_CROP = BLOCKS.register(new ResourceLocation(FarinataMod.MOD_ID, "chickpea_crop"),
            () -> new ChickpeaCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).dynamicShape().noOcclusion().randomTicks().noCollission()));

    public static final RegistrySupplier<Block> CHICKPEA_WILD_CROP = BLOCKS.register(new ResourceLocation(FarinataMod.MOD_ID, "wild_chickpea_crop"),
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noOcclusion().noCollission().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));

    public static final RegistrySupplier<LiquidBlock> CHICKPEA_SLURRY_BLOCK = BLOCKS.register(new ResourceLocation(FarinataMod.MOD_ID, "chickpea_slurry"),
            () -> new ArchitecturyLiquidBlock(FluidRegistries.CHICKPEA_SLURRY, BlockBehaviour.Properties.copy(Blocks.WATER)));

}

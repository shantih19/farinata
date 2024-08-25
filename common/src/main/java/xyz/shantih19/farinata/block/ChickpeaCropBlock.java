package xyz.shantih19.farinata.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import xyz.shantih19.farinata.FarinataMod;
import xyz.shantih19.farinata.registries.ItemRegistries;

import java.util.Properties;

public class ChickpeaCropBlock extends CropBlock {
    public ChickpeaCropBlock(Properties pProperties){
        super(pProperties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemRegistries.CHICKPEAS.get();
    }

}

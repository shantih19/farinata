package xyz.shantih19.farinata.items;

import dev.architectury.core.item.ArchitecturyBucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class ChickpeaSlurry extends ArchitecturyBucketItem {
    public ChickpeaSlurry(Supplier<FlowingFluid> fluid, Properties pProperties) {
        super(fluid, pProperties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }
}

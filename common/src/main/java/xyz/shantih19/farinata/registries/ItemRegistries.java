package xyz.shantih19.farinata.registries;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import xyz.shantih19.farinata.FarinataMod;
import xyz.shantih19.farinata.items.ChickpeaSlurry;

public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(FarinataMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> FARINATA = ITEMS.register(new ResourceLocation(FarinataMod.MOD_ID, "farinata"),
            () -> new BlockItem(BlockRegistries.FARINATA.get(), new Item.Properties().arch$tab(FarinataMod.FARINATA_TAB).food(
                    new FoodProperties.Builder().saturationMod(16f).nutrition(12)
                            .effect(new MobEffectInstance(MobEffects.SATURATION, 30 * 20), 1f)
                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15 * 20), 0.1f)
                            .build()
            )));

    public static final RegistrySupplier<Item> CHICKPEAS = ITEMS.register(new ResourceLocation(FarinataMod.MOD_ID, "chickpeas"),
            () -> new BlockItem(BlockRegistries.CHICKPEA_CROP.get(), new Item.Properties().arch$tab(FarinataMod.FARINATA_TAB).food(
                    new FoodProperties.Builder().fast().saturationMod(1.0f).nutrition(2).build())));

    public static final RegistrySupplier<Item> ROASTED_CHICKPEAS = ITEMS.register(new ResourceLocation(FarinataMod.MOD_ID, "roasted_chickpeas"),
            () -> new Item(new Item.Properties().arch$tab(FarinataMod.FARINATA_TAB).food(
                    new FoodProperties.Builder().fast().saturationMod(1.8f).nutrition(3).build())));

    public static final RegistrySupplier<Item> CHICKPEA_FLOUR = ITEMS.register(new ResourceLocation(FarinataMod.MOD_ID, "chickpea_flour"),
            () -> new Item(new Item.Properties().arch$tab(FarinataMod.FARINATA_TAB)));

    public static final RegistrySupplier<Item> CHICKPEA_SLURRY_BUCKET = ITEMS.register(new ResourceLocation(FarinataMod.MOD_ID, "chickpea_slurry"),
            () -> new ChickpeaSlurry(FluidRegistries.CHICKPEA_SLURRY, new Item.Properties().arch$tab(FarinataMod.FARINATA_TAB).food(
                    new FoodProperties.Builder().saturationMod(0.1f).alwaysEat().effect(
                            new MobEffectInstance(MobEffects.CONFUSION, 10), 0.9f).build()
            ).stacksTo(1)));
}

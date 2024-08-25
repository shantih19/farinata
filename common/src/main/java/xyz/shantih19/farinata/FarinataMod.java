package xyz.shantih19.farinata;

import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.level.biome.BiomeModifications;
import dev.architectury.registry.level.entity.trade.SimpleTrade;
import dev.architectury.registry.level.entity.trade.TradeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.shantih19.farinata.registries.BlockRegistries;
import xyz.shantih19.farinata.registries.FluidRegistries;
import xyz.shantih19.farinata.registries.ItemRegistries;

public final class FarinataMod {


    public static final String MOD_ID = "farinata";
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> FARINATA_TAB = TABS.register(new ResourceLocation(MOD_ID, "farinata"),
            () -> CreativeTabRegistry.create(Component.translatable("category.farinata"), () -> new ItemStack(ItemRegistries.FARINATA.get())));

    static Logger logger = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Write common init code here.

        logger.info("Farinata Time!");

        FluidRegistries.FLUIDS.register();
        BlockRegistries.BLOCKS.register();
        ItemRegistries.ITEMS.register();
        TABS.register();

        BiomeModifications.addProperties((context) -> context.getProperties().getClimateProperties().getTemperature() > 0.7 && context.getProperties().getClimateProperties().getTemperature() < 0.9,
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MOD_ID, "crop")));
                });

        LifecycleEvent.SETUP.register(() -> {
            ComposterBlock.COMPOSTABLES.put(ItemRegistries.CHICKPEAS.get(), 0.2f);
            TradeRegistry.registerVillagerTrade(VillagerProfession.FARMER, 1,
                    new SimpleTrade(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(ItemRegistries.CHICKPEAS.get(), 8), 5, 3, 0.02f),
                    new SimpleTrade(new ItemStack(ItemRegistries.CHICKPEAS.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD, 1), 3, 4, 0.04f)
            );
        });

    }

}

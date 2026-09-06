package extendedcells;

import appeng.api.client.StorageCellModels;
import extendedcells.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = ExtendedCells.MODID, dist = Dist.CLIENT)
public class ExtendedCellsClient {
    public ExtendedCellsClient(IEventBus modEventBus, ModContainer container) {
        modEventBus.addListener(ExtendedCellsClient::onClientSetup);

        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        ExtendedCells.LOGGER.info("HELLO FROM CLIENT SETUP");
        ExtendedCells.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

        event.enqueueWork(ExtendedCellsClient::registerDriveCellModels);
    }

    private static void registerDriveCellModels() {
        registerDriveCellModel(ModItems.EXT_ITEM_CELL_1K.get(), "extended_item_cell_1k");
        registerDriveCellModel(ModItems.EXT_ITEM_CELL_4K.get(), "extended_item_cell_4k");
        registerDriveCellModel(ModItems.EXT_ITEM_CELL_16K.get(), "extended_item_cell_16k");
        registerDriveCellModel(ModItems.EXT_ITEM_CELL_64K.get(), "extended_item_cell_64k");
        registerDriveCellModel(ModItems.EXT_ITEM_CELL_256K.get(), "extended_item_cell_256k");

        registerDriveCellModel(ModItems.EXT_FLUID_CELL_1K.get(), "extended_fluid_cell_1k");
        registerDriveCellModel(ModItems.EXT_FLUID_CELL_4K.get(), "extended_fluid_cell_4k");
        registerDriveCellModel(ModItems.EXT_FLUID_CELL_16K.get(), "extended_fluid_cell_16k");
        registerDriveCellModel(ModItems.EXT_FLUID_CELL_64K.get(), "extended_fluid_cell_64k");
        registerDriveCellModel(ModItems.EXT_FLUID_CELL_256K.get(), "extended_fluid_cell_256k");

        registerDriveCellModel(ModItems.EXT_CHEMICAL_CELL_1K.get(), "extended_chemical_cell_1k");
        registerDriveCellModel(ModItems.EXT_CHEMICAL_CELL_4K.get(), "extended_chemical_cell_4k");
        registerDriveCellModel(ModItems.EXT_CHEMICAL_CELL_16K.get(), "extended_chemical_cell_16k");
        registerDriveCellModel(ModItems.EXT_CHEMICAL_CELL_64K.get(), "extended_chemical_cell_64k");
        registerDriveCellModel(ModItems.EXT_CHEMICAL_CELL_256K.get(), "extended_chemical_cell_256k");
    }

    private static void registerDriveCellModel(net.minecraft.world.level.ItemLike item, String id) {
        StorageCellModels.registerModel(
                item,
                ResourceLocation.fromNamespaceAndPath(ExtendedCells.MODID, "block/drive/cells/" + id));
    }
}

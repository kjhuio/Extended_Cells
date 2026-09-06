package extendedcells.item;

import appeng.api.stacks.AEKeyType;
import appeng.api.storage.StorageCells;
import appeng.api.storage.cells.CellState;
import appeng.items.storage.StorageTier;
import extendedcells.ExtendedCells;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExtendedCells.MODID);

    public static final int VANILLA_TOTAL_TYPES = 63;
    public static final int EXTENDED_TOTAL_TYPES = VANILLA_TOTAL_TYPES * 2; // 126

    public static final DeferredHolder<Item, ExtendedBasicStorageCell> EXT_ITEM_CELL_1K = itemCell(
            "extended_item_cell_1k", 0.5, 1, 8);

    public static final DeferredHolder<Item, ExtendedBasicStorageCell> EXT_ITEM_CELL_4K = itemCell(
            "extended_item_cell_4k", 1.0, 4, 32);

    public static final DeferredHolder<Item, ExtendedBasicStorageCell> EXT_ITEM_CELL_16K = itemCell(
            "extended_item_cell_16k", 1.5, 16, 128);

    public static final DeferredHolder<Item, ExtendedBasicStorageCell> EXT_ITEM_CELL_64K = itemCell(
            "extended_item_cell_64k", 2.0, 64, 512);

    public static final DeferredHolder<Item, ExtendedBasicStorageCell> EXT_ITEM_CELL_256K = itemCell(
            "extended_item_cell_256k", 2.5, 256, 2048);

    public static final DeferredHolder<Item, ExtendedBasicStorageCell> EXT_FLUID_CELL_1K = fluidCell(
            "extended_fluid_cell_1k", 0.5, 1, 8);

    public static final DeferredHolder<Item, ExtendedBasicStorageCell> EXT_FLUID_CELL_4K = fluidCell(
            "extended_fluid_cell_4k", 1.0, 4, 32);

    public static final DeferredHolder<Item, ExtendedBasicStorageCell> EXT_FLUID_CELL_16K = fluidCell(
            "extended_fluid_cell_16k", 1.5, 16, 128);

    public static final DeferredHolder<Item, ExtendedBasicStorageCell> EXT_FLUID_CELL_64K = fluidCell(
            "extended_fluid_cell_64k", 2.0, 64, 512);

    public static final DeferredHolder<Item, ExtendedBasicStorageCell> EXT_FLUID_CELL_256K = fluidCell(
            "extended_fluid_cell_256k", 2.5, 256, 2048);

    public static final DeferredHolder<Item, ExtendedChemicalStorageCell> EXT_CHEMICAL_CELL_1K = chemicalCell(
            "extended_chemical_cell_1k", StorageTier.SIZE_1K);

    public static final DeferredHolder<Item, ExtendedChemicalStorageCell> EXT_CHEMICAL_CELL_4K = chemicalCell(
            "extended_chemical_cell_4k", StorageTier.SIZE_4K);

    public static final DeferredHolder<Item, ExtendedChemicalStorageCell> EXT_CHEMICAL_CELL_16K = chemicalCell(
            "extended_chemical_cell_16k", StorageTier.SIZE_16K);

    public static final DeferredHolder<Item, ExtendedChemicalStorageCell> EXT_CHEMICAL_CELL_64K = chemicalCell(
            "extended_chemical_cell_64k", StorageTier.SIZE_64K);

    public static final DeferredHolder<Item, ExtendedChemicalStorageCell> EXT_CHEMICAL_CELL_256K = chemicalCell(
            "extended_chemical_cell_256k", StorageTier.SIZE_256K);

    private static DeferredHolder<Item, ExtendedBasicStorageCell> itemCell(
            String id, double idleDrain, int kilobytes, int bytesPerType) {
        return ITEMS.register(id, () -> new ExtendedBasicStorageCell(
                new Item.Properties().stacksTo(1),
                idleDrain,
                kilobytes,
                bytesPerType,
                EXTENDED_TOTAL_TYPES,
                AEKeyType.items()));
    }

    private static DeferredHolder<Item, ExtendedBasicStorageCell> fluidCell(
            String id, double idleDrain, int kilobytes, int bytesPerType) {
        return ITEMS.register(id, () -> new ExtendedBasicStorageCell(
                new Item.Properties().stacksTo(1),
                idleDrain,
                kilobytes,
                bytesPerType,
                EXTENDED_TOTAL_TYPES,
                AEKeyType.fluids()));
    }

    private static DeferredHolder<Item, ExtendedChemicalStorageCell> chemicalCell(String id, StorageTier tier) {
        return ITEMS.register(id, () -> new ExtendedChemicalStorageCell(new Item.Properties().stacksTo(1), tier));
    }

    public static boolean isExtendedCell(Item item) {
        return item instanceof ExtendedCellTypeLimit;
    }
}

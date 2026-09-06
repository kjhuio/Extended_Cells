package extendedcells.item;

import appeng.api.config.FuzzyMode;
import appeng.items.storage.StorageTier;
import me.ramidzkh.mekae2.item.ChemicalStorageCell;
import net.minecraft.world.item.ItemStack;

public class ExtendedChemicalStorageCell extends ChemicalStorageCell implements ExtendedCellTypeLimit {
    public ExtendedChemicalStorageCell(Properties properties, StorageTier tier) {
        super(properties, tier);
    }

    @Override
    public int getTotalTypes(ItemStack cellItem) {
        return getExtendedTotalTypes();
    }

    @Override
    public boolean isEditable(ItemStack stack) {
        return false;
    }

    @Override
    public FuzzyMode getFuzzyMode(ItemStack stack) {
        return FuzzyMode.IGNORE_ALL;
    }

    @Override
    public void setFuzzyMode(ItemStack stack, FuzzyMode mode) {
    }
}

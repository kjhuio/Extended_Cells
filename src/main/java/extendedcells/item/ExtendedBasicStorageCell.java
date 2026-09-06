package extendedcells.item;

import appeng.api.config.FuzzyMode;
import appeng.api.stacks.AEKeyType;
import appeng.items.storage.BasicStorageCell;
import net.minecraft.world.item.ItemStack;

public class ExtendedBasicStorageCell extends BasicStorageCell implements ExtendedCellTypeLimit {
    public ExtendedBasicStorageCell(
            Properties properties,
            double idleDrain,
            int kilobytes,
            int bytesPerType,
            int totalTypes,
            AEKeyType keyType) {
        super(properties, idleDrain, kilobytes, bytesPerType, totalTypes, keyType);
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

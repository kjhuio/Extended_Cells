package extendedcells.item;

public interface ExtendedCellTypeLimit {
    default int getExtendedTotalTypes() {
        return ModItems.EXTENDED_TOTAL_TYPES;
    }
}

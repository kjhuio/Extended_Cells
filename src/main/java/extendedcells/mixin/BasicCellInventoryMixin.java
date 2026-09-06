package extendedcells.mixin;

import appeng.api.storage.cells.IBasicCellItem;
import appeng.me.cells.BasicCellInventory;
import extendedcells.item.ExtendedCellTypeLimit;
import extendedcells.item.ModItems;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BasicCellInventory.class)
public abstract class BasicCellInventoryMixin {
    @Shadow
    @Final
    private ItemStack i;

    @Shadow
    @Final
    private IBasicCellItem cellType;

    @ModifyConstant(method = "<init>", constant = @Constant(intValue = ModItems.VANILLA_TOTAL_TYPES))
    private int extendedcells$raiseTypeLimitForExtendedCells(int original) {
        if (this.cellType instanceof ExtendedCellTypeLimit extendedCell && this.i.getItem() == this.cellType) {
            return extendedCell.getExtendedTotalTypes();
        }

        return original;
    }
}

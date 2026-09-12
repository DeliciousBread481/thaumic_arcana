package hu.frontrider.core;

import kotlin.Metadata;
import net.minecraft.block.state.IBlockState;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"},
   d2 = {"Lhu/frontrider/core/IFluidHelper;", "", "getWaterValue", "", "blockState", "Lnet/minecraft/block/state/IBlockState;", "Thaumic Arcana"}
)
public interface IFluidHelper {
   int getWaterValue(@NotNull IBlockState var1);
}

package hu.frontrider.core;

import kotlin.Metadata;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&¨\u0006\u000f"},
   d2 = {"Lhu/frontrider/core/IBlockUpdater;", "", "updateBlockState", "", "world", "Lnet/minecraft/world/World;", "left", "Lnet/minecraft/util/math/BlockPos;", "right", "thizState", "Lnet/minecraft/block/state/IBlockState;", "thizPos", "leftSide", "Lnet/minecraft/util/EnumFacing;", "rightSide", "Thaumic Arcana"}
)
public interface IBlockUpdater {
   void updateBlockState(@NotNull World var1, @NotNull BlockPos var2, @NotNull BlockPos var3, @NotNull IBlockState var4, @NotNull BlockPos var5, @NotNull EnumFacing var6, @NotNull EnumFacing var7);
}

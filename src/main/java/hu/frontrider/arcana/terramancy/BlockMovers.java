package hu.frontrider.arcana.terramancy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
   d2 = {"Lhu/frontrider/arcana/terramancy/BlockMovers;", "", "()V", "move", "Lnet/minecraft/util/math/BlockPos;", "world", "Lnet/minecraft/world/World;", "pos", "direction", "Lnet/minecraft/util/EnumFacing;", "Thaumic Arcana"}
)
public final class BlockMovers {
   public static final BlockMovers INSTANCE;

   @NotNull
   public final BlockPos move(@NotNull World world, @NotNull BlockPos pos, @NotNull EnumFacing direction) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(direction, "direction");
      if (world.func_175625_s(pos) != null) {
         return pos;
      } else if (!world.func_175623_d(pos)) {
         return pos;
      } else {
         IBlockState blockState = world.func_180495_p(pos);
         BlockPos offset = pos.func_177972_a(direction);
         world.func_175656_a(offset, blockState);
         world.func_175698_g(offset);
         Intrinsics.checkExpressionValueIsNotNull(offset, "offset");
         return offset;
      }
   }

   private BlockMovers() {
   }

   static {
      BlockMovers var0 = new BlockMovers();
      INSTANCE = var0;
   }
}

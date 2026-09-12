package hu.frontrider.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"},
   d2 = {"Lhu/frontrider/core/util/BlockHelper;", "", "()V", "getFacing", "Lnet/minecraft/util/EnumFacing;", "p_getFacing_0_", "", "isPowered", "", "world", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/BlockPos;", "Thaumic Arcana"}
)
public final class BlockHelper {
   public static final BlockHelper INSTANCE;

   public final boolean isPowered(@NotNull World world, @NotNull BlockPos pos) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      return world.func_175687_A(pos) > 0 || world.func_175640_z(pos);
   }

   @Nullable
   public final EnumFacing getFacing(int p_getFacing_0_) {
      int i = p_getFacing_0_ & 7;
      return i > 5 ? null : EnumFacing.func_82600_a(i);
   }

   private BlockHelper() {
   }

   static {
      BlockHelper var0 = new BlockHelper();
      INSTANCE = var0;
   }
}

package hu.frontrider.core.util.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0002¨\u0006\t"},
   d2 = {"inRange", "", "Lnet/minecraft/util/math/BlockPos;", "blockPos", "range", "", "toBlockPos", "Lnet/minecraft/nbt/NBTTagCompound;", "toNBT", "Thaumic Arcana"}
)
public final class BlockposKt {
   @NotNull
   public static final NBTTagCompound toNBT(@NotNull BlockPos $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      NBTTagCompound nbtTagCompound = new NBTTagCompound();
      nbtTagCompound.func_74768_a("x", $receiver.func_177958_n());
      nbtTagCompound.func_74768_a("y", $receiver.func_177956_o());
      nbtTagCompound.func_74768_a("z", $receiver.func_177952_p());
      return nbtTagCompound;
   }

   @NotNull
   public static final BlockPos toBlockPos(@NotNull NBTTagCompound $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      return new BlockPos($receiver.func_74762_e("x"), $receiver.func_74762_e("y"), $receiver.func_74762_e("z"));
   }

   public static final boolean inRange(@NotNull BlockPos $receiver, @NotNull BlockPos blockPos, int range) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      Intrinsics.checkParameterIsNotNull(blockPos, "blockPos");
      double distance = blockPos.func_185332_f($receiver.func_177958_n(), $receiver.func_177956_o(), $receiver.func_177952_p());
      return distance <= (double)range;
   }
}

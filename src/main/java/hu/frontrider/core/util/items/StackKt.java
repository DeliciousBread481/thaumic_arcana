package hu.frontrider.core.util.items;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\u0005"},
   d2 = {"isNotEmpty", "", "Lnet/minecraft/item/ItemStack;", "sameAs", "stack", "Thaumic Arcana"}
)
public final class StackKt {
   public static final boolean sameAs(@NotNull ItemStack $receiver, @NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      NBTTagCompound thisNBT = $receiver.func_77978_p();
      NBTTagCompound stackNBT = stack.func_77978_p();
      boolean nbtmatch = true;
      if (thisNBT != null && stackNBT != null) {
         nbtmatch = Intrinsics.areEqual(thisNBT, stackNBT);
      }

      return Intrinsics.areEqual($receiver.func_77973_b(), stack.func_77973_b()) && $receiver.func_77960_j() == stack.func_77960_j() && nbtmatch;
   }

   public static final boolean isNotEmpty(@NotNull ItemStack $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      return !$receiver.func_190926_b();
   }
}

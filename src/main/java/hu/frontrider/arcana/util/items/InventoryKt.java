package hu.frontrider.arcana.util.items;

import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a8\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042$\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007\u001a\u001a\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001\u001a@\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00012$\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007¨\u0006\n"},
   d2 = {"contains", "", "Lnet/minecraftforge/items/IItemHandler;", "stack", "Lnet/minecraft/item/ItemStack;", "insertStack", "insertFunction", "Lkotlin/Function4;", "", "simulate", "Thaumic Arcana"}
)
public final class InventoryKt {
   public static final boolean contains(@NotNull IItemHandler $receiver, @NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      int i = 0;

      for(int var3 = $receiver.getSlots(); i < var3; ++i) {
         if ($receiver.getStackInSlot(i).func_77969_a(stack)) {
            return true;
         }
      }

      return false;
   }

   @NotNull
   public static final ItemStack insertStack(@NotNull IItemHandler $receiver, @NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      return insertStack($receiver, stack, false, null.INSTANCE);
   }

   @NotNull
   public static final ItemStack insertStack(@NotNull IItemHandler $receiver, @NotNull ItemStack stack, boolean simulate) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      return insertStack($receiver, stack, simulate, null.INSTANCE);
   }

   @NotNull
   public static final ItemStack insertStack(@NotNull IItemHandler $receiver, @NotNull ItemStack stack, boolean simulate, @NotNull Function4<? super IItemHandler, ? super Integer, ? super Boolean, ? super ItemStack, ItemStack> insertFunction) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(insertFunction, "insertFunction");
      ItemStack insertAttemptResult = stack;
      int i = 0;

      for(int var6 = $receiver.getSlots(); i < var6; ++i) {
         insertAttemptResult = (ItemStack)insertFunction.invoke($receiver, i, simulate, insertAttemptResult);
         if (insertAttemptResult.func_190926_b()) {
            ItemStack var10000 = ItemStack.field_190927_a;
            Intrinsics.checkExpressionValueIsNotNull(var10000, "ItemStack.EMPTY");
            return var10000;
         }
      }

      return insertAttemptResult;
   }

   @NotNull
   public static final ItemStack insertStack(@NotNull IItemHandler $receiver, @NotNull ItemStack stack, @NotNull Function4<? super IItemHandler, ? super Integer, ? super Boolean, ? super ItemStack, ItemStack> insertFunction) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(insertFunction, "insertFunction");
      return insertStack($receiver, stack, false, insertFunction);
   }
}

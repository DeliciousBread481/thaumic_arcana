package hu.frontrider.core.util.inventory;

import hu.frontrider.arcana.util.items.BlockedInventory;
import hu.frontrider.core.util.items.StackKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a\u001c\u0010\t\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¨\u0006\f"},
   d2 = {"addItemStackToInventory", "", "Lnet/minecraftforge/items/IItemHandler;", "stack", "Lnet/minecraft/item/ItemStack;", "startIndex", "", "endIndex", "extract", "extractFirst", "doExtract", "count", "Thaumic Arcana"}
)
public final class InventoryKt {
   public static final boolean addItemStackToInventory(@NotNull IItemHandler $receiver, @NotNull ItemStack stack, int startIndex, int endIndex) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      if (stack.func_190926_b()) {
         return true;
      } else {
         int openSlot = -1;
         int i = startIndex;
         int var6 = endIndex;
         if (startIndex <= endIndex) {
            while(true) {
               ItemStack var10000 = $receiver.getStackInSlot(i);
               Intrinsics.checkExpressionValueIsNotNull(var10000, "this.getStackInSlot(i)");
               ItemStack inventoryStack = var10000;
               if (StackKt.sameAs(inventoryStack, stack)) {
                  int hold = inventoryStack.func_77976_d() - inventoryStack.func_190916_E();
                  if (hold >= stack.func_190916_E()) {
                     inventoryStack.func_190917_f(stack.func_190916_E());
                     return true;
                  }

                  stack.func_190918_g(hold);
                  inventoryStack.func_190917_f(hold);
               } else if (inventoryStack.func_190926_b() && openSlot == -1) {
                  openSlot = i;
               }

               if (i == var6) {
                  break;
               }

               ++i;
            }
         }

         if (openSlot > -1) {
            if ($receiver instanceof BlockedInventory) {
               ((BlockedInventory)$receiver).insertItemInternal(openSlot, stack, false);
            } else {
               Intrinsics.checkExpressionValueIsNotNull($receiver.insertItem(openSlot, stack, false), "this.insertItem(openSlot, stack, false)");
            }

            return true;
         } else {
            return false;
         }
      }
   }

   // $FF: synthetic method
   public static boolean addItemStackToInventory$default(IItemHandler var0, ItemStack var1, int var2, int var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = 0;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.getSlots() - 1;
      }

      return addItemStackToInventory(var0, var1, var2, var3);
   }

   @NotNull
   public static final ItemStack extractFirst(@NotNull IItemHandler $receiver, boolean doExtract, int count) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      int stackCount = count;
      int i = 0;

      for(int var5 = $receiver.getSlots(); i < var5; ++i) {
         ItemStack var10000 = $receiver.getStackInSlot(i);
         Intrinsics.checkExpressionValueIsNotNull(var10000, "this.getStackInSlot(i)");
         ItemStack itemStack = var10000;
         if (StackKt.isNotEmpty(itemStack)) {
            if (count == 0) {
               stackCount = itemStack.func_190916_E();
            }

            var10000 = $receiver.extractItem(i, stackCount, !doExtract);
            Intrinsics.checkExpressionValueIsNotNull(var10000, "extractItem(i, stackCount, !doExtract)");
            return var10000;
         }
      }

      ItemStack var8 = ItemStack.field_190927_a;
      Intrinsics.checkExpressionValueIsNotNull(var8, "ItemStack.EMPTY");
      return var8;
   }

   // $FF: synthetic method
   @NotNull
   public static ItemStack extractFirst$default(IItemHandler var0, boolean var1, int var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = 0;
      }

      return extractFirst(var0, var1, var2);
   }

   @NotNull
   public static final ItemStack extract(@NotNull IItemHandler $receiver, @NotNull ItemStack stack, int startIndex, int endIndex) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      int i = startIndex;
      int var5 = endIndex;
      if (startIndex <= endIndex) {
         while(true) {
            ItemStack var10000 = $receiver.getStackInSlot(i);
            Intrinsics.checkExpressionValueIsNotNull(var10000, "this.getStackInSlot(i)");
            ItemStack inventoryStack = var10000;
            if (StackKt.sameAs(inventoryStack, stack)) {
               var10000 = $receiver.extractItem(i, stack.func_190916_E(), false);
               Intrinsics.checkExpressionValueIsNotNull(var10000, "extractItem(i, stack.count, false)");
               return var10000;
            }

            if (i == var5) {
               break;
            }

            ++i;
         }
      }

      ItemStack var7 = ItemStack.field_190927_a;
      Intrinsics.checkExpressionValueIsNotNull(var7, "ItemStack.EMPTY");
      return var7;
   }

   // $FF: synthetic method
   @NotNull
   public static ItemStack extract$default(IItemHandler var0, ItemStack var1, int var2, int var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = 0;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.getSlots() - 1;
      }

      return extract(var0, var1, var2, var3);
   }
}

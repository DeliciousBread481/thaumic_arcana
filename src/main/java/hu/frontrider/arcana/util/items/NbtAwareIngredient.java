package hu.frontrider.arcana.util.items;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\t"},
   d2 = {"Lhu/frontrider/arcana/util/items/NbtAwareIngredient;", "Lnet/minecraft/item/crafting/Ingredient;", "items", "", "Lnet/minecraft/item/ItemStack;", "([Lnet/minecraft/item/ItemStack;)V", "apply", "", "targetStack", "Thaumic Arcana"}
)
public final class NbtAwareIngredient extends Ingredient {
   public boolean apply(@Nullable ItemStack targetStack) {
      if (targetStack == null) {
         return false;
      } else {
         for(ItemStack itemstack : this.field_193371_b) {
            Intrinsics.checkExpressionValueIsNotNull(itemstack, "itemstack");
            if (itemstack.func_77973_b() == targetStack.func_77973_b()) {
               int i = itemstack.func_77960_j();
               if (i == 32767 || i == targetStack.func_77960_j()) {
                  return ItemStack.func_77989_b(itemstack, targetStack);
               }
            }
         }

         return false;
      }
   }

   public NbtAwareIngredient(@NotNull ItemStack... items) {
      Intrinsics.checkParameterIsNotNull(items, "items");
      super((ItemStack[])Arrays.copyOf(items, items.length));
   }
}

package hu.frontrider.core.recipes;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"},
   d2 = {"Lhu/frontrider/core/recipes/RecipeTippedTool;", "Lnet/minecraftforge/registries/IForgeRegistryEntry$Impl;", "Lnet/minecraft/item/crafting/IRecipe;", "()V", "canFit", "", "width", "", "height", "getCraftingResult", "Lnet/minecraft/item/ItemStack;", "inv", "Lnet/minecraft/inventory/InventoryCrafting;", "getRecipeOutput", "getRemainingItems", "Lnet/minecraft/util/NonNullList;", "isDynamic", "matches", "worldIn", "Lnet/minecraft/world/World;", "Thaumic Arcana"}
)
public final class RecipeTippedTool extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
   public boolean func_77569_a(@NotNull InventoryCrafting inv, @NotNull World worldIn) {
      Intrinsics.checkParameterIsNotNull(inv, "inv");
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      ArrayList items = new ArrayList();
      int i = 0;

      for(int var5 = inv.func_174922_i(); i < var5; ++i) {
         int j = 0;

         for(int var7 = inv.func_174923_h(); j < var7; ++j) {
            ItemStack itemstack = inv.func_70463_b(i, j);
            Intrinsics.checkExpressionValueIsNotNull(itemstack, "itemstack");
            if (!itemstack.func_190926_b()) {
               items.add(itemstack);
            }
         }
      }

      return items.size() == 2 ? SequencesKt.count(SequencesKt.filter(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable)items), null.INSTANCE), null.INSTANCE), null.INSTANCE)) == 0 : false;
   }

   @NotNull
   public ItemStack func_77572_b(@NotNull InventoryCrafting inv) {
      Intrinsics.checkParameterIsNotNull(inv, "inv");
      ArrayList items = new ArrayList();
      int i = 0;

      for(int var4 = inv.func_174922_i(); i < var4; ++i) {
         int j = 0;

         for(int var6 = inv.func_174923_h(); j < var6; ++j) {
            ItemStack itemstack = inv.func_70463_b(i, j);
            Intrinsics.checkExpressionValueIsNotNull(itemstack, "itemstack");
            if (!itemstack.func_190926_b()) {
               items.add(itemstack);
            }
         }
      }

      ItemStack var10000;
      if (items.size() != 2) {
         var10000 = ItemStack.field_190927_a;
         Intrinsics.checkExpressionValueIsNotNull(var10000, "ItemStack.EMPTY");
      } else {
         ItemStack tool = (ItemStack)SequencesKt.first(SequencesKt.filter(CollectionsKt.asSequence((Iterable)items), null.INSTANCE));
         ItemStack potion = (ItemStack)SequencesKt.first(SequencesKt.filter(CollectionsKt.asSequence((Iterable)items), null.INSTANCE));
         PotionUtils.func_185188_a(tool, PotionUtils.func_185191_c(potion));
         PotionUtils.func_185184_a(tool, (Collection)PotionUtils.func_185190_b(potion));
         PotionUtils.func_185182_a(tool, ArraysKt.toMutableList(new String[0]), 0.0F);
         var10000 = tool;
      }

      return var10000;
   }

   @NotNull
   public ItemStack func_77571_b() {
      ItemStack var10000 = ItemStack.field_190927_a;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "ItemStack.EMPTY");
      return var10000;
   }

   @NotNull
   public NonNullList<ItemStack> func_179532_b(@NotNull InventoryCrafting inv) {
      Intrinsics.checkParameterIsNotNull(inv, "inv");
      NonNullList var10000 = NonNullList.func_191197_a(inv.func_70302_i_(), ItemStack.field_190927_a);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "NonNullList.withSize(inv…ventory, ItemStack.EMPTY)");
      return var10000;
   }

   public boolean func_192399_d() {
      return true;
   }

   public boolean func_194133_a(int width, int height) {
      return width * height >= 2;
   }
}

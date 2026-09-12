package hu.frontrider.arcana.research.theory;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.items.ItemsTC;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
   d2 = {"Lhu/frontrider/arcana/research/theory/TheoryRegistry;", "", "()V", "init", "", "Thaumic Arcana"}
)
public final class TheoryRegistry {
   public final void init() {
      ArrayList itemStacks = new ArrayList();
      itemStacks.add(new ItemStack(Items.field_151014_N));
      itemStacks.add(new ItemStack(Items.field_151174_bG));
      itemStacks.add(new ItemStack(Items.field_151170_bI));
      itemStacks.add(new ItemStack(Items.field_185163_cU));
      itemStacks.add(new ItemStack(Items.field_151034_e));
      itemStacks.add(new ItemStack(Items.field_151015_O));
      itemStacks.add(new ItemStack(Items.field_151127_ba));
      itemStacks.add(new ItemStack(Blocks.field_150423_aK));
      itemStacks.add(new ItemStack(Items.field_151081_bc));
      itemStacks.add(new ItemStack(Items.field_151080_bb));
      itemStacks.add(new ItemStack(Items.field_185164_cV));
      itemStacks.add(new ItemStack(Items.field_151172_bF));
      itemStacks.add(new ItemStack((Block)Blocks.field_150434_aF));
      Collection $receiver$iv = (Collection)itemStacks;
      CardGrow.Companion var5 = CardGrow.Companion;
      Object[] var10000 = $receiver$iv.toArray(new ItemStack[0]);
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      } else {
         Object[] var6 = var10000;
         var5.setOptions$Thaumic_Arcana((ItemStack[])var6);
         itemStacks.clear();
         itemStacks.add(new ItemStack(Items.field_151082_bd));
         itemStacks.add(new ItemStack(Items.field_151076_bf));
         itemStacks.add(new ItemStack(Items.field_179561_bm));
         itemStacks.add(new ItemStack(Items.field_151147_al));
         $receiver$iv = (Collection)itemStacks;
         var5 = CardGrow.Companion;
         var10000 = $receiver$iv.toArray(new ItemStack[0]);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
         } else {
            var6 = var10000;
            var5.setOptions$Thaumic_Arcana((ItemStack[])var6);
            itemStacks.clear();
            itemStacks.add(new ItemStack(ItemsTC.brain));
            itemStacks.add(new ItemStack(Items.field_151078_bh));
            itemStacks.add(new ItemStack(Items.field_151103_aS));
            $receiver$iv = (Collection)itemStacks;
            var5 = CardGrow.Companion;
            var10000 = $receiver$iv.toArray(new ItemStack[0]);
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            } else {
               var6 = var10000;
               var5.setOptions$Thaumic_Arcana((ItemStack[])var6);
            }
         }
      }
   }
}

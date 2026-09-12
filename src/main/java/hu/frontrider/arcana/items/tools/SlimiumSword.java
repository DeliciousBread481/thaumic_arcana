package hu.frontrider.arcana.items.tools;

import hu.frontrider.arcana.ThaumicArcana;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0017¨\u0006\n"},
   d2 = {"Lhu/frontrider/arcana/items/tools/SlimiumSword;", "Lhu/frontrider/arcana/items/tools/SwordBase;", "()V", "getSubItems", "", "tab", "Lnet/minecraft/creativetab/CreativeTabs;", "items", "Lnet/minecraft/util/NonNullList;", "Lnet/minecraft/item/ItemStack;", "Thaumic Arcana"}
)
public final class SlimiumSword extends SwordBase {
   @SideOnly(Side.CLIENT)
   public void func_150895_a(@NotNull CreativeTabs tab, @NotNull NonNullList<ItemStack> items) {
      Intrinsics.checkParameterIsNotNull(tab, "tab");
      Intrinsics.checkParameterIsNotNull(items, "items");
      if (tab == ThaumicArcana.INSTANCE.getTABARCANA()) {
         ItemStack result = new ItemStack((Item)this);
         EnchantmentHelper.func_82782_a(MapsKt.mapOf(new Pair(Enchantments.field_185306_r, 2)), result);
         items.add(result);
      }

   }

   public SlimiumSword() {
      super("slimy_sword", MaterialsKt.getTOOL_MATERIAL_SLIMIUM());
   }
}

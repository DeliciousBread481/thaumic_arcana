package hu.frontrider.arcana.util;

import hu.frontrider.arcana.registrationhandlers.ItemRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0017¨\u0006\t"},
   d2 = {"Lhu/frontrider/arcana/util/CreativeTabArcana;", "Lnet/minecraft/creativetab/CreativeTabs;", "par1", "", "par2Str", "", "(ILjava/lang/String;)V", "getTabIconItem", "Lnet/minecraft/item/ItemStack;", "Thaumic Arcana"}
)
public final class CreativeTabArcana extends CreativeTabs {
   @SideOnly(Side.CLIENT)
   @NotNull
   public ItemStack func_78016_d() {
      return new ItemStack(ItemRegistry.Companion.getCreature_enchanter());
   }

   public CreativeTabArcana(int par1, @NotNull String par2Str) {
      Intrinsics.checkParameterIsNotNull(par2Str, "par2Str");
      super(par1, par2Str);
   }
}

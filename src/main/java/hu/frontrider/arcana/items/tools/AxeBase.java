package hu.frontrider.arcana.items.tools;

import hu.frontrider.arcana.ThaumicArcana;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"},
   d2 = {"Lhu/frontrider/arcana/items/tools/AxeBase;", "Lnet/minecraft/item/ItemTool;", "name", "", "material", "Lnet/minecraft/item/Item$ToolMaterial;", "(Ljava/lang/String;Lnet/minecraft/item/Item$ToolMaterial;)V", "canHarvestBlock", "", "blockIn", "Lnet/minecraft/block/state/IBlockState;", "Thaumic Arcana"}
)
public class AxeBase extends ItemTool {
   public boolean func_150897_b(@NotNull IBlockState blockIn) {
      Intrinsics.checkParameterIsNotNull(blockIn, "blockIn");
      return Intrinsics.areEqual(blockIn.func_177230_c().func_149688_o(blockIn), Material.field_151575_d);
   }

   public AxeBase(@NotNull String name, @NotNull Item.ToolMaterial material) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(material, "material");
      super(material, (Set)ToolBaseKt.access$getAXE_EFFECTIVE_ON$p());
      this.setRegistryName("thaumic_arcana", name);
      this.func_77655_b("thaumic_arcana." + name);
      this.func_77637_a(ThaumicArcana.INSTANCE.getTABARCANA());
   }
}

package hu.frontrider.arcana.items.tools;

import hu.frontrider.arcana.ThaumicArcana;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"},
   d2 = {"Lhu/frontrider/arcana/items/tools/ShovelBase;", "Lnet/minecraft/item/ItemSpade;", "name", "", "material", "Lnet/minecraft/item/Item$ToolMaterial;", "(Ljava/lang/String;Lnet/minecraft/item/Item$ToolMaterial;)V", "Thaumic Arcana"}
)
public class ShovelBase extends ItemSpade {
   public ShovelBase(@NotNull String name, @NotNull Item.ToolMaterial material) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(material, "material");
      super(material);
      this.setRegistryName("thaumic_arcana", name);
      this.func_77655_b("thaumic_arcana." + name);
      this.func_77637_a(ThaumicArcana.INSTANCE.getTABARCANA());
   }
}

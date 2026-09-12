package hu.frontrider.arcana.items;

import hu.frontrider.arcana.ThaumicArcana;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"},
   d2 = {"Lhu/frontrider/arcana/items/ItemBase;", "Lnet/minecraft/item/Item;", "name", "", "(Ljava/lang/String;)V", "resourceLocation", "Lnet/minecraft/util/ResourceLocation;", "(Lnet/minecraft/util/ResourceLocation;)V", "Thaumic Arcana"}
)
public class ItemBase extends Item {
   public ItemBase(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      super();
      this.setRegistryName("thaumic_arcana", name);
      this.func_77655_b("thaumic_arcana." + name);
      this.func_77637_a(ThaumicArcana.INSTANCE.getTABARCANA());
   }

   public ItemBase(@NotNull ResourceLocation resourceLocation) {
      Intrinsics.checkParameterIsNotNull(resourceLocation, "resourceLocation");
      super();
      this.setRegistryName(resourceLocation);
      this.func_77655_b("thaumic_arcana." + resourceLocation.func_110623_a());
      this.func_77637_a(ThaumicArcana.INSTANCE.getTABARCANA());
   }
}

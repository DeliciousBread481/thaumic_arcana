package hu.frontrider.arcana.entity.golems;

import hu.frontrider.arcana.util.ColorsKt;
import kotlin.Metadata;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.golems.EnumGolemTrait;
import thaumcraft.api.golems.parts.GolemMaterial;
import thaumcraft.api.items.ItemsTC;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
   d2 = {"Lhu/frontrider/arcana/entity/golems/MaterialLeather;", "Lthaumcraft/api/golems/parts/GolemMaterial;", "()V", "Thaumic Arcana"}
)
public final class MaterialLeather extends GolemMaterial {
   public MaterialLeather() {
      super("thaumic_arcana.leather", new String[]{"TA_LEATHER_STUDIES"}, new ResourceLocation("thaumic_arcana", "textures/entity/golem/mat_leather.png"), ColorsKt.convertToIntColor(198, 92, 53), 10, 0, 0, new ItemStack(Items.field_151116_aA, 10), new ItemStack(ItemsTC.mechanismComplex, 2), new EnumGolemTrait[]{EnumGolemTrait.LIGHT, EnumGolemTrait.HAULER});
   }
}

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
   d2 = {"Lhu/frontrider/arcana/entity/golems/MaterialHay;", "Lthaumcraft/api/golems/parts/GolemMaterial;", "()V", "Thaumic Arcana"}
)
public final class MaterialHay extends GolemMaterial {
   public MaterialHay() {
      super("thaumic_arcana.hay", new String[]{"TA_HAY_STUDIES"}, new ResourceLocation("thaumic_arcana", "textures/entity/golem/mat_hay.png"), ColorsKt.convertToIntColor(240, 255, 127), 3, 0, 0, new ItemStack(Items.field_151015_O, 10), new ItemStack(ItemsTC.mechanismSimple, 2), new EnumGolemTrait[]{EnumGolemTrait.FRAGILE, EnumGolemTrait.DEFT, EnumGolemTrait.LIGHT});
   }
}

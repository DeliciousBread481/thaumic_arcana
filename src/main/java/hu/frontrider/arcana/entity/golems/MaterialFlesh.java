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
   d2 = {"Lhu/frontrider/arcana/entity/golems/MaterialFlesh;", "Lthaumcraft/api/golems/parts/GolemMaterial;", "()V", "Thaumic Arcana"}
)
public final class MaterialFlesh extends GolemMaterial {
   public MaterialFlesh() {
      super("thaumic_arcana.flesh", new String[]{"TA_FLESH_STUDIES"}, new ResourceLocation("thaumic_arcana", "textures/entity/golem/mat_flesh.png"), ColorsKt.convertToIntColor(255, 127, 195), 5, 0, 2, new ItemStack(Items.field_151078_bh, 10), new ItemStack(ItemsTC.brain, 2), new EnumGolemTrait[]{EnumGolemTrait.FRAGILE, EnumGolemTrait.LIGHT, EnumGolemTrait.REPAIR, EnumGolemTrait.SMART});
   }
}

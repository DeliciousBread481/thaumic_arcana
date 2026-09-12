package hu.frontrider.arcana.entity.golems;

import hu.frontrider.arcana.util.ColorsKt;
import kotlin.Metadata;
import net.minecraft.init.Blocks;
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
   d2 = {"Lhu/frontrider/arcana/entity/golems/MaterialSlime;", "Lthaumcraft/api/golems/parts/GolemMaterial;", "()V", "Thaumic Arcana"}
)
public final class MaterialSlime extends GolemMaterial {
   public MaterialSlime() {
      super("thaumic_arcana.slime", new String[]{"TA_SLIME_STUDIES"}, new ResourceLocation("thaumic_arcana", "textures/entity/golem/mat_slime.png"), ColorsKt.convertToIntColor(24, 160, 51), 10, 10, 0, new ItemStack(Blocks.field_180399_cE, 1), new ItemStack(ItemsTC.plate, 2), new EnumGolemTrait[]{EnumGolemTrait.ARMORED, EnumGolemTrait.CLUMSY, EnumGolemTrait.BLASTPROOF, EnumGolemTrait.HEAVY});
   }
}

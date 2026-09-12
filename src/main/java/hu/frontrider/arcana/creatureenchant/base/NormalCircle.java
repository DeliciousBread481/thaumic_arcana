package hu.frontrider.arcana.creatureenchant.base;

import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EnchantingBaseCircle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/base/NormalCircle;", "Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;", "()V", "color", "Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle$Color;", "getColor", "()Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle$Color;", "formula", "Lthaumcraft/api/aspects/AspectList;", "kotlin.jvm.PlatformType", "getFormula", "()Lthaumcraft/api/aspects/AspectList;", "research", "", "getResearch", "()Ljava/lang/String;", "doEffect", "", "multiplier", "entityLiving", "Lnet/minecraft/entity/EntityLivingBase;", "enchant", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "Thaumic Arcana"}
)
public final class NormalCircle extends EnchantingBaseCircle {
   private final AspectList formula;
   @NotNull
   private final EnchantingBaseCircle.Color color;
   @NotNull
   private final String research;

   public AspectList getFormula() {
      return this.formula;
   }

   @NotNull
   public EnchantingBaseCircle.Color getColor() {
      return this.color;
   }

   @NotNull
   public String getResearch() {
      return this.research;
   }

   public int doEffect(int multiplier, @NotNull EntityLivingBase entityLiving, @NotNull CreatureEnchant enchant) {
      Intrinsics.checkParameterIsNotNull(entityLiving, "entityLiving");
      Intrinsics.checkParameterIsNotNull(enchant, "enchant");
      return multiplier;
   }

   public NormalCircle() {
      super("normal");
      this.formula = (new AspectList()).merge(Aspect.BEAST, 300).merge(Aspect.MAGIC, 100).merge(Aspect.LIFE, 50).merge(Aspect.AURA, 100);
      this.color = new EnchantingBaseCircle.Color(255, 255, 255, 255);
      this.research = "ENCHANT_MODIFICATION";
      this.setRegistryName("thaumic_arcana", "normal");
   }
}

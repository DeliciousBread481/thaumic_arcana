package hu.frontrider.arcana.creatureenchant.effect;

import hu.frontrider.arcana.creatureenchant.EffectEnchantBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/effect/Vitality;", "Lhu/frontrider/arcana/creatureenchant/EffectEnchantBase;", "()V", "research", "", "getResearch", "()Ljava/lang/String;", "formula", "Lthaumcraft/api/aspects/AspectList;", "Thaumic Arcana"}
)
public final class Vitality extends EffectEnchantBase {
   @NotNull
   public String getResearch() {
      return "CREATURE_ENCHANT_ADVANCED";
   }

   @NotNull
   public AspectList formula() {
      AspectList var10000 = (new AspectList()).merge(Aspect.SENSES, 20).merge(Aspect.LIFE, 100).merge(Aspect.MAGIC, 20);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "AspectList()\n           … .merge(Aspect.MAGIC, 20)");
      return var10000;
   }

   public Vitality() {
      Potion var10001 = MobEffects.field_76428_l;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "MobEffects.REGENERATION");
      Potion var10002 = MobEffects.field_82731_v;
      Intrinsics.checkExpressionValueIsNotNull(var10002, "MobEffects.WITHER");
      super(var10001, var10002, (double)-2.0F, new ResourceLocation("thaumic_arcana", "vitality"), "vitality");
   }
}

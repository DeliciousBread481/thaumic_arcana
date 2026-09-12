package hu.frontrider.arcana.recipes;

import hu.frontrider.arcana.AspectEffectMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.minecraft.potion.PotionEffect;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 3,
   d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"},
   d2 = {"<anonymous>", "", "it", "Lnet/minecraft/potion/PotionEffect;", "kotlin.jvm.PlatformType", "invoke"}
)
final class BrewSlime$getOutput$1$effect$1 extends Lambda implements Function1<PotionEffect, Boolean> {
   // $FF: synthetic field
   final AspectEffectMap.EffectEntry $potion;

   public final boolean invoke(PotionEffect it) {
      Intrinsics.checkExpressionValueIsNotNull(it, "it");
      return Intrinsics.areEqual(it.func_188419_a(), this.$potion.getPotion());
   }

   BrewSlime$getOutput$1$effect$1(AspectEffectMap.EffectEntry var1) {
      super(1);
      this.$potion = var1;
   }
}

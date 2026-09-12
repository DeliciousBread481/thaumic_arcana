package hu.frontrider.arcana.items.armor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"},
   d2 = {"makeInfusedArmor", "Lnet/minecraft/item/ItemStack;", "effects", "", "Lnet/minecraft/potion/PotionEffect;", "armor", "([Lnet/minecraft/potion/PotionEffect;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;", "Thaumic Arcana"}
)
public final class SlimuimArmorKt {
   @NotNull
   public static final ItemStack makeInfusedArmor(@NotNull PotionEffect[] effects, @NotNull ItemStack armor) {
      Intrinsics.checkParameterIsNotNull(effects, "effects");
      Intrinsics.checkParameterIsNotNull(armor, "armor");
      PotionEffect[] var4 = effects;
      Collection destination$iv$iv = (Collection)(new ArrayList(effects.length));

      for(Object item$iv$iv : effects) {
         PotionEffect var14 = new PotionEffect(((PotionEffect)item$iv$iv).func_188419_a(), ((PotionEffect)item$iv$iv).func_76459_b() * 5, ((PotionEffect)item$iv$iv).func_76458_c());
         destination$iv$iv.add(var14);
      }

      List newEffects = (List)destination$iv$iv;
      ItemStack var10000 = PotionUtils.func_185184_a(armor, (Collection)newEffects);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "PotionUtils.appendEffects(armor, newEffects)");
      return var10000;
   }
}

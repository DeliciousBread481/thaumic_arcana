package hu.frontrider.arcana.items.tools;

import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
   d2 = {"makeInfusedTool", "Lnet/minecraft/item/ItemStack;", "effects", "", "Lnet/minecraft/potion/PotionEffect;", "tool", "([Lnet/minecraft/potion/PotionEffect;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;", "Thaumic Arcana"}
)
public final class InfusedSlimiumKt {
   @NotNull
   public static final ItemStack makeInfusedTool(@NotNull PotionEffect[] effects, @NotNull ItemStack tool) {
      Intrinsics.checkParameterIsNotNull(effects, "effects");
      Intrinsics.checkParameterIsNotNull(tool, "tool");
      ItemStack var10000 = PotionUtils.func_185184_a(tool, (Collection)CollectionsKt.mutableListOf((PotionEffect[])Arrays.copyOf(effects, effects.length)));
      Intrinsics.checkExpressionValueIsNotNull(var10000, "PotionUtils.appendEffect… mutableListOf(*effects))");
      return var10000;
   }
}

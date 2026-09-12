package hu.frontrider.arcana.items.tools;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.FoodStats;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"},
   d2 = {"leech", "", "playerIn", "Lnet/minecraft/entity/player/EntityPlayer;", "stack", "Lnet/minecraft/item/ItemStack;", "Thaumic Arcana"}
)
public final class LiviumKt {
   private static final boolean leech(EntityPlayer playerIn, ItemStack stack) {
      FoodStats foodStats = playerIn.func_71024_bL();
      Intrinsics.checkExpressionValueIsNotNull(foodStats, "foodStats");
      int foodLevel = foodStats.func_75116_a();
      if (foodLevel <= 10) {
         return false;
      } else if (stack.func_77952_i() + 25 > stack.func_77958_k()) {
         return false;
      } else {
         foodStats.func_75114_a(foodStats.func_75116_a() - 10);
         playerIn.func_70690_d(new PotionEffect(MobEffects.field_76438_s, 200, 3));
         stack.func_77964_b(stack.func_77952_i() - 25);
         return true;
      }
   }

   // $FF: synthetic method
   public static final boolean access$leech(@NotNull EntityPlayer playerIn, @NotNull ItemStack stack) {
      return leech(playerIn, stack);
   }
}

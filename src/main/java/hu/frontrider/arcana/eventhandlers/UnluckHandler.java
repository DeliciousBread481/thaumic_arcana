package hu.frontrider.arcana.eventhandlers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"},
   d2 = {"Lhu/frontrider/arcana/eventhandlers/UnluckHandler;", "", "()V", "damage", "", "event", "Lnet/minecraftforge/event/entity/living/LivingHurtEvent;", "Thaumic Arcana"}
)
public final class UnluckHandler {
   @SubscribeEvent
   public final void damage(@NotNull LivingHurtEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      DamageSource var10000 = event.getSource();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "event.source");
      Entity trueSource = var10000.func_76346_g();
      if (trueSource instanceof EntityLiving) {
         PotionEffect unluck = ((EntityLiving)trueSource).func_70660_b(MobEffects.field_189112_A);
         if (unluck != null) {
            int amplifier = unluck.func_76458_c();
            if (trueSource.field_70170_p.field_73012_v.nextBoolean()) {
               event.setAmount(event.getAmount() / (float)amplifier);
            }
         }
      }

      PotionEffect unluck = event.getEntityLiving().func_70660_b(MobEffects.field_189112_A);
      if (unluck != null) {
         int amplifier = unluck.func_76458_c();
         if (event.getEntityLiving().field_70170_p.field_73012_v.nextBoolean()) {
            event.setAmount(event.getAmount() * (float)amplifier);
         }
      }

   }
}

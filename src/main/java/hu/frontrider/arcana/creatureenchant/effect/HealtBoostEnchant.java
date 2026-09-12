package hu.frontrider.arcana.creatureenchant.effect;

import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EffectEnchantBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/effect/HealtBoostEnchant;", "Lhu/frontrider/arcana/creatureenchant/EffectEnchantBase;", "()V", "research", "", "getResearch", "()Ljava/lang/String;", "formula", "Lthaumcraft/api/aspects/AspectList;", "tick", "", "event", "Lnet/minecraftforge/event/entity/living/LivingEvent$LivingUpdateEvent;", "Companion", "Thaumic Arcana"}
)
public final class HealtBoostEnchant extends EffectEnchantBase {
   @ObjectHolder("thaumic_arcana:protection")
   @NotNull
   public static CreatureEnchant protection;
   @ObjectHolder("thaumic_arcana:speed")
   @NotNull
   public static CreatureEnchant speed;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @NotNull
   public String getResearch() {
      return "CREATURE_ENCHANT_ADVANCED2";
   }

   @SubscribeEvent
   public void tick(@NotNull LivingEvent.LivingUpdateEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      super.tick(event);
      EntityLivingBase entity = event.getEntityLiving();
      Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
      CreatureEnchant var10002 = protection;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("protection");
      }

      int enchantLevel = this.getEnchantLevel(entity, var10002);
      var10002 = speed;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("speed");
      }

      int speedLevel = this.getEnchantLevel(entity, var10002);
      int thisLevel = this.getEnchantLevel(entity, this);
      if (thisLevel != 0) {
         if (speedLevel > 0 && thisLevel != 0) {
            label41: {
               if (entity.func_70660_b(MobEffects.field_76438_s) != null) {
                  PotionEffect var10000 = entity.func_70660_b(MobEffects.field_76438_s);
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  Intrinsics.checkExpressionValueIsNotNull(var10000, "entity.getActivePotionEffect(MobEffects.HUNGER)!!");
                  if (var10000.func_76459_b() >= 30) {
                     break label41;
                  }
               }

               entity.func_70690_d(new PotionEffect(MobEffects.field_76438_s, 240, speedLevel * 3, true, false));
            }
         }

         if (enchantLevel > 0 && thisLevel != 0) {
            if (entity.func_70660_b(MobEffects.field_82731_v) != null) {
               PotionEffect var6 = entity.func_70660_b(MobEffects.field_82731_v);
               if (var6 == null) {
                  Intrinsics.throwNpe();
               }

               Intrinsics.checkExpressionValueIsNotNull(var6, "entity.getActivePotionEffect(MobEffects.WITHER)!!");
               if (var6.func_76459_b() >= 30) {
                  return;
               }
            }

            entity.func_70690_d(new PotionEffect(MobEffects.field_82731_v, 240, enchantLevel, true, false));
         }

      }
   }

   @NotNull
   public AspectList formula() {
      AspectList var10000 = (new AspectList()).merge(Aspect.LIFE, 600).merge(Aspect.ORDER, 150).merge(Aspect.MAGIC, 300);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "AspectList().merge(Aspec… .merge(Aspect.MAGIC,300)");
      return var10000;
   }

   public HealtBoostEnchant() {
      Potion var10001 = MobEffects.field_180152_w;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "MobEffects.HEALTH_BOOST");
      Potion var10002 = MobEffects.field_180152_w;
      Intrinsics.checkExpressionValueIsNotNull(var10002, "MobEffects.HEALTH_BOOST");
      super(var10001, var10002, (double)-2.0F, new ResourceLocation("thaumic_arcana", "health_boost"), "health_boost");
   }

   // $FF: synthetic method
   @NotNull
   public static final CreatureEnchant access$getProtection$cp() {
      CreatureEnchant var10000 = protection;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("protection");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final CreatureEnchant access$getSpeed$cp() {
      CreatureEnchant var10000 = speed;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("speed");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"},
      d2 = {"Lhu/frontrider/arcana/creatureenchant/effect/HealtBoostEnchant$Companion;", "", "()V", "protection", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "getProtection", "()Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "setProtection", "(Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;)V", "speed", "getSpeed", "setSpeed", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final CreatureEnchant getProtection() {
         return HealtBoostEnchant.access$getProtection$cp();
      }

      public final void setProtection(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         HealtBoostEnchant.protection = var1;
      }

      @NotNull
      public final CreatureEnchant getSpeed() {
         return HealtBoostEnchant.access$getSpeed$cp();
      }

      public final void setSpeed(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         HealtBoostEnchant.speed = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

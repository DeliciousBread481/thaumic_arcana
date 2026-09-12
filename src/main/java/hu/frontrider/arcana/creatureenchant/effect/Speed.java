package hu.frontrider.arcana.creatureenchant.effect;

import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0007R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/effect/Speed;", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "()V", "research", "", "getResearch", "()Ljava/lang/String;", "fall", "", "event", "Lnet/minecraftforge/event/entity/living/LivingFallEvent;", "formula", "Lthaumcraft/api/aspects/AspectList;", "tick", "Lnet/minecraftforge/event/entity/living/LivingEvent$LivingUpdateEvent;", "Companion", "Thaumic Arcana"}
)
public final class Speed extends CreatureEnchant {
   @ObjectHolder("thaumic_arcana:protection")
   @NotNull
   public static CreatureEnchant protection;
   @ObjectHolder("thaumic_arcana:strength")
   @NotNull
   public static CreatureEnchant strength;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @NotNull
   public String getResearch() {
      return "CREATURE_ENCHANT_ADVANCED";
   }

   @SubscribeEvent
   public final void tick(@NotNull LivingEvent.LivingUpdateEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityLivingBase entity = event.getEntityLiving();
      Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
      CreatureEnchant var10002 = protection;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("protection");
      }

      int enchantLevel = this.getEnchantLevel(entity, var10002);
      float thisLevel = (float)this.getEnchantLevel(entity, this) * 1.6F;
      if (thisLevel > (float)0) {
         float var5 = entity.field_191988_bg;
         if (Math.abs(var5) > (float)0) {
            entity.field_191988_bg *= thisLevel;
         }
      } else {
         float var6 = entity.field_191988_bg;
         if (Math.abs(var6) > (float)0) {
            entity.field_191988_bg /= thisLevel;
         }
      }

      if (enchantLevel != 0 && thisLevel != 0.0F) {
         Potion effect = MobEffects.field_76438_s;
         if (entity.func_70660_b(effect) != null) {
            PotionEffect var10000 = entity.func_70660_b(effect);
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            Intrinsics.checkExpressionValueIsNotNull(var10000, "entity.getActivePotionEffect(effect)!!");
            if (var10000.func_76459_b() >= 30) {
               return;
            }
         }

         entity.func_70690_d(new PotionEffect(effect, 240, enchantLevel - 1, true, false));
      }

   }

   @SubscribeEvent
   public final void fall(@NotNull LivingFallEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityLivingBase entityLiving = event.getEntityLiving();
      Intrinsics.checkExpressionValueIsNotNull(entityLiving, "entityLiving");
      int thisLevel = this.getEnchantLevel(entityLiving, this);
      CreatureEnchant var10002 = strength;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("strength");
      }

      int strengthLevel = this.getEnchantLevel(entityLiving, var10002);
      if (thisLevel > 0 && strengthLevel > 0) {
         event.setDamageMultiplier(event.getDamageMultiplier() * (float)thisLevel);
      }

   }

   @NotNull
   public AspectList formula() {
      AspectList var10000 = (new AspectList()).merge(Aspect.SENSES, 20).merge(Aspect.ENERGY, 100).merge(Aspect.MAGIC, 20);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "AspectList()\n           … .merge(Aspect.MAGIC, 20)");
      return var10000;
   }

   public Speed() {
      super(new ResourceLocation("thaumic_arcana", "speed"), "speed");
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
   public static final CreatureEnchant access$getStrength$cp() {
      CreatureEnchant var10000 = strength;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("strength");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"},
      d2 = {"Lhu/frontrider/arcana/creatureenchant/effect/Speed$Companion;", "", "()V", "protection", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "getProtection", "()Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "setProtection", "(Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;)V", "strength", "getStrength", "setStrength", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final CreatureEnchant getProtection() {
         return Speed.access$getProtection$cp();
      }

      public final void setProtection(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         Speed.protection = var1;
      }

      @NotNull
      public final CreatureEnchant getStrength() {
         return Speed.access$getStrength$cp();
      }

      public final void setStrength(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         Speed.strength = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

package hu.frontrider.arcana.creatureenchant.effect;

import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EffectEnchantBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
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
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/effect/AgilityEnchant;", "Lhu/frontrider/arcana/creatureenchant/EffectEnchantBase;", "()V", "research", "", "getResearch", "()Ljava/lang/String;", "fall", "", "event", "Lnet/minecraftforge/event/entity/living/LivingFallEvent;", "formula", "Lthaumcraft/api/aspects/AspectList;", "Companion", "Thaumic Arcana"}
)
public final class AgilityEnchant extends EffectEnchantBase {
   @ObjectHolder("thaumic_arcana:protection")
   @NotNull
   public static CreatureEnchant protection;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @NotNull
   public String getResearch() {
      return "CREATURE_ENCHANT_ADVANCED2";
   }

   @SubscribeEvent
   public final void fall(@NotNull LivingFallEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityLivingBase entityLiving = event.getEntityLiving();
      Intrinsics.checkExpressionValueIsNotNull(entityLiving, "entityLiving");
      int thisLevel = this.getEnchantLevel(entityLiving, this);
      CreatureEnchant var10002 = protection;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("protection");
      }

      int protLevel = this.getEnchantLevel(entityLiving, var10002);
      if (thisLevel > 0 && protLevel == 0) {
         event.setDamageMultiplier(0.0F);
      }

   }

   @NotNull
   public AspectList formula() {
      AspectList var10000 = (new AspectList()).merge(Aspect.FLIGHT, 200).merge(Aspect.EARTH, 100).merge(Aspect.MOTION, 50).merge(Aspect.ENTROPY, 50);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "AspectList().merge(Aspec….merge(Aspect.ENTROPY,50)");
      return var10000;
   }

   public AgilityEnchant() {
      Potion var10001 = MobEffects.field_76430_j;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "MobEffects.JUMP_BOOST");
      Potion var10002 = MobEffects.field_76430_j;
      Intrinsics.checkExpressionValueIsNotNull(var10002, "MobEffects.JUMP_BOOST");
      super(var10001, var10002, (double)-2.0F, new ResourceLocation("thaumic_arcana", "agility"), "agility");
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

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"},
      d2 = {"Lhu/frontrider/arcana/creatureenchant/effect/AgilityEnchant$Companion;", "", "()V", "protection", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "getProtection", "()Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "setProtection", "(Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;)V", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final CreatureEnchant getProtection() {
         return AgilityEnchant.access$getProtection$cp();
      }

      public final void setProtection(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         AgilityEnchant.protection = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

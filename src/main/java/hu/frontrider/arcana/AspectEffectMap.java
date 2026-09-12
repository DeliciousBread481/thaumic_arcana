package hu.frontrider.arcana;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.aspects.Aspect;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010 \u001a\u00020!R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001e\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001e\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006#"},
   d2 = {"Lhu/frontrider/arcana/AspectEffectMap;", "", "()V", "blurredVision", "Lnet/minecraft/potion/Potion;", "getBlurredVision", "()Lnet/minecraft/potion/Potion;", "setBlurredVision", "(Lnet/minecraft/potion/Potion;)V", "deathGaze", "getDeathGaze", "setDeathGaze", "infectiousVisExhaust", "getInfectiousVisExhaust", "setInfectiousVisExhaust", "map", "", "Lthaumcraft/api/aspects/Aspect;", "Lhu/frontrider/arcana/AspectEffectMap$EffectEntry;", "getMap", "()Ljava/util/Map;", "setMap", "(Ljava/util/Map;)V", "sunScorned", "getSunScorned", "setSunScorned", "thaumarhia", "getThaumarhia", "setThaumarhia", "unnaturalHunger", "getUnnaturalHunger", "setUnnaturalHunger", "init", "", "EffectEntry", "Thaumic Arcana"}
)
public final class AspectEffectMap {
   @ObjectHolder("thaumcraft:sunScorned")
   @NotNull
   public static Potion sunScorned;
   @ObjectHolder("thaumcraft:thaumarhia")
   @NotNull
   public static Potion thaumarhia;
   @ObjectHolder("thaumcraft:infectiousVisExhaust")
   @NotNull
   public static Potion infectiousVisExhaust;
   @ObjectHolder("thaumcraft:blurredVision")
   @NotNull
   public static Potion blurredVision;
   @ObjectHolder("thaumcraft:deathGaze")
   @NotNull
   public static Potion deathGaze;
   @ObjectHolder("thaumcraft:unnaturalHunger")
   @NotNull
   public static Potion unnaturalHunger;
   @NotNull
   public static Map<Aspect, EffectEntry> map;
   public static final AspectEffectMap INSTANCE;

   @NotNull
   public final Potion getSunScorned() {
      Potion var10000 = sunScorned;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("sunScorned");
      }

      return var10000;
   }

   public final void setSunScorned(@NotNull Potion var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      sunScorned = var1;
   }

   @NotNull
   public final Potion getThaumarhia() {
      Potion var10000 = thaumarhia;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("thaumarhia");
      }

      return var10000;
   }

   public final void setThaumarhia(@NotNull Potion var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      thaumarhia = var1;
   }

   @NotNull
   public final Potion getInfectiousVisExhaust() {
      Potion var10000 = infectiousVisExhaust;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infectiousVisExhaust");
      }

      return var10000;
   }

   public final void setInfectiousVisExhaust(@NotNull Potion var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      infectiousVisExhaust = var1;
   }

   @NotNull
   public final Potion getBlurredVision() {
      Potion var10000 = blurredVision;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("blurredVision");
      }

      return var10000;
   }

   public final void setBlurredVision(@NotNull Potion var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      blurredVision = var1;
   }

   @NotNull
   public final Potion getDeathGaze() {
      Potion var10000 = deathGaze;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deathGaze");
      }

      return var10000;
   }

   public final void setDeathGaze(@NotNull Potion var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      deathGaze = var1;
   }

   @NotNull
   public final Potion getUnnaturalHunger() {
      Potion var10000 = unnaturalHunger;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("unnaturalHunger");
      }

      return var10000;
   }

   public final void setUnnaturalHunger(@NotNull Potion var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      unnaturalHunger = var1;
   }

   @NotNull
   public final Map<Aspect, EffectEntry> getMap() {
      Map var10000 = map;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("map");
      }

      return var10000;
   }

   public final void setMap(@NotNull Map<Aspect, EffectEntry> var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      map = var1;
   }

   public final void init() {
      Pair[] var10000 = new Pair[27];
      Aspect var10005 = Aspect.AIR;
      Potion var10008 = MobEffects.field_76427_o;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.WATER_BREATHING");
      var10000[0] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.VOID;
      var10008 = MobEffects.field_189112_A;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.UNLUCK");
      var10000[1] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.LIGHT;
      var10008 = MobEffects.field_188423_x;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.GLOWING");
      var10000[2] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.MOTION;
      var10008 = MobEffects.field_76424_c;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.SPEED");
      var10000[3] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      Pair var10003 = new Pair;
      var10005 = Aspect.COLD;
      EffectEntry var10006 = new EffectEntry;
      var10008 = infectiousVisExhaust;
      if (var10008 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infectiousVisExhaust");
      }

      var10006.<init>(var10008, 0, 2, (DefaultConstructorMarker)null);
      var10003.<init>(var10005, var10006);
      var10000[4] = var10003;
      var10005 = Aspect.LIFE;
      var10008 = MobEffects.field_76432_h;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.INSTANT_HEALTH");
      var10000[5] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.DEATH;
      var10008 = MobEffects.field_82731_v;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.WITHER");
      var10000[6] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.ENERGY;
      var10008 = MobEffects.field_76444_x;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.ABSORPTION");
      var10000[7] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.EXCHANGE;
      var10008 = MobEffects.field_76430_j;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.JUMP_BOOST");
      var10000[8] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.MAGIC;
      var10008 = MobEffects.field_180152_w;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.HEALTH_BOOST");
      var10000[9] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10003 = new Pair;
      var10005 = Aspect.AURA;
      var10006 = new EffectEntry;
      var10008 = sunScorned;
      if (var10008 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("sunScorned");
      }

      var10006.<init>(var10008, 0, 2, (DefaultConstructorMarker)null);
      var10003.<init>(var10005, var10006);
      var10000[10] = var10003;
      var10005 = Aspect.FLUX;
      var10008 = MobEffects.field_82731_v;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.WITHER");
      var10000[11] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.DARKNESS;
      var10008 = MobEffects.field_76440_q;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.BLINDNESS");
      var10000[12] = new Pair(var10005, new EffectEntry(var10008, 1000));
      var10005 = Aspect.ELDRITCH;
      var10008 = MobEffects.field_76433_i;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.INSTANT_DAMAGE");
      var10000[13] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.FLIGHT;
      var10008 = MobEffects.field_188424_y;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.LEVITATION");
      var10000[14] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.PLANT;
      var10008 = MobEffects.field_76431_k;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.NAUSEA");
      var10000[15] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.TOOL;
      var10008 = MobEffects.field_76422_e;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.HASTE");
      var10000[16] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.TRAP;
      var10008 = MobEffects.field_76421_d;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.SLOWNESS");
      var10000[17] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.SOUL;
      var10008 = MobEffects.field_76441_p;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.INVISIBILITY");
      var10000[18] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.METAL;
      var10008 = MobEffects.field_76426_n;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.FIRE_RESISTANCE");
      var10000[19] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.SENSES;
      var10008 = MobEffects.field_76439_r;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.NIGHT_VISION");
      var10000[20] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10003 = new Pair;
      var10005 = Aspect.AVERSION;
      var10006 = new EffectEntry;
      var10008 = deathGaze;
      if (var10008 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deathGaze");
      }

      var10006.<init>(var10008, 1000);
      var10003.<init>(var10005, var10006);
      var10000[21] = var10003;
      var10005 = Aspect.PROTECT;
      var10008 = MobEffects.field_76429_m;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.RESISTANCE");
      var10000[22] = new Pair(var10005, new EffectEntry(var10008, 10));
      var10005 = Aspect.DESIRE;
      var10008 = MobEffects.field_188425_z;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.LUCK");
      var10000[23] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10003 = new Pair;
      var10005 = Aspect.UNDEAD;
      var10006 = new EffectEntry;
      var10008 = unnaturalHunger;
      if (var10008 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("unnaturalHunger");
      }

      var10006.<init>(var10008, 0, 2, (DefaultConstructorMarker)null);
      var10003.<init>(var10005, var10006);
      var10000[24] = var10003;
      var10005 = Aspect.MAN;
      var10008 = MobEffects.field_76420_g;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.STRENGTH");
      var10000[25] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      var10005 = Aspect.MIND;
      var10008 = MobEffects.field_76419_f;
      Intrinsics.checkExpressionValueIsNotNull(var10008, "MobEffects.MINING_FATIGUE");
      var10000[26] = new Pair(var10005, new EffectEntry(var10008, 0, 2, (DefaultConstructorMarker)null));
      map = MapsKt.mapOf(var10000);
   }

   private AspectEffectMap() {
   }

   static {
      AspectEffectMap var0 = new AspectEffectMap();
      INSTANCE = var0;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"},
      d2 = {"Lhu/frontrider/arcana/AspectEffectMap$EffectEntry;", "", "potion", "Lnet/minecraft/potion/Potion;", "duration", "", "(Lnet/minecraft/potion/Potion;I)V", "getDuration", "()I", "getPotion", "()Lnet/minecraft/potion/Potion;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Thaumic Arcana"}
   )
   public static final class EffectEntry {
      @NotNull
      private final Potion potion;
      private final int duration;

      @NotNull
      public final Potion getPotion() {
         return this.potion;
      }

      public final int getDuration() {
         return this.duration;
      }

      public EffectEntry(@NotNull Potion potion, int duration) {
         Intrinsics.checkParameterIsNotNull(potion, "potion");
         super();
         this.potion = potion;
         this.duration = duration;
      }

      // $FF: synthetic method
      public EffectEntry(Potion var1, int var2, int var3, DefaultConstructorMarker var4) {
         if ((var3 & 2) != 0) {
            var2 = 2000;
         }

         this(var1, var2);
      }

      @NotNull
      public final Potion component1() {
         return this.potion;
      }

      public final int component2() {
         return this.duration;
      }

      @NotNull
      public final EffectEntry copy(@NotNull Potion potion, int duration) {
         Intrinsics.checkParameterIsNotNull(potion, "potion");
         return new EffectEntry(potion, duration);
      }

      // $FF: synthetic method
      @NotNull
      public static EffectEntry copy$default(EffectEntry var0, Potion var1, int var2, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.potion;
         }

         if ((var3 & 2) != 0) {
            var2 = var0.duration;
         }

         return var0.copy(var1, var2);
      }

      @NotNull
      public String toString() {
         return "EffectEntry(potion=" + this.potion + ", duration=" + this.duration + ")";
      }

      public int hashCode() {
         Potion var10000 = this.potion;
         return (var10000 != null ? var10000.hashCode() : 0) * 31 + Integer.hashCode(this.duration);
      }

      public boolean equals(@Nullable Object var1) {
         if (this != var1) {
            if (var1 instanceof EffectEntry) {
               EffectEntry var2 = (EffectEntry)var1;
               if (Intrinsics.areEqual(this.potion, var2.potion) && this.duration == var2.duration) {
                  return true;
               }
            }

            return false;
         } else {
            return true;
         }
      }
   }
}

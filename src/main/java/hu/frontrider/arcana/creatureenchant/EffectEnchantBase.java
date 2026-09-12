package hu.frontrider.arcana.creatureenchant;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/EffectEnchantBase;", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "positive", "Lnet/minecraft/potion/Potion;", "negative", "negativeMultiplier", "", "resourceLocation", "Lnet/minecraft/util/ResourceLocation;", "(Lnet/minecraft/potion/Potion;Lnet/minecraft/potion/Potion;DLnet/minecraft/util/ResourceLocation;)V", "unlocalisedName", "", "(Lnet/minecraft/potion/Potion;Lnet/minecraft/potion/Potion;DLnet/minecraft/util/ResourceLocation;Ljava/lang/String;)V", "tick", "", "event", "Lnet/minecraftforge/event/entity/living/LivingEvent$LivingUpdateEvent;", "Thaumic Arcana"}
)
public abstract class EffectEnchantBase extends CreatureEnchant {
   private final Potion positive;
   private final Potion negative;
   private final double negativeMultiplier;

   @SubscribeEvent
   public void tick(@NotNull LivingEvent.LivingUpdateEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityLivingBase entity = event.getEntityLiving();
      Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
      int enchantLevel = this.getEnchantLevel(entity, this);
      if (enchantLevel > 0) {
         label30: {
            if (entity.func_70660_b(this.positive) != null) {
               PotionEffect var10000 = entity.func_70660_b(this.positive);
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               Intrinsics.checkExpressionValueIsNotNull(var10000, "entity.getActivePotionEffect(positive)!!");
               if (var10000.func_76459_b() >= 30) {
                  break label30;
               }
            }

            entity.func_70690_d(new PotionEffect(this.positive, 240, enchantLevel - 1, true, false));
         }
      }

      if (enchantLevel < 0) {
         if (entity.func_70660_b(this.negative) != null) {
            PotionEffect var4 = entity.func_70660_b(this.negative);
            if (var4 == null) {
               Intrinsics.throwNpe();
            }

            Intrinsics.checkExpressionValueIsNotNull(var4, "entity.getActivePotionEffect(negative)!!");
            if (var4.func_76459_b() >= 30) {
               return;
            }
         }

         entity.func_70690_d(new PotionEffect(this.negative, 240, (int)((double)(enchantLevel + 1) * this.negativeMultiplier), true, false));
      }

   }

   public EffectEnchantBase(@NotNull Potion positive, @NotNull Potion negative, double negativeMultiplier, @NotNull ResourceLocation resourceLocation, @NotNull String unlocalisedName) {
      Intrinsics.checkParameterIsNotNull(positive, "positive");
      Intrinsics.checkParameterIsNotNull(negative, "negative");
      Intrinsics.checkParameterIsNotNull(resourceLocation, "resourceLocation");
      Intrinsics.checkParameterIsNotNull(unlocalisedName, "unlocalisedName");
      super(resourceLocation, unlocalisedName);
      this.positive = positive;
      this.negative = negative;
      this.negativeMultiplier = negativeMultiplier;
   }

   public EffectEnchantBase(@NotNull Potion positive, @NotNull Potion negative, double negativeMultiplier, @NotNull ResourceLocation resourceLocation) {
      Intrinsics.checkParameterIsNotNull(positive, "positive");
      Intrinsics.checkParameterIsNotNull(negative, "negative");
      Intrinsics.checkParameterIsNotNull(resourceLocation, "resourceLocation");
      String var10005 = resourceLocation.func_110623_a();
      Intrinsics.checkExpressionValueIsNotNull(var10005, "resourceLocation.resourcePath");
      this(positive, negative, negativeMultiplier, resourceLocation, var10005);
   }
}

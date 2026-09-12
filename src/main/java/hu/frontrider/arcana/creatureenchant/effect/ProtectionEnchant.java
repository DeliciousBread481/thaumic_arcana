package hu.frontrider.arcana.creatureenchant.effect;

import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/effect/ProtectionEnchant;", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "()V", "research", "", "getResearch", "()Ljava/lang/String;", "entityHurt", "", "event", "Lnet/minecraftforge/event/entity/living/LivingHurtEvent;", "formula", "Lthaumcraft/api/aspects/AspectList;", "Thaumic Arcana"}
)
public final class ProtectionEnchant extends CreatureEnchant {
   @NotNull
   public String getResearch() {
      return "CREATURE_ENCHANT";
   }

   @SubscribeEvent
   public final void entityHurt(@NotNull LivingHurtEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityLivingBase entity = event.getEntityLiving();
      Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
      int enchantLevel = this.getEnchantLevel(entity, this);
      if (enchantLevel != 0) {
         if (enchantLevel > 0) {
            event.setAmount(event.getAmount() / (float)(enchantLevel / 2));
         }

         if (enchantLevel < 0) {
            event.setAmount(event.getAmount() * (float)(enchantLevel / 2));
         }
      }

   }

   @NotNull
   public AspectList formula() {
      AspectList var10000 = (new AspectList()).merge(Aspect.PROTECT, 100).merge(Aspect.METAL, 60).merge(Aspect.AVERSION, 10).merge(Aspect.CRYSTAL, 3).merge(Aspect.EARTH, 20).merge(Aspect.MAGIC, 70);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "AspectList()\n           … .merge(Aspect.MAGIC, 70)");
      return var10000;
   }

   public ProtectionEnchant() {
      super(new ResourceLocation("thaumic_arcana", "protection"), "protection");
   }
}

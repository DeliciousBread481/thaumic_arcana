package hu.frontrider.arcana.creatureenchant.effect;

import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0002\b\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/effect/FertileEnchant;", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "()V", "research", "", "getResearch", "()Ljava/lang/String;", "createChild", "", "parentA", "Lnet/minecraft/entity/passive/EntityAnimal;", "parentB", "createChild$Thaumic_Arcana", "formula", "Lthaumcraft/api/aspects/AspectList;", "handleEvent", "event", "Lnet/minecraftforge/event/entity/living/BabyEntitySpawnEvent;", "Thaumic Arcana"}
)
public final class FertileEnchant extends CreatureEnchant {
   @NotNull
   public String getResearch() {
      return "CREATURE_ENCHANT";
   }

   @SubscribeEvent
   public final void handleEvent(@NotNull BabyEntitySpawnEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      if (event.getParentA() instanceof EntityAnimal && event.getParentB() instanceof EntityAnimal) {
         EntityLiving var10000 = event.getParentA();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.passive.EntityAnimal");
         }

         EntityAnimal parentA = (EntityAnimal)var10000;
         var10000 = event.getParentB();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.passive.EntityAnimal");
         }

         EntityAnimal parentB = (EntityAnimal)var10000;
         int parentAlevel = this.getEnchantLevel((EntityLivingBase)parentA, this);
         if (parentAlevel > 0) {
            this.createChild$Thaumic_Arcana(parentA, parentB);
         } else if (parentA.func_130014_f_().field_73012_v.nextBoolean() && parentAlevel < 0) {
            event.setCanceled(true);
         }

         int parentBlevel = this.getEnchantLevel((EntityLivingBase)parentB, this);
         if (parentBlevel > 0) {
            this.createChild$Thaumic_Arcana(parentB, parentA);
         } else if (parentB.func_130014_f_().field_73012_v.nextBoolean() && parentBlevel < 0) {
            event.setCanceled(true);
         }
      }

   }

   @NotNull
   public AspectList formula() {
      AspectList var10000 = (new AspectList()).merge(Aspect.LIFE, 20).merge(Aspect.DESIRE, 30).merge(Aspect.FIRE, 5).merge(Aspect.ORDER, 3).merge(Aspect.EXCHANGE, 20).merge(Aspect.MAGIC, 50);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "AspectList()\n           … .merge(Aspect.MAGIC, 50)");
      return var10000;
   }

   public final void createChild$Thaumic_Arcana(@NotNull EntityAnimal parentA, @NotNull EntityAnimal parentB) {
      Intrinsics.checkParameterIsNotNull(parentA, "parentA");
      Intrinsics.checkParameterIsNotNull(parentB, "parentB");
      EntityAgeable child = parentA.func_90011_a((EntityAgeable)parentB);
      if (child == null) {
         Intrinsics.throwNpe();
      }

      child.func_70107_b(parentA.field_70165_t, parentA.field_70163_u, parentA.field_70161_v);
      child.func_70873_a(-24000);
      parentA.field_70170_p.func_72838_d((Entity)child);
   }

   public FertileEnchant() {
      super(new ResourceLocation("thaumic_arcana", "fertile"), "fertile");
   }
}

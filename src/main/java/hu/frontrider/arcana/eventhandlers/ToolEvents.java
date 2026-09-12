package hu.frontrider.arcana.eventhandlers;

import hu.frontrider.arcana.util.IInfuseable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"},
   d2 = {"Lhu/frontrider/arcana/eventhandlers/ToolEvents;", "", "()V", "revivalCapsuleEvent", "", "event", "Lnet/minecraftforge/event/entity/living/LivingHurtEvent;", "toolPotionAttackEvent", "Companion", "Thaumic Arcana"}
)
public final class ToolEvents {
   @ObjectHolder("thaumic_arcana:revival_capsule")
   @NotNull
   public static Item revivalCapsule;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @SubscribeEvent
   public final void toolPotionAttackEvent(@NotNull LivingHurtEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      DamageSource var10000 = event.getSource();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "event.source");
      Entity trueSource = var10000.func_76346_g();
      Entity entity = event.getEntity();
      if (trueSource != null && trueSource instanceof EntityLivingBase && entity instanceof EntityLivingBase) {
         ItemStack var14 = ((EntityLivingBase)trueSource).func_184614_ca();
         Intrinsics.checkExpressionValueIsNotNull(var14, "trueSource.heldItemMainhand");
         if (var14.func_77973_b() instanceof IInfuseable) {
            List effectsFromStack = PotionUtils.func_185189_a(((EntityLivingBase)trueSource).func_184614_ca());
            ArrayList newEffects = new ArrayList();
            Intrinsics.checkExpressionValueIsNotNull(effectsFromStack, "effectsFromStack");

            for(Object element$iv : (Iterable)effectsFromStack) {
               PotionEffect it = (PotionEffect)element$iv;
               Intrinsics.checkExpressionValueIsNotNull(it, "it");
               int duration = it.func_76459_b() - 120;
               PotionEffect var15;
               if (duration > 0) {
                  newEffects.add(new PotionEffect(it.func_188419_a(), duration, it.func_76458_c()));
                  var15 = new PotionEffect(it.func_188419_a(), 120, it.func_76458_c());
               } else {
                  var15 = new PotionEffect(it.func_188419_a(), 120 + duration, it.func_76458_c());
               }

               PotionEffect potionEffect = var15;
               ((EntityLivingBase)entity).func_70690_d(potionEffect);
            }

            PotionUtils.func_185184_a(((EntityLivingBase)trueSource).func_184614_ca(), (Collection)newEffects);
         }
      }

   }

   @SubscribeEvent
   public final void revivalCapsuleEvent(@NotNull LivingHurtEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      LivingHurtEvent $receiver = event;
      EntityLivingBase var10000 = event.getEntityLiving();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "entityLiving");
      if (!(var10000.func_110143_aJ() > event.getAmount())) {
         if (event.getEntityLiving().hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (EnumFacing)null)) {
            Object var12 = event.getEntityLiving().getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (EnumFacing)null);
            if (var12 == null) {
               Intrinsics.throwNpe();
            }

            Intrinsics.checkExpressionValueIsNotNull(var12, "entityLiving.getCapabili…NDLER_CAPABILITY, null)!!");
            IItemHandler capability = (IItemHandler)var12;
            int i = 0;

            for(int var6 = capability.getSlots(); i < var6; ++i) {
               ItemStack var13 = capability.getStackInSlot(i);
               Intrinsics.checkExpressionValueIsNotNull(var13, "capability.getStackInSlot(i)");
               ItemStack stackInSlot = var13;
               Item var14 = stackInSlot.func_77973_b();
               Item var10001 = revivalCapsule;
               if (var10001 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("revivalCapsule");
               }

               if (Intrinsics.areEqual(var14, var10001)) {
                  capability.extractItem(i, 1, false);
                  EntityLivingBase $receiver = $receiver.getEntityLiving();
                  $receiver.func_70690_d(new PotionEffect(MobEffects.field_76428_l, 500, 3));
                  $receiver.func_70690_d(new PotionEffect(MobEffects.field_76429_m, 100, 3));
                  $receiver.func_70690_d(new PotionEffect(MobEffects.field_76427_o, 300, 1));
               }
            }

         }
      }
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getRevivalCapsule$cp() {
      Item var10000 = revivalCapsule;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("revivalCapsule");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"},
      d2 = {"Lhu/frontrider/arcana/eventhandlers/ToolEvents$Companion;", "", "()V", "revivalCapsule", "Lnet/minecraft/item/Item;", "getRevivalCapsule", "()Lnet/minecraft/item/Item;", "setRevivalCapsule", "(Lnet/minecraft/item/Item;)V", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final Item getRevivalCapsule() {
         return ToolEvents.access$getRevivalCapsule$cp();
      }

      public final void setRevivalCapsule(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ToolEvents.revivalCapsule = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

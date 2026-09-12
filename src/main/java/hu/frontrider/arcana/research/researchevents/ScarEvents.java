package hu.frontrider.arcana.research.researchevents;

import hu.frontrider.arcana.capabilities.scar.IScarred;
import hu.frontrider.arcana.capabilities.scar.ScarProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.capabilities.IPlayerKnowledge;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0007¨\u0006\t"},
   d2 = {"Lhu/frontrider/arcana/research/researchevents/ScarEvents;", "", "()V", "damageEvent", "", "event", "Lnet/minecraftforge/event/entity/living/LivingHurtEvent;", "tickEvent", "Lnet/minecraftforge/event/entity/living/LivingEvent$LivingUpdateEvent;", "Thaumic Arcana"}
)
public final class ScarEvents {
   @SubscribeEvent
   public final void damageEvent(@NotNull LivingHurtEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      Entity player = event.getEntity();
      if (player instanceof EntityPlayer) {
         Object var10000 = player.getCapability(ThaumcraftCapabilities.KNOWLEDGE, (EnumFacing)null);
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var10000, "player.getCapability(KNOWLEDGE, null)!!");
         IPlayerKnowledge knowledge = (IPlayerKnowledge)var10000;
         if (knowledge.isResearchComplete("BIOMANCY_BASICS")) {
            var10000 = player.getCapability(ScarProvider.Companion.getSCARRED_CAPABILITY(), (EnumFacing)null);
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            Intrinsics.checkExpressionValueIsNotNull(var10000, "player.getCapability(Sca…ARRED_CAPABILITY, null)!!");
            IScarred var4 = (IScarred)var10000;
         }
      }

   }

   @SubscribeEvent
   public final void tickEvent(@NotNull LivingEvent.LivingUpdateEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      Entity player = event.getEntity();
   }
}

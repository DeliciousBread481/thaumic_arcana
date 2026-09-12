package hu.frontrider.arcana.entity.inhibitor;

import hu.frontrider.arcana.api.InhibitorAiWrapper;
import hu.frontrider.arcana.capabilities.inhibitor.IInhibitor;
import hu.frontrider.arcana.capabilities.inhibitor.InhibitorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"},
   d2 = {"Lhu/frontrider/arcana/entity/inhibitor/InhibitorEvents;", "", "()V", "joinWorld", "", "event", "Lnet/minecraftforge/event/entity/EntityJoinWorldEvent;", "Thaumic Arcana"}
)
public final class InhibitorEvents {
   @SubscribeEvent
   public final void joinWorld(@NotNull EntityJoinWorldEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      Entity var2 = event.getEntity();
      Entity $receiver = var2;
      if (var2 instanceof EntityCreature && var2.hasCapability(InhibitorProvider.Companion.getINHIBITOR_CAPABILITY(), (EnumFacing)null)) {
         Object var10000 = var2.getCapability(InhibitorProvider.Companion.getINHIBITOR_CAPABILITY(), (EnumFacing)null);
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var10000, "getCapability(InhibitorP…BITOR_CAPABILITY, null)!!");
         IInhibitor capability = (IInhibitor)var10000;
         if (capability.getInhibited()) {
            ((EntityCreature)var2).field_70714_bg.field_75782_a.clear();
         }

         for(Object element$iv : (Iterable)capability.getAiList()) {
            InhibitorAiWrapper it = (InhibitorAiWrapper)element$iv;
            ((EntityCreature)$receiver).field_70714_bg.func_75776_a(it.getPriority(), it.get((EntityCreature)$receiver));
         }
      }

   }
}

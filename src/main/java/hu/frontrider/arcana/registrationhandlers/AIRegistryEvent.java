package hu.frontrider.arcana.registrationhandlers;

import hu.frontrider.arcana.api.InhibitorAIRegistryEvent;
import hu.frontrider.arcana.api.InhibitorAiWrapper;
import hu.frontrider.arcana.entity.inhibitor.ai.EntityAIAttackMeleeWrapper;
import hu.frontrider.arcana.entity.inhibitor.ai.EntityAIBreakDoorWrapper;
import hu.frontrider.arcana.entity.inhibitor.ai.EntityAIOpenAndCloseDoorWrapper;
import hu.frontrider.arcana.entity.inhibitor.ai.EntityAIOpenDoorWrapper;
import hu.frontrider.arcana.entity.inhibitor.ai.EntityAIPanicWrapper;
import hu.frontrider.arcana.entity.inhibitor.ai.EntityAIWanderWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/AIRegistryEvent;", "", "()V", "register", "", "aiRegistryEvent", "Lhu/frontrider/arcana/api/InhibitorAIRegistryEvent;", "Thaumic Arcana"}
)
public final class AIRegistryEvent {
   @SubscribeEvent
   public final void register(@NotNull InhibitorAIRegistryEvent aiRegistryEvent) {
      Intrinsics.checkParameterIsNotNull(aiRegistryEvent, "aiRegistryEvent");
      aiRegistryEvent.register(new InhibitorAiWrapper[]{new EntityAIAttackMeleeWrapper((double)3.0F), new EntityAIBreakDoorWrapper(), new EntityAIWanderWrapper((double)3.0F, 10), new EntityAIPanicWrapper((double)5.0F), new EntityAIOpenDoorWrapper(), new EntityAIOpenAndCloseDoorWrapper()});
   }
}

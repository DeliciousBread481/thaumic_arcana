package hu.frontrider.arcana.research;

import hu.frontrider.arcana.research.researchevents.PlantExperiments;
import hu.frontrider.arcana.research.researchevents.StartingFires;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"},
   d2 = {"Lhu/frontrider/arcana/research/ResearchEventManager;", "", "()V", "initHandlers", "", "registerhandler", "handler", "registerhandler$Thaumic_Arcana", "Thaumic Arcana"}
)
public final class ResearchEventManager {
   public final void initHandlers() {
      this.registerhandler$Thaumic_Arcana(new StartingFires());
      this.registerhandler$Thaumic_Arcana(new PlantExperiments());
   }

   public final void registerhandler$Thaumic_Arcana(@NotNull Object handler) {
      Intrinsics.checkParameterIsNotNull(handler, "handler");
      MinecraftForge.EVENT_BUS.register(handler);
   }
}

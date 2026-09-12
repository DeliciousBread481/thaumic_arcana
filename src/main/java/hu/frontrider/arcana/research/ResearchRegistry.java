package hu.frontrider.arcana.research;

import hu.frontrider.arcana.research.theory.AidTable;
import hu.frontrider.arcana.research.theory.CardDissect;
import hu.frontrider.arcana.research.theory.CardDissectDead;
import hu.frontrider.arcana.research.theory.CardGrow;
import hu.frontrider.arcana.research.theory.TheoryRegistry;
import kotlin.Metadata;
import net.minecraft.entity.passive.EntityAnimal;
import thaumcraft.api.research.IScanThing;
import thaumcraft.api.research.ScanEntity;
import thaumcraft.api.research.ScanningManager;
import thaumcraft.api.research.theorycraft.TheorycraftManager;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002¨\u0006\b"},
   d2 = {"Lhu/frontrider/arcana/research/ResearchRegistry;", "", "()V", "init", "", "initResearch", "initScans", "initTheories", "Thaumic Arcana"}
)
public final class ResearchRegistry {
   public final void init() {
      (new TheoryRegistry()).init();
      this.initTheories();
      this.initScans();
   }

   private final void initTheories() {
      TheorycraftManager.registerAid(new AidTable());
      TheorycraftManager.registerCard(CardGrow.class);
      TheorycraftManager.registerCard(CardDissect.class);
      TheorycraftManager.registerCard(CardDissectDead.class);
   }

   private final void initScans() {
      ScanningManager.addScannableThing((IScanThing)(new ScanEntity("FLESH_GROWTH", EntityAnimal.class, true)));
   }

   private final void initResearch() {
   }
}

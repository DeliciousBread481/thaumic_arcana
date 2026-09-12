package hu.frontrider.arcana.research.theory;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import thaumcraft.api.research.theorycraft.ITheorycraftAid;
import thaumcraft.api.research.theorycraft.TheorycraftCard;

public class AidTable implements ITheorycraftAid {
   @ObjectHolder("thaumic_arcana:experiment_table")
   private static Block experiment_table = null;

   public Object getAidObject() {
      return experiment_table;
   }

   public Class<TheorycraftCard>[] getCards() {
      return new Class[]{CardGrow.class, CardDissect.class, CardDissectDead.class, CardGrow.class, CardDissect.class, CardGrow.class, CardDissectDead.class, CardGrow.class, CardDissect.class, CardGrow.class};
   }
}

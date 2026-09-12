package hu.frontrider.arcana.api;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ResourceLocation;

public interface InhibitorAiWrapper {
   ResourceLocation getID();

   EntityAIBase get(EntityCreature var1);

   default int getPriority() {
      return 1;
   }
}

package hu.frontrider.arcana.registrationhandlers;

import hu.frontrider.arcana.casters.DisableEnchants;
import hu.frontrider.arcana.casters.EnableEnchants;
import kotlin.Metadata;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.casters.FocusEngine;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/FocusRegistry;", "", "()V", "init", "", "Thaumic Arcana"}
)
public final class FocusRegistry {
   public final void init() {
      FocusEngine.registerElement(DisableEnchants.class, new ResourceLocation("thaumic_arcana", "textures/cenchant/modifier/disable.png"), 8388736);
      FocusEngine.registerElement(EnableEnchants.class, new ResourceLocation("thaumic_arcana", "textures/cenchant/modifier/enable.png"), 16761087);
   }
}

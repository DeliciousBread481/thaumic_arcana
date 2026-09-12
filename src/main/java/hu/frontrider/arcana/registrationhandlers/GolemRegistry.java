package hu.frontrider.arcana.registrationhandlers;

import hu.frontrider.arcana.entity.golems.MaterialFlesh;
import hu.frontrider.arcana.entity.golems.MaterialHay;
import hu.frontrider.arcana.entity.golems.MaterialLeather;
import hu.frontrider.arcana.entity.golems.MaterialSlime;
import kotlin.Metadata;
import thaumcraft.api.golems.parts.GolemMaterial;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/GolemRegistry;", "", "()V", "init", "", "Thaumic Arcana"}
)
public final class GolemRegistry {
   public final void init() {
      GolemMaterial.register(new MaterialFlesh());
      GolemMaterial.register(new MaterialHay());
      GolemMaterial.register(new MaterialSlime());
      GolemMaterial.register(new MaterialLeather());
   }
}

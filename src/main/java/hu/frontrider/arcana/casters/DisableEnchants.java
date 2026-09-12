package hu.frontrider.arcana.casters;

import hu.frontrider.arcana.casters.backend.SetEnchantStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import thaumcraft.api.aspects.Aspect;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
   d2 = {"Lhu/frontrider/arcana/casters/DisableEnchants;", "Lhu/frontrider/arcana/casters/backend/SetEnchantStatus;", "()V", "Thaumic Arcana"}
)
public final class DisableEnchants extends SetEnchantStatus {
   public DisableEnchants() {
      Aspect var10002 = Aspect.FLUX;
      Intrinsics.checkExpressionValueIsNotNull(var10002, "Aspect.FLUX");
      boolean var1 = false;
      String var2 = "ENCHANT_FOCUS@2";
      Aspect var3 = var10002;
      String var4 = "disable_creature_enchants";
      super(var2, var4, var1, var3);
   }
}

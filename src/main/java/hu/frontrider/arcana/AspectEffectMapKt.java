package hu.frontrider.arcana;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\"!\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"},
   d2 = {"supportedAspects", "", "Lthaumcraft/api/aspects/Aspect;", "kotlin.jvm.PlatformType", "getSupportedAspects", "()[Lthaumcraft/api/aspects/Aspect;", "[Lthaumcraft/api/aspects/Aspect;", "Thaumic Arcana"}
)
public final class AspectEffectMapKt {
   @NotNull
   private static final Aspect[] supportedAspects;

   @NotNull
   public static final Aspect[] getSupportedAspects() {
      return supportedAspects;
   }

   static {
      supportedAspects = new Aspect[]{Aspect.AIR, Aspect.VOID, Aspect.LIGHT, Aspect.MOTION, Aspect.COLD, Aspect.LIFE, Aspect.DEATH, Aspect.ENERGY, Aspect.EXCHANGE, Aspect.MAGIC, Aspect.AURA, Aspect.FLUX, Aspect.DARKNESS, Aspect.ELDRITCH, Aspect.FLIGHT, Aspect.PLANT, Aspect.TOOL, Aspect.TRAP, Aspect.SOUL, Aspect.METAL, Aspect.SENSES, Aspect.AVERSION, Aspect.PROTECT, Aspect.DESIRE, Aspect.UNDEAD, Aspect.MAN, Aspect.MIND, Aspect.ALCHEMY, Aspect.ORDER, Aspect.CRAFT};
   }
}

package hu.frontrider.core.util;

import kotlin.Metadata;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0012\u0010\u0000\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0002¨\u0006\u0003"},
   d2 = {"cap", "", "", "Thaumic Arcana"}
)
public final class HelpersKt {
   public static final int cap(int $receiver, int cap) {
      return $receiver > cap ? cap : $receiver;
   }

   public static final double cap(double $receiver, double cap) {
      return $receiver > cap ? cap : $receiver;
   }
}

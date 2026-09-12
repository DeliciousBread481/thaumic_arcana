package hu.frontrider.arcana.util;

import kotlin.Metadata;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005"},
   d2 = {"convertToIntColor", "", "r", "g", "b", "Thaumic Arcana"}
)
public final class ColorsKt {
   public static final int convertToIntColor(int r, int g, int b) {
      return (int)(4278190080L | (long)((r & 255) << 16) | (long)((g & 255) << 8) | (long)(b & 255));
   }
}

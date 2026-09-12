package hu.frontrider.arcana.util.strings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"},
   d2 = {"Lhu/frontrider/arcana/util/strings/ChatFormat;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "BLACK", "DARK_BLUE", "DARK_GREEN", "DARK_AQUA", "DARK_RED", "DARK_PURPLE", "GOLD", "GRAY", "DARK_GRAY", "BLUE", "GREEN", "AQUA", "RED", "LIGHT_PURPLE", "YELLOW", "WHITE", "OBFUSCATED", "BOLD", "STRIKE_THROUGH", "UNDERLINE", "ITALIC", "RESET", "Thaumic Arcana"}
)
public enum ChatFormat {
   BLACK,
   DARK_BLUE,
   DARK_GREEN,
   DARK_AQUA,
   DARK_RED,
   DARK_PURPLE,
   GOLD,
   GRAY,
   DARK_GRAY,
   BLUE,
   GREEN,
   AQUA,
   RED,
   LIGHT_PURPLE,
   YELLOW,
   WHITE,
   OBFUSCATED,
   BOLD,
   STRIKE_THROUGH,
   UNDERLINE,
   ITALIC,
   RESET;

   @NotNull
   private final String tag;

   @NotNull
   public final String getTag() {
      return this.tag;
   }

   protected ChatFormat(@NotNull String tag) {
      Intrinsics.checkParameterIsNotNull(tag, "tag");
      super($enum_name_or_ordinal$0, $enum_name_or_ordinal$1);
      this.tag = tag;
   }
}

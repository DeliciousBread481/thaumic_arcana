package hu.frontrider.arcana.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"},
   d2 = {"add", "", "T", "", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "Thaumic Arcana"}
)
public final class ListBuilderKt {
   public static final <T> void add(@NotNull List<? extends T> $receiver, T element) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
   }
}

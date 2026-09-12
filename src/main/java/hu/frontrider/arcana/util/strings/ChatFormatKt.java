package hu.frontrider.arcana.util.strings;

import java.util.Arrays;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.resources.I18n;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0002¨\u0006\u000b"},
   d2 = {"formatString", "", "text", "formats", "", "Lhu/frontrider/arcana/util/strings/ChatFormat;", "(Ljava/lang/String;[Lhu/frontrider/arcana/util/strings/ChatFormat;)Ljava/lang/String;", "formatTranslate", "unlocalizedName", "prepend", "s", "Thaumic Arcana"}
)
public final class ChatFormatKt {
   @NotNull
   public static final String formatString(@NotNull String text, @NotNull ChatFormat... formats) {
      Intrinsics.checkParameterIsNotNull(text, "text");
      Intrinsics.checkParameterIsNotNull(formats, "formats");
      final Ref.ObjectRef text = new Ref.ObjectRef();
      text.element = text;
      ArrayIteratorKt.iterator(formats).forEachRemaining(new Consumer<ChatFormat>() {
         public final void accept(@NotNull ChatFormat it) {
            Intrinsics.checkParameterIsNotNull(it, "it");
            text.element = ChatFormatKt.prepend((String)text.element, it.getTag());
         }
      });
      return (String)text.element + ChatFormat.RESET.getTag();
   }

   private static final String prepend(@NotNull String $receiver, String s) {
      return s + $receiver;
   }

   @NotNull
   public static final String formatTranslate(@NotNull String unlocalizedName, @NotNull ChatFormat... formats) {
      Intrinsics.checkParameterIsNotNull(unlocalizedName, "unlocalizedName");
      Intrinsics.checkParameterIsNotNull(formats, "formats");
      String var10000 = I18n.func_135052_a(unlocalizedName, new Object[0]);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "I18n.format(unlocalizedName)");
      return formatString(var10000, (ChatFormat[])Arrays.copyOf(formats, formats.length));
   }
}

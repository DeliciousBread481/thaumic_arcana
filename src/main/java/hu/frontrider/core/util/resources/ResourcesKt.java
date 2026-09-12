package hu.frontrider.core.util.resources;

import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
   d2 = {"toFile", "Ljava/io/File;", "Lnet/minecraft/util/ResourceLocation;", "extension", "", "Thaumic Arcana"}
)
public final class ResourcesKt {
   @NotNull
   public static final File toFile(@NotNull ResourceLocation $receiver, @NotNull String extension) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      Intrinsics.checkParameterIsNotNull(extension, "extension");
      String path = "/assets/" + $receiver.func_110624_b() + '/' + $receiver.func_110623_a();
      CharSequence var3 = (CharSequence)extension;
      if (var3.length() > 0) {
         path = path + '.' + extension;
      }

      URL var10002 = $receiver.getClass().getResource(path);
      Intrinsics.checkExpressionValueIsNotNull(var10002, "javaClass.getResource(path)");
      return new File(var10002.getFile());
   }

   // $FF: synthetic method
   @NotNull
   public static File toFile$default(ResourceLocation var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = "";
      }

      return toFile(var0, var1);
   }
}

package hu.frontrider.core.util.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"},
   d2 = {"readToString", "", "Ljava/io/File;", "Thaumic Arcana"}
)
public final class FileKt {
   @NotNull
   public static final String readToString(@NotNull File $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      FileInputStream var5 = new FileInputStream($receiver);
      InputStream var6 = (InputStream)var5;
      Scanner scanner = new Scanner(var6);

      String result;
      for(result = ""; scanner.hasNextLine(); result = result + scanner.nextLine()) {
      }

      return result;
   }
}

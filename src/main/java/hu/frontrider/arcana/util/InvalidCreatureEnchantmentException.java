package hu.frontrider.arcana.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"},
   d2 = {"Lhu/frontrider/arcana/util/InvalidCreatureEnchantmentException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "wanted", "Lnet/minecraft/util/ResourceLocation;", "found", "(Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/util/ResourceLocation;)V", "Thaumic Arcana"}
)
public final class InvalidCreatureEnchantmentException extends RuntimeException {
   public InvalidCreatureEnchantmentException(@NotNull ResourceLocation wanted, @NotNull ResourceLocation found) {
      Intrinsics.checkParameterIsNotNull(wanted, "wanted");
      Intrinsics.checkParameterIsNotNull(found, "found");
      super("Problem while accessing creature enchants, wanted " + wanted + ", but found " + found + "this error is probably caused by an another mod!");
   }
}

package hu.frontrider.core.util.render;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"},
   d2 = {"getTexture", "Lnet/minecraft/util/ResourceLocation;", "Lnet/minecraft/item/Item;", "Thaumic Arcana"}
)
public final class ItemKt {
   @NotNull
   public static final ResourceLocation getTexture(@NotNull Item $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "receiver$0");
      ResourceLocation var10000 = $receiver.getRegistryName();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      Intrinsics.checkExpressionValueIsNotNull(var10000, "this.registryName!!");
      ResourceLocation registryName = var10000;
      String resourcePath = registryName.func_110623_a();
      return new ResourceLocation(registryName.func_110624_b(), "textures/items/" + resourcePath + ".png");
   }
}

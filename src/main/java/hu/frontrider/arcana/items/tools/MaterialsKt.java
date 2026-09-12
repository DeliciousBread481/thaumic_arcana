package hu.frontrider.arcana.items.tools;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003¨\u0006\b"},
   d2 = {"TOOL_MATERIAL_INFUSED_SLIMIUM", "Lnet/minecraft/item/Item$ToolMaterial;", "getTOOL_MATERIAL_INFUSED_SLIMIUM", "()Lnet/minecraft/item/Item$ToolMaterial;", "TOOL_MATERIAL_LIVIUM", "getTOOL_MATERIAL_LIVIUM", "TOOL_MATERIAL_SLIMIUM", "getTOOL_MATERIAL_SLIMIUM", "Thaumic Arcana"}
)
public final class MaterialsKt {
   @NotNull
   private static final Item.ToolMaterial TOOL_MATERIAL_LIVIUM;
   @NotNull
   private static final Item.ToolMaterial TOOL_MATERIAL_SLIMIUM;
   @NotNull
   private static final Item.ToolMaterial TOOL_MATERIAL_INFUSED_SLIMIUM;

   @NotNull
   public static final Item.ToolMaterial getTOOL_MATERIAL_LIVIUM() {
      return TOOL_MATERIAL_LIVIUM;
   }

   @NotNull
   public static final Item.ToolMaterial getTOOL_MATERIAL_SLIMIUM() {
      return TOOL_MATERIAL_SLIMIUM;
   }

   @NotNull
   public static final Item.ToolMaterial getTOOL_MATERIAL_INFUSED_SLIMIUM() {
      return TOOL_MATERIAL_INFUSED_SLIMIUM;
   }

   static {
      Item.ToolMaterial var10000 = EnumHelper.addToolMaterial("TA:LIVIUM", 3, 1024, 6.0F, 2.0F, 2);
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      Intrinsics.checkExpressionValueIsNotNull(var10000, "EnumHelper.addToolMateri…3, 1024, 6.0f, 2.0f, 2)!!");
      TOOL_MATERIAL_LIVIUM = var10000;
      var10000 = EnumHelper.addToolMaterial("TA:SLIMIUM", 3, 1024, 6.0F, 2.0F, 2);
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      Intrinsics.checkExpressionValueIsNotNull(var10000, "EnumHelper.addToolMateri…3, 1024, 6.0f, 2.0f, 2)!!");
      TOOL_MATERIAL_SLIMIUM = var10000;
      var10000 = EnumHelper.addToolMaterial("TA:INFUSED_SLIMIUM", 4, 1536, 8.0F, 4.0F, 1);
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      Intrinsics.checkExpressionValueIsNotNull(var10000, "EnumHelper.addToolMateri…4, 1536, 8.0f, 4.0f, 1)!!");
      TOOL_MATERIAL_INFUSED_SLIMIUM = var10000;
   }
}

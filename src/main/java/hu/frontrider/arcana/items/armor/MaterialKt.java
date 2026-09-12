package hu.frontrider.arcana.items.armor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
   d2 = {"ARMOR_MATERIAL_INFUSED_SLIME", "Lnet/minecraft/item/ItemArmor$ArmorMaterial;", "getARMOR_MATERIAL_INFUSED_SLIME", "()Lnet/minecraft/item/ItemArmor$ArmorMaterial;", "Thaumic Arcana"}
)
public final class MaterialKt {
   @NotNull
   private static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_INFUSED_SLIME;

   @NotNull
   public static final ItemArmor.ArmorMaterial getARMOR_MATERIAL_INFUSED_SLIME() {
      return ARMOR_MATERIAL_INFUSED_SLIME;
   }

   static {
      ItemArmor.ArmorMaterial var10000 = EnumHelper.addArmorMaterial("TA:INFUSED_SLIMIUM", "slimium", 1536, new int[]{3, 6, 7, 3}, 10, SoundEvents.field_187728_s, 2.0F);
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      Intrinsics.checkExpressionValueIsNotNull(var10000, "EnumHelper.addArmorMater…OR_EQUIP_LEATHER, 2.0f)!!");
      ARMOR_MATERIAL_INFUSED_SLIME = var10000;
   }
}

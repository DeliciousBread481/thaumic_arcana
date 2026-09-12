package hu.frontrider.arcana.items.armor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ2\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u0010"},
   d2 = {"Lhu/frontrider/arcana/items/armor/ArmorBase;", "Lnet/minecraft/item/ItemArmor;", "material", "Lnet/minecraft/item/ItemArmor$ArmorMaterial;", "renderindex", "", "slot", "Lnet/minecraft/inventory/EntityEquipmentSlot;", "(Lnet/minecraft/item/ItemArmor$ArmorMaterial;ILnet/minecraft/inventory/EntityEquipmentSlot;)V", "getArmorTexture", "", "stack", "Lnet/minecraft/item/ItemStack;", "entity", "Lnet/minecraft/entity/Entity;", "type", "Thaumic Arcana"}
)
public class ArmorBase extends ItemArmor {
   @Nullable
   public String getArmorTexture(@Nullable ItemStack stack, @Nullable Entity entity, @Nullable EntityEquipmentSlot slot, @Nullable String type) {
      return slot != EntityEquipmentSlot.LEGS ? "thaumic_arcana" + ":textures/models/armor/" + this.func_82812_d().func_179242_c() + "_layer_1.png" : "thaumic_arcana" + ":textures/models/armor/" + this.func_82812_d().func_179242_c() + "_layer_2.png";
   }

   public ArmorBase(@NotNull ItemArmor.ArmorMaterial material, int renderindex, @NotNull EntityEquipmentSlot slot) {
      Intrinsics.checkParameterIsNotNull(material, "material");
      Intrinsics.checkParameterIsNotNull(slot, "slot");
      super(material, renderindex, slot);
   }
}

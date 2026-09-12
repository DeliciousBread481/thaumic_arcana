package hu.frontrider.arcana.items.armor;

import hu.frontrider.arcana.util.IInfusedArmor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0016¨\u0006\u0018"},
   d2 = {"Lhu/frontrider/arcana/items/armor/SlimiumArmor;", "Lhu/frontrider/arcana/items/armor/ArmorBase;", "Lhu/frontrider/arcana/util/IInfusedArmor;", "slot", "Lnet/minecraft/inventory/EntityEquipmentSlot;", "(Lnet/minecraft/inventory/EntityEquipmentSlot;)V", "addInformation", "", "stack", "Lnet/minecraft/item/ItemStack;", "worldIn", "Lnet/minecraft/world/World;", "tooltip", "", "", "flagIn", "Lnet/minecraft/client/util/ITooltipFlag;", "hasEffect", "", "onArmorTick", "world", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "itemStack", "Thaumic Arcana"}
)
public final class SlimiumArmor extends ArmorBase implements IInfusedArmor {
   public void onArmorTick(@NotNull World world, @NotNull EntityPlayer player, @NotNull ItemStack itemStack) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(player, "player");
      Intrinsics.checkParameterIsNotNull(itemStack, "itemStack");
      List effectsFromStack = PotionUtils.func_185189_a(itemStack);
      ArrayList newEffects = new ArrayList();
      Intrinsics.checkExpressionValueIsNotNull(effectsFromStack, "effectsFromStack");

      for(Object element$iv : (Iterable)effectsFromStack) {
         PotionEffect it = (PotionEffect)element$iv;
         Intrinsics.checkExpressionValueIsNotNull(it, "it");
         int duration = it.func_76459_b() - 1;
         PotionEffect var10000;
         if (duration > 0) {
            newEffects.add(new PotionEffect(it.func_188419_a(), duration, it.func_76458_c()));
            var10000 = new PotionEffect(it.func_188419_a(), 1, it.func_76458_c());
         } else {
            var10000 = new PotionEffect(it.func_188419_a(), 1 + duration, it.func_76458_c());
         }

         PotionEffect potionEffect = var10000;
         player.func_70690_d(potionEffect);
      }

      PotionUtils.func_185184_a(itemStack, (Collection)newEffects);
   }

   @SideOnly(Side.CLIENT)
   public void func_77624_a(@NotNull ItemStack stack, @Nullable World worldIn, @NotNull List<String> tooltip, @NotNull ITooltipFlag flagIn) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(tooltip, "tooltip");
      Intrinsics.checkParameterIsNotNull(flagIn, "flagIn");
      PotionUtils.func_185182_a(stack, tooltip, 1.0F);
   }

   public boolean func_77636_d(@NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      return PotionUtils.func_185189_a(stack).size() > 0;
   }

   public SlimiumArmor(@NotNull EntityEquipmentSlot slot) {
      Intrinsics.checkParameterIsNotNull(slot, "slot");
      super(MaterialKt.getARMOR_MATERIAL_INFUSED_SLIME(), 0, slot);
   }
}

package hu.frontrider.arcana.items.tools;

import hu.frontrider.arcana.util.IInfuseable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
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
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0017J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0011"},
   d2 = {"Lhu/frontrider/arcana/items/tools/InfusedSlimiumAxe;", "Lhu/frontrider/arcana/items/tools/AxeBase;", "Lhu/frontrider/arcana/util/IInfuseable;", "()V", "addInformation", "", "stack", "Lnet/minecraft/item/ItemStack;", "worldIn", "Lnet/minecraft/world/World;", "tooltip", "", "", "flagIn", "Lnet/minecraft/client/util/ITooltipFlag;", "hasEffect", "", "Thaumic Arcana"}
)
public final class InfusedSlimiumAxe extends AxeBase implements IInfuseable {
   public boolean func_77636_d(@NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      return PotionUtils.func_185189_a(stack).size() > 0 || super.func_77636_d(stack);
   }

   @SideOnly(Side.CLIENT)
   public void func_77624_a(@NotNull ItemStack stack, @Nullable World worldIn, @NotNull List<String> tooltip, @NotNull ITooltipFlag flagIn) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(tooltip, "tooltip");
      Intrinsics.checkParameterIsNotNull(flagIn, "flagIn");
      PotionUtils.func_185182_a(stack, tooltip, 1.0F);
   }

   public InfusedSlimiumAxe() {
      super("infused_slimy_axe", MaterialsKt.getTOOL_MATERIAL_INFUSED_SLIMIUM());
   }
}

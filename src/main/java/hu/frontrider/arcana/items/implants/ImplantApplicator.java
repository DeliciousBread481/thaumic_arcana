package hu.frontrider.arcana.items.implants;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"},
   d2 = {"Lhu/frontrider/arcana/items/implants/ImplantApplicator;", "Lnet/minecraft/item/Item;", "()V", "onItemRightClick", "Lnet/minecraft/util/ActionResult;", "Lnet/minecraft/item/ItemStack;", "worldIn", "Lnet/minecraft/world/World;", "playerIn", "Lnet/minecraft/entity/player/EntityPlayer;", "handIn", "Lnet/minecraft/util/EnumHand;", "Thaumic Arcana"}
)
public final class ImplantApplicator extends Item {
   @NotNull
   public ActionResult<ItemStack> func_77659_a(@NotNull World worldIn, @NotNull EntityPlayer playerIn, @NotNull EnumHand handIn) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(playerIn, "playerIn");
      Intrinsics.checkParameterIsNotNull(handIn, "handIn");
      ActionResult var10000 = super.func_77659_a(worldIn, playerIn, handIn);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "super.onItemRightClick(worldIn, playerIn, handIn)");
      return var10000;
   }
}

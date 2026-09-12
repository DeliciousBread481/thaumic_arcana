package hu.frontrider.core.traits;

import hu.frontrider.core.util.inventory.InventoryChooser;
import hu.frontrider.core.util.inventory.InventoryKt;
import hu.frontrider.core.util.items.StackKt;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ7\u0010\u0003\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u0013¨\u0006\u0014"},
   d2 = {"Lhu/frontrider/core/traits/InventoryConsumer;", "", "()V", "consumeOne", "Lnet/minecraft/item/ItemStack;", "T", "clazz", "Ljava/lang/Class;", "world", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/BlockPos;", "sides", "", "Lnet/minecraft/util/EnumFacing;", "(Ljava/lang/Class;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;[Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/item/ItemStack;", "", "stacks", "Lnet/minecraft/item/Item;", "([Lnet/minecraft/item/Item;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;[Lnet/minecraft/util/EnumFacing;)Z", "Thaumic Arcana"}
)
public final class InventoryConsumer {
   public static final InventoryConsumer INSTANCE;

   public final boolean consumeOne(@NotNull Item[] stacks, @NotNull World world, @NotNull BlockPos pos, @NotNull EnumFacing[] sides) {
      Intrinsics.checkParameterIsNotNull(stacks, "stacks");
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(sides, "sides");

      for(Object element$iv : sides) {
         InventoryChooser var10000 = InventoryChooser.INSTANCE;
         BlockPos var10002 = pos.func_177972_a((EnumFacing)element$iv);
         Intrinsics.checkExpressionValueIsNotNull(var10002, "pos.offset(it)");
         EnumFacing var10003 = ((EnumFacing)element$iv).func_176734_d();
         Intrinsics.checkExpressionValueIsNotNull(var10003, "it.opposite");
         Optional inventory = var10000.getInventory(world, var10002, var10003);
         if (inventory.isPresent()) {
            Object var22 = inventory.get();
            Intrinsics.checkExpressionValueIsNotNull(var22, "inventory.get()");
            IItemHandler iItemHandler = (IItemHandler)var22;

            for(Object element$iv : stacks) {
               ItemStack item = InventoryKt.extract$default(iItemHandler, new ItemStack((Item)element$iv), 0, 0, 6, (Object)null);
               if (StackKt.isNotEmpty(item)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @NotNull
   public final <T> ItemStack consumeOne(@NotNull Class<T> clazz, @NotNull World world, @NotNull BlockPos pos, @NotNull EnumFacing[] sides) {
      Intrinsics.checkParameterIsNotNull(clazz, "clazz");
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(sides, "sides");

      for(Object element$iv : sides) {
         InventoryChooser var10000 = InventoryChooser.INSTANCE;
         BlockPos var10002 = pos.func_177972_a((EnumFacing)element$iv);
         Intrinsics.checkExpressionValueIsNotNull(var10002, "pos.offset(it)");
         EnumFacing var10003 = ((EnumFacing)element$iv).func_176734_d();
         Intrinsics.checkExpressionValueIsNotNull(var10003, "it.opposite");
         Optional inventory = var10000.getInventory(world, var10002, var10003);
         if (inventory.isPresent()) {
            Object var17 = inventory.get();
            Intrinsics.checkExpressionValueIsNotNull(var17, "inventory.get()");
            IItemHandler iItemHandler = (IItemHandler)var17;
            int index = 0;

            for(int var13 = iItemHandler.getSlots(); index < var13; ++index) {
               ItemStack var18 = iItemHandler.extractItem(index, 1, true);
               Intrinsics.checkExpressionValueIsNotNull(var18, "iItemHandler.extractItem(index, 1, true)");
               ItemStack itemStack = var18;
               if (StackKt.isNotEmpty(itemStack) && clazz.isInstance(itemStack.func_77973_b())) {
                  var18 = iItemHandler.extractItem(index, 1, false);
                  Intrinsics.checkExpressionValueIsNotNull(var18, "iItemHandler.extractItem(index, 1, false)");
                  return var18;
               }
            }
         }
      }

      ItemStack var20 = ItemStack.field_190927_a;
      Intrinsics.checkExpressionValueIsNotNull(var20, "ItemStack.EMPTY");
      return var20;
   }

   private InventoryConsumer() {
   }

   static {
      InventoryConsumer var0 = new InventoryConsumer();
      INSTANCE = var0;
   }
}

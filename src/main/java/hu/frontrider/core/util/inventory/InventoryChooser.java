package hu.frontrider.core.util.inventory;

import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/core/util/inventory/InventoryChooser;", "", "()V", "getBlockInventory", "Ljava/util/Optional;", "Lnet/minecraftforge/items/IItemHandler;", "world", "Lnet/minecraft/world/World;", "blockPos", "Lnet/minecraft/util/math/BlockPos;", "facing", "Lnet/minecraft/util/EnumFacing;", "getEntityInventory", "getInventory", "Thaumic Arcana"}
)
public final class InventoryChooser {
   public static final InventoryChooser INSTANCE;

   @NotNull
   public final Optional<IItemHandler> getInventory(@NotNull World world, @NotNull BlockPos blockPos, @NotNull EnumFacing facing) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(blockPos, "blockPos");
      Intrinsics.checkParameterIsNotNull(facing, "facing");
      Optional blockInventory = this.getBlockInventory(world, blockPos, facing);
      if (blockInventory.isPresent()) {
         return blockInventory;
      } else {
         Optional entityInventory = this.getEntityInventory(world, blockPos, facing);
         if (entityInventory.isPresent()) {
            return entityInventory;
         } else {
            Optional var10000 = Optional.empty();
            Intrinsics.checkExpressionValueIsNotNull(var10000, "Optional.empty()");
            return var10000;
         }
      }
   }

   private final Optional<IItemHandler> getBlockInventory(World world, BlockPos blockPos, EnumFacing facing) {
      TileEntity var10000 = world.func_175625_s(blockPos);
      if (var10000 != null) {
         Intrinsics.checkExpressionValueIsNotNull(var10000, "world.getTileEntity(bloc…: return Optional.empty()");
         TileEntity tileEntity = var10000;
         if (tileEntity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing)) {
            Object var8 = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing);
            if (var8 == null) {
               Intrinsics.throwNpe();
            }

            Intrinsics.checkExpressionValueIsNotNull(var8, "tileEntity.getCapability…LER_CAPABILITY, facing)!!");
            IItemHandler iItemHandler = (IItemHandler)var8;
            Optional var9 = Optional.of(iItemHandler);
            Intrinsics.checkExpressionValueIsNotNull(var9, "Optional.of(iItemHandler)");
            return var9;
         } else {
            Optional var7 = Optional.empty();
            Intrinsics.checkExpressionValueIsNotNull(var7, "Optional.empty()");
            return var7;
         }
      } else {
         Optional var6 = Optional.empty();
         Intrinsics.checkExpressionValueIsNotNull(var6, "Optional.empty()");
         return var6;
      }
   }

   private final Optional<IItemHandler> getEntityInventory(World world, BlockPos blockPos, EnumFacing facing) {
      for(Entity entity : world.func_72872_a(Entity.class, new AxisAlignedBB(blockPos))) {
         if (entity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing)) {
            Object var10000 = entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing);
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            Intrinsics.checkExpressionValueIsNotNull(var10000, "entity.getCapability(ITE…LER_CAPABILITY, facing)!!");
            IItemHandler iItemHandler = (IItemHandler)var10000;
            Optional var7 = Optional.of(iItemHandler);
            Intrinsics.checkExpressionValueIsNotNull(var7, "Optional.of(iItemHandler)");
            return var7;
         }
      }

      Optional var8 = Optional.empty();
      Intrinsics.checkExpressionValueIsNotNull(var8, "Optional.empty()");
      return var8;
   }

   private InventoryChooser() {
   }

   static {
      InventoryChooser var0 = new InventoryChooser();
      INSTANCE = var0;
   }
}

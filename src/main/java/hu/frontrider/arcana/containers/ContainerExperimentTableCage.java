package hu.frontrider.arcana.containers;

import hu.frontrider.arcana.blocks.experiments.tiles.TileEntityExperimentTable;
import hu.frontrider.core.gui.container.ContainerBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"},
   d2 = {"Lhu/frontrider/arcana/containers/ContainerExperimentTableCage;", "Lhu/frontrider/core/gui/container/ContainerBase;", "playerInv", "Lnet/minecraft/entity/player/InventoryPlayer;", "experimentTable", "Lhu/frontrider/arcana/blocks/experiments/tiles/TileEntityExperimentTable;", "(Lnet/minecraft/entity/player/InventoryPlayer;Lhu/frontrider/arcana/blocks/experiments/tiles/TileEntityExperimentTable;)V", "canInteractWith", "", "playerIn", "Lnet/minecraft/entity/player/EntityPlayer;", "Thaumic Arcana"}
)
public final class ContainerExperimentTableCage extends ContainerBase {
   public boolean func_75145_c(@NotNull EntityPlayer playerIn) {
      Intrinsics.checkParameterIsNotNull(playerIn, "playerIn");
      return true;
   }

   public ContainerExperimentTableCage(@NotNull InventoryPlayer playerInv, @NotNull TileEntityExperimentTable experimentTable) {
      Intrinsics.checkParameterIsNotNull(playerInv, "playerInv");
      Intrinsics.checkParameterIsNotNull(experimentTable, "experimentTable");
      super();
      IItemHandler inventory = (IItemHandler)experimentTable.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
      int x = 104;
      int slotIndex = 0;
      int i = 0;

      for(byte var7 = 1; i <= var7; ++i) {
         int j = 0;

         for(byte var9 = 2; j <= var9; ++j) {
            this.func_75146_a((Slot)(new SlotItemHandler(inventory, slotIndex, x + i * 36, -3 + j * 36)));
            ++slotIndex;
         }
      }

      i = 0;

      for(byte var12 = 2; i <= var12; ++i) {
         int var14 = 0;

         for(byte var15 = 8; var14 <= var15; ++var14) {
            this.func_75146_a(new Slot((IInventory)playerInv, var14 + i * 9 + 9, 8 + var14 * 18, 114 + i * 18));
         }
      }

      i = 0;

      for(byte var13 = 8; i <= var13; ++i) {
         this.func_75146_a(new Slot((IInventory)playerInv, i, 8 + i * 18, 172));
      }

   }
}

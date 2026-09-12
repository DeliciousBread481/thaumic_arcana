package hu.frontrider.arcana.blocks.experiments.tiles;

import javax.annotation.Nullable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityExperimentTable extends TileEntity {
   private ItemStackHandler cage = new ItemStackHandler(8);

   public void func_145836_u() {
      super.func_145836_u();
   }

   public NBTTagCompound func_189515_b(NBTTagCompound compound) {
      compound.func_74782_a("cage", this.cage.serializeNBT());
      return super.func_189515_b(compound);
   }

   public void func_145839_a(NBTTagCompound compound) {
      this.cage.deserializeNBT(compound.func_74775_l("cage"));
      super.func_145839_a(compound);
   }

   public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
      return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
   }

   @Nullable
   public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
      return (T)(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(this.cage) : super.getCapability(capability, facing));
   }
}

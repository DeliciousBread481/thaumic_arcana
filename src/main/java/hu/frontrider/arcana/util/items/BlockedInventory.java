package hu.frontrider.arcana.util.items;

import javax.annotation.Nonnull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00030\u0003H\u0096\u0001J!\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0097\u0001J\u0011\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000fH\u0097\u0001J \u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u001e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0012J\u0011\u0010\u001b\u001a\n \f*\u0004\u0018\u00010\u00030\u0003H\u0096\u0001J\u001b\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u000eH\u0096\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001d"},
   d2 = {"Lhu/frontrider/arcana/util/items/BlockedInventory;", "Lnet/minecraftforge/items/IItemHandlerModifiable;", "Lnet/minecraftforge/common/util/INBTSerializable;", "Lnet/minecraft/nbt/NBTTagCompound;", "handler", "Lnet/minecraftforge/items/ItemStackHandler;", "(Lnet/minecraftforge/items/ItemStackHandler;)V", "getHandler", "()Lnet/minecraftforge/items/ItemStackHandler;", "deserializeNBT", "", "p0", "kotlin.jvm.PlatformType", "extractItem", "Lnet/minecraft/item/ItemStack;", "", "p1", "p2", "", "getSlotLimit", "getSlots", "getStackInSlot", "insertItem", "slot", "stack", "simulate", "insertItemInternal", "serializeNBT", "setStackInSlot", "Thaumic Arcana"}
)
public final class BlockedInventory implements IItemHandlerModifiable, INBTSerializable<NBTTagCompound> {
   @NotNull
   private final ItemStackHandler handler;

   @NotNull
   public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      return stack;
   }

   @NotNull
   public final ItemStack insertItemInternal(int slot, @NotNull ItemStack stack, boolean simulate) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      ItemStack var10000 = this.handler.insertItem(slot, stack, simulate);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "handler.insertItem(slot, stack, simulate)");
      return var10000;
   }

   @NotNull
   public final ItemStackHandler getHandler() {
      return this.handler;
   }

   public BlockedInventory(@NotNull ItemStackHandler handler) {
      Intrinsics.checkParameterIsNotNull(handler, "handler");
      super();
      this.handler = handler;
   }

   @Nonnull
   @NotNull
   public ItemStack extractItem(int p0, int p1, boolean p2) {
      return this.handler.extractItem(p0, p1, p2);
   }

   public int getSlotLimit(int p0) {
      return this.handler.getSlotLimit(p0);
   }

   public int getSlots() {
      return this.handler.getSlots();
   }

   @Nonnull
   @NotNull
   public ItemStack getStackInSlot(int p0) {
      return this.handler.getStackInSlot(p0);
   }

   public void setStackInSlot(int p0, @Nonnull @NotNull ItemStack p1) {
      Intrinsics.checkParameterIsNotNull(p1, "p1");
      this.handler.setStackInSlot(p0, p1);
   }

   public void deserializeNBT(NBTTagCompound p0) {
      this.handler.deserializeNBT(p0);
   }

   public NBTTagCompound serializeNBT() {
      return this.handler.serializeNBT();
   }
}

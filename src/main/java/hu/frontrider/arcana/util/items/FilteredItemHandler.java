package hu.frontrider.arcana.util.items;

import javax.annotation.Nonnull;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00030\u0003H\u0096\u0001J!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\nH\u0097\u0001J\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0096\u0001J\t\u0010\u0018\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\bH\u0097\u0001J \u0010\u001a\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0011\u0010\u001b\u001a\n \u0013*\u0004\u0018\u00010\u00030\u0003H\u0096\u0001J\u001b\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0001\u0010\u0015\u001a\u00020\tH\u0096\u0001R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"},
   d2 = {"Lhu/frontrider/arcana/util/items/FilteredItemHandler;", "Lnet/minecraftforge/items/IItemHandlerModifiable;", "Lnet/minecraftforge/common/util/INBTSerializable;", "Lnet/minecraft/nbt/NBTTagCompound;", "handler", "Lnet/minecraftforge/items/ItemStackHandler;", "filterFunction", "Lkotlin/Function2;", "", "Lnet/minecraft/item/ItemStack;", "", "(Lnet/minecraftforge/items/ItemStackHandler;Lkotlin/jvm/functions/Function2;)V", "getFilterFunction", "()Lkotlin/jvm/functions/Function2;", "getHandler", "()Lnet/minecraftforge/items/ItemStackHandler;", "deserializeNBT", "", "p0", "kotlin.jvm.PlatformType", "extractItem", "p1", "p2", "getSlotLimit", "getSlots", "getStackInSlot", "insertItem", "serializeNBT", "setStackInSlot", "Thaumic Arcana"}
)
public final class FilteredItemHandler implements IItemHandlerModifiable, INBTSerializable<NBTTagCompound> {
   @NotNull
   private final ItemStackHandler handler;
   @NotNull
   private final Function2<Integer, ItemStack, Boolean> filterFunction;

   @NotNull
   public ItemStack insertItem(int p0, @NotNull ItemStack p1, boolean p2) {
      Intrinsics.checkParameterIsNotNull(p1, "p1");
      if (!(Boolean)this.filterFunction.invoke(p0, p1)) {
         return p1;
      } else {
         ItemStack var10000 = this.handler.insertItem(p0, p1, p2);
         Intrinsics.checkExpressionValueIsNotNull(var10000, "handler.insertItem(p0, p1, p2)");
         return var10000;
      }
   }

   @NotNull
   public final ItemStackHandler getHandler() {
      return this.handler;
   }

   @NotNull
   public final Function2<Integer, ItemStack, Boolean> getFilterFunction() {
      return this.filterFunction;
   }

   public FilteredItemHandler(@NotNull ItemStackHandler handler, @NotNull Function2<? super Integer, ? super ItemStack, Boolean> filterFunction) {
      Intrinsics.checkParameterIsNotNull(handler, "handler");
      Intrinsics.checkParameterIsNotNull(filterFunction, "filterFunction");
      super();
      this.handler = handler;
      this.filterFunction = filterFunction;
   }

   // $FF: synthetic method
   public FilteredItemHandler(ItemStackHandler var1, Function2 var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = null.INSTANCE;
      }

      this(var1, var2);
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

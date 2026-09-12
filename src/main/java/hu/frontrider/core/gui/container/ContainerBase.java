package hu.frontrider.core.gui.container;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"},
   d2 = {"Lhu/frontrider/core/gui/container/ContainerBase;", "Lnet/minecraft/inventory/Container;", "()V", "placePlayerInv", "", "playerInv", "Lnet/minecraft/entity/player/InventoryPlayer;", "transferStackInSlot", "Lnet/minecraft/item/ItemStack;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "index", "", "Thaumic Arcana"}
)
public abstract class ContainerBase extends Container {
   @NotNull
   public ItemStack func_82846_b(@Nullable EntityPlayer player, int index) {
      ItemStack itemstack = ItemStack.field_190927_a;
      Slot slot = (Slot)this.field_75151_b.get(index);
      if (slot != null && slot.func_75216_d()) {
         ItemStack itemstack1 = slot.func_75211_c();
         itemstack = itemstack1.func_77946_l();
         int var10000 = this.field_75151_b.size();
         if (player == null) {
            Intrinsics.throwNpe();
         }

         int containerSlots = var10000 - player.field_71071_by.field_70462_a.size();
         if (index < containerSlots) {
            if (!this.func_75135_a(itemstack1, containerSlots, this.field_75151_b.size(), true)) {
               ItemStack var7 = ItemStack.field_190927_a;
               Intrinsics.checkExpressionValueIsNotNull(var7, "ItemStack.EMPTY");
               return var7;
            }
         } else if (!this.func_75135_a(itemstack1, 0, containerSlots, false)) {
            ItemStack var10 = ItemStack.field_190927_a;
            Intrinsics.checkExpressionValueIsNotNull(var10, "ItemStack.EMPTY");
            return var10;
         }

         Intrinsics.checkExpressionValueIsNotNull(itemstack1, "itemstack1");
         if (itemstack1.func_190916_E() == 0) {
            slot.func_75215_d(ItemStack.field_190927_a);
         } else {
            slot.func_75218_e();
         }

         var10000 = itemstack1.func_190916_E();
         Intrinsics.checkExpressionValueIsNotNull(itemstack, "itemstack");
         if (var10000 == itemstack.func_190916_E()) {
            ItemStack var9 = ItemStack.field_190927_a;
            Intrinsics.checkExpressionValueIsNotNull(var9, "ItemStack.EMPTY");
            return var9;
         }

         slot.func_190901_a(player, itemstack1);
      }

      Intrinsics.checkExpressionValueIsNotNull(itemstack, "itemstack");
      return itemstack;
   }

   public final void placePlayerInv(@NotNull InventoryPlayer playerInv) {
      Intrinsics.checkParameterIsNotNull(playerInv, "playerInv");
      int i = 0;

      for(byte var3 = 2; i <= var3; ++i) {
         int j = 0;

         for(byte var5 = 8; j <= var5; ++j) {
            this.func_75146_a(new Slot((IInventory)playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
         }
      }

      i = 0;

      for(byte var7 = 8; i <= var7; ++i) {
         this.func_75146_a(new Slot((IInventory)playerInv, i, 8 + i * 18, 142));
      }

   }
}

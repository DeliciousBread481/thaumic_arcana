package hu.frontrider.core.util.inventory;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\b"},
   d2 = {"Lhu/frontrider/core/util/inventory/InventoryCraftingFalse;", "Lnet/minecraft/inventory/InventoryCrafting;", "width", "", "height", "(II)V", "Companion", "NullContainer", "Thaumic Arcana"}
)
public final class InventoryCraftingFalse extends InventoryCrafting {
   private static final NullContainer nullContainer = new NullContainer();
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public InventoryCraftingFalse(int width, int height) {
      super(nullContainer, width, height);
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"},
      d2 = {"Lhu/frontrider/core/util/inventory/InventoryCraftingFalse$NullContainer;", "Lnet/minecraft/inventory/Container;", "()V", "canInteractWith", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "onCraftMatrixChanged", "", "inventory", "Lnet/minecraft/inventory/IInventory;", "Thaumic Arcana"}
   )
   public static final class NullContainer extends Container {
      public void func_75130_a(@Nullable IInventory inventory) {
      }

      public boolean func_75145_c(@NotNull EntityPlayer player) {
         Intrinsics.checkParameterIsNotNull(player, "player");
         return false;
      }
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"},
      d2 = {"Lhu/frontrider/core/util/inventory/InventoryCraftingFalse$Companion;", "", "()V", "nullContainer", "Lhu/frontrider/core/util/inventory/InventoryCraftingFalse$NullContainer;", "Thaumic Arcana"}
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

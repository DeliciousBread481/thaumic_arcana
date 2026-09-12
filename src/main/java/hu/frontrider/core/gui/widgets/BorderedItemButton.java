package hu.frontrider.core.gui.widgets;

import hu.frontrider.core.gui.BaseGui;
import hu.frontrider.core.gui.widgets.interfaces.Clickable;
import hu.frontrider.core.gui.widgets.traits.ButtonRender;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"},
   d2 = {"Lhu/frontrider/core/gui/widgets/BorderedItemButton;", "Lhu/frontrider/core/gui/widgets/ItemButton;", "x", "", "y", "itemStack", "Lnet/minecraft/item/ItemStack;", "display", "", "action", "Lhu/frontrider/core/gui/widgets/interfaces/Clickable;", "xOffset", "(IILnet/minecraft/item/ItemStack;Ljava/lang/String;Lhu/frontrider/core/gui/widgets/interfaces/Clickable;I)V", "buttonRender", "Lhu/frontrider/core/gui/widgets/traits/ButtonRender;", "getButtonRender", "()Lhu/frontrider/core/gui/widgets/traits/ButtonRender;", "render", "", "guiBase", "Lhu/frontrider/core/gui/BaseGui;", "update", "Thaumic Arcana"}
)
public final class BorderedItemButton extends ItemButton {
   @NotNull
   private final ButtonRender buttonRender;

   @NotNull
   public final ButtonRender getButtonRender() {
      return this.buttonRender;
   }

   public void render(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      super.render(guiBase);
      this.buttonRender.render(guiBase);
   }

   public void update() {
      super.update();
      this.buttonRender.setX(this.getX());
      this.buttonRender.setY(this.getY());
      this.buttonRender.setWidth(this.getWidth());
      this.buttonRender.setHeight(this.getHeight());
   }

   public BorderedItemButton(int x, int y, @NotNull ItemStack itemStack, @NotNull String display, @NotNull Clickable action, int xOffset) {
      Intrinsics.checkParameterIsNotNull(itemStack, "itemStack");
      Intrinsics.checkParameterIsNotNull(display, "display");
      Intrinsics.checkParameterIsNotNull(action, "action");
      super(x, y, itemStack, display, action, xOffset);
      this.buttonRender = new ButtonRender(x, y, this.getWidth(), this.getHeight());
   }

   // $FF: synthetic method
   public BorderedItemButton(int var1, int var2, ItemStack var3, String var4, Clickable var5, int var6, int var7, DefaultConstructorMarker var8) {
      if ((var7 & 32) != 0) {
         var6 = 16;
      }

      this(var1, var2, var3, var4, var5, var6);
   }
}

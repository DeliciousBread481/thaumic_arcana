package hu.frontrider.core.gui.widgets;

import hu.frontrider.core.gui.BaseGui;
import hu.frontrider.core.gui.widgets.interfaces.Clickable;
import hu.frontrider.core.gui.widgets.interfaces.Widget;
import hu.frontrider.core.gui.widgets.traits.ItemWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0002\u0010\tJ!\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0096\u0001J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020!H\u0016R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010¨\u0006*"},
   d2 = {"Lhu/frontrider/core/gui/widgets/TabItemButton;", "Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "Lhu/frontrider/core/gui/widgets/interfaces/Clickable;", "x", "", "y", "itemStack", "Lnet/minecraft/item/ItemStack;", "action", "(IILnet/minecraft/item/ItemStack;Lhu/frontrider/core/gui/widgets/interfaces/Clickable;)V", "getAction", "()Lhu/frontrider/core/gui/widgets/interfaces/Clickable;", "height", "getHeight", "()I", "setHeight", "(I)V", "getItemStack", "()Lnet/minecraft/item/ItemStack;", "itemWidget", "Lhu/frontrider/core/gui/widgets/traits/ItemWidget;", "getItemWidget", "()Lhu/frontrider/core/gui/widgets/traits/ItemWidget;", "setItemWidget", "(Lhu/frontrider/core/gui/widgets/traits/ItemWidget;)V", "width", "getWidth", "setWidth", "getX", "setX", "getY", "setY", "onClick", "", "mouseX", "mouseY", "mouseButton", "postRender", "guiBase", "Lhu/frontrider/core/gui/BaseGui;", "render", "update", "Thaumic Arcana"}
)
public final class TabItemButton implements Widget, Clickable {
   private int height;
   private int width;
   @NotNull
   private ItemWidget itemWidget;
   private int x;
   private int y;
   @NotNull
   private final ItemStack itemStack;
   @NotNull
   private final Clickable action;

   public int getHeight() {
      return this.height;
   }

   public void setHeight(int var1) {
      this.height = var1;
   }

   public int getWidth() {
      return this.width;
   }

   public void setWidth(int var1) {
      this.width = var1;
   }

   @NotNull
   public final ItemWidget getItemWidget() {
      return this.itemWidget;
   }

   public final void setItemWidget(@NotNull ItemWidget var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.itemWidget = var1;
   }

   public void render(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      guiBase.drawTab$Thaumic_Arcana(this.getX(), this.getY());
   }

   public void postRender(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      this.itemWidget.postRender(guiBase);
   }

   public void update() {
      this.itemWidget = new ItemWidget(this.getX() + 8, this.getY(), this.itemStack, 0, "");
   }

   public int getX() {
      return this.x;
   }

   public void setX(int var1) {
      this.x = var1;
   }

   public int getY() {
      return this.y;
   }

   public void setY(int var1) {
      this.y = var1;
   }

   @NotNull
   public final ItemStack getItemStack() {
      return this.itemStack;
   }

   @NotNull
   public final Clickable getAction() {
      return this.action;
   }

   public TabItemButton(int x, int y, @NotNull ItemStack itemStack, @NotNull Clickable action) {
      Intrinsics.checkParameterIsNotNull(itemStack, "itemStack");
      Intrinsics.checkParameterIsNotNull(action, "action");
      super();
      this.x = x;
      this.y = y;
      this.itemStack = itemStack;
      this.action = action;
      this.height = 16;
      this.width = 28;
      this.itemWidget = new ItemWidget(this.getX() + 8, this.getY(), this.itemStack, 0, "");
   }

   public void onClick(int mouseX, int mouseY, int mouseButton) {
      this.action.onClick(mouseX, mouseY, mouseButton);
   }
}

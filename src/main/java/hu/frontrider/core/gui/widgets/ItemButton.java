package hu.frontrider.core.gui.widgets;

import hu.frontrider.core.gui.BaseGui;
import hu.frontrider.core.gui.widgets.interfaces.Clickable;
import hu.frontrider.core.gui.widgets.interfaces.Widget;
import hu.frontrider.core.gui.widgets.traits.ItemWidget;
import hu.frontrider.core.util.ChatFormatKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fJ!\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0096\u0001J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020%H\u0016R\u000e\u0010\n\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013¨\u0006-"},
   d2 = {"Lhu/frontrider/core/gui/widgets/ItemButton;", "Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "Lhu/frontrider/core/gui/widgets/interfaces/Clickable;", "x", "", "y", "itemStack", "Lnet/minecraft/item/ItemStack;", "display", "", "action", "xOffset", "(IILnet/minecraft/item/ItemStack;Ljava/lang/String;Lhu/frontrider/core/gui/widgets/interfaces/Clickable;I)V", "getDisplay", "()Ljava/lang/String;", "height", "getHeight", "()I", "setHeight", "(I)V", "getItemStack", "()Lnet/minecraft/item/ItemStack;", "itemWidget", "Lhu/frontrider/core/gui/widgets/traits/ItemWidget;", "getItemWidget", "()Lhu/frontrider/core/gui/widgets/traits/ItemWidget;", "setItemWidget", "(Lhu/frontrider/core/gui/widgets/traits/ItemWidget;)V", "width", "getWidth", "setWidth", "getX", "setX", "getXOffset", "getY", "setY", "onClick", "", "mouseX", "mouseY", "mouseButton", "postRender", "guiBase", "Lhu/frontrider/core/gui/BaseGui;", "update", "Thaumic Arcana"}
)
public class ItemButton implements Widget, Clickable {
   private int width;
   private int height;
   @NotNull
   private ItemWidget itemWidget;
   private int x;
   private int y;
   @NotNull
   private final ItemStack itemStack;
   @NotNull
   private final String display;
   private final Clickable action;
   private final int xOffset;

   public final int getWidth() {
      return this.width;
   }

   public final void setWidth(int var1) {
      this.width = var1;
   }

   public int getHeight() {
      return this.height;
   }

   public void setHeight(int var1) {
      this.height = var1;
   }

   @NotNull
   public final ItemWidget getItemWidget() {
      return this.itemWidget;
   }

   public final void setItemWidget(@NotNull ItemWidget var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.itemWidget = var1;
   }

   public void postRender(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      this.itemWidget.postRender(guiBase);
      guiBase.setZlevel$Thaumic_Arcana(400.0F);
      BaseGui.drawText$Thaumic_Arcana$default(guiBase, this.x, this.y + 4, this.width, ChatFormatKt.formatString(this.display), false, 0, 32, (Object)null);
      guiBase.setZlevel$Thaumic_Arcana(0.0F);
   }

   public void update() {
      this.itemWidget = new ItemWidget(this.x + this.xOffset, this.y, this.itemStack, this.xOffset, this.display);
      this.action.setX(this.x);
      this.action.setY(this.y);
      this.action.setWidth(this.width);
      this.action.setHeight(this.getHeight());
   }

   public final int getX() {
      return this.x;
   }

   public final void setX(int var1) {
      this.x = var1;
   }

   public final int getY() {
      return this.y;
   }

   public final void setY(int var1) {
      this.y = var1;
   }

   @NotNull
   public final ItemStack getItemStack() {
      return this.itemStack;
   }

   @NotNull
   public final String getDisplay() {
      return this.display;
   }

   public final int getXOffset() {
      return this.xOffset;
   }

   public ItemButton(int x, int y, @NotNull ItemStack itemStack, @NotNull String display, @NotNull Clickable action, int xOffset) {
      Intrinsics.checkParameterIsNotNull(itemStack, "itemStack");
      Intrinsics.checkParameterIsNotNull(display, "display");
      Intrinsics.checkParameterIsNotNull(action, "action");
      super();
      this.x = x;
      this.y = y;
      this.itemStack = itemStack;
      this.display = display;
      this.action = action;
      this.xOffset = xOffset;
      this.height = 16;
      this.itemWidget = new ItemWidget(this.x + this.xOffset, this.y, this.itemStack, this.xOffset, this.display);
      FontRenderer fontRenderer = Minecraft.func_71410_x().field_71466_p;
      this.width = fontRenderer.func_78256_a(this.display) + this.xOffset;
   }

   public void render(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      Widget.DefaultImpls.render(this, guiBase);
   }

   public void onClick(int mouseX, int mouseY, int mouseButton) {
      this.action.onClick(mouseX, mouseY, mouseButton);
   }
}

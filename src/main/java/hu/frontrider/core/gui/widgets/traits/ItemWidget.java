package hu.frontrider.core.gui.widgets.traits;

import hu.frontrider.core.gui.BaseGui;
import hu.frontrider.core.gui.widgets.interfaces.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u001a"},
   d2 = {"Lhu/frontrider/core/gui/widgets/traits/ItemWidget;", "Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "x", "", "y", "itemStack", "Lnet/minecraft/item/ItemStack;", "xOffset", "display", "", "(IILnet/minecraft/item/ItemStack;ILjava/lang/String;)V", "getDisplay", "()Ljava/lang/String;", "getItemStack", "()Lnet/minecraft/item/ItemStack;", "getX", "()I", "setX", "(I)V", "getXOffset", "getY", "setY", "postRender", "", "guiBase", "Lhu/frontrider/core/gui/BaseGui;", "Thaumic Arcana"}
)
public final class ItemWidget implements Widget {
   private int x;
   private int y;
   @NotNull
   private final ItemStack itemStack;
   private final int xOffset;
   @NotNull
   private final String display;

   public void postRender(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      guiBase.drawItemStack$Thaumic_Arcana(this.itemStack, this.getX() + this.xOffset, this.getY(), 0, this.display);
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

   public final int getXOffset() {
      return this.xOffset;
   }

   @NotNull
   public final String getDisplay() {
      return this.display;
   }

   public ItemWidget(int x, int y, @NotNull ItemStack itemStack, int xOffset, @NotNull String display) {
      Intrinsics.checkParameterIsNotNull(itemStack, "itemStack");
      Intrinsics.checkParameterIsNotNull(display, "display");
      super();
      this.x = x;
      this.y = y;
      this.itemStack = itemStack;
      this.xOffset = xOffset;
      this.display = display;
   }

   // $FF: synthetic method
   public ItemWidget(int var1, int var2, ItemStack var3, int var4, String var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 8) != 0) {
         var4 = 16;
      }

      this(var1, var2, var3, var4, var5);
   }

   public void render(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      Widget.DefaultImpls.render(this, guiBase);
   }

   public void update() {
      Widget.DefaultImpls.update(this);
   }
}

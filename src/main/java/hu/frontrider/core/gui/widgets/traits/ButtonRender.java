package hu.frontrider.core.gui.widgets.traits;

import hu.frontrider.core.gui.BaseGui;
import hu.frontrider.core.gui.widgets.interfaces.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0016"},
   d2 = {"Lhu/frontrider/core/gui/widgets/traits/ButtonRender;", "Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "x", "", "y", "width", "height", "(IIII)V", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "getX", "setX", "getY", "setY", "render", "", "guiBase", "Lhu/frontrider/core/gui/BaseGui;", "Thaumic Arcana"}
)
public final class ButtonRender implements Widget {
   private int x;
   private int y;
   private int width;
   private int height;

   public void render(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      guiBase.drawVerticalLinePublic$Thaumic_Arcana(this.getX(), this.getY(), this.getY() + this.height, 0);
      guiBase.drawVerticalLinePublic$Thaumic_Arcana(this.getX() + this.width, this.getY(), this.getY() + this.height, 0);
      guiBase.drawHorizontalLinePublic$Thaumic_Arcana(this.getX(), this.getX() + this.width, this.getY(), 4);
      guiBase.drawHorizontalLinePublic$Thaumic_Arcana(this.getX(), this.getX() + this.width, this.getY() + this.height, 0);
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

   public final int getWidth() {
      return this.width;
   }

   public final void setWidth(int var1) {
      this.width = var1;
   }

   public final int getHeight() {
      return this.height;
   }

   public final void setHeight(int var1) {
      this.height = var1;
   }

   public ButtonRender(int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
   }

   public void postRender(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      Widget.DefaultImpls.postRender(this, guiBase);
   }

   public void update() {
      Widget.DefaultImpls.update(this);
   }
}

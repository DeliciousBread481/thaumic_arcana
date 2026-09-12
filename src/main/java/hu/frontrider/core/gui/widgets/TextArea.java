package hu.frontrider.core.gui.widgets;

import hu.frontrider.core.gui.BaseGui;
import hu.frontrider.core.gui.widgets.interfaces.Widget;
import hu.frontrider.core.util.ChatFormatKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000f¨\u0006\u0016"},
   d2 = {"Lhu/frontrider/core/gui/widgets/TextArea;", "Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "x", "", "y", "width", "unlocalisedText", "", "(IIILjava/lang/String;)V", "getUnlocalisedText", "()Ljava/lang/String;", "getWidth", "()I", "getX", "setX", "(I)V", "getY", "setY", "render", "", "guiBase", "Lhu/frontrider/core/gui/BaseGui;", "Thaumic Arcana"}
)
public final class TextArea implements Widget {
   private int x;
   private int y;
   private final int width;
   @NotNull
   private final String unlocalisedText;

   public void render(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      BaseGui.drawText$Thaumic_Arcana$default(guiBase, this.getX(), this.getY(), this.width, ChatFormatKt.translateFormatting(this.unlocalisedText), true, 0, 32, (Object)null);
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

   @NotNull
   public final String getUnlocalisedText() {
      return this.unlocalisedText;
   }

   public TextArea(int x, int y, int width, @NotNull String unlocalisedText) {
      Intrinsics.checkParameterIsNotNull(unlocalisedText, "unlocalisedText");
      super();
      this.x = x;
      this.y = y;
      this.width = width;
      this.unlocalisedText = unlocalisedText;
   }

   public void postRender(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      Widget.DefaultImpls.postRender(this, guiBase);
   }

   public void update() {
      Widget.DefaultImpls.update(this);
   }
}

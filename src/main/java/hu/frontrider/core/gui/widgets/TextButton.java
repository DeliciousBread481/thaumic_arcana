package hu.frontrider.core.gui.widgets;

import hu.frontrider.core.gui.BaseGui;
import hu.frontrider.core.gui.widgets.interfaces.Clickable;
import hu.frontrider.core.gui.widgets.interfaces.Widget;
import hu.frontrider.core.util.ChatFormatKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ!\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0096\u0001J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016R\u000e\u0010\b\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u0013¨\u0006#"},
   d2 = {"Lhu/frontrider/core/gui/widgets/TextButton;", "Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "Lhu/frontrider/core/gui/widgets/interfaces/Clickable;", "x", "", "y", "display", "", "action", "width", "color", "(IILjava/lang/String;Lhu/frontrider/core/gui/widgets/interfaces/Clickable;II)V", "getColor", "()I", "getDisplay", "()Ljava/lang/String;", "height", "getHeight", "setHeight", "(I)V", "getWidth", "setWidth", "getX", "setX", "getY", "setY", "onClick", "", "mouseX", "mouseY", "mouseButton", "render", "guiBase", "Lhu/frontrider/core/gui/BaseGui;", "update", "Thaumic Arcana"}
)
public final class TextButton implements Widget, Clickable {
   private int height;
   private int x;
   private int y;
   @NotNull
   private final String display;
   private final Clickable action;
   private int width;
   private final int color;

   public int getHeight() {
      return this.height;
   }

   public void setHeight(int var1) {
      this.height = var1;
   }

   public void render(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      guiBase.setZlevel$Thaumic_Arcana(400.0F);
      guiBase.drawText$Thaumic_Arcana(this.getX(), this.getY() + 4, this.getWidth(), ChatFormatKt.translateFormatting(this.display), false, this.color);
      guiBase.setZlevel$Thaumic_Arcana(0.0F);
   }

   public void update() {
      this.action.setX(this.getX());
      this.action.setY(this.getY());
      this.action.setWidth(this.getWidth());
      this.action.setHeight(this.getHeight());
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
   public final String getDisplay() {
      return this.display;
   }

   public int getWidth() {
      return this.width;
   }

   public void setWidth(int var1) {
      this.width = var1;
   }

   public final int getColor() {
      return this.color;
   }

   public TextButton(int x, int y, @NotNull String display, @NotNull Clickable action, int width, int color) {
      Intrinsics.checkParameterIsNotNull(display, "display");
      Intrinsics.checkParameterIsNotNull(action, "action");
      super();
      this.x = x;
      this.y = y;
      this.display = display;
      this.action = action;
      this.width = width;
      this.color = color;
      this.height = 16;
      FontRenderer fontRenderer = Minecraft.func_71410_x().field_71466_p;
      this.setWidth(fontRenderer.func_78256_a(ChatFormatKt.translateFormatting(this.display)));
   }

   // $FF: synthetic method
   public TextButton(int var1, int var2, String var3, Clickable var4, int var5, int var6, int var7, DefaultConstructorMarker var8) {
      if ((var7 & 16) != 0) {
         var5 = 28;
      }

      if ((var7 & 32) != 0) {
         var6 = 0;
      }

      this(var1, var2, var3, var4, var5, var6);
   }

   public void postRender(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      Widget.DefaultImpls.postRender(this, guiBase);
   }

   public void onClick(int mouseX, int mouseY, int mouseButton) {
      this.action.onClick(mouseX, mouseY, mouseButton);
   }
}

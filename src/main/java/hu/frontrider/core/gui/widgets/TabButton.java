package hu.frontrider.core.gui.widgets;

import hu.frontrider.core.gui.BaseGui;
import hu.frontrider.core.gui.widgets.interfaces.Clickable;
import hu.frontrider.core.gui.widgets.interfaces.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0002\u0010\tJ!\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0096\u0001J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010¨\u0006\""},
   d2 = {"Lhu/frontrider/core/gui/widgets/TabButton;", "Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "Lhu/frontrider/core/gui/widgets/interfaces/Clickable;", "x", "", "y", "texture", "Lnet/minecraft/util/ResourceLocation;", "action", "(IILnet/minecraft/util/ResourceLocation;Lhu/frontrider/core/gui/widgets/interfaces/Clickable;)V", "getAction", "()Lhu/frontrider/core/gui/widgets/interfaces/Clickable;", "height", "getHeight", "()I", "setHeight", "(I)V", "getTexture", "()Lnet/minecraft/util/ResourceLocation;", "width", "getWidth", "setWidth", "getX", "setX", "getY", "setY", "onClick", "", "mouseX", "mouseY", "mouseButton", "render", "guiBase", "Lhu/frontrider/core/gui/BaseGui;", "Thaumic Arcana"}
)
public final class TabButton implements Widget, Clickable {
   private int height;
   private int width;
   private int x;
   private int y;
   @NotNull
   private final ResourceLocation texture;
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

   public void render(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      guiBase.drawTab$Thaumic_Arcana(this.getX(), this.getY(), this.texture);
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
   public final ResourceLocation getTexture() {
      return this.texture;
   }

   @NotNull
   public final Clickable getAction() {
      return this.action;
   }

   public TabButton(int x, int y, @NotNull ResourceLocation texture, @NotNull Clickable action) {
      Intrinsics.checkParameterIsNotNull(texture, "texture");
      Intrinsics.checkParameterIsNotNull(action, "action");
      super();
      this.x = x;
      this.y = y;
      this.texture = texture;
      this.action = action;
      this.height = 16;
      this.width = 28;
   }

   public void postRender(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      Widget.DefaultImpls.postRender(this, guiBase);
   }

   public void update() {
      Widget.DefaultImpls.update(this);
   }

   public void onClick(int mouseX, int mouseY, int mouseButton) {
      this.action.onClick(mouseX, mouseY, mouseButton);
   }
}

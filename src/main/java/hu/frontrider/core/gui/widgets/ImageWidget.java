package hu.frontrider.core.gui.widgets;

import hu.frontrider.core.gui.BaseGui;
import hu.frontrider.core.gui.widgets.interfaces.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0011¨\u0006\u0018"},
   d2 = {"Lhu/frontrider/core/gui/widgets/ImageWidget;", "Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "x", "", "y", "width", "height", "texture", "Lnet/minecraft/util/ResourceLocation;", "(IIIILnet/minecraft/util/ResourceLocation;)V", "getHeight", "()I", "getTexture", "()Lnet/minecraft/util/ResourceLocation;", "getWidth", "getX", "setX", "(I)V", "getY", "setY", "render", "", "guiBase", "Lhu/frontrider/core/gui/BaseGui;", "Thaumic Arcana"}
)
public final class ImageWidget implements Widget {
   private int x;
   private int y;
   private final int width;
   private final int height;
   @NotNull
   private final ResourceLocation texture;

   public void render(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      Minecraft var10000 = guiBase.field_146297_k;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "guiBase.mc");
      var10000.func_110434_K().func_110577_a(this.texture);
      Gui.func_146110_a(this.getX(), this.getY(), 0.0F, 0.0F, this.width, this.height, (float)this.width, (float)this.height);
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

   public final int getHeight() {
      return this.height;
   }

   @NotNull
   public final ResourceLocation getTexture() {
      return this.texture;
   }

   public ImageWidget(int x, int y, int width, int height, @NotNull ResourceLocation texture) {
      Intrinsics.checkParameterIsNotNull(texture, "texture");
      super();
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.texture = texture;
   }

   public void postRender(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");
      Widget.DefaultImpls.postRender(this, guiBase);
   }

   public void update() {
      Widget.DefaultImpls.update(this);
   }
}

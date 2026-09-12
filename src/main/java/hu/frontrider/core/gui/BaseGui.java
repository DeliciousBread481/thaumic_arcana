package hu.frontrider.core.gui;

import hu.frontrider.core.gui.widgets.interfaces.Clickable;
import hu.frontrider.core.gui.widgets.interfaces.DebugDraw;
import hu.frontrider.core.gui.widgets.interfaces.Widget;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J-\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0019J5\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b J \u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0016J\u001d\u0010&\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0000¢\u0006\u0002\b'J%\u0010&\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b'JA\u0010*\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u001f2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010\u0018\u001a\u00020\u0015H\u0000¢\u0006\u0002\b/J-\u00100\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0000¢\u0006\u0002\b2J\u0006\u00103\u001a\u00020\u0015J\u0006\u00104\u001a\u00020\u0015J \u00105\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u0015H\u0014J\r\u00107\u001a\u00020\u000fH\u0000¢\u0006\u0002\b8J\u0015\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020%H\u0000¢\u0006\u0002\b;R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006="},
   d2 = {"Lhu/frontrider/core/gui/BaseGui;", "Lnet/minecraft/client/gui/GuiScreen;", "()V", "staticWidgets", "", "Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "getStaticWidgets", "()[Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "setStaticWidgets", "([Lhu/frontrider/core/gui/widgets/interfaces/Widget;)V", "[Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "widgets", "getWidgets", "setWidgets", "debugDraw", "", "widget", "", "debugDraw$Thaumic_Arcana", "drawHorizontalLinePublic", "x", "", "endX", "y", "color", "drawHorizontalLinePublic$Thaumic_Arcana", "drawItemStack", "stack", "Lnet/minecraft/item/ItemStack;", "xoffset", "display", "", "drawItemStack$Thaumic_Arcana", "drawScreen", "mouseX", "mouseY", "partialTicks", "", "drawTab", "drawTab$Thaumic_Arcana", "resourceLocation", "Lnet/minecraft/util/ResourceLocation;", "drawText", "width", "formattedText", "multiLine", "", "drawText$Thaumic_Arcana", "drawVerticalLinePublic", "startY", "drawVerticalLinePublic$Thaumic_Arcana", "getHeight", "getWidth", "mouseClicked", "mouseButton", "reset", "reset$Thaumic_Arcana", "setZlevel", "level", "setZlevel$Thaumic_Arcana", "Companion", "Thaumic Arcana"}
)
public class BaseGui extends GuiScreen {
   @NotNull
   public Widget[] widgets;
   @NotNull
   public Widget[] staticWidgets;
   @NotNull
   private static final ResourceLocation BACKGROUND = new ResourceLocation("thaumic_arcana", "textures/gui/guide/base.png");
   @NotNull
   private static final ResourceLocation TAB = new ResourceLocation("thaumic_arcana", "textures/gui/guide/tab.png");
   private static int xSize = 176;
   private static int ySize = 166;
   private static boolean debug = true;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @NotNull
   public final Widget[] getWidgets() {
      Widget[] var10000 = this.widgets;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("widgets");
      }

      return var10000;
   }

   public final void setWidgets(@NotNull Widget[] var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.widgets = var1;
   }

   @NotNull
   public final Widget[] getStaticWidgets() {
      Widget[] var10000 = this.staticWidgets;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("staticWidgets");
      }

      return var10000;
   }

   public final void setStaticWidgets(@NotNull Widget[] var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.staticWidgets = var1;
   }

   public final int getWidth() {
      return this.field_146294_l;
   }

   public final int getHeight() {
      return this.field_146295_m;
   }

   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft var10000 = this.field_146297_k;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "this.mc");
      var10000.func_110434_K().func_110577_a(BACKGROUND);
      int i = (this.field_146294_l - xSize) / 2;
      int j = (this.field_146295_m - ySize) / 2;
      this.func_73729_b(i, j, 0, 0, xSize, ySize);
      Widget[] var22 = this.staticWidgets;
      if (var22 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("staticWidgets");
      }

      Widget[] var10001 = this.widgets;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("widgets");
      }

      Widget[] arrayOfWidgets = (Widget[])ArraysKt.plus(var22, var10001);

      for(Object element$iv : arrayOfWidgets) {
         ((Widget)element$iv).render(this);
      }

      for(Object element$iv : arrayOfWidgets) {
         ((Widget)element$iv).postRender(this);
      }

      if (debug) {
         for(Object element$iv : arrayOfWidgets) {
            this.debugDraw$Thaumic_Arcana(element$iv);
         }
      }

   }

   protected void func_73864_a(int mouseX, int mouseY, int mouseButton) {
      Widget[] var10000 = this.staticWidgets;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("staticWidgets");
      }

      Widget[] var10001 = this.widgets;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("widgets");
      }

      Object[] $receiver$iv = ArraysKt.plus(var10000, var10001);
      Iterator $receiver$iv$iv = $receiver$iv;
      Collection destination$iv$iv = (Collection)(new ArrayList());

      for(Object element$iv$iv : $receiver$iv) {
         Widget it = (Widget)element$iv$iv;
         if (it instanceof Clickable) {
            destination$iv$iv.add(element$iv$iv);
         }
      }

      $receiver$iv = (Iterable)((List)destination$iv$iv);
      destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));

      for(Object item$iv$iv : $receiver$iv) {
         Widget it = (Widget)item$iv$iv;
         if (it == null) {
            throw new TypeCastException("null cannot be cast to non-null type hu.frontrider.core.gui.widgets.interfaces.Clickable");
         }

         Clickable var16 = (Clickable)it;
         destination$iv$iv.add(var16);
      }

      $receiver$iv = (Iterable)((List)destination$iv$iv);
      $receiver$iv$iv = $receiver$iv.iterator();

      while(true) {
         if (!$receiver$iv$iv.hasNext()) {
            var26 = null;
            break;
         }

         Object element$iv = $receiver$iv$iv.next();
         Clickable it = (Clickable)element$iv;
         if (it.getX() <= mouseX && it.getX() + it.getWidth() >= mouseX && it.getY() <= mouseY && it.getY() + it.getHeight() >= mouseY) {
            var26 = element$iv;
            break;
         }
      }

      Clickable var27 = (Clickable)var26;
      if ((Clickable)var26 != null) {
         Clickable clickable = var27;
         clickable.onClick(mouseX, mouseY, mouseButton);
      }
   }

   public final void drawItemStack$Thaumic_Arcana(@NotNull ItemStack stack, int x, int y, int xoffset, @NotNull String display) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(display, "display");
      GlStateManager.func_179109_b(0.0F, 0.0F, 32.0F);
      this.field_73735_i = 200.0F;
      this.field_146296_j.field_77023_b = 200.0F;
      this.field_146296_j.func_175042_a(stack, x, y);
      this.field_73735_i = 0.0F;
      this.field_146296_j.field_77023_b = 0.0F;
   }

   public final void drawTab$Thaumic_Arcana(int x, int y, @NotNull ResourceLocation resourceLocation) {
      Intrinsics.checkParameterIsNotNull(resourceLocation, "resourceLocation");
      Minecraft var10000 = this.field_146297_k;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "this.mc");
      var10000.func_110434_K().func_110577_a(TAB);
      GuiScreen.func_146110_a(x, y, 0.0F, 0.0F, 28, 16, 28.0F, 16.0F);
      var10000 = this.field_146297_k;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "this.mc");
      var10000.func_110434_K().func_110577_a(resourceLocation);
      GuiScreen.func_146110_a(x + 6, y, 0.0F, 0.0F, 16, 16, 16.0F, 16.0F);
   }

   public final void drawTab$Thaumic_Arcana(int x, int y) {
      Minecraft var10000 = this.field_146297_k;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "this.mc");
      var10000.func_110434_K().func_110577_a(TAB);
      GuiScreen.func_146110_a(x, y, 0.0F, 0.0F, 28, 16, 28.0F, 16.0F);
   }

   public final void drawText$Thaumic_Arcana(int x, int y, int width, @NotNull String formattedText, boolean multiLine, int color) {
      Intrinsics.checkParameterIsNotNull(formattedText, "formattedText");
      if (multiLine) {
         this.field_146289_q.func_78279_b(formattedText, x, y, width, color);
      } else {
         this.field_146289_q.func_78276_b(formattedText, x, y, color);
      }

   }

   // $FF: synthetic method
   public static void drawText$Thaumic_Arcana$default(BaseGui var0, int var1, int var2, int var3, String var4, boolean var5, int var6, int var7, Object var8) {
      if (var8 != null) {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawText");
      } else {
         if ((var7 & 16) != 0) {
            var5 = false;
         }

         if ((var7 & 32) != 0) {
            var6 = 0;
         }

         var0.drawText$Thaumic_Arcana(var1, var2, var3, var4, var5, var6);
      }
   }

   public final void reset$Thaumic_Arcana() {
      this.widgets = new Widget[0];
   }

   public final void debugDraw$Thaumic_Arcana(@NotNull Object widget) {
      Intrinsics.checkParameterIsNotNull(widget, "widget");
      this.field_73735_i = 1000.0F;
      if (widget instanceof Clickable) {
         Clickable $receiver = (Clickable)widget;
         this.func_73728_b($receiver.getX(), $receiver.getY(), $receiver.getY() + $receiver.getHeight(), 16737535);
         this.func_73728_b($receiver.getX() + $receiver.getWidth(), $receiver.getY(), $receiver.getY() + $receiver.getHeight(), 16737535);
         this.func_73730_a($receiver.getX(), $receiver.getX() + $receiver.getWidth(), $receiver.getY(), 4);
         this.func_73730_a($receiver.getX(), $receiver.getX() + $receiver.getWidth(), $receiver.getY() + $receiver.getHeight(), 16737535);
      }

      if (widget instanceof DebugDraw) {
         ((DebugDraw)widget).debugDraw(this);
      }

      this.field_73735_i = 0.0F;
   }

   public final void drawVerticalLinePublic$Thaumic_Arcana(int x, int startY, int y, int color) {
      this.func_73728_b(x, startY, y, color);
   }

   public final void drawHorizontalLinePublic$Thaumic_Arcana(int x, int endX, int y, int color) {
      this.func_73730_a(x, endX, y, color);
   }

   public final void setZlevel$Thaumic_Arcana(float level) {
      this.field_73735_i = level;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"},
      d2 = {"Lhu/frontrider/core/gui/BaseGui$Companion;", "", "()V", "BACKGROUND", "Lnet/minecraft/util/ResourceLocation;", "getBACKGROUND", "()Lnet/minecraft/util/ResourceLocation;", "TAB", "getTAB", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "xSize", "", "getXSize", "()I", "setXSize", "(I)V", "ySize", "getYSize", "setYSize", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final ResourceLocation getBACKGROUND() {
         return BaseGui.BACKGROUND;
      }

      @NotNull
      public final ResourceLocation getTAB() {
         return BaseGui.TAB;
      }

      public final int getXSize() {
         return BaseGui.xSize;
      }

      public final void setXSize(int var1) {
         BaseGui.xSize = var1;
      }

      public final int getYSize() {
         return BaseGui.ySize;
      }

      public final void setYSize(int var1) {
         BaseGui.ySize = var1;
      }

      public final boolean getDebug() {
         return BaseGui.debug;
      }

      public final void setDebug(boolean var1) {
         BaseGui.debug = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

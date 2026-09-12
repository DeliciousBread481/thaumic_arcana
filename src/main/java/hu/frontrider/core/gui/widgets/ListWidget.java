package hu.frontrider.core.gui.widgets;

import hu.frontrider.core.gui.BaseGui;
import hu.frontrider.core.gui.widgets.interfaces.Clickable;
import hu.frontrider.core.gui.widgets.interfaces.DebugDraw;
import hu.frontrider.core.gui.widgets.interfaces.Widget;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u000b\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u0006#"},
   d2 = {"Lhu/frontrider/core/gui/widgets/ListWidget;", "Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "Lhu/frontrider/core/gui/widgets/interfaces/Clickable;", "Lhu/frontrider/core/gui/widgets/interfaces/DebugDraw;", "widgets", "", "x", "", "y", "ySpacing", "width", "height", "([Lhu/frontrider/core/gui/widgets/interfaces/Widget;IIIII)V", "getHeight", "()I", "setHeight", "(I)V", "[Lhu/frontrider/core/gui/widgets/interfaces/Widget;", "getWidth", "setWidth", "getX", "setX", "getY", "setY", "getYSpacing", "debugDraw", "", "guiBase", "Lhu/frontrider/core/gui/BaseGui;", "onClick", "mouseX", "mouseY", "mouseButton", "postRender", "render", "Thaumic Arcana"}
)
public final class ListWidget implements Widget, Clickable, DebugDraw {
   private final Widget[] widgets;
   private int x;
   private int y;
   private final int ySpacing;
   private int width;
   private int height;

   public void render(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");

      for(Object element$iv : this.widgets) {
         ((Widget)element$iv).render(guiBase);
      }

   }

   public void postRender(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");

      for(Object element$iv : this.widgets) {
         ((Widget)element$iv).postRender(guiBase);
      }

   }

   public void debugDraw(@NotNull BaseGui guiBase) {
      Intrinsics.checkParameterIsNotNull(guiBase, "guiBase");

      for(Object element$iv : this.widgets) {
         guiBase.debugDraw$Thaumic_Arcana(element$iv);
      }

   }

   public void onClick(int mouseX, int mouseY, int mouseButton) {
      Object[] $receiver$iv = this.widgets;
      Object var6 = $receiver$iv;
      Collection destination$iv$iv = (Collection)(new ArrayList());

      for(Object element$iv$iv : $receiver$iv) {
         if (element$iv$iv instanceof Clickable) {
            destination$iv$iv.add(element$iv$iv);
         }
      }

      Iterable $receiver$iv = (Iterable)((List)destination$iv$iv);
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
      Iterator $receiver$iv$iv = $receiver$iv.iterator();

      Object var10000;
      while(true) {
         if (!$receiver$iv$iv.hasNext()) {
            var10000 = null;
            break;
         }

         Object element$iv = $receiver$iv$iv.next();
         Clickable it = (Clickable)element$iv;
         if (it.getX() <= mouseX && it.getX() + it.getWidth() >= mouseX && it.getY() <= mouseY && it.getY() + it.getHeight() >= mouseY) {
            var10000 = element$iv;
            break;
         }
      }

      Clickable var26 = (Clickable)var10000;
      if ((Clickable)var10000 != null) {
         Clickable clickable = var26;
         clickable.onClick(mouseX, mouseY, mouseButton);
      }
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

   public final int getYSpacing() {
      return this.ySpacing;
   }

   public int getWidth() {
      return this.width;
   }

   public void setWidth(int var1) {
      this.width = var1;
   }

   public int getHeight() {
      return this.height;
   }

   public void setHeight(int var1) {
      this.height = var1;
   }

   public ListWidget(@NotNull Widget[] widgets, int x, int y, int ySpacing, int width, int height) {
      Intrinsics.checkParameterIsNotNull(widgets, "widgets");
      super();
      this.x = x;
      this.y = y;
      this.ySpacing = ySpacing;
      this.width = width;
      this.height = height;
      int yspace = this.getY() + 2;
      Widget[] var9 = widgets;
      Collection destination$iv$iv = (Collection)(new ArrayList(widgets.length));

      for(Object item$iv$iv : widgets) {
         ((Widget)item$iv$iv).setX(this.getX() + ((Widget)item$iv$iv).getX());
         ((Widget)item$iv$iv).setY(yspace);
         yspace += this.ySpacing;
         ((Widget)item$iv$iv).update();
         destination$iv$iv.add(item$iv$iv);
      }

      List var19 = (List)destination$iv$iv;
      Collection $receiver$iv = (Collection)var19;
      Object[] var10000 = $receiver$iv.toArray(new Widget[0]);
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      } else {
         Object[] var21 = var10000;
         this.widgets = (Widget[])var21;
      }
   }

   // $FF: synthetic method
   public ListWidget(Widget[] var1, int var2, int var3, int var4, int var5, int var6, int var7, DefaultConstructorMarker var8) {
      if ((var7 & 16) != 0) {
         var5 = 0;
      }

      if ((var7 & 32) != 0) {
         var6 = 0;
      }

      this(var1, var2, var3, var4, var5, var6);
   }

   public void update() {
      Widget.DefaultImpls.update(this);
   }
}

package hu.frontrider.arcana.util;

import hu.frontrider.arcana.ThaumicArcana;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J*\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0007¨\u0006\u000f"},
   d2 = {"Lhu/frontrider/arcana/util/UtilTextureRender;", "", "()V", "drawTextureSimple", "", "res", "Lnet/minecraft/util/ResourceLocation;", "x", "", "y", "w", "h", "drawTextureSquare", "img", "dim", "Thaumic Arcana"}
)
public final class UtilTextureRender {
   public static final UtilTextureRender INSTANCE;

   @SideOnly(Side.CLIENT)
   public final void drawTextureSimple(@Nullable ResourceLocation res, int x, int y, int w, int h) {
      if (res != null) {
         try {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft var10000 = Minecraft.func_71410_x();
            Intrinsics.checkExpressionValueIsNotNull(var10000, "Minecraft.getMinecraft()");
            var10000.func_110434_K().func_110577_a(res);
            Gui.func_146110_a(x, y, 0.0F, 0.0F, w, h, (float)w, (float)h);
         } catch (NullPointerException e) {
            ThaumicArcana.INSTANCE.getLogger().error("Null pointer drawTexture;Simple " + res.func_110623_a());
            ThaumicArcana.INSTANCE.getLogger().error(e.getMessage());
            e.printStackTrace();
         } catch (ReportedException e) {
            ThaumicArcana.INSTANCE.getLogger().error("net.minecraft.util.ReportedException ");
            ThaumicArcana.INSTANCE.getLogger().error(res.func_110624_b() + ":" + res.func_110623_a());
            ThaumicArcana.INSTANCE.getLogger().error(e.getMessage());
            e.printStackTrace();
         }

      }
   }

   @SideOnly(Side.CLIENT)
   public final void drawTextureSquare(@Nullable ResourceLocation img, int x, int y, int dim) {
      if (img != null) {
         this.drawTextureSimple(img, x, y, dim, dim);
      }
   }

   private UtilTextureRender() {
   }

   static {
      UtilTextureRender var0 = new UtilTextureRender();
      INSTANCE = var0;
   }
}

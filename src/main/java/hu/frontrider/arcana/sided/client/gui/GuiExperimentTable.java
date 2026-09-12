package hu.frontrider.arcana.sided.client.gui;

import hu.frontrider.arcana.blocks.experiments.tiles.TileEntityExperimentTable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(Side.CLIENT)
@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J \u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lhu/frontrider/arcana/sided/client/gui/GuiExperimentTable;", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "container", "Lnet/minecraft/inventory/Container;", "playerInv", "Lnet/minecraft/entity/player/InventoryPlayer;", "experimentTableTileEntity", "Lhu/frontrider/arcana/blocks/experiments/tiles/TileEntityExperimentTable;", "(Lnet/minecraft/inventory/Container;Lnet/minecraft/entity/player/InventoryPlayer;Lhu/frontrider/arcana/blocks/experiments/tiles/TileEntityExperimentTable;)V", "drawGuiContainerBackgroundLayer", "", "partialTicks", "", "mouseX", "", "mouseY", "drawScreen", "mouseClicked", "mouseButton", "Companion", "Thaumic Arcana"}
)
public final class GuiExperimentTable extends GuiContainer {
   private final InventoryPlayer playerInv;
   private final TileEntityExperimentTable experimentTableTileEntity;
   private static final ResourceLocation PAPER = new ResourceLocation("thaumcraft:textures/gui/paper.png");
   private static final ResourceLocation WOWRKBENCH = new ResourceLocation("thaumcraft:textures/gui/arcaneworkbench.png");
   private static final ResourceLocation GUI_BASE = new ResourceLocation("thaumcraft:textures/gui/gui_base.png");
   private static int xPaperSize = 256;
   private static int yPaperSize = 256;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
      int x = (this.field_146294_l - this.field_146999_f) / 2;
      int y = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_146276_q_();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft var10000 = this.field_146297_k;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "mc");
      var10000.func_110434_K().func_110577_a(WOWRKBENCH);
      int i = 0;

      for(byte var7 = 1; i <= var7; ++i) {
         int j = 0;

         for(byte var9 = 2; j <= var9; ++j) {
            this.func_175174_a((float)x + (float)92 + (float)(i * 36), (float)y - (float)15 + (float)(j * 36), 148, 52, 40, 40);
         }
      }

      var10000 = this.field_146297_k;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "mc");
      var10000.func_110434_K().func_110577_a(PAPER);
      GuiContainer.func_146110_a(x - 20, y - 20, 0.0F, 0.0F, xPaperSize / 2, yPaperSize / 2, 128.0F, 128.0F);
      var10000 = this.field_146297_k;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "mc");
      var10000.func_110434_K().func_110577_a(GUI_BASE);
      this.func_175174_a((float)x + (float)75, (float)y + (float)83, 65, 96, 14, 16);
      this.func_175174_a((float)x, (float)y + (float)107, 0, 167, 176, 89);
   }

   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
      super.func_73863_a(mouseX, mouseY, partialTicks);
      this.func_191948_b(mouseX, mouseY);
   }

   protected void func_73864_a(int mouseX, int mouseY, int mouseButton) {
      int x = (this.field_146294_l - this.field_146999_f) / 2;
      int y = (this.field_146295_m - this.field_147000_g) / 2;
      if (mouseX > x + 75 && x < x + 75 + 14 && mouseY > y + 83 && mouseY < y + 83 + 16) {
         System.out.println();
      }

   }

   public GuiExperimentTable(@NotNull Container container, @NotNull InventoryPlayer playerInv, @NotNull TileEntityExperimentTable experimentTableTileEntity) {
      Intrinsics.checkParameterIsNotNull(container, "container");
      Intrinsics.checkParameterIsNotNull(playerInv, "playerInv");
      Intrinsics.checkParameterIsNotNull(experimentTableTileEntity, "experimentTableTileEntity");
      super(container);
      this.playerInv = playerInv;
      this.experimentTableTileEntity = experimentTableTileEntity;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0010"},
      d2 = {"Lhu/frontrider/arcana/sided/client/gui/GuiExperimentTable$Companion;", "", "()V", "GUI_BASE", "Lnet/minecraft/util/ResourceLocation;", "PAPER", "WOWRKBENCH", "xPaperSize", "", "getXPaperSize", "()I", "setXPaperSize", "(I)V", "yPaperSize", "getYPaperSize", "setYPaperSize", "Thaumic Arcana"}
   )
   public static final class Companion {
      protected final int getXPaperSize() {
         return GuiExperimentTable.xPaperSize;
      }

      protected final void setXPaperSize(int var1) {
         GuiExperimentTable.xPaperSize = var1;
      }

      protected final int getYPaperSize() {
         return GuiExperimentTable.yPaperSize;
      }

      protected final void setYPaperSize(int var1) {
         GuiExperimentTable.yPaperSize = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

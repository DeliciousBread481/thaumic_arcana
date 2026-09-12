package hu.frontrider.arcana.sided;

import hu.frontrider.arcana.blocks.experiments.tiles.TileEntityExperimentTable;
import hu.frontrider.arcana.containers.ContainerExperimentTableCage;
import hu.frontrider.arcana.sided.client.gui.GuiExperimentTable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0017J:\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016¨\u0006\u0010"},
   d2 = {"Lhu/frontrider/arcana/sided/GuiHandler;", "Lnet/minecraftforge/fml/common/network/IGuiHandler;", "()V", "getClientGuiElement", "", "ID", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "world", "Lnet/minecraft/world/World;", "x", "y", "z", "getServerGuiElement", "GuiHolder", "Thaumic Arcana"}
)
public final class GuiHandler implements IGuiHandler {
   public static final int EXPERIMENT_TABLE_CAGE = 0;
   public static final GuiHolder GuiHolder = new GuiHolder((DefaultConstructorMarker)null);

   @Nullable
   public Object getServerGuiElement(int ID, @NotNull EntityPlayer player, @NotNull World world, int x, int y, int z) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      Intrinsics.checkParameterIsNotNull(world, "world");
      ContainerExperimentTableCage var10000;
      switch (ID) {
         case 0:
            var10000 = new ContainerExperimentTableCage;
            InventoryPlayer var10002 = player.field_71071_by;
            Intrinsics.checkExpressionValueIsNotNull(var10002, "player.inventory");
            TileEntity var10003 = world.func_175625_s(new BlockPos(x, y, z));
            if (var10003 == null) {
               throw new TypeCastException("null cannot be cast to non-null type hu.frontrider.arcana.blocks.experiments.tiles.TileEntityExperimentTable");
            }

            var10000.<init>(var10002, (TileEntityExperimentTable)var10003);
            break;
         default:
            var10000 = null;
      }

      return var10000;
   }

   @SideOnly(Side.CLIENT)
   @Nullable
   public Object getClientGuiElement(int ID, @NotNull EntityPlayer player, @NotNull World world, int x, int y, int z) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      Intrinsics.checkParameterIsNotNull(world, "world");
      GuiExperimentTable var10000;
      switch (ID) {
         case 0:
            TileEntity tileEntity = world.func_175625_s(new BlockPos(x, y, z));
            var10000 = new GuiExperimentTable;
            Object var10002 = this.getServerGuiElement(ID, player, world, x, y, z);
            if (var10002 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.inventory.Container");
            }

            Container var8 = (Container)var10002;
            InventoryPlayer var10003 = player.field_71071_by;
            Intrinsics.checkExpressionValueIsNotNull(var10003, "player.inventory");
            if (tileEntity == null) {
               throw new TypeCastException("null cannot be cast to non-null type hu.frontrider.arcana.blocks.experiments.tiles.TileEntityExperimentTable");
            }

            var10000.<init>(var8, var10003, (TileEntityExperimentTable)tileEntity);
            break;
         default:
            var10000 = null;
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"},
      d2 = {"Lhu/frontrider/arcana/sided/GuiHandler$GuiHolder;", "", "()V", "EXPERIMENT_TABLE_CAGE", "", "Thaumic Arcana"}
   )
   public static final class GuiHolder {
      private GuiHolder() {
      }

      // $FF: synthetic method
      public GuiHolder(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

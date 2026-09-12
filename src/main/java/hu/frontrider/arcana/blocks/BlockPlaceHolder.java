package hu.frontrider.arcana.blocks;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"},
   d2 = {"Lhu/frontrider/arcana/blocks/BlockPlaceHolder;", "Lhu/frontrider/arcana/blocks/BlockTileEntity;", "Lhu/frontrider/arcana/blocks/PlaceHolderTile;", "material", "Lnet/minecraft/block/material/Material;", "name", "", "(Lnet/minecraft/block/material/Material;Ljava/lang/String;)V", "tileEntityClass", "Ljava/lang/Class;", "getTileEntityClass", "()Ljava/lang/Class;", "createTileEntity", "world", "Lnet/minecraft/world/World;", "state", "Lnet/minecraft/block/state/IBlockState;", "isFullBlock", "", "isOpaqueCube", "onBlockHarvested", "", "worldIn", "pos", "Lnet/minecraft/util/math/BlockPos;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "setPos", "targetPos", "Thaumic Arcana"}
)
public final class BlockPlaceHolder extends BlockTileEntity<PlaceHolderTile> {
   @NotNull
   public Class<PlaceHolderTile> getTileEntityClass() {
      return PlaceHolderTile.class;
   }

   @Nullable
   public PlaceHolderTile createTileEntity(@NotNull World world, @NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(state, "state");
      return new PlaceHolderTile((BlockPos)null, 1, (DefaultConstructorMarker)null);
   }

   public final void setPos(@NotNull World world, @NotNull BlockPos pos, @NotNull BlockPos targetPos) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(targetPos, "targetPos");
      TileEntity var10000 = world.func_175625_s(pos);
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type hu.frontrider.arcana.blocks.PlaceHolderTile");
      } else {
         ((PlaceHolderTile)var10000).setTargePos(targetPos);
      }
   }

   public boolean func_149662_c(@NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(state, "state");
      return false;
   }

   public boolean func_149730_j(@NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(state, "state");
      return false;
   }

   public void func_176208_a(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state, @NotNull EntityPlayer player) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(state, "state");
      Intrinsics.checkParameterIsNotNull(player, "player");
      TileEntity var10000 = worldIn.func_175625_s(pos);
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type hu.frontrider.arcana.blocks.PlaceHolderTile");
      } else {
         BlockPos targePos = ((PlaceHolderTile)var10000).getTargePos();
         IBlockState blockState = worldIn.func_180495_p(targePos);
         Intrinsics.checkExpressionValueIsNotNull(blockState, "blockState");
         Block var7 = blockState.func_177230_c();
         if (!(var7 instanceof BreakNotifier)) {
            var7 = null;
         }

         BreakNotifier var8 = (BreakNotifier)var7;
         if (var8 != null) {
            var8.notify(worldIn, targePos);
         }

      }
   }

   public BlockPlaceHolder(@NotNull Material material, @NotNull String name) {
      Intrinsics.checkParameterIsNotNull(material, "material");
      Intrinsics.checkParameterIsNotNull(name, "name");
      super(material, name);
   }
}

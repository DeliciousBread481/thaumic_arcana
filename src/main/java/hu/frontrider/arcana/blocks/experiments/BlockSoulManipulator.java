package hu.frontrider.arcana.blocks.experiments;

import hu.frontrider.arcana.blocks.BlockTileEntity;
import hu.frontrider.arcana.blocks.experiments.tiles.TileEntitySoulManipulator;
import hu.frontrider.arcana.capabilities.EssentiaRecieverTrait;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"},
   d2 = {"Lhu/frontrider/arcana/blocks/experiments/BlockSoulManipulator;", "Lhu/frontrider/arcana/blocks/BlockTileEntity;", "Lhu/frontrider/arcana/blocks/experiments/tiles/TileEntitySoulManipulator;", "()V", "tileEntityClass", "Ljava/lang/Class;", "getTileEntityClass", "()Ljava/lang/Class;", "createTileEntity", "world", "Lnet/minecraft/world/World;", "state", "Lnet/minecraft/block/state/IBlockState;", "Thaumic Arcana"}
)
public final class BlockSoulManipulator extends BlockTileEntity<TileEntitySoulManipulator> {
   @NotNull
   public Class<TileEntitySoulManipulator> getTileEntityClass() {
      return TileEntitySoulManipulator.class;
   }

   @NotNull
   public TileEntitySoulManipulator createTileEntity(@NotNull World world, @NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(state, "state");
      return new TileEntitySoulManipulator((EssentiaRecieverTrait)null, 1, (DefaultConstructorMarker)null);
   }

   public BlockSoulManipulator() {
      Material var10001 = Material.field_151575_d;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Material.WOOD");
      super(var10001, "birth_chamber");
   }
}

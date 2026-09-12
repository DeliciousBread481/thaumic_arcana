package hu.frontrider.arcana.blocks;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"},
   d2 = {"Lhu/frontrider/arcana/blocks/BlockTileEntity;", "TE", "Lnet/minecraft/tileentity/TileEntity;", "Lhu/frontrider/arcana/blocks/BlockBase;", "material", "Lnet/minecraft/block/material/Material;", "name", "", "(Lnet/minecraft/block/material/Material;Ljava/lang/String;)V", "tileEntityClass", "Ljava/lang/Class;", "getTileEntityClass", "()Ljava/lang/Class;", "createTileEntity", "world", "Lnet/minecraft/world/World;", "state", "Lnet/minecraft/block/state/IBlockState;", "(Lnet/minecraft/world/World;Lnet/minecraft/block/state/IBlockState;)Lnet/minecraft/tileentity/TileEntity;", "getTileEntity", "Lnet/minecraft/world/IBlockAccess;", "pos", "Lnet/minecraft/util/math/BlockPos;", "(Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/tileentity/TileEntity;", "hasTileEntity", "", "Thaumic Arcana"}
)
public abstract class BlockTileEntity<TE extends TileEntity> extends BlockBase {
   @NotNull
   public abstract Class<TE> getTileEntityClass();

   @NotNull
   public final TE getTileEntity(@NotNull IBlockAccess world, @NotNull BlockPos pos) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      return (TE)world.func_175625_s(pos);
   }

   public boolean hasTileEntity(@Nullable IBlockState state) {
      return true;
   }

   @Nullable
   public abstract TE createTileEntity(@NotNull World var1, @NotNull IBlockState var2);

   public BlockTileEntity(@NotNull Material material, @NotNull String name) {
      Intrinsics.checkParameterIsNotNull(material, "material");
      Intrinsics.checkParameterIsNotNull(name, "name");
      super(material, name);
   }
}

package hu.frontrider.arcana.blocks.effect;

import hu.frontrider.arcana.blocks.BlockTileEntity;
import hu.frontrider.arcana.blocks.effect.tiles.TileEssentiaMine;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006!"},
   d2 = {"Lhu/frontrider/arcana/blocks/effect/EssentiaMine;", "Lhu/frontrider/arcana/blocks/BlockTileEntity;", "Lhu/frontrider/arcana/blocks/effect/tiles/TileEssentiaMine;", "()V", "tileEntityClass", "Ljava/lang/Class;", "getTileEntityClass", "()Ljava/lang/Class;", "createTileEntity", "world", "Lnet/minecraft/world/World;", "state", "Lnet/minecraft/block/state/IBlockState;", "getBlockLayer", "Lnet/minecraft/util/BlockRenderLayer;", "getBoundingBox", "Lnet/minecraft/util/math/AxisAlignedBB;", "source", "Lnet/minecraft/world/IBlockAccess;", "pos", "Lnet/minecraft/util/math/BlockPos;", "isCollidable", "", "isFullBlock", "isOpaqueCube", "isTopSolid", "onEntityCollidedWithBlock", "", "worldIn", "entityIn", "Lnet/minecraft/entity/Entity;", "onEntityWalk", "Companion", "Thaumic Arcana"}
)
public final class EssentiaMine extends BlockTileEntity<TileEssentiaMine> {
   @NotNull
   private static final AxisAlignedBB aabb = new AxisAlignedBB((double)0.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)0.0625F, (double)1.0F);
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @NotNull
   public Class<TileEssentiaMine> getTileEntityClass() {
      return TileEssentiaMine.class;
   }

   @Nullable
   public TileEssentiaMine createTileEntity(@NotNull World world, @NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(state, "state");
      return new TileEssentiaMine(1000);
   }

   public void func_176199_a(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull Entity entityIn) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(entityIn, "entityIn");
      TileEntity tileEntity = worldIn.func_175625_s(pos);
      if (tileEntity != null) {
         if (entityIn instanceof EntityLivingBase) {
            TileEssentiaMine $receiver = (TileEssentiaMine)tileEntity;
            $receiver.applyEffect((EntityLivingBase)entityIn);
            if ($receiver.isUsedUp()) {
               worldIn.func_175698_g(pos);
            }
         }
      } else {
         worldIn.func_175698_g(pos);
      }

   }

   public void func_180634_a(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state, @NotNull Entity entityIn) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(state, "state");
      Intrinsics.checkParameterIsNotNull(entityIn, "entityIn");
      this.func_176199_a(worldIn, pos, entityIn);
   }

   @NotNull
   public AxisAlignedBB func_185496_a(@NotNull IBlockState state, @NotNull IBlockAccess source, @NotNull BlockPos pos) {
      Intrinsics.checkParameterIsNotNull(state, "state");
      Intrinsics.checkParameterIsNotNull(source, "source");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      return aabb;
   }

   public boolean func_149703_v() {
      return true;
   }

   public boolean func_185481_k(@NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(state, "state");
      return false;
   }

   public boolean func_149730_j(@NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(state, "state");
      return false;
   }

   public boolean func_149662_c(@NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(state, "state");
      return false;
   }

   @NotNull
   public BlockRenderLayer func_180664_k() {
      return BlockRenderLayer.CUTOUT;
   }

   public EssentiaMine() {
      Material var10001 = Material.field_151594_q;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Material.CIRCUITS");
      super(var10001, "essentia_mine");
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
      d2 = {"Lhu/frontrider/arcana/blocks/effect/EssentiaMine$Companion;", "", "()V", "aabb", "Lnet/minecraft/util/math/AxisAlignedBB;", "getAabb", "()Lnet/minecraft/util/math/AxisAlignedBB;", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final AxisAlignedBB getAabb() {
         return EssentiaMine.aabb;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

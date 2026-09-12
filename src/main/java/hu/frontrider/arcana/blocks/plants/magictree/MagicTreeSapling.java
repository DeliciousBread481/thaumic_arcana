package hu.frontrider.arcana.blocks.plants.magictree;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J(\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0014J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"},
   d2 = {"Lhu/frontrider/arcana/blocks/plants/magictree/MagicTreeSapling;", "Lnet/minecraft/block/BlockBush;", "Lnet/minecraft/block/IGrowable;", "generator", "Lnet/minecraft/world/gen/feature/WorldGenAbstractTree;", "(Lnet/minecraft/world/gen/feature/WorldGenAbstractTree;)V", "getGenerator", "()Lnet/minecraft/world/gen/feature/WorldGenAbstractTree;", "canGrow", "", "worldIn", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/BlockPos;", "state", "Lnet/minecraft/block/state/IBlockState;", "isClient", "canUseBonemeal", "rand", "Ljava/util/Random;", "createBlockState", "Lnet/minecraft/block/state/BlockStateContainer;", "getBoundingBox", "Lnet/minecraft/util/math/AxisAlignedBB;", "source", "Lnet/minecraft/world/IBlockAccess;", "grow", "", "isReplaceable", "updateTick", "Companion", "Thaumic Arcana"}
)
public final class MagicTreeSapling extends BlockBush implements IGrowable {
   @NotNull
   private final WorldGenAbstractTree generator;
   @NotNull
   private static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB((double)0.099999994F, (double)0.0F, (double)0.099999994F, (double)0.9F, (double)0.8F, (double)0.9F);
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @NotNull
   protected BlockStateContainer func_180661_e() {
      return new BlockStateContainer((Block)this, new IProperty[0]);
   }

   public boolean func_180670_a(@NotNull World worldIn, @NotNull Random rand, @NotNull BlockPos pos, @NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(rand, "rand");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(state, "state");
      return (double)worldIn.field_73012_v.nextFloat() < 0.45;
   }

   public void func_180650_b(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state, @NotNull Random rand) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(state, "state");
      Intrinsics.checkParameterIsNotNull(rand, "rand");
      if (!worldIn.field_72995_K) {
         super.func_180650_b(worldIn, pos, state, rand);
         if (!worldIn.func_175697_a(pos, 1)) {
            return;
         }

         if (worldIn.func_175671_l(pos.func_177984_a()) >= 9 && rand.nextInt(7) == 0) {
            this.func_176474_b(worldIn, rand, pos, state);
         }
      }

   }

   public void func_176474_b(@NotNull World worldIn, @NotNull Random rand, @NotNull BlockPos pos, @NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(rand, "rand");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(state, "state");
      this.generator.func_180709_b(worldIn, rand, pos);
   }

   public boolean func_176473_a(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state, boolean isClient) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(state, "state");
      return true;
   }

   public boolean func_176200_f(@NotNull IBlockAccess worldIn, @NotNull BlockPos pos) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      return false;
   }

   @NotNull
   public AxisAlignedBB func_185496_a(@NotNull IBlockState state, @NotNull IBlockAccess source, @NotNull BlockPos pos) {
      Intrinsics.checkParameterIsNotNull(state, "state");
      Intrinsics.checkParameterIsNotNull(source, "source");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      return SAPLING_AABB;
   }

   @NotNull
   public final WorldGenAbstractTree getGenerator() {
      return this.generator;
   }

   public MagicTreeSapling(@NotNull WorldGenAbstractTree generator) {
      Intrinsics.checkParameterIsNotNull(generator, "generator");
      super(Material.field_151584_j);
      this.generator = generator;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
      d2 = {"Lhu/frontrider/arcana/blocks/plants/magictree/MagicTreeSapling$Companion;", "", "()V", "SAPLING_AABB", "Lnet/minecraft/util/math/AxisAlignedBB;", "getSAPLING_AABB", "()Lnet/minecraft/util/math/AxisAlignedBB;", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      protected final AxisAlignedBB getSAPLING_AABB() {
         return MagicTreeSapling.SAPLING_AABB;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

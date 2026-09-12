package hu.frontrider.arcana.blocks.experiments;

import com.google.common.base.Predicate;
import hu.frontrider.arcana.ThaumicArcana;
import hu.frontrider.arcana.blocks.BlockTileEntity;
import hu.frontrider.arcana.blocks.experiments.tiles.TileEntityExperimentTable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumFacing.Plane;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0014J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\\\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0016J&\u0010(\u001a\u00020)2\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J:\u0010*\u001a\u00020)2\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J$\u0010/\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u00100\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u000105H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u00067"},
   d2 = {"Lhu/frontrider/arcana/blocks/experiments/ExperimentTable;", "Lhu/frontrider/arcana/blocks/BlockTileEntity;", "Lhu/frontrider/arcana/blocks/experiments/tiles/TileEntityExperimentTable;", "()V", "tileEntityClass", "Ljava/lang/Class;", "getTileEntityClass", "()Ljava/lang/Class;", "createBlockState", "Lnet/minecraft/block/state/BlockStateContainer;", "createTileEntity", "world", "Lnet/minecraft/world/World;", "state", "Lnet/minecraft/block/state/IBlockState;", "getBlockLayer", "Lnet/minecraft/util/BlockRenderLayer;", "getMetaFromState", "", "getRenderType", "Lnet/minecraft/util/EnumBlockRenderType;", "getStateFromMeta", "meta", "isFullCube", "", "isOpaqueCube", "onBlockActivated", "worldIn", "pos", "Lnet/minecraft/util/math/BlockPos;", "playerIn", "Lnet/minecraft/entity/player/EntityPlayer;", "hand", "Lnet/minecraft/util/EnumHand;", "facing", "Lnet/minecraft/util/EnumFacing;", "hitX", "", "hitY", "hitZ", "onBlockAdded", "", "onBlockPlacedBy", "placer", "Lnet/minecraft/entity/EntityLivingBase;", "stack", "Lnet/minecraft/item/ItemStack;", "setDefaultFacing", "withMirror", "mirrorIn", "Lnet/minecraft/util/Mirror;", "withRotation", "rot", "Lnet/minecraft/util/Rotation;", "Companion", "Thaumic Arcana"}
)
public final class ExperimentTable extends BlockTileEntity<TileEntityExperimentTable> {
   private static final PropertyDirection FACING;
   @ObjectHolder("minecraft:water_bucket")
   private static final Item water_bucket;
   @ObjectHolder("minecraft:bucket")
   private static final Item bucket;
   @ObjectHolder("thaumic_arcana:formula")
   @Nullable
   private static Item formula;
   @ObjectHolder("thaumcraft:salis_mundus")
   private static final Item sal_mundi;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @NotNull
   public Class<TileEntityExperimentTable> getTileEntityClass() {
      return TileEntityExperimentTable.class;
   }

   @NotNull
   public IBlockState func_176203_a(int meta) {
      EnumFacing enumfacing = EnumFacing.func_82600_a(meta);
      Intrinsics.checkExpressionValueIsNotNull(enumfacing, "enumfacing");
      if (enumfacing.func_176740_k() == Axis.Y) {
         enumfacing = EnumFacing.NORTH;
      }

      IBlockState var10000 = this.func_176223_P().func_177226_a((IProperty)FACING, (Comparable)enumfacing);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "this.defaultState.withProperty(FACING, enumfacing)");
      return var10000;
   }

   public boolean func_180639_a(@Nullable World worldIn, @Nullable BlockPos pos, @Nullable IBlockState state, @Nullable EntityPlayer playerIn, @Nullable EnumHand hand, @Nullable EnumFacing facing, float hitX, float hitY, float hitZ) {
      if (playerIn == null) {
         Intrinsics.throwNpe();
      }

      ItemStack itemMainhand = playerIn.func_184614_ca();
      ItemStack itemOffhand = playerIn.func_184592_cb();
      if (!playerIn.func_70093_af()) {
         ThaumicArcana var14 = ThaumicArcana.INSTANCE;
         if (pos == null) {
            Intrinsics.throwNpe();
         }

         playerIn.openGui(var14, 0, worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
         return true;
      } else {
         if (worldIn == null) {
            Intrinsics.throwNpe();
         }

         if (!worldIn.field_72995_K) {
            return true;
         } else {
            Intrinsics.checkExpressionValueIsNotNull(itemMainhand, "itemMainhand");
            Item itemMainhandItem = itemMainhand.func_77973_b();
            Intrinsics.checkExpressionValueIsNotNull(itemOffhand, "itemOffhand");
            Item item = itemOffhand.func_77973_b();
            if (itemMainhandItem == Items.field_151069_bo && item == sal_mundi) {
               itemMainhand.func_190918_g(1);
               itemOffhand.func_190918_g(1);
               ItemStack var10001 = new ItemStack;
               Item var10003 = formula;
               if (var10003 == null) {
                  Intrinsics.throwNpe();
               }

               var10001.<init>(var10003, 1);
               playerIn.func_191521_c(var10001);
               return true;
            } else {
               return false;
            }
         }
      }
   }

   public int func_176201_c(@NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(state, "state");
      Comparable var10000 = state.func_177229_b((IProperty)FACING);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "state.getValue(FACING)");
      return ((EnumFacing)var10000).func_176745_a();
   }

   @NotNull
   public IBlockState func_185499_a(@NotNull IBlockState state, @Nullable Rotation rot) {
      Intrinsics.checkParameterIsNotNull(state, "state");
      IProperty var10001 = (IProperty)FACING;
      if (rot == null) {
         Intrinsics.throwNpe();
      }

      IBlockState var10000 = state.func_177226_a(var10001, (Comparable)rot.func_185831_a((EnumFacing)state.func_177229_b((IProperty)FACING)));
      Intrinsics.checkExpressionValueIsNotNull(var10000, "state.withProperty(FACIN…(state.getValue(FACING)))");
      return var10000;
   }

   @NotNull
   public IBlockState func_185471_a(@NotNull IBlockState state, @Nullable Mirror mirrorIn) {
      Intrinsics.checkParameterIsNotNull(state, "state");
      if (mirrorIn == null) {
         Intrinsics.throwNpe();
      }

      IBlockState var10000 = state.func_185907_a(mirrorIn.func_185800_a((EnumFacing)state.func_177229_b((IProperty)FACING)));
      Intrinsics.checkExpressionValueIsNotNull(var10000, "state.withRotation(mirro…(state.getValue(FACING)))");
      return var10000;
   }

   @NotNull
   protected BlockStateContainer func_180661_e() {
      return new BlockStateContainer(this, new IProperty[]{(IProperty)FACING});
   }

   @NotNull
   public EnumBlockRenderType func_149645_b(@Nullable IBlockState state) {
      return EnumBlockRenderType.MODEL;
   }

   @NotNull
   public BlockRenderLayer func_180664_k() {
      return BlockRenderLayer.CUTOUT;
   }

   public boolean func_149686_d(@Nullable IBlockState state) {
      return false;
   }

   public boolean func_149662_c(@Nullable IBlockState state) {
      return false;
   }

   public void func_176213_c(@Nullable World worldIn, @Nullable BlockPos pos, @Nullable IBlockState state) {
      if (worldIn == null) {
         Intrinsics.throwNpe();
      }

      this.setDefaultFacing(worldIn, pos, state);
   }

   private final void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
      if (!worldIn.field_72995_K) {
         if (pos == null) {
            Intrinsics.throwNpe();
         }

         IBlockState iblockstate = worldIn.func_180495_p(pos.func_177978_c());
         IBlockState iblockstate1 = worldIn.func_180495_p(pos.func_177968_d());
         IBlockState iblockstate2 = worldIn.func_180495_p(pos.func_177976_e());
         IBlockState iblockstate3 = worldIn.func_180495_p(pos.func_177974_f());
         if (state == null) {
            Intrinsics.throwNpe();
         }

         EnumFacing enumfacing;
         label51: {
            enumfacing = (EnumFacing)state.func_177229_b((IProperty)FACING);
            if (enumfacing == EnumFacing.NORTH) {
               Intrinsics.checkExpressionValueIsNotNull(iblockstate, "iblockstate");
               if (iblockstate.func_185913_b()) {
                  Intrinsics.checkExpressionValueIsNotNull(iblockstate1, "iblockstate1");
                  if (!iblockstate1.func_185913_b()) {
                     enumfacing = EnumFacing.SOUTH;
                     break label51;
                  }
               }
            }

            if (enumfacing == EnumFacing.SOUTH) {
               Intrinsics.checkExpressionValueIsNotNull(iblockstate1, "iblockstate1");
               if (iblockstate1.func_185913_b()) {
                  Intrinsics.checkExpressionValueIsNotNull(iblockstate, "iblockstate");
                  if (!iblockstate.func_185913_b()) {
                     enumfacing = EnumFacing.NORTH;
                     break label51;
                  }
               }
            }

            if (enumfacing == EnumFacing.WEST) {
               Intrinsics.checkExpressionValueIsNotNull(iblockstate2, "iblockstate2");
               if (iblockstate2.func_185913_b()) {
                  Intrinsics.checkExpressionValueIsNotNull(iblockstate3, "iblockstate3");
                  if (!iblockstate3.func_185913_b()) {
                     enumfacing = EnumFacing.EAST;
                     break label51;
                  }
               }
            }

            if (enumfacing == EnumFacing.EAST) {
               Intrinsics.checkExpressionValueIsNotNull(iblockstate3, "iblockstate3");
               if (iblockstate3.func_185913_b()) {
                  Intrinsics.checkExpressionValueIsNotNull(iblockstate2, "iblockstate2");
                  if (!iblockstate2.func_185913_b()) {
                     enumfacing = EnumFacing.WEST;
                  }
               }
            }
         }

         worldIn.func_180501_a(pos, state.func_177226_a((IProperty)FACING, (Comparable)enumfacing), 2);
      }

   }

   public void func_180633_a(@Nullable World worldIn, @Nullable BlockPos pos, @Nullable IBlockState state, @Nullable EntityLivingBase placer, @Nullable ItemStack stack) {
      if (worldIn == null) {
         Intrinsics.throwNpe();
      }

      if (pos == null) {
         Intrinsics.throwNpe();
      }

      if (state == null) {
         Intrinsics.throwNpe();
      }

      IProperty var10003 = (IProperty)FACING;
      if (placer == null) {
         Intrinsics.throwNpe();
      }

      worldIn.func_180501_a(pos, state.func_177226_a(var10003, (Comparable)placer.func_174811_aO()), 2);
   }

   @Nullable
   public TileEntityExperimentTable createTileEntity(@NotNull World world, @NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(state, "state");
      return new TileEntityExperimentTable();
   }

   public ExperimentTable() {
      Material var10001 = Material.field_151575_d;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Material.WOOD");
      super(var10001, "experiment_table");
      this.func_149711_c(3.0F);
   }

   static {
      FACING = PropertyDirection.func_177712_a("facing", (Predicate)Plane.HORIZONTAL);
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"},
      d2 = {"Lhu/frontrider/arcana/blocks/experiments/ExperimentTable$Companion;", "", "()V", "FACING", "Lnet/minecraft/block/properties/PropertyDirection;", "kotlin.jvm.PlatformType", "getFACING", "()Lnet/minecraft/block/properties/PropertyDirection;", "bucket", "Lnet/minecraft/item/Item;", "formula", "getFormula", "()Lnet/minecraft/item/Item;", "setFormula", "(Lnet/minecraft/item/Item;)V", "sal_mundi", "water_bucket", "Thaumic Arcana"}
   )
   public static final class Companion {
      public final PropertyDirection getFACING() {
         return ExperimentTable.FACING;
      }

      @Nullable
      public final Item getFormula() {
         return ExperimentTable.formula;
      }

      public final void setFormula(@Nullable Item var1) {
         ExperimentTable.formula = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

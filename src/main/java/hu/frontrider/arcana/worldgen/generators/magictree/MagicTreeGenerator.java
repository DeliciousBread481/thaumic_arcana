package hu.frontrider.arcana.worldgen.generators.magictree;

import java.util.Random;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.blocks.BlocksTC;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lhu/frontrider/arcana/worldgen/generators/magictree/MagicTreeGenerator;", "Lnet/minecraft/world/gen/feature/WorldGenAbstractTree;", "LOG", "Lnet/minecraft/block/state/IBlockState;", "LEAF", "useExtraRandomHeight", "", "(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/block/state/IBlockState;Z)V", "generate", "worldIn", "Lnet/minecraft/world/World;", "rand", "Ljava/util/Random;", "position", "Lnet/minecraft/util/math/BlockPos;", "Thaumic Arcana"}
)
public final class MagicTreeGenerator extends WorldGenAbstractTree {
   private final IBlockState LOG;
   private final IBlockState LEAF;
   private final boolean useExtraRandomHeight;

   public boolean func_180709_b(@NotNull World worldIn, @NotNull Random rand, @NotNull BlockPos position) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(rand, "rand");
      Intrinsics.checkParameterIsNotNull(position, "position");
      int i = rand.nextInt(3) + 5;
      if (this.useExtraRandomHeight) {
         i += rand.nextInt(7);
      }

      boolean flag = true;
      if (position.func_177956_o() >= 1 && position.func_177956_o() + i + 1 <= 256) {
         int j = position.func_177956_o();
         int var7 = position.func_177956_o() + 1 + i;
         if (j <= var7) {
            while(true) {
               int k = 1;
               if (j == position.func_177956_o()) {
                  k = 0;
               }

               if (j >= position.func_177956_o() + 1 + i - 2) {
                  k = 2;
               }

               BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

               for(int l = position.func_177958_n() - k; l <= position.func_177958_n() + k && flag; ++l) {
                  for(int i1 = position.func_177952_p() - k; i1 <= position.func_177952_p() + k && flag; ++i1) {
                     if (j >= 0 && j < worldIn.func_72800_K()) {
                        if (!this.isReplaceable(worldIn, (BlockPos)mutableBlockPos.func_181079_c(l, j, i1))) {
                           flag = false;
                        }
                     } else {
                        flag = false;
                     }
                  }
               }

               if (j == var7) {
                  break;
               }

               ++j;
            }
         }

         if (!flag) {
            return false;
         } else {
            BlockPos down = position.func_177977_b();
            IBlockState state = worldIn.func_180495_p(down);
            Intrinsics.checkExpressionValueIsNotNull(state, "state");
            Block var10000 = state.func_177230_c();
            IBlockAccess var10002 = (IBlockAccess)worldIn;
            EnumFacing var10004 = EnumFacing.UP;
            Block var10005 = Blocks.field_150345_g;
            if (var10005 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.block.BlockSapling");
            } else {
               boolean isSoil = var10000.canSustainPlant(state, var10002, down, var10004, (IPlantable)((BlockSapling)var10005));
               if (isSoil && position.func_177956_o() < worldIn.func_72800_K() - i - 1) {
                  state.func_177230_c().onPlantGrow(state, worldIn, down, position);
                  int i2 = position.func_177956_o() - 3 + i;
                  int var26 = position.func_177956_o() + i;
                  if (i2 <= var26) {
                     while(true) {
                        int k2 = i2 - (position.func_177956_o() + i);
                        int l2 = 1 - k2 / 2;
                        int i3 = position.func_177958_n() - l2;
                        int var14 = position.func_177958_n() + l2;
                        if (i3 <= var14) {
                           while(true) {
                              int j1 = i3 - position.func_177958_n();
                              int k1 = position.func_177952_p() - l2;
                              int var17 = position.func_177952_p() + l2;
                              if (k1 <= var17) {
                                 while(true) {
                                    int l1 = k1 - position.func_177952_p();
                                    if (Math.abs(j1) != l2 || Math.abs(l1) != l2 || rand.nextInt(2) != 0 && k2 != 0) {
                                       BlockPos blockpos = new BlockPos(i3, i2, k1);
                                       IBlockState state2 = worldIn.func_180495_p(blockpos);
                                       Intrinsics.checkExpressionValueIsNotNull(state2, "state2");
                                       if (state2.func_177230_c().isAir(state2, (IBlockAccess)worldIn, blockpos) || state2.func_177230_c().isAir(state2, (IBlockAccess)worldIn, blockpos)) {
                                          this.func_175903_a(worldIn, blockpos, this.LEAF);
                                       }
                                    }

                                    if (k1 == var17) {
                                       break;
                                    }

                                    ++k1;
                                 }
                              }

                              if (i3 == var14) {
                                 break;
                              }

                              ++i3;
                           }
                        }

                        if (i2 == var26) {
                           break;
                        }

                        ++i2;
                     }
                  }

                  i2 = 0;

                  for(int var27 = i; i2 < var27; ++i2) {
                     BlockPos upN = position.func_177981_b(i2);
                     IBlockState state2 = worldIn.func_180495_p(upN);
                     Intrinsics.checkExpressionValueIsNotNull(state2, "state2");
                     if (state2.func_177230_c().isAir(state2, (IBlockAccess)worldIn, upN) || state2.func_177230_c().isLeaves(state2, (IBlockAccess)worldIn, upN)) {
                        if (rand.nextInt(10) > 8) {
                           BlockPos var31 = position.func_177981_b(i2);
                           Block var10003 = BlocksTC.taintLog;
                           Intrinsics.checkExpressionValueIsNotNull(var10003, "BlocksTC.taintLog");
                           this.func_175903_a(worldIn, var31, var10003.func_176223_P());
                        } else {
                           this.func_175903_a(worldIn, position.func_177981_b(i2), this.LOG);
                        }
                     }
                  }

                  return true;
               } else {
                  return false;
               }
            }
         }
      } else {
         return false;
      }
   }

   public MagicTreeGenerator(@NotNull IBlockState LOG, @NotNull IBlockState LEAF, boolean useExtraRandomHeight) {
      Intrinsics.checkParameterIsNotNull(LOG, "LOG");
      Intrinsics.checkParameterIsNotNull(LEAF, "LEAF");
      super(true);
      this.LOG = LOG;
      this.LEAF = LEAF;
      this.useExtraRandomHeight = useExtraRandomHeight;
   }
}

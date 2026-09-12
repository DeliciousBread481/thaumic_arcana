package hu.frontrider.arcana.worldgen.generators.taintwine;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import thaumcraft.api.aura.AuraHelper;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.common.blocks.world.taint.TaintHelper;

public class TaintWineGenerator extends WorldGenAbstractTree {
   @ObjectHolder("thaumic_arcana:taint_wine_trunk")
   static Block taintWineTrunk = null;
   @ObjectHolder("thaumic_arcana:taint_wine_cap")
   static Block taintWineCap = null;

   public TaintWineGenerator() {
      super(false);
   }

   public boolean func_180709_b(World worldIn, Random rand, BlockPos position) {
      for(int height = 0; height < 5; ++height) {
         worldIn.func_175656_a(position.func_177981_b(height), taintWineTrunk.func_176223_P());
      }

      int capsize = 3;
      BlockPos capTemp = position.func_177985_f(capsize).func_177964_d(capsize).func_177981_b(5);

      for(int eastSize = 0; eastSize < capsize * 2 + 1; ++eastSize) {
         for(int southSize = 0; southSize < capsize * 2 + 1; ++southSize) {
            if (worldIn.field_73012_v.nextInt(10) > 2) {
               worldIn.func_175656_a(capTemp, taintWineCap.func_176223_P());
            }

            capTemp = capTemp.func_177968_d();
         }

         capTemp = capTemp.func_177974_f().func_177964_d(capsize * 2 + 1);
      }

      capTemp = position.func_177985_f(capsize).func_177964_d(capsize).func_177981_b(4);

      for(int eastSize = 0; eastSize < capsize * 2 + 1; ++eastSize) {
         for(int southSize = 0; southSize < capsize * 2 + 1; ++southSize) {
            if (worldIn.field_73012_v.nextInt(10) > 5 && worldIn.func_175623_d(position)) {
               worldIn.func_175656_a(capTemp, BlocksTC.taintFibre.func_176223_P());
            }

            capTemp = capTemp.func_177968_d();
         }

         capTemp = capTemp.func_177974_f().func_177964_d(capsize * 2 + 1);
      }

      capTemp = position.func_177985_f(capsize).func_177964_d(capsize).func_177977_b();

      for(int eastSize = 0; eastSize < capsize * 2 + 1; ++eastSize) {
         for(int southSize = 0; southSize < capsize * 2 + 1; ++southSize) {
            if (worldIn.field_73012_v.nextInt(10) > 2) {
               IBlockState blockState = worldIn.func_180495_p(position);
               if (!blockState.func_177230_c().func_176205_b(worldIn, position)) {
                  worldIn.func_175656_a(capTemp, BlocksTC.taintSoil.func_176223_P());
               }
            }

            capTemp = capTemp.func_177968_d();
         }

         capTemp = capTemp.func_177974_f().func_177964_d(capsize * 2 + 1);
      }

      AuraHelper.polluteAura(worldIn, position, 20.0F, true);
      TaintHelper.spreadFibres(worldIn, position);
      return true;
   }
}

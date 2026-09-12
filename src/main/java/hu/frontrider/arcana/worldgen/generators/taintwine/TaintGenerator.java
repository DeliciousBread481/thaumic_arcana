package hu.frontrider.arcana.worldgen.generators.taintwine;

import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import thaumcraft.common.blocks.world.taint.TaintHelper;

public class TaintGenerator extends WorldGenerator {
   public boolean func_180709_b(World worldIn, Random rand, BlockPos position) {
      if (rand.nextInt(10) > 7) {
         TaintHelper.spreadFibres(worldIn, position);
         if (rand.nextInt(10) > 4) {
            TaintHelper.addTaintSeed(worldIn, position);
         }

         return true;
      } else {
         return false;
      }
   }
}

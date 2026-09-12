package hu.frontrider.arcana.worldgen.biome;

import hu.frontrider.arcana.worldgen.generators.taintwine.TaintGenerator;
import hu.frontrider.arcana.worldgen.generators.taintwine.TaintWineGenerator;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TaintedLand extends Biome {
   public TaintedLand() {
      super(getProperties());
   }

   static Biome.BiomeProperties getProperties() {
      Biome.BiomeProperties tainted_land = new Biome.BiomeProperties("tainted_land");
      tainted_land.func_185396_a();
      tainted_land.func_185402_a(8389737);
      return tainted_land;
   }

   public int func_180627_b(BlockPos pos) {
      return 8389737;
   }

   public WorldGenAbstractTree func_150567_a(Random rand) {
      WorldGenAbstractTree superFeature = super.func_150567_a(rand);
      int range = rand.nextInt(1);
      return (WorldGenAbstractTree)(range > 0 && range < 5 ? new TaintWineGenerator() : superFeature);
   }

   public WorldGenerator func_76730_b(Random rand) {
      WorldGenerator superFeature = super.func_76730_b(rand);
      int range = rand.nextInt(1);
      return (WorldGenerator)(range > 0 && range < 5 ? new TaintGenerator() : superFeature);
   }
}

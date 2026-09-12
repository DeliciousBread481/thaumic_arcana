package hu.frontrider.arcana.registrationhandlers;

import hu.frontrider.arcana.worldgen.biome.TaintedLand;
import kotlin.Metadata;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/BiomeRegistry;", "", "()V", "init", "", "Thaumic Arcana"}
)
public final class BiomeRegistry {
   public final void init() {
      TaintedLand taintedLand = new TaintedLand();
      BiomeDictionary.addTypes(taintedLand, new BiomeDictionary.Type[]{Type.WASTELAND, Type.VOID, Type.MAGICAL, Type.RARE});
      BiomeManager.addBiome(BiomeType.DESERT, new BiomeManager.BiomeEntry(taintedLand, 1));
      BiomeManager.addBiome(BiomeType.WARM, new BiomeManager.BiomeEntry(taintedLand, 1));
      BiomeManager.addBiome(BiomeType.COOL, new BiomeManager.BiomeEntry(taintedLand, 1));
      BiomeManager.addBiome(BiomeType.ICY, new BiomeManager.BiomeEntry(taintedLand, 1));
   }
}

package hu.frontrider.arcana.blocks.plants.taintwine.mushroom;

import hu.frontrider.arcana.blocks.BlockTaintBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class TaintWineTrunk extends BlockTaintBase {
   public TaintWineTrunk() {
      super(Material.field_151576_e, "taint_wine_trunk", 3);
   }

   public BlockRenderLayer func_180664_k() {
      return BlockRenderLayer.CUTOUT;
   }

   public boolean func_149686_d(IBlockState state) {
      return false;
   }

   public boolean func_149662_c(IBlockState state) {
      return false;
   }
}

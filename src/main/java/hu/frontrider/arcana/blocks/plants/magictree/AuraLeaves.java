package hu.frontrider.arcana.blocks.plants.magictree;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aura.AuraHelper;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"},
   d2 = {"Lhu/frontrider/arcana/blocks/plants/magictree/AuraLeaves;", "Lnet/minecraft/block/Block;", "()V", "randomTick", "", "worldIn", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/BlockPos;", "state", "Lnet/minecraft/block/state/IBlockState;", "random", "Ljava/util/Random;", "Thaumic Arcana"}
)
public final class AuraLeaves extends Block {
   public void func_180645_a(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state, @NotNull Random random) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(state, "state");
      Intrinsics.checkParameterIsNotNull(random, "random");
      float vis = AuraHelper.getVis(worldIn, pos);
      int auraBase = AuraHelper.getAuraBase(worldIn, pos);
      if (vis < (float)auraBase) {
         AuraHelper.addVis(worldIn, pos, 5.0F);
         Block var10002 = Blocks.field_150350_a;
         Intrinsics.checkExpressionValueIsNotNull(var10002, "Blocks.AIR");
         worldIn.func_175656_a(pos, var10002.func_176223_P());
      }

   }

   public AuraLeaves() {
      super(Material.field_151584_j);
      this.field_149785_s = true;
      this.field_149789_z = true;
   }
}

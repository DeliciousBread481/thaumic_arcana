package hu.frontrider.arcana.items;

import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class ItemFertiliser extends ItemBase {
   public ItemFertiliser() {
      super(new ResourceLocation("thaumic_arcana", "fertiliser"));
   }

   private static boolean fertilise(World worldIn, BlockPos target, EntityPlayer player, ItemStack stack, EnumHand hand) {
      IBlockState iblockstate = worldIn.func_180495_p(target);
      int hook = ForgeEventFactory.onApplyBonemeal(player, worldIn, target, iblockstate, stack, hand);
      if (hook != 0) {
         return hook > 0;
      } else {
         if (iblockstate.func_177230_c() instanceof IGrowable) {
            IGrowable igrowable = (IGrowable)iblockstate.func_177230_c();
            if (igrowable.func_176473_a(worldIn, target, iblockstate, worldIn.field_72995_K)) {
               if (!worldIn.field_72995_K) {
                  if (igrowable.func_180670_a(worldIn, worldIn.field_73012_v, target, iblockstate)) {
                     igrowable.func_176474_b(worldIn, worldIn.field_73012_v, target, iblockstate);
                  }

                  stack.func_190918_g(1);
               }

               return true;
            }
         }

         return false;
      }
   }

   public EnumActionResult func_180614_a(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
      ItemStack stack = player.func_184586_b(hand);
      if (player.func_175151_a(pos.func_177972_a(facing), facing, stack) && fertilise(worldIn, pos, player, stack, hand)) {
         if (!worldIn.field_72995_K) {
            worldIn.func_175718_b(2005, pos, 0);
         }

         return EnumActionResult.SUCCESS;
      } else {
         return EnumActionResult.FAIL;
      }
   }
}

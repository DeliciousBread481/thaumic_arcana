package hu.frontrider.arcana.items;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IncubatedEgg extends ItemBase {
   public IncubatedEgg() {
      super(new ResourceLocation("thaumic_arcana", "incubated_egg"));
      this.func_77625_d(16);
   }

   public EnumActionResult func_180614_a(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
      ItemStack stack = player.func_184586_b(hand);
      BlockPos offset = pos.func_177972_a(facing);
      if (player.func_175151_a(offset, facing, stack)) {
         if (!worldIn.field_72995_K) {
            EntityChicken entityChicken = new EntityChicken(worldIn);
            entityChicken.func_70107_b((double)offset.func_177958_n() + (double)0.5F, (double)offset.func_177956_o(), (double)offset.func_177952_p() + (double)0.5F);
            entityChicken.func_70873_a(-24000);
            entityChicken.func_94061_f(false);
            worldIn.func_72838_d(entityChicken);
            stack.func_190918_g(1);
         }

         return EnumActionResult.SUCCESS;
      } else {
         return EnumActionResult.FAIL;
      }
   }
}

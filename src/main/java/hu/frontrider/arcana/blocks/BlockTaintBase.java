package hu.frontrider.arcana.blocks;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aura.AuraHelper;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J0\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J(\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"},
   d2 = {"Lhu/frontrider/arcana/blocks/BlockTaintBase;", "Lhu/frontrider/arcana/blocks/BlockBase;", "materialIn", "Lnet/minecraft/block/material/Material;", "name", "", "pollutionOnBreak", "", "(Lnet/minecraft/block/material/Material;Ljava/lang/String;I)V", "breakBlock", "", "worldIn", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/BlockPos;", "state", "Lnet/minecraft/block/state/IBlockState;", "dropBlockAsItemWithChance", "chance", "", "fortune", "dropXpOnBlockBreak", "amount", "randomTick", "random", "Ljava/util/Random;", "Thaumic Arcana"}
)
public class BlockTaintBase extends BlockBase {
   private final int pollutionOnBreak;

   public void func_180653_a(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state, float chance, int fortune) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(state, "state");
   }

   public void func_180637_b(@NotNull World worldIn, @NotNull BlockPos pos, int amount) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      int i = worldIn.field_73012_v.nextInt(4);
      int j = 0;

      for(int var6 = i; j < var6; ++j) {
         EntityXPOrb entityXPOrb = new EntityXPOrb(worldIn);
         entityXPOrb.func_70107_b((double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F);
         worldIn.func_72838_d((Entity)entityXPOrb);
      }

   }

   public void func_180663_b(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(state, "state");
      super.func_180663_b(worldIn, pos, state);
      AuraHelper.polluteAura(worldIn, pos, (float)this.pollutionOnBreak, true);
      if (!worldIn.field_72995_K) {
         ItemStack itemStack = ThaumcraftApiHelper.makeCrystal(Aspect.FLUX, worldIn.field_73012_v.nextInt(3));
         EntityItem fluxDrop = new EntityItem(worldIn);
         fluxDrop.func_92058_a(itemStack);
         fluxDrop.field_70165_t = (double)pos.func_177958_n() + (double)0.5F;
         fluxDrop.field_70163_u = (double)pos.func_177956_o();
         fluxDrop.field_70161_v = (double)pos.func_177952_p() + (double)0.5F;
      }
   }

   public void func_180645_a(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state, @NotNull Random random) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(state, "state");
      Intrinsics.checkParameterIsNotNull(random, "random");
      if (worldIn.field_73012_v.nextBoolean()) {
         AuraHelper.drainVis(worldIn, pos, 2.0F, false);
      }

   }

   public BlockTaintBase(@NotNull Material materialIn, @NotNull String name, int pollutionOnBreak) {
      Intrinsics.checkParameterIsNotNull(materialIn, "materialIn");
      Intrinsics.checkParameterIsNotNull(name, "name");
      super(materialIn, name);
      this.pollutionOnBreak = pollutionOnBreak;
   }
}

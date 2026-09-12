package hu.frontrider.arcana.blocks.effect;

import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantProvider;
import hu.frontrider.arcana.capabilities.creatureenchant.ICreatureEnchant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.aura.AuraHelper;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"},
   d2 = {"Lhu/frontrider/arcana/blocks/effect/BlockArcaneStoneEnchants;", "Lhu/frontrider/arcana/blocks/effect/BlockArcaneStoneBase;", "name", "", "status", "", "(Ljava/lang/String;Z)V", "getStatus", "()Z", "activate", "", "worldIn", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/BlockPos;", "entityIn", "Lnet/minecraft/entity/Entity;", "getBoundingBox", "Lnet/minecraft/util/math/AxisAlignedBB;", "state", "Lnet/minecraft/block/state/IBlockState;", "source", "Lnet/minecraft/world/IBlockAccess;", "isFullCube", "isOpaqueCube", "Thaumic Arcana"}
)
public abstract class BlockArcaneStoneEnchants extends BlockArcaneStoneBase {
   private final boolean status;

   public void activate(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull Entity entityIn) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(entityIn, "entityIn");
      if (entityIn.hasCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null)) {
         Object var10000 = entityIn.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var10000, "entityIn.getCapability(C…CHANT_CAPABILITY, null)!!");
         ICreatureEnchant capability = (ICreatureEnchant)var10000;
         if (capability.hasEnchant() == this.status) {
            return;
         }

         if (AuraHelper.drainVis(worldIn, pos, 2.0F, true) < (float)2) {
            return;
         }

         AuraHelper.drainVis(worldIn, pos, 2.0F, false);
         capability.setEnabledStatus(this.status);
      }

   }

   @NotNull
   public AxisAlignedBB func_185496_a(@Nullable IBlockState state, @Nullable IBlockAccess source, @Nullable BlockPos pos) {
      return new AxisAlignedBB((double)0.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)0.9375F, (double)1.0F);
   }

   public boolean func_149662_c(@Nullable IBlockState state) {
      return false;
   }

   public boolean func_149686_d(@Nullable IBlockState state) {
      return false;
   }

   public final boolean getStatus() {
      return this.status;
   }

   public BlockArcaneStoneEnchants(@NotNull String name, boolean status) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      super(name);
      this.status = status;
      this.func_149711_c(2.5F);
      this.func_149672_a(SoundType.field_185851_d);
   }
}

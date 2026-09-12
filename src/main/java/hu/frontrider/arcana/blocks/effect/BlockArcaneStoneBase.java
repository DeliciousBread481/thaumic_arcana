package hu.frontrider.arcana.blocks.effect;

import hu.frontrider.arcana.blocks.BlockBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/blocks/effect/BlockArcaneStoneBase;", "Lhu/frontrider/arcana/blocks/BlockBase;", "name", "", "(Ljava/lang/String;)V", "activate", "", "worldIn", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/BlockPos;", "entityIn", "Lnet/minecraft/entity/Entity;", "onEntityWalk", "Thaumic Arcana"}
)
public abstract class BlockArcaneStoneBase extends BlockBase {
   public void func_176199_a(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull Entity entityIn) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(entityIn, "entityIn");
      this.activate(worldIn, pos, entityIn);
   }

   public abstract void activate(@NotNull World var1, @NotNull BlockPos var2, @NotNull Entity var3);

   public BlockArcaneStoneBase(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Material var10001 = Material.field_151576_e;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Material.ROCK");
      super(var10001, name);
   }
}

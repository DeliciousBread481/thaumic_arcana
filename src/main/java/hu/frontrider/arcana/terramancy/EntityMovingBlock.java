package hu.frontrider.arcana.terramancy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"},
   d2 = {"Lhu/frontrider/arcana/terramancy/EntityMovingBlock;", "Lnet/minecraft/entity/item/EntityFallingBlock;", "world", "Lnet/minecraft/world/World;", "targetPos", "Lnet/minecraft/util/math/BlockPos;", "(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V", "getTargetPos", "()Lnet/minecraft/util/math/BlockPos;", "onEntityUpdate", "", "place", "Thaumic Arcana"}
)
public final class EntityMovingBlock extends EntityFallingBlock {
   @NotNull
   private final BlockPos targetPos;

   public void func_70030_z() {
      super.func_70030_z();
      Intrinsics.areEqual(this.func_180425_c(), this.targetPos);
   }

   public final void place() {
   }

   @NotNull
   public final BlockPos getTargetPos() {
      return this.targetPos;
   }

   public EntityMovingBlock(@NotNull World world, @NotNull BlockPos targetPos) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(targetPos, "targetPos");
      super(world);
      this.targetPos = targetPos;
      this.func_189654_d(true);
   }
}

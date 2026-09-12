package hu.frontrider.arcana.blocks;

import kotlin.Metadata;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"},
   d2 = {"Lhu/frontrider/arcana/blocks/BreakNotifier;", "", "notify", "", "world", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/BlockPos;", "Thaumic Arcana"}
)
public interface BreakNotifier {
   void notify(@NotNull World var1, @NotNull BlockPos var2);
}

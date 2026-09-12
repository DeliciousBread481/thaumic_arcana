package hu.frontrider.arcana.blocks;

import hu.frontrider.arcana.ThaumicArcana;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"},
   d2 = {"Lhu/frontrider/arcana/blocks/BlockBase;", "Lnet/minecraft/block/Block;", "materialIn", "Lnet/minecraft/block/material/Material;", "name", "", "(Lnet/minecraft/block/material/Material;Ljava/lang/String;)V", "Thaumic Arcana"}
)
public class BlockBase extends Block {
   public BlockBase(@NotNull Material materialIn, @NotNull String name) {
      Intrinsics.checkParameterIsNotNull(materialIn, "materialIn");
      Intrinsics.checkParameterIsNotNull(name, "name");
      super(materialIn);
      this.setRegistryName("thaumic_arcana", name);
      this.func_149663_c("thaumic_arcana." + name);
      this.func_149647_a(ThaumicArcana.INSTANCE.getTABARCANA());
   }
}

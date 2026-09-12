package hu.frontrider.arcana.blocks.plants.magictree;

import kotlin.Metadata;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
   d2 = {"Lhu/frontrider/arcana/blocks/plants/magictree/AuraLog;", "Lnet/minecraft/block/BlockRotatedPillar;", "()V", "Thaumic Arcana"}
)
public final class AuraLog extends BlockRotatedPillar {
   public AuraLog() {
      super(Material.field_151575_d);
   }
}

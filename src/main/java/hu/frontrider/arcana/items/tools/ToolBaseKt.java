package hu.frontrider.arcana.items.tools;

import com.google.common.collect.Sets;
import java.util.HashSet;
import kotlin.Metadata;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import thaumcraft.api.blocks.BlocksTC;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"2\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"},
   d2 = {"AXE_EFFECTIVE_ON", "Ljava/util/HashSet;", "Lnet/minecraft/block/Block;", "kotlin.jvm.PlatformType", "Thaumic Arcana"}
)
public final class ToolBaseKt {
   private static final HashSet<Block> AXE_EFFECTIVE_ON;

   static {
      AXE_EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.field_150344_f, Blocks.field_150342_X, Blocks.field_150364_r, Blocks.field_150363_s, (Block)Blocks.field_150486_ae, Blocks.field_150423_aK, Blocks.field_150428_aP, Blocks.field_150440_ba, Blocks.field_150468_ap, Blocks.field_150471_bO, Blocks.field_150452_aw, BlocksTC.logGreatwood, BlocksTC.logSilverwood, BlocksTC.plankGreatwood, BlocksTC.plankSilverwood});
   }

   // $FF: synthetic method
   public static final HashSet access$getAXE_EFFECTIVE_ON$p() {
      return AXE_EFFECTIVE_ON;
   }
}

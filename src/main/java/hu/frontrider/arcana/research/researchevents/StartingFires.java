package hu.frontrider.arcana.research.researchevents;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.BlockFire;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.capabilities.IPlayerKnowledge;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;
import thaumcraft.api.research.ResearchEvent;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\f¨\u0006\r"},
   d2 = {"Lhu/frontrider/arcana/research/researchevents/StartingFires;", "", "()V", "fires", "", "event", "Lthaumcraft/api/research/ResearchEvent$Research;", "spawnFires", "world", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/BlockPos;", "spawnFires$Thaumic_Arcana", "Thaumic Arcana"}
)
public final class StartingFires {
   @SubscribeEvent
   public final void fires(@NotNull ResearchEvent.Research event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityPlayer player = event.getPlayer();
      String researchKey = event.getResearchKey();
      if (Intrinsics.areEqual(researchKey, "ESSENTIASMELTER")) {
         IPlayerKnowledge capability = (IPlayerKnowledge)player.getCapability(ThaumcraftCapabilities.KNOWLEDGE, (EnumFacing)null);
         if (capability == null) {
            Intrinsics.throwNpe();
         }

         int researchStage = capability.getResearchStage(researchKey);
         if (researchStage == 2) {
            Intrinsics.checkExpressionValueIsNotNull(player, "player");
            World var10001 = player.func_130014_f_();
            Intrinsics.checkExpressionValueIsNotNull(var10001, "player.entityWorld");
            BlockPos var10002 = player.func_180425_c();
            Intrinsics.checkExpressionValueIsNotNull(var10002, "player.position");
            this.spawnFires$Thaumic_Arcana(var10001, var10002);
         }
      }

   }

   public final void spawnFires$Thaumic_Arcana(@NotNull World world, @NotNull BlockPos pos) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      BlockPos shiftedPos = pos.func_177974_f().func_177978_c();
      int west = 0;

      for(byte var5 = 2; west <= var5; ++west) {
         int south = 0;

         for(byte var7 = 2; south <= var7; ++south) {
            if (world.func_175623_d(shiftedPos) && world.field_73012_v.nextInt(10) > 6) {
               BlockFire var10002 = Blocks.field_150480_ab;
               Intrinsics.checkExpressionValueIsNotNull(var10002, "Blocks.FIRE");
               world.func_175656_a(shiftedPos, var10002.func_176223_P());
            }

            if (world.func_175623_d(shiftedPos.func_177984_a()) && world.field_73012_v.nextInt(10) > 6) {
               BlockPos var10001 = shiftedPos.func_177984_a();
               BlockFire var8 = Blocks.field_150480_ab;
               Intrinsics.checkExpressionValueIsNotNull(var8, "Blocks.FIRE");
               world.func_175656_a(var10001, var8.func_176223_P());
            }

            shiftedPos = shiftedPos.func_177976_e().func_177968_d();
         }
      }

   }
}

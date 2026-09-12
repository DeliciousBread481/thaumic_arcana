package hu.frontrider.arcana.research.researchevents;

import hu.frontrider.arcana.worldgen.generators.taintwine.TaintWineGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
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
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"},
   d2 = {"Lhu/frontrider/arcana/research/researchevents/PlantExperiments;", "", "()V", "genrator", "Lhu/frontrider/arcana/worldgen/generators/taintwine/TaintWineGenerator;", "getGenrator", "()Lhu/frontrider/arcana/worldgen/generators/taintwine/TaintWineGenerator;", "fires", "", "event", "Lthaumcraft/api/research/ResearchEvent$Research;", "spawnTaint", "world", "Lnet/minecraft/world/World;", "player", "Lnet/minecraft/util/math/BlockPos;", "Thaumic Arcana"}
)
public final class PlantExperiments {
   @NotNull
   private final TaintWineGenerator genrator = new TaintWineGenerator();

   @NotNull
   public final TaintWineGenerator getGenrator() {
      return this.genrator;
   }

   @SubscribeEvent
   public final void fires(@NotNull ResearchEvent.Research event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityPlayer player = event.getPlayer();
      String researchKey = event.getResearchKey();
      if (Intrinsics.areEqual(researchKey, "PLANT_EXPERIMENTS")) {
         IPlayerKnowledge capability = (IPlayerKnowledge)player.getCapability(ThaumcraftCapabilities.KNOWLEDGE, (EnumFacing)null);
         if (capability == null) {
            Intrinsics.throwNpe();
         }

         int researchStage = capability.getResearchStage(researchKey);
         if (researchStage == 1) {
            Intrinsics.checkExpressionValueIsNotNull(player, "player");
            World var10001 = player.func_130014_f_();
            Intrinsics.checkExpressionValueIsNotNull(var10001, "player.entityWorld");
            BlockPos var10002 = player.func_180425_c();
            Intrinsics.checkExpressionValueIsNotNull(var10002, "player.position");
            this.spawnTaint(var10001, var10002);
         }
      }

   }

   public final void spawnTaint(@NotNull World world, @NotNull BlockPos player) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(player, "player");
      this.genrator.func_180709_b(world, world.field_73012_v, player);
   }
}

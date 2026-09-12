package hu.frontrider.arcana.creatureenchant.effect;

import hu.frontrider.arcana.ThaumicArcana;
import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.sided.network.falldamage.FalldamageSyncMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u001d\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/effect/SpiderFingers;", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "()V", "research", "", "getResearch", "()Ljava/lang/String;", "formula", "Lthaumcraft/api/aspects/AspectList;", "isBlockThere", "", "world", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/BlockPos;", "isBlockThere$Thaumic_Arcana", "isEntityNextToAWall", "entityLivingBase", "Lnet/minecraft/entity/EntityLivingBase;", "isEntityNextToAWall$Thaumic_Arcana", "makeEntityClimb", "", "makeEntityClimb$Thaumic_Arcana", "tick", "event", "Lnet/minecraftforge/event/entity/living/LivingEvent$LivingUpdateEvent;", "Thaumic Arcana"}
)
public final class SpiderFingers extends CreatureEnchant {
   @NotNull
   public String getResearch() {
      return "CREATURE_ENCHANT";
   }

   @SubscribeEvent
   public final void tick(@NotNull LivingEvent.LivingUpdateEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityLivingBase entityLiving = event.getEntityLiving();
      Intrinsics.checkExpressionValueIsNotNull(entityLiving, "entityLiving");
      if (this.getEnchantLevel(entityLiving, this) > 0) {
         World var10001 = entityLiving.field_70170_p;
         Intrinsics.checkExpressionValueIsNotNull(var10001, "entityLiving.world");
         if (this.isEntityNextToAWall$Thaumic_Arcana(var10001, entityLiving)) {
            var10001 = entityLiving.field_70170_p;
            Intrinsics.checkExpressionValueIsNotNull(var10001, "entityLiving.world");
            this.makeEntityClimb$Thaumic_Arcana(var10001, entityLiving);
         }

      }
   }

   public final void makeEntityClimb$Thaumic_Arcana(@NotNull World world, @NotNull EntityLivingBase entityLivingBase) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(entityLivingBase, "entityLivingBase");
      if (entityLivingBase.field_191988_bg > (float)0) {
         entityLivingBase.field_70181_x = (double)(entityLivingBase.field_191988_bg / (float)2);
         entityLivingBase.field_191988_bg = 0.0F;
      }

      if (entityLivingBase.func_70093_af()) {
         entityLivingBase.field_70181_x = (double)0.0F;
         if (world.field_72995_K) {
            ThaumicArcana.INSTANCE.getNETWORK_WRAPPER().sendToServer(new FalldamageSyncMessage());
         }
      }

   }

   public final boolean isEntityNextToAWall$Thaumic_Arcana(@NotNull World world, @NotNull EntityLivingBase entityLivingBase) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(entityLivingBase, "entityLivingBase");
      BlockPos position = entityLivingBase.func_180425_c();
      EnumFacing facing = entityLivingBase.func_174811_aO();
      BlockPos var10002 = position.func_177972_a(facing);
      Intrinsics.checkExpressionValueIsNotNull(var10002, "position.offset(facing)");
      return this.isBlockThere$Thaumic_Arcana(world, var10002);
   }

   public final boolean isBlockThere$Thaumic_Arcana(@NotNull World world, @NotNull BlockPos pos) {
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      IBlockState blockState = world.func_180495_p(pos);
      Intrinsics.checkExpressionValueIsNotNull(blockState, "blockState");
      return !blockState.func_177230_c().func_176205_b((IBlockAccess)world, pos);
   }

   @NotNull
   public AspectList formula() {
      AspectList var10000 = (new AspectList()).merge(Aspect.BEAST, 50).merge(Aspect.LIFE, 20).merge(Aspect.SENSES, 40).merge(Aspect.TRAP, 60);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "AspectList()\n           …  .merge(Aspect.TRAP, 60)");
      return var10000;
   }

   public SpiderFingers() {
      super(new ResourceLocation("thaumic_arcana", "spider"), "spider");
   }
}

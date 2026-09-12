package hu.frontrider.arcana.casters.backend;

import hu.frontrider.arcana.ThaumicArcana;
import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantProvider;
import hu.frontrider.arcana.capabilities.creatureenchant.ICreatureEnchant;
import hu.frontrider.arcana.sided.network.creatureenchants.CreatureEnchantSyncMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.casters.FocusEffect;
import thaumcraft.api.casters.Trajectory;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ*\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J@\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"},
   d2 = {"Lhu/frontrider/arcana/casters/backend/SetEnchantStatus;", "Lthaumcraft/api/casters/FocusEffect;", "researchName", "", "name", "status", "", "requiredAspect", "Lthaumcraft/api/aspects/Aspect;", "(Ljava/lang/String;Ljava/lang/String;ZLthaumcraft/api/aspects/Aspect;)V", "execute", "rayTraceResult", "Lnet/minecraft/util/math/RayTraceResult;", "trajectory", "Lthaumcraft/api/casters/Trajectory;", "v", "", "i", "", "getAspect", "getComplexity", "getKey", "getResearch", "renderParticleFX", "", "world", "Lnet/minecraft/world/World;", "", "v1", "v2", "v3", "v4", "v5", "Thaumic Arcana"}
)
public class SetEnchantStatus extends FocusEffect {
   private final String researchName;
   private final String name;
   private final boolean status;
   private final Aspect requiredAspect;

   public boolean execute(@NotNull RayTraceResult rayTraceResult, @Nullable Trajectory trajectory, float v, int i) {
      Intrinsics.checkParameterIsNotNull(rayTraceResult, "rayTraceResult");
      Entity entityHit = rayTraceResult.field_72308_g;
      if (entityHit.hasCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null)) {
         Object var10000 = entityHit.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var10000, "entityHit.getCapability(…CHANT_CAPABILITY, null)!!");
         ICreatureEnchant capability = (ICreatureEnchant)var10000;
         capability.setEnabledStatus(this.status);
         Intrinsics.checkExpressionValueIsNotNull(entityHit, "entityHit");
         int entityId = entityHit.func_145782_y();
         ThaumicArcana.INSTANCE.getNETWORK_WRAPPER().sendToAllAround(new CreatureEnchantSyncMessage(capability, entityId), new NetworkRegistry.TargetPoint(entityHit.field_71093_bK, entityHit.field_70165_t, entityHit.field_70163_u, entityHit.field_70161_v, (double)128.0F));
         return true;
      } else {
         return false;
      }
   }

   public void renderParticleFX(@NotNull World world, double v, double v1, double v2, double v3, double v4, double v5) {
      Intrinsics.checkParameterIsNotNull(world, "world");
   }

   public int getComplexity() {
      return 4;
   }

   @Nullable
   public Aspect getAspect() {
      return this.requiredAspect;
   }

   @Nullable
   public String getKey() {
      return "thaumic_arcana." + this.name;
   }

   @Nullable
   public String getResearch() {
      return this.researchName;
   }

   public SetEnchantStatus(@NotNull String researchName, @NotNull String name, boolean status, @NotNull Aspect requiredAspect) {
      Intrinsics.checkParameterIsNotNull(researchName, "researchName");
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(requiredAspect, "requiredAspect");
      super();
      this.researchName = researchName;
      this.name = name;
      this.status = status;
      this.requiredAspect = requiredAspect;
   }
}

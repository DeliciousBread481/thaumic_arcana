package hu.frontrider.arcana.entity.inhibitor.ai;

import hu.frontrider.arcana.api.InhibitorAiWrapper;
import kotlin.Metadata;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\nH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"},
   d2 = {"Lhu/frontrider/arcana/entity/inhibitor/ai/EntityAIWanderWrapper;", "Lhu/frontrider/arcana/api/InhibitorAiWrapper;", "speed", "", "chance", "", "(DI)V", "getChance", "()I", "id", "Lnet/minecraft/util/ResourceLocation;", "getId", "()Lnet/minecraft/util/ResourceLocation;", "getSpeed", "()D", "get", "Lnet/minecraft/entity/ai/EntityAIBase;", "entityCreature", "Lnet/minecraft/entity/EntityCreature;", "getID", "Thaumic Arcana"}
)
public final class EntityAIWanderWrapper implements InhibitorAiWrapper {
   @NotNull
   private final ResourceLocation id;
   private final double speed;
   private final int chance;

   @NotNull
   public EntityAIBase get(@Nullable EntityCreature entityCreature) {
      return (EntityAIBase)(new EntityAIWander(entityCreature, this.speed, this.chance));
   }

   @NotNull
   public final ResourceLocation getId() {
      return this.id;
   }

   @NotNull
   public ResourceLocation getID() {
      return this.id;
   }

   public final double getSpeed() {
      return this.speed;
   }

   public final int getChance() {
      return this.chance;
   }

   public EntityAIWanderWrapper(double speed, int chance) {
      this.speed = speed;
      this.chance = chance;
      this.id = new ResourceLocation("thaumic_arcana", "run_around");
   }
}

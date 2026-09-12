package hu.frontrider.arcana.entity.inhibitor.ai;

import hu.frontrider.arcana.api.InhibitorAiWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/entity/inhibitor/ai/EntityAIAttackMeleeWrapper;", "Lhu/frontrider/arcana/api/InhibitorAiWrapper;", "speed", "", "(D)V", "id", "Lnet/minecraft/util/ResourceLocation;", "getSpeed", "()D", "get", "Lnet/minecraft/entity/ai/EntityAIBase;", "entityCreature", "Lnet/minecraft/entity/EntityCreature;", "getID", "Thaumic Arcana"}
)
public final class EntityAIAttackMeleeWrapper implements InhibitorAiWrapper {
   private final ResourceLocation id;
   private final double speed;

   @NotNull
   public EntityAIBase get(@NotNull EntityCreature entityCreature) {
      Intrinsics.checkParameterIsNotNull(entityCreature, "entityCreature");
      return (EntityAIBase)(new EntityAIAttackMelee(entityCreature, this.speed, true));
   }

   @NotNull
   public ResourceLocation getID() {
      return this.id;
   }

   public final double getSpeed() {
      return this.speed;
   }

   public EntityAIAttackMeleeWrapper(double speed) {
      this.speed = speed;
      this.id = new ResourceLocation("thaumic_arcana", "attack_attacker");
   }
}

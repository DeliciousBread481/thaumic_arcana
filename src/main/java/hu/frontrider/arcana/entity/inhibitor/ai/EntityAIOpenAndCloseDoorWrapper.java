package hu.frontrider.arcana.entity.inhibitor.ai;

import hu.frontrider.arcana.api.InhibitorAiWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"},
   d2 = {"Lhu/frontrider/arcana/entity/inhibitor/ai/EntityAIOpenAndCloseDoorWrapper;", "Lhu/frontrider/arcana/api/InhibitorAiWrapper;", "()V", "id", "Lnet/minecraft/util/ResourceLocation;", "getId", "()Lnet/minecraft/util/ResourceLocation;", "get", "Lnet/minecraft/entity/ai/EntityAIBase;", "entityCreature", "Lnet/minecraft/entity/EntityCreature;", "getID", "Thaumic Arcana"}
)
public final class EntityAIOpenAndCloseDoorWrapper implements InhibitorAiWrapper {
   @NotNull
   private final ResourceLocation id = new ResourceLocation("thaumic_arcana", "open_close_door");

   @NotNull
   public final ResourceLocation getId() {
      return this.id;
   }

   @NotNull
   public ResourceLocation getID() {
      return this.id;
   }

   @NotNull
   public EntityAIBase get(@NotNull EntityCreature entityCreature) {
      Intrinsics.checkParameterIsNotNull(entityCreature, "entityCreature");
      return (EntityAIBase)(new EntityAIOpenDoor((EntityLiving)entityCreature, true));
   }
}

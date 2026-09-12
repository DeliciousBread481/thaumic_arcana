package hu.frontrider.arcana.entity.inhibitor;

import kotlin.Metadata;
import net.minecraft.entity.ai.EntityAIBase;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"},
   d2 = {"Lhu/frontrider/arcana/entity/inhibitor/InhibitedAI;", "Lnet/minecraft/entity/ai/EntityAIBase;", "Lhu/frontrider/arcana/entity/inhibitor/IInhibitedAI;", "()V", "Thaumic Arcana"}
)
public abstract class InhibitedAI extends EntityAIBase implements IInhibitedAI {
}

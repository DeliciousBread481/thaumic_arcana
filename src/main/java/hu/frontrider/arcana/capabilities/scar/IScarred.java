package hu.frontrider.arcana.capabilities.scar;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0019X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"},
   d2 = {"Lhu/frontrider/arcana/capabilities/scar/IScarred;", "", "currentDamage", "", "getCurrentDamage", "()F", "setCurrentDamage", "(F)V", "limbs", "Lhu/frontrider/arcana/capabilities/scar/Limbs;", "getLimbs", "()Lhu/frontrider/arcana/capabilities/scar/Limbs;", "setLimbs", "(Lhu/frontrider/arcana/capabilities/scar/Limbs;)V", "requiredDamage", "", "getRequiredDamage", "()I", "setRequiredDamage", "(I)V", "scarred", "", "getScarred", "()Z", "severity", "", "getSeverity", "()B", "setSeverity", "(B)V", "Thaumic Arcana"}
)
public interface IScarred {
   boolean getScarred();

   int getRequiredDamage();

   void setRequiredDamage(int var1);

   float getCurrentDamage();

   void setCurrentDamage(float var1);

   byte getSeverity();

   void setSeverity(byte var1);

   @NotNull
   Limbs getLimbs();

   void setLimbs(@NotNull Limbs var1);
}

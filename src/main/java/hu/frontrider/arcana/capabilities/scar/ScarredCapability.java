package hu.frontrider.arcana.capabilities.scar;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020$H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006%"},
   d2 = {"Lhu/frontrider/arcana/capabilities/scar/ScarredCapability;", "Lhu/frontrider/arcana/capabilities/scar/IScarred;", "()V", "currentDamage", "", "getCurrentDamage", "()F", "setCurrentDamage", "(F)V", "limbs", "Lhu/frontrider/arcana/capabilities/scar/Limbs;", "getLimbs", "()Lhu/frontrider/arcana/capabilities/scar/Limbs;", "setLimbs", "(Lhu/frontrider/arcana/capabilities/scar/Limbs;)V", "requiredDamage", "", "getRequiredDamage", "()I", "setRequiredDamage", "(I)V", "scarred", "", "getScarred", "()Z", "severity", "", "getSeverity", "()B", "setSeverity", "(B)V", "equals", "other", "", "hashCode", "toString", "", "Thaumic Arcana"}
)
public final class ScarredCapability implements IScarred {
   @NotNull
   private Limbs limbs = new Limbs();
   private int requiredDamage = 300;
   private float currentDamage;
   private byte severity = 1;

   @NotNull
   public Limbs getLimbs() {
      return this.limbs;
   }

   public void setLimbs(@NotNull Limbs var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.limbs = var1;
   }

   public boolean getScarred() {
      return (float)this.getRequiredDamage() < this.getCurrentDamage();
   }

   public int getRequiredDamage() {
      return this.requiredDamage;
   }

   public void setRequiredDamage(int var1) {
      this.requiredDamage = var1;
   }

   public float getCurrentDamage() {
      return this.currentDamage;
   }

   public void setCurrentDamage(float var1) {
      this.currentDamage = var1;
   }

   public byte getSeverity() {
      return this.severity;
   }

   public void setSeverity(byte var1) {
      this.severity = var1;
   }

   public boolean equals(@Nullable Object other) {
      if ((ScarredCapability)this == other) {
         return true;
      } else if (Intrinsics.areEqual(this.getClass(), other != null ? other.getClass() : null) ^ true) {
         return false;
      } else if (other == null) {
         throw new TypeCastException("null cannot be cast to non-null type hu.frontrider.arcana.capabilities.scar.ScarredCapability");
      } else {
         ScarredCapability var10000 = (ScarredCapability)other;
         if (Intrinsics.areEqual(this.getLimbs(), ((ScarredCapability)other).getLimbs()) ^ true) {
            return false;
         } else if (this.getRequiredDamage() != ((ScarredCapability)other).getRequiredDamage()) {
            return false;
         } else if (this.getCurrentDamage() != ((ScarredCapability)other).getCurrentDamage()) {
            return false;
         } else {
            return this.getSeverity() == ((ScarredCapability)other).getSeverity();
         }
      }
   }

   public int hashCode() {
      int result = this.getLimbs().hashCode();
      result = 31 * result + this.getRequiredDamage();
      result = 31 * result + Float.hashCode(this.getCurrentDamage());
      result = 31 * result + this.getSeverity();
      return result;
   }

   @NotNull
   public String toString() {
      return "ScarredCapability(limbs=" + this.getLimbs() + ", requiredDamage=" + this.getRequiredDamage() + ", currentDamage=" + this.getCurrentDamage() + ", severity=" + this.getSeverity() + ')';
   }
}

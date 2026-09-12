package hu.frontrider.arcana.capabilities.scar;

import java.util.Random;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0018J\b\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006#"},
   d2 = {"Lhu/frontrider/arcana/capabilities/scar/Limbs;", "", "()V", "armDamage", "", "getArmDamage", "()B", "setArmDamage", "(B)V", "bodyDamage", "getBodyDamage", "setBodyDamage", "headDamage", "getHeadDamage", "setHeadDamage", "legDamage", "getLegDamage", "setLegDamage", "equals", "", "other", "fromNbt", "", "compound", "Lnet/minecraft/nbt/NBTTagCompound;", "hashCode", "", "hurt", "amount", "", "random", "Ljava/util/Random;", "toNbt", "toString", "", "Thaumic Arcana"}
)
public final class Limbs {
   private byte legDamage;
   private byte bodyDamage;
   private byte armDamage;
   private byte headDamage;

   public final byte getLegDamage() {
      return this.legDamage;
   }

   public final void setLegDamage(byte var1) {
      this.legDamage = var1;
   }

   public final byte getBodyDamage() {
      return this.bodyDamage;
   }

   public final void setBodyDamage(byte var1) {
      this.bodyDamage = var1;
   }

   public final byte getArmDamage() {
      return this.armDamage;
   }

   public final void setArmDamage(byte var1) {
      this.armDamage = var1;
   }

   public final byte getHeadDamage() {
      return this.headDamage;
   }

   public final void setHeadDamage(byte var1) {
      this.headDamage = var1;
   }

   @NotNull
   public final NBTTagCompound toNbt() {
      NBTTagCompound nbtTagCompound = new NBTTagCompound();
      nbtTagCompound.func_74774_a("leg", this.legDamage);
      nbtTagCompound.func_74774_a("arm", this.armDamage);
      nbtTagCompound.func_74774_a("body", this.bodyDamage);
      nbtTagCompound.func_74774_a("arm", this.armDamage);
      return nbtTagCompound;
   }

   public final void fromNbt(@NotNull NBTTagCompound compound) {
      Intrinsics.checkParameterIsNotNull(compound, "compound");
      this.legDamage = compound.func_74771_c("leg");
      this.armDamage = compound.func_74771_c("arm");
      this.bodyDamage = compound.func_74771_c("body");
      this.armDamage = compound.func_74771_c("arm");
   }

   @NotNull
   public String toString() {
      return "Limbs(legDamage=" + this.legDamage + ", bodyDamage=" + this.bodyDamage + ", armDamage=" + this.armDamage + ", headDamage=" + this.headDamage + ')';
   }

   public boolean equals(@Nullable Object other) {
      if ((Limbs)this == other) {
         return true;
      } else if (Intrinsics.areEqual(this.getClass(), other != null ? other.getClass() : null) ^ true) {
         return false;
      } else if (other == null) {
         throw new TypeCastException("null cannot be cast to non-null type hu.frontrider.arcana.capabilities.scar.Limbs");
      } else {
         Limbs var10000 = (Limbs)other;
         if (this.legDamage != ((Limbs)other).legDamage) {
            return false;
         } else if (this.bodyDamage != ((Limbs)other).bodyDamage) {
            return false;
         } else if (this.armDamage != ((Limbs)other).armDamage) {
            return false;
         } else {
            return this.headDamage == ((Limbs)other).headDamage;
         }
      }
   }

   public int hashCode() {
      int result = this.legDamage;
      result = 31 * result + this.bodyDamage;
      result = 31 * result + this.armDamage;
      result = 31 * result + this.headDamage;
      return result;
   }

   public final void hurt(float amount, @NotNull Random random) {
      Intrinsics.checkParameterIsNotNull(random, "random");
   }
}

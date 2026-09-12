package hu.frontrider.arcana.capabilities;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.EnumFacing;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.IEssentiaTransport;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\"\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010 \u001a\u00020\tH\u0016J\u0012\u0010!\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u001a\u0010$\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010&\u001a\u00020\tH\u0016J$\u0010'\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010&\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006("},
   d2 = {"Lhu/frontrider/arcana/capabilities/EssentiaRecieverTrait;", "Lthaumcraft/api/aspects/IEssentiaTransport;", "aspect", "Lthaumcraft/api/aspects/Aspect;", "facings", "", "Lnet/minecraft/util/EnumFacing;", "(Lthaumcraft/api/aspects/Aspect;[Lnet/minecraft/util/EnumFacing;)V", "amount", "", "getAmount", "()I", "setAmount", "(I)V", "getAspect", "()Lthaumcraft/api/aspects/Aspect;", "cost", "getCost", "setCost", "getFacings", "()[Lnet/minecraft/util/EnumFacing;", "[Lnet/minecraft/util/EnumFacing;", "addEssentia", "added", "p2", "canInputFrom", "", "facing", "canOutputTo", "p0", "getEssentiaAmount", "getEssentiaType", "getMinimumSuction", "getSuctionAmount", "getSuctionType", "isConnectable", "setSuction", "", "p1", "takeEssentia", "Thaumic Arcana"}
)
public final class EssentiaRecieverTrait implements IEssentiaTransport {
   private int amount;
   private int cost;
   @NotNull
   private final Aspect aspect;
   @NotNull
   private final EnumFacing[] facings;

   public final int getAmount() {
      return this.amount;
   }

   public final void setAmount(int var1) {
      this.amount = var1;
   }

   public final int getCost() {
      return this.cost;
   }

   public final void setCost(int var1) {
      this.cost = var1;
   }

   public int getMinimumSuction() {
      return 0;
   }

   @Nullable
   public Aspect getEssentiaType(@Nullable EnumFacing facing) {
      return null;
   }

   public int getEssentiaAmount(@Nullable EnumFacing p0) {
      return 0;
   }

   public boolean canInputFrom(@Nullable EnumFacing facing) {
      return ArraysKt.contains(this.facings, facing);
   }

   @Nullable
   public Aspect getSuctionType(@Nullable EnumFacing p0) {
      return ArraysKt.contains(this.facings, p0) ? this.aspect : null;
   }

   public int getSuctionAmount(@Nullable EnumFacing p0) {
      return this.cost - this.amount > 0 ? 128 : 0;
   }

   public boolean isConnectable(@NotNull EnumFacing facing) {
      Intrinsics.checkParameterIsNotNull(facing, "facing");
      return ArraysKt.contains(this.facings, facing);
   }

   public int addEssentia(@NotNull Aspect aspect, int added, @Nullable EnumFacing p2) {
      Intrinsics.checkParameterIsNotNull(aspect, "aspect");
      if (this.amount < this.cost && aspect == this.aspect) {
         int missing = this.cost - this.amount;
         int currentlyAdded = missing - added;
         int var10000;
         if (currentlyAdded < 0) {
            this.amount = this.cost;
            var10000 = Math.abs(currentlyAdded);
         } else {
            this.amount += currentlyAdded;
            var10000 = 0;
         }

         return var10000;
      } else {
         return 0;
      }
   }

   public int takeEssentia(@Nullable Aspect p0, int p1, @Nullable EnumFacing p2) {
      return 0;
   }

   public void setSuction(@Nullable Aspect p0, int p1) {
   }

   public boolean canOutputTo(@Nullable EnumFacing p0) {
      return false;
   }

   @NotNull
   public final Aspect getAspect() {
      return this.aspect;
   }

   @NotNull
   public final EnumFacing[] getFacings() {
      return this.facings;
   }

   public EssentiaRecieverTrait(@NotNull Aspect aspect, @NotNull EnumFacing[] facings) {
      Intrinsics.checkParameterIsNotNull(aspect, "aspect");
      Intrinsics.checkParameterIsNotNull(facings, "facings");
      super();
      this.aspect = aspect;
      this.facings = facings;
   }
}

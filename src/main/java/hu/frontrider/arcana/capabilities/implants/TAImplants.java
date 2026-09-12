package hu.frontrider.arcana.capabilities.implants;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"},
   d2 = {"Lhu/frontrider/arcana/capabilities/implants/TAImplants;", "Lhu/frontrider/arcana/capabilities/implants/ITAImplants;", "()V", "storage", "Ljava/util/HashMap;", "Lhu/frontrider/arcana/capabilities/implants/Slot;", "Lhu/frontrider/arcana/capabilities/implants/IImplant;", "getImplant", "Ljava/util/Optional;", "slot", "getImplants", "", "hasImplant", "", "setImplant", "", "implant", "Thaumic Arcana"}
)
public final class TAImplants implements ITAImplants {
   private final HashMap<Slot, IImplant> storage = new HashMap();

   @NotNull
   public Map<Slot, IImplant> getImplants() {
      return (Map)this.storage;
   }

   public boolean hasImplant(@NotNull Slot slot) {
      Intrinsics.checkParameterIsNotNull(slot, "slot");
      return this.storage.containsKey(slot);
   }

   @NotNull
   public Optional<IImplant> getImplant(@NotNull Slot slot) {
      Intrinsics.checkParameterIsNotNull(slot, "slot");
      if (this.storage.containsKey(slot)) {
         Object var2 = this.storage.get(slot);
         if (var2 == null) {
            Intrinsics.throwNpe();
         }

         Optional var3 = Optional.of(var2);
         Intrinsics.checkExpressionValueIsNotNull(var3, "Optional.of(storage[slot]!!)");
         return var3;
      } else {
         Optional var10000 = Optional.empty();
         Intrinsics.checkExpressionValueIsNotNull(var10000, "Optional.empty()");
         return var10000;
      }
   }

   public void setImplant(@NotNull Slot slot, @NotNull IImplant implant) {
      Intrinsics.checkParameterIsNotNull(slot, "slot");
      Intrinsics.checkParameterIsNotNull(implant, "implant");
      Map var3 = (Map)this.storage;
      var3.put(slot, implant);
   }
}

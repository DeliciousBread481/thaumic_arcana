package hu.frontrider.arcana.capabilities.implants;

import java.util.Map;
import java.util.Optional;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H&¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/capabilities/implants/ITAImplants;", "", "getImplant", "Ljava/util/Optional;", "Lhu/frontrider/arcana/capabilities/implants/IImplant;", "slot", "Lhu/frontrider/arcana/capabilities/implants/Slot;", "getImplants", "", "hasImplant", "", "setImplant", "", "implant", "Thaumic Arcana"}
)
public interface ITAImplants {
   @NotNull
   Map<Slot, IImplant> getImplants();

   boolean hasImplant(@NotNull Slot var1);

   @NotNull
   Optional<IImplant> getImplant(@NotNull Slot var1);

   void setImplant(@NotNull Slot var1, @NotNull IImplant var2);
}

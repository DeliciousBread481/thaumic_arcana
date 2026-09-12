package hu.frontrider.arcana.capabilities.inhibitor;

import hu.frontrider.arcana.api.InhibitorAiWrapper;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"},
   d2 = {"Lhu/frontrider/arcana/capabilities/inhibitor/IInhibitor;", "", "aiList", "", "Lhu/frontrider/arcana/api/InhibitorAiWrapper;", "getAiList", "()Ljava/util/List;", "setAiList", "(Ljava/util/List;)V", "inhibited", "", "getInhibited", "()Z", "setInhibited", "(Z)V", "Thaumic Arcana"}
)
public interface IInhibitor {
   boolean getInhibited();

   void setInhibited(boolean var1);

   @NotNull
   List<InhibitorAiWrapper> getAiList();

   void setAiList(@NotNull List<? extends InhibitorAiWrapper> var1);
}

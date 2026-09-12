package hu.frontrider.arcana.capabilities.inhibitor;

import hu.frontrider.arcana.api.InhibitorAiWrapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"},
   d2 = {"Lhu/frontrider/arcana/capabilities/inhibitor/InhibitorCapability;", "Lhu/frontrider/arcana/capabilities/inhibitor/IInhibitor;", "()V", "aiList", "", "Lhu/frontrider/arcana/api/InhibitorAiWrapper;", "getAiList", "()Ljava/util/List;", "setAiList", "(Ljava/util/List;)V", "inhibited", "", "getInhibited", "()Z", "setInhibited", "(Z)V", "Thaumic Arcana"}
)
public final class InhibitorCapability implements IInhibitor {
   private boolean inhibited;
   @NotNull
   private List<? extends InhibitorAiWrapper> aiList;

   public boolean getInhibited() {
      return this.inhibited;
   }

   public void setInhibited(boolean var1) {
      this.inhibited = var1;
   }

   @NotNull
   public List<InhibitorAiWrapper> getAiList() {
      return this.aiList;
   }

   public void setAiList(@NotNull List<? extends InhibitorAiWrapper> var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.aiList = var1;
   }

   public InhibitorCapability() {
      List var2 = CollectionsKt.emptyList();
      this.aiList = var2;
   }
}

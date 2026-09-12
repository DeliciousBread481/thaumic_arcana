package hu.frontrider.arcana.entity.inhibitor.ai;

import hu.frontrider.arcana.api.InhibitorAiWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fR6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"},
   d2 = {"Lhu/frontrider/arcana/entity/inhibitor/ai/AIHolder;", "", "()V", "storage", "Ljava/util/HashMap;", "Lnet/minecraft/util/ResourceLocation;", "Lhu/frontrider/arcana/api/InhibitorAiWrapper;", "Lkotlin/collections/HashMap;", "getStorage", "()Ljava/util/HashMap;", "setStorage", "(Ljava/util/HashMap;)V", "register", "", "aiList", "", "Thaumic Arcana"}
)
public final class AIHolder {
   @NotNull
   private static HashMap<ResourceLocation, InhibitorAiWrapper> storage;
   public static final AIHolder INSTANCE;

   @NotNull
   public final HashMap<ResourceLocation, InhibitorAiWrapper> getStorage() {
      return storage;
   }

   public final void setStorage(@NotNull HashMap<ResourceLocation, InhibitorAiWrapper> var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      storage = var1;
   }

   public final void register(@NotNull List<? extends InhibitorAiWrapper> aiList) {
      Intrinsics.checkParameterIsNotNull(aiList, "aiList");

      for(Object element$iv : (Iterable)aiList) {
         InhibitorAiWrapper it = (InhibitorAiWrapper)element$iv;
         Map var6 = (Map)storage;
         ResourceLocation var10000 = it.getID();
         Intrinsics.checkExpressionValueIsNotNull(var10000, "it.id");
         ResourceLocation var7 = var10000;
         var6.put(var7, it);
      }

   }

   private AIHolder() {
   }

   static {
      AIHolder var0 = new AIHolder();
      INSTANCE = var0;
      storage = new HashMap();
   }
}

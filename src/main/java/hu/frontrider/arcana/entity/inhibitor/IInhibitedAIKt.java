package hu.frontrider.arcana.entity.inhibitor;

import hu.frontrider.arcana.api.InhibitorAiWrapper;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\"-\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\" \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"},
   d2 = {"aiList", "Ljava/util/HashMap;", "Lnet/minecraft/util/ResourceLocation;", "Lhu/frontrider/arcana/api/InhibitorAiWrapper;", "Lkotlin/collections/HashMap;", "getAiList", "()Ljava/util/HashMap;", "peopleList", "", "", "getPeopleList", "()Ljava/util/List;", "setPeopleList", "(Ljava/util/List;)V", "Thaumic Arcana"}
)
public final class IInhibitedAIKt {
   @NotNull
   private static final HashMap<ResourceLocation, InhibitorAiWrapper> aiList = new HashMap();
   @NotNull
   public static List<String> peopleList;

   @NotNull
   public static final HashMap<ResourceLocation, InhibitorAiWrapper> getAiList() {
      return aiList;
   }

   @NotNull
   public static final List<String> getPeopleList() {
      List var10000 = peopleList;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("peopleList");
      }

      return var10000;
   }

   public static final void setPeopleList(@NotNull List<String> var0) {
      Intrinsics.checkParameterIsNotNull(var0, "<set-?>");
      peopleList = var0;
   }
}

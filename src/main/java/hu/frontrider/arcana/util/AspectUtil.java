package hu.frontrider.arcana.util;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"},
   d2 = {"Lhu/frontrider/arcana/util/AspectUtil;", "", "()V", "random", "Lthaumcraft/api/aspects/Aspect;", "getRandom", "()Lthaumcraft/api/aspects/Aspect;", "aspectEquals", "", "aspect1", "aspect2", "aspectListEquals", "Lthaumcraft/api/aspects/AspectList;", "getStoredAspects", "itemStack", "Lnet/minecraft/item/ItemStack;", "hashAspectList", "", "list", "Thaumic Arcana"}
)
public final class AspectUtil {
   public static final AspectUtil INSTANCE;

   @NotNull
   public final Aspect getRandom() {
      Collection var10000 = Aspect.aspects.values();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "Aspect.aspects.values");
      Collection aspects = var10000;
      if (aspects == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
      } else {
         Object[] var5 = aspects.toArray(new Aspect[0]);
         if (var5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
         } else {
            return ((Aspect[])var5)[(new Random()).nextInt(aspects.size())];
         }
      }
   }

   public final boolean aspectEquals(@NotNull Aspect aspect1, @NotNull Aspect aspect2) {
      Intrinsics.checkParameterIsNotNull(aspect1, "aspect1");
      Intrinsics.checkParameterIsNotNull(aspect2, "aspect2");
      return Intrinsics.areEqual(aspect1.getTag(), aspect2.getTag());
   }

   public final boolean aspectListEquals(@NotNull AspectList aspect1, @NotNull final AspectList aspect2) {
      Intrinsics.checkParameterIsNotNull(aspect1, "aspect1");
      Intrinsics.checkParameterIsNotNull(aspect2, "aspect2");
      boolean var10000;
      if (aspect1.aspects.size() != aspect2.aspects.size()) {
         var10000 = false;
      } else {
         Object var3 = aspect1.aspects.entrySet().stream().map(new Function<T, R>() {
            public final boolean invoke(Map.Entry<Aspect, Integer> aspectIntegerEntry) {
               Aspect key = (Aspect)aspectIntegerEntry.getKey();
               if (!aspect2.aspects.containsKey(key)) {
                  return false;
               } else {
                  Integer amount = (Integer)aspect2.aspects.get(key);
                  return Intrinsics.areEqual(amount, (Integer)aspectIntegerEntry.getValue());
               }
            }
         }).reduce(true, null.INSTANCE);
         Intrinsics.checkExpressionValueIsNotNull(var3, "aspect1.aspects.entries.…oolean!! && aBoolean2!! }");
         var10000 = (Boolean)var3;
      }

      return var10000;
   }

   @NotNull
   public final AspectList getStoredAspects(@NotNull ItemStack itemStack) {
      Intrinsics.checkParameterIsNotNull(itemStack, "itemStack");
      AspectList aspectList = new AspectList();
      NBTTagCompound var10001 = itemStack.func_77978_p();
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      aspectList.readFromNBT(var10001);
      return aspectList;
   }

   public final int hashAspectList(@NotNull AspectList list) {
      Intrinsics.checkParameterIsNotNull(list, "list");
      NBTTagCompound nbtTagCompound = new NBTTagCompound();
      list.writeToNBT(nbtTagCompound);
      return nbtTagCompound.hashCode();
   }

   private AspectUtil() {
   }

   static {
      AspectUtil var0 = new AspectUtil();
      INSTANCE = var0;
   }
}

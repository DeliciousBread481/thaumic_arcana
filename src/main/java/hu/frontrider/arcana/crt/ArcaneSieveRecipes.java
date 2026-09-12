package hu.frontrider.arcana.crt;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.thaumicarcana.Sieve")
@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"},
   d2 = {"Lhu/frontrider/arcana/crt/ArcaneSieveRecipes;", "", "()V", "register", "", "input1", "Lcrafttweaker/api/item/IIngredient;", "Thaumic Arcana"}
)
public final class ArcaneSieveRecipes {
   @ZenMethod
   public final void register(@NotNull IIngredient input1) {
      Intrinsics.checkParameterIsNotNull(input1, "input1");
      List items = input1.getItems();
      Object var10000 = items.get(0);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "items[0]");
      ((IItemStack)var10000).getName();
   }
}

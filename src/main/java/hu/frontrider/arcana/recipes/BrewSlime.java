package hu.frontrider.arcana.recipes;

import hu.frontrider.arcana.AspectEffectMap;
import hu.frontrider.arcana.AspectEffectMapKt;
import hu.frontrider.arcana.items.ItemInfusedSlime;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.sequences.SequencesKt;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\r"},
   d2 = {"Lhu/frontrider/arcana/recipes/BrewSlime;", "Lnet/minecraftforge/common/brewing/IBrewingRecipe;", "()V", "canBeBrewed", "", "ingredient", "Lnet/minecraft/item/ItemStack;", "getOutput", "input", "isAwkwardPotion", "isIngredient", "isInput", "Companion", "Thaumic Arcana"}
)
public final class BrewSlime implements IBrewingRecipe {
   @ObjectHolder("thaumic_arcana:infused_slime")
   @NotNull
   public static Item infusedSlime;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public boolean isIngredient(@NotNull ItemStack ingredient) {
      Intrinsics.checkParameterIsNotNull(ingredient, "ingredient");
      Item var10000 = ingredient.func_77973_b();
      Item var10001 = infusedSlime;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infusedSlime");
      }

      return Intrinsics.areEqual(var10000, var10001) && Intrinsics.areEqual(AspectEffectMapKt.getSupportedAspects()[ingredient.func_77960_j()], Aspect.CRAFT) ^ true;
   }

   @NotNull
   public ItemStack getOutput(@NotNull ItemStack input, @NotNull ItemStack ingredient) {
      Intrinsics.checkParameterIsNotNull(input, "input");
      Intrinsics.checkParameterIsNotNull(ingredient, "ingredient");
      if (!this.isInput(input)) {
         ItemStack var51 = ItemStack.field_190927_a;
         Intrinsics.checkExpressionValueIsNotNull(var51, "ItemStack.EMPTY");
         return var51;
      } else {
         Item var10000 = ingredient.func_77973_b();
         if (!(var10000 instanceof ItemInfusedSlime)) {
            var10000 = null;
         }

         ItemInfusedSlime var3 = (ItemInfusedSlime)var10000;
         Aspect aspect = AspectEffectMapKt.getSupportedAspects()[ingredient.func_77960_j()];
         AspectEffectMap.EffectEntry potion = (AspectEffectMap.EffectEntry)AspectEffectMap.INSTANCE.getMap().get(aspect);
         List effectsFromStack = PotionUtils.func_185189_a(input);
         PotionEffect var38;
         if (potion != null) {
            Intrinsics.checkExpressionValueIsNotNull(effectsFromStack, "effectsFromStack");
            var38 = (PotionEffect)SequencesKt.firstOrNull(SequencesKt.filter(CollectionsKt.asSequence((Iterable)effectsFromStack), new BrewSlime$getOutput$1$effect$1(potion)));
         } else {
            var38 = null;
         }

         PotionEffect effect = var38;
         ItemStack var41;
         if (effect != null) {
            effectsFromStack.remove(effect);
            var41 = input.func_77946_l();
            SpreadBuilder var10001 = new SpreadBuilder(2);
            var10001.add(new PotionEffect(effect.func_188419_a(), effect.func_76459_b() + 2, effect.func_76458_c()));
            Intrinsics.checkExpressionValueIsNotNull(effectsFromStack, "effectsFromStack");
            Collection $receiver$iv = (Collection)effectsFromStack;
            SpreadBuilder var10 = var10001;
            SpreadBuilder var11 = var10001;
            ItemStack var12 = var41;
            if ($receiver$iv == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
            }

            Object[] var40 = $receiver$iv.toArray(new PotionEffect[0]);
            if (var40 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }

            Object[] var14 = var40;
            var10.addSpread(var14);
            var41 = PotionUtils.func_185184_a(var12, (Collection)CollectionsKt.listOf((PotionEffect[])var11.toArray(new PotionEffect[var11.size()])));
         } else if (Intrinsics.areEqual(aspect, Aspect.ORDER)) {
            Intrinsics.checkExpressionValueIsNotNull(effectsFromStack, "effectsFromStack");
            PotionEffect var42 = (PotionEffect)CollectionsKt.first(effectsFromStack);
            if (var42 == null) {
               return input;
            }

            PotionEffect last = var42;
            effectsFromStack.remove(last);
            ItemStack var43 = input.func_77946_l();
            SpreadBuilder var52 = new SpreadBuilder(2);
            var52.add(new PotionEffect(last.func_188419_a(), last.func_76459_b() * 2, last.func_76458_c()));
            Collection $i$f$toTypedArray = (Collection)effectsFromStack;
            SpreadBuilder var21 = var52;
            SpreadBuilder var24 = var52;
            ItemStack var27 = var43;
            Object[] var44 = $i$f$toTypedArray.toArray(new PotionEffect[0]);
            if (var44 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }

            Object[] var34 = var44;
            var21.addSpread(var34);
            var41 = PotionUtils.func_185184_a(var27, (Collection)CollectionsKt.listOf((PotionEffect[])var24.toArray(new PotionEffect[var24.size()])));
         } else if (Intrinsics.areEqual(aspect, Aspect.ALCHEMY)) {
            Intrinsics.checkExpressionValueIsNotNull(effectsFromStack, "effectsFromStack");
            PotionEffect var45 = (PotionEffect)CollectionsKt.first(effectsFromStack);
            if (var45 == null) {
               return input;
            }

            PotionEffect last = var45;
            if (last.func_76458_c() > 2) {
               return input;
            }

            effectsFromStack.remove(last);
            ItemStack var46 = input.func_77946_l();
            SpreadBuilder var53 = new SpreadBuilder(2);
            var53.add(new PotionEffect(last.func_188419_a(), last.func_76459_b(), last.func_76458_c() + 1));
            Collection $receiver$iv = (Collection)effectsFromStack;
            SpreadBuilder var22 = var53;
            SpreadBuilder var25 = var53;
            ItemStack var28 = var46;
            Object[] var47 = $receiver$iv.toArray(new PotionEffect[0]);
            if (var47 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }

            Object[] var35 = var47;
            var22.addSpread(var35);
            var41 = PotionUtils.func_185184_a(var28, (Collection)CollectionsKt.listOf((PotionEffect[])var25.toArray(new PotionEffect[var25.size()])));
         } else if (potion != null) {
            var41 = input.func_77946_l();
            SpreadBuilder var54 = new SpreadBuilder(2);
            var54.add(new PotionEffect(potion.getPotion(), potion.getDuration(), 0));
            Intrinsics.checkExpressionValueIsNotNull(effectsFromStack, "effectsFromStack");
            Collection last = (Collection)effectsFromStack;
            SpreadBuilder var23 = var54;
            SpreadBuilder var26 = var54;
            ItemStack var29 = var41;
            if (last == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
            }

            Object[] var49 = last.toArray(new PotionEffect[0]);
            if (var49 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }

            Object[] var36 = var49;
            var23.addSpread(var36);
            var41 = PotionUtils.func_185184_a(var29, (Collection)CollectionsKt.listOf((PotionEffect[])var26.toArray(new PotionEffect[var26.size()])));
         } else {
            var41 = input;
         }

         ItemStack result = var41;
         Intrinsics.checkExpressionValueIsNotNull(result, "result");
         NBTTagCompound var50 = result.func_77978_p();
         if (var50 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var50, "result.tagCompound!!");
         NBTTagCompound tagCompound = var50;
         if (tagCompound.func_74764_b("brewCount")) {
            int brewCount = tagCompound.func_74762_e("brewCount") + 1;
            tagCompound.func_74768_a("brewCount", brewCount);
         } else {
            tagCompound.func_74768_a("brewCount", 1);
         }

         String string = tagCompound.func_74779_i("Potion");
         if (Intrinsics.areEqual(string, "minecraft:awkward")) {
            tagCompound.func_74778_a("Potion", "minecraft:thick");
         }

         result.func_77982_d(tagCompound);
         return result;
      }
   }

   public boolean isInput(@NotNull ItemStack ingredient) {
      Intrinsics.checkParameterIsNotNull(ingredient, "ingredient");
      return this.isAwkwardPotion(ingredient) && this.canBeBrewed(ingredient);
   }

   private final boolean isAwkwardPotion(ItemStack ingredient) {
      NBTTagCompound var10000 = ingredient.func_77978_p();
      if (var10000 == null) {
         return false;
      } else {
         NBTTagCompound $receiver = var10000;
         boolean var6;
         if ($receiver.func_74764_b("Potion")) {
            String type = $receiver.func_74779_i("Potion");
            var6 = Intrinsics.areEqual(type, "minecraft:awkward") || Intrinsics.areEqual(type, "minecraft:thick");
         } else {
            var6 = false;
         }

         return var6;
      }
   }

   private final boolean canBeBrewed(ItemStack ingredient) {
      NBTTagCompound var10000 = ingredient.func_77978_p();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      NBTTagCompound $receiver = var10000;
      return $receiver.func_74764_b("brewCount") ? $receiver.func_74762_e("brewCount") < 5 : true;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getInfusedSlime$cp() {
      Item var10000 = infusedSlime;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infusedSlime");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"},
      d2 = {"Lhu/frontrider/arcana/recipes/BrewSlime$Companion;", "", "()V", "infusedSlime", "Lnet/minecraft/item/Item;", "getInfusedSlime", "()Lnet/minecraft/item/Item;", "setInfusedSlime", "(Lnet/minecraft/item/Item;)V", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final Item getInfusedSlime() {
         return BrewSlime.access$getInfusedSlime$cp();
      }

      public final void setInfusedSlime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         BrewSlime.infusedSlime = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

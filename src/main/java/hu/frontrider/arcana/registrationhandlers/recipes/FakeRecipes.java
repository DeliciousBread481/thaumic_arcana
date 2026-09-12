package hu.frontrider.arcana.registrationhandlers.recipes;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.RecipeMisc;
import thaumcraft.api.crafting.RecipeMisc.MiscRecipeType;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0007"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/recipes/FakeRecipes;", "", "()V", "init", "", "initSmelting", "Companion", "Thaumic Arcana"}
)
public final class FakeRecipes {
   @ObjectHolder("thaumic_arcana:slime_meat_raw")
   @NotNull
   public static Item rawSlimeMeat;
   @ObjectHolder("thaumic_arcana:slime_meat_cooked")
   @NotNull
   public static Item cookedSlimeMeat;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public final void init() {
      this.initSmelting();
   }

   public final void initSmelting() {
      ResourceLocation var10000 = new ResourceLocation("thaumic_arcana:smelt_slime_meat");
      RecipeMisc var10001 = new RecipeMisc;
      ItemStack var10003 = new ItemStack;
      Item var10005 = rawSlimeMeat;
      if (var10005 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("rawSlimeMeat");
      }

      var10003.<init>(var10005);
      ItemStack var10004 = new ItemStack;
      Item var10006 = cookedSlimeMeat;
      if (var10006 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cookedSlimeMeat");
      }

      var10004.<init>(var10006);
      var10001.<init>(var10003, var10004, MiscRecipeType.SMELTING);
      ThaumcraftApi.addFakeCraftingRecipe(var10000, var10001);
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getRawSlimeMeat$cp() {
      Item var10000 = rawSlimeMeat;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("rawSlimeMeat");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getCookedSlimeMeat$cp() {
      Item var10000 = cookedSlimeMeat;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cookedSlimeMeat");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"},
      d2 = {"Lhu/frontrider/arcana/registrationhandlers/recipes/FakeRecipes$Companion;", "", "()V", "cookedSlimeMeat", "Lnet/minecraft/item/Item;", "getCookedSlimeMeat", "()Lnet/minecraft/item/Item;", "setCookedSlimeMeat", "(Lnet/minecraft/item/Item;)V", "rawSlimeMeat", "getRawSlimeMeat", "setRawSlimeMeat", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final Item getRawSlimeMeat() {
         return FakeRecipes.access$getRawSlimeMeat$cp();
      }

      public final void setRawSlimeMeat(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         FakeRecipes.rawSlimeMeat = var1;
      }

      @NotNull
      public final Item getCookedSlimeMeat() {
         return FakeRecipes.access$getCookedSlimeMeat$cp();
      }

      public final void setCookedSlimeMeat(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         FakeRecipes.cookedSlimeMeat = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

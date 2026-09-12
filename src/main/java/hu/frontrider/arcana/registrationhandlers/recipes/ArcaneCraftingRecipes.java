package hu.frontrider.arcana.registrationhandlers.recipes;

import hu.frontrider.arcana.AspectEffectMapKt;
import hu.frontrider.arcana.ThaumicArcana;
import hu.frontrider.arcana.items.ItemInfusedSlime;
import hu.frontrider.arcana.recipes.InfuseSlimiumTool;
import hu.frontrider.arcana.util.ListBuilder;
import hu.frontrider.arcana.util.items.NbtAwareIngredient;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.api.items.ItemsTC;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/recipes/ArcaneCraftingRecipes;", "", "()V", "defaultGroup", "Lnet/minecraft/util/ResourceLocation;", "initLivium", "", "initRecipes", "initSlimeInfusion", "initSlimeMeat", "initSlimyTools", "initSouls", "register", "Companion", "Thaumic Arcana"}
)
public final class ArcaneCraftingRecipes {
   private final ResourceLocation defaultGroup = new ResourceLocation("thaumic_arcana", "biomancy");
   @ObjectHolder("thaumic_arcana:experiment_table")
   @Nullable
   private static Block experiment_table;
   @ObjectHolder("thaumic_arcana:creature_enchanter")
   @Nullable
   private static Item enchanter;
   @ObjectHolder("thaumic_arcana:neutered_flesh")
   @NotNull
   public static Item neutered_flesh;
   @ObjectHolder("thaumic_arcana:slime_meat_raw")
   @NotNull
   public static Item slimeMeat;
   @ObjectHolder("thaumic_arcana:ingot_livium")
   @NotNull
   public static Item ingot_livium;
   @ObjectHolder("thaumic_arcana:livium_pickaxe")
   @NotNull
   public static Item pickaxe_livium;
   @ObjectHolder("thaumic_arcana:livium_axe")
   @NotNull
   public static Item axe_livium;
   @ObjectHolder("thaumic_arcana:livium_shovel")
   @NotNull
   public static Item shovel_livium;
   @ObjectHolder("thaumic_arcana:livium_sword")
   @NotNull
   public static Item sword_livium;
   @ObjectHolder("thaumic_arcana:paving_stone_disable_enchants")
   @Nullable
   private static Block disable_enchants;
   @ObjectHolder("thaumic_arcana:paving_stone_enable_enchants")
   @Nullable
   private static Block enable_enchants;
   @ObjectHolder("thaumcraft:stone_arcane_brick")
   @Nullable
   private static Block arcane_stone;
   @ObjectHolder("thaumic_arcana:arcane_sieve")
   @NotNull
   public static Block arcane_sieve;
   @ObjectHolder("thaumic_arcana:empty_soul_capsule")
   @NotNull
   public static Item empty_soul_capsule;
   @ObjectHolder("thaumic_arcana:soul_capsule")
   @NotNull
   public static Item soul_capsule;
   @ObjectHolder("thaumic_arcana:experience_store")
   @NotNull
   public static Item experience_store;
   @ObjectHolder("thaumcraft:salis_mundus")
   @Nullable
   private static Item sal_mundi;
   @ObjectHolder("thaumcraft:plank_greatwood")
   @NotNull
   public static Item plank_greatwood;
   @ObjectHolder("minecraft:bowl")
   @Nullable
   private static Item bowl;
   @ObjectHolder("minecraft:glass_bottle")
   @Nullable
   private static Item bottle;
   @ObjectHolder("minecraft:stick")
   @NotNull
   public static Item stick;
   @ObjectHolder("minecraft:slime_ball")
   @NotNull
   public static Item slime;
   @ObjectHolder("minecraft:iron_ingot")
   @NotNull
   public static Item iron_ingot;
   @ObjectHolder("thaumic_arcana:slimy_pickaxe")
   @NotNull
   public static Item pickaxe_slime;
   @ObjectHolder("thaumic_arcana:slimy_axe")
   @NotNull
   public static Item axe_slime;
   @ObjectHolder("thaumic_arcana:slimy_shovel")
   @NotNull
   public static Item shovel_slime;
   @ObjectHolder("thaumic_arcana:slimy_sword")
   @NotNull
   public static Item sword_slime;
   @ObjectHolder("thaumic_arcana:slimy_hoe")
   @NotNull
   public static Item hoe_slime;
   @ObjectHolder("thaumic_arcana:infused_slime")
   @NotNull
   public static Item infused_slime;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public final void register() {
      this.initRecipes();
      this.initLivium();
      this.initSlimyTools();
      this.initSlimeMeat();
      this.initSlimeInfusion();
      this.initSouls();
   }

   private final void initRecipes() {
      ArcaneCraftingRecipes $receiver = this;
      NonNullList var10002 = NonNullList.func_191196_a();
      Intrinsics.checkExpressionValueIsNotNull(var10002, "NonNullList.create<Ingredient>()");
      ListBuilder var10000 = new ListBuilder((List)var10002);
      Item var10001 = Items.field_151122_aG;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000 = var10000.add(Ingredient.func_193367_a(var10001));
      var10001 = sal_mundi;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000 = var10000.add(Ingredient.func_193367_a(var10001));
      var10001 = sal_mundi;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000 = var10000.add(Ingredient.func_193367_a(var10001));
      var10001 = sal_mundi;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      List var12 = var10000.add(Ingredient.func_193367_a(var10001)).add(Ingredient.func_193369_a(new ItemStack[]{ThaumcraftApiHelper.makeCrystal(Aspect.LIFE)})).build();
      if (var12 == null) {
         throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
      } else {
         NonNullList book = (NonNullList)var12;
         ResourceLocation var13 = new ResourceLocation("thaumic_arcana", "create_book");
         ShapelessArcaneRecipe var19 = new ShapelessArcaneRecipe;
         ResourceLocation var10003 = $receiver.defaultGroup;
         AspectList var10006 = (new AspectList()).add(Aspect.ENTROPY, 3).add(Aspect.EARTH, 1).add(Aspect.AIR, 1);
         ItemStack var10007 = new ItemStack;
         Item var10009 = enchanter;
         if (var10009 == null) {
            Intrinsics.throwNpe();
         }

         var10007.<init>(var10009);
         var19.<init>(var10003, "BIOMANCY_BASICS", 30, var10006, var10007, book.toArray());
         ThaumcraftApi.addArcaneCraftingRecipe(var13, (IArcaneRecipe)var19);
         $receiver = this;
         CraftingHelper.ShapedPrimer cagePrimer = new CraftingHelper.ShapedPrimer();
         cagePrimer.height = 3;
         cagePrimer.width = 3;
         NonNullList var58 = NonNullList.func_191196_a();
         Intrinsics.checkExpressionValueIsNotNull(var58, "NonNullList.create<Ingredient>()");
         ListBuilder var20 = new ListBuilder((List)var58);
         ItemStack[] var42 = new ItemStack[1];
         ItemStack var10005 = new ItemStack;
         Block var80 = arcane_stone;
         if (var80 == null) {
            Intrinsics.throwNpe();
         }

         var10005.<init>(var80);
         var42[0] = var10005;
         var20 = var20.add(Ingredient.func_193369_a(var42));
         var42 = new ItemStack[1];
         var10005 = new ItemStack;
         var80 = arcane_stone;
         if (var80 == null) {
            Intrinsics.throwNpe();
         }

         var10005.<init>(var80);
         var42[0] = var10005;
         var20 = var20.add(Ingredient.func_193369_a(var42));
         var42 = new ItemStack[1];
         var10005 = new ItemStack;
         var80 = arcane_stone;
         if (var80 == null) {
            Intrinsics.throwNpe();
         }

         var10005.<init>(var80);
         var42[0] = var10005;
         var20 = var20.add(Ingredient.func_193369_a(var42));
         var42 = new ItemStack[1];
         var10005 = new ItemStack;
         var80 = arcane_stone;
         if (var80 == null) {
            Intrinsics.throwNpe();
         }

         var10005.<init>(var80);
         var42[0] = var10005;
         var20 = var20.add(Ingredient.func_193369_a(var42));
         ItemStack[] var10004 = new ItemStack[1];
         ItemStack var84 = ThaumcraftApiHelper.makeCrystal(Aspect.AURA);
         Intrinsics.checkExpressionValueIsNotNull(var84, "ThaumcraftApiHelper.makeCrystal(Aspect.AURA)");
         var10004[0] = var84;
         var20 = var20.add(new NbtAwareIngredient(var10004));
         var42 = new ItemStack[1];
         var10005 = new ItemStack;
         Block var85 = arcane_stone;
         if (var85 == null) {
            Intrinsics.throwNpe();
         }

         var10005.<init>(var85);
         var42[0] = var10005;
         var20 = var20.add(Ingredient.func_193369_a(var42));
         var42 = new ItemStack[1];
         var10005 = new ItemStack;
         var85 = arcane_stone;
         if (var85 == null) {
            Intrinsics.throwNpe();
         }

         var10005.<init>(var85);
         var42[0] = var10005;
         var20 = var20.add(Ingredient.func_193369_a(var42));
         var42 = new ItemStack[1];
         var10005 = new ItemStack;
         var85 = arcane_stone;
         if (var85 == null) {
            Intrinsics.throwNpe();
         }

         var10005.<init>(var85);
         var42[0] = var10005;
         var20 = var20.add(Ingredient.func_193369_a(var42));
         var42 = new ItemStack[1];
         var10005 = new ItemStack;
         var85 = arcane_stone;
         if (var85 == null) {
            Intrinsics.throwNpe();
         }

         var10005.<init>(var85);
         var42[0] = var10005;
         List var29 = var20.add(Ingredient.func_193369_a(var42)).build();
         if (var29 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
         } else {
            cagePrimer.input = (NonNullList)var29;
            var13 = new ResourceLocation("thaumic_arcana", "arcane_stone_enable_enchants");
            ShapedArcaneRecipe var30 = new ShapedArcaneRecipe;
            ResourceLocation var59 = $receiver.defaultGroup;
            var10006 = (new AspectList()).add(Aspect.ORDER, 2).merge(Aspect.EARTH, 1).merge(Aspect.WATER, 1);
            ItemStack var89 = new ItemStack;
            Block var100 = enable_enchants;
            if (var100 == null) {
               Intrinsics.throwNpe();
            }

            var89.<init>(var100, 4);
            var30.<init>(var59, "ENCHANT_FOCUS", 20, var10006, var89, cagePrimer);
            ThaumcraftApi.addArcaneCraftingRecipe(var13, (IArcaneRecipe)var30);
            $receiver = this;
            cagePrimer = new CraftingHelper.ShapedPrimer();
            cagePrimer.height = 3;
            cagePrimer.width = 3;
            NonNullList var60 = NonNullList.func_191196_a();
            Intrinsics.checkExpressionValueIsNotNull(var60, "NonNullList.create<Ingredient>()");
            ListBuilder var31 = new ListBuilder((List)var60);
            var42 = new ItemStack[1];
            var10005 = new ItemStack;
            Block var90 = arcane_stone;
            if (var90 == null) {
               Intrinsics.throwNpe();
            }

            var10005.<init>(var90);
            var42[0] = var10005;
            var31 = var31.add(Ingredient.func_193369_a(var42));
            var42 = new ItemStack[1];
            var10005 = new ItemStack;
            var90 = arcane_stone;
            if (var90 == null) {
               Intrinsics.throwNpe();
            }

            var10005.<init>(var90);
            var42[0] = var10005;
            var31 = var31.add(Ingredient.func_193369_a(var42));
            var42 = new ItemStack[1];
            var10005 = new ItemStack;
            var90 = arcane_stone;
            if (var90 == null) {
               Intrinsics.throwNpe();
            }

            var10005.<init>(var90);
            var42[0] = var10005;
            var31 = var31.add(Ingredient.func_193369_a(var42));
            var42 = new ItemStack[1];
            var10005 = new ItemStack;
            var90 = arcane_stone;
            if (var90 == null) {
               Intrinsics.throwNpe();
            }

            var10005.<init>(var90);
            var42[0] = var10005;
            var31 = var31.add(Ingredient.func_193369_a(var42));
            var10004 = new ItemStack[1];
            ItemStack var94 = ThaumcraftApiHelper.makeCrystal(Aspect.FLUX);
            Intrinsics.checkExpressionValueIsNotNull(var94, "ThaumcraftApiHelper.makeCrystal(Aspect.FLUX)");
            var10004[0] = var94;
            var31 = var31.add(new NbtAwareIngredient(var10004));
            var42 = new ItemStack[1];
            var10005 = new ItemStack;
            Block var95 = arcane_stone;
            if (var95 == null) {
               Intrinsics.throwNpe();
            }

            var10005.<init>(var95);
            var42[0] = var10005;
            var31 = var31.add(Ingredient.func_193369_a(var42));
            var42 = new ItemStack[1];
            var10005 = new ItemStack;
            var95 = arcane_stone;
            if (var95 == null) {
               Intrinsics.throwNpe();
            }

            var10005.<init>(var95);
            var42[0] = var10005;
            var31 = var31.add(Ingredient.func_193369_a(var42));
            var42 = new ItemStack[1];
            var10005 = new ItemStack;
            var95 = arcane_stone;
            if (var95 == null) {
               Intrinsics.throwNpe();
            }

            var10005.<init>(var95);
            var42[0] = var10005;
            var31 = var31.add(Ingredient.func_193369_a(var42));
            var42 = new ItemStack[1];
            var10005 = new ItemStack;
            var95 = arcane_stone;
            if (var95 == null) {
               Intrinsics.throwNpe();
            }

            var10005.<init>(var95);
            var42[0] = var10005;
            List var40 = var31.add(Ingredient.func_193369_a(var42)).build();
            if (var40 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
            } else {
               cagePrimer.input = (NonNullList)var40;
               var13 = new ResourceLocation("thaumic_arcana", "arcane_stone_disable_enchants");
               ShapedArcaneRecipe var41 = new ShapedArcaneRecipe;
               ResourceLocation var61 = $receiver.defaultGroup;
               var10006 = (new AspectList()).add(Aspect.ENTROPY, 2).merge(Aspect.EARTH, 1).merge(Aspect.WATER, 1);
               ItemStack var99 = new ItemStack;
               var100 = disable_enchants;
               if (var100 == null) {
                  Intrinsics.throwNpe();
               }

               var99.<init>(var100, 4);
               var41.<init>(var61, "ENCHANT_FOCUS", 20, var10006, var99, cagePrimer);
               ThaumcraftApi.addArcaneCraftingRecipe(var13, (IArcaneRecipe)var41);
            }
         }
      }
   }

   private final void initLivium() {
      ResourceLocation liviumGroup = new ResourceLocation("thaumic_arcana", "biomancy_livium");
      ArcaneCraftingRecipes $receiver = this;
      ResourceLocation fleshGroup = new ResourceLocation("thaumic_arcana", "biomancy_livium_flesh");
      ResourceLocation var10000 = new ResourceLocation("thaumic_arcana", "neutered_flesh");
      ShapelessArcaneRecipe var10001 = new ShapelessArcaneRecipe;
      AspectList var10006 = (new AspectList()).add(Aspect.ENTROPY, 1).add(Aspect.ORDER, 1);
      ItemStack var10007 = new ItemStack;
      Item var10009 = neutered_flesh;
      if (var10009 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("neutered_flesh");
      }

      var10007.<init>(var10009);
      var10001.<init>(fleshGroup, "", 30, var10006, var10007, new String[]{"allFlesh"});
      ThaumcraftApi.addArcaneCraftingRecipe(var10000, (IArcaneRecipe)var10001);
      $receiver = this;
      CraftingHelper.ShapedPrimer tool = new CraftingHelper.ShapedPrimer();
      tool.height = 3;
      tool.width = 3;
      NonNullList var10003 = NonNullList.func_191196_a();
      Intrinsics.checkExpressionValueIsNotNull(var10003, "NonNullList.create<Ingredient>()");
      ListBuilder var18 = new ListBuilder((List)var10003);
      ItemStack[] var10002 = new ItemStack[1];
      ItemStack var10005 = new ItemStack;
      Item var72 = ingot_livium;
      if (var72 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
      }

      var10005.<init>(var72);
      var10002[0] = var10005;
      var18 = var18.add(Ingredient.func_193369_a(var10002));
      var10002 = new ItemStack[1];
      var10005 = new ItemStack;
      var72 = ingot_livium;
      if (var72 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
      }

      var10005.<init>(var72);
      var10002[0] = var10005;
      var18 = var18.add(Ingredient.func_193369_a(var10002));
      var10002 = new ItemStack[1];
      var10005 = new ItemStack;
      var72 = ingot_livium;
      if (var72 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
      }

      var10005.<init>(var72);
      var10002[0] = var10005;
      var18 = var18.add(Ingredient.func_193369_a(var10002)).add(Ingredient.field_193370_a);
      Item var44 = stick;
      if (var44 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("stick");
      }

      var18 = var18.add(Ingredient.func_193367_a(var44)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
      var44 = stick;
      if (var44 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("stick");
      }

      List var23 = var18.add(Ingredient.func_193367_a(var44)).add(Ingredient.field_193370_a).build();
      if (var23 == null) {
         throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
      } else {
         tool.input = (NonNullList)var23;
         var10000 = new ResourceLocation("thaumic_arcana", "create_livium_pickaxe");
         ShapedArcaneRecipe var24 = new ShapedArcaneRecipe;
         var10006 = (new AspectList()).add(Aspect.ORDER, 2).merge(Aspect.EARTH, 1).merge(Aspect.WATER, 1);
         ItemStack var75 = new ItemStack;
         var10009 = pickaxe_livium;
         if (var10009 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickaxe_livium");
         }

         var75.<init>(var10009);
         var24.<init>(liviumGroup, "LIVIUM", 10, var10006, var75, tool);
         ThaumcraftApi.addArcaneCraftingRecipe(var10000, (IArcaneRecipe)var24);
         $receiver = this;
         tool = new CraftingHelper.ShapedPrimer();
         tool.height = 3;
         tool.width = 3;
         var10003 = NonNullList.func_191196_a();
         Intrinsics.checkExpressionValueIsNotNull(var10003, "NonNullList.create<Ingredient>()");
         ListBuilder var25 = new ListBuilder((List)var10003);
         ItemStack[] var46 = new ItemStack[1];
         var10005 = new ItemStack;
         Item var76 = ingot_livium;
         if (var76 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
         }

         var10005.<init>(var76);
         var46[0] = var10005;
         var25 = var25.add(Ingredient.func_193369_a(var46));
         var46 = new ItemStack[1];
         var10005 = new ItemStack;
         var76 = ingot_livium;
         if (var76 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
         }

         var10005.<init>(var76);
         var46[0] = var10005;
         var25 = var25.add(Ingredient.func_193369_a(var46)).add(Ingredient.field_193370_a);
         var46 = new ItemStack[1];
         var10005 = new ItemStack;
         var76 = ingot_livium;
         if (var76 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
         }

         var10005.<init>(var76);
         var46[0] = var10005;
         var25 = var25.add(Ingredient.func_193369_a(var46));
         Item var49 = stick;
         if (var49 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stick");
         }

         var25 = var25.add(Ingredient.func_193367_a(var49)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
         var49 = stick;
         if (var49 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stick");
         }

         List var30 = var25.add(Ingredient.func_193367_a(var49)).add(Ingredient.field_193370_a).build();
         if (var30 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
         } else {
            tool.input = (NonNullList)var30;
            var10000 = new ResourceLocation("thaumic_arcana", "create_livium_axe");
            ShapedArcaneRecipe var31 = new ShapedArcaneRecipe;
            var10006 = (new AspectList()).add(Aspect.ORDER, 2).merge(Aspect.EARTH, 1).merge(Aspect.WATER, 1);
            ItemStack var79 = new ItemStack;
            var10009 = axe_livium;
            if (var10009 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("axe_livium");
            }

            var79.<init>(var10009);
            var31.<init>(liviumGroup, "LIVIUM", 10, var10006, var79, tool);
            ThaumcraftApi.addArcaneCraftingRecipe(var10000, (IArcaneRecipe)var31);
            $receiver = this;
            tool = new CraftingHelper.ShapedPrimer();
            tool.height = 3;
            tool.width = 3;
            var10003 = NonNullList.func_191196_a();
            Intrinsics.checkExpressionValueIsNotNull(var10003, "NonNullList.create<Ingredient>()");
            ListBuilder var32 = (new ListBuilder((List)var10003)).add(Ingredient.field_193370_a);
            ItemStack[] var51 = new ItemStack[1];
            var10005 = new ItemStack;
            Item var80 = ingot_livium;
            if (var80 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
            }

            var10005.<init>(var80);
            var51[0] = var10005;
            var32 = var32.add(Ingredient.func_193369_a(var51)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
            Item var52 = stick;
            if (var52 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("stick");
            }

            var32 = var32.add(Ingredient.func_193367_a(var52)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
            var52 = stick;
            if (var52 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("stick");
            }

            List var35 = var32.add(Ingredient.func_193367_a(var52)).add(Ingredient.field_193370_a).build();
            if (var35 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
            } else {
               tool.input = (NonNullList)var35;
               var10000 = new ResourceLocation("thaumic_arcana", "create_livium_shovel");
               ShapedArcaneRecipe var36 = new ShapedArcaneRecipe;
               var10006 = (new AspectList()).add(Aspect.ORDER, 2).merge(Aspect.EARTH, 1).merge(Aspect.WATER, 1);
               ItemStack var81 = new ItemStack;
               var10009 = shovel_livium;
               if (var10009 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("shovel_livium");
               }

               var81.<init>(var10009);
               var36.<init>(liviumGroup, "LIVIUM", 10, var10006, var81, tool);
               ThaumcraftApi.addArcaneCraftingRecipe(var10000, (IArcaneRecipe)var36);
               $receiver = this;
               tool = new CraftingHelper.ShapedPrimer();
               tool.height = 3;
               tool.width = 3;
               var10003 = NonNullList.func_191196_a();
               Intrinsics.checkExpressionValueIsNotNull(var10003, "NonNullList.create<Ingredient>()");
               ListBuilder var37 = (new ListBuilder((List)var10003)).add(Ingredient.field_193370_a);
               ItemStack[] var54 = new ItemStack[1];
               var10005 = new ItemStack;
               Item var82 = ingot_livium;
               if (var82 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
               }

               var10005.<init>(var82);
               var54[0] = var10005;
               var37 = var37.add(Ingredient.func_193369_a(var54)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
               var54 = new ItemStack[1];
               var10005 = new ItemStack;
               var82 = ingot_livium;
               if (var82 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
               }

               var10005.<init>(var82);
               var54[0] = var10005;
               var37 = var37.add(Ingredient.func_193369_a(var54)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
               Item var56 = stick;
               if (var56 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("stick");
               }

               List var40 = var37.add(Ingredient.func_193367_a(var56)).add(Ingredient.field_193370_a).build();
               if (var40 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
               } else {
                  tool.input = (NonNullList)var40;
                  var10000 = new ResourceLocation("thaumic_arcana", "create_livium_sword");
                  ShapedArcaneRecipe var41 = new ShapedArcaneRecipe;
                  var10006 = (new AspectList()).add(Aspect.ORDER, 2).merge(Aspect.EARTH, 1).merge(Aspect.WATER, 1);
                  ItemStack var84 = new ItemStack;
                  var10009 = sword_livium;
                  if (var10009 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("sword_livium");
                  }

                  var84.<init>(var10009);
                  var41.<init>(liviumGroup, "LIVIUM", 10, var10006, var84, tool);
                  ThaumcraftApi.addArcaneCraftingRecipe(var10000, (IArcaneRecipe)var41);
               }
            }
         }
      }
   }

   private final void initSlimyTools() {
      ResourceLocation slimyGroup = new ResourceLocation("thaumic_arcana", "biomancy_slimy");
      ArcaneCraftingRecipes $receiver = this;
      CraftingHelper.ShapedPrimer tool = new CraftingHelper.ShapedPrimer();
      tool.height = 3;
      tool.width = 3;
      NonNullList var10003 = NonNullList.func_191196_a();
      Intrinsics.checkExpressionValueIsNotNull(var10003, "NonNullList.create<Ingredient>()");
      ListBuilder var10001 = new ListBuilder((List)var10003);
      ItemStack[] var10002 = new ItemStack[1];
      ItemStack var10005 = new ItemStack;
      Item var10007 = slime;
      if (var10007 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("slime");
      }

      var10005.<init>(var10007);
      var10002[0] = var10005;
      var10001 = var10001.add(Ingredient.func_193369_a(var10002));
      var10002 = new ItemStack[1];
      var10005 = new ItemStack;
      var10007 = iron_ingot;
      if (var10007 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("iron_ingot");
      }

      var10005.<init>(var10007);
      var10002[0] = var10005;
      var10001 = var10001.add(Ingredient.func_193369_a(var10002));
      var10002 = new ItemStack[1];
      var10005 = new ItemStack;
      var10007 = slime;
      if (var10007 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("slime");
      }

      var10005.<init>(var10007);
      var10002[0] = var10005;
      var10001 = var10001.add(Ingredient.func_193369_a(var10002)).add(Ingredient.field_193370_a);
      Item var55 = stick;
      if (var55 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("stick");
      }

      var10001 = var10001.add(Ingredient.func_193367_a(var55)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
      var55 = stick;
      if (var55 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("stick");
      }

      List var32 = var10001.add(Ingredient.func_193367_a(var55)).add(Ingredient.field_193370_a).build();
      if (var32 == null) {
         throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
      } else {
         tool.input = (NonNullList)var32;
         ItemStack var10000 = new ItemStack;
         var55 = pickaxe_slime;
         if (var55 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickaxe_slime");
         }

         var10000.<init>(var55);
         ItemStack result = var10000;
         EnchantmentHelper.func_82782_a(MapsKt.mapOf(new Pair(Enchantments.field_185306_r, 1)), result);
         ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("thaumic_arcana", "create_slimy_pickaxe"), (IArcaneRecipe)(new ShapedArcaneRecipe(slimyGroup, "TA_SLIME@4", 40, (new AspectList()).add(Aspect.ORDER, 4), result, tool)));
         Unit var19 = Unit.INSTANCE;
         $receiver = this;
         tool = new CraftingHelper.ShapedPrimer();
         tool.height = 3;
         tool.width = 3;
         var10003 = NonNullList.func_191196_a();
         Intrinsics.checkExpressionValueIsNotNull(var10003, "NonNullList.create<Ingredient>()");
         ListBuilder var33 = new ListBuilder((List)var10003);
         ItemStack[] var58 = new ItemStack[1];
         var10005 = new ItemStack;
         var10007 = slime;
         if (var10007 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slime");
         }

         var10005.<init>(var10007);
         var58[0] = var10005;
         var33 = var33.add(Ingredient.func_193369_a(var58));
         var58 = new ItemStack[1];
         var10005 = new ItemStack;
         var10007 = iron_ingot;
         if (var10007 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iron_ingot");
         }

         var10005.<init>(var10007);
         var58[0] = var10005;
         var33 = var33.add(Ingredient.func_193369_a(var58)).add(Ingredient.field_193370_a);
         var58 = new ItemStack[1];
         var10005 = new ItemStack;
         var10007 = slime;
         if (var10007 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slime");
         }

         var10005.<init>(var10007);
         var58[0] = var10005;
         var33 = var33.add(Ingredient.func_193369_a(var58));
         Item var61 = stick;
         if (var61 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stick");
         }

         var33 = var33.add(Ingredient.func_193367_a(var61)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
         var61 = stick;
         if (var61 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stick");
         }

         List var38 = var33.add(Ingredient.func_193367_a(var61)).add(Ingredient.field_193370_a).build();
         if (var38 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
         } else {
            tool.input = (NonNullList)var38;
            ItemStack var20 = new ItemStack;
            var61 = axe_slime;
            if (var61 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("axe_slime");
            }

            var20.<init>(var61);
            result = var20;
            EnchantmentHelper.func_82782_a(MapsKt.mapOf(new Pair(Enchantments.field_185306_r, 1)), result);
            ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("thaumic_arcana", "create_slimy_axe"), (IArcaneRecipe)(new ShapedArcaneRecipe(slimyGroup, "TA_SLIME@4", 40, (new AspectList()).add(Aspect.ORDER, 4), result, tool)));
            Unit var21 = Unit.INSTANCE;
            $receiver = this;
            tool = new CraftingHelper.ShapedPrimer();
            tool.height = 3;
            tool.width = 3;
            var10003 = NonNullList.func_191196_a();
            Intrinsics.checkExpressionValueIsNotNull(var10003, "NonNullList.create<Ingredient>()");
            ListBuilder var39 = (new ListBuilder((List)var10003)).add(Ingredient.field_193370_a);
            ItemStack[] var64 = new ItemStack[1];
            var10005 = new ItemStack;
            var10007 = slime;
            if (var10007 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("slime");
            }

            var10005.<init>(var10007);
            var64[0] = var10005;
            var39 = var39.add(Ingredient.func_193369_a(var64)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
            Item var65 = stick;
            if (var65 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("stick");
            }

            var39 = var39.add(Ingredient.func_193367_a(var65));
            ItemStack[] var66 = new ItemStack[1];
            var10005 = new ItemStack;
            var10007 = iron_ingot;
            if (var10007 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("iron_ingot");
            }

            var10005.<init>(var10007);
            var66[0] = var10005;
            var39 = var39.add(Ingredient.func_193369_a(var66)).add(Ingredient.field_193370_a);
            Item var67 = stick;
            if (var67 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("stick");
            }

            List var43 = var39.add(Ingredient.func_193367_a(var67)).add(Ingredient.field_193370_a).build();
            if (var43 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
            } else {
               tool.input = (NonNullList)var43;
               ItemStack var22 = new ItemStack;
               var67 = shovel_slime;
               if (var67 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("shovel_slime");
               }

               var22.<init>(var67);
               result = var22;
               EnchantmentHelper.func_82782_a(MapsKt.mapOf(new Pair(Enchantments.field_185306_r, 1)), result);
               ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("thaumic_arcana", "create_slimy_shovel"), (IArcaneRecipe)(new ShapedArcaneRecipe(slimyGroup, "TA_SLIME@4", 40, (new AspectList()).add(Aspect.ORDER, 4), result, tool)));
               Unit var23 = Unit.INSTANCE;
               $receiver = this;
               tool = new CraftingHelper.ShapedPrimer();
               tool.height = 3;
               tool.width = 3;
               ItemStack var24 = new ItemStack;
               var67 = hoe_slime;
               if (var67 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("hoe_slime");
               }

               var24.<init>(var67);
               result = var24;
               EnchantmentHelper.func_82782_a(MapsKt.mapOf(new Pair(Enchantments.field_185306_r, 1)), result);
               var10003 = NonNullList.func_191196_a();
               Intrinsics.checkExpressionValueIsNotNull(var10003, "NonNullList.create<Ingredient>()");
               ListBuilder var44 = new ListBuilder((List)var10003);
               ItemStack[] var70 = new ItemStack[1];
               var10005 = new ItemStack;
               var10007 = iron_ingot;
               if (var10007 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("iron_ingot");
               }

               var10005.<init>(var10007);
               var70[0] = var10005;
               var44 = var44.add(Ingredient.func_193369_a(var70));
               var70 = new ItemStack[1];
               var10005 = new ItemStack;
               var10007 = slime;
               if (var10007 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("slime");
               }

               var10005.<init>(var10007);
               var70[0] = var10005;
               var44 = var44.add(Ingredient.func_193369_a(var70)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
               Item var72 = stick;
               if (var72 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("stick");
               }

               var44 = var44.add(Ingredient.func_193367_a(var72)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
               var72 = stick;
               if (var72 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("stick");
               }

               List var48 = var44.add(Ingredient.func_193367_a(var72)).add(Ingredient.field_193370_a).build();
               if (var48 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
               } else {
                  tool.input = (NonNullList)var48;
                  ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("thaumic_arcana", "create_slimy_hoe"), (IArcaneRecipe)(new ShapedArcaneRecipe(slimyGroup, "TA_SLIME@4", 40, (new AspectList()).add(Aspect.ORDER, 4), result, tool)));
                  Unit var25 = Unit.INSTANCE;
                  $receiver = this;
                  tool = new CraftingHelper.ShapedPrimer();
                  tool.height = 3;
                  tool.width = 3;
                  var10003 = NonNullList.func_191196_a();
                  Intrinsics.checkExpressionValueIsNotNull(var10003, "NonNullList.create<Ingredient>()");
                  ListBuilder var49 = (new ListBuilder((List)var10003)).add(Ingredient.field_193370_a);
                  ItemStack[] var74 = new ItemStack[1];
                  var10005 = new ItemStack;
                  var10007 = slime;
                  if (var10007 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("slime");
                  }

                  var10005.<init>(var10007);
                  var74[0] = var10005;
                  var49 = var49.add(Ingredient.func_193369_a(var74)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
                  var74 = new ItemStack[1];
                  var10005 = new ItemStack;
                  var10007 = iron_ingot;
                  if (var10007 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("iron_ingot");
                  }

                  var10005.<init>(var10007);
                  var74[0] = var10005;
                  var49 = var49.add(Ingredient.func_193369_a(var74)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
                  Item var76 = stick;
                  if (var76 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("stick");
                  }

                  List var52 = var49.add(Ingredient.func_193367_a(var76)).add(Ingredient.field_193370_a).build();
                  if (var52 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
                  } else {
                     tool.input = (NonNullList)var52;
                     ItemStack var26 = new ItemStack;
                     var76 = sword_slime;
                     if (var76 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sword_slime");
                     }

                     var26.<init>(var76);
                     result = var26;
                     EnchantmentHelper.func_82782_a(MapsKt.mapOf(new Pair(Enchantments.field_185306_r, 1)), result);
                     ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("thaumic_arcana", "create_slimy_sword"), (IArcaneRecipe)(new ShapedArcaneRecipe(slimyGroup, "TA_SLIME@4", 40, (new AspectList()).add(Aspect.ORDER, 4), result, tool)));
                     Unit var27 = Unit.INSTANCE;
                  }
               }
            }
         }
      }
   }

   private final void initSlimeMeat() {
      <undefinedtype> makeSlimeMeat$ = new Function2<Item, String, Unit>() {
         public final void invoke(@NotNull Item item, @NotNull String tag) {
            Intrinsics.checkParameterIsNotNull(item, "item");
            Intrinsics.checkParameterIsNotNull(tag, "tag");
            ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("thaumic_arcana", "make_slime_" + tag), (IArcaneRecipe)(new ShapelessArcaneRecipe(ArcaneCraftingRecipes.this.defaultGroup, "TA_SLIME_MEAT", 30, (new AspectList()).add(Aspect.ORDER, 3).add(Aspect.EARTH, 1).add(Aspect.WATER, 1), new ItemStack(ArcaneCraftingRecipes.Companion.getSlimeMeat(), 4), new Item[]{item, Items.field_151123_aH, Items.field_151123_aH, Items.field_151123_aH})));
         }
      };
      Item var10001 = Items.field_151082_bd;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Items.BEEF");
      makeSlimeMeat$.invoke(var10001, "beef");
      var10001 = Items.field_179561_bm;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Items.MUTTON");
      makeSlimeMeat$.invoke(var10001, "mutton");
      var10001 = Items.field_151147_al;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Items.PORKCHOP");
      makeSlimeMeat$.invoke(var10001, "pork");
   }

   private final void initSlimeInfusion() {
      NonNullList variants = NonNullList.func_191196_a();
      Item var10000 = infused_slime;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infused_slime");
      }

      var10000.func_150895_a(ThaumicArcana.INSTANCE.getTABARCANA(), variants);
      Intrinsics.checkExpressionValueIsNotNull(variants, "variants");

      for(Object element$iv : (Iterable)variants) {
         ItemStack it = (ItemStack)element$iv;
         Aspect[] var13 = AspectEffectMapKt.getSupportedAspects();
         Intrinsics.checkExpressionValueIsNotNull(it, "it");
         Aspect aspect = var13[it.func_77960_j()];
         ItemStack crystal = ThaumcraftApiHelper.makeCrystal(aspect);
         ItemInfusedSlime.Companion var14 = ItemInfusedSlime.Companion;
         Aspect var10001 = Aspect.CRAFT;
         Intrinsics.checkExpressionValueIsNotNull(var10001, "Aspect.CRAFT");
         Item var10002 = infused_slime;
         if (var10002 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infused_slime");
         }

         ItemStack fabric = var14.createSlimeFor(var10001, var10002);
         NonNullList var18 = NonNullList.func_191196_a();
         Intrinsics.checkExpressionValueIsNotNull(var18, "NonNullList.create<Ingredient>()");
         ListBuilder var15 = new ListBuilder((List)var18);
         ItemStack[] var10003 = new ItemStack[1];
         Intrinsics.checkExpressionValueIsNotNull(crystal, "crystal");
         var10003[0] = crystal;
         List var16 = var15.add(new NbtAwareIngredient(var10003)).add(Ingredient.func_193369_a(new ItemStack[]{fabric})).build();
         if (var16 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
         }

         NonNullList fabrico = (NonNullList)var16;
         ItemInfusedSlime.Companion var17 = ItemInfusedSlime.Companion;
         Intrinsics.checkExpressionValueIsNotNull(aspect, "aspect");
         Item var19 = it.func_77973_b();
         Intrinsics.checkExpressionValueIsNotNull(var19, "it.item");
         ItemStack fabricitem = var17.createSlimeFor(aspect, var19);
         ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("thaumic_arcana", "slime_infuse_" + aspect.getTag()), (IArcaneRecipe)(new ShapelessArcaneRecipe(this.defaultGroup, "TA_SLIME_INFUSION", 5, (new AspectList()).add(Aspect.WATER, 1), fabricitem, fabrico.toArray())));
      }

      ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("thaumic_arcana", "infuse_tool"), new InfuseSlimiumTool());
   }

   private final void initSouls() {
      ArcaneCraftingRecipes $receiver = this;
      NonNullList var10002 = NonNullList.func_191196_a();
      Intrinsics.checkExpressionValueIsNotNull(var10002, "NonNullList.create<Ingredient>()");
      ListBuilder var10000 = (new ListBuilder((List)var10002)).add(Ingredient.field_193370_a);
      Item var10001 = Items.field_191525_da;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000 = var10000.add(Ingredient.func_193367_a(var10001)).add(Ingredient.field_193370_a);
      var10001 = Items.field_191525_da;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000 = var10000.add(Ingredient.func_193367_a(var10001)).add(Ingredient.field_193370_a);
      var10001 = Items.field_191525_da;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000 = var10000.add(Ingredient.func_193367_a(var10001)).add(Ingredient.field_193370_a);
      var10001 = Items.field_191525_da;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      List var12 = var10000.add(Ingredient.func_193367_a(var10001)).add(Ingredient.field_193370_a).build();
      if (var12 == null) {
         throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
      } else {
         NonNullList capsule = (NonNullList)var12;
         CraftingHelper.ShapedPrimer primer = new CraftingHelper.ShapedPrimer();
         primer.height = 3;
         primer.width = 3;
         primer.input = capsule;
         ResourceLocation var13 = new ResourceLocation("thaumic_arcana", "create_capsule");
         ShapedArcaneRecipe var20 = new ShapedArcaneRecipe;
         ResourceLocation var10003 = $receiver.defaultGroup;
         AspectList var10006 = (new AspectList()).add(Aspect.EARTH, 2);
         ItemStack var10007 = new ItemStack;
         Item var10009 = empty_soul_capsule;
         if (var10009 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("empty_soul_capsule");
         }

         var10007.<init>(var10009);
         var20.<init>(var10003, "TA_SOULS", 10, var10006, var10007, primer);
         ThaumcraftApi.addArcaneCraftingRecipe(var13, (IArcaneRecipe)var20);
         $receiver = this;
         var10002 = NonNullList.func_191196_a();
         Intrinsics.checkExpressionValueIsNotNull(var10002, "NonNullList.create<Ingredient>()");
         ListBuilder var14 = (new ListBuilder((List)var10002)).add(Ingredient.func_193369_a(new ItemStack[]{new ItemStack(ItemsTC.nuggets, 1, 6)})).add(Ingredient.func_193369_a(new ItemStack[]{new ItemStack(ItemsTC.jarBrace)})).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a);
         Item[] var21 = new Item[1];
         Item var10004 = soul_capsule;
         if (var10004 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("soul_capsule");
         }

         var21[0] = var10004;
         List var15 = var14.add(Ingredient.func_193368_a(var21)).add(Ingredient.field_193370_a).add(Ingredient.field_193370_a).add(Ingredient.func_193368_a(new Item[]{Items.field_151062_by})).add(Ingredient.func_193367_a(ItemsTC.mechanismComplex)).build();
         if (var15 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.NonNullList<net.minecraft.item.crafting.Ingredient>");
         } else {
            capsule = (NonNullList)var15;
            primer = new CraftingHelper.ShapedPrimer();
            primer.height = 3;
            primer.width = 3;
            primer.input = capsule;
            ResourceLocation var16 = new ResourceLocation("thaumic_arcana", "create_knowledge_infuser");
            ShapedArcaneRecipe var22 = new ShapedArcaneRecipe;
            var10003 = $receiver.defaultGroup;
            var10006 = (new AspectList()).add(Aspect.EARTH, 2);
            var10007 = new ItemStack;
            var10009 = experience_store;
            if (var10009 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("experience_store");
            }

            var10007.<init>(var10009);
            var22.<init>(var10003, "TA_EXPERIENCE_STORE", 30, var10006, var10007, primer);
            ThaumcraftApi.addArcaneCraftingRecipe(var16, (IArcaneRecipe)var22);
         }
      }
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getNeutered_flesh$cp() {
      Item var10000 = neutered_flesh;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("neutered_flesh");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getSlimeMeat$cp() {
      Item var10000 = slimeMeat;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("slimeMeat");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getIngot_livium$cp() {
      Item var10000 = ingot_livium;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getPickaxe_livium$cp() {
      Item var10000 = pickaxe_livium;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("pickaxe_livium");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getAxe_livium$cp() {
      Item var10000 = axe_livium;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("axe_livium");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getShovel_livium$cp() {
      Item var10000 = shovel_livium;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("shovel_livium");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getSword_livium$cp() {
      Item var10000 = sword_livium;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("sword_livium");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Block access$getArcane_sieve$cp() {
      Block var10000 = arcane_sieve;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("arcane_sieve");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getEmpty_soul_capsule$cp() {
      Item var10000 = empty_soul_capsule;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("empty_soul_capsule");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getSoul_capsule$cp() {
      Item var10000 = soul_capsule;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("soul_capsule");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getExperience_store$cp() {
      Item var10000 = experience_store;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("experience_store");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getPlank_greatwood$cp() {
      Item var10000 = plank_greatwood;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("plank_greatwood");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getStick$cp() {
      Item var10000 = stick;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("stick");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getSlime$cp() {
      Item var10000 = slime;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("slime");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getIron_ingot$cp() {
      Item var10000 = iron_ingot;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("iron_ingot");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getPickaxe_slime$cp() {
      Item var10000 = pickaxe_slime;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("pickaxe_slime");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getAxe_slime$cp() {
      Item var10000 = axe_slime;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("axe_slime");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getShovel_slime$cp() {
      Item var10000 = shovel_slime;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("shovel_slime");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getSword_slime$cp() {
      Item var10000 = sword_slime;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("sword_slime");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getHoe_slime$cp() {
      Item var10000 = hoe_slime;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("hoe_slime");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getInfused_slime$cp() {
      Item var10000 = infused_slime;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infused_slime");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\bS\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R \u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001e\u0010'\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001e\u00100\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001e\u00103\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011R\u001e\u00106\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010\u0011R\u001e\u00109\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R\u001e\u0010<\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000f\"\u0004\b>\u0010\u0011R\u001e\u0010?\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011R\u001e\u0010B\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u000f\"\u0004\bD\u0010\u0011R \u0010E\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u000f\"\u0004\bG\u0010\u0011R\u001e\u0010H\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u000f\"\u0004\bJ\u0010\u0011R\u001e\u0010K\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u000f\"\u0004\bM\u0010\u0011R\u001e\u0010N\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000f\"\u0004\bP\u0010\u0011R\u001e\u0010Q\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u000f\"\u0004\bS\u0010\u0011R\u001e\u0010T\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u000f\"\u0004\bV\u0010\u0011R\u001e\u0010W\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u000f\"\u0004\bY\u0010\u0011R\u001e\u0010Z\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u000f\"\u0004\b\\\u0010\u0011R\u001e\u0010]\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u000f\"\u0004\b_\u0010\u0011¨\u0006`"},
      d2 = {"Lhu/frontrider/arcana/registrationhandlers/recipes/ArcaneCraftingRecipes$Companion;", "", "()V", "arcane_sieve", "Lnet/minecraft/block/Block;", "getArcane_sieve", "()Lnet/minecraft/block/Block;", "setArcane_sieve", "(Lnet/minecraft/block/Block;)V", "arcane_stone", "getArcane_stone", "setArcane_stone", "axe_livium", "Lnet/minecraft/item/Item;", "getAxe_livium", "()Lnet/minecraft/item/Item;", "setAxe_livium", "(Lnet/minecraft/item/Item;)V", "axe_slime", "getAxe_slime", "setAxe_slime", "bottle", "getBottle", "setBottle", "bowl", "getBowl", "setBowl", "disable_enchants", "getDisable_enchants", "setDisable_enchants", "empty_soul_capsule", "getEmpty_soul_capsule", "setEmpty_soul_capsule", "enable_enchants", "getEnable_enchants", "setEnable_enchants", "enchanter", "getEnchanter", "setEnchanter", "experience_store", "getExperience_store", "setExperience_store", "experiment_table", "getExperiment_table", "setExperiment_table", "hoe_slime", "getHoe_slime", "setHoe_slime", "infused_slime", "getInfused_slime", "setInfused_slime", "ingot_livium", "getIngot_livium", "setIngot_livium", "iron_ingot", "getIron_ingot", "setIron_ingot", "neutered_flesh", "getNeutered_flesh", "setNeutered_flesh", "pickaxe_livium", "getPickaxe_livium", "setPickaxe_livium", "pickaxe_slime", "getPickaxe_slime", "setPickaxe_slime", "plank_greatwood", "getPlank_greatwood", "setPlank_greatwood", "sal_mundi", "getSal_mundi", "setSal_mundi", "shovel_livium", "getShovel_livium", "setShovel_livium", "shovel_slime", "getShovel_slime", "setShovel_slime", "slime", "getSlime", "setSlime", "slimeMeat", "getSlimeMeat", "setSlimeMeat", "soul_capsule", "getSoul_capsule", "setSoul_capsule", "stick", "getStick", "setStick", "sword_livium", "getSword_livium", "setSword_livium", "sword_slime", "getSword_slime", "setSword_slime", "Thaumic Arcana"}
   )
   public static final class Companion {
      @Nullable
      public final Block getExperiment_table() {
         return ArcaneCraftingRecipes.experiment_table;
      }

      public final void setExperiment_table(@Nullable Block var1) {
         ArcaneCraftingRecipes.experiment_table = var1;
      }

      @Nullable
      public final Item getEnchanter() {
         return ArcaneCraftingRecipes.enchanter;
      }

      public final void setEnchanter(@Nullable Item var1) {
         ArcaneCraftingRecipes.enchanter = var1;
      }

      @NotNull
      public final Item getNeutered_flesh() {
         return ArcaneCraftingRecipes.access$getNeutered_flesh$cp();
      }

      public final void setNeutered_flesh(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.neutered_flesh = var1;
      }

      @NotNull
      public final Item getSlimeMeat() {
         return ArcaneCraftingRecipes.access$getSlimeMeat$cp();
      }

      public final void setSlimeMeat(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.slimeMeat = var1;
      }

      @NotNull
      public final Item getIngot_livium() {
         return ArcaneCraftingRecipes.access$getIngot_livium$cp();
      }

      public final void setIngot_livium(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.ingot_livium = var1;
      }

      @NotNull
      public final Item getPickaxe_livium() {
         return ArcaneCraftingRecipes.access$getPickaxe_livium$cp();
      }

      public final void setPickaxe_livium(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.pickaxe_livium = var1;
      }

      @NotNull
      public final Item getAxe_livium() {
         return ArcaneCraftingRecipes.access$getAxe_livium$cp();
      }

      public final void setAxe_livium(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.axe_livium = var1;
      }

      @NotNull
      public final Item getShovel_livium() {
         return ArcaneCraftingRecipes.access$getShovel_livium$cp();
      }

      public final void setShovel_livium(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.shovel_livium = var1;
      }

      @NotNull
      public final Item getSword_livium() {
         return ArcaneCraftingRecipes.access$getSword_livium$cp();
      }

      public final void setSword_livium(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.sword_livium = var1;
      }

      @Nullable
      public final Block getDisable_enchants() {
         return ArcaneCraftingRecipes.disable_enchants;
      }

      public final void setDisable_enchants(@Nullable Block var1) {
         ArcaneCraftingRecipes.disable_enchants = var1;
      }

      @Nullable
      public final Block getEnable_enchants() {
         return ArcaneCraftingRecipes.enable_enchants;
      }

      public final void setEnable_enchants(@Nullable Block var1) {
         ArcaneCraftingRecipes.enable_enchants = var1;
      }

      @Nullable
      public final Block getArcane_stone() {
         return ArcaneCraftingRecipes.arcane_stone;
      }

      public final void setArcane_stone(@Nullable Block var1) {
         ArcaneCraftingRecipes.arcane_stone = var1;
      }

      @NotNull
      public final Block getArcane_sieve() {
         return ArcaneCraftingRecipes.access$getArcane_sieve$cp();
      }

      public final void setArcane_sieve(@NotNull Block var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.arcane_sieve = var1;
      }

      @NotNull
      public final Item getEmpty_soul_capsule() {
         return ArcaneCraftingRecipes.access$getEmpty_soul_capsule$cp();
      }

      public final void setEmpty_soul_capsule(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.empty_soul_capsule = var1;
      }

      @NotNull
      public final Item getSoul_capsule() {
         return ArcaneCraftingRecipes.access$getSoul_capsule$cp();
      }

      public final void setSoul_capsule(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.soul_capsule = var1;
      }

      @NotNull
      public final Item getExperience_store() {
         return ArcaneCraftingRecipes.access$getExperience_store$cp();
      }

      public final void setExperience_store(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.experience_store = var1;
      }

      @Nullable
      public final Item getSal_mundi() {
         return ArcaneCraftingRecipes.sal_mundi;
      }

      public final void setSal_mundi(@Nullable Item var1) {
         ArcaneCraftingRecipes.sal_mundi = var1;
      }

      @NotNull
      public final Item getPlank_greatwood() {
         return ArcaneCraftingRecipes.access$getPlank_greatwood$cp();
      }

      public final void setPlank_greatwood(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.plank_greatwood = var1;
      }

      @Nullable
      public final Item getBowl() {
         return ArcaneCraftingRecipes.bowl;
      }

      public final void setBowl(@Nullable Item var1) {
         ArcaneCraftingRecipes.bowl = var1;
      }

      @Nullable
      public final Item getBottle() {
         return ArcaneCraftingRecipes.bottle;
      }

      public final void setBottle(@Nullable Item var1) {
         ArcaneCraftingRecipes.bottle = var1;
      }

      @NotNull
      public final Item getStick() {
         return ArcaneCraftingRecipes.access$getStick$cp();
      }

      public final void setStick(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.stick = var1;
      }

      @NotNull
      public final Item getSlime() {
         return ArcaneCraftingRecipes.access$getSlime$cp();
      }

      public final void setSlime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.slime = var1;
      }

      @NotNull
      public final Item getIron_ingot() {
         return ArcaneCraftingRecipes.access$getIron_ingot$cp();
      }

      public final void setIron_ingot(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.iron_ingot = var1;
      }

      @NotNull
      public final Item getPickaxe_slime() {
         return ArcaneCraftingRecipes.access$getPickaxe_slime$cp();
      }

      public final void setPickaxe_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.pickaxe_slime = var1;
      }

      @NotNull
      public final Item getAxe_slime() {
         return ArcaneCraftingRecipes.access$getAxe_slime$cp();
      }

      public final void setAxe_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.axe_slime = var1;
      }

      @NotNull
      public final Item getShovel_slime() {
         return ArcaneCraftingRecipes.access$getShovel_slime$cp();
      }

      public final void setShovel_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.shovel_slime = var1;
      }

      @NotNull
      public final Item getSword_slime() {
         return ArcaneCraftingRecipes.access$getSword_slime$cp();
      }

      public final void setSword_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.sword_slime = var1;
      }

      @NotNull
      public final Item getHoe_slime() {
         return ArcaneCraftingRecipes.access$getHoe_slime$cp();
      }

      public final void setHoe_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.hoe_slime = var1;
      }

      @NotNull
      public final Item getInfused_slime() {
         return ArcaneCraftingRecipes.access$getInfused_slime$cp();
      }

      public final void setInfused_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ArcaneCraftingRecipes.infused_slime = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

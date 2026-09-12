package hu.frontrider.arcana.registrationhandlers.recipes;

import hu.frontrider.arcana.TAConfig;
import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EnchantingBaseCircle;
import hu.frontrider.arcana.items.CreatureEnchanter;
import hu.frontrider.arcana.items.EnchantModifierDust;
import hu.frontrider.arcana.items.EnchantmentUpgradePowder;
import hu.frontrider.arcana.items.ItemInfusedSlime;
import hu.frontrider.arcana.items.ItemPlantBall;
import hu.frontrider.arcana.registrationhandlers.ItemRegistry;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004¨\u0006\u0011"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/recipes/AlchemyRecipes;", "", "()V", "initEnchanting", "", "initFertilizer", "initGrowingAdvanced", "initGrowingBasic", "initGrowingFlesh", "initHardenFleshToLeather", "initMetalTransmutation", "initPlantExperiments", "initPlantProducts", "initSlime", "initSouls", "register", "Companion", "Thaumic Arcana"}
)
public final class AlchemyRecipes {
   @ObjectHolder("thaumic_arcana:magic_oak_sapling")
   @NotNull
   public static Block magic_oak_sapling;
   @ObjectHolder("thaumic_arcana:silver_oak_sapling")
   @NotNull
   public static Block silver_oak_sapling;
   @ObjectHolder("thaumic_arcana:tainted_oak_sapling")
   @NotNull
   public static Block tainted_oak_sapling;
   @ObjectHolder("thaumic_arcana:enchant_modifier")
   @NotNull
   public static Item modifier;
   @ObjectHolder("thaumic_arcana:nutrient_mix")
   @NotNull
   public static Item nutrientMix;
   @ObjectHolder("thaumic_arcana:empty_soul_capsule")
   @NotNull
   public static Item empty_soul_capsule;
   @ObjectHolder("thaumic_arcana:soul_capsule")
   @NotNull
   public static Item soul_capsule;
   @ObjectHolder("thaumic_arcana:infused_slime")
   @NotNull
   public static Item infused_slime;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public final void register() {
      this.initMetalTransmutation();
      this.initGrowingBasic();
      this.initFertilizer();
      this.initHardenFleshToLeather();
      this.initGrowingAdvanced();
      this.initGrowingFlesh();
      this.initPlantProducts();
      this.initEnchanting();
      this.initPlantExperiments();
      this.initSlime();
      this.initSouls();
   }

   private final void initMetalTransmutation() {
      AlchemyRecipes $receiver = this;
      CrucibleRecipe recipe = new CrucibleRecipe("METAL_TRANSMUTATION", new ItemStack(Items.field_151074_bl, 1, 0), "nuggetIron", (new AspectList()).add(Aspect.DESIRE, 1));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "transmutation_gold"), recipe);
      if (OreDictionary.doesOreNameExist("ingotCopper")) {
         NonNullList copper = OreDictionary.getOres("nuggetCopper");
         if (copper.size() > 0) {
            Object var10000 = copper.get(0);
            Intrinsics.checkExpressionValueIsNotNull(var10000, "copper[0]");
            ItemStack itemStack = (ItemStack)var10000;
            itemStack.func_190920_e(1);
            recipe = new CrucibleRecipe("METAL_TRANSMUTATION", itemStack, "nuggetIron", (new AspectList()).add(Aspect.EXCHANGE, 1));
            ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "transmutation_copper"), recipe);
         }
      }

      if (OreDictionary.doesOreNameExist("ingotLead")) {
         NonNullList lead = OreDictionary.getOres("nuggetLead");
         if (lead.size() > 0) {
            Object var22 = lead.get(0);
            Intrinsics.checkExpressionValueIsNotNull(var22, "lead[0]");
            ItemStack itemStack = (ItemStack)var22;
            itemStack.func_190920_e(1);
            recipe = new CrucibleRecipe("METAL_TRANSMUTATION", itemStack, "nuggetIron", (new AspectList()).add(Aspect.ORDER, 1));
            ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "transmutation_lead"), recipe);
         }
      }

      if (OreDictionary.doesOreNameExist("ingotSilver")) {
         NonNullList silver = OreDictionary.getOres("nuggetSilver");
         if (silver.size() > 0) {
            Object var23 = silver.get(0);
            Intrinsics.checkExpressionValueIsNotNull(var23, "silver[0]");
            ItemStack itemStack = (ItemStack)var23;
            itemStack.func_190920_e(1);
            recipe = new CrucibleRecipe("METAL_TRANSMUTATION", itemStack, "nuggetIron", (new AspectList()).add(Aspect.METAL, 1));
            ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "transmutation_silver"), recipe);
         }
      }

      if (OreDictionary.doesOreNameExist("ingotNickel")) {
         NonNullList nickel = OreDictionary.getOres("nuggetNickel");
         if (nickel.size() > 0) {
            Object var24 = nickel.get(0);
            Intrinsics.checkExpressionValueIsNotNull(var24, "nickel[0]");
            ItemStack itemStack = (ItemStack)var24;
            itemStack.func_190920_e(1);
            recipe = new CrucibleRecipe("METAL_TRANSMUTATION", itemStack, "nuggetIron", (new AspectList()).add(Aspect.ALCHEMY, 1));
            ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "transmutation_nickel"), recipe);
         }
      }

      if (TAConfig.enablePlatinum && OreDictionary.doesOreNameExist("ingotPlatinum")) {
         NonNullList platinum = OreDictionary.getOres("nuggetPlatinum");
         if (platinum.size() > 0) {
            Object var25 = platinum.get(0);
            Intrinsics.checkExpressionValueIsNotNull(var25, "platinum[0]");
            ItemStack itemStack = (ItemStack)var25;
            itemStack.func_190920_e(1);
            recipe = new CrucibleRecipe("METAL_TRANSMUTATION", itemStack, "nuggetIron", (new AspectList()).add(Aspect.CRYSTAL, 1).merge(Aspect.DESIRE, 5));
            ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "transmutation_platinum"), recipe);
         }
      }

      if (OreDictionary.doesOreNameExist("ingotTin")) {
         NonNullList tin = OreDictionary.getOres("nuggetTin");
         if (tin.size() > 0) {
            Object var26 = tin.get(0);
            Intrinsics.checkExpressionValueIsNotNull(var26, "tin[0]");
            ItemStack itemStack = (ItemStack)var26;
            itemStack.func_190920_e(1);
            recipe = new CrucibleRecipe("METAL_TRANSMUTATION", itemStack, "nuggetIron", (new AspectList()).add(Aspect.CRYSTAL, 1));
            ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "transmutation_tin"), recipe);
         }
      }

   }

   private final void initGrowingBasic() {
      String KEY = "PLANT_GROWTH";
      AlchemyRecipes $receiver = this;
      CrucibleRecipe recipe = new CrucibleRecipe(KEY, new ItemStack(Items.field_151015_O, 1), new ItemStack(Items.field_151014_N), (new AspectList()).add(Aspect.LIGHT, 2).merge(Aspect.EARTH, 2).merge(Aspect.WATER, 2));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "grow_wheat"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe(KEY, new ItemStack(Items.field_151172_bF, 2), new ItemStack(Items.field_151172_bF), (new AspectList()).add(Aspect.LIGHT, 2).merge(Aspect.EARTH, 2).merge(Aspect.WATER, 2));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "grow_carrot"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe(KEY, new ItemStack(Items.field_151174_bG, 2), new ItemStack(Items.field_151174_bG), (new AspectList()).add(Aspect.LIGHT, 2).merge(Aspect.EARTH, 2).merge(Aspect.WATER, 2));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "grow_potato"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe(KEY, new ItemStack(Items.field_185164_cV, 1), new ItemStack(Items.field_185163_cU), (new AspectList()).add(Aspect.LIGHT, 2).merge(Aspect.EARTH, 2).merge(Aspect.WATER, 2));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "grow_beetroot"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe(KEY, new ItemStack(Items.field_151120_aE, 3), new ItemStack(Items.field_151120_aE), (new AspectList()).add(Aspect.LIGHT, 2).merge(Aspect.EARTH, 2).merge(Aspect.WATER, 3));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "grow_reeds"), recipe);
      $receiver = this;
      Item object = (Item)Item.field_150901_e.func_82594_a(new ResourceLocation("minecraft:melon"));
      CrucibleRecipe var10000 = new CrucibleRecipe;
      ItemStack var10003 = new ItemStack;
      if (object == null) {
         Intrinsics.throwNpe();
      }

      var10003.<init>(object, 1);
      var10000.<init>(KEY, var10003, new ItemStack(Items.field_151081_bc), (new AspectList()).add(Aspect.LIGHT, 3).merge(Aspect.EARTH, 3).merge(Aspect.WATER, 3));
      CrucibleRecipe recipe = var10000;
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "grow_melon"), recipe);
      $receiver = this;
      object = (Item)Item.field_150901_e.func_82594_a(new ResourceLocation("minecraft:pumpkin"));
      var10000 = new CrucibleRecipe;
      var10003 = new ItemStack;
      if (object == null) {
         Intrinsics.throwNpe();
      }

      var10003.<init>(object, 1);
      var10000.<init>(KEY, var10003, new ItemStack(Items.field_151080_bb), (new AspectList()).add(Aspect.LIGHT, 3).merge(Aspect.EARTH, 3).merge(Aspect.WATER, 3));
      recipe = var10000;
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "grow_beetroot"), recipe);
   }

   private final void initGrowingAdvanced() {
      String KEY = "PLANT_GROWTH_ADVANCED";
      List var10000 = ItemPlantBall.Companion.getTreeItems();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      List treeItems = var10000;
      int index = 0;

      for(ItemStack treeItem : treeItems) {
         ItemStack seedItem = ItemPlantBall.Companion.getProductByIndex(treeItem, 0);
         CrucibleRecipe recipe = new CrucibleRecipe(KEY, treeItem, new ItemStack(seedItem.func_77973_b(), 1, seedItem.func_77960_j()), (new AspectList()).add(Aspect.LIGHT, 5).merge(Aspect.EARTH, 10).merge(Aspect.WATER, 12).merge(Aspect.VOID, 5));
         ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "tree_" + index), recipe);
         ++index;
      }

      var10000 = ItemPlantBall.Companion.getSeedItems();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      List seedItems = var10000;
      index = 0;

      for(ItemStack seedlingItem : seedItems) {
         ItemStack seedItem = ItemPlantBall.Companion.getProductByIndex(seedlingItem, 0);
         CrucibleRecipe recipe = new CrucibleRecipe(KEY, seedlingItem, new ItemStack(seedItem.func_77973_b(), 1, seedItem.func_77960_j()), (new AspectList()).add(Aspect.LIGHT, 5).merge(Aspect.EARTH, 10).merge(Aspect.WATER, 12).merge(Aspect.VOID, 5));
         ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "seed_1" + index), recipe);
         ++index;
      }

   }

   private final void initGrowingFlesh() {
      String KEY = "FLESH_GROWTH";
      AlchemyRecipes $receiver = this;
      CrucibleRecipe recipe = new CrucibleRecipe(KEY, new ItemStack(Items.field_151082_bd, 2), new ItemStack(Items.field_151082_bd), (new AspectList()).add(Aspect.LIFE, 10));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "grow_beef"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe(KEY, new ItemStack(Items.field_179561_bm, 2), new ItemStack(Items.field_179561_bm), (new AspectList()).add(Aspect.LIFE, 10));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "grow_mutton"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe(KEY, new ItemStack(Items.field_151147_al, 2), new ItemStack(Items.field_151147_al), (new AspectList()).add(Aspect.LIFE, 10));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "grow_pork"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe(KEY, new ItemStack(Items.field_151076_bf, 2), new ItemStack(Items.field_151076_bf), (new AspectList()).add(Aspect.LIFE, 10));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "grow_chicken"), recipe);
      $receiver = this;
      CrucibleRecipe var10000 = new CrucibleRecipe;
      ItemStack var10003 = new ItemStack;
      Item var10005 = nutrientMix;
      if (var10005 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("nutrientMix");
      }

      var10003.<init>(var10005);
      var10000.<init>(KEY, var10003, new ItemStack(Items.field_151102_aT), (new AspectList()).add(Aspect.LIFE, 3).add(Aspect.PLANT, 2).add(Aspect.MAGIC, 2));
      recipe = var10000;
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "nutrient_mix"), recipe);
   }

   private final void initHardenFleshToLeather() {
      AlchemyRecipes $receiver = this;
      CrucibleRecipe recipe = new CrucibleRecipe("FLESH_TO_LEATHER", new ItemStack(Items.field_151116_aA, 1), new ItemStack(Items.field_151082_bd), (new AspectList()).add(Aspect.EXCHANGE, 1).merge(Aspect.CRAFT, 1));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "beef_to_leather"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe("FLESH_TO_LEATHER", new ItemStack(Items.field_151116_aA, 1), new ItemStack(Items.field_151147_al), (new AspectList()).add(Aspect.EXCHANGE, 1).merge(Aspect.CRAFT, 1));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "pork_to_leather"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe("FLESH_TO_LEATHER", new ItemStack(Items.field_151116_aA, 1), new ItemStack(Items.field_179561_bm), (new AspectList()).add(Aspect.EXCHANGE, 1).merge(Aspect.CRAFT, 1));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "mutton_to_leather"), recipe);
   }

   private final void initFertilizer() {
      AlchemyRecipes $receiver = this;
      CrucibleRecipe recipe = new CrucibleRecipe("ARCANE_FERTILIZER", new ItemStack(ItemRegistry.Companion.getFertiliser(), 16), ThaumcraftApiHelper.makeCrystal(Aspect.PLANT, 1), (new AspectList()).add(Aspect.LIGHT, 4).merge(Aspect.EARTH, 4).merge(Aspect.WATER, 4).merge(Aspect.CRAFT, 4).add(Aspect.PLANT, 10));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "fertilizer_recipe"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe("INCUBATED_EGG", new ItemStack(ItemRegistry.Companion.getIncubated_egg(), 1), new ItemStack(Items.field_151110_aK), (new AspectList()).add(Aspect.FIRE, 2).merge(Aspect.LIFE, 2));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "incubated_egg_recipe"), recipe);
   }

   private final void initPlantProducts() {
      AlchemyRecipes $receiver = this;
      CrucibleRecipe recipe = new CrucibleRecipe("PLANT_PRODUCTS", new ItemStack(Items.field_151121_aF, 16, 0), "logWood", (new AspectList()).add(Aspect.WATER, 1).add(Aspect.ENTROPY, 1).add(Aspect.ORDER, 1));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "paper"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe("PLANT_PRODUCTS", new ItemStack(Items.field_151100_aR, 2, 1), new ItemStack(Items.field_151100_aR, 1, 1), (new AspectList()).add(Aspect.WATER, 1).add(Aspect.LIGHT, 1).add(Aspect.EARTH, 1).add(Aspect.LIFE, 1));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "dye_red"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe("PLANT_PRODUCTS", new ItemStack(Items.field_151100_aR, 2, 2), new ItemStack(Items.field_151100_aR, 1, 2), (new AspectList()).add(Aspect.WATER, 1).add(Aspect.LIGHT, 1).add(Aspect.EARTH, 1).add(Aspect.LIFE, 1));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "dye_green"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe("PLANT_PRODUCTS", new ItemStack(Items.field_151100_aR, 2, 11), new ItemStack(Items.field_151100_aR, 1, 11), (new AspectList()).add(Aspect.WATER, 1).add(Aspect.LIGHT, 1).add(Aspect.EARTH, 1).add(Aspect.LIFE, 1));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "dye_yellow"), recipe);
   }

   private final void initEnchanting() {
      AlchemyRecipes $receiver = this;
      CrucibleRecipe recipe = new CrucibleRecipe("CREATURE_ENCHANT", new ItemStack(ItemRegistry.Companion.getEnchanting_powder_basic(), 1, 0), new ItemStack(Items.field_151100_aR, 1, 4), (new AspectList()).add(Aspect.MAGIC, 10).add(Aspect.ENTROPY, 3).add(Aspect.ORDER, 3));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "enchant_powder_basic"), recipe);
      $receiver = this;
      IForgeRegistry registry = GameRegistry.findRegistry(CreatureEnchant.class);

      for(Item it : new Item[]{ItemRegistry.Companion.getEnchanting_powder_basic(), ItemRegistry.Companion.getEnchanting_powder_advanced(), ItemRegistry.Companion.getEnchanting_powder_magical()}) {
         Intrinsics.checkExpressionValueIsNotNull(registry, "registry");

         for(CreatureEnchant enchant : registry.getValuesCollection()) {
            CreatureEnchanter.Companion var10000 = CreatureEnchanter.Companion;
            CreatureEnchanter.EnchantmentData[] var10002 = new CreatureEnchanter.EnchantmentData[1];
            CreatureEnchanter.EnchantmentData var10005 = new CreatureEnchanter.EnchantmentData;
            Intrinsics.checkExpressionValueIsNotNull(enchant, "enchant");
            if (it == null) {
               throw new TypeCastException("null cannot be cast to non-null type hu.frontrider.arcana.items.EnchantmentUpgradePowder");
            }

            var10005.<init>(enchant, ((EnchantmentUpgradePowder)it).getLevel());
            var10002[0] = var10005;
            ItemStack enchantedItem = var10000.createEnchantedItem(it, var10002);
            CrucibleRecipe recipe = new CrucibleRecipe(enchant.getResearch(), enchantedItem, new ItemStack(it), enchant.formula().merge(Aspect.ENERGY, ((EnchantmentUpgradePowder)it).getLevel() * 10));
            ResourceLocation var21 = new ResourceLocation;
            StringBuilder var10003 = new StringBuilder();
            ResourceLocation var10004 = enchant.getRegistryName();
            if (var10004 == null) {
               Intrinsics.throwNpe();
            }

            Intrinsics.checkExpressionValueIsNotNull(var10004, "enchant.registryName!!");
            var10003 = var10003.append(var10004.func_110623_a()).append("_");
            var10004 = ((EnchantmentUpgradePowder)it).getRegistryName();
            if (var10004 == null) {
               Intrinsics.throwNpe();
            }

            Intrinsics.checkExpressionValueIsNotNull(var10004, "it.registryName!!");
            var21.<init>("thaumic_arcana", var10003.append(var10004.func_110623_a()).toString());
            ThaumcraftApi.addCrucibleRecipe(var21, recipe);
         }
      }

      $receiver = this;
      registry = GameRegistry.findRegistry(EnchantingBaseCircle.class);
      Intrinsics.checkExpressionValueIsNotNull(registry, "registry");

      for(EnchantingBaseCircle enchant : registry.getValuesCollection()) {
         EnchantModifierDust.Companion var22 = EnchantModifierDust.Companion;
         Item var10001 = modifier;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modifier");
         }

         Intrinsics.checkExpressionValueIsNotNull(enchant, "enchant");
         ItemStack enchantedItem = var22.createItem(var10001, enchant);
         CrucibleRecipe var23 = new CrucibleRecipe;
         String var25 = enchant.getResearch();
         ItemStack var29 = new ItemStack;
         Item var10006 = modifier;
         if (var10006 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modifier");
         }

         var29.<init>(var10006);
         var23.<init>(var25, enchantedItem, var29, enchant.getFormula());
         CrucibleRecipe recipe = var23;
         ResourceLocation var24 = new ResourceLocation;
         StringBuilder var27 = (new StringBuilder()).append("ce_circle_");
         ResourceLocation var30 = enchant.getRegistryName();
         if (var30 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var30, "enchant.registryName!!");
         var24.<init>("thaumic_arcana", var27.append(var30.func_110623_a()).toString());
         ThaumcraftApi.addCrucibleRecipe(var24, recipe);
      }

   }

   private final void initPlantExperiments() {
      String KEY = "PLANT_EXPERIMENTS";
      AlchemyRecipes $receiver = this;
      CrucibleRecipe var10000 = new CrucibleRecipe;
      ItemStack var10003 = new ItemStack;
      Block var10005 = magic_oak_sapling;
      if (var10005 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("magic_oak_sapling");
      }

      var10003.<init>(var10005, 1, 0);
      var10000.<init>(KEY, var10003, new ItemStack(Blocks.field_150345_g, 1, 0), (new AspectList()).add(Aspect.LIGHT, 2).merge(Aspect.EARTH, 2).merge(Aspect.WATER, 2).merge(Aspect.MAGIC, 20));
      CrucibleRecipe recipe = var10000;
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "great_oak_wood"), recipe);
      $receiver = this;
      var10000 = new CrucibleRecipe;
      var10003 = new ItemStack;
      var10005 = silver_oak_sapling;
      if (var10005 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("silver_oak_sapling");
      }

      var10003.<init>(var10005, 1, 0);
      var10000.<init>(KEY, var10003, new ItemStack(Blocks.field_150345_g, 1, 0), (new AspectList()).add(Aspect.LIGHT, 2).merge(Aspect.EARTH, 2).merge(Aspect.WATER, 2).merge(Aspect.AURA, 20));
      recipe = var10000;
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "silver_oak_wood"), recipe);
      $receiver = this;
      var10000 = new CrucibleRecipe;
      var10003 = new ItemStack;
      var10005 = tainted_oak_sapling;
      if (var10005 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("tainted_oak_sapling");
      }

      var10003.<init>(var10005, 1, 0);
      var10000.<init>(KEY, var10003, new ItemStack(Blocks.field_150345_g, 1, 0), (new AspectList()).add(Aspect.LIGHT, 2).merge(Aspect.EARTH, 2).merge(Aspect.WATER, 2).merge(Aspect.FLUX, 20).merge(Aspect.LIFE, 30));
      recipe = var10000;
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "tainted_oak_wood"), recipe);
   }

   private final void initSlime() {
      AlchemyRecipes $receiver = this;
      CrucibleRecipe recipe = new CrucibleRecipe("TA_SLIME@4", new ItemStack(Items.field_151064_bs, 4), Blocks.field_189877_df, (new AspectList()).add(Aspect.ENTROPY, 4).add(Aspect.FIRE, 2));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "magma_to_cream"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe("TA_SLIME@4", new ItemStack(Items.field_151123_aH, 1), Items.field_151064_bs, (new AspectList()).add(Aspect.CRAFT, 2).add(Aspect.WATER, 2));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "cream_to_slime"), recipe);
      $receiver = this;
      recipe = new CrucibleRecipe("TA_SLIME@4", new ItemStack(Items.field_151065_br, 1), Items.field_151064_bs, (new AspectList()).add(Aspect.CRAFT, 2).add(Aspect.FIRE, 2));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "cream_to_powder"), recipe);
      $receiver = this;
      NBTTagCompound entityTag = new NBTTagCompound();
      entityTag.func_74778_a("id", "minecraft:slime");
      ItemStack result = new ItemStack(Items.field_151063_bx, 1);
      NBTTagCompound compound = new NBTTagCompound();
      compound.func_74782_a("EntityTag", (NBTBase)entityTag);
      result.func_77982_d(compound);
      CrucibleRecipe recipe = new CrucibleRecipe("TA_SLIME_ANIMATION", result, Blocks.field_180399_cE, (new AspectList()).add(Aspect.LIFE, 5).add(Aspect.ORDER, 2));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "make_slime_spawner"), recipe);
      $receiver = this;
      entityTag = new NBTTagCompound();
      entityTag.func_74778_a("id", "minecraft:magma_cube");
      result = new ItemStack(Items.field_151063_bx, 1);
      compound = new NBTTagCompound();
      compound.func_74782_a("EntityTag", (NBTBase)entityTag);
      result.func_77982_d(compound);
      recipe = new CrucibleRecipe("TA_SLIME_ANIMATION", result, Blocks.field_180399_cE, (new AspectList()).add(Aspect.LIFE, 5).add(Aspect.ORDER, 2).add(Aspect.FIRE, 20));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "make_magma_slime_spawner"), recipe);
      $receiver = this;
      ItemInfusedSlime.Companion var10000 = ItemInfusedSlime.Companion;
      Aspect var10001 = Aspect.CRAFT;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Aspect.CRAFT");
      Item var10002 = infused_slime;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infused_slime");
      }

      ItemStack fabricitem = var10000.createSlimeFor(var10001, var10002);
      CrucibleRecipe recipe = new CrucibleRecipe("TA_SLIME_INFUSION", fabricitem, Items.field_151123_aH, (new AspectList()).add(Aspect.CRAFT, 5));
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "fabric_slime"), recipe);
   }

   public final void initSouls() {
      AlchemyRecipes $receiver = this;
      CrucibleRecipe var10000 = new CrucibleRecipe;
      ItemStack var10003 = new ItemStack;
      Item var10005 = soul_capsule;
      if (var10005 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("soul_capsule");
      }

      var10003.<init>(var10005);
      Item var10004 = empty_soul_capsule;
      if (var10004 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("empty_soul_capsule");
      }

      var10000.<init>("TA_SOULS", var10003, var10004, (new AspectList()).add(Aspect.SOUL, 60).add(Aspect.AIR, 10).add(Aspect.FIRE, 20));
      CrucibleRecipe recipe = var10000;
      ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("thaumic_arcana", "soul_capsule"), recipe);
   }

   // $FF: synthetic method
   @NotNull
   public static final Block access$getMagic_oak_sapling$cp() {
      Block var10000 = magic_oak_sapling;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("magic_oak_sapling");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Block access$getSilver_oak_sapling$cp() {
      Block var10000 = silver_oak_sapling;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("silver_oak_sapling");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Block access$getTainted_oak_sapling$cp() {
      Block var10000 = tainted_oak_sapling;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("tainted_oak_sapling");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getModifier$cp() {
      Item var10000 = modifier;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modifier");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getNutrientMix$cp() {
      Item var10000 = nutrientMix;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("nutrientMix");
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
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011¨\u0006!"},
      d2 = {"Lhu/frontrider/arcana/registrationhandlers/recipes/AlchemyRecipes$Companion;", "", "()V", "empty_soul_capsule", "Lnet/minecraft/item/Item;", "getEmpty_soul_capsule", "()Lnet/minecraft/item/Item;", "setEmpty_soul_capsule", "(Lnet/minecraft/item/Item;)V", "infused_slime", "getInfused_slime", "setInfused_slime", "magic_oak_sapling", "Lnet/minecraft/block/Block;", "getMagic_oak_sapling", "()Lnet/minecraft/block/Block;", "setMagic_oak_sapling", "(Lnet/minecraft/block/Block;)V", "modifier", "getModifier$Thaumic_Arcana", "setModifier$Thaumic_Arcana", "nutrientMix", "getNutrientMix$Thaumic_Arcana", "setNutrientMix$Thaumic_Arcana", "silver_oak_sapling", "getSilver_oak_sapling", "setSilver_oak_sapling", "soul_capsule", "getSoul_capsule", "setSoul_capsule", "tainted_oak_sapling", "getTainted_oak_sapling", "setTainted_oak_sapling", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final Block getMagic_oak_sapling() {
         return AlchemyRecipes.access$getMagic_oak_sapling$cp();
      }

      public final void setMagic_oak_sapling(@NotNull Block var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         AlchemyRecipes.magic_oak_sapling = var1;
      }

      @NotNull
      public final Block getSilver_oak_sapling() {
         return AlchemyRecipes.access$getSilver_oak_sapling$cp();
      }

      public final void setSilver_oak_sapling(@NotNull Block var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         AlchemyRecipes.silver_oak_sapling = var1;
      }

      @NotNull
      public final Block getTainted_oak_sapling() {
         return AlchemyRecipes.access$getTainted_oak_sapling$cp();
      }

      public final void setTainted_oak_sapling(@NotNull Block var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         AlchemyRecipes.tainted_oak_sapling = var1;
      }

      @NotNull
      public final Item getModifier$Thaumic_Arcana() {
         return AlchemyRecipes.access$getModifier$cp();
      }

      public final void setModifier$Thaumic_Arcana(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         AlchemyRecipes.modifier = var1;
      }

      @NotNull
      public final Item getNutrientMix$Thaumic_Arcana() {
         return AlchemyRecipes.access$getNutrientMix$cp();
      }

      public final void setNutrientMix$Thaumic_Arcana(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         AlchemyRecipes.nutrientMix = var1;
      }

      @NotNull
      public final Item getEmpty_soul_capsule() {
         return AlchemyRecipes.access$getEmpty_soul_capsule$cp();
      }

      public final void setEmpty_soul_capsule(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         AlchemyRecipes.empty_soul_capsule = var1;
      }

      @NotNull
      public final Item getSoul_capsule() {
         return AlchemyRecipes.access$getSoul_capsule$cp();
      }

      public final void setSoul_capsule(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         AlchemyRecipes.soul_capsule = var1;
      }

      @NotNull
      public final Item getInfused_slime() {
         return AlchemyRecipes.access$getInfused_slime$cp();
      }

      public final void setInfused_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         AlchemyRecipes.infused_slime = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

package hu.frontrider.arcana.registrationhandlers.recipes;

import hu.frontrider.arcana.registrationhandlers.ItemRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.items.ItemsTC;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004¨\u0006\u000b"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/recipes/InfusionRecipes;", "", "()V", "initInfusedSlimeArmor", "", "initInfusedSlimeTools", "initLivium", "initSouls", "register", "registerCreatureEnchants", "Companion", "Thaumic Arcana"}
)
public final class InfusionRecipes {
   @ObjectHolder("thaumic_arcana:enchant_modifier")
   @NotNull
   public static Item modifier;
   @ObjectHolder("thaumic_arcana:ingot_livium")
   @NotNull
   public static Item ingot_livium;
   @ObjectHolder("thaumic_arcana:neutered_flesh")
   @NotNull
   public static Item neutered_flesh;
   @ObjectHolder("thaumic_arcana:infused_slimy_pickaxe")
   @NotNull
   public static Item pickaxe_slime_infused;
   @ObjectHolder("thaumic_arcana:infused_slimy_axe")
   @NotNull
   public static Item axe_slime_infused;
   @ObjectHolder("thaumic_arcana:infused_slimy_shovel")
   @NotNull
   public static Item shovel_slime_infused;
   @ObjectHolder("thaumic_arcana:infused_slimy_sword")
   @NotNull
   public static Item sword_slime_infused;
   @ObjectHolder("thaumic_arcana:infused_slimy_hoe")
   @NotNull
   public static Item hoe_slime_infused;
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
   @ObjectHolder("thaumic_arcana:infused_slimy_chestplate")
   @NotNull
   public static Item infused_slimy_chestplate;
   @ObjectHolder("thaumic_arcana:infused_slimy_leggings")
   @NotNull
   public static Item infused_slimy_leggings;
   @ObjectHolder("thaumic_arcana:infused_slimy_helmet")
   @NotNull
   public static Item infused_slimy_helmet;
   @ObjectHolder("thaumic_arcana:infused_slime")
   @NotNull
   public static Item infused_slime;
   @ObjectHolder("thaumic_arcana:soul_capsule")
   @NotNull
   public static Item soul_capsule;
   @ObjectHolder("thaumic_arcana:revival_capsule")
   @NotNull
   public static Item revival_capsule;
   @ObjectHolder("thaumic_arcana:experience_store")
   @NotNull
   public static Item experience_store;
   @ObjectHolder("thaumic_arcana:mind_inhibitor")
   @NotNull
   public static Item mind_inhibitor;
   @ObjectHolder("thaumcraft:vishroom")
   @NotNull
   public static Item vishroom;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public final void register() {
      this.registerCreatureEnchants();
      this.initLivium();
      this.initInfusedSlimeTools();
      this.initInfusedSlimeArmor();
      this.initSouls();
   }

   public final void registerCreatureEnchants() {
      InfusionRecipes $receiver = this;
      ItemStack source = new ItemStack(ItemRegistry.Companion.getEnchanting_powder_basic());
      source.func_77982_d((NBTTagCompound)null);
      ItemStack itemStack = new ItemStack(ItemRegistry.Companion.getEnchanting_powder_advanced());
      ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("thaumic_arcana", "enchant_powder_advanced"), new InfusionRecipe("CREATURE_ENCHANT_ADVANCED", itemStack, 5, (new AspectList()).add(Aspect.MAGIC, 20).add(Aspect.LIFE, 50).add(Aspect.AURA, 20), source, new Object[]{new ItemStack(ItemsTC.salisMundus), new ItemStack(Items.field_151100_aR, 1, 4), new ItemStack(ItemsTC.salisMundus), new ItemStack(Items.field_151100_aR, 1, 4), new ItemStack(ItemsTC.salisMundus), new ItemStack(Items.field_151100_aR, 1, 4)}));
      $receiver = this;
      ItemStack var10000 = new ItemStack;
      Item var10002 = modifier;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modifier");
      }

      var10000.<init>(var10002);
      source = var10000;
      itemStack = new ItemStack(ItemRegistry.Companion.getEnchanting_powder_advanced());
      itemStack.func_77982_d((NBTTagCompound)null);
      ResourceLocation var9 = new ResourceLocation("thaumic_arcana", "enchant_modifier_base");
      InfusionRecipe var10001 = new InfusionRecipe;
      AspectList var10006 = (new AspectList()).add(Aspect.MAGIC, 20).add(Aspect.LIFE, 50).add(Aspect.AURA, 20).add(Aspect.BEAST, 100);
      Object[] var10008 = new Object[8];
      ItemStack var10011 = new ItemStack;
      Object var10013 = BlocksTC.nitor.get(EnumDyeColor.WHITE);
      if (var10013 == null) {
         Intrinsics.throwNpe();
      }

      var10011.<init>((Block)var10013);
      var10008[0] = var10011;
      var10011 = new ItemStack;
      var10013 = BlocksTC.nitor.get(EnumDyeColor.WHITE);
      if (var10013 == null) {
         Intrinsics.throwNpe();
      }

      var10011.<init>((Block)var10013);
      var10008[1] = var10011;
      var10011 = new ItemStack;
      var10013 = BlocksTC.nitor.get(EnumDyeColor.WHITE);
      if (var10013 == null) {
         Intrinsics.throwNpe();
      }

      var10011.<init>((Block)var10013);
      var10008[2] = var10011;
      var10011 = new ItemStack;
      var10013 = BlocksTC.nitor.get(EnumDyeColor.WHITE);
      if (var10013 == null) {
         Intrinsics.throwNpe();
      }

      var10011.<init>((Block)var10013);
      var10008[3] = var10011;
      var10008[4] = ThaumcraftApiHelper.makeCrystal(Aspect.ORDER);
      var10008[5] = ThaumcraftApiHelper.makeCrystal(Aspect.ORDER);
      var10008[6] = ThaumcraftApiHelper.makeCrystal(Aspect.MAGIC);
      var10008[7] = ThaumcraftApiHelper.makeCrystal(Aspect.MAGIC);
      var10001.<init>("ENCHANT_MODIFICATION", source, 5, var10006, itemStack, var10008);
      ThaumcraftApi.addInfusionCraftingRecipe(var9, var10001);
   }

   private final void initLivium() {
      InfusionRecipes $receiver = this;
      ItemStack var10000 = new ItemStack;
      Item var10002 = neutered_flesh;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("neutered_flesh");
      }

      var10000.<init>(var10002);
      ItemStack source = var10000;
      var10000 = new ItemStack;
      var10002 = ingot_livium;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
      }

      var10000.<init>(var10002);
      ItemStack itemStack = var10000;
      ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("thaumic_arcana", "create_livium"), new InfusionRecipe("LIVIUM", itemStack, 2, (new AspectList()).add(Aspect.METAL, 30).add(Aspect.LIFE, 50), source, new Object[]{new ItemStack(Items.field_151042_j), new ItemStack(Items.field_151042_j), new ItemStack(Items.field_151042_j)}));
   }

   private final void initInfusedSlimeTools() {
      <undefinedtype> createTool$ = null.INSTANCE;
      Item var10001 = axe_slime;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("axe_slime");
      }

      Item var10002 = axe_slime_infused;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("axe_slime_infused");
      }

      AspectList var10004 = (new AspectList()).merge(Aspect.METAL, 10);
      Intrinsics.checkExpressionValueIsNotNull(var10004, "AspectList().merge(Aspect.METAL, 10)");
      createTool$.invoke(var10001, var10002, "axe", var10004);
      var10001 = hoe_slime;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("hoe_slime");
      }

      var10002 = hoe_slime_infused;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("hoe_slime_infused");
      }

      var10004 = (new AspectList()).merge(Aspect.PLANT, 10);
      Intrinsics.checkExpressionValueIsNotNull(var10004, "AspectList().merge(Aspect.PLANT, 10)");
      createTool$.invoke(var10001, var10002, "hoe", var10004);
      var10001 = shovel_slime;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("shovel_slime");
      }

      var10002 = shovel_slime_infused;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("shovel_slime_infused");
      }

      var10004 = (new AspectList()).merge(Aspect.EARTH, 10);
      Intrinsics.checkExpressionValueIsNotNull(var10004, "AspectList().merge(Aspect.EARTH, 10)");
      createTool$.invoke(var10001, var10002, "shovel", var10004);
      var10001 = pickaxe_slime;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("pickaxe_slime");
      }

      var10002 = pickaxe_slime_infused;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("pickaxe_slime_infused");
      }

      var10004 = (new AspectList()).merge(Aspect.TOOL, 10);
      Intrinsics.checkExpressionValueIsNotNull(var10004, "AspectList().merge(Aspect.TOOL, 10)");
      createTool$.invoke(var10001, var10002, "pickaxe", var10004);
      var10001 = sword_slime;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("sword_slime");
      }

      var10002 = sword_slime_infused;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("sword_slime_infused");
      }

      var10004 = (new AspectList()).merge(Aspect.AVERSION, 10);
      Intrinsics.checkExpressionValueIsNotNull(var10004, "AspectList().merge(Aspect.AVERSION, 10)");
      createTool$.invoke(var10001, var10002, "sword", var10004);
   }

   private final void initInfusedSlimeArmor() {
      <undefinedtype> createArmor$ = null.INSTANCE;
      ItemArmor var10001 = Items.field_151161_ac;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Items.DIAMOND_HELMET");
      Item var2 = (Item)var10001;
      Item var10002 = infused_slimy_helmet;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infused_slimy_helmet");
      }

      createArmor$.invoke(var2, var10002, "helmet", new AspectList());
      ItemArmor var3 = Items.field_151163_ad;
      Intrinsics.checkExpressionValueIsNotNull(var3, "Items.DIAMOND_CHESTPLATE");
      Item var4 = (Item)var3;
      var10002 = infused_slimy_chestplate;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infused_slimy_chestplate");
      }

      createArmor$.invoke(var4, var10002, "chestplate", new AspectList());
      ItemArmor var5 = Items.field_151173_ae;
      Intrinsics.checkExpressionValueIsNotNull(var5, "Items.DIAMOND_LEGGINGS");
      Item var6 = (Item)var5;
      var10002 = infused_slimy_leggings;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infused_slimy_leggings");
      }

      createArmor$.invoke(var6, var10002, "leggings", new AspectList());
   }

   private final void initSouls() {
      InfusionRecipes $receiver = this;
      ItemStack var10000 = new ItemStack;
      Item var10002 = soul_capsule;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("soul_capsule");
      }

      var10000.<init>(var10002);
      ItemStack source = var10000;
      var10000 = new ItemStack;
      var10002 = revival_capsule;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("revival_capsule");
      }

      var10000.<init>(var10002);
      ItemStack itemStack = var10000;
      ResourceLocation var10 = new ResourceLocation("thaumic_arcana", "create_revival_capsule");
      InfusionRecipe var10001 = new InfusionRecipe;
      AspectList var10006 = (new AspectList()).add(Aspect.LIFE, 50).add(Aspect.MAGIC, 50).add(Aspect.TOOL, 10).add(Aspect.PROTECT, 120).add(Aspect.SOUL, 100);
      Object[] var10008 = new Object[]{new ItemStack(Items.field_151062_by), new ItemStack(ItemsTC.ingots), new ItemStack(Items.field_151073_bk), new ItemStack(Items.field_151043_k), null, null, null, null, null, null};
      ItemStack var10011 = new ItemStack;
      Item var10013 = ingot_livium;
      if (var10013 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
      }

      var10011.<init>(var10013);
      var10008[4] = var10011;
      var10008[5] = new ItemStack(Items.field_151062_by);
      var10008[6] = new ItemStack(ItemsTC.ingots);
      var10008[7] = new ItemStack(Items.field_151073_bk);
      var10008[8] = new ItemStack(Items.field_151043_k);
      var10011 = new ItemStack;
      var10013 = ingot_livium;
      if (var10013 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
      }

      var10011.<init>(var10013);
      var10008[9] = var10011;
      var10001.<init>("TA_REVIVAL_CAPSULE", itemStack, 4, var10006, source, var10008);
      ThaumcraftApi.addInfusionCraftingRecipe(var10, var10001);
      $receiver = this;
      ItemStack var11 = new ItemStack;
      var10002 = experience_store;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("experience_store");
      }

      var11.<init>(var10002);
      source = var11;
      var11 = new ItemStack;
      var10002 = mind_inhibitor;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mind_inhibitor");
      }

      var11.<init>(var10002);
      itemStack = var11;
      ResourceLocation var13 = new ResourceLocation("thaumic_arcana", "create_inhibitor");
      var10001 = new InfusionRecipe;
      var10006 = (new AspectList()).add(Aspect.MAGIC, 100).add(Aspect.AURA, 100).add(Aspect.TOOL, 10).add(Aspect.ELDRITCH, 30).add(Aspect.SOUL, 100);
      var10008 = new Object[4];
      var10011 = new ItemStack;
      var10013 = soul_capsule;
      if (var10013 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("soul_capsule");
      }

      var10011.<init>(var10013);
      var10008[0] = var10011;
      var10011 = new ItemStack;
      var10013 = vishroom;
      if (var10013 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("vishroom");
      }

      var10011.<init>(var10013);
      var10008[1] = var10011;
      var10008[2] = new ItemStack(BlocksTC.brainBox);
      var10008[3] = new ItemStack(BlocksTC.condenserlatticeDirty);
      var10001.<init>("TA_INHIBITOR", itemStack, 4, var10006, source, var10008);
      ThaumcraftApi.addInfusionCraftingRecipe(var13, var10001);
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
   public static final Item access$getIngot_livium$cp() {
      Item var10000 = ingot_livium;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("ingot_livium");
      }

      return var10000;
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
   public static final Item access$getPickaxe_slime_infused$cp() {
      Item var10000 = pickaxe_slime_infused;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("pickaxe_slime_infused");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getAxe_slime_infused$cp() {
      Item var10000 = axe_slime_infused;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("axe_slime_infused");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getShovel_slime_infused$cp() {
      Item var10000 = shovel_slime_infused;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("shovel_slime_infused");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getSword_slime_infused$cp() {
      Item var10000 = sword_slime_infused;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("sword_slime_infused");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getHoe_slime_infused$cp() {
      Item var10000 = hoe_slime_infused;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("hoe_slime_infused");
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
   public static final Item access$getInfused_slimy_chestplate$cp() {
      Item var10000 = infused_slimy_chestplate;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infused_slimy_chestplate");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getInfused_slimy_leggings$cp() {
      Item var10000 = infused_slimy_leggings;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infused_slimy_leggings");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getInfused_slimy_helmet$cp() {
      Item var10000 = infused_slimy_helmet;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infused_slimy_helmet");
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
   public static final Item access$getRevival_capsule$cp() {
      Item var10000 = revival_capsule;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("revival_capsule");
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
   public static final Item access$getMind_inhibitor$cp() {
      Item var10000 = mind_inhibitor;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mind_inhibitor");
      }

      return var10000;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getVishroom$cp() {
      Item var10000 = vishroom;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("vishroom");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bD\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001e\u00100\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001e\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001e\u00106\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001e\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001e\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001e\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001e\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001e\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\b¨\u0006H"},
      d2 = {"Lhu/frontrider/arcana/registrationhandlers/recipes/InfusionRecipes$Companion;", "", "()V", "axe_slime", "Lnet/minecraft/item/Item;", "getAxe_slime", "()Lnet/minecraft/item/Item;", "setAxe_slime", "(Lnet/minecraft/item/Item;)V", "axe_slime_infused", "getAxe_slime_infused", "setAxe_slime_infused", "experience_store", "getExperience_store", "setExperience_store", "hoe_slime", "getHoe_slime", "setHoe_slime", "hoe_slime_infused", "getHoe_slime_infused", "setHoe_slime_infused", "infused_slime", "getInfused_slime", "setInfused_slime", "infused_slimy_chestplate", "getInfused_slimy_chestplate", "setInfused_slimy_chestplate", "infused_slimy_helmet", "getInfused_slimy_helmet", "setInfused_slimy_helmet", "infused_slimy_leggings", "getInfused_slimy_leggings", "setInfused_slimy_leggings", "ingot_livium", "getIngot_livium", "setIngot_livium", "mind_inhibitor", "getMind_inhibitor", "setMind_inhibitor", "modifier", "getModifier$Thaumic_Arcana", "setModifier$Thaumic_Arcana", "neutered_flesh", "getNeutered_flesh", "setNeutered_flesh", "pickaxe_slime", "getPickaxe_slime", "setPickaxe_slime", "pickaxe_slime_infused", "getPickaxe_slime_infused", "setPickaxe_slime_infused", "revival_capsule", "getRevival_capsule", "setRevival_capsule", "shovel_slime", "getShovel_slime", "setShovel_slime", "shovel_slime_infused", "getShovel_slime_infused", "setShovel_slime_infused", "soul_capsule", "getSoul_capsule", "setSoul_capsule", "sword_slime", "getSword_slime", "setSword_slime", "sword_slime_infused", "getSword_slime_infused", "setSword_slime_infused", "vishroom", "getVishroom", "setVishroom", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final Item getModifier$Thaumic_Arcana() {
         return InfusionRecipes.access$getModifier$cp();
      }

      public final void setModifier$Thaumic_Arcana(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.modifier = var1;
      }

      @NotNull
      public final Item getIngot_livium() {
         return InfusionRecipes.access$getIngot_livium$cp();
      }

      public final void setIngot_livium(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.ingot_livium = var1;
      }

      @NotNull
      public final Item getNeutered_flesh() {
         return InfusionRecipes.access$getNeutered_flesh$cp();
      }

      public final void setNeutered_flesh(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.neutered_flesh = var1;
      }

      @NotNull
      public final Item getPickaxe_slime_infused() {
         return InfusionRecipes.access$getPickaxe_slime_infused$cp();
      }

      public final void setPickaxe_slime_infused(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.pickaxe_slime_infused = var1;
      }

      @NotNull
      public final Item getAxe_slime_infused() {
         return InfusionRecipes.access$getAxe_slime_infused$cp();
      }

      public final void setAxe_slime_infused(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.axe_slime_infused = var1;
      }

      @NotNull
      public final Item getShovel_slime_infused() {
         return InfusionRecipes.access$getShovel_slime_infused$cp();
      }

      public final void setShovel_slime_infused(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.shovel_slime_infused = var1;
      }

      @NotNull
      public final Item getSword_slime_infused() {
         return InfusionRecipes.access$getSword_slime_infused$cp();
      }

      public final void setSword_slime_infused(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.sword_slime_infused = var1;
      }

      @NotNull
      public final Item getHoe_slime_infused() {
         return InfusionRecipes.access$getHoe_slime_infused$cp();
      }

      public final void setHoe_slime_infused(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.hoe_slime_infused = var1;
      }

      @NotNull
      public final Item getPickaxe_slime() {
         return InfusionRecipes.access$getPickaxe_slime$cp();
      }

      public final void setPickaxe_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.pickaxe_slime = var1;
      }

      @NotNull
      public final Item getAxe_slime() {
         return InfusionRecipes.access$getAxe_slime$cp();
      }

      public final void setAxe_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.axe_slime = var1;
      }

      @NotNull
      public final Item getShovel_slime() {
         return InfusionRecipes.access$getShovel_slime$cp();
      }

      public final void setShovel_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.shovel_slime = var1;
      }

      @NotNull
      public final Item getSword_slime() {
         return InfusionRecipes.access$getSword_slime$cp();
      }

      public final void setSword_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.sword_slime = var1;
      }

      @NotNull
      public final Item getHoe_slime() {
         return InfusionRecipes.access$getHoe_slime$cp();
      }

      public final void setHoe_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.hoe_slime = var1;
      }

      @NotNull
      public final Item getInfused_slimy_chestplate() {
         return InfusionRecipes.access$getInfused_slimy_chestplate$cp();
      }

      public final void setInfused_slimy_chestplate(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.infused_slimy_chestplate = var1;
      }

      @NotNull
      public final Item getInfused_slimy_leggings() {
         return InfusionRecipes.access$getInfused_slimy_leggings$cp();
      }

      public final void setInfused_slimy_leggings(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.infused_slimy_leggings = var1;
      }

      @NotNull
      public final Item getInfused_slimy_helmet() {
         return InfusionRecipes.access$getInfused_slimy_helmet$cp();
      }

      public final void setInfused_slimy_helmet(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.infused_slimy_helmet = var1;
      }

      @NotNull
      public final Item getInfused_slime() {
         return InfusionRecipes.access$getInfused_slime$cp();
      }

      public final void setInfused_slime(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.infused_slime = var1;
      }

      @NotNull
      public final Item getSoul_capsule() {
         return InfusionRecipes.access$getSoul_capsule$cp();
      }

      public final void setSoul_capsule(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.soul_capsule = var1;
      }

      @NotNull
      public final Item getRevival_capsule() {
         return InfusionRecipes.access$getRevival_capsule$cp();
      }

      public final void setRevival_capsule(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.revival_capsule = var1;
      }

      @NotNull
      public final Item getExperience_store() {
         return InfusionRecipes.access$getExperience_store$cp();
      }

      public final void setExperience_store(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.experience_store = var1;
      }

      @NotNull
      public final Item getMind_inhibitor() {
         return InfusionRecipes.access$getMind_inhibitor$cp();
      }

      public final void setMind_inhibitor(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.mind_inhibitor = var1;
      }

      @NotNull
      public final Item getVishroom() {
         return InfusionRecipes.access$getVishroom$cp();
      }

      public final void setVishroom(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         InfusionRecipes.vishroom = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

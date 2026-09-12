package hu.frontrider.arcana.registrationhandlers;

import hu.frontrider.arcana.ThaumicArcana;
import hu.frontrider.arcana.items.CreatureEnchanter;
import hu.frontrider.arcana.items.EnchantModifierDust;
import hu.frontrider.arcana.items.EnchantmentUpgradePowder;
import hu.frontrider.arcana.items.IncubatedEgg;
import hu.frontrider.arcana.items.ItemFertiliser;
import hu.frontrider.arcana.items.ItemInfusedSlime;
import hu.frontrider.arcana.items.ItemPlantBall;
import hu.frontrider.arcana.items.armor.SlimiumArmor;
import hu.frontrider.arcana.items.curio.AnimatedCuriosity;
import hu.frontrider.arcana.items.curio.AuraCuriosity;
import hu.frontrider.arcana.items.curio.InfusedCuriosity;
import hu.frontrider.arcana.items.curio.NaturalCuriosity;
import hu.frontrider.arcana.items.curio.ResearchResult;
import hu.frontrider.arcana.items.tools.InfusedSlimiumAxe;
import hu.frontrider.arcana.items.tools.InfusedSlimiumHoe;
import hu.frontrider.arcana.items.tools.InfusedSlimiumPickAxe;
import hu.frontrider.arcana.items.tools.InfusedSlimiumShovel;
import hu.frontrider.arcana.items.tools.InfusedSlimiumSword;
import hu.frontrider.arcana.items.tools.ItemExpStore;
import hu.frontrider.arcana.items.tools.ItemInhibitor;
import hu.frontrider.arcana.items.tools.LiviumAxe;
import hu.frontrider.arcana.items.tools.LiviumPickAxe;
import hu.frontrider.arcana.items.tools.LiviumShovel;
import hu.frontrider.arcana.items.tools.LiviumSword;
import hu.frontrider.arcana.items.tools.SlimiumAxe;
import hu.frontrider.arcana.items.tools.SlimiumHoe;
import hu.frontrider.arcana.items.tools.SlimiumPickAxe;
import hu.frontrider.arcana.items.tools.SlimiumShovel;
import hu.frontrider.arcana.items.tools.SlimiumSword;
import hu.frontrider.arcana.util.Initialisable;
import hu.frontrider.arcana.util.items.ItemFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¨\u0006\t"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/ItemRegistry;", "", "()V", "init", "", "event", "Lnet/minecraftforge/event/RegistryEvent$Register;", "Lnet/minecraft/item/Item;", "Companion", "Thaumic Arcana"}
)
public final class ItemRegistry {
   @NotNull
   private static Item enchanting_powder_basic;
   @NotNull
   private static Item enchanting_powder_advanced;
   @NotNull
   private static Item enchanting_powder_magical;
   @NotNull
   private static Item fertiliser;
   @NotNull
   private static Item incubated_egg;
   @NotNull
   private static Item creature_enchanter;
   @NotNull
   private static Item plant_ball;
   @NotNull
   private static final EnchantModifierDust enchantModifier;
   @NotNull
   private static final ArrayList<Block> blocks;
   @NotNull
   private static final List<Item> items;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @SubscribeEvent
   public final void init(@NotNull final RegistryEvent.Register<Item> event) {
      Intrinsics.checkParameterIsNotNull(event, "event");

      for(Object element$iv : (Iterable)items) {
         Item item = (Item)element$iv;
         if (item instanceof Initialisable) {
            ((Initialisable)item).init();
         }
      }

      for(Object element$iv : (Iterable)blocks) {
         Block it = (Block)element$iv;
         Collection $i$a$1$forEach = (Collection)items;
         ItemBlock var10000 = new ItemBlock(it);
         ResourceLocation var10001 = it.getRegistryName();
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         Item $i$f$forEach = ((Item)var10000.setRegistryName(var10001)).func_77637_a(it.func_149708_J());
         $i$a$1$forEach.add($i$f$forEach);
      }

      items.iterator().forEachRemaining(new Consumer<Item>() {
         public final void accept(@NotNull Item it) {
            Intrinsics.checkParameterIsNotNull(it, "it");
            event.getRegistry().registerAll(new Item[]{it});
         }
      });
   }

   static {
      ResourceLocation var10003 = new ResourceLocation("thaumic_arcana", "enchanting_powder_basic");
      SimpleNetworkWrapper var10004 = ThaumicArcana.INSTANCE.getNETWORK_WRAPPER();
      Intrinsics.checkExpressionValueIsNotNull(var10004, "NETWORK_WRAPPER");
      enchanting_powder_basic = new EnchantmentUpgradePowder(1, var10003, var10004);
      var10003 = new ResourceLocation("thaumic_arcana", "enchanting_powder_advanced");
      var10004 = ThaumicArcana.INSTANCE.getNETWORK_WRAPPER();
      Intrinsics.checkExpressionValueIsNotNull(var10004, "NETWORK_WRAPPER");
      enchanting_powder_advanced = new EnchantmentUpgradePowder(2, var10003, var10004);
      var10003 = new ResourceLocation("thaumic_arcana", "enchanting_powder_magical");
      var10004 = ThaumicArcana.INSTANCE.getNETWORK_WRAPPER();
      Intrinsics.checkExpressionValueIsNotNull(var10004, "NETWORK_WRAPPER");
      enchanting_powder_magical = new EnchantmentUpgradePowder(3, var10003, var10004);
      fertiliser = new ItemFertiliser();
      incubated_egg = new IncubatedEgg();
      SimpleNetworkWrapper var10002 = ThaumicArcana.INSTANCE.getNETWORK_WRAPPER();
      Intrinsics.checkExpressionValueIsNotNull(var10002, "NETWORK_WRAPPER");
      creature_enchanter = new CreatureEnchanter(var10002);
      plant_ball = new ItemPlantBall();
      var10002 = ThaumicArcana.INSTANCE.getNETWORK_WRAPPER();
      Intrinsics.checkExpressionValueIsNotNull(var10002, "NETWORK_WRAPPER");
      enchantModifier = new EnchantModifierDust(var10002);
      blocks = new ArrayList();
      Item[] var10000 = new Item[]{ItemFactory.INSTANCE.start((Item)(new ItemFood(5, 0.3F, true))).setResourourceLocation("nutrient_mix").build(), ItemFactory.INSTANCE.start((Item)(new ItemFood(8, 0.1F, true))).setResourourceLocation("nutritious_mix").build(), fertiliser, incubated_egg, creature_enchanter, plant_ball, enchanting_powder_basic, enchanting_powder_advanced, enchanting_powder_magical, enchantModifier, new ResearchResult(), new NaturalCuriosity(), new AuraCuriosity(), new InfusedCuriosity(), new AnimatedCuriosity(), ItemFactory.INSTANCE.start(new Item()).setResourourceLocation("ingot_livium").build(), ItemFactory.INSTANCE.start(new Item()).setResourourceLocation("neutered_flesh").build(), (Item)(new LiviumPickAxe()), (Item)(new LiviumAxe()), (Item)(new LiviumShovel()), (Item)(new LiviumSword()), (Item)(new SlimiumPickAxe()), (Item)(new SlimiumAxe()), (Item)(new SlimiumSword()), (Item)(new SlimiumShovel()), (Item)(new SlimiumHoe()), (Item)(new InfusedSlimiumAxe()), (Item)(new InfusedSlimiumPickAxe()), (Item)(new InfusedSlimiumSword()), (Item)(new InfusedSlimiumHoe()), (Item)(new InfusedSlimiumShovel()), ItemFactory.INSTANCE.start((Item)(new SlimiumArmor(EntityEquipmentSlot.CHEST))).setResourourceLocation("infused_slimy_chestplate").build(), ItemFactory.INSTANCE.start((Item)(new SlimiumArmor(EntityEquipmentSlot.LEGS))).setResourourceLocation("infused_slimy_leggings").build(), ItemFactory.INSTANCE.start((Item)(new SlimiumArmor(EntityEquipmentSlot.HEAD))).setResourourceLocation("infused_slimy_helmet").build(), ItemFactory.INSTANCE.start((Item)(new ItemFood(3, 0.3F, false))).setResourourceLocation("slime_meat_raw").build(), ItemFactory.INSTANCE.start((Item)(new ItemFood(10, 0.9F, false))).setResourourceLocation("slime_meat_cooked").build(), ItemFactory.INSTANCE.start(new ItemInfusedSlime()).setResourourceLocation("infused_slime").build(), null, null, null, null, null};
      Item var3 = ItemFactory.INSTANCE.start(new ItemExpStore()).setResourourceLocation("experience_store").build().func_77625_d(1);
      Intrinsics.checkExpressionValueIsNotNull(var3, "ItemFactory.start(ItemEx…      .setMaxStackSize(1)");
      var10000[37] = var3;
      var10000[38] = ItemFactory.INSTANCE.start(new Item()).setResourourceLocation("empty_soul_capsule").build();
      var10000[39] = ItemFactory.INSTANCE.start(new Item()).setResourourceLocation("soul_capsule").build();
      var3 = ItemFactory.INSTANCE.start(new Item()).setResourourceLocation("revival_capsule").build().func_77625_d(1);
      Intrinsics.checkExpressionValueIsNotNull(var3, "ItemFactory.start(Item()…      .setMaxStackSize(1)");
      var10000[40] = var3;
      var3 = ItemFactory.INSTANCE.start(new ItemInhibitor()).setResourourceLocation("mind_inhibitor").build().func_77625_d(8);
      Intrinsics.checkExpressionValueIsNotNull(var3, "ItemFactory.start(ItemIn…      .setMaxStackSize(8)");
      var10000[41] = var3;
      items = CollectionsKt.mutableListOf(var10000);
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR\u001a\u0010\u001b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR\u001a\u0010\u001e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000b\"\u0004\b'\u0010\r¨\u0006("},
      d2 = {"Lhu/frontrider/arcana/registrationhandlers/ItemRegistry$Companion;", "", "()V", "blocks", "Ljava/util/ArrayList;", "Lnet/minecraft/block/Block;", "getBlocks", "()Ljava/util/ArrayList;", "creature_enchanter", "Lnet/minecraft/item/Item;", "getCreature_enchanter", "()Lnet/minecraft/item/Item;", "setCreature_enchanter", "(Lnet/minecraft/item/Item;)V", "enchantModifier", "Lhu/frontrider/arcana/items/EnchantModifierDust;", "getEnchantModifier", "()Lhu/frontrider/arcana/items/EnchantModifierDust;", "enchanting_powder_advanced", "getEnchanting_powder_advanced", "setEnchanting_powder_advanced", "enchanting_powder_basic", "getEnchanting_powder_basic", "setEnchanting_powder_basic", "enchanting_powder_magical", "getEnchanting_powder_magical", "setEnchanting_powder_magical", "fertiliser", "getFertiliser", "setFertiliser", "incubated_egg", "getIncubated_egg", "setIncubated_egg", "items", "", "getItems", "()Ljava/util/List;", "plant_ball", "getPlant_ball", "setPlant_ball", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final Item getEnchanting_powder_basic() {
         return ItemRegistry.enchanting_powder_basic;
      }

      public final void setEnchanting_powder_basic(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ItemRegistry.enchanting_powder_basic = var1;
      }

      @NotNull
      public final Item getEnchanting_powder_advanced() {
         return ItemRegistry.enchanting_powder_advanced;
      }

      public final void setEnchanting_powder_advanced(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ItemRegistry.enchanting_powder_advanced = var1;
      }

      @NotNull
      public final Item getEnchanting_powder_magical() {
         return ItemRegistry.enchanting_powder_magical;
      }

      public final void setEnchanting_powder_magical(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ItemRegistry.enchanting_powder_magical = var1;
      }

      @NotNull
      public final Item getFertiliser() {
         return ItemRegistry.fertiliser;
      }

      public final void setFertiliser(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ItemRegistry.fertiliser = var1;
      }

      @NotNull
      public final Item getIncubated_egg() {
         return ItemRegistry.incubated_egg;
      }

      public final void setIncubated_egg(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ItemRegistry.incubated_egg = var1;
      }

      @NotNull
      public final Item getCreature_enchanter() {
         return ItemRegistry.creature_enchanter;
      }

      public final void setCreature_enchanter(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ItemRegistry.creature_enchanter = var1;
      }

      @NotNull
      public final Item getPlant_ball() {
         return ItemRegistry.plant_ball;
      }

      public final void setPlant_ball(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ItemRegistry.plant_ball = var1;
      }

      @NotNull
      public final EnchantModifierDust getEnchantModifier() {
         return ItemRegistry.enchantModifier;
      }

      @NotNull
      public final ArrayList<Block> getBlocks() {
         return ItemRegistry.blocks;
      }

      @NotNull
      public final List<Item> getItems() {
         return ItemRegistry.items;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

package hu.frontrider.arcana;

import hu.frontrider.arcana.api.InhibitorAIRegistryEvent;
import hu.frontrider.arcana.api.PeopleRegistryEvent;
import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantStorage;
import hu.frontrider.arcana.capabilities.creatureenchant.ICreatureEnchant;
import hu.frontrider.arcana.capabilities.inhibitor.IInhibitor;
import hu.frontrider.arcana.capabilities.inhibitor.InhibitorStorage;
import hu.frontrider.arcana.capabilities.scar.IScarred;
import hu.frontrider.arcana.capabilities.scar.ScarredStorage;
import hu.frontrider.arcana.entity.inhibitor.IInhibitedAIKt;
import hu.frontrider.arcana.entity.inhibitor.InhibitorEvents;
import hu.frontrider.arcana.entity.inhibitor.ai.AIHolder;
import hu.frontrider.arcana.eventhandlers.CurioDropEvents;
import hu.frontrider.arcana.eventhandlers.FunctionEventManager;
import hu.frontrider.arcana.eventhandlers.LifecycleEventManager;
import hu.frontrider.arcana.eventhandlers.ToolEvents;
import hu.frontrider.arcana.eventhandlers.UnluckHandler;
import hu.frontrider.arcana.recipes.BrewSlime;
import hu.frontrider.arcana.registrationhandlers.AIRegistryEvent;
import hu.frontrider.arcana.registrationhandlers.BlockRegistry;
import hu.frontrider.arcana.registrationhandlers.CreatureEnchantRegistry;
import hu.frontrider.arcana.registrationhandlers.FocusRegistry;
import hu.frontrider.arcana.registrationhandlers.GolemRegistry;
import hu.frontrider.arcana.registrationhandlers.ItemRegistry;
import hu.frontrider.arcana.registrationhandlers.LootHandler;
import hu.frontrider.arcana.registrationhandlers.OreDictionaryRegistry;
import hu.frontrider.arcana.registrationhandlers.recipes.AlchemyRecipes;
import hu.frontrider.arcana.registrationhandlers.recipes.ArcaneCraftingRecipes;
import hu.frontrider.arcana.registrationhandlers.recipes.FakeRecipes;
import hu.frontrider.arcana.registrationhandlers.recipes.InfusionRecipes;
import hu.frontrider.arcana.research.ResearchEventManager;
import hu.frontrider.arcana.research.ResearchRegistry;
import hu.frontrider.arcana.server.commands.StructureSpawnerCommand;
import hu.frontrider.arcana.sided.GuiHandler;
import hu.frontrider.arcana.sided.network.creatureenchants.CreatureEnchantSyncMessage;
import hu.frontrider.arcana.sided.network.creatureenchants.CreatureEnchantSyncMessageHandler;
import hu.frontrider.arcana.sided.network.creatureenchants.CreatureEnchantSynchroniser;
import hu.frontrider.arcana.sided.network.falldamage.FalldamageSyncMessage;
import hu.frontrider.arcana.sided.network.falldamage.FalldamageSyncMessageHandler;
import hu.frontrider.arcana.sided.server.commands.ScarHelperCommand;
import hu.frontrider.arcana.util.CreativeTabArcana;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.ICommand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(
   modid = "thaumic_arcana",
   name = "Thaumic Arcana",
   version = "1.2.0",
   dependencies = "required-after:thaumcraft;required-after:forgelin;before:jei;after:thaumcraftresearchloader",
   modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter",
   acceptedMinecraftVersions = "[1.12.2]"
)
@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007J\u0010\u00101\u001a\u00020.2\u0006\u0010/\u001a\u000202H\u0007J\u0010\u00103\u001a\u00020.2\u0006\u0010/\u001a\u000204H\u0007J\u0010\u00105\u001a\u00020.2\u0006\u0010/\u001a\u000206H\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)¨\u00067"},
   d2 = {"Lhu/frontrider/arcana/ThaumicArcana;", "", "()V", "ConfigDirectory", "Ljava/io/File;", "getConfigDirectory", "()Ljava/io/File;", "setConfigDirectory", "(Ljava/io/File;)V", "MODID", "", "NAME", "NETWORK_WRAPPER", "Lnet/minecraftforge/fml/common/network/simpleimpl/SimpleNetworkWrapper;", "kotlin.jvm.PlatformType", "getNETWORK_WRAPPER", "()Lnet/minecraftforge/fml/common/network/simpleimpl/SimpleNetworkWrapper;", "TABARCANA", "Lnet/minecraft/creativetab/CreativeTabs;", "getTABARCANA", "()Lnet/minecraft/creativetab/CreativeTabs;", "setTABARCANA", "(Lnet/minecraft/creativetab/CreativeTabs;)V", "VERSION", "logger", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "setLogger", "(Lorg/apache/logging/log4j/Logger;)V", "proxy", "Lhu/frontrider/arcana/CommonProxy;", "getProxy", "()Lhu/frontrider/arcana/CommonProxy;", "setProxy", "(Lhu/frontrider/arcana/CommonProxy;)V", "slimeMeat", "Lnet/minecraft/item/Item;", "getSlimeMeat", "()Lnet/minecraft/item/Item;", "setSlimeMeat", "(Lnet/minecraft/item/Item;)V", "slimeSteak", "getSlimeSteak", "setSlimeSteak", "init", "", "event", "Lnet/minecraftforge/fml/common/event/FMLInitializationEvent;", "postInit", "Lnet/minecraftforge/fml/common/event/FMLPostInitializationEvent;", "preInit", "Lnet/minecraftforge/fml/common/event/FMLPreInitializationEvent;", "serverLoad", "Lnet/minecraftforge/fml/common/event/FMLServerStartingEvent;", "Thaumic Arcana"}
)
public final class ThaumicArcana {
   @NotNull
   public static final String MODID = "thaumic_arcana";
   @NotNull
   public static final String NAME = "Thaumic Arcana";
   @NotNull
   public static final String VERSION = "1.2.0";
   @NotNull
   public static File ConfigDirectory;
   @NotNull
   public static Logger logger;
   @NotNull
   private static CreativeTabs TABARCANA;
   private static final SimpleNetworkWrapper NETWORK_WRAPPER;
   @SidedProxy(
      clientSide = "hu.frontrider.arcana.sided.client.ClientProxy",
      serverSide = "hu.frontrider.arcana.CommonProxy"
   )
   @NotNull
   public static CommonProxy proxy;
   @ObjectHolder("thaumic_arcana:slime_meat_raw")
   @NotNull
   public static Item slimeMeat;
   @ObjectHolder("thaumic_arcana:slime_meat_cooked")
   @NotNull
   public static Item slimeSteak;
   public static final ThaumicArcana INSTANCE;

   @EventHandler
   public final void preInit(@NotNull FMLPreInitializationEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      Logger var10000 = event.getModLog();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "event.modLog");
      logger = var10000;
      File suggestedConfigurationFile = event.getSuggestedConfigurationFile();
      String var3 = "adding registration handlers";
      System.out.println(var3);
      MinecraftForge.EVENT_BUS.register(new BlockRegistry());
      MinecraftForge.EVENT_BUS.register(new ItemRegistry());
      MinecraftForge.EVENT_BUS.register(new CreatureEnchantRegistry());
      MinecraftForge.EVENT_BUS.register(new ToolEvents());
      MinecraftForge.EVENT_BUS.register(new UnluckHandler());
      MinecraftForge.EVENT_BUS.register(new InhibitorEvents());
      MinecraftForge.EVENT_BUS.register(new AIRegistryEvent());
      StringBuilder var10002 = new StringBuilder();
      Intrinsics.checkExpressionValueIsNotNull(suggestedConfigurationFile, "suggestedConfigurationFile");
      ConfigDirectory = new File(var10002.append(suggestedConfigurationFile.getParent()).append("/").append("thaumic_arcana").append("/").toString());
      CommonProxy var4 = proxy;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("proxy");
      }

      var4.preInit(event);
      CapabilityManager.INSTANCE.register(ICreatureEnchant.class, new CreatureEnchantStorage(), null.INSTANCE);
      CapabilityManager.INSTANCE.register(IScarred.class, new ScarredStorage(), null.INSTANCE);
      CapabilityManager.INSTANCE.register(IInhibitor.class, new InhibitorStorage(), null.INSTANCE);
      (new LootHandler()).init();
      NETWORK_WRAPPER.registerMessage(CreatureEnchantSyncMessageHandler.class, CreatureEnchantSyncMessage.class, 0, Side.CLIENT);
      NETWORK_WRAPPER.registerMessage(FalldamageSyncMessageHandler.class, FalldamageSyncMessage.class, 1, Side.SERVER);
      NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
      ResearchRegistrationKt.registerResearchLoader(suggestedConfigurationFile);
   }

   @EventHandler
   public final void init(@NotNull FMLInitializationEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      CommonProxy var10000 = proxy;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("proxy");
      }

      var10000.init(event);
      AspectEffectMap.INSTANCE.init();
      MinecraftForge.EVENT_BUS.register(new CreatureEnchantSynchroniser());
      MinecraftForge.EVENT_BUS.register(new FunctionEventManager());
      MinecraftForge.EVENT_BUS.register(new LifecycleEventManager());
      MinecraftForge.EVENT_BUS.register(new CurioDropEvents());
      (new OreDictionaryRegistry()).init();
      (new ResearchEventManager()).initHandlers();
      (new AlchemyRecipes()).register();
      (new InfusionRecipes()).register();
      (new ArcaneCraftingRecipes()).register();
      (new ResearchRegistry()).init();
      (new FocusRegistry()).init();
      (new GolemRegistry()).init();
      (new FakeRecipes()).init();
      ArrayList aiList = new ArrayList();
      InhibitorAIRegistryEvent inhibitorAIRegistryEvent = new InhibitorAIRegistryEvent((List)aiList);
      MinecraftForge.EVENT_BUS.post(inhibitorAIRegistryEvent);
      AIHolder.INSTANCE.register((List)aiList);
      BlockDispenser.field_149943_a.func_82595_a(ItemRegistry.Companion.getIncubated_egg(), new BehaviorDefaultDispenseItem() {
         private final BehaviorDefaultDispenseItem dispenseBehavior = new BehaviorDefaultDispenseItem();

         @NotNull
         public ItemStack func_82487_b(@NotNull IBlockSource source, @NotNull ItemStack stack) {
            label17: {
               Intrinsics.checkParameterIsNotNull(source, "source");
               Intrinsics.checkParameterIsNotNull(stack, "stack");
               EnumFacing enumfacing = (EnumFacing)source.func_189992_e().func_177229_b((IProperty)BlockDispenser.field_176441_a);
               World world = source.func_82618_k();
               double var10000 = source.func_82615_a();
               Intrinsics.checkExpressionValueIsNotNull(enumfacing, "enumfacing");
               double d0 = var10000 + (double)((float)enumfacing.func_82601_c() * 1.125F);
               double d1 = source.func_82617_b() + (double)((float)enumfacing.func_96559_d() * 1.125F);
               double d2 = source.func_82616_c() + (double)((float)enumfacing.func_82599_e() * 1.125F);
               BlockPos blockpos = source.func_180699_d().func_177972_a(enumfacing);
               IBlockState var16 = world.func_180495_p(blockpos);
               Intrinsics.checkExpressionValueIsNotNull(var16, "world.getBlockState(blockpos)");
               Material material = var16.func_185904_a();
               double var17;
               if (Intrinsics.areEqual(Material.field_151586_h, material)) {
                  var17 = (double)1.0F;
               } else {
                  if (Intrinsics.areEqual(Material.field_151579_a, material) ^ true) {
                     break label17;
                  }

                  Material var18 = Material.field_151586_h;
                  IBlockState var10001 = world.func_180495_p(blockpos.func_177977_b());
                  Intrinsics.checkExpressionValueIsNotNull(var10001, "world.getBlockState(blockpos.down())");
                  if (Intrinsics.areEqual(var18, var10001.func_185904_a()) ^ true) {
                     break label17;
                  }

                  var17 = (double)0.0F;
               }

               double d3 = var17;
               EntityChicken chicken = new EntityChicken(world);
               chicken.field_70177_z = enumfacing.func_185119_l();
               chicken.func_70873_a(-24000);
               chicken.field_70165_t = d0;
               chicken.field_70163_u = d1 + d3;
               chicken.field_70161_v = d2;
               world.func_72838_d((Entity)chicken);
               stack.func_190918_g(1);
               return stack;
            }

            ItemStack var19 = this.dispenseBehavior.func_82482_a(source, stack);
            Intrinsics.checkExpressionValueIsNotNull(var19, "this.dispenseBehavior.dispense(source, stack)");
            return var19;
         }
      });
      ArrayList arrayList = new ArrayList();
      PeopleRegistryEvent peopleRegistryEvent = new PeopleRegistryEvent((List)arrayList);
      MinecraftForge.EVENT_BUS.post(peopleRegistryEvent);
      Collection var6 = (Collection)arrayList;
      String[] var10001 = TAConfig.entityPerson;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "TAConfig.entityPerson");
      CollectionsKt.addAll(var6, var10001);
      IInhibitedAIKt.setPeopleList((List)arrayList);
   }

   @EventHandler
   public final void postInit(@NotNull FMLPostInitializationEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      FurnaceRecipes var10000 = FurnaceRecipes.func_77602_a();
      Item var10001 = slimeMeat;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("slimeMeat");
      }

      ItemStack var10002 = new ItemStack;
      Item var10004 = slimeSteak;
      if (var10004 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("slimeSteak");
      }

      var10002.<init>(var10004);
      var10000.func_151396_a(var10001, var10002, 0.1F);
      BrewingRecipeRegistry.addRecipe(new BrewSlime());
   }

   @EventHandler
   public final void serverLoad(@NotNull FMLServerStartingEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      event.registerServerCommand((ICommand)(new StructureSpawnerCommand()));
      event.registerServerCommand((ICommand)(new ScarHelperCommand()));
   }

   @NotNull
   public final File getConfigDirectory() {
      File var10000 = ConfigDirectory;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("ConfigDirectory");
      }

      return var10000;
   }

   public final void setConfigDirectory(@NotNull File var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      ConfigDirectory = var1;
   }

   @NotNull
   public final Logger getLogger() {
      Logger var10000 = logger;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("logger");
      }

      return var10000;
   }

   public final void setLogger(@NotNull Logger var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      logger = var1;
   }

   @NotNull
   public final CreativeTabs getTABARCANA() {
      return TABARCANA;
   }

   public final void setTABARCANA(@NotNull CreativeTabs var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      TABARCANA = var1;
   }

   public final SimpleNetworkWrapper getNETWORK_WRAPPER() {
      return NETWORK_WRAPPER;
   }

   @NotNull
   public final CommonProxy getProxy() {
      CommonProxy var10000 = proxy;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("proxy");
      }

      return var10000;
   }

   public final void setProxy(@NotNull CommonProxy var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      proxy = var1;
   }

   @NotNull
   public final Item getSlimeMeat() {
      Item var10000 = slimeMeat;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("slimeMeat");
      }

      return var10000;
   }

   public final void setSlimeMeat(@NotNull Item var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      slimeMeat = var1;
   }

   @NotNull
   public final Item getSlimeSteak() {
      Item var10000 = slimeSteak;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("slimeSteak");
      }

      return var10000;
   }

   public final void setSlimeSteak(@NotNull Item var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      slimeSteak = var1;
   }

   private ThaumicArcana() {
   }

   static {
      ThaumicArcana var0 = new ThaumicArcana();
      INSTANCE = var0;
      TABARCANA = new CreativeTabArcana(CreativeTabs.getNextID(), "thaumic_arcana");
      NETWORK_WRAPPER = NetworkRegistry.INSTANCE.newSimpleChannel("thaumic_arcana");
   }
}

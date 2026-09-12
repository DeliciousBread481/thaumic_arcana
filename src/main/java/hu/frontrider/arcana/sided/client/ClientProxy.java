package hu.frontrider.arcana.sided.client;

import hu.frontrider.arcana.CommonProxy;
import hu.frontrider.arcana.creatureenchant.EnchantingBaseCircle;
import hu.frontrider.arcana.registrationhandlers.ItemRegistry;
import hu.frontrider.arcana.sided.client.commands.ReloadOffsetsCommand;
import hu.frontrider.arcana.sided.client.rendering.EnchantRenderer;
import hu.frontrider.arcana.sided.client.rendering.implantmodel.ImplantRenderer;
import java.awt.Color;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.command.ICommand;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"},
   d2 = {"Lhu/frontrider/arcana/sided/client/ClientProxy;", "Lhu/frontrider/arcana/CommonProxy;", "()V", "init", "", "event", "Lnet/minecraftforge/fml/common/event/FMLInitializationEvent;", "Companion", "Thaumic Arcana"}
)
public final class ClientProxy extends CommonProxy {
   @ObjectHolder("thaumic_arcana:enchant_modifier")
   @Nullable
   private static Item enchantModifier;
   @ObjectHolder("thaumic_arcana:infused_slime")
   @NotNull
   public static Item infusedSlime;
   @ObjectHolder("thaumic_arcana:essentia_mine")
   @NotNull
   public static Block essentia_mine;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public void init(@NotNull FMLInitializationEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      super.init(event);
      Companion var10000 = Companion;
      Minecraft var10001 = Minecraft.func_71410_x();
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Minecraft.getMinecraft()");
      RenderItem var24 = var10001.func_175599_af();
      Intrinsics.checkExpressionValueIsNotNull(var24, "Minecraft.getMinecraft().renderItem");
      ItemModelMesher var25 = var24.func_175037_a();
      Intrinsics.checkExpressionValueIsNotNull(var25, "Minecraft.getMinecraft()…enderItem.itemModelMesher");
      var10000.initClient(var25);
      EnchantRenderer enchantRenderer = new EnchantRenderer();
      IForgeRegistry var14 = ForgeRegistries.ENTITIES;
      Intrinsics.checkExpressionValueIsNotNull(var14, "ForgeRegistries.ENTITIES");
      Set var15 = var14.getEntries();
      Intrinsics.checkExpressionValueIsNotNull(var15, "ForgeRegistries.ENTITIES.entries");

      for(Object element$iv : (Iterable)var15) {
         Map.Entry resourceLocationEntityEntryEntry = (Map.Entry)element$iv;
         Object var16 = resourceLocationEntityEntryEntry.getValue();
         Intrinsics.checkExpressionValueIsNotNull(var16, "resourceLocationEntityEntryEntry.value");
         Class entityClass = ((EntityEntry)var16).getEntityClass();
         Minecraft var17 = Minecraft.func_71410_x();
         Intrinsics.checkExpressionValueIsNotNull(var17, "Minecraft.getMinecraft()");
         Render renderer = var17.func_175598_ae().func_78715_a(entityClass);
         if (renderer instanceof RenderLivingBase) {
            ((RenderLivingBase)renderer).func_177094_a(enchantRenderer);
         }
      }

      Minecraft var18 = Minecraft.func_71410_x();
      Intrinsics.checkExpressionValueIsNotNull(var18, "Minecraft.getMinecraft()");
      RenderManager var19 = var18.func_175598_ae();
      Intrinsics.checkExpressionValueIsNotNull(var19, "Minecraft.getMinecraft().renderManager");

      for(RenderPlayer playerRender : var19.getSkinMap().values()) {
         playerRender.func_177094_a(enchantRenderer);
         playerRender.func_177094_a(new ImplantRenderer());
      }

      MinecraftForge.EVENT_BUS.register(enchantRenderer);
      ClientCommandHandler.instance.func_71560_a((ICommand)(new ReloadOffsetsCommand(enchantRenderer)));
      final IForgeRegistry registry = GameRegistry.findRegistry(EnchantingBaseCircle.class);
      Minecraft var20 = Minecraft.func_71410_x();
      Intrinsics.checkExpressionValueIsNotNull(var20, "Minecraft.getMinecraft()");
      ItemColors var21 = var20.getItemColors();
      IItemColor var26 = new IItemColor() {
         public final int func_186726_a(ItemStack stack, int $noName_1) {
            Intrinsics.checkExpressionValueIsNotNull(stack, "stack");
            NBTTagCompound var10000 = stack.func_77978_p();
            if (var10000 != null) {
               Intrinsics.checkExpressionValueIsNotNull(var10000, "stack.tagCompound ?: return@IItemColor 0");
               NBTTagCompound tagCompound = var10000;
               if (!tagCompound.func_74764_b("modifier")) {
                  return 0;
               } else {
                  String modifier = tagCompound.func_74779_i("modifier");
                  IForgeRegistryEntry var7 = registry.getValue(new ResourceLocation(modifier));
                  if (var7 == null) {
                     Intrinsics.throwNpe();
                  }

                  Intrinsics.checkExpressionValueIsNotNull(var7, "registry.getValue(ResourceLocation(modifier))!!");
                  EnchantingBaseCircle value = (EnchantingBaseCircle)var7;
                  EnchantingBaseCircle.Color color = value.getColor();
                  return (new Color(color.getR(), color.getG(), color.getB())).getRGB();
               }
            } else {
               return 0;
            }
         }
      };
      Item[] var10002 = new Item[1];
      Item var10005 = enchantModifier;
      if (var10005 == null) {
         Intrinsics.throwNpe();
      }

      var10002[0] = var10005;
      var21.func_186730_a(var26, var10002);
      Minecraft var22 = Minecraft.func_71410_x();
      Intrinsics.checkExpressionValueIsNotNull(var22, "Minecraft.getMinecraft()");
      ItemColors var23 = var22.getItemColors();
      var26 = null.INSTANCE;
      var10002 = new Item[1];
      var10005 = infusedSlime;
      if (var10005 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("infusedSlime");
      }

      var10002[0] = var10005;
      var23.func_186730_a(var26, var10002);
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

   // $FF: synthetic method
   @NotNull
   public static final Block access$getEssentia_mine$cp() {
      Block var10000 = essentia_mine;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("essentia_mine");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0016"},
      d2 = {"Lhu/frontrider/arcana/sided/client/ClientProxy$Companion;", "", "()V", "enchantModifier", "Lnet/minecraft/item/Item;", "getEnchantModifier$Thaumic_Arcana", "()Lnet/minecraft/item/Item;", "setEnchantModifier$Thaumic_Arcana", "(Lnet/minecraft/item/Item;)V", "essentia_mine", "Lnet/minecraft/block/Block;", "getEssentia_mine$Thaumic_Arcana", "()Lnet/minecraft/block/Block;", "setEssentia_mine$Thaumic_Arcana", "(Lnet/minecraft/block/Block;)V", "infusedSlime", "getInfusedSlime$Thaumic_Arcana", "setInfusedSlime$Thaumic_Arcana", "initClient", "", "mesher", "Lnet/minecraft/client/renderer/ItemModelMesher;", "Thaumic Arcana"}
   )
   public static final class Companion {
      @Nullable
      public final Item getEnchantModifier$Thaumic_Arcana() {
         return ClientProxy.enchantModifier;
      }

      public final void setEnchantModifier$Thaumic_Arcana(@Nullable Item var1) {
         ClientProxy.enchantModifier = var1;
      }

      @NotNull
      public final Item getInfusedSlime$Thaumic_Arcana() {
         return ClientProxy.access$getInfusedSlime$cp();
      }

      public final void setInfusedSlime$Thaumic_Arcana(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ClientProxy.infusedSlime = var1;
      }

      @NotNull
      public final Block getEssentia_mine$Thaumic_Arcana() {
         return ClientProxy.access$getEssentia_mine$cp();
      }

      public final void setEssentia_mine$Thaumic_Arcana(@NotNull Block var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ClientProxy.essentia_mine = var1;
      }

      @SideOnly(Side.CLIENT)
      public final void initClient(@NotNull ItemModelMesher mesher) {
         Intrinsics.checkParameterIsNotNull(mesher, "mesher");

         for(Item item : ItemRegistry.Companion.getItems()) {
            ModelResourceLocation model = new ModelResourceLocation(((ResourceLocation)Objects.requireNonNull(item.getRegistryName())).toString(), "inventory");
            ModelLoader.registerItemVariants(item, new ResourceLocation[]{(ResourceLocation)model});
            mesher.func_178086_a(item, 0, model);
         }

      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

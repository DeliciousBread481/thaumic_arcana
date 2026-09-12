package hu.frontrider.arcana.sided.client.rendering;

import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantCapability;
import hu.frontrider.arcana.client.rendering.CreatureEnchantOffsetManager;
import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EnchantingBaseCircle;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.commons.lang3.tuple.Triple;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003JM\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\"JH\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bH\u0016J\b\u0010$\u001a\u00020\u0018H\u0002J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020(H\u0002J\u0018\u0010)\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020(H\u0002J\u0006\u0010*\u001a\u00020\u0018J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-H\u0007J\b\u0010.\u001a\u00020/H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u00060"},
   d2 = {"Lhu/frontrider/arcana/sided/client/rendering/EnchantRenderer;", "Lnet/minecraft/client/renderer/entity/layers/LayerRenderer;", "Lnet/minecraft/entity/EntityLivingBase;", "()V", "cicle", "Lnet/minecraft/util/ResourceLocation;", "getCicle$Thaumic_Arcana", "()Lnet/minecraft/util/ResourceLocation;", "setCicle$Thaumic_Arcana", "(Lnet/minecraft/util/ResourceLocation;)V", "creatureEnchantOffsetManager", "Lhu/frontrider/arcana/client/rendering/CreatureEnchantOffsetManager;", "getCreatureEnchantOffsetManager$Thaumic_Arcana", "()Lhu/frontrider/arcana/client/rendering/CreatureEnchantOffsetManager;", "setCreatureEnchantOffsetManager$Thaumic_Arcana", "(Lhu/frontrider/arcana/client/rendering/CreatureEnchantOffsetManager;)V", "creatureEnchants", "Lnet/minecraftforge/registries/IForgeRegistry;", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "getCreatureEnchants$Thaumic_Arcana", "()Lnet/minecraftforge/registries/IForgeRegistry;", "setCreatureEnchants$Thaumic_Arcana", "(Lnet/minecraftforge/registries/IForgeRegistry;)V", "doRender", "", "entity", "limbSwing", "", "limbSwingAmount", "partialTicks", "ageInTicks", "netHeadYaw", "headPitch", "scale", "doRender$Thaumic_Arcana", "doRenderLayer", "drawIcon", "drawIcons", "textureManager", "Lnet/minecraft/client/renderer/texture/TextureManager;", "Lnet/minecraft/entity/Entity;", "drawMain", "reload", "renderFirstPerson", "event", "Lnet/minecraftforge/client/event/RenderWorldLastEvent;", "shouldCombineTextures", "", "Thaumic Arcana"}
)
public final class EnchantRenderer implements LayerRenderer<EntityLivingBase> {
   @NotNull
   private ResourceLocation cicle = new ResourceLocation("thaumic_arcana", "textures/cenchant/enchant_effect.png");
   @NotNull
   private IForgeRegistry<CreatureEnchant> creatureEnchants;
   @NotNull
   private CreatureEnchantOffsetManager creatureEnchantOffsetManager;

   @NotNull
   public final ResourceLocation getCicle$Thaumic_Arcana() {
      return this.cicle;
   }

   public final void setCicle$Thaumic_Arcana(@NotNull ResourceLocation var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.cicle = var1;
   }

   @NotNull
   public final IForgeRegistry<CreatureEnchant> getCreatureEnchants$Thaumic_Arcana() {
      return this.creatureEnchants;
   }

   public final void setCreatureEnchants$Thaumic_Arcana(@NotNull IForgeRegistry<CreatureEnchant> var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.creatureEnchants = var1;
   }

   @NotNull
   public final CreatureEnchantOffsetManager getCreatureEnchantOffsetManager$Thaumic_Arcana() {
      return this.creatureEnchantOffsetManager;
   }

   public final void setCreatureEnchantOffsetManager$Thaumic_Arcana(@NotNull CreatureEnchantOffsetManager var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.creatureEnchantOffsetManager = var1;
   }

   public void func_177141_a(@NotNull EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
      Intrinsics.checkParameterIsNotNull(entity, "entity");
      this.doRender$Thaumic_Arcana(entity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
   }

   @SubscribeEvent
   public final void renderFirstPerson(@NotNull RenderWorldLastEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityPlayerSP player = Minecraft.func_71410_x().field_71439_g;
      if (player != null) {
         int thirdPersonView = Minecraft.func_71410_x().field_71474_y.field_74320_O;
         if (thirdPersonView == 0) {
            GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
            this.doRender$Thaumic_Arcana((EntityLivingBase)player, player.field_184619_aG, player.field_70721_aZ, event.getPartialTicks(), (float)player.field_70173_aa, player.field_71109_bG, player.field_70726_aT, 1.0F);
            GlStateManager.func_179109_b(0.0F, 1.0F, 0.0F);
         }
      }

   }

   public final void doRender$Thaumic_Arcana(@NotNull EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
      Intrinsics.checkParameterIsNotNull(entity, "entity");
      boolean enchanted = CreatureEnchant.Companion.isEnchanted((Entity)entity);
      if (enchanted) {
         EntityEntry entry = EntityRegistry.getEntry(entity.getClass());
         GlStateManager.func_179094_E();
         String var14;
         if (entry != null) {
            ResourceLocation var10000 = entry.getRegistryName();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var14 = var10000.toString();
         } else {
            var14 = "";
         }

         Intrinsics.checkExpressionValueIsNotNull(var14, "when {\n                e…      else ->\"\"\n        }");
         String name = var14;
         Triple offset = this.creatureEnchantOffsetManager.getForEntity(name, entity);
         Object var15 = offset.getLeft();
         Intrinsics.checkExpressionValueIsNotNull(var15, "offset.left");
         float var16 = ((Number)var15).floatValue();
         Object var10001 = offset.getMiddle();
         Intrinsics.checkExpressionValueIsNotNull(var10001, "offset.middle");
         float var17 = ((Number)var10001).floatValue();
         Object var10002 = offset.getRight();
         Intrinsics.checkExpressionValueIsNotNull(var10002, "offset.right");
         GlStateManager.func_179109_b(var16, var17, ((Number)var10002).floatValue());
         GlStateManager.func_179114_b(180.0F, 0.0F, 1.0F, 1.0F);
         GlStateManager.func_179139_a(0.6, 0.6, 0.6);
         GlStateManager.func_179114_b(ageInTicks / 20.0F * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
         TextureManager renderEngine = Minecraft.func_71410_x().field_71446_o;
         GlStateManager.func_179129_p();
         GlStateManager.func_179140_f();
         Intrinsics.checkExpressionValueIsNotNull(renderEngine, "renderEngine");
         this.drawMain(renderEngine, (Entity)entity);
         GlStateManager.func_179137_b((double)0.0F, (double)0.0F, -0.1);
         this.drawIcons(renderEngine, (Entity)entity);
         GlStateManager.func_179137_b((double)0.0F, (double)0.0F, 0.1);
         GlStateManager.func_179109_b(-((Number)offset.getLeft()).floatValue(), -((Number)offset.getMiddle()).floatValue(), -((Number)offset.getRight()).floatValue());
         GlStateManager.func_179145_e();
         GlStateManager.func_179089_o();
         GlStateManager.func_179121_F();
      }
   }

   public boolean func_177142_b() {
      return false;
   }

   private final void drawMain(TextureManager textureManager, Entity entity) {
      EnchantingBaseCircle baseCircle = CreatureEnchant.Companion.getBaseCircle(entity);
      if (baseCircle == null) {
         Intrinsics.throwNpe();
      }

      EnchantingBaseCircle.Color color = baseCircle.getColor();
      textureManager.func_110577_a(this.cicle);
      GlStateManager.func_179124_c(color.getR(), color.getG(), color.getB());
      GlStateManager.func_187447_r(7);
      GlStateManager.func_187426_b(0.0F, 0.0F);
      GL11.glVertex3f(-2.0F, -2.0F, 0.0F);
      GlStateManager.func_187426_b(1.0F, 0.0F);
      GL11.glVertex3f(2.0F, -2.0F, 0.0F);
      GlStateManager.func_187426_b(1.0F, 1.0F);
      GL11.glVertex3f(2.0F, 2.0F, 0.0F);
      GlStateManager.func_187426_b(0.0F, 1.0F);
      GL11.glVertex3f(-2.0F, 2.0F, 0.0F);
      GlStateManager.func_187437_J();
      GlStateManager.func_179117_G();
   }

   private final void drawIcons(TextureManager textureManager, Entity entity) {
      Map creatureEnchants = CreatureEnchant.Companion.getCreatureEnchants(entity);
      Collection values = creatureEnchants.values();
      int index = 1;

      for(CreatureEnchantCapability.CreatureEnchantContainer var6 : values) {
         CreatureEnchant creatureEnchant = var6.component1();
         int level = var6.component2();
         textureManager.func_110577_a(creatureEnchant.getIcon());
         switch (level) {
            case 1:
               GlStateManager.func_179124_c(0.71F, 1.0F, 0.0F);
               break;
            case 2:
               GlStateManager.func_179124_c(1.0F, 0.49F, 0.49F);
               break;
            default:
               GlStateManager.func_179124_c(0.83F, 0.49F, 1.0F);
         }

         float x = (float)(Math.cos((double)(45 * index)) * 1.8);
         float y = (float)(Math.sin((double)(45 * index)) * 1.8);
         GlStateManager.func_179109_b(x, y, 0.0F);
         this.drawIcon();
         GlStateManager.func_179109_b(-x, -y, 0.0F);
         ++index;
      }

   }

   private final void drawIcon() {
      GL11.glBegin(7);
      GlStateManager.func_187426_b(0.0F, 0.0F);
      GL11.glVertex3f(-0.5F, -0.5F, 0.0F);
      GlStateManager.func_187426_b(1.0F, 0.0F);
      GL11.glVertex3f(0.5F, -0.5F, 0.0F);
      GlStateManager.func_187426_b(1.0F, 1.0F);
      GL11.glVertex3f(0.5F, 0.5F, 0.0F);
      GlStateManager.func_187426_b(0.0F, 1.0F);
      GL11.glVertex3f(-0.5F, 0.5F, 0.0F);
      GlStateManager.func_187437_J();
   }

   public final void reload() {
      this.creatureEnchantOffsetManager.loadConfigs();
   }

   public EnchantRenderer() {
      IForgeRegistry var10001 = GameRegistry.findRegistry(CreatureEnchant.class);
      Intrinsics.checkExpressionValueIsNotNull(var10001, "GameRegistry.findRegistr…atureEnchant::class.java)");
      this.creatureEnchants = var10001;
      this.creatureEnchantOffsetManager = new CreatureEnchantOffsetManager();
      this.creatureEnchantOffsetManager.loadConfigs();
   }
}

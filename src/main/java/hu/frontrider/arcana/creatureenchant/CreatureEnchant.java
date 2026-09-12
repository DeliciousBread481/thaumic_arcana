package hu.frontrider.arcana.creatureenchant;

import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantCapability;
import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantProvider;
import hu.frontrider.arcana.capabilities.creatureenchant.ICreatureEnchant;
import hu.frontrider.arcana.util.AspectUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.aspects.AspectList;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0000H\u0016J\u0006\u0010\u0014\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "Lnet/minecraftforge/registries/IForgeRegistryEntry$Impl;", "resourceLocation", "Lnet/minecraft/util/ResourceLocation;", "unlocalizedName", "", "(Lnet/minecraft/util/ResourceLocation;Ljava/lang/String;)V", "icon", "getIcon", "()Lnet/minecraft/util/ResourceLocation;", "research", "getResearch", "()Ljava/lang/String;", "formula", "Lthaumcraft/api/aspects/AspectList;", "getEnchantLevel", "", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "enchantment", "getUnlocalizedName", "toString", "Companion", "Thaumic Arcana"}
)
public abstract class CreatureEnchant extends IForgeRegistryEntry.Impl<CreatureEnchant> {
   @NotNull
   private final ResourceLocation icon;
   private final String unlocalizedName;
   @ObjectHolder("thaumic_arcana:normal")
   private static final EnchantingBaseCircle baseCircle;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @NotNull
   public final ResourceLocation getIcon() {
      return this.icon;
   }

   @NotNull
   public abstract String getResearch();

   @NotNull
   public final String getUnlocalizedName() {
      return "enchant.creature_enchant." + this.unlocalizedName;
   }

   public int getEnchantLevel(@NotNull EntityLivingBase entity, @NotNull CreatureEnchant enchantment) {
      Intrinsics.checkParameterIsNotNull(entity, "entity");
      Intrinsics.checkParameterIsNotNull(enchantment, "enchantment");
      if (entity.hasCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null)) {
         Object var10000 = entity.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var10000, "entity.getCapability(Cre…CHANT_CAPABILITY, null)!!");
         ICreatureEnchant capability = (ICreatureEnchant)var10000;
         int level = capability.getLevel(enchantment);
         if (capability.hasEnchant(enchantment)) {
            return capability.getCircle().doEffect(level, entity, enchantment);
         }
      }

      return 0;
   }

   @NotNull
   public abstract AspectList formula();

   @NotNull
   public String toString() {
      return "CreatureEnchant{, registryName=" + this.getRegistryName() + ", research='" + this.getResearch() + "'" + "}";
   }

   public CreatureEnchant(@NotNull ResourceLocation resourceLocation, @NotNull String unlocalizedName) {
      Intrinsics.checkParameterIsNotNull(resourceLocation, "resourceLocation");
      Intrinsics.checkParameterIsNotNull(unlocalizedName, "unlocalizedName");
      super();
      this.unlocalizedName = unlocalizedName;
      this.setRegistryName(resourceLocation);
      this.icon = new ResourceLocation(resourceLocation.func_110624_b(), "textures/cenchant/" + resourceLocation.func_110623_a() + ".png");
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"},
      d2 = {"Lhu/frontrider/arcana/creatureenchant/CreatureEnchant$Companion;", "", "()V", "baseCircle", "Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;", "getBaseCircle", "entity", "Lnet/minecraft/entity/Entity;", "getCreatureEnchants", "", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "Lhu/frontrider/arcana/capabilities/creatureenchant/CreatureEnchantCapability$CreatureEnchantContainer;", "getForFormula", "formula", "Lthaumcraft/api/aspects/AspectList;", "isEnchanted", "", "setEnchantment", "", "enchants", "Lhu/frontrider/arcana/capabilities/creatureenchant/ICreatureEnchant;", "Thaumic Arcana"}
   )
   public static final class Companion {
      public final void setEnchantment(@NotNull Entity entity, @NotNull ICreatureEnchant enchants) {
         Intrinsics.checkParameterIsNotNull(entity, "entity");
         Intrinsics.checkParameterIsNotNull(enchants, "enchants");
         if (entity.hasCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null)) {
            ICreatureEnchant capability = (ICreatureEnchant)entity.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
            if (capability == null) {
               Intrinsics.throwNpe();
            }

            capability.setStore(enchants.getStore());
            capability.setCircle(enchants.getCircle());
         }

      }

      public final boolean isEnchanted(@NotNull Entity entity) {
         Intrinsics.checkParameterIsNotNull(entity, "entity");
         if (entity.hasCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null)) {
            ICreatureEnchant capability = (ICreatureEnchant)entity.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
            if (capability == null) {
               Intrinsics.throwNpe();
            }

            return capability.hasEnchant();
         } else {
            return false;
         }
      }

      @NotNull
      public final Map<CreatureEnchant, CreatureEnchantCapability.CreatureEnchantContainer> getCreatureEnchants(@NotNull Entity entity) {
         Intrinsics.checkParameterIsNotNull(entity, "entity");
         if (entity.hasCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null)) {
            ICreatureEnchant capability = (ICreatureEnchant)entity.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
            if (capability == null) {
               Intrinsics.throwNpe();
            }

            return capability.getStore();
         } else {
            return MapsKt.emptyMap();
         }
      }

      @Nullable
      public final EnchantingBaseCircle getBaseCircle(@NotNull Entity entity) {
         Intrinsics.checkParameterIsNotNull(entity, "entity");
         if (entity.hasCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null)) {
            ICreatureEnchant capability = (ICreatureEnchant)entity.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
            if (capability == null) {
               Intrinsics.throwNpe();
            }

            return capability.getCircle();
         } else {
            return CreatureEnchant.baseCircle;
         }
      }

      @Nullable
      public final CreatureEnchant getForFormula(@NotNull AspectList formula) {
         Intrinsics.checkParameterIsNotNull(formula, "formula");
         IForgeRegistry var10000 = GameRegistry.findRegistry(CreatureEnchant.class);
         Intrinsics.checkExpressionValueIsNotNull(var10000, "GameRegistry.findRegistr…atureEnchant::class.java)");

         for(CreatureEnchant enchant : var10000.getValuesCollection()) {
            if (AspectUtil.INSTANCE.aspectListEquals(enchant.formula(), formula)) {
               return enchant;
            }
         }

         return null;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

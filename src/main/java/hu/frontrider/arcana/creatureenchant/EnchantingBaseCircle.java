package hu.frontrider.arcana.creatureenchant;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.AspectList;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0006\u0010\u0018\u001a\u00020\u0003R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001a"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;", "Lnet/minecraftforge/registries/IForgeRegistryEntry$Impl;", "unlocalizedName", "", "(Ljava/lang/String;)V", "color", "Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle$Color;", "getColor", "()Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle$Color;", "formula", "Lthaumcraft/api/aspects/AspectList;", "getFormula", "()Lthaumcraft/api/aspects/AspectList;", "research", "getResearch", "()Ljava/lang/String;", "getUnlocalizedName$Thaumic_Arcana", "doEffect", "", "multiplier", "entityLiving", "Lnet/minecraft/entity/EntityLivingBase;", "enchant", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "getUnlocalizedName", "Color", "Thaumic Arcana"}
)
public abstract class EnchantingBaseCircle extends IForgeRegistryEntry.Impl<EnchantingBaseCircle> {
   @NotNull
   private final String unlocalizedName;

   @NotNull
   public abstract Color getColor();

   @NotNull
   public abstract AspectList getFormula();

   @NotNull
   public abstract String getResearch();

   public abstract int doEffect(int var1, @NotNull EntityLivingBase var2, @NotNull CreatureEnchant var3);

   @NotNull
   public final String getUnlocalizedName() {
      return "enchant.modifier." + this.unlocalizedName;
   }

   @NotNull
   public final String getUnlocalizedName$Thaumic_Arcana() {
      return this.unlocalizedName;
   }

   protected EnchantingBaseCircle(@NotNull String unlocalizedName) {
      Intrinsics.checkParameterIsNotNull(unlocalizedName, "unlocalizedName");
      super();
      this.unlocalizedName = unlocalizedName;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R$\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0005\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR$\u0010\u0004\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR$\u0010\u0002\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006\u0014"},
      d2 = {"Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle$Color;", "", "r", "", "g", "b", "a", "(IIII)V", "<set-?>", "", "getA", "()F", "setA$Thaumic_Arcana", "(F)V", "getB", "setB$Thaumic_Arcana", "getG", "setG$Thaumic_Arcana", "getR", "setR$Thaumic_Arcana", "Thaumic Arcana"}
   )
   public static final class Color {
      private float r;
      private float g;
      private float b;
      private float a;

      public final float getR() {
         return this.r;
      }

      public final void setR$Thaumic_Arcana(float var1) {
         this.r = var1;
      }

      public final float getG() {
         return this.g;
      }

      public final void setG$Thaumic_Arcana(float var1) {
         this.g = var1;
      }

      public final float getB() {
         return this.b;
      }

      public final void setB$Thaumic_Arcana(float var1) {
         this.b = var1;
      }

      public final float getA() {
         return this.a;
      }

      public final void setA$Thaumic_Arcana(float var1) {
         this.a = var1;
      }

      public Color(int r, int g, int b, int a) {
         this.r = (float)(r / 255);
         this.g = (float)(g / 255);
         this.b = (float)(b / 255);
         this.a = (float)(a / 255);
      }
   }
}

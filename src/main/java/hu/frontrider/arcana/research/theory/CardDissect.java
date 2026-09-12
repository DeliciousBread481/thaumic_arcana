package hu.frontrider.arcana.research.theory;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.research.theorycraft.ResearchTableData;
import thaumcraft.api.research.theorycraft.TheorycraftCard;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u001c\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"},
   d2 = {"Lhu/frontrider/arcana/research/theory/CardDissect;", "Lthaumcraft/api/research/theorycraft/TheorycraftCard;", "()V", "itemStack", "Lnet/minecraft/item/ItemStack;", "activate", "", "entityPlayer", "Lnet/minecraft/entity/player/EntityPlayer;", "researchTableData", "Lthaumcraft/api/research/theorycraft/ResearchTableData;", "deserialize", "", "nbt", "Lnet/minecraft/nbt/NBTTagCompound;", "getInspirationCost", "", "getLocalizedName", "", "getLocalizedText", "getRequiredItems", "", "()[Lnet/minecraft/item/ItemStack;", "getRequiredItemsConsumed", "", "getResearchCategory", "initialize", "player", "data", "serialize", "Companion", "Thaumic Arcana"}
)
public final class CardDissect extends TheorycraftCard {
   private ItemStack itemStack;
   @Nullable
   private static ItemStack[] options;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public int getInspirationCost() {
      return 1;
   }

   public boolean initialize(@Nullable EntityPlayer player, @Nullable ResearchTableData data) {
      Random r = new Random(this.getSeed());
      ItemStack var10001 = options;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      ItemStack[] var10003 = options;
      if (var10003 == null) {
         Intrinsics.throwNpe();
      }

      var10001 = ((Object[])var10001)[r.nextInt(var10003.length)].func_77946_l();
      Intrinsics.checkExpressionValueIsNotNull(var10001, "options!![r.nextInt(options!!.size)].copy()");
      this.itemStack = var10001;
      return true;
   }

   @NotNull
   public boolean[] getRequiredItemsConsumed() {
      return new boolean[]{true, true};
   }

   @NotNull
   public ItemStack[] getRequiredItems() {
      return new ItemStack[]{new ItemStack(this.itemStack.func_77973_b(), 1)};
   }

   @NotNull
   public String getLocalizedName() {
      String var10000 = (new TextComponentTranslation("card.thaumic_arcana.study_flesh.name", new Object[]{TextFormatting.DARK_BLUE.toString() + this.itemStack.func_82833_r() + TextFormatting.RESET + "" + TextFormatting.BOLD})).func_150254_d();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "TextComponentTranslation…tting.BOLD).formattedText");
      return var10000;
   }

   @NotNull
   public String getLocalizedText() {
      String var10000 = (new TextComponentTranslation("card.thaumic_arcana.study_flesh.text", new Object[]{TextFormatting.DARK_BLUE.toString() + this.itemStack.func_82833_r() + TextFormatting.RESET})).func_150254_d();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "TextComponentTranslation…ting.RESET).formattedText");
      return var10000;
   }

   public boolean activate(@NotNull EntityPlayer entityPlayer, @NotNull ResearchTableData researchTableData) {
      Intrinsics.checkParameterIsNotNull(entityPlayer, "entityPlayer");
      Intrinsics.checkParameterIsNotNull(researchTableData, "researchTableData");
      researchTableData.addTotal(this.getResearchCategory(), 15);
      return true;
   }

   @NotNull
   public NBTTagCompound serialize() {
      NBTTagCompound nbt = super.serialize();
      Item var10002 = this.itemStack.func_77973_b();
      Intrinsics.checkExpressionValueIsNotNull(var10002, "this.itemStack.item");
      ResourceLocation var2 = var10002.getRegistryName();
      if (var2 == null) {
         Intrinsics.throwNpe();
      }

      nbt.func_74778_a("item", var2.toString());
      Intrinsics.checkExpressionValueIsNotNull(nbt, "nbt");
      return nbt;
   }

   public void deserialize(@Nullable NBTTagCompound nbt) {
      super.deserialize(nbt);
      RegistryNamespaced var10000 = Item.field_150901_e;
      ResourceLocation var10001 = new ResourceLocation;
      if (nbt == null) {
         Intrinsics.throwNpe();
      }

      var10001.<init>(nbt.func_74779_i("item"));
      Item item = (Item)var10000.func_82594_a(var10001);
      if (item == null) {
         item = Items.field_151082_bd;
      }

      ItemStack var3 = new ItemStack;
      if (item == null) {
         Intrinsics.throwNpe();
      }

      var3.<init>(item, 1);
      this.itemStack = var3;
   }

   @NotNull
   public String getResearchCategory() {
      return "BIOMANCY";
   }

   public CardDissect() {
      this.itemStack = new ItemStack(Items.field_151014_N);
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"},
      d2 = {"Lhu/frontrider/arcana/research/theory/CardDissect$Companion;", "", "()V", "options", "", "Lnet/minecraft/item/ItemStack;", "getOptions$Thaumic_Arcana", "()[Lnet/minecraft/item/ItemStack;", "setOptions$Thaumic_Arcana", "([Lnet/minecraft/item/ItemStack;)V", "[Lnet/minecraft/item/ItemStack;", "Thaumic Arcana"}
   )
   public static final class Companion {
      @Nullable
      public final ItemStack[] getOptions$Thaumic_Arcana() {
         return CardDissect.options;
      }

      public final void setOptions$Thaumic_Arcana(@Nullable ItemStack[] var1) {
         CardDissect.options = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

package hu.frontrider.arcana.items;

import hu.frontrider.arcana.ThaumicArcana;
import hu.frontrider.arcana.util.Initialisable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagEnd;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005¢\u0006\u0002\u0010\u0003J6\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001f\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0017\"\u00020\u0006¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dH\u0017J\b\u0010\u001e\u001a\u00020\fH\u0016JR\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006."},
   d2 = {"Lhu/frontrider/arcana/items/ItemPlantBall;", "Lhu/frontrider/arcana/items/ItemBase;", "Lhu/frontrider/arcana/util/Initialisable;", "()V", "seedVariants", "", "Lnet/minecraft/item/ItemStack;", "getSeedVariants", "()Ljava/util/List;", "treeVariants", "getTreeVariants", "addInformation", "", "stack", "worldIn", "Lnet/minecraft/world/World;", "tooltip", "", "", "flagIn", "Lnet/minecraft/client/util/ITooltipFlag;", "getBallFor", "stacks", "", "([Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;", "getSubItems", "tab", "Lnet/minecraft/creativetab/CreativeTabs;", "items", "Lnet/minecraft/util/NonNullList;", "init", "onItemUse", "Lnet/minecraft/util/EnumActionResult;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "pos", "Lnet/minecraft/util/math/BlockPos;", "hand", "Lnet/minecraft/util/EnumHand;", "facing", "Lnet/minecraft/util/EnumFacing;", "hitX", "", "hitY", "hitZ", "Companion", "Thaumic Arcana"}
)
public final class ItemPlantBall extends ItemBase implements Initialisable {
   @Nullable
   private static List<ItemStack> treeItems;
   @Nullable
   private static List<ItemStack> seedItems;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @NotNull
   public final List<ItemStack> getTreeVariants() {
      ArrayList items = new ArrayList();
      ItemPlantBall $receiver = this;
      int meta = 0;
      Item sapling = (Item)Item.field_150901_e.func_82594_a(new ResourceLocation("minecraft:sapling"));
      Item log = (Item)Item.field_150901_e.func_82594_a(new ResourceLocation("minecraft:log"));

      Item log2;
      for(log2 = (Item)Item.field_150901_e.func_82594_a(new ResourceLocation("minecraft:log2")); meta < 4; ++meta) {
         ItemStack[] var10002 = new ItemStack[2];
         ItemStack var10005 = new ItemStack;
         if (sapling == null) {
            Intrinsics.throwNpe();
         }

         var10005.<init>(sapling, 2, meta);
         var10002[0] = var10005;
         var10005 = new ItemStack;
         if (log == null) {
            Intrinsics.throwNpe();
         }

         var10005.<init>(log, 5, meta);
         var10002[1] = var10005;
         items.add($receiver.getBallFor(var10002));
      }

      for(int var9 = 0; var9 < 2; ++var9) {
         ItemStack[] var10 = new ItemStack[2];
         ItemStack var12 = new ItemStack;
         if (sapling == null) {
            Intrinsics.throwNpe();
         }

         var12.<init>(sapling, 2, var9 + 4);
         var10[0] = var12;
         var12 = new ItemStack;
         if (log2 == null) {
            Intrinsics.throwNpe();
         }

         var12.<init>(log2, 5, var9);
         var10[1] = var12;
         items.add($receiver.getBallFor(var10));
      }

      return (List)items;
   }

   @NotNull
   public final List<ItemStack> getSeedVariants() {
      ArrayList items = new ArrayList();
      items.add(this.getBallFor(new ItemStack(Items.field_151014_N, 2), new ItemStack(Items.field_151015_O, 6)));
      items.add(this.getBallFor(new ItemStack(Items.field_185163_cU, 2), new ItemStack(Items.field_185164_cV, 3)));
      return (List)items;
   }

   @NotNull
   public final ItemStack getBallFor(@NotNull ItemStack... stacks) {
      Intrinsics.checkParameterIsNotNull(stacks, "stacks");
      ItemStack itemStack = new ItemStack(this);
      NBTTagCompound nbtTagCompound = new NBTTagCompound();
      NBTTagList tagList = new NBTTagList();
      ItemStack[] var6 = stacks;
      Collection destination$iv$iv = (Collection)(new ArrayList(stacks.length));

      for(Object item$iv$iv : stacks) {
         Item var10000 = ((ItemStack)item$iv$iv).func_77973_b();
         Intrinsics.checkExpressionValueIsNotNull(var10000, "stack.item");
         ResourceLocation var24 = var10000.getRegistryName();
         if (var24 == null) {
            Intrinsics.throwNpe();
         }

         String var25 = var24.toString();
         Intrinsics.checkExpressionValueIsNotNull(var25, "stack.item.registryName!!.toString()");
         String regname = var25;
         int metadata = ((ItemStack)item$iv$iv).func_77960_j();
         int count = ((ItemStack)item$iv$iv).func_190916_E();
         NBTTagCompound tagCompound = new NBTTagCompound();
         tagCompound.func_74778_a("item", regname);
         tagCompound.func_74768_a("count", count);
         tagCompound.func_74768_a("meta", metadata);
         destination$iv$iv.add(tagCompound);
      }

      for(Object element$iv : (Iterable)((List)destination$iv$iv)) {
         NBTTagCompound it = (NBTTagCompound)element$iv;
         tagList.func_74742_a((NBTBase)it);
      }

      nbtTagCompound.func_74782_a("products", (NBTBase)tagList);
      itemStack.func_77982_d(nbtTagCompound);
      return itemStack;
   }

   public void func_77624_a(@Nullable ItemStack stack, @Nullable World worldIn, @Nullable final List<String> tooltip, @Nullable ITooltipFlag flagIn) {
      super.func_77624_a(stack, worldIn, tooltip, flagIn);
      if (stack == null) {
         Intrinsics.throwNpe();
      }

      if (stack.func_77978_p() != null) {
         NBTTagCompound tagCompound = stack.func_77978_p();
         if (tagCompound == null) {
            Intrinsics.throwNpe();
         }

         NBTBase var10000 = tagCompound.func_74781_a("products");
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagList");
         } else {
            NBTTagList products = (NBTTagList)var10000;
            if (tooltip == null) {
               Intrinsics.throwNpe();
            }

            String var10001 = I18n.func_135052_a("item.thaumic_arcana.plant_ball.contains", new Object[0]);
            Intrinsics.checkExpressionValueIsNotNull(var10001, "I18n.format(\"item.thaumi…ana.plant_ball.contains\")");
            tooltip.add(var10001);
            products.iterator().forEachRemaining(new Consumer<NBTBase>() {
               public final void accept(NBTBase item) {
                  if (item == null) {
                     throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
                  } else {
                     String regname = ((NBTTagCompound)item).func_74779_i("item");
                     int count = ((NBTTagCompound)item).func_74762_e("count");
                     int meta = ((NBTTagCompound)item).func_74762_e("meta");
                     ResourceLocation resourcelocation = new ResourceLocation(regname);
                     Item itemObj = (Item)Item.field_150901_e.func_82594_a(resourcelocation);
                     StringBuilder var10000 = (new StringBuilder()).append(" - ").append(TextFormatting.GREEN);
                     ItemStack var10001 = new ItemStack;
                     if (itemObj == null) {
                        Intrinsics.throwNpe();
                     }

                     var10001.<init>(itemObj, 1, meta);
                     String lore = var10000.append(var10001.func_82833_r()).append(" ").append(TextFormatting.RESET).append(count).toString();
                     tooltip.add(lore);
                  }
               }
            });
         }
      }
   }

   @NotNull
   public EnumActionResult func_180614_a(@Nullable final EntityPlayer player, @Nullable final World worldIn, @Nullable BlockPos pos, @Nullable EnumHand hand, @Nullable EnumFacing facing, float hitX, float hitY, float hitZ) {
      if (player == null) {
         Intrinsics.throwNpe();
      }

      ItemStack heldItem = player.func_184586_b(hand);
      Intrinsics.checkExpressionValueIsNotNull(heldItem, "heldItem");
      NBTTagCompound tagCompound = heldItem.func_77978_p();
      if (tagCompound == null) {
         Intrinsics.throwNpe();
      }

      NBTBase var10000 = tagCompound.func_74781_a("products");
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagList");
      } else {
         NBTTagList products = (NBTTagList)var10000;
         products.iterator().forEachRemaining(new Consumer<NBTBase>() {
            public final void accept(NBTBase item) {
               if (item == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
               } else {
                  String regName = ((NBTTagCompound)item).func_74779_i("item");
                  int count = ((NBTTagCompound)item).func_74762_e("count");
                  int meta = ((NBTTagCompound)item).func_74762_e("meta");
                  ResourceLocation resourcelocation = new ResourceLocation(regName);
                  Item itemObj = (Item)Item.field_150901_e.func_82594_a(resourcelocation);
                  ItemStack var10000 = new ItemStack;
                  if (itemObj == null) {
                     Intrinsics.throwNpe();
                  }

                  var10000.<init>(itemObj, count, meta);
                  ItemStack itemStack = var10000;
                  if (!player.func_191521_c(itemStack)) {
                     EntityItem var9 = new EntityItem;
                     World var10002 = worldIn;
                     if (var10002 == null) {
                        Intrinsics.throwNpe();
                     }

                     var9.<init>(var10002);
                     EntityItem entityItem = var9;
                     entityItem.func_92058_a(itemStack);
                     entityItem.field_70165_t = player.field_70165_t;
                     entityItem.field_70163_u = player.field_70163_u;
                     entityItem.field_70161_v = player.field_70161_v;
                     worldIn.func_72838_d((Entity)entityItem);
                  }

               }
            }
         });
         heldItem.func_190918_g(1);
         return EnumActionResult.SUCCESS;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_150895_a(@NotNull CreativeTabs tab, @NotNull NonNullList<ItemStack> items) {
      Intrinsics.checkParameterIsNotNull(tab, "tab");
      Intrinsics.checkParameterIsNotNull(items, "items");
      if (tab == ThaumicArcana.INSTANCE.getTABARCANA() && !(Intrinsics.areEqual(tab, CreativeTabs.field_78027_g) ^ true)) {
         if (treeItems != null) {
            List var10001 = treeItems;
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            items.addAll((Collection)var10001);
         }

         if (seedItems != null) {
            List var3 = seedItems;
            if (var3 == null) {
               Intrinsics.throwNpe();
            }

            items.addAll((Collection)var3);
         }

      }
   }

   public void init() {
      treeItems = this.getTreeVariants();
      seedItems = this.getSeedVariants();
   }

   public ItemPlantBall() {
      super(new ResourceLocation("thaumic_arcana", "plant_ball"));
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011R4\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR4\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0012"},
      d2 = {"Lhu/frontrider/arcana/items/ItemPlantBall$Companion;", "", "()V", "<set-?>", "", "Lnet/minecraft/item/ItemStack;", "seedItems", "getSeedItems", "()Ljava/util/List;", "setSeedItems", "(Ljava/util/List;)V", "treeItems", "getTreeItems", "setTreeItems", "getProductByIndex", "itemStack", "index", "", "Thaumic Arcana"}
   )
   public static final class Companion {
      @Nullable
      public final List<ItemStack> getTreeItems() {
         return ItemPlantBall.treeItems;
      }

      private final void setTreeItems(List<ItemStack> var1) {
         ItemPlantBall.treeItems = var1;
      }

      @Nullable
      public final List<ItemStack> getSeedItems() {
         return ItemPlantBall.seedItems;
      }

      private final void setSeedItems(List<ItemStack> var1) {
         ItemPlantBall.seedItems = var1;
      }

      @NotNull
      public final ItemStack getProductByIndex(@NotNull ItemStack itemStack, int index) {
         Intrinsics.checkParameterIsNotNull(itemStack, "itemStack");
         NBTTagCompound tagCompound = itemStack.func_77978_p();
         if (tagCompound == null) {
            Intrinsics.throwNpe();
         }

         NBTBase var10000 = tagCompound.func_74781_a("products");
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagList");
         } else {
            NBTTagList products = (NBTTagList)var10000;
            NBTBase item = products.func_179238_g(index);
            if (item instanceof NBTTagEnd) {
               return new ItemStack(Items.field_190931_a);
            } else if (item == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
            } else {
               String regName = ((NBTTagCompound)item).func_74779_i("item");
               int count = ((NBTTagCompound)item).func_74762_e("count");
               int meta = ((NBTTagCompound)item).func_74762_e("meta");
               ResourceLocation resourcelocation = new ResourceLocation(regName);
               Item itemObj = (Item)Item.field_150901_e.func_82594_a(resourcelocation);
               ItemStack var11 = new ItemStack;
               if (itemObj == null) {
                  Intrinsics.throwNpe();
               }

               var11.<init>(itemObj, count, meta);
               return var11;
            }
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

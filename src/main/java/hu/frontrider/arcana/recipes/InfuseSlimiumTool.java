package hu.frontrider.arcana.recipes;

import hu.frontrider.arcana.items.armor.SlimuimArmorKt;
import hu.frontrider.arcana.items.tools.InfusedSlimiumKt;
import hu.frontrider.arcana.util.IInfuseable;
import hu.frontrider.arcana.util.IInfusedArmor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IArcaneRecipe;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u001a\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\tH\u0016R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\""},
   d2 = {"Lhu/frontrider/arcana/recipes/InfuseSlimiumTool;", "Lthaumcraft/api/crafting/IArcaneRecipe;", "()V", "aspects", "Lthaumcraft/api/aspects/AspectList;", "kotlin.jvm.PlatformType", "getAspects", "()Lthaumcraft/api/aspects/AspectList;", "resourceLocation", "Lnet/minecraft/util/ResourceLocation;", "canFit", "", "width", "", "height", "getCraftingResult", "Lnet/minecraft/item/ItemStack;", "inv", "Lnet/minecraft/inventory/InventoryCrafting;", "getCrystals", "getRecipeOutput", "getRegistryName", "getRegistryType", "Ljava/lang/Class;", "Lnet/minecraft/item/crafting/IRecipe;", "getResearch", "", "getVis", "isDynamic", "matches", "worldIn", "Lnet/minecraft/world/World;", "setRegistryName", "name", "Thaumic Arcana"}
)
public final class InfuseSlimiumTool implements IArcaneRecipe {
   private ResourceLocation resourceLocation;
   private final AspectList aspects;

   public final AspectList getAspects() {
      return this.aspects;
   }

   @NotNull
   public String getResearch() {
      return "TA_INFUSED_SLIME_TOOL";
   }

   public boolean func_194133_a(int width, int height) {
      return width > 1 || height > 1;
   }

   @NotNull
   public Class<IRecipe> getRegistryType() {
      return IRecipe.class;
   }

   @NotNull
   public AspectList getCrystals() {
      AspectList var10000 = this.aspects;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "aspects");
      return var10000;
   }

   @NotNull
   public ItemStack func_77571_b() {
      ItemStack var10000 = ItemStack.field_190927_a;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "ItemStack.EMPTY");
      return var10000;
   }

   @Nullable
   public ResourceLocation getRegistryName() {
      ResourceLocation var10000 = this.resourceLocation;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("resourceLocation");
      }

      return var10000;
   }

   public int getVis() {
      return 20;
   }

   public boolean func_192399_d() {
      return true;
   }

   @NotNull
   public ItemStack func_77572_b(@NotNull InventoryCrafting inv) {
      Intrinsics.checkParameterIsNotNull(inv, "inv");
      ArrayList items = new ArrayList();
      int i = 0;

      for(int var4 = inv.func_70302_i_(); i < var4; ++i) {
         items.add(inv.func_70301_a(i));
      }

      Iterable $receiver$iv = (Iterable)items;
      Iterator var5 = $receiver$iv.iterator();

      Object var10000;
      while(true) {
         if (var5.hasNext()) {
            Object element$iv = var5.next();
            ItemStack it = (ItemStack)element$iv;
            if (!Intrinsics.areEqual(it.func_77973_b(), Items.field_151068_bn)) {
               continue;
            }

            var10000 = element$iv;
            break;
         }

         var10000 = null;
         break;
      }

      ItemStack var21 = (ItemStack)var10000;
      if ((ItemStack)var10000 == null) {
         var21 = ItemStack.field_190927_a;
         Intrinsics.checkExpressionValueIsNotNull(var21, "ItemStack.EMPTY");
         return var21;
      } else {
         ItemStack potion = var21;
         Iterable $receiver$iv = (Iterable)items;
         Iterator copy = $receiver$iv.iterator();

         while(true) {
            if (copy.hasNext()) {
               Object element$iv = copy.next();
               ItemStack it = (ItemStack)element$iv;
               if (!(it.func_77973_b() instanceof IInfuseable)) {
                  continue;
               }

               var22 = element$iv;
               break;
            }

            var22 = null;
            break;
         }

         var21 = (ItemStack)var22;
         if ((ItemStack)var22 != null) {
            ItemStack tool = var21;
            List effectsFromStack = PotionUtils.func_185189_a(potion);
            ItemStack copy = tool.func_77946_l();
            if (tool.func_77973_b() instanceof IInfusedArmor) {
               Intrinsics.checkExpressionValueIsNotNull(effectsFromStack, "effectsFromStack");
               Collection $receiver$iv = (Collection)effectsFromStack;
               if ($receiver$iv == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
               }

               PotionEffect[] var25 = $receiver$iv.toArray(new PotionEffect[0]);
               if (var25 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
               }

               var25 = var25;
               Intrinsics.checkExpressionValueIsNotNull(copy, "copy");
               var21 = SlimuimArmorKt.makeInfusedArmor(var25, copy);
            } else {
               Intrinsics.checkExpressionValueIsNotNull(effectsFromStack, "effectsFromStack");
               Collection $receiver$iv = (Collection)effectsFromStack;
               if ($receiver$iv == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
               }

               PotionEffect[] var28 = $receiver$iv.toArray(new PotionEffect[0]);
               if (var28 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
               }

               var28 = var28;
               Intrinsics.checkExpressionValueIsNotNull(copy, "copy");
               var21 = InfusedSlimiumKt.makeInfusedTool(var28, copy);
            }

            return var21;
         } else {
            var21 = ItemStack.field_190927_a;
            Intrinsics.checkExpressionValueIsNotNull(var21, "ItemStack.EMPTY");
            return var21;
         }
      }
   }

   @NotNull
   public IRecipe setRegistryName(@Nullable ResourceLocation name) {
      ResourceLocation var10001 = name;
      if (name == null) {
         var10001 = this.resourceLocation;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceLocation");
         }
      }

      this.resourceLocation = var10001;
      return (IRecipe)this;
   }

   public boolean func_77569_a(@NotNull InventoryCrafting inv, @Nullable World worldIn) {
      Intrinsics.checkParameterIsNotNull(inv, "inv");
      ArrayList items = new ArrayList();
      int i = 0;

      for(byte var5 = 8; i <= var5; ++i) {
         ItemStack stackInSlot = inv.func_70301_a(i);
         Intrinsics.checkExpressionValueIsNotNull(stackInSlot, "stackInSlot");
         if (!stackInSlot.func_190926_b()) {
            items.add(stackInSlot);
         }
      }

      if (items.size() != 2) {
         return false;
      } else {
         Iterable $receiver$iv = (Iterable)items;
         Iterator var14 = $receiver$iv.iterator();

         Object var10000;
         while(true) {
            if (var14.hasNext()) {
               Object element$iv = var14.next();
               ItemStack it = (ItemStack)element$iv;
               if (!Intrinsics.areEqual(it.func_77973_b(), Items.field_151068_bn)) {
                  continue;
               }

               var10000 = element$iv;
               break;
            }

            var10000 = null;
            break;
         }

         ItemStack var18 = (ItemStack)var10000;
         if ((ItemStack)var10000 == null) {
            return false;
         } else {
            ItemStack potion = var18;
            if (!potion.func_77942_o()) {
               return false;
            } else {
               NBTTagCompound var19 = potion.func_77978_p();
               if (var19 == null) {
                  Intrinsics.throwNpe();
               }

               if (Intrinsics.areEqual(var19.func_74779_i("Potion"), "minecraft:thick") ^ true) {
                  return false;
               } else {
                  $receiver$iv = (Iterable)items;
                  var14 = $receiver$iv.iterator();

                  while(true) {
                     if (var14.hasNext()) {
                        Object element$iv = var14.next();
                        ItemStack it = (ItemStack)element$iv;
                        if (!(it.func_77973_b() instanceof IInfuseable)) {
                           continue;
                        }

                        var20 = element$iv;
                        break;
                     }

                     var20 = null;
                     break;
                  }

                  return (ItemStack)var20 != null;
               }
            }
         }
      }
   }

   public InfuseSlimiumTool() {
      this.aspects = (new AspectList()).merge(Aspect.WATER, 1).merge(Aspect.EARTH, 1);
   }
}

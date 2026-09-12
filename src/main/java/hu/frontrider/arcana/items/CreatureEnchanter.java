package hu.frontrider.arcana.items;

import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantProvider;
import hu.frontrider.arcana.capabilities.creatureenchant.ICreatureEnchant;
import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.registrationhandlers.ItemRegistry;
import hu.frontrider.arcana.sided.network.creatureenchants.CreatureEnchantSyncMessage;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.aura.AuraHelper;
import thaumcraft.api.items.ItemsTC;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0002'(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0016J0\u0010\u0018\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016JR\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00152\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"},
   d2 = {"Lhu/frontrider/arcana/items/CreatureEnchanter;", "Lhu/frontrider/arcana/items/ItemBase;", "networkWrapper", "Lnet/minecraftforge/fml/common/network/simpleimpl/SimpleNetworkWrapper;", "(Lnet/minecraftforge/fml/common/network/simpleimpl/SimpleNetworkWrapper;)V", "addInformation", "", "stack", "Lnet/minecraft/item/ItemStack;", "worldIn", "Lnet/minecraft/world/World;", "tooltip", "", "", "flagIn", "Lnet/minecraft/client/util/ITooltipFlag;", "applyEntity", "", "entity", "Lnet/minecraft/entity/Entity;", "playerIn", "Lnet/minecraft/entity/player/EntityPlayer;", "hasEffect", "isEnchantable", "itemInteractionForEntity", "Lnet/minecraft/entity/EntityLivingBase;", "hand", "Lnet/minecraft/util/EnumHand;", "onItemUse", "Lnet/minecraft/util/EnumActionResult;", "player", "pos", "Lnet/minecraft/util/math/BlockPos;", "facing", "Lnet/minecraft/util/EnumFacing;", "hitX", "", "hitY", "hitZ", "Companion", "EnchantmentData", "Thaumic Arcana"}
)
public final class CreatureEnchanter extends ItemBase {
   private final SimpleNetworkWrapper networkWrapper;
   @ObjectHolder("thaumcraft:warpward")
   @Nullable
   private static final Potion warpWard;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public final boolean applyEntity(@Nullable final Entity entity, @Nullable final EntityPlayer playerIn, @Nullable final ItemStack stack) {
      if (stack == null) {
         Intrinsics.throwNpe();
      }

      NBTTagCompound var10000 = stack.func_77978_p();
      if (var10000 != null) {
         Intrinsics.checkExpressionValueIsNotNull(var10000, "stack!!.tagCompound ?: return false");
         NBTTagCompound tagCompound = var10000;
         if (!tagCompound.func_74764_b("creature_enchants")) {
            return false;
         } else {
            if (entity == null) {
               Intrinsics.throwNpe();
            }

            if (entity.hasCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null)) {
               if (playerIn == null) {
                  Intrinsics.throwNpe();
               }

               if (!playerIn.func_130014_f_().field_72995_K) {
                  ICreatureEnchant var7 = (ICreatureEnchant)entity.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
                  if (var7 == null) {
                     return false;
                  }

                  Intrinsics.checkExpressionValueIsNotNull(var7, "entity.getCapability(Cre…TY, null) ?: return false");
                  final ICreatureEnchant capability = var7;
                  NBTBase creature_enchants = tagCompound.func_74781_a("creature_enchants");
                  if (creature_enchants == null) {
                     throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagList");
                  }

                  ((NBTTagList)creature_enchants).iterator().forEachRemaining(new Consumer<NBTBase>() {
                     public final void accept(NBTBase enchant) {
                        if (capability.getStore().size() <= 6 && AuraHelper.drainVis(entity.field_70170_p, entity.func_180425_c(), 30.0F, true) >= (float)30) {
                           AuraHelper.drainVis(entity.field_70170_p, entity.func_180425_c(), 30.0F, false);
                           Companion var10000 = CreatureEnchanter.Companion;
                           if (enchant == null) {
                              throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
                           }

                           EnchantmentData enchantmentData = var10000.nbtToEnchantment$Thaumic_Arcana((NBTTagCompound)enchant);
                           capability.removeEnchant(enchantmentData.getEnchantment());
                           AuraHelper.polluteAura(entity.func_130014_f_(), entity.func_180425_c(), 5.0F, true);
                           if (entity instanceof EntityPlayer) {
                              AuraHelper.polluteAura(((EntityPlayer)entity).func_130014_f_(), ((EntityPlayer)entity).func_180425_c(), 20.0F, true);
                           }

                           stack.func_190918_g(1);
                           int entityId = entity.func_145782_y();
                           CreatureEnchanter.this.networkWrapper.sendTo(new CreatureEnchantSyncMessage(capability, entityId), (EntityPlayerMP)playerIn);
                        }

                     }
                  });
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   public boolean func_111207_a(@Nullable ItemStack stack, @Nullable EntityPlayer playerIn, @Nullable EntityLivingBase entity, @Nullable EnumHand hand) {
      return this.applyEntity((Entity)entity, playerIn, stack);
   }

   @NotNull
   public EnumActionResult func_180614_a(@Nullable EntityPlayer player, @Nullable World worldIn, @Nullable BlockPos pos, @Nullable EnumHand hand, @Nullable EnumFacing facing, float hitX, float hitY, float hitZ) {
      if (player == null) {
         Intrinsics.throwNpe();
      }

      ItemStack stack = player.func_184614_ca();
      ItemStack gauntlet = player.func_184592_cb();
      if (worldIn == null) {
         Intrinsics.throwNpe();
      }

      if (pos == null) {
         Intrinsics.throwNpe();
      }

      IBlockState blockState = worldIn.func_180495_p(pos);
      Intrinsics.checkExpressionValueIsNotNull(blockState, "blockState");
      EnumActionResult var10000;
      if (blockState.func_177230_c() == Blocks.field_150381_bn) {
         Intrinsics.checkExpressionValueIsNotNull(gauntlet, "gauntlet");
         if (Intrinsics.areEqual(gauntlet.func_77973_b(), ItemsTC.casterBasic)) {
            Potion var10001 = warpWard;
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            if (player.func_70660_b(var10001) != null) {
               var10000 = this.applyEntity((Entity)player, player, stack) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
               return var10000;
            }
         }
      }

      var10000 = EnumActionResult.FAIL;
      return var10000;
   }

   public boolean func_77616_k(@NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      return false;
   }

   public void func_77624_a(@Nullable ItemStack stack, @Nullable World worldIn, @Nullable final List<String> tooltip, @Nullable ITooltipFlag flagIn) {
      if (stack == null) {
         Intrinsics.throwNpe();
      }

      NBTTagCompound tagCompound = stack.func_77978_p();
      if (tagCompound != null && tagCompound.func_74764_b("creature_enchants")) {
         NBTBase var10000 = tagCompound.func_74781_a("creature_enchants");
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagList");
         }

         NBTTagList creature_enchants = (NBTTagList)var10000;
         creature_enchants.iterator().forEachRemaining(new Consumer<NBTBase>() {
            public final void accept(NBTBase enchant) {
               if (enchant == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
               } else {
                  String name = ((NBTTagCompound)enchant).func_74779_i("name");
                  int level = ((NBTTagCompound)enchant).func_74762_e("level");
                  List var10000 = tooltip;
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  List var10;
                  StringBuilder var11;
                  StringBuilder var12;
                  label42: {
                     StringBuilder var10001 = new StringBuilder();
                     StringBuilder var10002 = (new StringBuilder()).append("enchant.creature_enchant.");
                     Intrinsics.checkExpressionValueIsNotNull(name, "name");
                     CharSequence thisCollection$iv = (CharSequence)name;
                     String var5 = ":";
                     var12 = var10002;
                     var11 = var10001;
                     var10 = var10000;
                     Regex var13 = new Regex(var5);
                     byte var6 = 0;
                     List var18 = var13.split(thisCollection$iv, var6);
                     if (!var18.isEmpty()) {
                        ListIterator iterator$iv = var18.listIterator(var18.size());

                        while(iterator$iv.hasPrevious()) {
                           String it = (String)iterator$iv.previous();
                           CharSequence var7 = (CharSequence)it;
                           if (var7.length() != 0) {
                              var10000 = CollectionsKt.take((Iterable)var18, iterator$iv.nextIndex() + 1);
                              break label42;
                           }
                        }
                     }

                     var10000 = CollectionsKt.emptyList();
                  }

                  List var19 = var10000;
                  Collection $receiver$iv = (Collection)var19;
                  if ($receiver$iv == null) {
                     throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                  } else {
                     String var23 = $receiver$iv.toArray(new String[0]);
                     if (var23 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                     } else {
                        String var20 = var23;
                        String thisCollection$iv = ((String[])var20)[1];
                        if (thisCollection$iv == null) {
                           throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        } else {
                           var23 = thisCollection$iv.toLowerCase();
                           Intrinsics.checkExpressionValueIsNotNull(var23, "(this as java.lang.String).toLowerCase()");
                           var20 = var23;
                           var10.add(var11.append(I18n.func_135052_a(var12.append(var20).toString(), new Object[0])).append(" ").append(level).toString());
                        }
                     }
                  }
               }
            }
         });
      }

   }

   @SideOnly(Side.CLIENT)
   public boolean func_77636_d(@NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      NBTTagCompound tagCompound = stack.func_77978_p();
      return tagCompound != null && tagCompound.func_74764_b("creature_enchants");
   }

   public CreatureEnchanter(@NotNull SimpleNetworkWrapper networkWrapper) {
      Intrinsics.checkParameterIsNotNull(networkWrapper, "networkWrapper");
      super(new ResourceLocation("thaumic_arcana", "creature_enchanter"));
      this.networkWrapper = networkWrapper;
      this.func_77625_d(1);
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"},
      d2 = {"Lhu/frontrider/arcana/items/CreatureEnchanter$EnchantmentData;", "", "enchantment", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "level", "", "(Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;I)V", "getEnchantment", "()Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "getLevel", "()I", "Thaumic Arcana"}
   )
   public static final class EnchantmentData {
      @NotNull
      private final CreatureEnchant enchantment;
      private final int level;

      @NotNull
      public final CreatureEnchant getEnchantment() {
         return this.enchantment;
      }

      public final int getLevel() {
         return this.level;
      }

      public EnchantmentData(@NotNull CreatureEnchant enchantment, int level) {
         Intrinsics.checkParameterIsNotNull(enchantment, "enchantment");
         super();
         this.enchantment = enchantment;
         this.level = level;
      }
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0002\u0010\fJ'\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"},
      d2 = {"Lhu/frontrider/arcana/items/CreatureEnchanter$Companion;", "", "()V", "warpWard", "Lnet/minecraft/potion/Potion;", "getWarpWard", "()Lnet/minecraft/potion/Potion;", "createEnchantedItem", "Lnet/minecraft/item/ItemStack;", "enchantmentDatas", "", "Lhu/frontrider/arcana/items/CreatureEnchanter$EnchantmentData;", "([Lhu/frontrider/arcana/items/CreatureEnchanter$EnchantmentData;)Lnet/minecraft/item/ItemStack;", "baseItem", "Lnet/minecraft/item/Item;", "(Lnet/minecraft/item/Item;[Lhu/frontrider/arcana/items/CreatureEnchanter$EnchantmentData;)Lnet/minecraft/item/ItemStack;", "nbtToEnchantment", "nbt", "Lnet/minecraft/nbt/NBTTagCompound;", "nbtToEnchantment$Thaumic_Arcana", "Thaumic Arcana"}
   )
   public static final class Companion {
      @Nullable
      public final Potion getWarpWard() {
         return CreatureEnchanter.warpWard;
      }

      @NotNull
      public final ItemStack createEnchantedItem(@NotNull Item baseItem, @NotNull EnchantmentData... enchantmentDatas) {
         Intrinsics.checkParameterIsNotNull(baseItem, "baseItem");
         Intrinsics.checkParameterIsNotNull(enchantmentDatas, "enchantmentDatas");
         ItemStack enchanter = new ItemStack(baseItem, 1);
         NBTTagList tagList = new NBTTagList();

         for(EnchantmentData enchantmentData : enchantmentDatas) {
            NBTTagCompound enchantmentTag = new NBTTagCompound();
            ResourceLocation var10002 = enchantmentData.getEnchantment().getRegistryName();
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            enchantmentTag.func_74778_a("name", var10002.toString());
            enchantmentTag.func_74768_a("level", enchantmentData.getLevel());
            tagList.func_74742_a((NBTBase)enchantmentTag);
         }

         NBTTagCompound compound = new NBTTagCompound();
         compound.func_74782_a("creature_enchants", (NBTBase)tagList);
         enchanter.func_77982_d(compound);
         return enchanter;
      }

      @NotNull
      public final ItemStack createEnchantedItem(@NotNull EnchantmentData... enchantmentDatas) {
         Intrinsics.checkParameterIsNotNull(enchantmentDatas, "enchantmentDatas");
         return ((Companion)this).createEnchantedItem(ItemRegistry.Companion.getCreature_enchanter(), (EnchantmentData[])Arrays.copyOf(enchantmentDatas, enchantmentDatas.length));
      }

      @NotNull
      public final EnchantmentData nbtToEnchantment$Thaumic_Arcana(@NotNull NBTTagCompound nbt) {
         Intrinsics.checkParameterIsNotNull(nbt, "nbt");
         String name = nbt.func_74779_i("name");
         int level = nbt.func_74762_e("level");
         EnchantmentData var10000 = new EnchantmentData;
         IForgeRegistryEntry var10002 = GameRegistry.findRegistry(CreatureEnchant.class).getValue(new ResourceLocation(name));
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var10002, "GameRegistry.findRegistr…ResourceLocation(name))!!");
         var10000.<init>((CreatureEnchant)var10002, level);
         return var10000;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

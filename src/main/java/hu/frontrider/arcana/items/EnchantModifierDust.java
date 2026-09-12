package hu.frontrider.arcana.items;

import hu.frontrider.arcana.ThaumicArcana;
import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantProvider;
import hu.frontrider.arcana.capabilities.creatureenchant.ICreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EnchantingBaseCircle;
import hu.frontrider.arcana.sided.network.creatureenchants.CreatureEnchantSyncMessage;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.aura.AuraHelper;
import thaumcraft.api.items.ItemsTC;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J+\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u001e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001cH\u0017J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0016J0\u0010\u001f\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016JR\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u00152\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"},
   d2 = {"Lhu/frontrider/arcana/items/EnchantModifierDust;", "Lhu/frontrider/arcana/items/ItemBase;", "networkWrapper", "Lnet/minecraftforge/fml/common/network/simpleimpl/SimpleNetworkWrapper;", "(Lnet/minecraftforge/fml/common/network/simpleimpl/SimpleNetworkWrapper;)V", "addInformation", "", "stack", "Lnet/minecraft/item/ItemStack;", "worldIn", "Lnet/minecraft/world/World;", "tooltip", "", "", "flagIn", "Lnet/minecraft/client/util/ITooltipFlag;", "applyEntity", "", "entity", "Lnet/minecraft/entity/Entity;", "playerIn", "Lnet/minecraft/entity/player/EntityPlayer;", "applyEntity$Thaumic_Arcana", "getHasSubtypes", "getSubItems", "tab", "Lnet/minecraft/creativetab/CreativeTabs;", "items", "Lnet/minecraft/util/NonNullList;", "hasEffect", "isEnchantable", "itemInteractionForEntity", "Lnet/minecraft/entity/EntityLivingBase;", "hand", "Lnet/minecraft/util/EnumHand;", "onItemUse", "Lnet/minecraft/util/EnumActionResult;", "player", "pos", "Lnet/minecraft/util/math/BlockPos;", "facing", "Lnet/minecraft/util/EnumFacing;", "hitX", "", "hitY", "hitZ", "Companion", "Thaumic Arcana"}
)
public final class EnchantModifierDust extends ItemBase {
   private final SimpleNetworkWrapper networkWrapper;
   private static final IForgeRegistry<EnchantingBaseCircle> registry = GameRegistry.findRegistry(EnchantingBaseCircle.class);
   @ObjectHolder("thaumcraft:warpward")
   @Nullable
   private static final Potion warpWard;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public boolean func_77616_k(@NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      return false;
   }

   public final boolean applyEntity$Thaumic_Arcana(@Nullable Entity entity, @Nullable EntityPlayer playerIn, @Nullable ItemStack stack) {
      if (stack == null) {
         Intrinsics.throwNpe();
      }

      NBTTagCompound var10000 = stack.func_77978_p();
      if (var10000 != null) {
         Intrinsics.checkExpressionValueIsNotNull(var10000, "stack!!.tagCompound ?: return false");
         NBTTagCompound tagCompound = var10000;
         if (!tagCompound.func_74764_b("modifier")) {
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
                  if (AuraHelper.drainVis(entity.field_70170_p, entity.func_180425_c(), 30.0F, true) < (float)30) {
                     return false;
                  }

                  String modifier = tagCompound.func_74779_i("modifier");
                  EnchantingBaseCircle baseCircle = (EnchantingBaseCircle)registry.getValue(new ResourceLocation(modifier));
                  ICreatureEnchant capability = (ICreatureEnchant)entity.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
                  if (capability == null) {
                     Intrinsics.throwNpe();
                  }

                  if (baseCircle == null) {
                     Intrinsics.throwNpe();
                  }

                  capability.setCircle(baseCircle);
                  stack.func_190918_g(1);
                  AuraHelper.polluteAura(entity.func_130014_f_(), entity.func_180425_c(), 10.0F, true);
                  int entityId = entity.func_145782_y();
                  this.networkWrapper.sendTo(new CreatureEnchantSyncMessage(capability, entityId), (EntityPlayerMP)playerIn);
               }
            }

            return false;
         }
      } else {
         return false;
      }
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
               var10000 = this.applyEntity$Thaumic_Arcana((Entity)player, player, stack) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
               return var10000;
            }
         }
      }

      var10000 = EnumActionResult.FAIL;
      return var10000;
   }

   public boolean func_111207_a(@Nullable ItemStack stack, @Nullable EntityPlayer playerIn, @Nullable EntityLivingBase entity, @Nullable EnumHand hand) {
      return this.applyEntity$Thaumic_Arcana((Entity)entity, playerIn, stack);
   }

   public void func_77624_a(@Nullable ItemStack stack, @Nullable World worldIn, @Nullable List<String> tooltip, @Nullable ITooltipFlag flagIn) {
      if (stack == null) {
         Intrinsics.throwNpe();
      }

      NBTTagCompound tagCompound = stack.func_77978_p();
      if (tagCompound != null && tagCompound.func_74764_b("modifier")) {
         String name = tagCompound.func_74779_i("modifier");
         if (tooltip == null) {
            Intrinsics.throwNpe();
         }

         StringBuilder var14;
         List var10000;
         label46: {
            StringBuilder var10001 = (new StringBuilder()).append("enchant.modifier.");
            Intrinsics.checkExpressionValueIsNotNull(name, "name");
            CharSequence thisCollection$iv = (CharSequence)name;
            String var8 = ":";
            var14 = var10001;
            Regex var15 = new Regex(var8);
            byte var9 = 0;
            List var20 = var15.split(thisCollection$iv, var9);
            if (!var20.isEmpty()) {
               ListIterator iterator$iv = var20.listIterator(var20.size());

               while(iterator$iv.hasPrevious()) {
                  String it = (String)iterator$iv.previous();
                  CharSequence var10 = (CharSequence)it;
                  if (var10.length() != 0) {
                     var10000 = CollectionsKt.take((Iterable)var20, iterator$iv.nextIndex() + 1);
                     break label46;
                  }
               }
            }

            var10000 = CollectionsKt.emptyList();
         }

         List var21 = var10000;
         Collection $receiver$iv = (Collection)var21;
         if ($receiver$iv == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
         }

         String var24 = $receiver$iv.toArray(new String[0]);
         if (var24 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
         }

         String var22 = var24;
         String thisCollection$iv = ((String[])var22)[1];
         if (thisCollection$iv == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         var24 = thisCollection$iv.toLowerCase();
         Intrinsics.checkExpressionValueIsNotNull(var24, "(this as java.lang.String).toLowerCase()");
         var22 = var24;
         String var26 = I18n.func_135052_a(var14.append(var22).toString(), new Object[0]);
         Intrinsics.checkExpressionValueIsNotNull(var26, "I18n.format(\"enchant.mod…Array()[1].toLowerCase())");
         tooltip.add(var26);
      }

   }

   @SideOnly(Side.CLIENT)
   public boolean func_77636_d(@NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      NBTTagCompound tagCompound = stack.func_77978_p();
      return tagCompound != null && tagCompound.func_74764_b("modifier");
   }

   public boolean func_77614_k() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public void func_150895_a(@NotNull CreativeTabs tab, @NotNull NonNullList<ItemStack> items) {
      Intrinsics.checkParameterIsNotNull(tab, "tab");
      Intrinsics.checkParameterIsNotNull(items, "items");
      if (tab == ThaumicArcana.INSTANCE.getTABARCANA()) {
         items.add(new ItemStack(this));
         IForgeRegistry var10000 = registry;
         Intrinsics.checkExpressionValueIsNotNull(var10000, "registry");
         Collection var9 = var10000.getValuesCollection();
         Intrinsics.checkExpressionValueIsNotNull(var9, "registry.valuesCollection");

         for(Object element$iv : (Iterable)var9) {
            EnchantingBaseCircle enchant = (EnchantingBaseCircle)element$iv;
            Companion var10001 = Companion;
            Item var10002 = this;
            Intrinsics.checkExpressionValueIsNotNull(enchant, "enchant");
            items.add(var10001.createItem(var10002, enchant));
         }
      }

   }

   public EnchantModifierDust(@NotNull SimpleNetworkWrapper networkWrapper) {
      Intrinsics.checkParameterIsNotNull(networkWrapper, "networkWrapper");
      super(new ResourceLocation("thaumic_arcana", "enchant_modifier"));
      this.networkWrapper = networkWrapper;
      this.func_77625_d(1);
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"},
      d2 = {"Lhu/frontrider/arcana/items/EnchantModifierDust$Companion;", "", "()V", "registry", "Lnet/minecraftforge/registries/IForgeRegistry;", "Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;", "kotlin.jvm.PlatformType", "warpWard", "Lnet/minecraft/potion/Potion;", "getWarpWard", "()Lnet/minecraft/potion/Potion;", "createItem", "Lnet/minecraft/item/ItemStack;", "baseItem", "Lnet/minecraft/item/Item;", "modifierName", "Thaumic Arcana"}
   )
   public static final class Companion {
      @Nullable
      public final Potion getWarpWard() {
         return EnchantModifierDust.warpWard;
      }

      @NotNull
      public final ItemStack createItem(@NotNull Item baseItem, @NotNull EnchantingBaseCircle modifierName) {
         Intrinsics.checkParameterIsNotNull(baseItem, "baseItem");
         Intrinsics.checkParameterIsNotNull(modifierName, "modifierName");
         ItemStack enchanter = new ItemStack(baseItem, 1);
         NBTTagCompound compound = new NBTTagCompound();
         ResourceLocation var10002 = modifierName.getRegistryName();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         compound.func_74778_a("modifier", var10002.toString());
         enchanter.func_77982_d(compound);
         return enchanter;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

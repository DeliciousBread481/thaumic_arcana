package hu.frontrider.arcana.items;

import hu.frontrider.arcana.AspectEffectMap;
import hu.frontrider.arcana.AspectEffectMapKt;
import hu.frontrider.arcana.ThaumicArcana;
import hu.frontrider.arcana.blocks.effect.tiles.TileEssentiaMine;
import hu.frontrider.arcana.util.strings.ChatFormat;
import hu.frontrider.arcana.util.strings.ChatFormatKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.aspects.Aspect;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0016JH\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006%"},
   d2 = {"Lhu/frontrider/arcana/items/ItemInfusedSlime;", "Lnet/minecraft/item/Item;", "()V", "addInformation", "", "stack", "Lnet/minecraft/item/ItemStack;", "worldIn", "Lnet/minecraft/world/World;", "tooltip", "", "", "flagIn", "Lnet/minecraft/client/util/ITooltipFlag;", "getHasSubtypes", "", "getSubItems", "tab", "Lnet/minecraft/creativetab/CreativeTabs;", "items", "Lnet/minecraft/util/NonNullList;", "onItemUse", "Lnet/minecraft/util/EnumActionResult;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "pos", "Lnet/minecraft/util/math/BlockPos;", "hand", "Lnet/minecraft/util/EnumHand;", "facing", "Lnet/minecraft/util/EnumFacing;", "hitX", "", "hitY", "hitZ", "showDurabilityBar", "Companion", "Thaumic Arcana"}
)
public final class ItemInfusedSlime extends Item {
   @ObjectHolder("thaumic_arcana:essentia_mine")
   @NotNull
   public static Block essentia_mine;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public boolean showDurabilityBar(@NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      return false;
   }

   @NotNull
   public EnumActionResult func_180614_a(@NotNull EntityPlayer player, @NotNull World worldIn, @NotNull BlockPos pos, @NotNull EnumHand hand, @NotNull EnumFacing facing, float hitX, float hitY, float hitZ) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(hand, "hand");
      Intrinsics.checkParameterIsNotNull(facing, "facing");
      BlockPos pos = pos;
      IBlockState iblockstate = worldIn.func_180495_p(pos);
      Intrinsics.checkExpressionValueIsNotNull(iblockstate, "iblockstate");
      Block block = iblockstate.func_177230_c();
      if (!block.func_176200_f((IBlockAccess)worldIn, pos)) {
         BlockPos var10000 = pos.func_177972_a(facing);
         Intrinsics.checkExpressionValueIsNotNull(var10000, "pos.offset(facing)");
         pos = var10000;
      }

      IBlockState var14 = worldIn.func_180495_p(pos.func_177977_b());
      Intrinsics.checkExpressionValueIsNotNull(var14, "worldIn.getBlockState(pos.down())");
      if (var14.func_185913_b()) {
         ItemStack itemstack = player.func_184586_b(hand);
         Aspect[] var15 = AspectEffectMapKt.getSupportedAspects();
         Intrinsics.checkExpressionValueIsNotNull(itemstack, "itemstack");
         Aspect aspect = var15[itemstack.func_77960_j()];
         if (!AspectEffectMap.INSTANCE.getMap().containsKey(aspect)) {
            return EnumActionResult.FAIL;
         } else {
            Block var10002 = essentia_mine;
            if (var10002 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("essentia_mine");
            }

            worldIn.func_175656_a(pos, var10002.func_176223_P());
            TileEssentiaMine var16 = worldIn.func_175625_s(pos);
            if (var16 == null) {
               throw new TypeCastException("null cannot be cast to non-null type hu.frontrider.arcana.blocks.effect.tiles.TileEssentiaMine");
            } else {
               var16 = var16;
               Intrinsics.checkExpressionValueIsNotNull(aspect, "aspect");
               String var10001 = aspect.getTag();
               Intrinsics.checkExpressionValueIsNotNull(var10001, "aspect.tag");
               var16.setAspect(var10001);
               return EnumActionResult.SUCCESS;
            }
         }
      } else {
         return EnumActionResult.FAIL;
      }
   }

   public boolean func_77614_k() {
      return true;
   }

   public void func_150895_a(@NotNull CreativeTabs tab, @NotNull NonNullList<ItemStack> items) {
      Intrinsics.checkParameterIsNotNull(tab, "tab");
      Intrinsics.checkParameterIsNotNull(items, "items");
      if (tab == ThaumicArcana.INSTANCE.getTABARCANA()) {
         for(Object element$iv : AspectEffectMapKt.getSupportedAspects()) {
            Companion var10001 = Companion;
            Intrinsics.checkExpressionValueIsNotNull(element$iv, "aspect");
            items.add(var10001.createSlimeFor((Aspect)element$iv, this));
         }
      }

   }

   public void func_77624_a(@NotNull ItemStack stack, @Nullable World worldIn, @NotNull List<String> tooltip, @NotNull ITooltipFlag flagIn) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(tooltip, "tooltip");
      Intrinsics.checkParameterIsNotNull(flagIn, "flagIn");
      super.func_77624_a(stack, worldIn, tooltip, flagIn);
      Aspect aspect = AspectEffectMapKt.getSupportedAspects()[stack.func_77960_j()];
      Object[] var10002 = new Object[1];
      Intrinsics.checkExpressionValueIsNotNull(aspect, "aspect");
      var10002[0] = aspect.getTag();
      String var10001 = I18n.func_135052_a("thaumic_arcana.tooltip.infused_with", var10002);
      Intrinsics.checkExpressionValueIsNotNull(var10001, "I18n.format(\"thaumic_arc…nfused_with\", aspect.tag)");
      tooltip.add(ChatFormatKt.formatString(var10001, ChatFormat.AQUA));
   }

   public ItemInfusedSlime() {
      this.func_77656_e(AspectEffectMapKt.getSupportedAspects().length);
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
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"},
      d2 = {"Lhu/frontrider/arcana/items/ItemInfusedSlime$Companion;", "", "()V", "essentia_mine", "Lnet/minecraft/block/Block;", "getEssentia_mine", "()Lnet/minecraft/block/Block;", "setEssentia_mine", "(Lnet/minecraft/block/Block;)V", "createSlimeFor", "Lnet/minecraft/item/ItemStack;", "aspect", "Lthaumcraft/api/aspects/Aspect;", "item", "Lnet/minecraft/item/Item;", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final ItemStack createSlimeFor(@NotNull Aspect aspect, @NotNull Item item) {
         Intrinsics.checkParameterIsNotNull(aspect, "aspect");
         Intrinsics.checkParameterIsNotNull(item, "item");
         return new ItemStack(item, 1, ArraysKt.indexOf(AspectEffectMapKt.getSupportedAspects(), aspect));
      }

      @NotNull
      public final Block getEssentia_mine() {
         return ItemInfusedSlime.access$getEssentia_mine$cp();
      }

      public final void setEssentia_mine(@NotNull Block var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ItemInfusedSlime.essentia_mine = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

package hu.frontrider.arcana.items.curio;

import hu.frontrider.arcana.items.ItemBase;
import hu.frontrider.arcana.util.strings.ChatFormat;
import hu.frontrider.arcana.util.strings.ChatFormatKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.capabilities.IPlayerKnowledge.EnumKnowledgeType;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016¨\u0006\u001d"},
   d2 = {"Lhu/frontrider/arcana/items/curio/ResearchResult;", "Lhu/frontrider/arcana/items/ItemBase;", "()V", "addInformation", "", "stack", "Lnet/minecraft/item/ItemStack;", "worldIn", "Lnet/minecraft/world/World;", "tooltip", "", "", "flagIn", "Lnet/minecraft/client/util/ITooltipFlag;", "onItemUse", "Lnet/minecraft/util/EnumActionResult;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "pos", "Lnet/minecraft/util/math/BlockPos;", "hand", "Lnet/minecraft/util/EnumHand;", "facing", "Lnet/minecraft/util/EnumFacing;", "hitX", "", "hitY", "hitZ", "Companion", "Thaumic Arcana"}
)
public final class ResearchResult extends ItemBase {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @NotNull
   public EnumActionResult func_180614_a(@NotNull EntityPlayer player, @NotNull World worldIn, @NotNull BlockPos pos, @NotNull EnumHand hand, @NotNull EnumFacing facing, float hitX, float hitY, float hitZ) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(hand, "hand");
      Intrinsics.checkParameterIsNotNull(facing, "facing");
      ItemStack heldItem = player.func_184586_b(hand);
      Intrinsics.checkExpressionValueIsNotNull(heldItem, "heldItem");
      NBTTagCompound var10000 = heldItem.func_77978_p();
      if (var10000 != null) {
         Intrinsics.checkExpressionValueIsNotNull(var10000, "heldItem.tagCompound ?: …urn EnumActionResult.FAIL");
         NBTTagCompound tagCompound = var10000;
         NBTBase var24 = tagCompound.func_74781_a("research");
         if (var24 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagList");
         } else {
            NBTTagList nbtTagList = (NBTTagList)var24;
            String playerName = tagCompound.func_74779_i("player");
            if (Intrinsics.areEqual(player.getPersistentID().toString(), playerName) ^ true) {
               return EnumActionResult.FAIL;
            } else {
               int oProg = EnumKnowledgeType.OBSERVATION.getProgression();
               int tProg = EnumKnowledgeType.THEORY.getProgression();

               for(Object element$iv : (Iterable)nbtTagList) {
                  NBTBase it = (NBTBase)element$iv;
                  if (it == null) {
                     throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
                  }

                  NBTTagCompound nbtTagCompound = (NBTTagCompound)it;
                  String key = nbtTagCompound.func_74779_i("research");
                  ResearchCategory research = ResearchCategories.getResearchCategory(key);
                  ThaumcraftApi.internalMethods.addKnowledge(player, EnumKnowledgeType.THEORY, research, MathHelper.func_76136_a(player.func_70681_au(), tProg / 2, tProg));
                  ThaumcraftApi.internalMethods.addKnowledge(player, EnumKnowledgeType.OBSERVATION, research, MathHelper.func_76136_a(player.func_70681_au(), oProg / 2, oProg));
               }

               return EnumActionResult.SUCCESS;
            }
         }
      } else {
         return EnumActionResult.FAIL;
      }
   }

   public void func_77624_a(@NotNull ItemStack stack, @Nullable World worldIn, @NotNull List<String> tooltip, @NotNull ITooltipFlag flagIn) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(tooltip, "tooltip");
      Intrinsics.checkParameterIsNotNull(flagIn, "flagIn");
      super.func_77624_a(stack, worldIn, tooltip, flagIn);
      tooltip.add(ChatFormatKt.formatTranslate("thaumic_arcana.tooltip.unused", ChatFormat.RED));
   }

   public ResearchResult() {
      super("research_result");
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"},
      d2 = {"Lhu/frontrider/arcana/items/curio/ResearchResult$Companion;", "", "()V", "setResearch", "", "researchCategory", "", "Lthaumcraft/api/research/ResearchCategory;", "itemStack", "Lnet/minecraft/item/ItemStack;", "([Lthaumcraft/api/research/ResearchCategory;Lnet/minecraft/item/ItemStack;)V", "Thaumic Arcana"}
   )
   public static final class Companion {
      public final void setResearch(@NotNull ResearchCategory[] researchCategory, @NotNull ItemStack itemStack) {
         Intrinsics.checkParameterIsNotNull(researchCategory, "researchCategory");
         Intrinsics.checkParameterIsNotNull(itemStack, "itemStack");
         NBTTagList nbtList = new NBTTagList();

         for(Object element$iv : researchCategory) {
            NBTTagCompound nbtTagCompound = new NBTTagCompound();
            nbtTagCompound.func_74778_a("key", ((ResearchCategory)element$iv).key);
            nbtList.func_74742_a((NBTBase)nbtTagCompound);
         }

         NBTTagCompound var10000 = itemStack.func_77978_p();
         if (var10000 == null) {
            var10000 = new NBTTagCompound();
         }

         Intrinsics.checkExpressionValueIsNotNull(var10000, "itemStack.tagCompound ?: NBTTagCompound()");
         NBTTagCompound nbtTagCompound = var10000;
         nbtTagCompound.func_74782_a("research", (NBTBase)nbtList);
         itemStack.func_77982_d(nbtTagCompound);
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

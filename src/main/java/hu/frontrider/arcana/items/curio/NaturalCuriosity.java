package hu.frontrider.arcana.items.curio;

import hu.frontrider.arcana.items.ItemBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.capabilities.IPlayerKnowledge.EnumKnowledgeType;
import thaumcraft.api.research.ResearchCategories;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016JH\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016¨\u0006\u0018"},
   d2 = {"Lhu/frontrider/arcana/items/curio/NaturalCuriosity;", "Lhu/frontrider/arcana/items/ItemBase;", "()V", "onItemRightClick", "Lnet/minecraft/util/ActionResult;", "Lnet/minecraft/item/ItemStack;", "worldIn", "Lnet/minecraft/world/World;", "playerIn", "Lnet/minecraft/entity/player/EntityPlayer;", "handIn", "Lnet/minecraft/util/EnumHand;", "onItemUse", "Lnet/minecraft/util/EnumActionResult;", "player", "pos", "Lnet/minecraft/util/math/BlockPos;", "hand", "facing", "Lnet/minecraft/util/EnumFacing;", "hitX", "", "hitY", "hitZ", "Thaumic Arcana"}
)
public final class NaturalCuriosity extends ItemBase {
   @NotNull
   public EnumActionResult func_180614_a(@NotNull EntityPlayer player, @NotNull World worldIn, @NotNull BlockPos pos, @NotNull EnumHand hand, @NotNull EnumFacing facing, float hitX, float hitY, float hitZ) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(hand, "hand");
      Intrinsics.checkParameterIsNotNull(facing, "facing");
      this.func_77659_a(worldIn, player, hand);
      return EnumActionResult.SUCCESS;
   }

   @NotNull
   public ActionResult<ItemStack> func_77659_a(@NotNull World worldIn, @NotNull EntityPlayer playerIn, @NotNull EnumHand handIn) {
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(playerIn, "playerIn");
      Intrinsics.checkParameterIsNotNull(handIn, "handIn");
      if (!worldIn.field_72995_K) {
         int oProg = EnumKnowledgeType.OBSERVATION.getProgression();
         int tProg = EnumKnowledgeType.THEORY.getProgression();
         switch (worldIn.field_73012_v.nextInt(5)) {
            case 0:
               ThaumcraftApi.internalMethods.addKnowledge(playerIn, EnumKnowledgeType.OBSERVATION, ResearchCategories.getResearchCategory("ALCHEMY"), MathHelper.func_76136_a(playerIn.func_70681_au(), oProg / 2, oProg));
               ThaumcraftApi.internalMethods.addKnowledge(playerIn, EnumKnowledgeType.THEORY, ResearchCategories.getResearchCategory("ALCHEMY"), MathHelper.func_76136_a(playerIn.func_70681_au(), tProg / 3, tProg / 2));
               break;
            case 1:
               ThaumcraftApi.internalMethods.addKnowledge(playerIn, EnumKnowledgeType.OBSERVATION, ResearchCategories.getResearchCategory("BASIC"), MathHelper.func_76136_a(playerIn.func_70681_au(), oProg / 2, oProg));
               ThaumcraftApi.internalMethods.addKnowledge(playerIn, EnumKnowledgeType.THEORY, ResearchCategories.getResearchCategory("BASIC"), MathHelper.func_76136_a(playerIn.func_70681_au(), tProg / 3, tProg / 2));
               break;
            case 2:
               ThaumcraftApi.internalMethods.addKnowledge(playerIn, EnumKnowledgeType.OBSERVATION, ResearchCategories.getResearchCategory("BIOMANCY"), MathHelper.func_76136_a(playerIn.func_70681_au(), oProg / 2, oProg));
               ThaumcraftApi.internalMethods.addKnowledge(playerIn, EnumKnowledgeType.THEORY, ResearchCategories.getResearchCategory("BIOMANCY"), MathHelper.func_76136_a(playerIn.func_70681_au(), tProg / 3, tProg / 2));
               break;
            default:
               ThaumcraftApi.internalMethods.addKnowledge(playerIn, EnumKnowledgeType.THEORY, ResearchCategories.getResearchCategory("BIOMANCY"), MathHelper.func_76136_a(playerIn.func_70681_au(), tProg / 3, tProg / 2));
         }

         playerIn.func_184586_b(handIn).func_190918_g(1);
      }

      ActionResult var10000 = super.func_77659_a(worldIn, playerIn, handIn);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "super.onItemRightClick(worldIn, playerIn, handIn)");
      return var10000;
   }

   public NaturalCuriosity() {
      super("organic_curiosity");
   }
}

package hu.frontrider.arcana.registrationhandlers;

import hu.frontrider.arcana.blocks.effect.BlockArcaneStoneDisableEnchants;
import hu.frontrider.arcana.blocks.effect.BlockArcaneStoneEnableEnchants;
import hu.frontrider.arcana.blocks.effect.EssentiaMine;
import hu.frontrider.arcana.blocks.plants.magictree.AuraLeaves;
import hu.frontrider.arcana.blocks.plants.magictree.AuraLog;
import hu.frontrider.arcana.blocks.plants.magictree.MagicTreeSapling;
import hu.frontrider.arcana.blocks.plants.taintwine.mushroom.TaintWineCap;
import hu.frontrider.arcana.blocks.plants.taintwine.mushroom.TaintWineTrunk;
import hu.frontrider.arcana.util.BlockFactory;
import hu.frontrider.arcana.worldgen.generators.magictree.MagicTreeGenerator;
import java.util.Collection;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.blocks.BlocksTC;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¨\u0006\t"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/BlockRegistry;", "", "()V", "init", "", "event", "Lnet/minecraftforge/event/RegistryEvent$Register;", "Lnet/minecraft/block/Block;", "Companion", "Thaumic Arcana"}
)
public final class BlockRegistry {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @SubscribeEvent
   public final void init(@NotNull RegistryEvent.Register<Block> event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      Block auraLog = BlockFactory.INSTANCE.start((Block)(new AuraLog())).setResourourceLocation("aura_wood_log").build();
      Block auraLeaves = BlockFactory.INSTANCE.start(new AuraLeaves()).setResourourceLocation("aura_leaves").build();
      BlockLeaves var10000 = Blocks.field_150362_t;
      Intrinsics.checkExpressionValueIsNotNull(var10000, "Blocks.LEAVES");
      IBlockState oakLeaves = var10000.func_176223_P().func_177226_a((IProperty)BlockOldLeaf.field_176239_P, (Comparable)EnumType.OAK).func_177226_a((IProperty)BlockOldLeaf.field_176236_b, (Comparable)false);
      EssentiaMine essentiaMine = new EssentiaMine();
      Block var10006 = BlocksTC.logGreatwood;
      Intrinsics.checkExpressionValueIsNotNull(var10006, "BlocksTC.logGreatwood");
      IBlockState var12 = var10006.func_176223_P();
      Intrinsics.checkExpressionValueIsNotNull(var12, "BlocksTC.logGreatwood.defaultState");
      Intrinsics.checkExpressionValueIsNotNull(oakLeaves, "oakLeaves");
      Block magicOak = (new BlockFactory.BlockFactoryHelper((Block)(new MagicTreeSapling(new MagicTreeGenerator(var12, oakLeaves, true))))).setResourourceLocation("magic_oak_sapling").build();
      Block var13 = BlocksTC.logSilverwood;
      Intrinsics.checkExpressionValueIsNotNull(var13, "BlocksTC.logSilverwood");
      IBlockState var14 = var13.func_176223_P();
      Intrinsics.checkExpressionValueIsNotNull(var14, "BlocksTC.logSilverwood.defaultState");
      Block silverOak = (new BlockFactory.BlockFactoryHelper((Block)(new MagicTreeSapling(new MagicTreeGenerator(var14, oakLeaves, true))))).setResourourceLocation("silver_oak_sapling").build();
      Block var15 = BlocksTC.taintLog;
      Intrinsics.checkExpressionValueIsNotNull(var15, "BlocksTC.taintLog");
      IBlockState var16 = var15.func_176223_P();
      Intrinsics.checkExpressionValueIsNotNull(var16, "BlocksTC.taintLog.defaultState");
      Block taintOak = (new BlockFactory.BlockFactoryHelper((Block)(new MagicTreeSapling(new MagicTreeGenerator(var16, oakLeaves, true))))).setResourourceLocation("tainted_oak_sapling").build();
      var16 = auraLog.func_176223_P();
      Intrinsics.checkExpressionValueIsNotNull(var16, "auraLog.defaultState");
      IBlockState var10007 = auraLeaves.func_176223_P();
      Intrinsics.checkExpressionValueIsNotNull(var10007, "auraLeaves.defaultState");
      Block auraWood = (new BlockFactory.BlockFactoryHelper((Block)(new MagicTreeSapling(new MagicTreeGenerator(var16, var10007, true))))).setResourourceLocation("aura_wood_sapling").build();
      BlockArcaneStoneEnableEnchants enableEnchants = new BlockArcaneStoneEnableEnchants();
      BlockArcaneStoneDisableEnchants disableEnchants = new BlockArcaneStoneDisableEnchants();
      CollectionsKt.addAll((Collection)ItemRegistry.Companion.getBlocks(), new Block[]{auraLeaves, auraLog, auraWood, magicOak, silverOak, taintOak, enableEnchants, disableEnchants});
      event.getRegistry().registerAll(new Block[]{auraLeaves, auraLog, auraWood, new TaintWineCap(), new TaintWineTrunk(), magicOak, silverOak, taintOak, enableEnchants, disableEnchants, essentiaMine});
      GameRegistry.registerTileEntity((essentiaMine).getTileEntityClass(), (ResourceLocation)Objects.requireNonNull(essentiaMine.getRegistryName()));
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
      d2 = {"Lhu/frontrider/arcana/registrationhandlers/BlockRegistry$Companion;", "", "()V", "Thaumic Arcana"}
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

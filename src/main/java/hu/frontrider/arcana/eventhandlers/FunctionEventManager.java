package hu.frontrider.arcana.eventhandlers;

import hu.frontrider.arcana.items.EnchantmentUpgradePowder;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"},
   d2 = {"Lhu/frontrider/arcana/eventhandlers/FunctionEventManager;", "", "()V", "createEnchantedBook", "", "event", "Lnet/minecraftforge/event/entity/player/PlayerInteractEvent$RightClickBlock;", "entityRightClick", "Lnet/minecraftforge/event/entity/player/PlayerInteractEvent$EntityInteract;", "selfEnchantFix", "Companion", "Thaumic Arcana"}
)
public final class FunctionEventManager {
   @ObjectHolder("thaumic_arcana:enchanting_powder_basic")
   private static Item enchant_basic;
   @ObjectHolder("thaumic_arcana:enchanting_powder_advanced")
   private static Item enchant_advanced;
   @ObjectHolder("thaumic_arcana:enchanting_powder_magical")
   private static Item enchant_magical;
   @ObjectHolder("thaumic_arcana:creature_enchanter")
   private static Item enchant_book;
   @ObjectHolder("minecraft:enchanting_table")
   private static Block enchanting_table;
   @ObjectHolder("thaumic_arcana:nutrient_mix")
   @NotNull
   public static Item nutrientMix;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @SubscribeEvent
   public final void entityRightClick(@NotNull PlayerInteractEvent.EntityInteract event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      Entity target = event.getTarget();
      if (target instanceof EntityAgeable && ((EntityAgeable)target).func_70631_g_()) {
         EntityPlayer player = event.getEntityPlayer();
         Intrinsics.checkExpressionValueIsNotNull(player, "player");
         ItemStack itemStack = player.func_184614_ca();
         Intrinsics.checkExpressionValueIsNotNull(itemStack, "itemStack");
         Item item = itemStack.func_77973_b();
         Item var10001 = nutrientMix;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nutrientMix");
         }

         if (Intrinsics.areEqual(item, var10001)) {
            itemStack.func_190918_g(1);
            ((EntityAgeable)target).func_110195_a(30000);
         }
      }

   }

   @SubscribeEvent
   public final void createEnchantedBook(@NotNull PlayerInteractEvent.RightClickBlock event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      World world = event.getWorld();
      if (!world.field_72995_K) {
         EntityPlayer player = event.getEntityPlayer();
         Intrinsics.checkExpressionValueIsNotNull(player, "player");
         ItemStack itemMainhand = player.func_184614_ca();
         ItemStack itemOffhand = player.func_184592_cb();
         IBlockState var10000 = world.func_180495_p(event.getPos());
         Intrinsics.checkExpressionValueIsNotNull(var10000, "world.getBlockState(event.pos)");
         Block var12 = var10000.func_177230_c();
         Block var10001 = enchanting_table;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enchanting_table");
         }

         if (var12 == var10001) {
            Intrinsics.checkExpressionValueIsNotNull(itemMainhand, "itemMainhand");
            if (itemMainhand.func_77973_b() instanceof EnchantmentUpgradePowder) {
               Intrinsics.checkExpressionValueIsNotNull(itemOffhand, "itemOffhand");
               Item var13 = itemOffhand.func_77973_b();
               Item var16 = enchant_book;
               if (var16 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("enchant_book");
               }

               if (var13 == var16) {
                  BlockPos pos = event.getPos().func_177984_a();
                  EntityItem entityItem = new EntityItem(world);
                  Intrinsics.checkExpressionValueIsNotNull(pos, "pos");
                  entityItem.func_70107_b((double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F);
                  ItemStack var14 = new ItemStack;
                  Item var10002 = enchant_book;
                  if (var10002 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("enchant_book");
                  }

                  if (var10002 == null) {
                     Intrinsics.throwNpe();
                  }

                  var14.<init>(var10002);
                  ItemStack itemStack = var14;
                  entityItem.func_92058_a(itemStack);
                  world.func_72838_d((Entity)entityItem);
                  Item var15 = itemMainhand.func_77973_b();
                  if (var15 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type hu.frontrider.arcana.items.EnchantmentUpgradePowder");
                  }

                  ((EnchantmentUpgradePowder)var15).transferEnchants(itemMainhand, itemStack);
                  SoundEvent sound = new SoundEvent(new ResourceLocation("thaumcraft:dust"));
                  world.func_184133_a((EntityPlayer)null, pos, sound, SoundCategory.AMBIENT, 1.0F, 1.5F);
                  int i = 0;

                  for(byte var11 = 49; i <= var11; ++i) {
                     world.func_175688_a(EnumParticleTypes.FIREWORKS_SPARK, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, (double)0.0F, (double)0.0F, (double)0.0F, new int[0]);
                  }
               }
            }
         }

      }
   }

   @SubscribeEvent
   public final void selfEnchantFix(@NotNull PlayerInteractEvent.RightClickBlock event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      World world = event.getWorld();
      if (!world.field_72995_K) {
         EntityPlayer player = event.getEntityPlayer();
         Intrinsics.checkExpressionValueIsNotNull(player, "player");
         ItemStack itemMainhand = player.func_184614_ca();
         Intrinsics.checkExpressionValueIsNotNull(itemMainhand, "itemMainhand");
         Item var10000 = itemMainhand.func_77973_b();
         Item var10001 = enchant_book;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enchant_book");
         }

         if (var10000 != var10001) {
            var10000 = itemMainhand.func_77973_b();
            var10001 = enchant_basic;
            if (var10001 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("enchant_basic");
            }

            if (!Intrinsics.areEqual(var10000, var10001)) {
               var10000 = itemMainhand.func_77973_b();
               var10001 = enchant_advanced;
               if (var10001 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("enchant_advanced");
               }

               if (!Intrinsics.areEqual(var10000, var10001)) {
                  var10000 = itemMainhand.func_77973_b();
                  var10001 = enchant_magical;
                  if (var10001 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("enchant_magical");
                  }

                  if (!Intrinsics.areEqual(var10000, var10001)) {
                     return;
                  }
               }
            }
         }

         event.setUseBlock(Result.DENY);
      }
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getNutrientMix$cp() {
      Item var10000 = nutrientMix;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("nutrientMix");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"},
      d2 = {"Lhu/frontrider/arcana/eventhandlers/FunctionEventManager$Companion;", "", "()V", "enchant_advanced", "Lnet/minecraft/item/Item;", "enchant_basic", "enchant_book", "enchant_magical", "enchanting_table", "Lnet/minecraft/block/Block;", "nutrientMix", "getNutrientMix$Thaumic_Arcana", "()Lnet/minecraft/item/Item;", "setNutrientMix$Thaumic_Arcana", "(Lnet/minecraft/item/Item;)V", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final Item getNutrientMix$Thaumic_Arcana() {
         return FunctionEventManager.access$getNutrientMix$cp();
      }

      public final void setNutrientMix$Thaumic_Arcana(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         FunctionEventManager.nutrientMix = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

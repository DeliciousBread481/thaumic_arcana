package hu.frontrider.arcana.items.caster;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.casters.CasterTriggerRegistry;
import thaumcraft.api.casters.FocusEngine;
import thaumcraft.api.casters.FocusPackage;
import thaumcraft.api.casters.ICaster;
import thaumcraft.api.casters.IFocusBlockPicker;
import thaumcraft.api.casters.IFocusElement;
import thaumcraft.api.casters.IInteractWithCaster;
import thaumcraft.api.items.IArchitect;
import thaumcraft.codechicken.lib.math.MathHelper;
import thaumcraft.common.items.casters.CasterManager;
import thaumcraft.common.items.casters.ItemCaster;
import thaumcraft.common.items.casters.ItemFocus;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.misc.PacketAuraToClient;
import thaumcraft.common.lib.utils.BlockUtils;
import thaumcraft.common.world.aura.AuraChunk;
import thaumcraft.common.world.aura.AuraHandler;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ6\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J0\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001bH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J8\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\"\u0010.\u001a\u0004\u0018\u00010$2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\"\u00101\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u00104\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010\u0012H\u0016J\u0014\u0010:\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010;\u001a\u00020<2\u0006\u00109\u001a\u00020\u0012H\u0016J\b\u0010=\u001a\u00020\u001bH\u0016J\b\u0010>\u001a\u00020\u001bH\u0017J&\u0010?\u001a\u00020\u00102\b\u0010*\u001a\u0004\u0018\u00010\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010@\u001a\u0004\u0018\u00010\u0012H\u0016J(\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00120B2\b\u0010*\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020DH\u0016JR\u0010E\u001a\u00020F2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u00142\b\u0010+\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020 2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J6\u0010J\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\u0010K\u001a\u0004\u0018\u00010\u00142\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u001bH\u0016J\u001a\u0010N\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010O\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010P\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u00122\u0006\u0010S\u001a\u00020\u001bH\u0016J0\u0010T\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-2\u0006\u0010U\u001a\u00020VH\u0016J\u0016\u0010W\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\u0012J\"\u0010Y\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010*\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020ZH\u0002J\u0010\u0010[\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\\"},
   d2 = {"Lhu/frontrider/arcana/items/caster/BasicBattleGauntlet;", "Lnet/minecraft/item/ItemSword;", "Lthaumcraft/api/items/IArchitect;", "Lthaumcraft/api/casters/ICaster;", "area", "", "material", "Lnet/minecraft/item/Item$ToolMaterial;", "(ILnet/minecraft/item/Item$ToolMaterial;)V", "myFormatter", "Ljava/text/DecimalFormat;", "getMyFormatter$Thaumic_Arcana", "()Ljava/text/DecimalFormat;", "setMyFormatter$Thaumic_Arcana", "(Ljava/text/DecimalFormat;)V", "addInformation", "", "stack", "Lnet/minecraft/item/ItemStack;", "worldIn", "Lnet/minecraft/world/World;", "tooltip", "", "", "flagIn", "Lnet/minecraft/client/util/ITooltipFlag;", "consumeVis", "", "is", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "amount", "", "crafting", "sim", "generateSourceVector", "Lnet/minecraft/util/math/RayTraceResult;", "e", "Lnet/minecraft/entity/Entity;", "getArchitectBlocks", "Ljava/util/ArrayList;", "Lnet/minecraft/util/math/BlockPos;", "world", "pos", "side", "Lnet/minecraft/util/EnumFacing;", "getArchitectMOP", "Lnet/minecraft/entity/EntityLivingBase;", "getAuraPool", "getConsumptionModifier", "getFocus", "Lthaumcraft/common/items/casters/ItemFocus;", "getFocusStack", "getItemUseAction", "Lnet/minecraft/item/EnumAction;", "stack1", "getMaxItemUseDuration", "itemstack", "getPickedBlock", "getRarity", "Lnet/minecraft/item/EnumRarity;", "isDamageable", "isFull3D", "onArmorTick", "itemStack", "onItemRightClick", "Lnet/minecraft/util/ActionResult;", "hand", "Lnet/minecraft/util/EnumHand;", "onItemUseFirst", "Lnet/minecraft/util/EnumActionResult;", "hitX", "hitY", "hitZ", "onUpdate", "w", "slot", "currentItem", "setFocus", "focus", "shouldCauseReequipAnimation", "oldStack", "newStack", "slotChanged", "showAxis", "axis", "Lthaumcraft/api/items/IArchitect$EnumAxis;", "storePickedBlock", "stackout", "updateAura", "Lnet/minecraft/entity/player/EntityPlayerMP;", "useBlockHighlight", "Thaumic Arcana"}
)
public class BasicBattleGauntlet extends ItemSword implements IArchitect, ICaster {
   @NotNull
   private DecimalFormat myFormatter;
   private int area;

   @NotNull
   public final DecimalFormat getMyFormatter$Thaumic_Arcana() {
      return this.myFormatter;
   }

   public final void setMyFormatter$Thaumic_Arcana(@NotNull DecimalFormat var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.myFormatter = var1;
   }

   public boolean shouldCauseReequipAnimation(@NotNull ItemStack oldStack, @NotNull ItemStack newStack, boolean slotChanged) {
      Intrinsics.checkParameterIsNotNull(oldStack, "oldStack");
      Intrinsics.checkParameterIsNotNull(newStack, "newStack");
      if (oldStack.func_77973_b() == (BasicBattleGauntlet)this && newStack.func_77973_b() == (BasicBattleGauntlet)this) {
         Item var10000 = oldStack.func_77973_b();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type thaumcraft.common.items.casters.ItemCaster");
         } else {
            ItemFocus oldf = ((ItemCaster)var10000).getFocus(oldStack);
            var10000 = newStack.func_77973_b();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type thaumcraft.common.items.casters.ItemCaster");
            } else {
               ItemFocus newf = ((ItemCaster)var10000).getFocus(newStack);
               int s1 = 0;
               int s2 = 0;
               String var9;
               if (oldf != null) {
                  Item var10001 = oldStack.func_77973_b();
                  if (var10001 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type thaumcraft.common.items.casters.ItemCaster");
                  }

                  var9 = oldf.getSortingHelper(((ItemCaster)var10001).getFocusStack(oldStack));
               } else {
                  var9 = null;
               }

               if (var9 != null) {
                  Item var11 = oldStack.func_77973_b();
                  if (var11 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type thaumcraft.common.items.casters.ItemCaster");
                  }

                  s1 = oldf.getSortingHelper(((ItemCaster)var11).getFocusStack(oldStack)).hashCode();
               }

               if (newf != null) {
                  Item var12 = newStack.func_77973_b();
                  if (var12 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type thaumcraft.common.items.casters.ItemCaster");
                  }

                  var9 = newf.getSortingHelper(((ItemCaster)var12).getFocusStack(newStack));
               } else {
                  var9 = null;
               }

               if (var9 != null) {
                  Item var13 = newStack.func_77973_b();
                  if (var13 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type thaumcraft.common.items.casters.ItemCaster");
                  }

                  s2 = newf.getSortingHelper(((ItemCaster)var13).getFocusStack(newStack)).hashCode();
               }

               return s1 != s2;
            }
         }
      } else {
         return newStack.func_77973_b() != oldStack.func_77973_b();
      }
   }

   public boolean func_77645_m() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77662_d() {
      return true;
   }

   private final float getAuraPool(EntityPlayer player) {
      float tot = 0.0F;
      switch (this.area) {
         case 1:
            tot = AuraHandler.getVis(player.field_70170_p, player.func_180425_c());
            EnumFacing[] var7 = EnumFacing.field_176754_o;
            int var11 = var7.length;
            int var13 = 0;

            for(int var6 = var11; var13 < var6; ++var13) {
               EnumFacing face = var7[var13];
               tot += AuraHandler.getVis(player.field_70170_p, player.func_180425_c().func_177967_a(face, 16));
            }

            return tot;
         case 2:
            tot = 0.0F;
            int var7 = -1;

            for(byte var5 = 1; var7 <= var5; ++var7) {
               for(int zz = -1; zz <= 1; ++zz) {
                  tot += AuraHandler.getVis(player.field_70170_p, player.func_180425_c().func_177982_a(var7 * 16, 0, zz * 16));
               }
            }

            return tot;
         default:
            tot = AuraHandler.getVis(player.field_70170_p, player.func_180425_c());
            return tot;
      }
   }

   public boolean consumeVis(@NotNull ItemStack is, @NotNull EntityPlayer player, float amount, boolean crafting, boolean sim) {
      Intrinsics.checkParameterIsNotNull(is, "is");
      Intrinsics.checkParameterIsNotNull(player, "player");
      float amount = amount * this.getConsumptionModifier(is, player, crafting);
      float tot = this.getAuraPool(player);
      if (tot < amount) {
         return false;
      } else if (sim) {
         return true;
      } else {
         switch (this.area) {
            case 1:
               float var15 = amount / 5.0F;

               while(amount > 0.0F) {
                  if (var15 > amount) {
                     var15 = amount;
                  }

                  amount -= AuraHandler.drainVis(player.field_70170_p, player.func_180425_c(), var15, sim);
                  if (amount <= 0.0F) {
                     return amount <= 0.0F;
                  }

                  if (var15 > amount) {
                     var15 = amount;
                  }

                  EnumFacing[] var12 = EnumFacing.field_176754_o;
                  int var16 = var12.length;
                  int var18 = 0;

                  for(int var121 = var16; var18 < var121; ++var18) {
                     EnumFacing face = var12[var18];
                     amount -= AuraHandler.drainVis(player.field_70170_p, player.func_180425_c().func_177967_a(face, 16), var15, sim);
                     if (amount <= 0.0F) {
                        return amount <= 0.0F;
                     }
                  }
               }

               return amount <= 0.0F;
            case 2:
               float i = amount / 9.0F;

               while(amount > 0.0F) {
                  if (i > amount) {
                     i = amount;
                  }

                  int var12 = -1;

                  for(byte var10 = 1; var12 <= var10; ++var12) {
                     for(int zz = -1; zz <= 1; ++zz) {
                        amount -= AuraHandler.drainVis(player.field_70170_p, player.func_180425_c().func_177982_a(var12 * 16, 0, zz * 16), i, sim);
                        if (amount <= 0.0F) {
                           return amount <= 0.0F;
                        }
                     }
                  }
               }

               return amount <= 0.0F;
            default:
               amount -= AuraHandler.drainVis(player.field_70170_p, player.func_180425_c(), amount, sim);
               return amount <= 0.0F;
         }
      }
   }

   public float getConsumptionModifier(@NotNull ItemStack is, @Nullable EntityPlayer player, boolean crafting) {
      Intrinsics.checkParameterIsNotNull(is, "is");
      float consumptionModifier = 1.0F;
      if (player != null) {
         consumptionModifier -= CasterManager.getTotalVisDiscount(player);
      }

      return Math.max(consumptionModifier, 0.1F);
   }

   @Nullable
   public ItemFocus getFocus(@NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      if (stack.func_77942_o()) {
         NBTTagCompound var10000 = stack.func_77978_p();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (var10000.func_74764_b("focus")) {
            var10000 = stack.func_77978_p();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            NBTTagCompound nbt = var10000.func_74775_l("focus");
            ItemStack fs = new ItemStack(nbt);
            if (!fs.func_190926_b()) {
               Item var5 = fs.func_77973_b();
               if (var5 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type thaumcraft.common.items.casters.ItemFocus");
               }

               return (ItemFocus)var5;
            }
         }
      }

      return null;
   }

   @Nullable
   public ItemStack getFocusStack(@NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      if (stack.func_77942_o()) {
         NBTTagCompound var10000 = stack.func_77978_p();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (var10000.func_74764_b("focus")) {
            var10000 = stack.func_77978_p();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            NBTTagCompound nbt = var10000.func_74775_l("focus");
            return new ItemStack(nbt);
         }
      }

      return null;
   }

   public void setFocus(@NotNull ItemStack stack, @Nullable ItemStack focus) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      if (focus != null && !focus.func_190926_b()) {
         stack.func_77983_a("focus", (NBTBase)focus.func_77955_b(new NBTTagCompound()));
      } else {
         NBTTagCompound var10000 = stack.func_77978_p();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.func_82580_o("focus");
      }

   }

   @NotNull
   public EnumRarity func_77613_e(@NotNull ItemStack itemstack) {
      Intrinsics.checkParameterIsNotNull(itemstack, "itemstack");
      return EnumRarity.UNCOMMON;
   }

   @SideOnly(Side.CLIENT)
   public void func_77624_a(@Nullable ItemStack stack, @Nullable World worldIn, @Nullable List<String> tooltip, @Nullable ITooltipFlag flagIn) {
      if (stack == null) {
         Intrinsics.throwNpe();
      }

      if (stack.func_77942_o()) {
         String text = "";
         ItemStack focus = this.getFocusStack(stack);
         if (focus != null && !focus.func_190926_b()) {
            Item var10000 = focus.func_77973_b();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type thaumcraft.common.items.casters.ItemFocus");
            }

            float amt = ((ItemFocus)var10000).getVisCost(focus);
            if (amt > 0.0F) {
               text = "§r" + this.myFormatter.format((double)amt) + " " + I18n.func_74838_a("item.Focus.cost1");
            }
         }

         if (tooltip == null) {
            Intrinsics.throwNpe();
         }

         tooltip.add(TextFormatting.ITALIC.toString() + "" + TextFormatting.AQUA + I18n.func_74838_a("tc.vis.cost") + " " + text);
      }

      if (this.getFocus(stack) != null) {
         if (tooltip == null) {
            Intrinsics.throwNpe();
         }

         StringBuilder var10001 = (new StringBuilder()).append(TextFormatting.BOLD.toString()).append("").append(TextFormatting.ITALIC).append("").append(TextFormatting.GREEN);
         ItemFocus var10002 = this.getFocus(stack);
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         ItemStack var10003 = this.getFocusStack(stack);
         if (var10003 == null) {
            Intrinsics.throwNpe();
         }

         tooltip.add(var10001.append(var10002.func_77653_i(var10003)).toString());
         ItemFocus var8 = this.getFocus(stack);
         if (var8 == null) {
            Intrinsics.throwNpe();
         }

         var8.addFocusInformation(this.getFocusStack(stack), worldIn, tooltip, flagIn);
      }

   }

   public void onArmorTick(@Nullable World world, @Nullable EntityPlayer player, @Nullable ItemStack itemStack) {
      super.onArmorTick(world, player, itemStack);
   }

   public void func_77663_a(@Nullable ItemStack is, @Nullable World w, @Nullable Entity e, int slot, boolean currentItem) {
      if (w == null) {
         Intrinsics.throwNpe();
      }

      if (!w.field_72995_K) {
         if (e == null) {
            Intrinsics.throwNpe();
         }

         if (e.field_70173_aa % 10 == 0 && e instanceof EntityPlayerMP) {
            for(Object var10000 : ((EntityPlayerMP)e).func_184214_aD()) {
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemStack");
               }

               ItemStack h = (ItemStack)var10000;
               if (h != null && !h.func_190926_b() && h.func_77973_b() instanceof ICaster) {
                  this.updateAura(is, w, (EntityPlayerMP)e);
                  break;
               }
            }
         }
      }

   }

   private final void updateAura(ItemStack stack, World world, EntityPlayerMP player) {
      float cv = 0.0F;
      float cf = 0.0F;
      int bv = 0;
      switch (this.area) {
         case 1:
            WorldProvider var20 = world.field_73011_w;
            Intrinsics.checkExpressionValueIsNotNull(var20, "world.provider");
            AuraChunk var14 = AuraHandler.getAuraChunk(var20.getDimension(), (int)player.field_70165_t >> 4, (int)player.field_70161_v >> 4);
            if (var14 != null) {
               cv = var14.getVis();
               cf = var14.getFlux();
               bv = var14.getBase();
               EnumFacing[] var12 = EnumFacing.field_176754_o;
               int var17 = var12.length;
               int var10 = 0;

               for(int var11 = var17; var10 < var11; ++var10) {
                  EnumFacing face = var12[var10];
                  var20 = world.field_73011_w;
                  Intrinsics.checkExpressionValueIsNotNull(var20, "world.provider");
                  int var22 = var20.getDimension();
                  int var10001 = (int)player.field_70165_t >> 4;
                  Intrinsics.checkExpressionValueIsNotNull(face, "face");
                  var14 = AuraHandler.getAuraChunk(var22, var10001 + face.func_82601_c(), ((int)player.field_70161_v >> 4) + face.func_82599_e());
                  if (var14 != null) {
                     cv += var14.getVis();
                     cf += var14.getFlux();
                     bv += var14.getBase();
                  }
               }
            }
            break;
         case 2:
            for(int xx = -1; xx <= 1; ++xx) {
               for(int zz = -1; zz <= 1; ++zz) {
                  WorldProvider var10000 = world.field_73011_w;
                  Intrinsics.checkExpressionValueIsNotNull(var10000, "world.provider");
                  AuraChunk ac = AuraHandler.getAuraChunk(var10000.getDimension(), ((int)player.field_70165_t >> 4) + xx, ((int)player.field_70161_v >> 4) + zz);
                  if (ac != null) {
                     cv += ac.getVis();
                     cf += ac.getFlux();
                     bv += ac.getBase();
                  }
               }
            }

            WorldProvider var19 = world.field_73011_w;
            Intrinsics.checkExpressionValueIsNotNull(var19, "world.provider");
            AuraChunk var13 = AuraHandler.getAuraChunk(var19.getDimension(), (int)player.field_70165_t >> 4, (int)player.field_70161_v >> 4);
            if (var13 != null) {
               cv = var13.getVis();
               cf = var13.getFlux();
               bv = var13.getBase();
            }
            break;
         default:
            WorldProvider var23 = world.field_73011_w;
            Intrinsics.checkExpressionValueIsNotNull(var23, "world.provider");
            AuraChunk var16 = AuraHandler.getAuraChunk(var23.getDimension(), (int)player.field_70165_t >> 4, (int)player.field_70161_v >> 4);
            if (var16 != null) {
               cv = var16.getVis();
               cf = var16.getFlux();
               bv = var16.getBase();
            }
      }

      PacketHandler.INSTANCE.sendTo((IMessage)(new PacketAuraToClient(new AuraChunk((Chunk)null, (short)bv, cv, cf))), player);
   }

   @NotNull
   public EnumActionResult onItemUseFirst(@Nullable EntityPlayer player, @Nullable World world, @Nullable BlockPos pos, @Nullable EnumFacing side, float hitX, float hitY, float hitZ, @Nullable EnumHand hand) {
      if (world == null) {
         Intrinsics.throwNpe();
      }

      if (pos == null) {
         Intrinsics.throwNpe();
      }

      IBlockState bs = world.func_180495_p(pos);
      Intrinsics.checkExpressionValueIsNotNull(bs, "bs");
      if (bs.func_177230_c() instanceof IInteractWithCaster) {
         Block var10000 = bs.func_177230_c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type thaumcraft.api.casters.IInteractWithCaster");
         }

         IInteractWithCaster var18 = (IInteractWithCaster)var10000;
         if (player == null) {
            Intrinsics.throwNpe();
         }

         if (var18.onCasterRightClick(world, player.func_184586_b(hand), player, pos, side, hand)) {
            return EnumActionResult.PASS;
         }
      }

      TileEntity tile = world.func_175625_s(pos);
      if (tile != null && tile instanceof IInteractWithCaster) {
         IInteractWithCaster var19 = (IInteractWithCaster)tile;
         if (player == null) {
            Intrinsics.throwNpe();
         }

         if (var19.onCasterRightClick(world, player.func_184586_b(hand), player, pos, side, hand)) {
            return EnumActionResult.PASS;
         }
      }

      if (CasterTriggerRegistry.hasTrigger(bs)) {
         if (player == null) {
            Intrinsics.throwNpe();
         }

         return CasterTriggerRegistry.performTrigger(world, player.func_184586_b(hand), player, pos, side, bs) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
      } else {
         if (player == null) {
            Intrinsics.throwNpe();
         }

         ItemStack var10001 = player.func_184586_b(hand);
         Intrinsics.checkExpressionValueIsNotNull(var10001, "player!!.getHeldItem(hand)");
         ItemStack fb = this.getFocusStack(var10001);
         if (fb != null && !fb.func_190926_b()) {
            FocusPackage core = ItemFocus.getPackage(fb);

            for(Object var20 : core.nodes) {
               if (var20 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type thaumcraft.api.casters.IFocusElement");
               }

               IFocusElement fe = (IFocusElement)var20;
               if (fe instanceof IFocusBlockPicker && player.func_70093_af() && world.func_175625_s(pos) == null) {
                  if (!world.field_72995_K) {
                     ItemStack isout = new ItemStack(bs.func_177230_c(), 1, bs.func_177230_c().func_176201_c(bs));

                     try {
                        if (bs != Blocks.field_150350_a) {
                           ItemStack is = BlockUtils.getSilkTouchDrop(bs);
                           if (is != null && !is.func_190926_b()) {
                              ItemStack var21 = is.func_77946_l();
                              Intrinsics.checkExpressionValueIsNotNull(var21, "`is`.copy()");
                              isout = var21;
                           }
                        }
                     } catch (Exception var17) {
                     }

                     var10001 = player.func_184586_b(hand);
                     Intrinsics.checkExpressionValueIsNotNull(var10001, "player.getHeldItem(hand)");
                     this.storePickedBlock(var10001, isout);
                     return EnumActionResult.SUCCESS;
                  }

                  if (hand == null) {
                     Intrinsics.throwNpe();
                  }

                  player.func_184609_a(hand);
                  return EnumActionResult.PASS;
               }
            }
         }

         return EnumActionResult.PASS;
      }
   }

   private final RayTraceResult generateSourceVector(Entity e) {
      Vec3d v = e.func_174791_d();
      boolean mainhand = true;
      if (e instanceof EntityPlayer) {
         label27: {
            if (((EntityPlayer)e).func_184614_ca() != null) {
               ItemStack var10000 = ((EntityPlayer)e).func_184614_ca();
               Intrinsics.checkExpressionValueIsNotNull(var10000, "e.heldItemMainhand");
               if (var10000.func_77973_b() instanceof ICaster) {
                  mainhand = true;
                  break label27;
               }
            }

            if (((EntityPlayer)e).func_184592_cb() != null) {
               ItemStack var11 = ((EntityPlayer)e).func_184592_cb();
               Intrinsics.checkExpressionValueIsNotNull(var11, "e.heldItemOffhand");
               if (var11.func_77973_b() instanceof ICaster) {
                  mainhand = false;
               }
            }
         }
      }

      double posX = -MathHelper.cos((double)((e.field_70177_z - 0.5F) / 180.0F * 3.141593F)) * (double)0.2F * (double)(mainhand ? 1 : -1);
      double posZ = -MathHelper.sin((double)((e.field_70177_z - 0.5F) / 180.0F * 3.141593F)) * (double)0.3F * (double)(mainhand ? 1 : -1);
      Vec3d vl = e.func_70040_Z();
      v = v.func_72441_c(posX, (double)e.func_70047_e() - 0.4000000014901161, posZ);
      v = v.func_178787_e(vl);
      return new RayTraceResult(e, v);
   }

   @NotNull
   public ActionResult<ItemStack> func_77659_a(@Nullable World world, @NotNull EntityPlayer player, @NotNull EnumHand hand) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      Intrinsics.checkParameterIsNotNull(hand, "hand");
      ItemStack var10001 = player.func_184586_b(hand);
      Intrinsics.checkExpressionValueIsNotNull(var10001, "player.getHeldItem(hand)");
      ItemStack focusStack = this.getFocusStack(var10001);
      var10001 = player.func_184586_b(hand);
      Intrinsics.checkExpressionValueIsNotNull(var10001, "player.getHeldItem(hand)");
      ItemFocus focus = this.getFocus(var10001);
      if (focus != null && CasterManager.getCooldown((EntityLivingBase)player) > (float)0) {
         CasterManager.setCooldown((EntityLivingBase)player, focus.getActivationTime(focusStack));
         FocusPackage core = ItemFocus.getPackage(focusStack);
         if (player.func_70093_af()) {
            for(Object var9 : core.nodes) {
               if (var9 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type thaumcraft.api.casters.IFocusElement");
               }

               IFocusElement fe = (IFocusElement)var9;
               if (fe instanceof IFocusBlockPicker && player.func_70093_af()) {
                  return new ActionResult(EnumActionResult.PASS, player.func_184586_b(hand));
               }
            }
         }

         if (world == null) {
            Intrinsics.throwNpe();
         }

         if (world.field_72995_K) {
            return new ActionResult(EnumActionResult.SUCCESS, player.func_184586_b(hand));
         } else {
            var10001 = player.func_184586_b(hand);
            Intrinsics.checkExpressionValueIsNotNull(var10001, "player.getHeldItem(hand)");
            if (this.consumeVis(var10001, player, focus.getVisCost(focusStack), false, false)) {
               FocusEngine.castFocusPackage((EntityLivingBase)player, core);
               player.func_184609_a(hand);
               return new ActionResult(EnumActionResult.SUCCESS, player.func_184586_b(hand));
            } else {
               return new ActionResult(EnumActionResult.FAIL, player.func_184586_b(hand));
            }
         }
      } else {
         ActionResult var10000 = super.func_77659_a(world, player, hand);
         Intrinsics.checkExpressionValueIsNotNull(var10000, "super.onItemRightClick(world, player, hand)");
         return var10000;
      }
   }

   public int func_77626_a(@Nullable ItemStack itemstack) {
      return 72000;
   }

   @NotNull
   public EnumAction func_77661_b(@Nullable ItemStack stack1) {
      return EnumAction.BOW;
   }

   @Nullable
   public ArrayList<BlockPos> getArchitectBlocks(@NotNull ItemStack stack, @NotNull World world, @NotNull BlockPos pos, @NotNull EnumFacing side, @NotNull EntityPlayer player) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(side, "side");
      Intrinsics.checkParameterIsNotNull(player, "player");
      ItemFocus focus = this.getFocus(stack);
      if (focus != null) {
         FocusPackage fp = ItemFocus.getPackage(this.getFocusStack(stack));
         if (fp != null) {
            for(Object var10000 : fp.nodes) {
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type thaumcraft.api.casters.IFocusElement");
               }

               IFocusElement fe = (IFocusElement)var10000;
               if (fe instanceof IArchitect) {
                  return ((IArchitect)fe).getArchitectBlocks(stack, world, pos, side, player);
               }
            }
         }
      }

      return null;
   }

   public boolean showAxis(@NotNull ItemStack stack, @NotNull World world, @NotNull EntityPlayer player, @NotNull EnumFacing side, @NotNull IArchitect.EnumAxis axis) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(player, "player");
      Intrinsics.checkParameterIsNotNull(side, "side");
      Intrinsics.checkParameterIsNotNull(axis, "axis");
      ItemFocus focus = this.getFocus(stack);
      if (focus != null) {
         FocusPackage fp = ItemFocus.getPackage(this.getFocusStack(stack));
         if (fp != null) {
            for(Object var10000 : fp.nodes) {
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type thaumcraft.api.casters.IFocusElement");
               }

               IFocusElement fe = (IFocusElement)var10000;
               if (fe instanceof IArchitect) {
                  return ((IArchitect)fe).showAxis(stack, world, player, side, axis);
               }
            }
         }
      }

      return false;
   }

   @Nullable
   public RayTraceResult getArchitectMOP(@NotNull ItemStack stack, @NotNull World world, @NotNull EntityLivingBase player) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(world, "world");
      Intrinsics.checkParameterIsNotNull(player, "player");
      ItemFocus focus = this.getFocus(stack);
      if (focus != null) {
         FocusPackage fp = ItemFocus.getPackage(this.getFocusStack(stack));
         if (fp != null && FocusEngine.doesPackageContainElement(fp, "thaumcraft.PLAN")) {
            IFocusElement var10000 = FocusEngine.getElement("thaumcraft.PLAN");
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type thaumcraft.api.items.IArchitect");
            }

            return ((IArchitect)var10000).getArchitectMOP(this.getFocusStack(stack), world, player);
         }
      }

      return null;
   }

   public boolean useBlockHighlight(@NotNull ItemStack stack) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      return false;
   }

   public final void storePickedBlock(@NotNull ItemStack stack, @NotNull ItemStack stackout) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(stackout, "stackout");
      NBTTagCompound item = new NBTTagCompound();
      stack.func_77983_a("picked", (NBTBase)stackout.func_77955_b(item));
   }

   @Nullable
   public ItemStack getPickedBlock(@Nullable ItemStack stack) {
      if (stack != null && !stack.func_190926_b()) {
         ItemStack out = (ItemStack)null;
         ItemFocus focus = this.getFocus(stack);
         if (focus != null && stack.func_77942_o()) {
            NBTTagCompound var10000 = stack.func_77978_p();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            if (var10000.func_74764_b("picked")) {
               FocusPackage fp = ItemFocus.getPackage(this.getFocusStack(stack));
               if (fp != null) {
                  for(Object var9 : fp.nodes) {
                     if (var9 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type thaumcraft.api.casters.IFocusElement");
                     }

                     IFocusElement fe = (IFocusElement)var9;
                     if (fe instanceof IFocusBlockPicker) {
                        out = new ItemStack(Blocks.field_150350_a);

                        try {
                           ItemStack var10 = new ItemStack;
                           NBTTagCompound var10002 = stack.func_77978_p();
                           if (var10002 == null) {
                              Intrinsics.throwNpe();
                           }

                           var10.<init>(var10002.func_74775_l("picked"));
                           out = var10;
                        } catch (Exception var8) {
                        }
                        break;
                     }
                  }
               }
            }
         }

         return out;
      } else {
         return ItemStack.field_190927_a;
      }
   }

   public BasicBattleGauntlet(int area, @NotNull Item.ToolMaterial material) {
      Intrinsics.checkParameterIsNotNull(material, "material");
      super(material);
      this.area = area;
      this.myFormatter = new DecimalFormat("#######.#");
      this.field_77777_bU = 1;
      this.func_77656_e(0);
      this.func_185043_a(new ResourceLocation("focus"), null.INSTANCE);
   }

   // $FF: synthetic method
   public BasicBattleGauntlet(int var1, Item.ToolMaterial var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 1) != 0) {
         var1 = 0;
      }

      this(var1, var2);
   }
}

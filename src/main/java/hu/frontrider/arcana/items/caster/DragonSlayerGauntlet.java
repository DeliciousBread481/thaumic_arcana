package hu.frontrider.arcana.items.caster;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0010"},
   d2 = {"Lhu/frontrider/arcana/items/caster/DragonSlayerGauntlet;", "Lhu/frontrider/arcana/items/caster/BasicBattleGauntlet;", "area", "", "(I)V", "drain", "", "capability", "Lnet/minecraftforge/energy/IEnergyStorage;", "hitEntity", "", "stack", "Lnet/minecraft/item/ItemStack;", "target", "Lnet/minecraft/entity/EntityLivingBase;", "attacker", "Thaumic Arcana"}
)
public final class DragonSlayerGauntlet extends BasicBattleGauntlet {
   public boolean func_77644_a(@NotNull ItemStack stack, @NotNull EntityLivingBase target, @NotNull EntityLivingBase attacker) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(target, "target");
      Intrinsics.checkParameterIsNotNull(attacker, "attacker");
      if (target.hasCapability(CapabilityEnergy.ENERGY, (EnumFacing)null)) {
         Object var10000 = target.getCapability(CapabilityEnergy.ENERGY, (EnumFacing)null);
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var10000, "target.getCapability(Cap…ityEnergy.ENERGY, null)!!");
         IEnergyStorage capability = (IEnergyStorage)var10000;
         this.drain(capability);
      }

      if (target.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (EnumFacing)null)) {
         Object var10 = target.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (EnumFacing)null);
         if (var10 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var10, "target.getCapability(Cap…NDLER_CAPABILITY, null)!!");
         IItemHandler capability = (IItemHandler)var10;
         int i = 0;

         for(int var6 = capability.getSlots(); i < var6; ++i) {
            ItemStack var11 = capability.getStackInSlot(i);
            Intrinsics.checkExpressionValueIsNotNull(var11, "capability.getStackInSlot(i)");
            ItemStack stackInSlot = var11;
            if (stackInSlot.hasCapability(CapabilityEnergy.ENERGY, (EnumFacing)null)) {
               Object var12 = stackInSlot.getCapability(CapabilityEnergy.ENERGY, (EnumFacing)null);
               if (var12 == null) {
                  Intrinsics.throwNpe();
               }

               Intrinsics.checkExpressionValueIsNotNull(var12, "stackInSlot.getCapabilit…ityEnergy.ENERGY, null)!!");
               IEnergyStorage energy = (IEnergyStorage)var12;
               this.drain(energy);
            }
         }
      }

      return true;
   }

   public final void drain(@NotNull IEnergyStorage capability) {
      Intrinsics.checkParameterIsNotNull(capability, "capability");
      capability.extractEnergy(capability.getEnergyStored(), false);
   }

   public DragonSlayerGauntlet(int area) {
      super(area, ToolMaterial.DIAMOND);
   }
}

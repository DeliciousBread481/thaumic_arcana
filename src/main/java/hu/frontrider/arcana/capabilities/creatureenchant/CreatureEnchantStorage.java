package hu.frontrider.arcana.capabilities.creatureenchant;

import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EnchantingBaseCircle;
import java.util.Collection;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/capabilities/creatureenchant/CreatureEnchantStorage;", "Lnet/minecraftforge/common/capabilities/Capability$IStorage;", "Lhu/frontrider/arcana/capabilities/creatureenchant/ICreatureEnchant;", "()V", "readNBT", "", "capability", "Lnet/minecraftforge/common/capabilities/Capability;", "instance", "side", "Lnet/minecraft/util/EnumFacing;", "nbt", "Lnet/minecraft/nbt/NBTBase;", "writeNBT", "Thaumic Arcana"}
)
public final class CreatureEnchantStorage implements Capability.IStorage<ICreatureEnchant> {
   @Nullable
   public NBTBase writeNBT(@NotNull Capability<ICreatureEnchant> capability, @NotNull ICreatureEnchant instance, @Nullable EnumFacing side) {
      Intrinsics.checkParameterIsNotNull(capability, "capability");
      Intrinsics.checkParameterIsNotNull(instance, "instance");
      NBTTagCompound storage = new NBTTagCompound();
      NBTTagList enchantmentNBTList = new NBTTagList();
      Collection enchants = instance.getStore().values();

      for(Object element$iv : (Iterable)enchants) {
         CreatureEnchantCapability.CreatureEnchantContainer enchant = (CreatureEnchantCapability.CreatureEnchantContainer)element$iv;
         NBTTagCompound enchantData = new NBTTagCompound();
         enchantData.func_74768_a("level", enchant.getLevel());
         enchantData.func_74768_a("usedTo", enchant.getUsedTo());
         ResourceLocation var10002 = enchant.getCreatureEnchant().getRegistryName();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         enchantData.func_74778_a("enchant", var10002.toString());
         enchantData.func_74757_a("enabled", enchant.getEnabled());
         enchantmentNBTList.func_74742_a((NBTBase)enchantData);
      }

      storage.func_74782_a("enchants", (NBTBase)enchantmentNBTList);
      ResourceLocation var14 = instance.getCircle().getRegistryName();
      if (var14 == null) {
         Intrinsics.throwNpe();
      }

      storage.func_74778_a("base", var14.toString());
      return (NBTBase)storage;
   }

   public void readNBT(@NotNull Capability<ICreatureEnchant> capability, @NotNull final ICreatureEnchant instance, @Nullable EnumFacing side, @NotNull NBTBase nbt) {
      Intrinsics.checkParameterIsNotNull(capability, "capability");
      Intrinsics.checkParameterIsNotNull(instance, "instance");
      Intrinsics.checkParameterIsNotNull(nbt, "nbt");
      NBTTagList enchants;
      if (nbt instanceof NBTTagList) {
         enchants = (NBTTagList)nbt;
      } else {
         NBTTagCompound compound = (NBTTagCompound)nbt;
         NBTBase var10000 = compound.func_74781_a("enchants");
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagList");
         }

         enchants = (NBTTagList)var10000;
         if (compound.func_74764_b("base")) {
            EnchantingBaseCircle base = (EnchantingBaseCircle)GameRegistry.findRegistry(EnchantingBaseCircle.class).getValue(new ResourceLocation(compound.func_74779_i("base")));
            if (base == null) {
               Intrinsics.throwNpe();
            }

            instance.setCircle(base);
         } else {
            EnchantingBaseCircle base = (EnchantingBaseCircle)GameRegistry.findRegistry(EnchantingBaseCircle.class).getValue(new ResourceLocation("thaumic_arcana", "normal"));
            if (base == null) {
               Intrinsics.throwNpe();
            }

            instance.setCircle(base);
         }
      }

      enchants.iterator().forEachRemaining(new Consumer<NBTBase>() {
         public final void accept(NBTBase enchant) {
            if (enchant == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
            } else {
               String enchantName = ((NBTTagCompound)enchant).func_74779_i("enchant");
               int level = ((NBTTagCompound)enchant).func_74762_e("level");
               ResourceLocation enchantment = new ResourceLocation(enchantName);
               CreatureEnchant creatureEnchant = (CreatureEnchant)GameRegistry.findRegistry(CreatureEnchant.class).getValue(enchantment);
               int usedTo = 0;
               if (((NBTTagCompound)enchant).func_74764_b("usedTo")) {
                  usedTo = ((NBTTagCompound)enchant).func_74762_e("usedTo");
               }

               boolean enabled = true;
               if (((NBTTagCompound)enchant).func_74764_b("enabled")) {
                  enabled = ((NBTTagCompound)enchant).func_74767_n("enabled");
               }

               CreatureEnchantCapability.CreatureEnchantContainer var10000 = new CreatureEnchantCapability.CreatureEnchantContainer;
               if (creatureEnchant == null) {
                  Intrinsics.throwNpe();
               }

               var10000.<init>(creatureEnchant, level, usedTo, enabled);
               CreatureEnchantCapability.CreatureEnchantContainer creatureEnchantContainer = var10000;
               instance.putEnchant(creatureEnchantContainer);
            }
         }
      });
   }
}

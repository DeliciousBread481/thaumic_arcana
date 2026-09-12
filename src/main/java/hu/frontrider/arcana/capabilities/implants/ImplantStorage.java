package hu.frontrider.arcana.capabilities.implants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/capabilities/implants/ImplantStorage;", "Lnet/minecraftforge/common/capabilities/Capability$IStorage;", "Lhu/frontrider/arcana/capabilities/implants/ITAImplants;", "()V", "readNBT", "", "capability", "Lnet/minecraftforge/common/capabilities/Capability;", "instance", "side", "Lnet/minecraft/util/EnumFacing;", "nbt", "Lnet/minecraft/nbt/NBTBase;", "writeNBT", "Thaumic Arcana"}
)
public final class ImplantStorage implements Capability.IStorage<ITAImplants> {
   @Nullable
   public NBTBase writeNBT(@NotNull Capability<ITAImplants> capability, @NotNull ITAImplants instance, @NotNull EnumFacing side) {
      Intrinsics.checkParameterIsNotNull(capability, "capability");
      Intrinsics.checkParameterIsNotNull(instance, "instance");
      Intrinsics.checkParameterIsNotNull(side, "side");
      NBTTagList tagList = new NBTTagList();
      Map $receiver$iv = instance.getImplants();
      Collection destination$iv$iv = (Collection)(new ArrayList($receiver$iv.size()));

      for(Map.Entry item$iv$iv : $receiver$iv.entrySet()) {
         Slot slot = (Slot)item$iv$iv.getKey();
         IImplant it = (IImplant)item$iv$iv.getValue();
         NBTTagCompound tag = new NBTTagCompound();
         tag.func_74782_a("data", (NBTBase)it.getData());
         tag.func_74778_a("name", String.valueOf(it.getRegistryName()));
         tag.func_74778_a("slot", slot.name());
         destination$iv$iv.add(tag);
      }

      for(Object element$iv : (Iterable)((List)destination$iv$iv)) {
         NBTTagCompound it = (NBTTagCompound)element$iv;
         tagList.func_74742_a((NBTBase)it);
      }

      return (NBTBase)tagList;
   }

   public void readNBT(@Nullable Capability<ITAImplants> capability, @NotNull ITAImplants instance, @NotNull EnumFacing side, @NotNull NBTBase nbt) {
      Intrinsics.checkParameterIsNotNull(instance, "instance");
      Intrinsics.checkParameterIsNotNull(side, "side");
      Intrinsics.checkParameterIsNotNull(nbt, "nbt");
      IForgeRegistry implantRegistry = GameRegistry.findRegistry(IImplant.class);

      for(Object element$iv : (Iterable)((NBTTagList)nbt)) {
         NBTBase it = (NBTBase)element$iv;
         if (it == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
         }

         NBTTagCompound compound = (NBTTagCompound)it;
         ResourceLocation regname = new ResourceLocation(compound.func_74779_i("name"));
         if (implantRegistry.containsKey(regname)) {
            IForgeRegistryEntry var10000 = implantRegistry.getValue(regname);
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            Intrinsics.checkExpressionValueIsNotNull(var10000, "implantRegistry.getValue(regname)!!");
            IImplant implant = (IImplant)var10000;
            NBTTagCompound var10001 = compound.func_74775_l("data");
            Intrinsics.checkExpressionValueIsNotNull(var10001, "compound.getCompoundTag(\"data\")");
            implant.setData(var10001);
            String var16 = ((NBTTagCompound)it).func_74779_i("slot");
            Intrinsics.checkExpressionValueIsNotNull(var16, "it.getString(\"slot\")");
            Slot slot = Slot.valueOf(var16);
            instance.setImplant(slot, implant);
         }
      }

   }
}

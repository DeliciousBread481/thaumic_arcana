package hu.frontrider.arcana.capabilities.inhibitor;

import hu.frontrider.arcana.api.InhibitorAiWrapper;
import hu.frontrider.arcana.entity.inhibitor.IInhibitedAIKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/capabilities/inhibitor/InhibitorStorage;", "Lnet/minecraftforge/common/capabilities/Capability$IStorage;", "Lhu/frontrider/arcana/capabilities/inhibitor/IInhibitor;", "()V", "readNBT", "", "capability", "Lnet/minecraftforge/common/capabilities/Capability;", "instance", "side", "Lnet/minecraft/util/EnumFacing;", "nbt", "Lnet/minecraft/nbt/NBTBase;", "writeNBT", "Thaumic Arcana"}
)
public final class InhibitorStorage implements Capability.IStorage<IInhibitor> {
   @Nullable
   public NBTBase writeNBT(@NotNull Capability<IInhibitor> capability, @NotNull IInhibitor instance, @Nullable EnumFacing side) {
      Intrinsics.checkParameterIsNotNull(capability, "capability");
      Intrinsics.checkParameterIsNotNull(instance, "instance");
      NBTTagCompound storage = new NBTTagCompound();
      storage.func_74757_a("isInhibited", instance.getInhibited());
      NBTTagList inhibitedAI = new NBTTagList();

      for(Object element$iv : (Iterable)instance.getAiList()) {
         InhibitorAiWrapper it = (InhibitorAiWrapper)element$iv;
         NBTTagCompound ai = new NBTTagCompound();
         ResourceLocation $receiver = it.getID();
         Intrinsics.checkExpressionValueIsNotNull($receiver, "this");
         ai.func_74778_a("domain", $receiver.func_110624_b());
         ai.func_74778_a("path", $receiver.func_110623_a());
         ai.func_74768_a("priority", it.getPriority());
         inhibitedAI.func_74742_a((NBTBase)ai);
      }

      storage.func_74782_a("inhibitor", (NBTBase)inhibitedAI);
      return (NBTBase)storage;
   }

   public void readNBT(@NotNull Capability<IInhibitor> capability, @NotNull IInhibitor instance, @Nullable EnumFacing side, @NotNull NBTBase nbt) {
      Intrinsics.checkParameterIsNotNull(capability, "capability");
      Intrinsics.checkParameterIsNotNull(instance, "instance");
      Intrinsics.checkParameterIsNotNull(nbt, "nbt");
      NBTTagCompound nbtTagCompound = (NBTTagCompound)nbt;
      instance.setInhibited(nbtTagCompound.func_74767_n("isInhibited"));
      NBTBase var10000 = ((NBTTagCompound)nbt).func_74781_a("inhibitor");
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagList");
      } else {
         for(Object element$iv : (Iterable)((NBTTagList)var10000)) {
            NBTBase it = (NBTBase)element$iv;
            if (it == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
            }

            NBTTagCompound $receiver = (NBTTagCompound)it;
            $receiver.func_74764_b("priority");
            ResourceLocation resourceLocation = new ResourceLocation($receiver.func_74779_i("domain"), $receiver.func_74779_i("path"));
            ArrayList selectedAI = new ArrayList();
            if (IInhibitedAIKt.getAiList().containsKey(resourceLocation)) {
               Object var10001 = IInhibitedAIKt.getAiList().get(resourceLocation);
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               selectedAI.add(var10001);
            }

            instance.setAiList((List)selectedAI);
         }

      }
   }
}

package hu.frontrider.arcana.capabilities.scar;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J(\u0010\r\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/capabilities/scar/ScarredStorage;", "Lnet/minecraftforge/common/capabilities/Capability$IStorage;", "Lhu/frontrider/arcana/capabilities/scar/IScarred;", "()V", "readNBT", "", "capability", "Lnet/minecraftforge/common/capabilities/Capability;", "instance", "side", "Lnet/minecraft/util/EnumFacing;", "nbt", "Lnet/minecraft/nbt/NBTBase;", "writeNBT", "Thaumic Arcana"}
)
public final class ScarredStorage implements Capability.IStorage<IScarred> {
   public void readNBT(@Nullable Capability<IScarred> capability, @NotNull IScarred instance, @Nullable EnumFacing side, @Nullable NBTBase nbt) {
      Intrinsics.checkParameterIsNotNull(instance, "instance");
      if (nbt == null) {
         throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
      } else {
         NBTTagCompound var5 = (NBTTagCompound)nbt;
         if (var5.func_74764_b("requiredDamage")) {
            instance.setRequiredDamage(var5.func_74762_e("requiredDamage"));
         }

         if (var5.func_74764_b("currentDamage")) {
            instance.setCurrentDamage(var5.func_74760_g("currentDamage"));
         }

         if (var5.func_74764_b("severity")) {
            instance.setSeverity(var5.func_74771_c("severity"));
         }

         if (var5.func_74764_b("limbs")) {
            Limbs var10000 = instance.getLimbs();
            NBTBase var10001 = var5.func_74781_a("limbs");
            if (var10001 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
            }

            var10000.fromNbt((NBTTagCompound)var10001);
         }

      }
   }

   @NotNull
   public NBTBase writeNBT(@NotNull Capability<IScarred> capability, @NotNull IScarred instance, @Nullable EnumFacing side) {
      Intrinsics.checkParameterIsNotNull(capability, "capability");
      Intrinsics.checkParameterIsNotNull(instance, "instance");
      NBTTagCompound nbtTagCompound = new NBTTagCompound();
      nbtTagCompound.func_74768_a("requiredDamage", instance.getRequiredDamage());
      nbtTagCompound.func_74776_a("currentDamage", instance.getCurrentDamage());
      nbtTagCompound.func_74774_a("severity", instance.getSeverity());
      nbtTagCompound.func_74782_a("limbs", (NBTBase)instance.getLimbs().toNbt());
      return (NBTBase)nbtTagCompound;
   }
}

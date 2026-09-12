package hu.frontrider.arcana.capabilities.implants;

import kotlin.Metadata;
import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/capabilities/implants/IImplant;", "Lnet/minecraftforge/registries/IForgeRegistryEntry$Impl;", "()V", "getData", "Lnet/minecraft/nbt/NBTTagCompound;", "getSlot", "", "setData", "nbt", "supports", "", "type", "Ljava/lang/Class;", "Lnet/minecraft/entity/EntityLiving;", "Thaumic Arcana"}
)
public abstract class IImplant extends IForgeRegistryEntry.Impl<IImplant> {
   public abstract boolean supports(@NotNull Class<EntityLiving> var1);

   public abstract void getSlot();

   @NotNull
   public abstract NBTTagCompound getData();

   public abstract void setData(@NotNull NBTTagCompound var1);
}

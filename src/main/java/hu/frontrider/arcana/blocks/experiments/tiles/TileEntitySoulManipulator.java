package hu.frontrider.arcana.blocks.experiments.tiles;

import hu.frontrider.arcana.capabilities.EssentiaRecieverTrait;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.IEssentiaTransport;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J1\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00132\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J-\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J!\u0010\u001c\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u001e\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J!\u0010\u001f\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u001e\u0010 \u001a\u00020\u00132\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016J\u0019\u0010!\u001a\u00020\u00132\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J!\u0010&\u001a\u00020#2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0096\u0001J1\u0010'\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0010\u0010(\u001a\u00020%2\u0006\u0010$\u001a\u00020%H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006)"},
   d2 = {"Lhu/frontrider/arcana/blocks/experiments/tiles/TileEntitySoulManipulator;", "Lnet/minecraft/tileentity/TileEntity;", "Lthaumcraft/api/aspects/IEssentiaTransport;", "essentiaReciever", "Lhu/frontrider/arcana/capabilities/EssentiaRecieverTrait;", "(Lhu/frontrider/arcana/capabilities/EssentiaRecieverTrait;)V", "cage", "Lnet/minecraftforge/items/ItemStackHandler;", "getEssentiaReciever", "()Lhu/frontrider/arcana/capabilities/EssentiaRecieverTrait;", "addEssentia", "", "p0", "Lthaumcraft/api/aspects/Aspect;", "kotlin.jvm.PlatformType", "p1", "p2", "Lnet/minecraft/util/EnumFacing;", "canInputFrom", "", "canOutputTo", "getCapability", "T", "capability", "Lnet/minecraftforge/common/capabilities/Capability;", "facing", "(Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/util/EnumFacing;)Ljava/lang/Object;", "getEssentiaAmount", "getEssentiaType", "getMinimumSuction", "getSuctionAmount", "getSuctionType", "hasCapability", "isConnectable", "readFromNBT", "", "compound", "Lnet/minecraft/nbt/NBTTagCompound;", "setSuction", "takeEssentia", "writeToNBT", "Thaumic Arcana"}
)
public final class TileEntitySoulManipulator extends TileEntity implements IEssentiaTransport {
   private final ItemStackHandler cage;
   @NotNull
   private final EssentiaRecieverTrait essentiaReciever;

   @NotNull
   public NBTTagCompound func_189515_b(@NotNull NBTTagCompound compound) {
      Intrinsics.checkParameterIsNotNull(compound, "compound");
      compound.func_74782_a("slot", (NBTBase)this.cage.serializeNBT());
      compound.func_74768_a("amount", this.essentiaReciever.getAmount());
      NBTTagCompound var10000 = super.func_189515_b(compound);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "super.writeToNBT(compound)");
      return var10000;
   }

   public void func_145839_a(@NotNull NBTTagCompound compound) {
      Intrinsics.checkParameterIsNotNull(compound, "compound");
      this.cage.deserializeNBT(compound.func_74775_l("slot"));
      this.essentiaReciever.setAmount(compound.func_74762_e("amount"));
      super.func_145839_a(compound);
   }

   public boolean hasCapability(@NotNull Capability<?> capability, @Nullable EnumFacing facing) {
      Intrinsics.checkParameterIsNotNull(capability, "capability");
      return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
   }

   @Nullable
   public <T> T getCapability(@NotNull Capability<T> capability, @Nullable EnumFacing facing) {
      Intrinsics.checkParameterIsNotNull(capability, "capability");
      return (T)(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(this.cage) : super.getCapability(capability, facing));
   }

   @NotNull
   public final EssentiaRecieverTrait getEssentiaReciever() {
      return this.essentiaReciever;
   }

   public TileEntitySoulManipulator(@NotNull EssentiaRecieverTrait essentiaReciever) {
      Intrinsics.checkParameterIsNotNull(essentiaReciever, "essentiaReciever");
      super();
      this.essentiaReciever = essentiaReciever;
      this.cage = new ItemStackHandler(1);
   }

   // $FF: synthetic method
   public TileEntitySoulManipulator(EssentiaRecieverTrait var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         Aspect var10002 = Aspect.SOUL;
         Intrinsics.checkExpressionValueIsNotNull(var10002, "Aspect.SOUL");
         var1 = new EssentiaRecieverTrait(var10002, new EnumFacing[]{EnumFacing.DOWN});
      }

      this(var1);
   }

   public TileEntitySoulManipulator() {
      this((EssentiaRecieverTrait)null, 1, (DefaultConstructorMarker)null);
   }

   public int addEssentia(Aspect p0, int p1, EnumFacing p2) {
      return this.essentiaReciever.addEssentia(p0, p1, p2);
   }

   public boolean canInputFrom(EnumFacing p0) {
      return this.essentiaReciever.canInputFrom(p0);
   }

   public boolean canOutputTo(EnumFacing p0) {
      return this.essentiaReciever.canOutputTo(p0);
   }

   public int getEssentiaAmount(EnumFacing p0) {
      return this.essentiaReciever.getEssentiaAmount(p0);
   }

   public Aspect getEssentiaType(EnumFacing p0) {
      return this.essentiaReciever.getEssentiaType(p0);
   }

   public int getMinimumSuction() {
      return this.essentiaReciever.getMinimumSuction();
   }

   public int getSuctionAmount(EnumFacing p0) {
      return this.essentiaReciever.getSuctionAmount(p0);
   }

   public Aspect getSuctionType(EnumFacing p0) {
      return this.essentiaReciever.getSuctionType(p0);
   }

   public boolean isConnectable(EnumFacing p0) {
      return this.essentiaReciever.isConnectable(p0);
   }

   public void setSuction(Aspect p0, int p1) {
      this.essentiaReciever.setSuction(p0, p1);
   }

   public int takeEssentia(Aspect p0, int p1, EnumFacing p2) {
      return this.essentiaReciever.takeEssentia(p0, p1, p2);
   }
}

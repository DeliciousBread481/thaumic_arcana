package hu.frontrider.arcana.blocks;

import hu.frontrider.core.util.data.BlockposKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\r"},
   d2 = {"Lhu/frontrider/arcana/blocks/PlaceHolderTile;", "Lnet/minecraft/tileentity/TileEntity;", "targePos", "Lnet/minecraft/util/math/BlockPos;", "(Lnet/minecraft/util/math/BlockPos;)V", "getTargePos", "()Lnet/minecraft/util/math/BlockPos;", "setTargePos", "readFromNBT", "", "compound", "Lnet/minecraft/nbt/NBTTagCompound;", "writeToNBT", "Thaumic Arcana"}
)
public final class PlaceHolderTile extends TileEntity {
   @NotNull
   private BlockPos targePos;

   @NotNull
   public NBTTagCompound func_189515_b(@NotNull NBTTagCompound compound) {
      Intrinsics.checkParameterIsNotNull(compound, "compound");
      compound.func_74782_a("pos", (NBTBase)BlockposKt.toNBT(this.targePos));
      return compound;
   }

   public void func_145839_a(@NotNull NBTTagCompound compound) {
      Intrinsics.checkParameterIsNotNull(compound, "compound");
      NBTBase var10001 = compound.func_74781_a("pos");
      if (var10001 == null) {
         throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
      } else {
         this.targePos = BlockposKt.toBlockPos((NBTTagCompound)var10001);
      }
   }

   @NotNull
   public final BlockPos getTargePos() {
      return this.targePos;
   }

   public final void setTargePos(@NotNull BlockPos var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.targePos = var1;
   }

   public PlaceHolderTile(@NotNull BlockPos targePos) {
      Intrinsics.checkParameterIsNotNull(targePos, "targePos");
      super();
      this.targePos = targePos;
   }

   // $FF: synthetic method
   public PlaceHolderTile(BlockPos var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         var1 = new BlockPos(0, 0, 0);
      }

      this(var1);
   }

   public PlaceHolderTile() {
      this((BlockPos)null, 1, (DefaultConstructorMarker)null);
   }
}

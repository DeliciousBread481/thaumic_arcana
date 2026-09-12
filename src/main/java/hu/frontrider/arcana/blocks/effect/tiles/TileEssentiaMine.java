package hu.frontrider.arcana.blocks.effect.tiles;

import hu.frontrider.arcana.AspectEffectMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\n\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"},
   d2 = {"Lhu/frontrider/arcana/blocks/effect/tiles/TileEssentiaMine;", "Lnet/minecraft/tileentity/TileEntity;", "time", "", "(I)V", "()V", "aspect", "Lthaumcraft/api/aspects/Aspect;", "getAspect", "()Lthaumcraft/api/aspects/Aspect;", "setAspect", "(Lthaumcraft/api/aspects/Aspect;)V", "isUsedUp", "", "()Z", "applyEffect", "", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "readFromNBT", "compound", "Lnet/minecraft/nbt/NBTTagCompound;", "string", "", "writeToNBT", "Thaumic Arcana"}
)
public final class TileEssentiaMine extends TileEntity {
   private int time;
   @NotNull
   private Aspect aspect;

   @NotNull
   public final Aspect getAspect() {
      return this.aspect;
   }

   public final void setAspect(@NotNull Aspect var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.aspect = var1;
   }

   public final void applyEffect(@NotNull EntityLivingBase entity) {
      Intrinsics.checkParameterIsNotNull(entity, "entity");
      PotionEffect var10001 = new PotionEffect;
      Object var10003 = AspectEffectMap.INSTANCE.getMap().get(this.aspect);
      if (var10003 == null) {
         Intrinsics.throwNpe();
      }

      var10001.<init>(((AspectEffectMap.EffectEntry)var10003).getPotion(), 40, 0);
      entity.func_70690_d(var10001);
      --this.time;
   }

   public final boolean isUsedUp() {
      return this.time <= 0;
   }

   @NotNull
   public NBTTagCompound func_189515_b(@NotNull NBTTagCompound compound) {
      Intrinsics.checkParameterIsNotNull(compound, "compound");
      compound.func_74768_a("time", this.time);
      compound.func_74778_a("aspect", this.aspect.getTag());
      return compound;
   }

   public void func_145839_a(@NotNull NBTTagCompound compound) {
      Intrinsics.checkParameterIsNotNull(compound, "compound");
      if (compound.func_74764_b("time")) {
         this.time = compound.func_74762_e("time");
      }

      if (compound.func_74764_b("aspect")) {
         Aspect var10001 = Aspect.getAspect(compound.func_74779_i("aspect"));
         Intrinsics.checkExpressionValueIsNotNull(var10001, "Aspect.getAspect(compound.getString(\"aspect\"))");
         this.aspect = var10001;
      }

   }

   public final void setAspect(@NotNull String string) {
      Intrinsics.checkParameterIsNotNull(string, "string");
      Aspect var10001 = Aspect.getAspect(string);
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Aspect.getAspect(string)");
      this.aspect = var10001;
   }

   public TileEssentiaMine() {
      Aspect var10001 = Aspect.BEAST;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "Aspect.BEAST");
      this.aspect = var10001;
   }

   public TileEssentiaMine(int time) {
      this();
      this.time = time;
   }
}

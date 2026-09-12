package hu.frontrider.arcana.capabilities.creatureenchant;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J-\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00112\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lhu/frontrider/arcana/capabilities/creatureenchant/CreatureEnchantProvider;", "Lnet/minecraftforge/common/capabilities/ICapabilitySerializable;", "Lnet/minecraft/nbt/NBTBase;", "()V", "instance", "Lhu/frontrider/arcana/capabilities/creatureenchant/ICreatureEnchant;", "deserializeNBT", "", "nbt", "getCapability", "T", "capability", "Lnet/minecraftforge/common/capabilities/Capability;", "facing", "Lnet/minecraft/util/EnumFacing;", "(Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/util/EnumFacing;)Ljava/lang/Object;", "hasCapability", "", "serializeNBT", "Companion", "Thaumic Arcana"}
)
public final class CreatureEnchantProvider implements ICapabilitySerializable<NBTBase> {
   private final ICreatureEnchant instance;
   @CapabilityInject(ICreatureEnchant.class)
   @NotNull
   public static Capability<ICreatureEnchant> CREATURE_ENCHANT_CAPABILITY;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public boolean hasCapability(@NotNull Capability<?> capability, @Nullable EnumFacing facing) {
      Intrinsics.checkParameterIsNotNull(capability, "capability");
      Capability var10001 = CREATURE_ENCHANT_CAPABILITY;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("CREATURE_ENCHANT_CAPABILITY");
      }

      return capability == var10001;
   }

   @Nullable
   public <T> T getCapability(@NotNull Capability<T> capability, @Nullable EnumFacing facing) {
      Intrinsics.checkParameterIsNotNull(capability, "capability");
      Capability var10001 = CREATURE_ENCHANT_CAPABILITY;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("CREATURE_ENCHANT_CAPABILITY");
      }

      Object var3;
      if (capability == var10001) {
         Capability var10000 = CREATURE_ENCHANT_CAPABILITY;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("CREATURE_ENCHANT_CAPABILITY");
         }

         var3 = var10000.cast(this.instance);
      } else {
         var3 = null;
      }

      return (T)var3;
   }

   @Nullable
   public NBTBase serializeNBT() {
      Capability var10000 = CREATURE_ENCHANT_CAPABILITY;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("CREATURE_ENCHANT_CAPABILITY");
      }

      Capability.IStorage var1 = var10000.getStorage();
      Capability var10001 = CREATURE_ENCHANT_CAPABILITY;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("CREATURE_ENCHANT_CAPABILITY");
      }

      return var1.writeNBT(var10001, this.instance, (EnumFacing)null);
   }

   public void deserializeNBT(@NotNull NBTBase nbt) {
      Intrinsics.checkParameterIsNotNull(nbt, "nbt");
      Capability var10000 = CREATURE_ENCHANT_CAPABILITY;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("CREATURE_ENCHANT_CAPABILITY");
      }

      Capability.IStorage var2 = var10000.getStorage();
      Capability var10001 = CREATURE_ENCHANT_CAPABILITY;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("CREATURE_ENCHANT_CAPABILITY");
      }

      var2.readNBT(var10001, this.instance, (EnumFacing)null, nbt);
   }

   public CreatureEnchantProvider() {
      Capability var10001 = CREATURE_ENCHANT_CAPABILITY;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("CREATURE_ENCHANT_CAPABILITY");
      }

      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      this.instance = (ICreatureEnchant)var10001.getDefaultInstance();
   }

   // $FF: synthetic method
   @NotNull
   public static final Capability access$getCREATURE_ENCHANT_CAPABILITY$cp() {
      Capability var10000 = CREATURE_ENCHANT_CAPABILITY;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("CREATURE_ENCHANT_CAPABILITY");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"},
      d2 = {"Lhu/frontrider/arcana/capabilities/creatureenchant/CreatureEnchantProvider$Companion;", "", "()V", "CREATURE_ENCHANT_CAPABILITY", "Lnet/minecraftforge/common/capabilities/Capability;", "Lhu/frontrider/arcana/capabilities/creatureenchant/ICreatureEnchant;", "getCREATURE_ENCHANT_CAPABILITY", "()Lnet/minecraftforge/common/capabilities/Capability;", "setCREATURE_ENCHANT_CAPABILITY", "(Lnet/minecraftforge/common/capabilities/Capability;)V", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final Capability<ICreatureEnchant> getCREATURE_ENCHANT_CAPABILITY() {
         return CreatureEnchantProvider.access$getCREATURE_ENCHANT_CAPABILITY$cp();
      }

      public final void setCREATURE_ENCHANT_CAPABILITY(@NotNull Capability<ICreatureEnchant> var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         CreatureEnchantProvider.CREATURE_ENCHANT_CAPABILITY = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

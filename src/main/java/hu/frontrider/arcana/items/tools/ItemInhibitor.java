package hu.frontrider.arcana.items.tools;

import hu.frontrider.arcana.capabilities.inhibitor.IInhibitor;
import hu.frontrider.arcana.capabilities.inhibitor.InhibitorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"},
   d2 = {"Lhu/frontrider/arcana/items/tools/ItemInhibitor;", "Lnet/minecraft/item/Item;", "()V", "itemInteractionForEntity", "", "stack", "Lnet/minecraft/item/ItemStack;", "playerIn", "Lnet/minecraft/entity/player/EntityPlayer;", "target", "Lnet/minecraft/entity/EntityLivingBase;", "hand", "Lnet/minecraft/util/EnumHand;", "Companion", "Thaumic Arcana"}
)
public final class ItemInhibitor extends Item {
   @ObjectHolder("thaumic_arcana:experience_store")
   @NotNull
   public static Item experience_store;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public boolean func_111207_a(@NotNull ItemStack stack, @NotNull EntityPlayer playerIn, @NotNull EntityLivingBase target, @NotNull EnumHand hand) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(playerIn, "playerIn");
      Intrinsics.checkParameterIsNotNull(target, "target");
      Intrinsics.checkParameterIsNotNull(hand, "hand");
      if (target instanceof EntityLiving && target.hasCapability(InhibitorProvider.Companion.getINHIBITOR_CAPABILITY(), (EnumFacing)null)) {
         Object var10000 = target.getCapability(InhibitorProvider.Companion.getINHIBITOR_CAPABILITY(), (EnumFacing)null);
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var10000, "target.getCapability(INHIBITOR_CAPABILITY, null)!!");
         IInhibitor capability = (IInhibitor)var10000;
         capability.setInhibited(true);
         ((EntityLiving)target).field_70714_bg.field_75782_a.clear();
         ItemStack var10002 = new ItemStack;
         Item var10004 = experience_store;
         if (var10004 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("experience_store");
         }

         var10002.<init>(var10004);
         playerIn.func_184611_a(hand, var10002);
         return true;
      } else {
         return false;
      }
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getExperience_store$cp() {
      Item var10000 = experience_store;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("experience_store");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"},
      d2 = {"Lhu/frontrider/arcana/items/tools/ItemInhibitor$Companion;", "", "()V", "experience_store", "Lnet/minecraft/item/Item;", "getExperience_store", "()Lnet/minecraft/item/Item;", "setExperience_store", "(Lnet/minecraft/item/Item;)V", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final Item getExperience_store() {
         return ItemInhibitor.access$getExperience_store$cp();
      }

      public final void setExperience_store(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ItemInhibitor.experience_store = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

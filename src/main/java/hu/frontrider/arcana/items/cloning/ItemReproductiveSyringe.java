package hu.frontrider.arcana.items.cloning;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0011"},
   d2 = {"Lhu/frontrider/arcana/items/cloning/ItemReproductiveSyringe;", "Lnet/minecraft/item/Item;", "()V", "itemInteractionForEntity", "", "stack", "Lnet/minecraft/item/ItemStack;", "playerIn", "Lnet/minecraft/entity/player/EntityPlayer;", "target", "Lnet/minecraft/entity/EntityLivingBase;", "hand", "Lnet/minecraft/util/EnumHand;", "makeBottle", "animal", "Lnet/minecraft/entity/passive/EntityAnimal;", "Companion", "Thaumic Arcana"}
)
public final class ItemReproductiveSyringe extends Item {
   @ObjectHolder("thaumic_arcana:reproductive_material")
   @NotNull
   public static Item reproductive_material;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public boolean func_111207_a(@NotNull ItemStack stack, @NotNull EntityPlayer playerIn, @NotNull EntityLivingBase target, @NotNull EnumHand hand) {
      Intrinsics.checkParameterIsNotNull(stack, "stack");
      Intrinsics.checkParameterIsNotNull(playerIn, "playerIn");
      Intrinsics.checkParameterIsNotNull(target, "target");
      Intrinsics.checkParameterIsNotNull(hand, "hand");
      if (target instanceof EntityAnimal && ((EntityAnimal)target).func_70880_s()) {
         EnumHand correctHand = hand == EnumHand.MAIN_HAND ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
         ItemStack bottle = playerIn.func_184586_b(correctHand);
         Intrinsics.checkExpressionValueIsNotNull(bottle, "bottle");
         if (Intrinsics.areEqual(bottle.func_77973_b(), Items.field_151069_bo)) {
            bottle.func_190918_g(1);
            ItemStack reprMaterial = this.makeBottle((EntityAnimal)target);
            if (!playerIn.field_71071_by.func_70441_a(reprMaterial)) {
               playerIn.field_70170_p.func_72838_d((Entity)(new EntityItem(playerIn.field_70170_p, playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, reprMaterial)));
            }

            return true;
         }
      }

      return false;
   }

   @NotNull
   public final ItemStack makeBottle(@NotNull EntityAnimal animal) {
      Intrinsics.checkParameterIsNotNull(animal, "animal");
      ItemStack var10000 = new ItemStack;
      Item var10002 = reproductive_material;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("reproductive_material");
      }

      var10000.<init>(var10002);
      ItemStack itemStack = var10000;
      NBTTagCompound nbtTagCompound = new NBTTagCompound();
      String var12 = animal.func_189512_bd();
      Intrinsics.checkExpressionValueIsNotNull(var12, "animal.cachedUniqueIdString");
      List uniqueIdString = StringsKt.split$default((CharSequence)var12, new String[]{"-"}, false, 0, 6, (Object)null);
      NBTTagCompound unique = new NBTTagCompound();
      NBTTagCompound $receiver = unique;
      int index = 0;

      for(String it : (Iterable)uniqueIdString) {
         $receiver.func_74778_a("id" + index, it);
         ++index;
      }

      NBTTagCompound animalNbt = animal.func_189511_e(new NBTTagCompound());
      nbtTagCompound.func_74782_a("unique", (NBTBase)unique);
      nbtTagCompound.func_74782_a("animal", (NBTBase)animalNbt);
      itemStack.func_77982_d(nbtTagCompound);
      return itemStack;
   }

   // $FF: synthetic method
   @NotNull
   public static final Item access$getReproductive_material$cp() {
      Item var10000 = reproductive_material;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("reproductive_material");
      }

      return var10000;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"},
      d2 = {"Lhu/frontrider/arcana/items/cloning/ItemReproductiveSyringe$Companion;", "", "()V", "reproductive_material", "Lnet/minecraft/item/Item;", "getReproductive_material", "()Lnet/minecraft/item/Item;", "setReproductive_material", "(Lnet/minecraft/item/Item;)V", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final Item getReproductive_material() {
         return ItemReproductiveSyringe.access$getReproductive_material$cp();
      }

      public final void setReproductive_material(@NotNull Item var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         ItemReproductiveSyringe.reproductive_material = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

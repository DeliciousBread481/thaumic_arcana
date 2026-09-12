package hu.frontrider.arcana.creatureenchant.effect;

import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.util.items.InventoryKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"},
   d2 = {"Lhu/frontrider/arcana/creatureenchant/effect/ProductivityEnchant;", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "()V", "research", "", "getResearch", "()Ljava/lang/String;", "entityDrop", "", "event", "Lnet/minecraftforge/event/entity/living/LivingDropsEvent;", "formula", "Lthaumcraft/api/aspects/AspectList;", "Thaumic Arcana"}
)
public final class ProductivityEnchant extends CreatureEnchant {
   @NotNull
   public String getResearch() {
      return "CREATURE_ENCHANT_ADVANCED2";
   }

   @SubscribeEvent
   public final void entityDrop(@NotNull LivingDropsEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityLivingBase entity = event.getEntityLiving();
      Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
      int enchantLevel = this.getEnchantLevel(entity, this);
      if (enchantLevel != 0) {
         if (enchantLevel > 0) {
            if (entity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (EnumFacing)null)) {
               Object var18 = entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (EnumFacing)null);
               if (var18 == null) {
                  Intrinsics.throwNpe();
               }

               Intrinsics.checkExpressionValueIsNotNull(var18, "entity.getCapability(ITE…NDLER_CAPABILITY, null)!!");
               IItemHandler iItemHandler = (IItemHandler)var18;

               for(EntityItem it : event.getDrops()) {
                  Iterable var19 = entity.func_184193_aE();
                  Intrinsics.checkExpressionValueIsNotNull(var19, "entity.armorInventoryList");
                  Intrinsics.checkExpressionValueIsNotNull(it, "it");
                  if (!CollectionsKt.contains(var19, it.func_92059_d())) {
                     ItemStack var10001 = it.func_92059_d();
                     Intrinsics.checkExpressionValueIsNotNull(var10001, "it.item");
                     if (!InventoryKt.contains(iItemHandler, var10001)) {
                        int it = 0;

                        for(int var8 = enchantLevel; it < var8; ++it) {
                           it.field_70170_p.func_72838_d((Entity)(new EntityItem(it.field_70170_p, it.field_70165_t, it.field_70163_u, it.field_70161_v, it.func_92059_d())));
                        }
                     }
                  }
               }
            } else {
               for(EntityItem it : event.getDrops()) {
                  Iterable var10000 = entity.func_184193_aE();
                  Intrinsics.checkExpressionValueIsNotNull(var10000, "entity.armorInventoryList");
                  Intrinsics.checkExpressionValueIsNotNull(it, "it");
                  if (!CollectionsKt.contains(var10000, it.func_92059_d())) {
                     int i = 0;

                     for(int i = enchantLevel; i < i; ++i) {
                        it.field_70170_p.func_72838_d((Entity)(new EntityItem(it.field_70170_p, it.field_70165_t, it.field_70163_u, it.field_70161_v, it.func_92059_d())));
                     }
                  }
               }
            }
         }

         if (enchantLevel < 0) {
            List var20 = event.getDrops();
            Intrinsics.checkExpressionValueIsNotNull(var20, "event.drops");

            for(Object element$iv : (Iterable)var20) {
               EntityItem it = (EntityItem)element$iv;
               it.field_70170_p.func_72900_e((Entity)it);
            }
         }
      }

   }

   @NotNull
   public AspectList formula() {
      AspectList var10000 = (new AspectList()).merge(Aspect.LIFE, 300).merge(Aspect.EARTH, 30).merge(Aspect.MAGIC, 500).merge(Aspect.PLANT, 10);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "AspectList()\n           … .merge(Aspect.PLANT, 10)");
      return var10000;
   }

   public ProductivityEnchant() {
      super(new ResourceLocation("thaumic_arcana", "productivity"), "productivity");
   }
}

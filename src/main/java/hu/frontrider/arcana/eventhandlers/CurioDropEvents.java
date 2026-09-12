package hu.frontrider.arcana.eventhandlers;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;
import thaumcraft.common.golems.EntityThaumcraftGolem;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"},
   d2 = {"Lhu/frontrider/arcana/eventhandlers/CurioDropEvents;", "", "()V", "entityDrop", "", "event", "Lnet/minecraftforge/event/entity/living/LivingDropsEvent;", "Companion", "Thaumic Arcana"}
)
public final class CurioDropEvents {
   @ObjectHolder("thaumic_arcana:organic_curiosity")
   private static Item organic_curio;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @SubscribeEvent
   public final void entityDrop(@NotNull LivingDropsEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      DamageSource var10000 = event.getSource();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "event.source");
      Entity var8 = var10000.func_76346_g();
      if (var8 != null) {
         Intrinsics.checkExpressionValueIsNotNull(var8, "(event.source.trueSource ?: return)");
         Entity source = var8;
         if (!(event.getEntityLiving() instanceof EntityThaumcraftGolem)) {
            if (source instanceof EntityPlayer || source instanceof EntityPlayer) {
               boolean knowsResearchStrict = ThaumcraftCapabilities.knowsResearch((EntityPlayer)source, new String[]{"TA_RESEARCH"});
               if (knowsResearchStrict) {
                  Entity entity = event.getEntity();
                  World world = entity.field_70170_p;
                  if (world.field_73012_v.nextInt(10) <= 1) {
                     return;
                  }

                  EntityItem item = new EntityItem(world, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
                  ItemStack var9 = new ItemStack;
                  Item var10002 = organic_curio;
                  if (var10002 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("organic_curio");
                  }

                  var9.<init>(var10002, world.field_73012_v.nextInt(2));
                  ItemStack itemStack = var9;
                  item.func_92058_a(itemStack);
                  world.func_72838_d((Entity)item);
               }

            }
         }
      }
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000¨\u0006\u0005"},
      d2 = {"Lhu/frontrider/arcana/eventhandlers/CurioDropEvents$Companion;", "", "()V", "organic_curio", "Lnet/minecraft/item/Item;", "Thaumic Arcana"}
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

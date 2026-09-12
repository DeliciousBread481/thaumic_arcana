package hu.frontrider.arcana.eventhandlers;

import hu.frontrider.arcana.TAConfig;
import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantProvider;
import hu.frontrider.arcana.capabilities.creatureenchant.ICreatureEnchant;
import hu.frontrider.arcana.capabilities.inhibitor.InhibitorProvider;
import hu.frontrider.arcana.capabilities.scar.ScarProvider;
import hu.frontrider.arcana.entity.inhibitor.IInhibitedAIKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0007¨\u0006\u000b"},
   d2 = {"Lhu/frontrider/arcana/eventhandlers/LifecycleEventManager;", "", "()V", "attachCapability", "", "event", "Lnet/minecraftforge/event/AttachCapabilitiesEvent;", "Lnet/minecraft/entity/Entity;", "onPlayerClone", "Lnet/minecraftforge/event/entity/player/PlayerEvent$Clone;", "Companion", "Thaumic Arcana"}
)
public final class LifecycleEventManager {
   private static final ResourceLocation CREATURE_ENCHANT = new ResourceLocation("thaumic_arcana", "creature_enchant");
   private static final ResourceLocation SCAR = new ResourceLocation("thaumic_arcana", "scar");
   private static final ResourceLocation INHIBITOR = new ResourceLocation("thaumic_arcana", "inhibitor");
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @SubscribeEvent
   public final void onPlayerClone(@NotNull PlayerEvent.Clone event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityPlayer original = event.getOriginal();
      if (!event.isWasDeath()) {
         if (original.hasCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null)) {
            EntityPlayer player = event.getEntityPlayer();
            ICreatureEnchant creatureEnchant = (ICreatureEnchant)player.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
            ICreatureEnchant oldCreatureEnchant = (ICreatureEnchant)original.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
            if (creatureEnchant == null) {
               Intrinsics.throwNpe();
            }

            if (oldCreatureEnchant == null) {
               Intrinsics.throwNpe();
            }

            creatureEnchant.setStore(oldCreatureEnchant.getStore());
         }

      }
   }

   @SubscribeEvent
   public final void attachCapability(@NotNull AttachCapabilitiesEvent<Entity> event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      Entity object = (Entity)event.getObject();
      if (object instanceof EntityLiving) {
         for(String entry : TAConfig.entityBlacklist) {
            EntityEntry entityEntry = (EntityEntry)ForgeRegistries.ENTITIES.getValue(new ResourceLocation(entry));
            if (entityEntry != null && Intrinsics.areEqual(entityEntry.getEntityClass(), ((EntityLiving)object).getClass()) ^ true) {
               event.addCapability(CREATURE_ENCHANT, (ICapabilityProvider)(new CreatureEnchantProvider()));
            }
         }

         boolean isPeople = false;

         for(String entry : IInhibitedAIKt.getPeopleList()) {
            EntityEntry entityEntry = (EntityEntry)ForgeRegistries.ENTITIES.getValue(new ResourceLocation(entry));
            if (entityEntry != null) {
               isPeople = isPeople && Intrinsics.areEqual(entityEntry.getEntityClass(), ((EntityLiving)object).getClass());
            }
         }

         if (!isPeople) {
            event.addCapability(INHIBITOR, (ICapabilityProvider)(new InhibitorProvider()));
         }
      }

      if (object instanceof EntityPlayer) {
         event.addCapability(CREATURE_ENCHANT, (ICapabilityProvider)(new CreatureEnchantProvider()));
         event.addCapability(SCAR, (ICapabilityProvider)(new ScarProvider()));
      }

   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"},
      d2 = {"Lhu/frontrider/arcana/eventhandlers/LifecycleEventManager$Companion;", "", "()V", "CREATURE_ENCHANT", "Lnet/minecraft/util/ResourceLocation;", "INHIBITOR", "SCAR", "Thaumic Arcana"}
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

package hu.frontrider.arcana.sided.network.creatureenchants;

import hu.frontrider.arcana.ThaumicArcana;
import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantProvider;
import hu.frontrider.arcana.capabilities.creatureenchant.ICreatureEnchant;
import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0007¨\u0006\u000b"},
   d2 = {"Lhu/frontrider/arcana/sided/network/creatureenchants/CreatureEnchantSynchroniser;", "", "()V", "EntityTrack", "", "event", "Lnet/minecraftforge/event/entity/player/PlayerEvent$StartTracking;", "entityJoin", "Lnet/minecraftforge/event/entity/EntityJoinWorldEvent;", "syncPlayer", "Lnet/minecraftforge/fml/common/gameevent/PlayerEvent$PlayerLoggedInEvent;", "Thaumic Arcana"}
)
public final class CreatureEnchantSynchroniser {
   @SubscribeEvent(
      receiveCanceled = true,
      priority = EventPriority.HIGH
   )
   public final void EntityTrack(@NotNull PlayerEvent.StartTracking event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      Entity target = event.getTarget();
      if (target.hasCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null)) {
         EntityPlayer entityPlayer = event.getEntityPlayer();
         Intrinsics.checkExpressionValueIsNotNull(target, "target");
         int entityId = target.func_145782_y();
         SimpleNetworkWrapper var10000 = ThaumicArcana.INSTANCE.getNETWORK_WRAPPER();
         CreatureEnchantSyncMessage var10001 = new CreatureEnchantSyncMessage;
         Object var10003 = target.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
         if (var10003 == null) {
            Intrinsics.throwNpe();
         }

         Intrinsics.checkExpressionValueIsNotNull(var10003, "target.getCapability<ICr…CHANT_CAPABILITY, null)!!");
         var10001.<init>((ICreatureEnchant)var10003, entityId);
         IMessage var5 = var10001;
         if (entityPlayer == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.player.EntityPlayerMP");
         }

         var10000.sendTo(var5, (EntityPlayerMP)entityPlayer);
      }

   }

   @SubscribeEvent
   @SideOnly(Side.CLIENT)
   public final void entityJoin(@NotNull EntityJoinWorldEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      Entity entity = event.getEntity();
      Map var10000 = CreatureEnchantSyncMessageHandler.Companion.getEnchantmentCache();
      Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
      if (var10000.containsKey(entity.func_145782_y())) {
         CreatureEnchant.Companion var3 = CreatureEnchant.Companion;
         Object var10002 = CreatureEnchantSyncMessageHandler.Companion.getEnchantmentCache().get(entity.func_145782_y());
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         var3.setEnchantment(entity, (ICreatureEnchant)var10002);
         CreatureEnchantSyncMessageHandler.Companion.getEnchantmentCache().remove(entity.func_145782_y());
      }

   }

   @SubscribeEvent
   public final void syncPlayer(@NotNull net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      EntityPlayer entity = event.player;
      Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
      int entityId = entity.func_145782_y();
      SimpleNetworkWrapper var10000 = ThaumicArcana.INSTANCE.getNETWORK_WRAPPER();
      CreatureEnchantSyncMessage var10001 = new CreatureEnchantSyncMessage;
      Object var10003 = entity.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
      if (var10003 == null) {
         Intrinsics.throwNpe();
      }

      Intrinsics.checkExpressionValueIsNotNull(var10003, "entity.getCapability<ICr…CHANT_CAPABILITY, null)!!");
      var10001.<init>((ICreatureEnchant)var10003, entityId);
      var10000.sendTo(var10001, (EntityPlayerMP)entity);
   }
}

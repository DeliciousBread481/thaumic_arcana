package hu.frontrider.arcana.sided.network.creatureenchants;

import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantProvider;
import hu.frontrider.arcana.capabilities.creatureenchant.ICreatureEnchant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"},
   d2 = {"Lhu/frontrider/arcana/sided/network/creatureenchants/CreatureEnchantSyncMessageHandler;", "Lnet/minecraftforge/fml/common/network/simpleimpl/IMessageHandler;", "Lhu/frontrider/arcana/sided/network/creatureenchants/CreatureEnchantSyncMessage;", "Lnet/minecraftforge/fml/common/network/simpleimpl/IMessage;", "()V", "onMessage", "message", "ctx", "Lnet/minecraftforge/fml/common/network/simpleimpl/MessageContext;", "Companion", "Thaumic Arcana"}
)
public final class CreatureEnchantSyncMessageHandler implements IMessageHandler<CreatureEnchantSyncMessage, IMessage> {
   @NotNull
   private static Map<Integer, ICreatureEnchant> enchantmentCache = (Map)(new HashMap());
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @Nullable
   public IMessage onMessage(@NotNull CreatureEnchantSyncMessage message, @NotNull MessageContext ctx) {
      Intrinsics.checkParameterIsNotNull(message, "message");
      Intrinsics.checkParameterIsNotNull(ctx, "ctx");

      try {
         Entity var3 = Minecraft.func_71410_x().field_71441_e.func_73045_a(message.getId());
      } catch (Exception var7) {
         Map var4 = enchantmentCache;
         Integer var5 = message.getId();
         ICreatureEnchant var10000 = message.getEnchant();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         ICreatureEnchant var6 = var10000;
         var4.put(var5, var6);
         return null;
      }

      Entity entityByID = Minecraft.func_71410_x().field_71441_e.func_73045_a(message.getId());
      if (entityByID == null) {
         Map var10 = enchantmentCache;
         Integer var11 = message.getId();
         ICreatureEnchant var13 = message.getEnchant();
         if (var13 == null) {
            Intrinsics.throwNpe();
         }

         ICreatureEnchant var12 = var13;
         var10.put(var11, var12);
         return null;
      } else {
         if (entityByID.hasCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null)) {
            ICreatureEnchant capability = (ICreatureEnchant)entityByID.getCapability(CreatureEnchantProvider.Companion.getCREATURE_ENCHANT_CAPABILITY(), (EnumFacing)null);
            if (capability == null) {
               Intrinsics.throwNpe();
            }

            ICreatureEnchant var10001 = message.getEnchant();
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            capability.setStore(var10001.getStore());
            var10001 = message.getEnchant();
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            capability.setCircle(var10001.getCircle());
         }

         return null;
      }
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"},
      d2 = {"Lhu/frontrider/arcana/sided/network/creatureenchants/CreatureEnchantSyncMessageHandler$Companion;", "", "()V", "enchantmentCache", "", "", "Lhu/frontrider/arcana/capabilities/creatureenchant/ICreatureEnchant;", "getEnchantmentCache", "()Ljava/util/Map;", "setEnchantmentCache", "(Ljava/util/Map;)V", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final Map<Integer, ICreatureEnchant> getEnchantmentCache() {
         return CreatureEnchantSyncMessageHandler.enchantmentCache;
      }

      public final void setEnchantmentCache(@NotNull Map<Integer, ICreatureEnchant> var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         CreatureEnchantSyncMessageHandler.enchantmentCache = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

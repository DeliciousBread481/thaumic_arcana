package hu.frontrider.arcana.sided.network.creatureenchants;

import hu.frontrider.arcana.capabilities.creatureenchant.CreatureEnchantCapability;
import hu.frontrider.arcana.capabilities.creatureenchant.ICreatureEnchant;
import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EnchantingBaseCircle;
import io.netty.buffer.ByteBuf;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Lhu/frontrider/arcana/sided/network/creatureenchants/CreatureEnchantSyncMessage;", "Lnet/minecraftforge/fml/common/network/simpleimpl/IMessage;", "enchant", "Lhu/frontrider/arcana/capabilities/creatureenchant/ICreatureEnchant;", "id", "", "(Lhu/frontrider/arcana/capabilities/creatureenchant/ICreatureEnchant;I)V", "()V", "<set-?>", "getEnchant", "()Lhu/frontrider/arcana/capabilities/creatureenchant/ICreatureEnchant;", "setEnchant", "(Lhu/frontrider/arcana/capabilities/creatureenchant/ICreatureEnchant;)V", "enchantingBaseCircles", "Lnet/minecraftforge/registries/IForgeRegistry;", "Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;", "getId", "()I", "setId", "(I)V", "registry", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "fromBytes", "", "buf", "Lio/netty/buffer/ByteBuf;", "toBytes", "Companion", "Thaumic Arcana"}
)
public final class CreatureEnchantSyncMessage implements IMessage {
   @Nullable
   private ICreatureEnchant enchant;
   private int id;
   private final IForgeRegistry<EnchantingBaseCircle> enchantingBaseCircles;
   private final IForgeRegistry<CreatureEnchant> registry;
   private static final int byteLength = 1;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @Nullable
   public final ICreatureEnchant getEnchant() {
      return this.enchant;
   }

   private final void setEnchant(ICreatureEnchant var1) {
      this.enchant = var1;
   }

   public final int getId() {
      return this.id;
   }

   private final void setId(int var1) {
      this.id = var1;
   }

   public void fromBytes(@NotNull ByteBuf buf) {
      Intrinsics.checkParameterIsNotNull(buf, "buf");
      if (this.enchant == null) {
         this.enchant = new CreatureEnchantCapability();
      }

      this.id = ByteBufUtils.readVarInt(buf, 4);
      EnchantingBaseCircle baseCircle = (EnchantingBaseCircle)this.enchantingBaseCircles.getValue(new ResourceLocation(ByteBufUtils.readUTF8String(buf)));
      ICreatureEnchant var10000 = this.enchant;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      if (baseCircle == null) {
         Intrinsics.throwNpe();
      }

      var10000.setCircle(baseCircle);
      int count = ByteBufUtils.readVarInt(buf, byteLength);
      int i = 0;

      for(int var5 = count; i < var5; ++i) {
         boolean enabled = buf.readBoolean();
         String enchantIndex = ByteBufUtils.readUTF8String(buf);
         int level = ByteBufUtils.readVarInt(buf, byteLength);
         int usedTo = ByteBufUtils.readVarInt(buf, byteLength);
         CreatureEnchant creatureEnchant = (CreatureEnchant)this.registry.getValue(new ResourceLocation(enchantIndex));
         var10000 = this.enchant;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         CreatureEnchantCapability.CreatureEnchantContainer var10001 = new CreatureEnchantCapability.CreatureEnchantContainer;
         if (creatureEnchant == null) {
            Intrinsics.throwNpe();
         }

         var10001.<init>(creatureEnchant, level, usedTo, enabled);
         var10000.putEnchant(var10001);
      }

   }

   public void toBytes(@NotNull ByteBuf buf) {
      Intrinsics.checkParameterIsNotNull(buf, "buf");
      ICreatureEnchant var10000 = this.enchant;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      Collection store = var10000.getStore().values();
      ByteBufUtils.writeVarInt(buf, this.id, 4);
      ICreatureEnchant var10001 = this.enchant;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      ResourceLocation var13 = var10001.getCircle().getRegistryName();
      if (var13 == null) {
         Intrinsics.throwNpe();
      }

      ByteBufUtils.writeUTF8String(buf, var13.toString());
      ByteBufUtils.writeVarInt(buf, store.size(), byteLength);

      for(Object element$iv : (Iterable)store) {
         CreatureEnchantCapability.CreatureEnchantContainer $creatureEnchant_level_usedTo_enabled = (CreatureEnchantCapability.CreatureEnchantContainer)element$iv;
         CreatureEnchant creatureEnchant = $creatureEnchant_level_usedTo_enabled.component1();
         int level = $creatureEnchant_level_usedTo_enabled.component2();
         int usedTo = $creatureEnchant_level_usedTo_enabled.component3();
         boolean enabled = $creatureEnchant_level_usedTo_enabled.component4();
         buf.writeBoolean(enabled);
         var13 = creatureEnchant.getRegistryName();
         if (var13 == null) {
            Intrinsics.throwNpe();
         }

         ByteBufUtils.writeUTF8String(buf, var13.toString());
         ByteBufUtils.writeVarInt(buf, level, byteLength);
         ByteBufUtils.writeVarInt(buf, usedTo, byteLength);
      }

   }

   public CreatureEnchantSyncMessage() {
      IForgeRegistry var10001 = GameRegistry.findRegistry(CreatureEnchant.class);
      Intrinsics.checkExpressionValueIsNotNull(var10001, "GameRegistry.findRegistr…atureEnchant::class.java)");
      this.registry = var10001;
      var10001 = GameRegistry.findRegistry(EnchantingBaseCircle.class);
      Intrinsics.checkExpressionValueIsNotNull(var10001, "GameRegistry.findRegistr…ngBaseCircle::class.java)");
      this.enchantingBaseCircles = var10001;
   }

   public CreatureEnchantSyncMessage(@NotNull ICreatureEnchant enchant, int id) {
      Intrinsics.checkParameterIsNotNull(enchant, "enchant");
      this();
      this.enchant = enchant;
      this.id = id;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0005"},
      d2 = {"Lhu/frontrider/arcana/sided/network/creatureenchants/CreatureEnchantSyncMessage$Companion;", "", "()V", "byteLength", "", "Thaumic Arcana"}
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

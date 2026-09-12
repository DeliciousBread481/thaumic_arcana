package hu.frontrider.arcana.capabilities.creatureenchant;

import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EnchantingBaseCircle;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH&J\b\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\nH&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH&J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\nH&J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0014H&J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0014H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"},
   d2 = {"Lhu/frontrider/arcana/capabilities/creatureenchant/ICreatureEnchant;", "", "circle", "Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;", "getCircle", "()Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;", "setCircle", "(Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;)V", "store", "", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "Lhu/frontrider/arcana/capabilities/creatureenchant/CreatureEnchantCapability$CreatureEnchantContainer;", "getStore", "()Ljava/util/Map;", "setStore", "(Ljava/util/Map;)V", "getLevel", "", "enchant", "hasEnchant", "", "putEnchant", "", "creatureEnchantContainer", "removeEnchant", "setEnabledStatus", "status", "Thaumic Arcana"}
)
public interface ICreatureEnchant {
   @NotNull
   Map<CreatureEnchant, CreatureEnchantCapability.CreatureEnchantContainer> getStore();

   void setStore(@NotNull Map<CreatureEnchant, CreatureEnchantCapability.CreatureEnchantContainer> var1);

   @NotNull
   EnchantingBaseCircle getCircle();

   void setCircle(@NotNull EnchantingBaseCircle var1);

   boolean hasEnchant();

   boolean hasEnchant(@NotNull CreatureEnchant var1);

   int getLevel(@NotNull CreatureEnchant var1);

   void setEnabledStatus(@NotNull CreatureEnchant var1, boolean var2);

   void setEnabledStatus(boolean var1);

   void putEnchant(@NotNull CreatureEnchantCapability.CreatureEnchantContainer var1);

   void removeEnchant(@NotNull CreatureEnchant var1);
}

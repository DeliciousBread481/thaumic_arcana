package hu.frontrider.arcana.capabilities.creatureenchant;

import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EnchantingBaseCircle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u000e¢\u0006\u0002\n\u0000R<\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"},
   d2 = {"Lhu/frontrider/arcana/capabilities/creatureenchant/CreatureEnchantCapability;", "Lhu/frontrider/arcana/capabilities/creatureenchant/ICreatureEnchant;", "()V", "value", "Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;", "circle", "getCircle", "()Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;", "setCircle", "(Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;)V", "enchantingBaseCircle", "enchants", "", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "Lhu/frontrider/arcana/capabilities/creatureenchant/CreatureEnchantCapability$CreatureEnchantContainer;", "store", "getStore", "()Ljava/util/Map;", "setStore", "(Ljava/util/Map;)V", "getLevel", "", "enchant", "hasEnchant", "", "putEnchant", "", "creatureEnchantContainer", "removeEnchant", "setEnabledStatus", "status", "Companion", "CreatureEnchantContainer", "Thaumic Arcana"}
)
public final class CreatureEnchantCapability implements ICreatureEnchant {
   private Map<CreatureEnchant, CreatureEnchantContainer> enchants = (Map)(new HashMap());
   private EnchantingBaseCircle enchantingBaseCircle;
   @ObjectHolder("thaumic_arcana:normal")
   private static EnchantingBaseCircle baseCircle;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public void removeEnchant(@NotNull CreatureEnchant enchant) {
      Intrinsics.checkParameterIsNotNull(enchant, "enchant");
      this.enchants.remove(enchant);
   }

   public void setEnabledStatus(boolean status) {
      for(Object element$iv : (Iterable)this.enchants.keySet()) {
         CreatureEnchant it = (CreatureEnchant)element$iv;
         CreatureEnchantContainer var10000 = (CreatureEnchantContainer)this.enchants.get(it);
         if (var10000 != null) {
            var10000.setEnabled(status);
         }
      }

   }

   public void setEnabledStatus(@NotNull CreatureEnchant enchant, boolean status) {
      Intrinsics.checkParameterIsNotNull(enchant, "enchant");
      CreatureEnchantContainer var10000 = (CreatureEnchantContainer)this.enchants.get(enchant);
      if (var10000 != null) {
         var10000.setEnabled(status);
      }

   }

   @NotNull
   public Map<CreatureEnchant, CreatureEnchantContainer> getStore() {
      return this.enchants;
   }

   public void setStore(@NotNull Map<CreatureEnchant, CreatureEnchantContainer> value) {
      Intrinsics.checkParameterIsNotNull(value, "value");
      this.enchants = value;
   }

   @NotNull
   public EnchantingBaseCircle getCircle() {
      return this.enchantingBaseCircle;
   }

   public void setCircle(@NotNull EnchantingBaseCircle value) {
      Intrinsics.checkParameterIsNotNull(value, "value");
      this.enchantingBaseCircle = value;
   }

   public boolean hasEnchant() {
      if (this.enchants.isEmpty()) {
         return false;
      } else {
         Iterable $receiver$iv = (Iterable)this.enchants.values();
         Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));

         for(Object item$iv$iv : $receiver$iv) {
            CreatureEnchantContainer it = (CreatureEnchantContainer)item$iv$iv;
            Boolean var11 = it.getEnabled();
            destination$iv$iv.add(var11);
         }

         $receiver$iv = (Iterable)((List)destination$iv$iv);
         destination$iv$iv = (Collection)(new ArrayList());

         for(Object element$iv$iv : $receiver$iv) {
            boolean it = (Boolean)element$iv$iv;
            if (it) {
               destination$iv$iv.add(element$iv$iv);
            }
         }

         Collection var13 = (Collection)((List)destination$iv$iv);
         return var13.size() > 0;
      }
   }

   public boolean hasEnchant(@NotNull CreatureEnchant enchant) {
      Intrinsics.checkParameterIsNotNull(enchant, "enchant");
      boolean var10000;
      if (!this.enchants.containsKey(enchant)) {
         var10000 = false;
      } else {
         Object var2 = this.enchants.get(enchant);
         if (var2 == null) {
            Intrinsics.throwNpe();
         }

         var10000 = ((CreatureEnchantContainer)var2).getEnabled();
      }

      return var10000;
   }

   public int getLevel(@NotNull CreatureEnchant enchant) {
      Intrinsics.checkParameterIsNotNull(enchant, "enchant");
      int var3;
      if (this.enchants.containsKey(enchant)) {
         Object var10000 = this.enchants.get(enchant);
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (((CreatureEnchantContainer)var10000).getEnabled()) {
            var10000 = this.enchants.get(enchant);
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var3 = ((CreatureEnchantContainer)var10000).getLevel();
         } else {
            var3 = 0;
         }
      } else {
         var3 = 0;
      }

      return var3;
   }

   public void putEnchant(@NotNull CreatureEnchantContainer creatureEnchantContainer) {
      Intrinsics.checkParameterIsNotNull(creatureEnchantContainer, "creatureEnchantContainer");
      Map var2 = this.enchants;
      CreatureEnchant var3 = creatureEnchantContainer.getCreatureEnchant();
      var2.put(var3, creatureEnchantContainer);
   }

   public CreatureEnchantCapability() {
      EnchantingBaseCircle var10001 = baseCircle;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      this.enchantingBaseCircle = var10001;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001d"},
      d2 = {"Lhu/frontrider/arcana/capabilities/creatureenchant/CreatureEnchantCapability$CreatureEnchantContainer;", "", "creatureEnchant", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "level", "", "usedTo", "enabled", "", "(Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;IIZ)V", "getCreatureEnchant", "()Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "getEnabled", "()Z", "setEnabled", "(Z)V", "getLevel", "()I", "getUsedTo", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "Thaumic Arcana"}
   )
   public static final class CreatureEnchantContainer {
      @NotNull
      private final CreatureEnchant creatureEnchant;
      private final int level;
      private final int usedTo;
      private boolean enabled;

      @NotNull
      public final CreatureEnchant getCreatureEnchant() {
         return this.creatureEnchant;
      }

      public final int getLevel() {
         return this.level;
      }

      public final int getUsedTo() {
         return this.usedTo;
      }

      public final boolean getEnabled() {
         return this.enabled;
      }

      public final void setEnabled(boolean var1) {
         this.enabled = var1;
      }

      public CreatureEnchantContainer(@NotNull CreatureEnchant creatureEnchant, int level, int usedTo, boolean enabled) {
         Intrinsics.checkParameterIsNotNull(creatureEnchant, "creatureEnchant");
         super();
         this.creatureEnchant = creatureEnchant;
         this.level = level;
         this.usedTo = usedTo;
         this.enabled = enabled;
      }

      // $FF: synthetic method
      public CreatureEnchantContainer(CreatureEnchant var1, int var2, int var3, boolean var4, int var5, DefaultConstructorMarker var6) {
         if ((var5 & 8) != 0) {
            var4 = true;
         }

         this(var1, var2, var3, var4);
      }

      @NotNull
      public final CreatureEnchant component1() {
         return this.creatureEnchant;
      }

      public final int component2() {
         return this.level;
      }

      public final int component3() {
         return this.usedTo;
      }

      public final boolean component4() {
         return this.enabled;
      }

      @NotNull
      public final CreatureEnchantContainer copy(@NotNull CreatureEnchant creatureEnchant, int level, int usedTo, boolean enabled) {
         Intrinsics.checkParameterIsNotNull(creatureEnchant, "creatureEnchant");
         return new CreatureEnchantContainer(creatureEnchant, level, usedTo, enabled);
      }

      // $FF: synthetic method
      @NotNull
      public static CreatureEnchantContainer copy$default(CreatureEnchantContainer var0, CreatureEnchant var1, int var2, int var3, boolean var4, int var5, Object var6) {
         if ((var5 & 1) != 0) {
            var1 = var0.creatureEnchant;
         }

         if ((var5 & 2) != 0) {
            var2 = var0.level;
         }

         if ((var5 & 4) != 0) {
            var3 = var0.usedTo;
         }

         if ((var5 & 8) != 0) {
            var4 = var0.enabled;
         }

         return var0.copy(var1, var2, var3, var4);
      }

      @NotNull
      public String toString() {
         return "CreatureEnchantContainer(creatureEnchant=" + this.creatureEnchant + ", level=" + this.level + ", usedTo=" + this.usedTo + ", enabled=" + this.enabled + ")";
      }

      public int hashCode() {
         CreatureEnchant var10000 = this.creatureEnchant;
         int var1 = (((var10000 != null ? var10000.hashCode() : 0) * 31 + Integer.hashCode(this.level)) * 31 + Integer.hashCode(this.usedTo)) * 31;
         byte var10001 = this.enabled;
         if (var10001 != 0) {
            var10001 = 1;
         }

         return var1 + var10001;
      }

      public boolean equals(@Nullable Object var1) {
         if (this != var1) {
            if (var1 instanceof CreatureEnchantContainer) {
               CreatureEnchantContainer var2 = (CreatureEnchantContainer)var1;
               if (Intrinsics.areEqual(this.creatureEnchant, var2.creatureEnchant) && this.level == var2.level && this.usedTo == var2.usedTo && this.enabled == var2.enabled) {
                  return true;
               }
            }

            return false;
         } else {
            return true;
         }
      }
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"},
      d2 = {"Lhu/frontrider/arcana/capabilities/creatureenchant/CreatureEnchantCapability$Companion;", "", "()V", "baseCircle", "Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;", "Thaumic Arcana"}
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

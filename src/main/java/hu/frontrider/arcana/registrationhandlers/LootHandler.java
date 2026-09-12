package hu.frontrider.arcana.registrationhandlers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0017"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/LootHandler;", "", "()V", "animated_curio", "Lnet/minecraft/world/storage/loot/LootEntry;", "getAnimated_curio", "()Lnet/minecraft/world/storage/loot/LootEntry;", "setAnimated_curio", "(Lnet/minecraft/world/storage/loot/LootEntry;)V", "aura_curio", "getAura_curio", "setAura_curio", "infused_curio", "getInfused_curio", "setInfused_curio", "magical_powder", "getMagical_powder", "setMagical_powder", "init", "", "onLootTableLoad", "event", "Lnet/minecraftforge/event/LootTableLoadEvent;", "Thaumic Arcana"}
)
public final class LootHandler {
   @NotNull
   private LootEntry magical_powder;
   @NotNull
   private LootEntry aura_curio;
   @NotNull
   private LootEntry animated_curio;
   @NotNull
   private LootEntry infused_curio;

   public final void init() {
      MinecraftForge.EVENT_BUS.register(this);
   }

   @NotNull
   public final LootEntry getMagical_powder() {
      return this.magical_powder;
   }

   public final void setMagical_powder(@NotNull LootEntry var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.magical_powder = var1;
   }

   @NotNull
   public final LootEntry getAura_curio() {
      return this.aura_curio;
   }

   public final void setAura_curio(@NotNull LootEntry var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.aura_curio = var1;
   }

   @NotNull
   public final LootEntry getAnimated_curio() {
      return this.animated_curio;
   }

   public final void setAnimated_curio(@NotNull LootEntry var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.animated_curio = var1;
   }

   @NotNull
   public final LootEntry getInfused_curio() {
      return this.infused_curio;
   }

   public final void setInfused_curio(@NotNull LootEntry var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.infused_curio = var1;
   }

   @SubscribeEvent
   public final void onLootTableLoad(@NotNull LootTableLoadEvent event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      ResourceLocation name = event.getName();
      if (Intrinsics.areEqual(name, LootTableList.field_186424_f) || Intrinsics.areEqual(name, LootTableList.field_186423_e) || Intrinsics.areEqual(name, LootTableList.field_186429_k) || Intrinsics.areEqual(name, LootTableList.field_191189_ay) || Intrinsics.areEqual(name, LootTableList.field_186430_l)) {
         try {
            LootPool pool = event.getTable().getPool("main");
            pool.addEntry(this.magical_powder);
         } catch (NullPointerException var4) {
         }
      }

      if (Intrinsics.areEqual(name, LootTableList.field_186423_e)) {
         LootPool pool = event.getTable().getPool("main");
         pool.addEntry(this.aura_curio);
         pool.addEntry(this.animated_curio);
         pool.addEntry(this.infused_curio);
      }

   }

   public LootHandler() {
      this.magical_powder = (LootEntry)(new LootEntryItem(ItemRegistry.Companion.getEnchanting_powder_magical(), 5, 1, new LootFunction[0], new LootCondition[0], "thaumic_arcana:magical_enchant_powder"));
      this.aura_curio = (LootEntry)(new LootEntryItem(ItemRegistry.Companion.getEnchanting_powder_magical(), 3, 1, new LootFunction[0], new LootCondition[0], "thaumic_arcana:vaporous_curiosoitx"));
      this.animated_curio = (LootEntry)(new LootEntryItem(ItemRegistry.Companion.getEnchanting_powder_magical(), 3, 1, new LootFunction[0], new LootCondition[0], "thaumic_arcana:animated_curiosity"));
      this.infused_curio = (LootEntry)(new LootEntryItem(ItemRegistry.Companion.getEnchanting_powder_magical(), 3, 1, new LootFunction[0], new LootCondition[0], "thaumic_arcana:infused_curiosity"));
   }
}

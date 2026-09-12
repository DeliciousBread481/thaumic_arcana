package hu.frontrider.arcana.registrationhandlers;

import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EnchantingBaseCircle;
import hu.frontrider.arcana.creatureenchant.base.EffectAmplifierCircle;
import hu.frontrider.arcana.creatureenchant.base.NegationCircle;
import hu.frontrider.arcana.creatureenchant.base.NormalCircle;
import hu.frontrider.arcana.creatureenchant.effect.AgilityEnchant;
import hu.frontrider.arcana.creatureenchant.effect.FertileEnchant;
import hu.frontrider.arcana.creatureenchant.effect.HasteEnchant;
import hu.frontrider.arcana.creatureenchant.effect.HealtBoostEnchant;
import hu.frontrider.arcana.creatureenchant.effect.ProductivityEnchant;
import hu.frontrider.arcana.creatureenchant.effect.ProtectionEnchant;
import hu.frontrider.arcana.creatureenchant.effect.RespirationEnchant;
import hu.frontrider.arcana.creatureenchant.effect.Speed;
import hu.frontrider.arcana.creatureenchant.effect.SpiderFingers;
import hu.frontrider.arcana.creatureenchant.effect.StrengthEnchant;
import hu.frontrider.arcana.creatureenchant.effect.Vitality;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0007¨\u0006\u000b"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/CreatureEnchantRegistry;", "", "()V", "registryEventCreatureEnchant", "", "event", "Lnet/minecraftforge/event/RegistryEvent$Register;", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "registryEventEnchantingBaseCircle", "Lhu/frontrider/arcana/creatureenchant/EnchantingBaseCircle;", "Companion", "Thaumic Arcana"}
)
public final class CreatureEnchantRegistry {
   @NotNull
   private static CreatureEnchant STRENGTH_ENCHANT = new StrengthEnchant();
   @NotNull
   private static CreatureEnchant FERTILE_ENCHANT = new FertileEnchant();
   @NotNull
   private static CreatureEnchant PROTECTION_ENCHANT = new ProtectionEnchant();
   @NotNull
   private static CreatureEnchant RESPIRATION_ENCHANT = new RespirationEnchant();
   @NotNull
   private static CreatureEnchant SPIDERFINGERS_ENCHANT = new SpiderFingers();
   @NotNull
   private static CreatureEnchant SPEED_ENCHANT = new Speed();
   @NotNull
   private static CreatureEnchant VITALITY_ENCHANT = new Vitality();
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @SubscribeEvent
   public final void registryEventCreatureEnchant(@NotNull RegistryEvent.Register<CreatureEnchant> event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      event.getRegistry().registerAll(new CreatureEnchant[]{STRENGTH_ENCHANT, SPEED_ENCHANT, SPIDERFINGERS_ENCHANT, PROTECTION_ENCHANT, FERTILE_ENCHANT, RESPIRATION_ENCHANT, VITALITY_ENCHANT, new HealtBoostEnchant(), new AgilityEnchant(), new HasteEnchant(), new ProductivityEnchant()});
   }

   @SubscribeEvent
   public final void registryEventEnchantingBaseCircle(@NotNull RegistryEvent.Register<EnchantingBaseCircle> event) {
      Intrinsics.checkParameterIsNotNull(event, "event");
      event.getRegistry().registerAll(new EnchantingBaseCircle[]{new NormalCircle(), new NegationCircle(), new EffectAmplifierCircle()});
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"},
      d2 = {"Lhu/frontrider/arcana/registrationhandlers/CreatureEnchantRegistry$Companion;", "", "()V", "FERTILE_ENCHANT", "Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "getFERTILE_ENCHANT", "()Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;", "setFERTILE_ENCHANT", "(Lhu/frontrider/arcana/creatureenchant/CreatureEnchant;)V", "PROTECTION_ENCHANT", "getPROTECTION_ENCHANT", "setPROTECTION_ENCHANT", "RESPIRATION_ENCHANT", "getRESPIRATION_ENCHANT", "setRESPIRATION_ENCHANT", "SPEED_ENCHANT", "getSPEED_ENCHANT", "setSPEED_ENCHANT", "SPIDERFINGERS_ENCHANT", "getSPIDERFINGERS_ENCHANT", "setSPIDERFINGERS_ENCHANT", "STRENGTH_ENCHANT", "getSTRENGTH_ENCHANT", "setSTRENGTH_ENCHANT", "VITALITY_ENCHANT", "getVITALITY_ENCHANT", "setVITALITY_ENCHANT", "Thaumic Arcana"}
   )
   public static final class Companion {
      @NotNull
      public final CreatureEnchant getSTRENGTH_ENCHANT() {
         return CreatureEnchantRegistry.STRENGTH_ENCHANT;
      }

      public final void setSTRENGTH_ENCHANT(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         CreatureEnchantRegistry.STRENGTH_ENCHANT = var1;
      }

      @NotNull
      public final CreatureEnchant getFERTILE_ENCHANT() {
         return CreatureEnchantRegistry.FERTILE_ENCHANT;
      }

      public final void setFERTILE_ENCHANT(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         CreatureEnchantRegistry.FERTILE_ENCHANT = var1;
      }

      @NotNull
      public final CreatureEnchant getPROTECTION_ENCHANT() {
         return CreatureEnchantRegistry.PROTECTION_ENCHANT;
      }

      public final void setPROTECTION_ENCHANT(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         CreatureEnchantRegistry.PROTECTION_ENCHANT = var1;
      }

      @NotNull
      public final CreatureEnchant getRESPIRATION_ENCHANT() {
         return CreatureEnchantRegistry.RESPIRATION_ENCHANT;
      }

      public final void setRESPIRATION_ENCHANT(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         CreatureEnchantRegistry.RESPIRATION_ENCHANT = var1;
      }

      @NotNull
      public final CreatureEnchant getSPIDERFINGERS_ENCHANT() {
         return CreatureEnchantRegistry.SPIDERFINGERS_ENCHANT;
      }

      public final void setSPIDERFINGERS_ENCHANT(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         CreatureEnchantRegistry.SPIDERFINGERS_ENCHANT = var1;
      }

      @NotNull
      public final CreatureEnchant getSPEED_ENCHANT() {
         return CreatureEnchantRegistry.SPEED_ENCHANT;
      }

      public final void setSPEED_ENCHANT(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         CreatureEnchantRegistry.SPEED_ENCHANT = var1;
      }

      @NotNull
      public final CreatureEnchant getVITALITY_ENCHANT() {
         return CreatureEnchantRegistry.VITALITY_ENCHANT;
      }

      public final void setVITALITY_ENCHANT(@NotNull CreatureEnchant var1) {
         Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
         CreatureEnchantRegistry.VITALITY_ENCHANT = var1;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}

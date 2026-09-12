package hu.frontrider.arcana.registrationhandlers;

import hu.frontrider.arcana.capabilities.implants.IImplant;
import hu.frontrider.arcana.creatureenchant.CreatureEnchant;
import hu.frontrider.arcana.creatureenchant.EnchantingBaseCircle;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.RegistryBuilder;

@EventBusSubscriber(
   modid = "thaumic_arcana"
)
public class RegistryHolder {
   @SubscribeEvent
   static void register(RegistryEvent.NewRegistry event) {
      (new RegistryBuilder()).setType(CreatureEnchant.class).setIDRange(0, 100).setName(new ResourceLocation("thaumic_arcana", "creature_enchant")).add((owner, stage, id, obj, oldObj) -> MinecraftForge.EVENT_BUS.register(obj)).create();
      (new RegistryBuilder()).setType(EnchantingBaseCircle.class).setIDRange(0, 100).setName(new ResourceLocation("thaumic_arcana", "enchanting_base_circle")).create();
      (new RegistryBuilder()).setType(IImplant.class).setIDRange(0, 100).setName(new ResourceLocation("thaumic_arcana", "implant")).add((owner, stage, id, obj, oldObj) -> MinecraftForge.EVENT_BUS.register(obj)).create();
   }
}

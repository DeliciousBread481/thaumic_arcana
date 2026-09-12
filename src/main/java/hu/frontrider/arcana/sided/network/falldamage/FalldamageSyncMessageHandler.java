package hu.frontrider.arcana.sided.network.falldamage;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class FalldamageSyncMessageHandler implements IMessageHandler<FalldamageSyncMessage, IMessage> {
   public IMessage onMessage(FalldamageSyncMessage message, MessageContext ctx) {
      ctx.getServerHandler().field_147369_b.field_70143_R = 0.0F;
      return null;
   }
}

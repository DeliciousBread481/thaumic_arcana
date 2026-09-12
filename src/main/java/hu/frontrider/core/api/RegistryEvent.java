package hu.frontrider.core.api;

import java.util.Collections;
import java.util.List;
import net.minecraftforge.fml.common.eventhandler.Event;

public class RegistryEvent<T> extends Event {
   private List<T> list;

   public RegistryEvent(List<T> items) {
      this.list = items;
   }

   public void register(T item) {
      this.list.add(item);
   }

   public void register(T... item) {
      Collections.addAll(this.list, item);
   }
}

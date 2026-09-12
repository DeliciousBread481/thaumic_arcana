package hu.frontrider.arcana.registrationhandlers;

import kotlin.Metadata;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"},
   d2 = {"Lhu/frontrider/arcana/registrationhandlers/OreDictionaryRegistry;", "", "()V", "init", "", "initFlesh", "Thaumic Arcana"}
)
public final class OreDictionaryRegistry {
   public final void init() {
      this.initFlesh();
   }

   public final void initFlesh() {
      for(Object element$iv : new Item[]{Items.field_151082_bd, Items.field_151076_bf, Items.field_151147_al, Items.field_151115_aP, Items.field_179561_bm}) {
         OreDictionary.registerOre("allFlesh", (Item)element$iv);
      }

   }
}

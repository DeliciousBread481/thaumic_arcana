package hu.frontrider.arcana.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.IEssentiaContainerItem;

public class ItemWithAspects extends ItemBase implements IEssentiaContainerItem {
   public ItemWithAspects(ResourceLocation resourceLocation) {
      super(resourceLocation);
   }

   public AspectList getAspects(ItemStack itemStack) {
      NBTTagCompound tagCompound = itemStack.func_77978_p();
      AspectList aspectList = new AspectList();
      if (tagCompound == null) {
         return aspectList;
      } else {
         aspectList.readFromNBT(tagCompound);
         return aspectList;
      }
   }

   public void setAspects(ItemStack itemStack, AspectList aspectList) {
      NBTTagCompound tagCompound = itemStack.func_77978_p();
      if (tagCompound == null) {
         tagCompound = new NBTTagCompound();
      }

      aspectList.writeToNBT(tagCompound);
      itemStack.func_77982_d(tagCompound);
   }

   public boolean ignoreContainedAspects() {
      return false;
   }
}

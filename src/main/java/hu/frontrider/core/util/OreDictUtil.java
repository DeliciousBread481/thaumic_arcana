package hu.frontrider.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"},
   d2 = {"Lhu/frontrider/core/util/OreDictUtil;", "", "()V", "blockMatchesName", "", "block", "Lnet/minecraft/block/Block;", "name", "", "Thaumic Arcana"}
)
public final class OreDictUtil {
   public static final OreDictUtil INSTANCE;

   public final boolean blockMatchesName(@NotNull Block block, @NotNull String name) {
      Intrinsics.checkParameterIsNotNull(block, "block");
      Intrinsics.checkParameterIsNotNull(name, "name");
      NonNullList oredictEntries = OreDictionary.getOres(name);
      boolean foundMatch = false;

      for(ItemStack itemStack : oredictEntries) {
         if (foundMatch) {
            break;
         }

         Intrinsics.checkExpressionValueIsNotNull(itemStack, "itemStack");
         Item item = itemStack.func_77973_b();
         if (item instanceof ItemBlock && ((ItemBlock)item).func_179223_d() == block) {
            foundMatch = true;
         }
      }

      return foundMatch;
   }

   private OreDictUtil() {
   }

   static {
      OreDictUtil var0 = new OreDictUtil();
      INSTANCE = var0;
   }
}

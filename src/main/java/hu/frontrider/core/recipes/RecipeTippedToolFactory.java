package hu.frontrider.core.recipes;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"},
   d2 = {"Lhu/frontrider/core/recipes/RecipeTippedToolFactory;", "Lnet/minecraftforge/common/crafting/IRecipeFactory;", "()V", "parse", "Lnet/minecraft/item/crafting/IRecipe;", "p0", "Lnet/minecraftforge/common/crafting/JsonContext;", "p1", "Lcom/google/gson/JsonObject;", "Thaumic Arcana"}
)
public final class RecipeTippedToolFactory implements IRecipeFactory {
   @NotNull
   public IRecipe parse(@Nullable JsonContext p0, @Nullable JsonObject p1) {
      return new RecipeTippedTool();
   }
}

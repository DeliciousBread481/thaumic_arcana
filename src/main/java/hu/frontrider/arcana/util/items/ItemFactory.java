package hu.frontrider.arcana.util.items;

import hu.frontrider.arcana.ThaumicArcana;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"},
   d2 = {"Lhu/frontrider/arcana/util/items/ItemFactory;", "", "()V", "start", "Lhu/frontrider/arcana/util/items/ItemFactory$ItemFactoryHelper;", "base", "Lnet/minecraft/item/Item;", "ItemFactoryHelper", "Thaumic Arcana"}
)
public final class ItemFactory {
   public static final ItemFactory INSTANCE;

   @NotNull
   public final ItemFactoryHelper start(@NotNull Item base) {
      Intrinsics.checkParameterIsNotNull(base, "base");
      return new ItemFactoryHelper(base);
   }

   private ItemFactory() {
   }

   static {
      ItemFactory var0 = new ItemFactory();
      INSTANCE = var0;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lhu/frontrider/arcana/util/items/ItemFactory$ItemFactoryHelper;", "", "base", "Lnet/minecraft/item/Item;", "(Lnet/minecraft/item/Item;)V", "getBase", "()Lnet/minecraft/item/Item;", "resourceLocation", "Lnet/minecraft/util/ResourceLocation;", "build", "setResourourceLocation", "name", "", "location", "Thaumic Arcana"}
   )
   public static final class ItemFactoryHelper {
      private ResourceLocation resourceLocation;
      @NotNull
      private final Item base;

      @NotNull
      public final ItemFactoryHelper setResourourceLocation(@NotNull ResourceLocation location) {
         Intrinsics.checkParameterIsNotNull(location, "location");
         this.resourceLocation = location;
         return this;
      }

      @NotNull
      public final ItemFactoryHelper setResourourceLocation(@NotNull String name) {
         Intrinsics.checkParameterIsNotNull(name, "name");
         this.resourceLocation = new ResourceLocation("thaumic_arcana", name);
         return this;
      }

      @NotNull
      public final Item build() {
         Item var10000 = this.base;
         ResourceLocation var10001 = this.resourceLocation;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceLocation");
         }

         var10000.setRegistryName(var10001);
         var10000 = this.base;
         StringBuilder var2 = (new StringBuilder()).append("thaumic_arcana.");
         ResourceLocation var10002 = this.resourceLocation;
         if (var10002 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceLocation");
         }

         var10000.func_77655_b(var2.append(var10002.func_110623_a()).toString());
         this.base.func_77637_a(ThaumicArcana.INSTANCE.getTABARCANA());
         return this.base;
      }

      @NotNull
      public final Item getBase() {
         return this.base;
      }

      public ItemFactoryHelper(@NotNull Item base) {
         Intrinsics.checkParameterIsNotNull(base, "base");
         super();
         this.base = base;
      }
   }
}

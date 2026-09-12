package hu.frontrider.core.util.factory;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\"\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"},
   d2 = {"Lhu/frontrider/core/util/factory/ItemFactory;", "", "()V", "creativeTabs", "Lnet/minecraft/creativetab/CreativeTabs;", "kotlin.jvm.PlatformType", "getCreativeTabs", "()Lnet/minecraft/creativetab/CreativeTabs;", "setCreativeTabs", "(Lnet/minecraft/creativetab/CreativeTabs;)V", "modid", "", "getModid", "()Ljava/lang/String;", "setModid", "(Ljava/lang/String;)V", "start", "Lhu/frontrider/core/util/factory/ItemFactory$ItemFactoryHelper;", "base", "Lnet/minecraft/item/Item;", "ItemFactoryHelper", "Thaumic Arcana"}
)
public final class ItemFactory {
   @NotNull
   private static String modid;
   private static CreativeTabs creativeTabs;
   public static final ItemFactory INSTANCE;

   @NotNull
   public final String getModid() {
      return modid;
   }

   public final void setModid(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      modid = var1;
   }

   public final CreativeTabs getCreativeTabs() {
      return creativeTabs;
   }

   public final void setCreativeTabs(CreativeTabs var1) {
      creativeTabs = var1;
   }

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
      modid = "minecraft";
      creativeTabs = CreativeTabs.field_78030_b;
   }

   @Metadata(
      mv = {1, 1, 13},
      bv = {1, 0, 3},
      k = 1,
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lhu/frontrider/core/util/factory/ItemFactory$ItemFactoryHelper;", "", "base", "Lnet/minecraft/item/Item;", "(Lnet/minecraft/item/Item;)V", "getBase", "()Lnet/minecraft/item/Item;", "resourceLocation", "Lnet/minecraft/util/ResourceLocation;", "build", "setResourourceLocation", "name", "", "location", "Thaumic Arcana"}
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
         this.resourceLocation = new ResourceLocation(ItemFactory.INSTANCE.getModid(), name);
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
         StringBuilder var2 = (new StringBuilder()).append(ItemFactory.INSTANCE.getModid()).append('.');
         ResourceLocation var10002 = this.resourceLocation;
         if (var10002 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceLocation");
         }

         var10000.func_77655_b(var2.append(var10002.func_110623_a()).toString());
         this.base.func_77637_a(ItemFactory.INSTANCE.getCreativeTabs());
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

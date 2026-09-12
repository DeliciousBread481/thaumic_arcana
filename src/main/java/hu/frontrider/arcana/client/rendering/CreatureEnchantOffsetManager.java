package hu.frontrider.arcana.client.rendering;

import hu.frontrider.arcana.ThaumicArcana;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ0\u0010\u0011\u001a\u00020\r2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00180\u0017H\u0002R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"},
   d2 = {"Lhu/frontrider/arcana/client/rendering/CreatureEnchantOffsetManager;", "", "()V", "offsets", "", "", "Lorg/apache/commons/lang3/tuple/Triple;", "", "getForEntity", "resourceLocation", "entityLivingBase", "Lnet/minecraft/entity/EntityLivingBase;", "initDefaults", "", "properties", "Ljava/util/Properties;", "loadConfigs", "reportError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "languageKey", "message", "Lkotlin/Function0;", "", "Thaumic Arcana"}
)
public final class CreatureEnchantOffsetManager {
   private Map<String, Triple<Float, Float, Float>> offsets;

   public final void loadConfigs() {
      final File file = new File(ThaumicArcana.INSTANCE.getConfigDirectory().getAbsolutePath() + "/enchantingCircleOffsets.properties");
      Properties offsetProperties = new Properties();
      if (!file.exists()) {
         this.initDefaults(offsetProperties);

         try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            offsetProperties.store((OutputStream)(new FileOutputStream(file)), "This file contains the offsets that are used to render the enchantment circles.\nSome entities may render their circles above their heads, or in the ground.This file provides a fix for that.");
         } catch (IOException e) {
            this.reportError((Exception)e, "rendering.thaumic_arcana.reload.failed", new Function0<String[]>() {
               @NotNull
               public final String[] invoke() {
                  return new String[]{"config file:" + file.getAbsolutePath()};
               }
            });
         }
      } else {
         try {
            offsetProperties.load((InputStream)(new FileInputStream(file)));
         } catch (IOException e) {
            this.reportError((Exception)e, "rendering.thaumic_arcana.reload.failed", new Function0<String[]>() {
               @NotNull
               public final String[] invoke() {
                  return new String[]{"config file:" + file.getAbsolutePath()};
               }
            });
         }
      }

      if (this.offsets == null) {
         this.offsets = (Map)(new HashMap());
      } else {
         Map var10000 = this.offsets;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.clear();
      }

      offsetProperties.forEach(new BiConsumer<Object, Object>() {
         public final void accept(final Object key, final Object value) {
            try {
               List var10000;
               label42: {
                  CharSequence thisCollection$iv = (CharSequence)value.toString();
                  String var5 = ",";
                  Regex var14 = new Regex(var5);
                  byte var6 = 0;
                  List $receiver$iv = var14.split(thisCollection$iv, var6);
                  if (!$receiver$iv.isEmpty()) {
                     ListIterator iterator$iv = $receiver$iv.listIterator($receiver$iv.size());

                     while(iterator$iv.hasPrevious()) {
                        String it = (String)iterator$iv.previous();
                        CharSequence var7 = (CharSequence)it;
                        if (var7.length() != 0) {
                           var10000 = CollectionsKt.take((Iterable)$receiver$iv, iterator$iv.nextIndex() + 1);
                           break label42;
                        }
                     }
                  }

                  var10000 = CollectionsKt.emptyList();
               }

               Collection thisCollection$iv = (Collection)var10000;
               if (thisCollection$iv == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
               }

               Map var19 = thisCollection$iv.toArray(new String[0]);
               if (var19 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
               }

               String[] split = (String[])var19;
               var19 = CreatureEnchantOffsetManager.this.offsets;
               if (var19 == null) {
                  Intrinsics.throwNpe();
               }

               Map thisCollection$iv = var19;
               String var16 = key.toString();
               ImmutableTriple var18 = new ImmutableTriple(Float.valueOf(split[0]), Float.valueOf(split[1]), Float.valueOf(split[2]));
               thisCollection$iv.put(var16, var18);
            } catch (Exception e) {
               CreatureEnchantOffsetManager.this.reportError(e, "rendering.thaumic_arcana.reload.failed", new Function0<String[]>() {
                  @NotNull
                  public final String[] invoke() {
                     return new String[]{"key: " + key, "value: " + value};
                  }
               });
            }

         }
      });
   }

   public final void initDefaults(@NotNull Properties properties) {
      Intrinsics.checkParameterIsNotNull(properties, "properties");
      properties.setProperty("minecraft:VillagerGolem", "0,1,0");
      properties.setProperty("minecraft:sheep", "0,1.5,0");
      properties.setProperty("minecraft:cow", "0,1.5,0");
      properties.setProperty("minecraft:chicken", "0,1.5,0");
      properties.setProperty("minecraft:shulker", "0,1.5,0");
      properties.setProperty("minecraft:witherSkeleton", "0,1.5,0");
      properties.setProperty("minecraft:guardian", "0,1.4,0");
   }

   @NotNull
   public final Triple<Float, Float, Float> getForEntity(@NotNull String resourceLocation, @Nullable EntityLivingBase entityLivingBase) {
      Intrinsics.checkParameterIsNotNull(resourceLocation, "resourceLocation");
      float height = 0.0F;
      if (entityLivingBase != null) {
         height = (float)((double)entityLivingBase.field_70131_O - (double)0.5F);
      }

      Map var10000 = this.offsets;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      Triple var6;
      if (var10000.containsKey(resourceLocation)) {
         Map var4 = this.offsets;
         if (var4 == null) {
            Intrinsics.throwNpe();
         }

         Object var5 = var4.get(resourceLocation);
         if (var5 == null) {
            Intrinsics.throwNpe();
         }

         var6 = (Triple)var5;
      } else {
         var6 = (Triple)(new ImmutableTriple(0.0F, height, 0.0F));
      }

      return var6;
   }

   private final void reportError(Exception e, String languageKey, Function0<String[]> message) {
      EntityPlayerSP player = Minecraft.func_71410_x().field_71439_g;
      if (player != null) {
         player.func_145747_a((ITextComponent)(new TextComponentTranslation(languageKey, new Object[0])));
      }

      for(String log : (String[])message.invoke()) {
         ThaumicArcana.INSTANCE.getLogger().error(log);
      }

      ThaumicArcana.INSTANCE.getLogger().error(e.getStackTrace());
   }

   // $FF: synthetic method
   public static final void access$setOffsets$p(CreatureEnchantOffsetManager $this, @Nullable Map var1) {
      $this.offsets = var1;
   }
}

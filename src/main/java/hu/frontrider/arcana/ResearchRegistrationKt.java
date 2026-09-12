package hu.frontrider.arcana;

import com.google.gson.Gson;
import hu.frontrider.thaumcraft.researchloader.ResearchCategoryJson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import org.jetbrains.annotations.NotNull;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"},
   d2 = {"registerResearchLoader", "", "suggestedConfigurationFile", "Ljava/io/File;", "Thaumic Arcana"}
)
public final class ResearchRegistrationKt {
   public static final void registerResearchLoader(@NotNull File suggestedConfigurationFile) {
      Intrinsics.checkParameterIsNotNull(suggestedConfigurationFile, "suggestedConfigurationFile");
      String[] researchFiles = new String[]{"thaumic_arcana:research/biomancy", "thaumic_arcana:research/biomancy/enchanting", "thaumic_arcana:research/biomancy/plantproducts", "thaumic_arcana:research/biomancy/animalproducts", "thaumic_arcana:research/biomancy/golems", "thaumic_arcana:research/biomancy/plantexperiments", "thaumic_arcana:research/biomancy/metallurgy", "thaumic_arcana:research/biomancy/slime", "thaumic_arcana:research/biomancy/souls", "thaumic_arcana:research/scans"};
      ResearchCategoryJson research = (new ResearchCategoryJson()).setKey("BIOMANCY").setRequired_research("MINDBIOTHAUMIC").setAspectList((new AspectList()).add(Aspect.ALCHEMY, 30).add(Aspect.LIFE, 10).add(Aspect.MAGIC, 10).add(Aspect.LIGHT, 5).add(Aspect.AVERSION, 5).add(Aspect.EARTH, 5).add(Aspect.WATER, 5)).setIcon("thaumic_arcana:textures/research/cat_biomancy.png").setBackground("thaumcraft:textures/gui/gui_research_back_7.jpg").setBackground_overlay("thaumcraft:textures/gui/gui_research_back_over.png");
      Loader var10000 = Loader.instance();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "Loader.instance()");
      List var34 = var10000.getActiveModList();
      Intrinsics.checkExpressionValueIsNotNull(var34, "Loader.instance().activeModList");
      Iterable $receiver$iv = (Iterable)var34;
      Iterator var4 = $receiver$iv.iterator();

      while(true) {
         if (var4.hasNext()) {
            Object element$iv = var4.next();
            ModContainer it = (ModContainer)element$iv;
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            if (!Intrinsics.areEqual(it.getModId(), "thaumcraftresearchloader")) {
               continue;
            }

            var35 = element$iv;
            break;
         }

         var35 = null;
         break;
      }

      if ((ModContainer)var35 == null) {
         for(Object element$iv : researchFiles) {
            if (element$iv == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            String var36 = ((String)element$iv).toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(var36, "(this as java.lang.String).toLowerCase()");
            String var30 = var36;
            ThaumcraftApi.registerResearchLocation(new ResourceLocation(var30));
         }

         Intrinsics.checkExpressionValueIsNotNull(research, "research");
         ResearchCategories.registerCategory(research.getKey(), research.getRequired_research(), research.getAspects(), new ResourceLocation(research.getIcon()), new ResourceLocation(research.getBackground()), new ResourceLocation(research.getBackground_overlay()));
      } else {
         File researchFile = new File(suggestedConfigurationFile.getParent() + "/thaumcraftresearchloader/research/thaumic_arcana.txt");
         researchFile.getParentFile().mkdirs();
         if (!researchFile.exists()) {
            researchFile.createNewFile();
            Charset $i$a$1$firstOrNull = Charsets.UTF_8;
            short it = 8192;
            OutputStream var11 = (OutputStream)(new FileOutputStream(researchFile));
            Writer var10 = (Writer)(new OutputStreamWriter(var11, $i$a$1$firstOrNull));
            BufferedWriter var12 = var10 instanceof BufferedWriter ? (BufferedWriter)var10 : new BufferedWriter(var10, it);
            Writer var13 = (Writer)var12;
            PrintWriter printWriter = new PrintWriter(var13);

            for(Object element$iv : researchFiles) {
               printWriter.write(element$iv + "\n");
            }

            printWriter.close();
         }

         File category = new File(suggestedConfigurationFile.getParent() + "/thaumcraftresearchloader/category/thaumic_arcana.json");
         category.getParentFile().mkdirs();
         if (!category.exists()) {
            category.createNewFile();
            Charset var26 = Charsets.UTF_8;
            short var28 = 8192;
            OutputStream $i$a$3$forEach = (OutputStream)(new FileOutputStream(category));
            Writer var29 = (Writer)(new OutputStreamWriter($i$a$3$forEach, var26));
            BufferedWriter var32 = var29 instanceof BufferedWriter ? (BufferedWriter)var29 : new BufferedWriter(var29, var28);
            Writer var15 = (Writer)var32;
            PrintWriter printWriter = new PrintWriter(var15);
            printWriter.println((new Gson()).toJson(research));
            printWriter.close();
         }

      }
   }
}

package hu.frontrider.thaumcraft.researchloader;

import java.util.ArrayList;
import java.util.List;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ResearchCategoryJson {
   List<AspectNotation> aspects;
   String key;
   String required_research;
   String icon;
   String background;
   String background_overlay;

   public AspectList getAspects() {
      AspectList aspectList = new AspectList();

      for(AspectNotation aspect : this.aspects) {
         Aspect aspect1 = Aspect.getAspect(aspect.name);
         aspectList.merge(aspect1, aspect.amount);
      }

      return aspectList;
   }

   public ResearchCategoryJson setAspects(List<AspectNotation> aspects) {
      this.aspects = aspects;
      return this;
   }

   public String getKey() {
      return this.key;
   }

   public ResearchCategoryJson setKey(String key) {
      this.key = key;
      return this;
   }

   public String getRequired_research() {
      return this.required_research;
   }

   public ResearchCategoryJson setRequired_research(String required_research) {
      this.required_research = required_research;
      return this;
   }

   public String getIcon() {
      return this.icon;
   }

   public ResearchCategoryJson setIcon(String icon) {
      this.icon = icon;
      return this;
   }

   public String getBackground() {
      return this.background;
   }

   public ResearchCategoryJson setBackground(String background) {
      this.background = background;
      return this;
   }

   public String getBackground_overlay() {
      return this.background_overlay;
   }

   public ResearchCategoryJson setBackground_overlay(String background_overlay) {
      this.background_overlay = background_overlay;
      return this;
   }

   public ResearchCategoryJson setAspectList(AspectList aspectList) {
      this.aspects = new ArrayList();

      for(Aspect aspect : aspectList.getAspects()) {
         int amount = aspectList.getAmount(aspect);
         this.aspects.add(new AspectNotation(aspect.getName(), amount));
      }

      return this;
   }

   class AspectNotation {
      private final String name;
      private final int amount;

      AspectNotation(String name, int amount) {
         this.name = name;
         this.amount = amount;
      }
   }
}

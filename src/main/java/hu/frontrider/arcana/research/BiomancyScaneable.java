package hu.frontrider.arcana.research;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import thaumcraft.api.research.IScanThing;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000f"},
   d2 = {"Lhu/frontrider/arcana/research/BiomancyScaneable;", "Lthaumcraft/api/research/IScanThing;", "()V", "checkThing", "", "entityPlayer", "Lnet/minecraft/entity/player/EntityPlayer;", "o", "", "getResearchKey", "", "onSuccess", "", "player", "object", "Thaumic Arcana"}
)
public final class BiomancyScaneable implements IScanThing {
   public boolean checkThing(@NotNull EntityPlayer entityPlayer, @NotNull Object o) {
      Intrinsics.checkParameterIsNotNull(entityPlayer, "entityPlayer");
      Intrinsics.checkParameterIsNotNull(o, "o");
      return false;
   }

   @Nullable
   public String getResearchKey(@NotNull EntityPlayer entityPlayer, @NotNull Object o) {
      Intrinsics.checkParameterIsNotNull(entityPlayer, "entityPlayer");
      Intrinsics.checkParameterIsNotNull(o, "o");
      return null;
   }

   public void onSuccess(@Nullable EntityPlayer player, @Nullable Object object) {
   }
}

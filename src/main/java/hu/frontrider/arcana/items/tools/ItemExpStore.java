package hu.frontrider.arcana.items.tools;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import thaumcraft.common.tiles.devices.TileJarBrain;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bJ\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\bJH\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016J\u0016\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b¨\u0006'"},
   d2 = {"Lhu/frontrider/arcana/items/tools/ItemExpStore;", "Lnet/minecraft/item/Item;", "()V", "addExperienceLevelToPlayer", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "levels", "", "addExperienceToPlayer", "exp", "getExperience", "tile", "Lthaumcraft/common/tiles/devices/TileJarBrain;", "getExtraPlayerExperience", "getLevelPlayerExperience", "getMaxExperience", "tileJarBrain", "getPlayerExperience", "getSpace", "getTotalExpForLevel", "level", "modifyExperience", "onItemUse", "Lnet/minecraft/util/EnumActionResult;", "worldIn", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/BlockPos;", "hand", "Lnet/minecraft/util/EnumHand;", "facing", "Lnet/minecraft/util/EnumFacing;", "hitX", "", "hitY", "hitZ", "setPlayerExperience", "setPlayerLevel", "Thaumic Arcana"}
)
public final class ItemExpStore extends Item {
   @NotNull
   public EnumActionResult func_180614_a(@NotNull EntityPlayer player, @NotNull World worldIn, @NotNull BlockPos pos, @NotNull EnumHand hand, @NotNull EnumFacing facing, float hitX, float hitY, float hitZ) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      Intrinsics.checkParameterIsNotNull(worldIn, "worldIn");
      Intrinsics.checkParameterIsNotNull(pos, "pos");
      Intrinsics.checkParameterIsNotNull(hand, "hand");
      Intrinsics.checkParameterIsNotNull(facing, "facing");
      if (!player.func_70093_af()) {
         return EnumActionResult.FAIL;
      } else {
         TileEntity tileEntity = worldIn.func_175625_s(pos);
         if (tileEntity != null && tileEntity instanceof TileJarBrain) {
            int curLevel = player.field_71068_ca;
            if (this.getExtraPlayerExperience(player) > 0) {
               int exp = Math.min(this.getExtraPlayerExperience(player), this.getSpace((TileJarBrain)tileEntity));
               this.setPlayerExperience(player, this.getPlayerExperience(player) - exp);
               if (player.field_71068_ca < curLevel) {
                  this.setPlayerLevel(player, curLevel);
               }

               this.modifyExperience((TileJarBrain)tileEntity, exp - 1);
            } else if (player.field_71068_ca > 0) {
               int var12 = Math.min(this.getTotalExpForLevel(player.field_71068_ca) - this.getTotalExpForLevel(player.field_71068_ca - 1), this.getSpace((TileJarBrain)tileEntity));
               this.setPlayerExperience(player, this.getPlayerExperience(player) - var12);
               if (player.field_71068_ca < curLevel - 1) {
                  this.setPlayerLevel(player, curLevel - 1);
               }

               this.modifyExperience((TileJarBrain)tileEntity, var12 - 1);
            }

            return EnumActionResult.SUCCESS;
         } else {
            return EnumActionResult.FAIL;
         }
      }
   }

   public final int getExperience(@NotNull TileJarBrain tile) {
      Intrinsics.checkParameterIsNotNull(tile, "tile");
      return tile.xp;
   }

   public final int getSpace(@NotNull TileJarBrain tile) {
      Intrinsics.checkParameterIsNotNull(tile, "tile");
      return this.getMaxExperience(tile) - this.getExperience(tile);
   }

   private final int getMaxExperience(TileJarBrain tileJarBrain) {
      return tileJarBrain.xpMax;
   }

   public final int modifyExperience(@NotNull TileJarBrain tile, int exp) {
      Intrinsics.checkParameterIsNotNull(tile, "tile");
      int storedExp = this.getExperience(tile) + exp;
      if (storedExp > this.getMaxExperience(tile)) {
         storedExp = this.getMaxExperience(tile);
      } else if (storedExp < 0) {
         storedExp = 0;
      }

      tile.xp = storedExp;
      return storedExp;
   }

   public final int getPlayerExperience(@NotNull EntityPlayer player) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      return this.getTotalExpForLevel(player.field_71068_ca) + this.getExtraPlayerExperience(player);
   }

   public final int getLevelPlayerExperience(@NotNull EntityPlayer player) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      return this.getTotalExpForLevel(player.field_71068_ca);
   }

   public final int getExtraPlayerExperience(@NotNull EntityPlayer player) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      return Math.round(player.field_71106_cc * (float)player.func_71050_bK());
   }

   public final void setPlayerExperience(@NotNull EntityPlayer player, int exp) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      player.field_71068_ca = 0;
      player.field_71106_cc = 0.0F;
      player.field_71067_cb = 0;
      this.addExperienceToPlayer(player, exp);
   }

   public final void setPlayerLevel(@NotNull EntityPlayer player, int level) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      player.field_71068_ca = level;
      player.field_71106_cc = 0.0F;
   }

   public final void addExperienceToPlayer(@NotNull EntityPlayer player, int exp) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      int exp = exp;
      int i = Integer.MAX_VALUE - player.field_71067_cb;
      if (exp > i) {
         exp = i;
      }

      player.field_71106_cc += (float)exp / (float)player.func_71050_bK();

      for(player.field_71067_cb += exp; player.field_71106_cc >= 1.0F; player.field_71106_cc /= (float)player.func_71050_bK()) {
         player.field_71106_cc = (player.field_71106_cc - 1.0F) * (float)player.func_71050_bK();
         this.addExperienceLevelToPlayer(player, 1);
      }

   }

   public final void addExperienceLevelToPlayer(@NotNull EntityPlayer player, int levels) {
      Intrinsics.checkParameterIsNotNull(player, "player");
      player.field_71068_ca += levels;
      if (player.field_71068_ca < 0) {
         player.field_71068_ca = 0;
         player.field_71106_cc = 0.0F;
         player.field_71067_cb = 0;
      }

   }

   public final int getTotalExpForLevel(int level) {
      return level >= 32 ? (9 * level * level - 325 * level + 4440) / 2 : (level >= 17 ? (5 * level * level - 81 * level + 720) / 2 : level * level + 6 * level);
   }
}

package hu.frontrider.arcana.sided.server.commands;

import hu.frontrider.arcana.capabilities.scar.IScarred;
import hu.frontrider.arcana.capabilities.scar.ScarProvider;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000bH\u0016J;\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J#\u0010\u0014\u001a\u00020\u00152\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010\u0018¨\u0006\u0019"},
   d2 = {"Lhu/frontrider/arcana/sided/server/commands/ScarHelperCommand;", "Lnet/minecraft/command/CommandBase;", "()V", "execute", "", "server", "Lnet/minecraft/server/MinecraftServer;", "sender", "Lnet/minecraft/command/ICommandSender;", "args", "", "", "(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;)V", "getName", "getTabCompletions", "", "targetPos", "Lnet/minecraft/util/math/BlockPos;", "(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;Lnet/minecraft/util/math/BlockPos;)Ljava/util/List;", "getUsage", "isUsernameIndex", "", "index", "", "([Ljava/lang/String;I)Z", "Thaumic Arcana"}
)
public final class ScarHelperCommand extends CommandBase {
   @NotNull
   public String func_71517_b() {
      return "tascar";
   }

   public void func_184881_a(@NotNull MinecraftServer server, @NotNull ICommandSender sender, @NotNull String[] args) {
      Intrinsics.checkParameterIsNotNull(server, "server");
      Intrinsics.checkParameterIsNotNull(sender, "sender");
      Intrinsics.checkParameterIsNotNull(args, "args");
      if (args.length < 2) {
         throw (Throwable)(new WrongUsageException("/tascar <player> <check|setdamage> <number>>", new Object[0]));
      } else {
         Entity var10000 = CommandBase.func_184884_a(server, sender, args[0], EntityLivingBase.class);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.EntityLivingBase");
         } else {
            EntityLivingBase entitylivingbase = (EntityLivingBase)var10000;
            if (!entitylivingbase.hasCapability(ScarProvider.Companion.getSCARRED_CAPABILITY(), (EnumFacing)null)) {
               throw (Throwable)(new WrongUsageException("Target can not be scarred!", new Object[0]));
            } else {
               IScarred capability = (IScarred)entitylivingbase.getCapability(ScarProvider.Companion.getSCARRED_CAPABILITY(), (EnumFacing)null);
               switch (var6) {
                  case "check":
                     sender.func_145747_a((ITextComponent)(new TextComponentString(String.valueOf(capability))));
                     break;
                  case "setDamage":
               }

            }
         }
      }
   }

   @NotNull
   public String func_71518_a(@NotNull ICommandSender sender) {
      Intrinsics.checkParameterIsNotNull(sender, "sender");
      return "/tascar <player> <check|setdamage> <number>>";
   }

   @NotNull
   public List<String> func_184883_a(@NotNull MinecraftServer server, @NotNull ICommandSender sender, @NotNull String[] args, @Nullable BlockPos targetPos) {
      Intrinsics.checkParameterIsNotNull(server, "server");
      Intrinsics.checkParameterIsNotNull(sender, "sender");
      Intrinsics.checkParameterIsNotNull(args, "args");
      List var10000;
      if (args.length == 1) {
         String[] var10001 = server.func_71213_z();
         var10000 = CommandBase.func_71530_a(args, (String[])Arrays.copyOf(var10001, var10001.length));
         Intrinsics.checkExpressionValueIsNotNull(var10000, "CommandBase.getListOfStr…server.onlinePlayerNames)");
      } else {
         if (args.length == 2) {
            return (List)CollectionsKt.arrayListOf(new String[]{"check", "setDamage"});
         }

         var10000 = CollectionsKt.emptyList();
      }

      return var10000;
   }

   public boolean func_82358_a(@NotNull String[] args, int index) {
      Intrinsics.checkParameterIsNotNull(args, "args");
      return index == 0;
   }
}

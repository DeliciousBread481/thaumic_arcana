package hu.frontrider.arcana.server.commands;

import hu.frontrider.arcana.worldgen.generators.taintwine.TaintWineGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.command.server.CommandSetBlock;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0011"},
   d2 = {"Lhu/frontrider/arcana/server/commands/StructureSpawnerCommand;", "Lnet/minecraft/command/server/CommandSetBlock;", "()V", "execute", "", "server", "Lnet/minecraft/server/MinecraftServer;", "sender", "Lnet/minecraft/command/ICommandSender;", "args", "", "", "(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;)V", "getName", "getRequiredPermissionLevel", "", "getUsage", "Thaumic Arcana"}
)
public final class StructureSpawnerCommand extends CommandSetBlock {
   @NotNull
   public String func_71517_b() {
      return "spawnArcanaStructure";
   }

   public int func_82362_a() {
      return 2;
   }

   @NotNull
   public String func_71518_a(@Nullable ICommandSender sender) {
      return "commands.thaumic_arcana.spawn_structure.usage";
   }

   public void func_184881_a(@Nullable MinecraftServer server, @NotNull ICommandSender sender, @NotNull String[] args) throws CommandException {
      Intrinsics.checkParameterIsNotNull(sender, "sender");
      Intrinsics.checkParameterIsNotNull(args, "args");
      if (args.length < 4) {
         throw (Throwable)(new WrongUsageException("commands.thaumic_arcana.spawn_structure.usage", new Object[0]));
      } else {
         BlockPos blockpos = CommandBase.func_175757_a(sender, args, 0, false);
         switch (var5) {
            case "taintWine":
               (new TaintWineGenerator()).func_180709_b(sender.func_130014_f_(), sender.func_130014_f_().field_73012_v, blockpos);
               return;
            default:
               throw (Throwable)(new CommandException("commands.thaumic_arcana.spawn_structure.invalid_name", new Object[0]));
         }
      }
   }
}

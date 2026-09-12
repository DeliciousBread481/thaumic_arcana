package hu.frontrider.arcana.sided.client.commands;

import hu.frontrider.arcana.sided.client.rendering.EnchantRenderer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.client.IClientCommand;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J+\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018H\u0017¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J=\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J#\u0010\"\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010$R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"},
   d2 = {"Lhu/frontrider/arcana/sided/client/commands/ReloadOffsetsCommand;", "Lnet/minecraftforge/client/IClientCommand;", "enchantRenderer", "Lhu/frontrider/arcana/sided/client/rendering/EnchantRenderer;", "(Lhu/frontrider/arcana/sided/client/rendering/EnchantRenderer;)V", "aliases", "", "", "name", "allowUsageWithoutPrefix", "", "sender", "Lnet/minecraft/command/ICommandSender;", "message", "checkPermission", "server", "Lnet/minecraft/server/MinecraftServer;", "compareTo", "", "iCommand", "Lnet/minecraft/command/ICommand;", "execute", "", "args", "", "(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;)V", "getAliases", "", "getName", "getTabCompletions", "targetPos", "Lnet/minecraft/util/math/BlockPos;", "(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/command/ICommandSender;[Ljava/lang/String;Lnet/minecraft/util/math/BlockPos;)Ljava/util/List;", "getUsage", "isUsernameIndex", "index", "([Ljava/lang/String;I)Z", "Thaumic Arcana"}
)
public final class ReloadOffsetsCommand implements IClientCommand {
   private final List<String> aliases;
   private final String name;
   private final EnchantRenderer enchantRenderer;

   @NotNull
   public String func_71517_b() {
      return this.name;
   }

   @NotNull
   public String func_71518_a(@NotNull ICommandSender sender) {
      Intrinsics.checkParameterIsNotNull(sender, "sender");
      return '/' + this.name;
   }

   @NotNull
   public List<String> func_71514_a() {
      return this.aliases;
   }

   @SideOnly(Side.CLIENT)
   public void func_184881_a(@NotNull MinecraftServer server, @NotNull ICommandSender sender, @NotNull String[] args) {
      Intrinsics.checkParameterIsNotNull(server, "server");
      Intrinsics.checkParameterIsNotNull(sender, "sender");
      Intrinsics.checkParameterIsNotNull(args, "args");
      this.enchantRenderer.reload();
      sender.func_145747_a((ITextComponent)(new TextComponentTranslation("command.thaumic_arcana.reload.feedback", new Object[0])));
   }

   public boolean func_184882_a(@NotNull MinecraftServer server, @NotNull ICommandSender sender) {
      Intrinsics.checkParameterIsNotNull(server, "server");
      Intrinsics.checkParameterIsNotNull(sender, "sender");
      return true;
   }

   @Nullable
   public List<String> func_184883_a(@NotNull MinecraftServer server, @NotNull ICommandSender sender, @NotNull String[] args, @Nullable BlockPos targetPos) {
      Intrinsics.checkParameterIsNotNull(server, "server");
      Intrinsics.checkParameterIsNotNull(sender, "sender");
      Intrinsics.checkParameterIsNotNull(args, "args");
      return null;
   }

   public boolean func_82358_a(@NotNull String[] args, int index) {
      Intrinsics.checkParameterIsNotNull(args, "args");
      return false;
   }

   public int compareTo(@NotNull ICommand iCommand) {
      Intrinsics.checkParameterIsNotNull(iCommand, "iCommand");
      return 0;
   }

   public boolean allowUsageWithoutPrefix(@NotNull ICommandSender sender, @NotNull String message) {
      Intrinsics.checkParameterIsNotNull(sender, "sender");
      Intrinsics.checkParameterIsNotNull(message, "message");
      return false;
   }

   public ReloadOffsetsCommand(@NotNull EnchantRenderer enchantRenderer) {
      Intrinsics.checkParameterIsNotNull(enchantRenderer, "enchantRenderer");
      super();
      this.enchantRenderer = enchantRenderer;
      this.aliases = (List)(new ArrayList());
      this.name = "reloadarcana";
      this.aliases.add("name");
   }
}

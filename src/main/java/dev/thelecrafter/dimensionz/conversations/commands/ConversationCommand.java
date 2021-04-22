package dev.thelecrafter.dimensionz.conversations.commands;

import dev.thelecrafter.dimensionz.conversations.config.FileManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ConversationCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            switch (args[0]) {
                case "reload":
                    sender.sendMessage(ChatColor.YELLOW + "Starting to reload...");
                    FileManager.reload();
                    sender.sendMessage(ChatColor.GREEN + "Reloaded!");
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "Unknown subcommand! Use /conversation <reload>");
            }
        } else sender.sendMessage(ChatColor.RED + "Unknown syntax! Use /conversation <reload>");
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> tabComplete = new ArrayList<>();

        if (args.length == 1) {
            if ("reload".contains(args[0])) tabComplete.add("reload");
        }

        return tabComplete;
    }
}

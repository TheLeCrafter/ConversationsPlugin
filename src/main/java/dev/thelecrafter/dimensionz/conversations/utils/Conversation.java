package dev.thelecrafter.dimensionz.conversations.utils;

import dev.thelecrafter.dimensionz.conversations.ConversationsPlugin;
import dev.thelecrafter.dimensionz.conversations.config.FileManager;
import net.citizensnpcs.api.npc.NPC;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class Conversation {

    public static final Set<Player> IN_CONVERSATION = new HashSet<>();

    public static void sendPlayerConversation(Player player, NPC speaker, List<String> conversation, Integer line) {
        if (player.isOnline()) {
            IN_CONVERSATION.add(player);
            player.sendMessage(ChatColor.DARK_GRAY + "[NPC] " + ChatColor.WHITE + speaker.getFullName() + ChatColor.DARK_GRAY + " > " + ChatColor.WHITE + setPlaceholders(player, conversation.get(line)));
            Bukkit.getScheduler().scheduleSyncDelayedTask(ConversationsPlugin.INSTANCE, () -> {
                if ((line + 1) <= (conversation.size() - 1)) {
                    sendPlayerConversation(player, speaker, conversation, line + 1);
                } else {
                    player.sendMessage(ChatColor.DARK_GRAY + "[Dialog Ende]");
                    IN_CONVERSATION.remove(player);
                }
            }, conversation.get(line).length());
        }
    }

    public static String setPlaceholders(Player player, String string) {
        string = ChatColor.translateAlternateColorCodes('&', string);
        string = string.replace("%%player_name%%", player.getDisplayName());
        string = string.replace("%%player_name_no_rank%%", player.getName());
        return string;
    }

}

package dev.thelecrafter.dimensionz.conversations;

import dev.thelecrafter.dimensionz.conversations.commands.ConversationCommand;
import dev.thelecrafter.dimensionz.conversations.config.DefaultConfig;
import dev.thelecrafter.dimensionz.conversations.config.FileManager;
import dev.thelecrafter.dimensionz.conversations.events.OnTalkableClick;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConversationsPlugin extends JavaPlugin {

    public static ConversationsPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        FileManager.setup();
        DefaultConfig.addDefaultValues();
        getCommand("conversation").setExecutor(new ConversationCommand());
        getCommand("conversation").setTabCompleter(new ConversationCommand());
        Bukkit.getPluginManager().registerEvents(new OnTalkableClick(), INSTANCE);
    }

}

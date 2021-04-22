package dev.thelecrafter.dimensionz.conversations.config;

import dev.thelecrafter.dimensionz.conversations.ConversationsPlugin;
import dev.thelecrafter.dimensionz.conversations.utils.Talkable;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DefaultConfig {

    private static final FileConfiguration config = FileManager.get();

    public static void addDefaultValues() {
        for (Talkable talkable : Talkable.values()) {
            if (!config.contains("conversations." + talkable.toString())) {
                config.set("conversations." + talkable.toString(), new String[]{"Hallo!", "Zur Zeit habe ich von keinem Admin einen Text bekommen.", "Komm wieder, wenn ich einen habe."});
                FileManager.save();
            }
        }
    }

}

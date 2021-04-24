package dev.thelecrafter.dimensionz.conversations.config;

import org.bukkit.configuration.file.FileConfiguration;

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

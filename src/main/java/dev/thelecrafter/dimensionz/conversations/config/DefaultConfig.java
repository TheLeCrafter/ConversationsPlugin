package dev.thelecrafter.dimensionz.conversations.config;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.configuration.file.FileConfiguration;

public class DefaultConfig {

    private static final FileConfiguration config = FileManager.get();

    public static void addDefaultValues() {
        for (String npcId : config.getKeys(false)) {
            if (!config.contains("conversations." + npcId)) {
                config.set("conversations." + npcId, new String[]{"Hallo!", "Zur Zeit habe ich von keinem Admin einen Text bekommen.", "Komm wieder, wenn ich einen habe."});
                FileManager.save();
            }
        }
    }

}

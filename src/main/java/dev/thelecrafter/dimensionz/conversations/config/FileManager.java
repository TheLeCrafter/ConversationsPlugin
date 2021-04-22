package dev.thelecrafter.dimensionz.conversations.config;

import dev.thelecrafter.dimensionz.conversations.ConversationsPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    private static File file;
    private static FileConfiguration customFile;

    // Finds or generates the custom file
    public static void setup() {
        file = new File(ConversationsPlugin.INSTANCE.getDataFolder(), "conversations.yml");

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // Just a catch lol
            }
        }

        customFile = YamlConfiguration.loadConfiguration(file);

    }

    // Get the file configuration
    public static FileConfiguration get() {
        return customFile;
    }

    // Save the file configuration
    public static void save() {
        try {
            customFile.save(file);
        } catch (IOException e) {
            System.out.println("Failed to save the conversations file!");
        }
    }

    // Reload the file configuration
    public static void reload() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}

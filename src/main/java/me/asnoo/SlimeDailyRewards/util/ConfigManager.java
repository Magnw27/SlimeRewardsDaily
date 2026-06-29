package me.asnoo.slimedailyrewards.util;

import me.asnoo.slimedailyrewards.SlimeDailyRewards;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private final File file;
    private final FileConfiguration config;

    public ConfigManager() {

        file = new File(
                SlimeDailyRewards.getInstance().getDataFolder(),
                "playerdata.yml"
        );

        if (!file.exists()) {

            file.getParentFile().mkdirs();

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        config = YamlConfiguration.loadConfiguration(file);

    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void save() {

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

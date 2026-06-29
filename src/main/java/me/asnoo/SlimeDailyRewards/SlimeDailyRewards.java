package me.asnoo.slimerewards;

import me.asnoo.slimerewards.command.DailyCommand;
import me.asnoo.slimerewards.listener.InventoryListener;
import me.asnoo.slimerewards.util.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlimeRewards extends JavaPlugin {

    private static SlimeRewards instance;

    private ConfigManager playerData;

    @Override
    public void onEnable() {

        instance = this;

        playerData = new ConfigManager();

        getCommand("daily").setExecutor(new DailyCommand());

        getServer().getPluginManager().registerEvents(
                new InventoryListener(),
                this
        );

        getLogger().info("--------------------------------");
        getLogger().info("SlimeRewards Aktif Bosqu!");
        getLogger().info("Version : " + getDescription().getVersion());
        getLogger().info("--------------------------------");
    }

    @Override
    public void onDisable() {

        getLogger().info("SlimeRewards Dinonaktifkan!");

    }

    public static SlimeRewards getInstance() {
        return instance;
    }

    public ConfigManager getPlayerData() {
        return playerData;
    }

}

package me.asnoo.slimerewards;

import me.asnoo.slimerewards.command.DailyCommand;
import me.asnoo.slimerewards.listener.InventoryListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlimeRewards extends JavaPlugin {

} {

    private static SlimeRewards instance;

    @Override
    public void onEnable() {

        instance = this;

        getLogger().info("--------------------------------");
        getLogger().info("SlimeRewards Aktif Bosqu!");
        getLogger().info("Version : " + getDescription().getVersion());
        getLogger().info("--------------------------------");
    @Override
    public void onEnable() {

        instance = this;

        getCommand("daily").setExecutor(new DailyCommand());

        getServer().getPluginManager().registerEvents(
                new InventoryListener(),
                this
        );

    getLogger().info("SlimeRewards Enabled!");

}

    }

    @Override
    public void onDisable() {

        getLogger().info("SlimeRewards Dinonaktifkan!");

    }

    public static SlimeRewards getInstance() {
        return instance;
    }

}

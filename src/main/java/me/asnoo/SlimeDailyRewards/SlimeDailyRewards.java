package me.namamu.slimerewards;

import org.bukkit.plugin.java.JavaPlugin;

public final class SlimeRewards extends JavaPlugin {

    private static SlimeRewards instance;

    @Override
    public void onEnable() {

        instance = this;

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

}

package me.asnoo.slimerewards.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DailyGUI {

    public static final String TITLE = "§aDaily Rewards";

    public static void open(Player player) {

        Inventory inventory = Bukkit.createInventory(null, 27, TITLE);

        ItemStack reward = new ItemStack(Material.CHEST);

        ItemMeta meta = reward.getItemMeta();

        meta.setDisplayName("§aDaily Reward");

        reward.setItemMeta(meta);

        inventory.setItem(13, reward);

        player.openInventory(inventory);

    }

}

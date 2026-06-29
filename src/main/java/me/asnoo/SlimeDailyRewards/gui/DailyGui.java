package me.asnoo.slimedailyrewards.gui;

import me.asnoo.slimedailyrewards.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DailyGUI {

    public static final String TITLE = "§2✦ Daily Rewards ✦";

    public static void open(Player player) {

        // Membuat inventory
        Inventory inventory = Bukkit.createInventory(null, 27, TITLE);

        // Membuat item border
        ItemStack border = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .name(" ")
                .build();

        // Mengisi border
        for (int i = 0; i < 27; i++) {
            if (i < 9 || i > 17 || i == 9 || i == 17) {
                inventory.setItem(i, border);
            }
        }

        // Item Daily Reward
        inventory.setItem(
                13,
                new ItemBuilder(Material.CHEST)
                        .name("§aDaily Reward")
                        .lore(
                                "§7Klik untuk claim reward.",
                                "",
                                "§eComing Soon..."
                        )
                        .hideAttributes()
                        .build()
        );

        // Membuka GUI
        player.openInventory(inventory);
    }
}

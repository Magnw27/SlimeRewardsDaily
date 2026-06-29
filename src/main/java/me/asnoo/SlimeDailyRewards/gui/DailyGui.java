package me.asnoo.slimedailyrewards.gui;

import me.asnoo.slimedailyrewards.manager.GUIManager;
import me.asnoo.slimedailyrewards.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DailyGUI {

    public static void open(Player player) {

        Inventory inventory = Bukkit.createInventory(
                null,
                GUIManager.DAILY_SIZE,
                GUIManager.DAILY_TITLE
        );

        fillBorder(inventory);

        createReward(inventory);

        player.openInventory(inventory);
    }

    /**
     * Mengisi border GUI
     */
    private static void fillBorder(Inventory inventory) {

        ItemStack border = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .name(" ")
                .build();

        int size = inventory.getSize();

        for (int slot = 0; slot < size; slot++) {

            if (slot < 9 || slot >= size - 9 || slot % 9 == 0 || slot % 9 == 8) {
                inventory.setItem(slot, border);
            }

        }

    }

    /**
     * Membuat tombol reward
     */
    private static void createReward(Inventory inventory) {

        inventory.setItem(
                GUIManager.REWARD_SLOT,
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

    }

}

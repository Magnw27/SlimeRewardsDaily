package me.asnoo.slimedailyrewards.gui;

import me.asnoo.slimedailyrewards.manager.GUIManager;
import me.asnoo.slimedailyrewards.manager.RewardManager;
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

        createRewards(inventory);

        player.openInventory(inventory);

    }

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

    private static void createRewards(Inventory inventory) {

        for (int day = 0; day < GUIManager.REWARD_SLOTS.length; day++) {

            inventory.setItem(
                    GUIManager.REWARD_SLOTS[day],
                    RewardManager.getReward(day + 1)
            );

        }

    }

}

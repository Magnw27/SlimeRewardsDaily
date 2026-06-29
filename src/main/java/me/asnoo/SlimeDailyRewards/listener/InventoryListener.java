package me.asnoo.slimedailyrewards.listener;

import me.asnoo.slimedailyrewards.manager.CooldownManager;
import me.asnoo.slimedailyrewards.manager.GUIManager;
import me.asnoo.slimedailyrewards.storage.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (!event.getView().getTitle().equals(GUIManager.DAILY_TITLE))
            return;

        event.setCancelled(true);

        if (!(event.getWhoClicked() instanceof Player player))
            return;

        int slot = event.getRawSlot();

        for (int i = 0; i < GUIManager.REWARD_SLOTS.length; i++) {

            if (slot != GUIManager.REWARD_SLOTS[i])
                continue;

            int currentDay = PlayerData.getCurrentDay(player.getUniqueId());

            if (currentDay != i + 1) {
                player.sendMessage("§cYou can't claim this reward yet.");
                return;
            }

            if (!CooldownManager.canClaim(player)) {
                player.sendMessage("§cYou have already claimed today's reward.");
                return;
            }

            player.sendMessage("§aReward claimed!");

            PlayerData.setLastClaim(
                    player.getUniqueId(),
                    System.currentTimeMillis()
            );

            int nextDay = currentDay + 1;

            if (nextDay > GUIManager.REWARD_SLOTS.length) {
                nextDay = 1;
            }

            PlayerData.setCurrentDay(
                    player.getUniqueId(),
                    nextDay
            );

            player.closeInventory();

            return;

        }

    }

}

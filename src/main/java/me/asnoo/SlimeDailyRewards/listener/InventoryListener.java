package me.asnoo.slimedailyrewards.listener;

import me.asnoo.slimedailyrewards.gui.DailyGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (!event.getView().getTitle().equals(DailyGUI.TITLE))
            return;

        event.setCancelled(true);

    }

}

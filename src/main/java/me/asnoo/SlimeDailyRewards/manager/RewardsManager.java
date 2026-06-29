package me.asnoo.slimedailyrewards.manager;

import me.asnoo.slimedailyrewards.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RewardManager {

    public static ItemStack getDailyReward() {

        return new ItemBuilder(Material.CHEST)
                .name("§aDaily Reward")
                .lore(
                        "§7Klik untuk claim reward.",
                        "",
                        "§eComing Soon..."
                )
                .hideAttributes()
                .build();

    }

}

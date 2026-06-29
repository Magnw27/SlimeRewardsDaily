package me.asnoo.slimedailyrewards.manager;

import me.asnoo.slimedailyrewards.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RewardManager {

    public static ItemStack getReward(int day) {

        return new ItemBuilder(Material.CHEST)
                .name("§aDay " + day)
                .lore(
                        "",
                        "§7Click to claim reward.",
                        "",
                        "§eReward Coming Soon"
                )
                .hideAttributes()
                .build();

    }

}

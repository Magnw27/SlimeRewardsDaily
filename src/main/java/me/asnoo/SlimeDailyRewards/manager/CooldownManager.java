package me.asnoo.slimedailyrewards.manager;

import me.asnoo.slimedailyrewards.storage.PlayerData;
import org.bukkit.entity.Player;

public class CooldownManager {

    private static final long COOLDOWN = 86400000L;

    public static boolean canClaim(Player player) {

        long last = PlayerData.getLastClaim(player.getUniqueId());

        return System.currentTimeMillis() - last >= COOLDOWN;

    }

    public static long getRemaining(Player player) {

        long last = PlayerData.getLastClaim(player.getUniqueId());

        long remain = COOLDOWN - (System.currentTimeMillis() - last);

        return Math.max(remain, 0);

    }

}

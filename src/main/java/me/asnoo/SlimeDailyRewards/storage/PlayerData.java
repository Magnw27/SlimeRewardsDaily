package me.asnoo.slimedailyrewards.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerData {

    private static final Map<UUID, Integer> currentDay = new HashMap<>();
    private static final Map<UUID, Long> lastClaim = new HashMap<>();

    public static int getCurrentDay(UUID uuid) {
        return currentDay.getOrDefault(uuid, 1);
    }

    public static void setCurrentDay(UUID uuid, int day) {
        currentDay.put(uuid, day);
    }

    public static long getLastClaim(UUID uuid) {
        return lastClaim.getOrDefault(uuid, 0L);
    }

    public static void setLastClaim(UUID uuid, long time) {
        lastClaim.put(uuid, time);
    }

}

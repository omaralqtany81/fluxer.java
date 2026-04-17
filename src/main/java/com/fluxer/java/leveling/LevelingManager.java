package com.fluxer.java.leveling;

import com.fluxer.java.entities.Message;
import java.util.HashMap;
import java.util.Map;

/**
 * A built-in leveling engine. 
 * Tracks activity and manages rank progressions automatically.
 */
public class LevelingManager {
    private final Map<String, UserStats> userStats = new HashMap<>();
    private final Map<Integer, String> roleRewards = new HashMap<>();

    /**
     * Define which role is rewarded at which level.
     */
    public void addRoleReward(int level, String roleId) {
        roleRewards.put(level, roleId);
    }

    /**
     * Processes a message and awards XP.
     */
    public void processMessage(Message message) {
        String userId = message.getAuthor().getId();
        UserStats stats = userStats.computeIfAbsent(userId, k -> new UserStats());
        
        stats.addXp(15 + (int)(Math.random() * 10)); // Dynamic XP reward

        if (stats.canLevelUp()) {
            stats.levelUp();
            handleLevelUp(message, stats.getLevel());
        }
    }

    private void handleLevelUp(Message message, int newLevel) {
        message.reply("🎉 Congrats " + message.getAuthor().getAsMention() + "! You just reached Level " + newLevel + "!");
        
        String rewardRole = roleRewards.get(newLevel);
        if (rewardRole != null) {
            // Auto-assign role logic would go here via RestManager
            System.out.println("Awarding role " + rewardRole + " to " + message.getAuthor().getUsername());
        }
    }

    // Inner class to track individual performance
    private static class UserStats {
        private int xp = 0;
        private int level = 0;

        public void addXp(int amount) { this.xp += amount; }
        public boolean canLevelUp() { return xp >= (level + 1) * 100; } // Scalable leveling curve
        public void levelUp() { this.level++; }
        public int getLevel() { return level; }
    }
}

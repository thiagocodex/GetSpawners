package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.Messages;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Debug extends Messages {
    public void debugHologram(Player commandSender) {
        Block spawner;
        int amount = 0;
        for (Entity entity : commandSender.getWorld().getEntities()) {
            if (entity instanceof ArmorStand) {
                Location armorStandLocation = entity.getLocation();
                spawner = commandSender.getWorld().getBlockAt(armorStandLocation.subtract(0.5, 0, 0.5));
                if (spawner.getType() != Material.SPAWNER && ((ArmorStand) entity).isSmall()) {
                    entity.remove();
                    amount++;
                    commandSender.sendMessage(BUG_REMOVED_ANNOUNCE.replaceAll("%hologram_name%", entity.getName()));
                }
            }
        }
        commandSender.sendMessage(BUG_REMOVED_AMOUNT.replaceAll("%amount%", Integer.toString(amount)));
    }
}
package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.CustomConfig;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public class EntitySpawnTest extends CustomConfig {
    public static void spawn(String stackedName, Location location) {


        ArmorStand stand = location.getWorld().spawn(location.add(0.5, 0, 0.5), ArmorStand.class, consumerStand -> {
            consumerStand.setCustomName(stackedName);
            consumerStand.setCustomNameVisible(true);
            consumerStand.setSmall(true);
            consumerStand.setVisible(false);
            consumerStand.setGravity(false);
        });

    }
}

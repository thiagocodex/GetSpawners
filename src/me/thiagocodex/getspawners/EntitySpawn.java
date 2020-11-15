package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.CustomConfig;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.Consumer;

public class EntitySpawn extends CustomConfig {
    public static void spawn(String stackedName, Location location) {

        location.getWorld().spawn(location.add(0.5, 0, 0.5), ArmorStand.class,
                new Consumer<ArmorStand>() {
                    @Override
                    public void accept(ArmorStand consumerStand) {
                        consumerStand.setCustomName(stackedName);
                        consumerStand.setCustomNameVisible(true);
                        consumerStand.setSmall(true);
                        consumerStand.setVisible(false);
                        consumerStand.setGravity(false);
                    }
                });

    }
}

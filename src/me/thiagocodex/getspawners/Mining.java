package me.thiagocodex.getspawners;

import org.bukkit.GameMode;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class Mining extends DropSpawners {
    static void cancelBlockBreak(BlockBreakEvent event) {
        if (creatureSpawner.getMinSpawnDelay() == 202) {
            Hologram.remove(event);
        }
        if (creatureSpawner.getMinSpawnDelay() > 201) {
            GetSpawners.morphable.update(
                    creatureSpawner.getBlock(),
                    spawnedType,
                    creatureSpawner.getSpawnCount(),
                    creatureSpawner.getMinSpawnDelay(),
                    creatureSpawner.getMaxSpawnDelay(),
                    true,
                    false);
            event.setCancelled(true);
            Hologram.setCustomName(event);
        }
    }

    static void mine(BlockBreakEvent event) {
        Random random = new Random();
        int randomNum = random.nextInt(100);
        if (player.getGameMode() == GameMode.SURVIVAL) {
            for (int i = 100; i >= 0; i -= 10) {
                if (player.hasPermission("getspawners.drop." + i + "%")) {
                    if (randomNum <= i) {
                        for (int j = 100; j >= 0; j -= 10) {
                            if (player.hasPermission("getspawners.drop." + spawnedType.toLowerCase() + "." + j + "%")) {
                                cancelBlockBreak(event);
                                if (randomNum <= j) {
                                    block.getWorld().dropItemNaturally(event.getBlock().getLocation(), itemStack);
                                    if (j != 100) {
                                        player.sendMessage(PREFIX + " " + LUCKY);
                                    }
                                    event.setExpToDrop(0);
                                } else {
                                    player.sendMessage(PREFIX + " " + UNLUCKY);
                                }
                                return;
                            } else {
                                if (j < 10) {
                                    cancelBlockBreak(event);
                                    block.getWorld().dropItemNaturally(event.getBlock().getLocation(), itemStack);
                                    if (i != 100) {
                                        player.sendMessage(PREFIX + " " + LUCKY);
                                    }
                                    event.setExpToDrop(0);
                                    return;
                                }
                            }
                        }
                    } else {
                        cancelBlockBreak(event);
                        player.sendMessage(PREFIX + " " + UNLUCKY);
                        return;
                    }
                } else {
                    if (i < 10) {
                        player.sendMessage(PREFIX + " " + NO_PERM);
                        event.setCancelled(true);
                        return;
                    }
                }
            }
        }
    }
}

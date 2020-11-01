package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.CustomConfig;
import me.thiagocodex.getspawners.customconfig.Messages;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.SpawnerSpawnEvent;

public class CustomMobName extends Messages {
    @EventHandler
    private void onSpawn(SpawnerSpawnEvent event) {
        if (event.getSpawner().getMinSpawnDelay() > 200) {
            if (customNameForGsMobs) {
                String spawnedType = firstCapitalWord(event.getSpawner().getSpawnedType().name());
                spawnedType = fixSpawnedType(spawnedType);
                event.getEntity().addScoreboardTag("GSId");
                String customName = CustomConfig.getMobs().getString("Custom_Mob_Name." + spawnedType);
                event.getEntity().setCustomNameVisible(alwaysVisibleGsMobsName);
                event.getEntity().setCustomName(color(customName));
            }
        }
    }
}
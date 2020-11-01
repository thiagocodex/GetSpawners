package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.compatibility.GriefPreventionCompat;
import me.thiagocodex.getspawners.compatibility.ResidenceCompat;
import me.thiagocodex.getspawners.compatibility.SuperVanishCompat;
import me.thiagocodex.getspawners.compatibility.TownyCompat;
import me.thiagocodex.getspawners.compatibility.WorldGuardCompat;
import me.thiagocodex.getspawners.customconfig.CustomConfig;
import me.thiagocodex.getspawners.customconfig.Messages;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChangeSpawners extends Messages implements Listener {
    private static Block clickedBlock;
    private static Player player;
    private static String eggTypeName;

    private void setCustomName() {
        eggTypeName = player.getInventory().getItemInMainHand().getType().name();
        String spawnTypeNameUpdated = firstCapitalWord(eggTypeName.replaceAll("_SPAWN_EGG", ""));
        List<Entity> entities = clickedBlock.getWorld().getEntities();
        for (Entity entity : entities) {
            if (entity.getLocation().subtract(0.5, 0, 0.5).toString().equals(clickedBlock.getLocation().toString())) {
                CreatureSpawner spawner = (CreatureSpawner) clickedBlock.getState();
                String spawnedType = color(CustomConfig.getSpawners().getString("Spawner_Name." +
                        firstCapitalWord(spawnTypeNameUpdated)));
                String amount = Integer.toString(spawner.getMinSpawnDelay() - 200);
                String displayName = spawnedType + " " + amount + "X";
                entity.setCustomName(color(displayName));
            }
        }
    }

    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent event) {
        Action action = event.getAction();
        player = event.getPlayer();
        clickedBlock = event.getClickedBlock();
        eggTypeName = player.getInventory().getItemInMainHand().getType().name();
        if (action == Action.RIGHT_CLICK_BLOCK) {
            if (clickedBlock.getType() == Material.SPAWNER && eggTypeName.contains("_SPAWN_EGG")) {
                if (!CustomConfig.getConfig().getBoolean("Allow_SpawnEgg_Change.Enabled")) {
                    event.setCancelled(true);
                    player.sendMessage(PREFIX + " " + NO_CHANGE_ENABLED);
                } else if (!GriefPreventionCompat.gpCompat(event)) {
                    event.setCancelled(true);
                    player.sendMessage(PREFIX + " " + GRIEFPREVENTION_COMPAT_NO_INTERACT);
                } else if (!SuperVanishCompat.svCompat(event)) {
                    event.setCancelled(true);
                    player.sendMessage(PREFIX + " " + SUPERVANISH_COMPAT_NO_INTERACT);
                } else if (!ResidenceCompat.resCompat(event)) {
                    event.setCancelled(true);
                    player.sendMessage(PREFIX + " " + RESIDENCE_COMPAT_NO_INTERACT);
                } else if (!WorldGuardCompat.wgCompat(event)) {
                    event.setCancelled(true);
                    player.sendMessage(PREFIX + " " + WORLDGUARD_COMPAT_NO_INTERACT);
                } else if (!TownyCompat.townyCompat(event)) {
                    event.setCancelled(true);
                    player.sendMessage(PREFIX + " " + TOWNY_COMPAT_NO_INTERACT);
                } else {
                    CreatureSpawner spawner = (CreatureSpawner) clickedBlock.getState();
                    int spawnCount = spawner.getSpawnCount();
                    int minSpawnDelay = spawner.getMinSpawnDelay();
                    int maxSpawnDelay = spawner.getMaxSpawnDelay();
                    String spawnedType = spawner.getSpawnedType().name().toLowerCase();
                    String placedSpawnerType = firstCapitalWord(spawner.getSpawnedType().name());
                    GetSpawners.morphable.update(clickedBlock, spawnedType, spawnCount, minSpawnDelay, maxSpawnDelay, false, true);
                    setCustomName();
                    placedSpawnerType = fixSpawnedType(placedSpawnerType);
                    String inHandSpawnEggType = firstCapitalWord(player.getInventory().getItemInMainHand().getType().toString().replace("_SPAWN_EGG", ""));
                    inHandSpawnEggType = fixSpawnedType(inHandSpawnEggType);
                    String oldSpawnerId = CustomConfig.getSpawners().getString(
                            "Spawner_Lore." + placedSpawnerType).substring(0, CustomConfig.getSpawners().getString(
                            "Spawner_Lore." + placedSpawnerType).indexOf(","));
                    String newSpawnerId = CustomConfig.getSpawners().getString(
                            "Spawner_Lore." + inHandSpawnEggType).substring(0, CustomConfig.getSpawners().getString(
                            "Spawner_Lore." + inHandSpawnEggType).indexOf(","));
                    String changeMessage = CHANGED_SPAWNER
                            .replaceAll("%placed_spawner%", oldSpawnerId)
                            .replaceAll("%new_spawner%", newSpawnerId)
                            .replaceAll("&", "§");
                    player.sendMessage(PREFIX + " " + changeMessage);
                }
            }
        }
    }
}
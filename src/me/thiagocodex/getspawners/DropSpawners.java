package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.compatibility.GriefPreventionCompat;
import me.thiagocodex.getspawners.compatibility.ResidenceCompat;
import me.thiagocodex.getspawners.compatibility.SuperVanishCompat;
import me.thiagocodex.getspawners.compatibility.TownyCompat;
import me.thiagocodex.getspawners.compatibility.WorldGuardCompat;
import me.thiagocodex.getspawners.customconfig.CustomConfig;
import me.thiagocodex.getspawners.customconfig.Messages;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class DropSpawners extends Messages {
    protected static Player player;
    protected static Block block;
    protected static CreatureSpawner creatureSpawner;
    protected static ItemStack itemStack;
    protected static String spawnedType;

    @EventHandler
    private void onSpawnerMine(BlockBreakEvent event) {
        player = event.getPlayer();
        block = event.getBlock();
        if (block.getType() == Material.SPAWNER) {
            if (player.hasPermission("getspawners.drop")) {
                creatureSpawner = (CreatureSpawner) block.getState();
                spawnedType = firstCapitalWord(creatureSpawner.getSpawnedType().name());
                spawnedType = fixSpawnedType(spawnedType);
                String spawnerDisplayName = color(CustomConfig.getSpawners().getString("Spawner_Name." + firstCapitalWord(spawnedType)));
                String stringLores = color(CustomConfig.getSpawners().getString("Spawner_Lore." + spawnedType)).replaceAll("%owner%", player.getName());
                List<String> spawnerDisplayLore = new ArrayList<>();
                for (String lore : stringLores.split(",")) {
                    spawnerDisplayLore.add(lore.trim());
                }
                itemStack = getItemStack(spawnerDisplayName, spawnerDisplayLore, spawnedType);
                if (!GriefPreventionCompat.gpCompat(event)
                        || !ResidenceCompat.resCompat(event)
                        || !SuperVanishCompat.svCompat(event)
                        || !TownyCompat.townyCompat(event)) {
                    event.setCancelled(true);
                } else if (!WorldGuardCompat.wgCompat(event)) {
                    event.setCancelled(true);
                    player.sendMessage(PREFIX + " " + WORLDGUARD_COMPAT_NO_BREAK);
                } else if (player.hasPermission("getspawners.drop.all")
                        || player.hasPermission("getspawners.drop." + spawnedType.toLowerCase())) {
                    PickaxeTool.checkToMine(player, event);
                } else if (!player.hasPermission("getspawners.noperm.destroy")) {
                    event.setCancelled(true);
                    player.sendMessage(PREFIX + " " + NO_MOB_PERM.replaceAll("%spawner_name%", spawnerDisplayName));
                } else {
                    Mining.cancelBlockBreak(event);
                    player.sendMessage(PREFIX + " " + NO_MOB_PERM.replaceAll("%spawner_name%", spawnerDisplayName));
                }
            } else if (!player.hasPermission("getspawners.noperm.destroy")) {
                event.setCancelled(true);
                player.sendMessage(PREFIX + " " + NO_PERM);
            } else {
                player.sendMessage(PREFIX + " " + NO_PERM);
            }
        }
    }
}
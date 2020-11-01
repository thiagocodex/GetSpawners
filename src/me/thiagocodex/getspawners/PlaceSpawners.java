package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.Messages;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class PlaceSpawners extends Messages {

    @EventHandler
    private void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItemInHand();
        Block blockPlaced = event.getBlockPlaced();
        if (blockPlaced.getType() == Material.SPAWNER) {
            if (player.hasPermission("getspawners.place")) {
                String spawnedType = getSpawnedType(itemStack);
                GetSpawners.morphable.update(blockPlaced, spawnedType, 0, 0, 0, false, false);
            } else {
                event.setCancelled(true);
                player.sendMessage(PREFIX + " " + NO_PERM);
            }
        }
    }
}
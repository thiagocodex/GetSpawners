package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.Messages;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplodeHologram extends Messages implements Listener {
    @EventHandler
    private void onExplode(EntityExplodeEvent event) {
        for (Block block : event.blockList()) {
            if (block.getType() == Material.SPAWNER) {
                for (Entity entity : block.getChunk().getEntities()) {
                    if (block.getLocation().add(0.5, 0, 0.5).toString().equals(entity.getLocation().toString())) {
                        entity.remove();
                    }
                }
            }
        }
    }
}
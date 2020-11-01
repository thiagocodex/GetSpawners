package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.Messages;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DroppedExp extends Messages implements Listener {
    @EventHandler
    private void onDeath(EntityDeathEvent event) {
        if (droppedExpFromGsMobs && event.getEntity().getScoreboardTags().toString().contains("GSId")) {
            if (divide == 0) {
                divide = 1;
            }
            Bukkit.broadcastMessage(event.getDroppedExp() + "");
            event.setDroppedExp(event.getDroppedExp() * multiply / divide - subtract + add);
        } else if (droppedExpFromMobs && !event.getEntity().getScoreboardTags().toString().contains("GSId")) {
            if (divideVan == 0) {
                divideVan = 1;
            }
            event.setDroppedExp(event.getDroppedExp() * multiplyVan / divideVan - subtractVan + addVan);
        }
        if (ANNOUNCE_DROPPED_EXP_ENABLED && event.getEntity().getKiller() != null) {
            event.getEntity().getKiller().sendMessage(PREFIX + " " + color(DROPPED_EXP_ANNOUNCE
                    .replaceAll("%mob_name%", event.getEntity().getName())
                    .replaceAll("%dropped_exp%", Integer.toString(event.getDroppedExp()))));
        }
    }
}
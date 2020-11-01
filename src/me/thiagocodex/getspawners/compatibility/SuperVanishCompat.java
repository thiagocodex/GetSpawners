package me.thiagocodex.getspawners.compatibility;

import me.thiagocodex.getspawners.customconfig.Messages;
import de.myzelyam.supervanish.SuperVanish;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class SuperVanishCompat extends Messages {
    public static boolean svCompat(BlockBreakEvent e) {
        try {
            SuperVanish superVanish = SuperVanish.getPlugin(SuperVanish.class);
            return !superVanish.getVanishStateMgr().isVanished(e.getPlayer().getUniqueId()) || e.getPlayer().hasPermission("sv.breakblocks") || !superVanish.getSettings().getBoolean("RestrictiveOptions.PreventBlockBreaking");
        } catch (NoClassDefFoundError error) {
            return true;
        }
    }

    public static boolean svCompat(PlayerInteractEvent e) {
        try {
            SuperVanish superVanish = SuperVanish.getPlugin(SuperVanish.class);
            return !superVanish.getVanishStateMgr().isVanished(e.getPlayer().getUniqueId()) || !canChangeWithEggBySuperVanish;
        } catch (NoClassDefFoundError error) {
            return true;
        }
    }
}

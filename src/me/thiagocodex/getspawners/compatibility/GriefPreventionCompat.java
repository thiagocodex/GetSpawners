package me.thiagocodex.getspawners.compatibility;

import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class GriefPreventionCompat {
    public static boolean gpCompat(BlockBreakEvent e) {
        try {
            GriefPrevention.getPlugin(GriefPrevention.class);
            String noBreakReason = GriefPrevention.instance.allowBreak(e.getPlayer(), e.getBlock(), e.getBlock().getLocation());
            return noBreakReason == null;
        } catch (NoClassDefFoundError error) {
            return true;
        }
    }

    public static boolean gpCompat(PlayerInteractEvent e) {
        try {
            GriefPrevention.getPlugin(GriefPrevention.class);
            String noBuildReason = GriefPrevention.instance.allowBuild(e.getPlayer(), e.getClickedBlock().getLocation());
            return noBuildReason == null;
        } catch (NoClassDefFoundError error) {
            return true;
        }
    }
}
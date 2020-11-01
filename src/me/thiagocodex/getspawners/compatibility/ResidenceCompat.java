package me.thiagocodex.getspawners.compatibility;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.containers.Flags;
import com.bekvon.bukkit.residence.protection.FlagPermissions;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class ResidenceCompat {
    public static boolean resCompat(BlockBreakEvent e) {
        try {
            FlagPermissions perms = Residence.getPlugin(Residence.class).getPermsByLocForPlayer(e.getBlock().getLocation(), e.getPlayer());
            boolean allowed = perms.playerHas(e.getPlayer(), Flags.destroy, perms.playerHas(e.getPlayer(), Flags.build, true));
            return allowed || e.getPlayer().hasPermission("residence.bypass.destroy");
        } catch (NoClassDefFoundError error) {
            return true;
        }
    }

    public static boolean resCompat(PlayerInteractEvent e) {
        try {
            FlagPermissions perms = Residence.getPlugin(Residence.class).getPermsByLocForPlayer(e.getClickedBlock().getLocation(), e.getPlayer());
            boolean allowed = perms.playerHas(e.getPlayer(), Flags.destroy, perms.playerHas(e.getPlayer(), Flags.build, true));
            return allowed || e.getPlayer().hasPermission("residence.bypass.build");
        } catch (NoClassDefFoundError error) {
            return true;
        }
    }
}
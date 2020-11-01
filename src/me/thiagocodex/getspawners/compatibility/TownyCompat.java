package me.thiagocodex.getspawners.compatibility;

import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.object.TownyPermission;
import com.palmergames.bukkit.towny.utils.PlayerCacheUtil;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class TownyCompat {

    public static boolean townyCompat(BlockBreakEvent e) {
        try {
            Towny.getPlugin(Towny.class);
            return PlayerCacheUtil.getCachePermission(e.getPlayer(), e.getBlock().getLocation(), e.getBlock().getType(), TownyPermission.ActionType.DESTROY) || e.getPlayer().isOp();
        } catch (NoClassDefFoundError error) {
            return true;
        }
    }

    public static boolean townyCompat(PlayerInteractEvent e) {
        try {
            Towny.getPlugin(Towny.class);
            return PlayerCacheUtil.getCachePermission(e.getPlayer(), e.getClickedBlock().getLocation(), e.getClickedBlock().getType(), TownyPermission.ActionType.BUILD) || e.getPlayer().isOp();
        } catch (NoClassDefFoundError error) {
            return true;
        }
    }
}

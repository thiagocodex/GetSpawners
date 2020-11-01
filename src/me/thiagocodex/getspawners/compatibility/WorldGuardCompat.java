package me.thiagocodex.getspawners.compatibility;

import me.thiagocodex.getspawners.customconfig.Messages;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class WorldGuardCompat {
    public static boolean wgCompat(BlockBreakEvent e) {
        try {
            WorldGuardPlugin worldGuardPlugin = WorldGuardPlugin.getPlugin(WorldGuardPlugin.class);
            if (Messages.bukkitVersion.equals("1.8")) {
                Method method = worldGuardPlugin.getClass().getMethod("canBuild", Player.class, Block.class);
                return (boolean) method.invoke(worldGuardPlugin, e.getPlayer(), e.getBlock());
            } else {
                RegionQuery query = WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery();
                com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(e.getBlock().getLocation());
                return query.testState(loc, WorldGuardPlugin.inst().wrapPlayer(e.getPlayer()), com.sk89q.worldguard.protection.flags.Flags.BUILD) || e.getPlayer().isOp();

            }
        } catch (NoClassDefFoundError | NoSuchMethodException | InvocationTargetException | IllegalAccessException error) {
            return true;
        }
    }


    public static boolean wgCompat(PlayerInteractEvent e) {
        try {
            WorldGuardPlugin worldGuardPlugin = WorldGuardPlugin.getPlugin(WorldGuardPlugin.class);
            if (Messages.bukkitVersion.equals("1.8")) {
                Method method = worldGuardPlugin.getClass().getMethod("canBuild", Player.class, Block.class);
                return (boolean) method.invoke(worldGuardPlugin, e.getPlayer(), e.getClickedBlock());
            } else {
                RegionQuery query = WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery();
                com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(e.getClickedBlock().getLocation());
                return query.testState(loc, WorldGuardPlugin.inst().wrapPlayer(e.getPlayer()), com.sk89q.worldguard.protection.flags.Flags.BUILD) || e.getPlayer().isOp();
            }
        } catch (NoClassDefFoundError | NoSuchMethodException | InvocationTargetException | IllegalAccessException error) {
            return true;
        }
    }
}
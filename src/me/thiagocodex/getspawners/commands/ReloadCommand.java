package me.thiagocodex.getspawners.commands;

import me.thiagocodex.getspawners.*;
import me.thiagocodex.getspawners.customconfig.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;

class ReloadCommand extends Messages {
    private static final GetSpawners getSpawners = GetSpawners.getPlugin(GetSpawners.class);

    void reload(CommandSender commandSender) {
        if (commandSender.hasPermission("getspawners.reload")) {
            HandlerList.unregisterAll(getSpawners);
            getSpawners.loadConfig();
            getSpawners.getServer().getPluginManager().registerEvents(new ChangeSpawners(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new CheckLatest(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new CustomMobName(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new Debug(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new DropSpawners(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new DroppedExp(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new ExplodeHologram(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new PlaceSpawners(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new SpawnerStack(), getSpawners);
            commandSender.sendMessage(PREFIX + " " + RELOADED);
        } else {
            commandSender.sendMessage(PREFIX + " " + NO_PERM);
        }
    }
}
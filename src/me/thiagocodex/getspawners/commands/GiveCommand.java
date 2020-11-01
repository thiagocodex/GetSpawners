package me.thiagocodex.getspawners.commands;

import me.thiagocodex.getspawners.GiveSpawners;
import me.thiagocodex.getspawners.customconfig.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

class GiveCommand extends Messages {
    void give(CommandSender commandSender, String[] args) {
        if (commandSender.hasPermission("getspawners.give")) {
            if (args.length == 4 && args[2].matches("\\b" + getMobsRegex(getMobsHint(bukkitVersion)) + "\\b") && args[3].matches("^[0-9]{1,2}$")) {
                Player receiver = Bukkit.getServer().getPlayer(args[1]);
                if (receiver != null) {
                    GiveSpawners give = new GiveSpawners();
                    give.makeSpawner(commandSender, receiver, args[2], args[3], args[2]);
                } else {
                    commandSender.sendMessage(PREFIX + " " + PLAYER_NOT_FOUND);
                }
            } else {
                commandSender.sendMessage(PREFIX + " " + INVALID_COMMAND + "\n" + MOB_NAMES + " " + ChatColor.RED + getMobsHint(bukkitVersion));
            }
        } else {
            commandSender.sendMessage(PREFIX + " " + NO_PERM);
        }
    }
}
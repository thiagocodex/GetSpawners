package me.thiagocodex.getspawners.commands;

import me.thiagocodex.getspawners.Debug;
import me.thiagocodex.getspawners.customconfig.Messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class Commands extends Messages implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "reload":
                    ReloadCommand reloadCommand = new ReloadCommand();
                    reloadCommand.reload(commandSender);
                    break;
                case "give":
                    GiveCommand giveCommand = new GiveCommand();
                    giveCommand.give(commandSender, args);
                    break;
                case "xdebug":
                    new Debug().debugHologram((Player) commandSender);
                    break;
                default:
                    commandSender.sendMessage(PREFIX + " " + COMMANDS_HINT + ChatColor.RED + "\n/gs reload \n/gs give <player> <mob_name> <amount> \n/gs xdebug");
            }
        } else {
            commandSender.sendMessage(PREFIX + " " + COMMANDS_HINT + ChatColor.RED + "\n/gs reload \n/gs give <player> <mob_name> <amount> \n/gs xdebug");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> completions = new ArrayList<>();
        if (s.equalsIgnoreCase("gs")) {
            completions.add("give");
            completions.add("reload");
            completions.add("xdebug");
        }
        if (args[0].equalsIgnoreCase("give")) {
            completions.clear();
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                completions.add(player.getDisplayName().replaceAll("§.", ""));
            }
            if (args.length == 3) {
                completions.clear();
                String[] spawnersTypes = getMobsHint(bukkitVersion).split(", ");
                for (String spawnerType : spawnersTypes) {
                    for (int i = 1; i <= spawnerType.length(); i++) {
                        if (spawnerType.substring(0, i).equalsIgnoreCase(args[2])) {
                            completions.add(spawnerType);
                        } else if (args[2].length() == 0) {
                            completions.clear();
                            completions.addAll(Arrays.asList(spawnersTypes));
                        }
                    }
                }
            }
            if (args.length == 4) {
                completions.clear();
                completions.add("1");
                completions.add("5");
                completions.add("10");
                completions.add("20");
                completions.add("64");
                completions.add("99");
                Collections.sort(completions);
            }
            if (args.length > 4) {
                completions.clear();
            }
        } else if (args[0].equalsIgnoreCase("reload") ||
                args[0].equalsIgnoreCase("xdebug")) {
            completions.clear();
        }
        return completions;
    }
}
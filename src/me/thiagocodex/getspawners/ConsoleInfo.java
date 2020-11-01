package me.thiagocodex.getspawners;

import org.bukkit.Bukkit;

class ConsoleInfo {
    static String showCompatiblesStatus(String prefix, String versionMessage) {
        String worldGuardAndWorldEditStatus;
        if (Bukkit.getServer().getPluginManager().getPlugin("WorldGuard") != null &&
                Bukkit.getServer().getPluginManager().getPlugin("WorldEdit") != null) {
            worldGuardAndWorldEditStatus = "§aO K§r";
        } else {
            worldGuardAndWorldEditStatus = "§cN/A§r";
        }
        String superVanishStatus;
        if (Bukkit.getServer().getPluginManager().getPlugin("SuperVanish") != null) {
            superVanishStatus = "§aO K§r";
        } else {
            superVanishStatus = "§cN/A§r";
        }
        String griefPreventionStatus;
        if (Bukkit.getServer().getPluginManager().getPlugin("GriefPrevention") != null) {
            griefPreventionStatus = "§aO K§r";
        } else {
            griefPreventionStatus = "§cN/A§r";
        }
        String residenceStatus;
        if (Bukkit.getServer().getPluginManager().getPlugin("Residence") != null) {
            residenceStatus = "§aO K§r";
        } else {
            residenceStatus = "§cN/A§r";
        }
        String townyStatus;
        if (Bukkit.getServer().getPluginManager().getPlugin("Towny") != null) {
            townyStatus = "§aO K§r";
        } else {
            townyStatus = "§cN/A§r";
        }


        return "\n\nCompatibles with " + prefix.replaceAll("[\\[\\]]", "") + ":\n" +
                "+-----------------------------------------------+\n|   " + worldGuardAndWorldEditStatus + "   |        WorldGuard & WorldEdit       |\n" +
                "+---------+-------------------------------------+\n|   " + griefPreventionStatus + "   |           GriefPrevention           |\n" +
                "+---------+-------------------------------------+\n|   " + superVanishStatus + "   |             SuperVanish             |\n" +
                "+---------+-------------------------------------+\n|   " + residenceStatus + "   |              Residence              |\n" +
                "+---------+-------------------------------------+\n|   " + townyStatus + "   |                Towny                |\n" +
                "+-----------------------------------------------+\n|       " + versionMessage + "      |\n" +
                "+-----------------------------------------------+\n";
    }
}
package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.Messages;
import org.bukkit.Material;

public class BlockReplaced extends Messages {

    static boolean fix(Material material) {
        if (material == Material.valueOf("GRASS")
                || material == Material.valueOf("FERN")
                || material == Material.valueOf("DEAD_BUSH")
                || material == Material.valueOf("SEAGRASS")
                || material == Material.valueOf("TALL_SEAGRASS")
                || material == Material.valueOf("SNOW")
                || material == Material.valueOf("VINE")
                || material == Material.valueOf("TALL_GRASS")
                || material == Material.valueOf("LARGE_FERN")) {
            return true;

        } else if (bukkitVersion.equalsIgnoreCase("1.16")
                || bukkitVersion.equalsIgnoreCase("1.16.1")
                || bukkitVersion.equalsIgnoreCase("1.16.2")
                || bukkitVersion.equalsIgnoreCase("1.16.3")
                || bukkitVersion.equalsIgnoreCase("1.16.4")
                || bukkitVersion.equalsIgnoreCase("1.16.5")) {
            return material == Material.valueOf("WARPED_ROOTS")
                    || material == Material.valueOf("CRIMSON_ROOTS")
                    || material == Material.valueOf("NETHER_SPROUTS");
        } else {
            return false;
        }
    }
}


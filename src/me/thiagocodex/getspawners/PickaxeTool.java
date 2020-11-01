package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.Messages;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class PickaxeTool extends Messages {
    private static String option;

    public static void checkToMine(Player player, BlockBreakEvent event) {
        if (isNetheritePick && hasNetheritePickSilk && isDiamondPick && hasDiamondPickSilk && isIronPick && hasIronPickSilk) {
            option = "(.*NETHERITE_PICKAXE.*SILK_TOUCH.*)|(.*DIAMOND_PICKAXE.*SILK_TOUCH.*)|(.*IRON_PICKAXE.*SILK_TOUCH.*)";
        } else if (isNetheritePick && hasNetheritePickSilk && isDiamondPick && hasDiamondPickSilk && isIronPick) {
            option = "(.*NETHERITE_PICKAXE.*SILK_TOUCH.*)|(.*DIAMOND_PICKAXE.*SILK_TOUCH.*)|(.*IRON_PICKAXE.*)";
        } else if (isNetheritePick && hasNetheritePickSilk && isDiamondPick && isIronPick && hasIronPickSilk) {
            option = "(.*NETHERITE_PICKAXE.*SILK_TOUCH.*)|(.*DIAMOND_PICKAXE.*)|(.*IRON_PICKAXE.*SILK_TOUCH.*)";
        } else if (isNetheritePick && isDiamondPick && hasDiamondPickSilk && isIronPick && hasIronPickSilk) {
            option = "(.*NETHERITE_PICKAXE.*)|(.*DIAMOND_PICKAXE.*SILK_TOUCH.*)|(.*IRON_PICKAXE.*SILK_TOUCH.*)";
        } else if (isNetheritePick && hasNetheritePickSilk && isDiamondPick && isIronPick) {
            option = "(.*NETHERITE_PICKAXE.*SILK_TOUCH.*)|(.*DIAMOND_PICKAXE.*)|(.*IRON_PICKAXE.*)";
        } else if (isNetheritePick && isDiamondPick && isIronPick) {
            option = "(.*NETHERITE_PICKAXE.*)|(.*DIAMOND_PICKAXE.*)|(.*IRON_PICKAXE.*)";
        } else if (isNetheritePick && hasNetheritePickSilk && isDiamondPick && hasDiamondPickSilk) {
            option = "(.*NETHERITE_PICKAXE.*SILK_TOUCH.*)|(.*DIAMOND_PICKAXE.*SILK_TOUCH.*)";
        } else if (isNetheritePick && hasNetheritePickSilk && isIronPick && hasIronPickSilk) {
            option = "(.*NETHERITE_PICKAXE.*SILK_TOUCH.*)|(.*IRON_PICKAXE.*SILK_TOUCH.*)";
        } else if (isNetheritePick && isDiamondPick && hasDiamondPickSilk) {
            option = "(.*NETHERITE_PICKAXE.*)|(.*DIAMOND_PICKAXE.*SILK_TOUCH.*)";
        } else if (isNetheritePick && isIronPick && hasIronPickSilk) {
            option = "(.*NETHERITE_PICKAXE.*)|(.*IRON_PICKAXE.*SILK_TOUCH.*)";
        } else if (isNetheritePick && isDiamondPick) {
            option = "(.*NETHERITE_PICKAXE.*)|(.*DIAMOND_PICKAXE.*)";
        } else if (isNetheritePick && isIronPick) {
            option = "(.*NETHERITE_PICKAXE.*)|(.*IRON_PICKAXE.*)";
        } else if (isDiamondPick && hasDiamondPickSilk && isIronPick && hasIronPickSilk) {
            option = "(.*DIAMOND_PICKAXE.*SILK_TOUCH.*)|(.*IRON_PICKAXE.*SILK_TOUCH.*)";
        } else if (isDiamondPick && hasDiamondPickSilk && isIronPick) {
            option = "(.*DIAMOND_PICKAXE.*SILK_TOUCH.*)|(.*IRON_PICKAXE.*)";
        } else if (isDiamondPick && isIronPick && hasIronPickSilk) {
            option = "(.*IRON_PICKAXE.*SILK_TOUCH.*)|(.*DIAMOND_PICKAXE.*)";
        } else if (isDiamondPick && hasDiamondPickSilk) {
            option = ".*DIAMOND_PICKAXE.*SILK_TOUCH.*";
        } else if (isIronPick && hasIronPickSilk) {
            option = ".*IRON_PICKAXE.*SILK_TOUCH.*";
        } else if (isDiamondPick && isIronPick) {
            option = "(.*DIAMOND_PICKAXE.*|.*IRON_PICKAXE.*)";
        } else if (isDiamondPick) {
            option = ".*DIAMOND_PICKAXE.*";
        } else if (isIronPick) {
            option = ".*IRON_PICKAXE.*";
        }
        if (player.getGameMode() == GameMode.SURVIVAL) {
            if (player.getInventory().getItemInMainHand().toString().matches(option)) {
                Mining.mine(event);
            } else {
                if (!player.hasPermission("getspawners.noperm.destroy")) {
                    event.setCancelled(true);
                } else {
                    Mining.cancelBlockBreak(event);
                }
                player.sendMessage(PREFIX + " " + WARNING);
            }
        } else if (player.getGameMode() == GameMode.CREATIVE) {
            Hologram.remove(event);
        }
    }
}

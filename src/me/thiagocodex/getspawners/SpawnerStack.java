package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.CustomConfig;
import me.thiagocodex.getspawners.customconfig.Messages;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class SpawnerStack extends Messages {
    @EventHandler
    private void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block blockAgainst = event.getBlockAgainst();
        Block blockPlaced = event.getBlockPlaced();

        BlockState blockReplacedState = event.getBlockReplacedState();

        if (!(BlockReplaced.fix(blockReplacedState.getType()))) {

            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
            if (blockAgainst.getType() == Material.SPAWNER && itemInMainHand.getType() == Material.SPAWNER) {
                CreatureSpawner spawnerPlaced = (CreatureSpawner) blockAgainst.getState();
                CreatureSpawner inHandSpawner = (CreatureSpawner) blockPlaced.getState();
                String inHandSpawnedType = getSpawnedType(itemInMainHand);
                String spawnedType = firstCapitalWord(spawnerPlaced.getSpawnedType().name());
                spawnedType = fixSpawnedType(spawnedType);
                if (inHandSpawnedType.equals(firstCapitalWord(spawnedType))) {
                    if (spawnerPlaced.getMinSpawnDelay() < 215) {
                        GetSpawners.morphable.update(
                                blockAgainst,
                                spawnedType.toLowerCase(),
                                spawnerPlaced.getSpawnCount(),
                                spawnerPlaced.getMinSpawnDelay(),
                                spawnerPlaced.getMaxSpawnDelay(),
                                false,
                                false);
                        String inHandSpawnerSpawnedType = color(CustomConfig.getSpawners().getString("Spawner_Name." + spawnedType));
                        int spawnerAmount = spawnerPlaced.getMinSpawnDelay() == 200 ? 2 : spawnerPlaced.getMinSpawnDelay() - 199;
                        Particles.showParticles(spawnerAmount, blockAgainst, player);
                        String amount = Integer.toString(spawnerAmount);
                        String displayName = inHandSpawnerSpawnedType + " " + amount + "X";
                        if (spawnerPlaced.getMinSpawnDelay() == 201 || spawnerPlaced.getMinSpawnDelay() == 200 && spawnerPlaced.getSpawnCount() == 4) {
                            int x = blockAgainst.getX();
                            int y = blockAgainst.getY();
                            int z = blockAgainst.getZ();
                            player.getWorld().setGameRule(GameRule.SEND_COMMAND_FEEDBACK, false);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:armor_stand " +
                                    x + " " + y + " " + z + " " + "{" + "Invisible:1," + " CustomName:\"\\\"" + displayName + "\\\"\", CustomNameVisible:1, NoGravity:1, Small:1}");
                            player.getWorld().setGameRule(GameRule.SEND_COMMAND_FEEDBACK, true);
                        } else if (spawnerAmount >= 2) {
                            List<Entity> entities = blockAgainst.getWorld().getEntities();
                            for (Entity armorStand : entities) {
                                if (armorStand.getLocation().subtract(0.5, 0, 0.5).toString().equals(blockAgainst.getLocation().toString())) {
                                    armorStand.setCustomName(displayName);
                                }
                            }
                        }
                        if (player.getGameMode() == GameMode.SURVIVAL) {
                            ItemStack itemStack = new ItemStack(inHandSpawner.getType(), itemInMainHand.getAmount() - 1);
                            itemStack.setItemMeta(itemInMainHand.getItemMeta());
                            event.getPlayer().getInventory().setItemInMainHand(itemStack);
                        }
                    } else {
                        player.sendMessage(color(PREFIX + " " + STACK_LIMIT_WARNING));
                    }
                    event.setCancelled(true);
                }
                Block spawner;
                for (Entity entity : event.getPlayer().getWorld().getEntities()) {
                    if (entity instanceof ArmorStand) {
                        Location armorStandLocation = entity.getLocation();
                        spawner = event.getPlayer().getWorld().getBlockAt(armorStandLocation.subtract(0.5, 0, 0.5));
                        if (spawner.getType() != Material.SPAWNER && ((ArmorStand) entity).isSmall()) {
                            entity.remove();
                        }
                    }
                }
            }
        }
    }
}
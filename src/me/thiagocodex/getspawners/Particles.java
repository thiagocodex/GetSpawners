package me.thiagocodex.getspawners;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class Particles {
    private static final GetSpawners getSpawners = GetSpawners.getPlugin(GetSpawners.class);
    private static double piDiv10 = 1;

    public static void showParticles(int spawnerAmount, Block spawner, Player player) {
        Particle particle;
        switch (spawnerAmount) {
            case 2:
                particle = Particle.VILLAGER_HAPPY;
                break;
            case 3:
                particle = Particle.FLAME;
                break;
            case 4:
                particle = Particle.FIREWORKS_SPARK;
                break;
            case 5:
                particle = Particle.CRIT_MAGIC;
                break;
            case 6:
                particle = Particle.CLOUD;
                break;
            case 7:
                particle = Particle.END_ROD;
                break;
            case 8:
                particle = Particle.SPELL;
                break;
            case 9:
                particle = Particle.PORTAL;
                break;
            case 10:
                particle = Particle.TOTEM;
                break;
            case 11:
                particle = Particle.DRAGON_BREATH;
                break;
            case 12:
                particle = Particle.SNOWBALL;
                break;
            case 13:
                particle = Particle.LAVA;
                break;
            case 14:
                particle = Particle.HEART;
                break;
            default:
                particle = Particle.VILLAGER_ANGRY;
        }
        player.playSound(player.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
        Location location = spawner.getLocation().add(0.5, 0.1, 0.50);
        new BukkitRunnable() {
            @Override
            public void run() {
                piDiv10 += Math.PI / 18;
                double addX = Math.cos(piDiv10);
                double addZ = Math.sin(piDiv10);
                if (piDiv10 < 7.8) {
                    location.add(addX, 0, addZ);
                    spawner.getWorld().spawnParticle(particle, location, 1, 0, 0, 0, 0);
                    location.subtract(addX, 0, addZ);
                } else {
                    this.cancel();
                    piDiv10 = 1;
                }
            }
        }.runTaskTimerAsynchronously(getSpawners, 0, 1);
    }
}
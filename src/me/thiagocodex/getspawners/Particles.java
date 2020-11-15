package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.Messages;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class Particles extends Messages {
    private static final GetSpawners getSpawners = GetSpawners.getPlugin(GetSpawners.class);
    private static double piDiv10 = 1;


    public static void showParticles(int spawnerAmount, Block spawner, Player player) {
        Particle particle;
        Sound sound;
        switch (spawnerAmount) {
            case 2:
                particle = Particle.valueOf(particleAndSound.get(0).split(",")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(0).split(",")[1].trim());
                break;
            case 3:
                particle = Particle.valueOf(particleAndSound.get(1).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(1).split(", ")[1].trim());
                break;
            case 4:
                particle = Particle.valueOf(particleAndSound.get(2).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(2).split(", ")[1].trim());
                break;
            case 5:
                particle = Particle.valueOf(particleAndSound.get(3).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(3).split(", ")[1].trim());
                break;
            case 6:
                particle = Particle.valueOf(particleAndSound.get(4).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(4).split(", ")[1].trim());
                break;
            case 7:
                particle = Particle.valueOf(particleAndSound.get(5).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(5).split(", ")[1].trim());
                break;
            case 8:
                particle = Particle.valueOf(particleAndSound.get(6).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(6).split(", ")[1].trim());
                break;
            case 9:
                particle = Particle.valueOf(particleAndSound.get(7).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(7).split(", ")[1].trim());
                break;
            case 10:
                particle = Particle.valueOf(particleAndSound.get(8).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(8).split(", ")[1].trim());
                break;
            case 11:
                particle = Particle.valueOf(particleAndSound.get(9).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(9).split(", ")[1].trim());
                break;
            case 12:
                particle = Particle.valueOf(particleAndSound.get(10).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(10).split(", ")[1].trim());
                break;
            case 13:
                particle = Particle.valueOf(particleAndSound.get(11).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(11).split(", ")[1].trim());
                break;
            case 14:
                particle = Particle.valueOf(particleAndSound.get(12).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(12).split(", ")[1].trim());
                break;
            default:
                particle = Particle.valueOf(particleAndSound.get(13).split(", ")[0].trim());
                sound = Sound.valueOf(particleAndSound.get(13).split(", ")[1].trim());
        }
        player.playSound(player.getLocation(), sound, 1, 1);
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
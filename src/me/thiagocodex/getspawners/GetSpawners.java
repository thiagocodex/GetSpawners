package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.commands.Commands;
import me.thiagocodex.getspawners.customconfig.CustomConfig;
import me.thiagocodex.getspawners.customconfig.Messages;
import me.thiagocodex.getspawners.nms_1_13_R1.UpdateSpawners_1_13_R1;
import me.thiagocodex.getspawners.nms_1_13_R2.UpdateSpawners_1_13_R2;
import me.thiagocodex.getspawners.nms_1_14_R1.UpdateSpawners_1_14_R1;
import me.thiagocodex.getspawners.nms_1_15_R1.UpdateSpawners_1_15_R1;
import me.thiagocodex.getspawners.nms_1_16_R1.UpdateSpawners_1_16_R1;
import me.thiagocodex.getspawners.nms_1_16_R2.UpdateSpawners_1_16_R2;
import me.thiagocodex.getspawners.nms_1_16_R3.UpdateSpawners_1_16_R3;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class GetSpawners extends JavaPlugin {
    protected static Morphable morphable;
    public void onEnable() {
        new CheckLatest().getGSVersion();
        loadConfig();
        switch (Messages.bukkitVersion) {
            case "1.13":
                morphable = new UpdateSpawners_1_13_R1();
                break;
            case "1.13.1":
            case "1.13.2":
                morphable = new UpdateSpawners_1_13_R2();
                break;
            case "1.14":
            case "1.14.1":
            case "1.14.2":
            case "1.14.3":
            case "1.14.4":
                morphable = new UpdateSpawners_1_14_R1();
                break;
            case "1.15":
            case "1.15.1":
            case "1.15.2":
                morphable = new UpdateSpawners_1_15_R1();
                break;
            case "1.16":
            case "1.16.1":
                morphable = new UpdateSpawners_1_16_R1();
                break;
            case "1.16.2":
            case "1.16.3":
                morphable = new UpdateSpawners_1_16_R2();

                break;
            case "1.16.4":
            case "1.16.5":
                morphable = new UpdateSpawners_1_16_R3();
        }
        getServer().getPluginManager().registerEvents(new ChangeSpawners(), this);
        getServer().getPluginManager().registerEvents(new CheckLatest(), this);
        getServer().getPluginManager().registerEvents(new CustomMobName(), this);
        getServer().getPluginManager().registerEvents(new Debug(), this);
        getServer().getPluginManager().registerEvents(new DropSpawners(), this);
        getServer().getPluginManager().registerEvents(new DroppedExp(), this);
        getServer().getPluginManager().registerEvents(new ExplodeHologram(), this);
        getServer().getPluginManager().registerEvents(new PlaceSpawners(), this);
        getServer().getPluginManager().registerEvents(new SpawnerStack(), this);
        getCommand("gs").setExecutor(new Commands());
        Bukkit.getConsoleSender().sendMessage(Messages.PREFIX + " " + Messages.ENABLED);
        Bukkit.getConsoleSender().sendMessage(ConsoleInfo.showCompatiblesStatus(Messages.PREFIX, CheckLatest.versionMessage));

    }
    public void loadConfig() {
        try {
            CustomConfig.onCreateFolderAndFiles();
            CustomConfig.loadReload();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
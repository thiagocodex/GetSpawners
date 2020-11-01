package me.thiagocodex.getspawners;

import me.thiagocodex.getspawners.customconfig.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CheckLatest implements Listener {
    static String versionMessage;
    private static String stringGsVersion;
    private static final GetSpawners getSpawners = GetSpawners.getPlugin(GetSpawners.class);
    private static HttpURLConnection httpURLConnection;

    float getGSVersion() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            URL gsBlog = new URL("https://raw.githubusercontent.com/thiagocodex/GetSpawners/main/VERSION");
            httpURLConnection = (HttpURLConnection) gsBlog.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) stringBuilder.append(inputLine);
            in.close();
            int gsVersion = Integer.parseInt(stringBuilder.toString().replaceAll("%", "").replaceAll("\\.", ""));
            stringGsVersion = stringBuilder.toString().replaceAll("%", "");
            if (Integer.parseInt(getSpawners.getDescription().getVersion()
                    .replaceAll("%", "").replaceAll("\\.", "")) < gsVersion) {
                versionMessage = "§cYou don't have the latest version!§r";
            } else {
                versionMessage = "   §bYou have the latest version!§r   ";
            }
            return gsVersion;
        } catch (IOException e) {
            versionMessage = " §eDon't worry, can't connect to db!§r";
        } finally {
            httpURLConnection.disconnect();
        }
        return 0;
    }

    @EventHandler
    private void onOpJoin(PlayerJoinEvent event) {
        if (event.getPlayer().isOp()) {
            if (Integer.parseInt(getSpawners.getDescription().getVersion()
                    .replaceAll("%", "").replaceAll("\\.", "")) < getGSVersion()) {
                event.getPlayer().sendMessage(Messages.PREFIX + " " + "§6There is a new updated version available!\n" +
                        "current version: §e§l" + getSpawners.getDescription().getVersion() + " §6new version: §a§l" + stringGsVersion + " §6click to download:\n§3https://github.com/thiagocodex/GetSpawners/releases");
                event.getPlayer().sendMessage("");
            }
        }
    }
}

package me.thiagocodex.getspawners.customconfig;

import me.thiagocodex.getspawners.nms_1_13_R1.ItemStack_1_13_R1;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.ItemTagType;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Messages implements Listener {
    public static String fixSpawnedType(String spawnedType) {
        switch (spawnedType) {
            case "Pig_Zombie":
                return "Zombie_Pigman";
            case "Mushroom_Cow":
                return "Mooshroom";
            case "Snowman":
                return "Snow_Golem";
        }
        return spawnedType;
    }

    public static String getSpawnedType(ItemStack itemStack) {
        switch (bukkitVersion) {
            case "1.13":
                return firstCapitalWord(ItemStack_1_13_R1.getTag(itemStack));
            case "1.13.1":
            case "1.13.2":
                return itemStack.getItemMeta().getCustomTagContainer()
                        .getCustomTag(new NamespacedKey(CustomConfig.getSpawners, "SpawnerType"), ItemTagType.STRING);
            case "1.14":
            case "1.14.1":
            case "1.14.2":
            case "1.14.3":
            case "1.14.4":
            case "1.15":
            case "1.15.1":
            case "1.15.2":
            case "1.16":
            case "1.16.1":
            case "1.16.2":
            case "1.16.3":
            case "1.16.4":
            case "1.16.5":
                return itemStack.getItemMeta().getPersistentDataContainer()
                        .get(new NamespacedKey(CustomConfig.getSpawners, "SpawnerType"), PersistentDataType.STRING);
        }
        return null;
    }

    public static ItemStack getItemStack(String spawnerDisplayName, List<String> spawnerDisplayLore, String spawnedType) {
        ItemMeta itemMeta;
        ItemStack itemStack;
        switch (bukkitVersion) {
            case "1.13":
                itemStack = new ItemStack(Material.SPAWNER, 1);
                itemStack = ItemStack_1_13_R1.itemStack(itemStack, spawnedType);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.WHITE + spawnerDisplayName);
                itemMeta.setLore(spawnerDisplayLore);
                itemStack.setItemMeta(itemMeta);
                return itemStack;
            case "1.13.1":
            case "1.13.2":
                itemStack = new ItemStack(Material.SPAWNER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.getCustomTagContainer().setCustomTag(new NamespacedKey(CustomConfig.getSpawners, "SpawnerType"), ItemTagType.STRING, firstCapitalWord(spawnedType));
                itemStack.setItemMeta(itemMeta);
                itemMeta.setDisplayName(ChatColor.WHITE + spawnerDisplayName);
                itemMeta.setLore(spawnerDisplayLore);
                itemStack.setItemMeta(itemMeta);
                return itemStack;
            case "1.14":
            case "1.14.1":
            case "1.14.2":
            case "1.14.3":
            case "1.14.4":
            case "1.15":
            case "1.15.1":
            case "1.15.2":
            case "1.16":
            case "1.16.1":
            case "1.16.2":
            case "1.16.3":
            case "1.16.4":
            case "1.16.5":
                itemStack = new ItemStack(Material.SPAWNER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.WHITE + spawnerDisplayName);
                itemMeta.setLore(spawnerDisplayLore);
                itemMeta.getPersistentDataContainer().set(new NamespacedKey(CustomConfig.getSpawners, "SpawnerType"), PersistentDataType.STRING, firstCapitalWord(spawnedType));
                itemStack.setItemMeta(itemMeta);
                return itemStack;
        }
        return null;
    }

    public static String bukkitVersion = Bukkit.getBukkitVersion().substring(0, Bukkit.getBukkitVersion().indexOf("-"));

    protected static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    protected static String firstCapitalWord(String string) {
        string = string.toLowerCase();
        if (string.contains("_")) {
            StringBuilder stringBuilder = new StringBuilder();
            String[] part = string.split("_");
            for (String s : part) {
                stringBuilder.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append("_");
            }
            return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
        } else {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        }
    }

    protected static String getMobsHint(String bukkitVersion) {
        List<String> versionMobs = new ArrayList<>();
        String[] mobs1_13 = {"Bat", "Blaze", "Cave_Spider", "Chicken", "Cod", "Cow", "Creeper", "Dolphin", "Donkey", "Drowned", "Elder_Guardian", "Ender_Dragon", "Enderman", "Endermite", "Evoker", "Ghast", "Giant", "Guardian", "Horse", "Husk", "Illusioner", "Iron_Golem", "Llama", "Magma_Cube", "Mooshroom", "Mule", "Ocelot", "Parrot", "Phantom", "Pig", "Polar_Bear", "Pufferfish", "Rabbit", "Salmon", "Sheep", "Shulker", "Silverfish", "Skeleton", "Skeleton_Horse", "Slime", "Snow_Golem", "Spider", "Squid", "Stray", "Tropical_Fish", "Turtle", "Vex", "Villager", "Vindicator", "Witch", "Wither", "Wither_Skeleton", "Wolf", "Zombie", "Zombie_Horse", "Zombie_Pigman", "Zombie_Villager"};
        switch (bukkitVersion) {
            case "1.13":
            case "1.13.1":
            case "1.13.2":
                Collections.addAll(versionMobs, mobs1_13);
                break;
            case "1.14":
            case "1.14.1":
            case "1.14.2":
            case "1.14.3":
            case "1.14.4":
                Collections.addAll(versionMobs, mobs1_13);
                Collections.addAll(versionMobs, "Cat", "Fox", "Panda", "Pillager", "Ravager", "Trader_Llama", "Wandering_Trader");
                break;
            case "1.15":
            case "1.15.1":
            case "1.15.2":
                Collections.addAll(versionMobs, mobs1_13);
                Collections.addAll(versionMobs, "Cat", "Fox", "Panda", "Pillager", "Ravager", "Trader_Llama", "Wandering_Trader");
                Collections.addAll(versionMobs, "Bee");
                break;
            case "1.16":
            case "1.16.1":
                Collections.addAll(versionMobs, mobs1_13);
                Collections.addAll(versionMobs, "Cat", "Fox", "Panda", "Pillager", "Ravager", "Trader_Llama", "Wandering_Trader");
                Collections.addAll(versionMobs, "Bee");
                Collections.addAll(versionMobs, "Hoglin", "Piglin", "Strider", "Zoglin", "Zombified_Piglin");
                versionMobs.remove("Zombie_Pigman");
                break;
            case "1.16.2":
            case "1.16.3":
            case "1.16.4":
            case "1.16.5":
                Collections.addAll(versionMobs, mobs1_13);
                Collections.addAll(versionMobs, "Cat", "Fox", "Panda", "Pillager", "Ravager", "Trader_Llama", "Wandering_Trader");
                Collections.addAll(versionMobs, "Bee");
                Collections.addAll(versionMobs, "Hoglin", "Piglin", "Strider", "Zoglin", "Zombified_Piglin", "Piglin_Brute");
                versionMobs.remove("Zombie_Pigman");
        }
        Collections.sort(versionMobs);
        return versionMobs.toString().
                replaceAll("[]\\[]", "");
    }

    protected static String getMobsRegex(String versionMobsToRegex) {
        return "(?i)" + versionMobsToRegex.replaceAll(", ", "|");
    }

    protected static boolean isNetheritePick;
    protected static boolean hasNetheritePickSilk;
    protected static boolean isDiamondPick;
    protected static boolean hasDiamondPickSilk;
    protected static boolean isIronPick;
    protected static boolean hasIronPickSilk;
    protected static boolean canChangeWithEgg;
    protected static boolean canChangeWithEggBySuperVanish;
    protected static boolean customNameForGsMobs;
    protected static boolean alwaysVisibleGsMobsName;
    protected static boolean droppedExpFromGsMobs;
    protected static int multiply;
    protected static int divide;
    protected static int subtract;
    protected static int add;
    protected static boolean droppedExpFromMobs;
    protected static int multiplyVan;
    protected static int divideVan;
    protected static int subtractVan;
    protected static int addVan;
    protected static boolean canLog;
    protected static boolean isParticleAndSound;
    protected static String zoneId;
    protected static String datePattern;
    protected static String timePattern;
    protected static String logOutput;
    protected static List<String> particleAndSound = new ArrayList<>();
    public static String PREFIX;
    public static String ENABLED;
    protected static String RELOADED;
    protected static String LUCKY;
    protected static String UNLUCKY;
    protected static String WARNING;
    protected static String NO_PERM;
    protected static String NO_MOB_PERM;
    protected static String PLAYER_NOT_FOUND;
    protected static String INVALID_COMMAND;
    protected static String GAVE;
    protected static String RECEIVED;
    protected static String MOB_NAMES;
    protected static String COMMANDS_HINT;
    protected static String CHANGED_SPAWNER;
    protected static String NO_CHANGE_ENABLED;
    protected static String GRIEFPREVENTION_COMPAT_NO_INTERACT;
    protected static String RESIDENCE_COMPAT_NO_INTERACT;
    protected static String WORLDGUARD_COMPAT_NO_INTERACT;
    protected static String WORLDGUARD_COMPAT_NO_BREAK;
    protected static String SUPERVANISH_COMPAT_NO_INTERACT;
    protected static String TOWNY_COMPAT_NO_INTERACT;
    protected static String STACK_LIMIT_WARNING;
    protected static String BUG_REMOVED_ANNOUNCE;
    protected static String BUG_REMOVED_AMOUNT;
    protected static String DROPPED_EXP_ANNOUNCE;
    protected static boolean ANNOUNCE_DROPPED_EXP_ENABLED;

    public static void reloadConfig() {
        //Plugin config options
        isNetheritePick = CustomConfig.getConfig().getBoolean("Netherite_Pickaxe.Enabled");
        hasNetheritePickSilk = CustomConfig.getConfig().getBoolean("Netherite_Pickaxe.Silk_Touch_Required");
        isDiamondPick = CustomConfig.getConfig().getBoolean("Diamond_Pickaxe.Enabled");
        hasDiamondPickSilk = CustomConfig.getConfig().getBoolean("Diamond_Pickaxe.Silk_Touch_Required");
        isIronPick = CustomConfig.getConfig().getBoolean("Iron_Pickaxe.Enabled");
        hasIronPickSilk = CustomConfig.getConfig().getBoolean("Iron_Pickaxe.Silk_Touch_Required");
        canChangeWithEgg = CustomConfig.getConfig().getBoolean("Allow_SpawnEgg_Change.Enabled");
        canChangeWithEggBySuperVanish = CustomConfig.getConfig().getBoolean("SuperVanish_Prevent_SpawnEgg_Change.Enabled");
        customNameForGsMobs = CustomConfig.getConfig().getBoolean("Custom_Name_For_gsMobs.Enabled");
        alwaysVisibleGsMobsName = CustomConfig.getConfig().getBoolean("Always_Visible_Name.Enabled");
        droppedExpFromGsMobs = CustomConfig.getConfig().getBoolean("Dropped_Exp_From_gsMobs.Enabled");
        multiply = CustomConfig.getConfig().getInt("Dropped_Exp_From_gsMobs.Multiply");
        divide = CustomConfig.getConfig().getInt("Dropped_Exp_From_gsMobs.Divide");
        subtract = CustomConfig.getConfig().getInt("Dropped_Exp_From_gsMobs.Subtract");
        add = CustomConfig.getConfig().getInt("Dropped_Exp_From_gsMobs.Add");
        droppedExpFromMobs = CustomConfig.getConfig().getBoolean("Dropped_Exp_From_Vanilla_Mobs.Enabled");
        multiplyVan = CustomConfig.getConfig().getInt("Dropped_Exp_From_Vanilla_Mobs.Multiply");
        divideVan = CustomConfig.getConfig().getInt("Dropped_Exp_From_Vanilla_Mobs.Divide");
        subtractVan = CustomConfig.getConfig().getInt("Dropped_Exp_From_Vanilla_Mobs.Subtract");
        addVan = CustomConfig.getConfig().getInt("Dropped_Exp_From_Vanilla_Mobs.Add");
        canLog = CustomConfig.getConfig().getBoolean("Log.Enabled");
        zoneId = CustomConfig.getConfig().getString("Log.ZoneId");
        datePattern = CustomConfig.getConfig().getString("Log.DatePattern");
        timePattern = CustomConfig.getConfig().getString("Log.TimePattern");
        logOutput = color(CustomConfig.getConfig().getString("Log.Output"));
        particleAndSound = CustomConfig.getConfig().getStringList("Particles.Particle_And_Sound");
        isParticleAndSound = CustomConfig.getConfig().getBoolean("Particles.Enabled");
        //Plugin runtime messages
        PREFIX = color(CustomConfig.getMessages().getString("Plugin.Prefix"));
        ENABLED = color(CustomConfig.getMessages().getString("Console_Messages.Plugin_Enabled"));
        RELOADED = color(CustomConfig.getMessages().getString("Console_Messages.Plugin_Reloaded"));
        LUCKY = color(CustomConfig.getMessages().getString("Messages.Lucky"));
        UNLUCKY = color(CustomConfig.getMessages().getString("Messages.Unlucky"));
        WARNING = color(CustomConfig.getMessages().getString("Messages.Warning"));
        NO_PERM = color(CustomConfig.getMessages().getString("Messages.No_Permission"));
        NO_MOB_PERM = color(CustomConfig.getMessages().getString("Messages.No_Mob_Permission"));
        PLAYER_NOT_FOUND = color(CustomConfig.getMessages().getString("Messages.Player_Not_Found"));
        INVALID_COMMAND = color(CustomConfig.getMessages().getString("Messages.Invalid_Command"));
        GAVE = color(CustomConfig.getMessages().getString("Messages.Gave"));
        RECEIVED = color(CustomConfig.getMessages().getString("Messages.Received"));
        MOB_NAMES = color(CustomConfig.getMessages().getString("Messages.Mob_Names"));
        COMMANDS_HINT = color(CustomConfig.getMessages().getString("Messages.Commands_Hint"));
        CHANGED_SPAWNER = color(CustomConfig.getMessages().getString("Messages.Changed_Spawner"));
        NO_CHANGE_ENABLED = color(CustomConfig.getMessages().getString("Messages.No_Change_Enabled"));
        GRIEFPREVENTION_COMPAT_NO_INTERACT = color(CustomConfig.getMessages().getString("Messages.GriefPrevention_Compat_No_Interact"));
        RESIDENCE_COMPAT_NO_INTERACT = color(CustomConfig.getMessages().getString("Messages.Residence_Compat_No_Interact"));
        WORLDGUARD_COMPAT_NO_INTERACT = color(CustomConfig.getMessages().getString("Messages.WorldGuard_Compat_No_Interact"));
        WORLDGUARD_COMPAT_NO_BREAK = color(CustomConfig.getMessages().getString("Messages.WorldGuard_Compat_No_Break"));
        SUPERVANISH_COMPAT_NO_INTERACT = color(CustomConfig.getMessages().getString("Messages.SuperVanish_Compat_No_Interact"));
        TOWNY_COMPAT_NO_INTERACT = color(CustomConfig.getMessages().getString("Messages.Towny_Compat_No_Interact"));
        STACK_LIMIT_WARNING = color(CustomConfig.getMessages().getString("Messages.Stack_Limit_Warning"));
        BUG_REMOVED_ANNOUNCE = color(CustomConfig.getMessages().getString("Messages.Bug_Removed_Announce"));
        BUG_REMOVED_AMOUNT = color(CustomConfig.getMessages().getString("Messages.Bug_Removed_Amount"));
        ANNOUNCE_DROPPED_EXP_ENABLED = CustomConfig.getMessages().getBoolean("Announce_Dropped_Exp.Enabled");
        DROPPED_EXP_ANNOUNCE = color(CustomConfig.getMessages().getString("Announce_Dropped_Exp.Message"));
    }
}
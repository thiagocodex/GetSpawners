package me.thiagocodex.getspawners.customconfig;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

abstract class EnglishContent {
    private static Writer writer;

    static void writeEnMessagesContent(Path messagesFile) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(messagesFile.toFile()), StandardCharsets.UTF_8));
            writer.write("# If you want to change any line in any file, if the first character is '&' type between \"' '\"  e.g: '&aEnabled successfully!'\n" +
                    "Plugin:\n" +
                    "# The prefix that will appear always when the plugin send a message\n" +
                    "  Prefix: '&f[&eGet&3Spawners&f]'\n" +
                    "\n" +
                    "Console_Messages:\n" +
                    "# Enabled message in the console start\n" +
                    "  Plugin_Enabled: '&aEnabled successfully!'\n" +
                    "\n" +
                    "# Reloaded message to reload command sender\n" +
                    "  Plugin_Reloaded: '&aReloaded successfully!'\n" +
                    "\n" +
                    "Messages:\n" +
                    "# Show when a player mines a spawner successfully\n" +
                    "  Lucky: '&bWow, Lucky guy ! ! !'\n" +
                    "\n" +
                    "# If some group is using percentage permission, this will show if a player mines and not have luck\n" +
                    "  Unlucky: '&cBetter luck next time.'\n" +
                    "\n" +
                    "# Here is the message to send when a player to use a not allowed pick\n" +
                    "  Warning: '&cYou can''t mine spawners with this type of tool.'\n" +
                    "\n" +
                    "# When players have not permission, it will show when he mines a spawner\n" +
                    "  No_Permission: '&cYou don''t have permission to do that.'\n" +
                    "\n" +
                    "# When players have not mob permission, it will show when he mines a spawner\n" +
                    "  No_Mob_Permission: '&cYou don''t have permission to drop a&r %spawner_name%'\n" +
                    "\n" +
                    "# If you try to give a spawner to a player whom not exist online in the server\n" +
                    "  Player_Not_Found: '&cPlayer not found online in the server.'\n" +
                    "\n" +
                    "# Invalid command message to help\n" +
                    "  Invalid_Command: '&cInvalid command: &6Usage: /gs give <player> <mob_name> <amount>'\n" +
                    "\n" +
                    "# Gave message will appear if you have success giving a player spawners with command\n" +
                    "  Gave: '&aYou gave &6%amount%&r %spawner_name% &ato &f%player%.'\n" +
                    "\n" +
                    "# Received message will appear if you have success receiving a spawners from an admin or console\n" +
                    "  Received: '&aYou received &6%amount%&r %spawner_name% &afrom &f%sender%.'\n" +
                    "\n" +
                    "# Available mob names to help with commands\n" +
                    "  Mob_Names: '&eMob names:'\n" +
                    "\n" +
                    "# Command hint maybe also can help\n" +
                    "  Commands_Hint: '&eAvailable commands:'\n" +
                    "\n" +
                    "# The message to notice that you changed a mob spawner from what to what\n" +
                    "  Changed_Spawner: '&fChanged %placed_spawner% &fto %new_spawner%.'\n" +
                    "\n" +
                    "# If the change option is disabled, plugin will notice you by this message\n" +
                    "  No_Change_Enabled: '&cYou can''t do this because that option is disabled in getspawners config.yml file.'\n" +
                    "\n" +
                    "# When you have GriefPrevention plugin installed, this message will appear to players that tries to change protected spawners\n" +
                    "  GriefPrevention_Compat_No_Interact: '&2GriefPrevention protected area; &cYou don''t have permission to interact with that block.'\n" +
                    "\n" +
                    "# When you have Residence plugin installed, this message will appear to players that tries to change protected spawners\n" +
                    "  Residence_Compat_No_Interact: '&6Residence protected area; &cYou don''t have interact &cpermission<s> with that block.'\n" +
                    "\n" +
                    "# When you have WorldGuard plugin installed, this message will appear to players that tries to change protected spawners\n" +
                    "  WorldGuard_Compat_No_Interact: '&3WorldGuard protected area; &c&lHey! &7Sorry, but you can''t interact with that block here.'\n" +
                    "  \n" +
                    "# When you have WorldGuard plugin installed, this message will appear to players that tries to break protected spawners\n" +
                    "  WorldGuard_Compat_No_Break: '&3WorldGuard protected area; &c&lHey! &7Sorry, but you can''t break that block here.'\n" +
                    "\n" +
                    "# When you have Towny plugin installed, this message will appear to players that try to change protected spawners\n" +
                    "  Towny_Compat_No_Interact: '&5Towny protected area; &cNot allowed to interact with that block.'\n" +
                    "\n" +
                    "# When you have SuperVanish plugin installed, this message will appear to invisibles players that tries to change spawners while\n" +
                    "# superVanish_Prevent_SpawnEgg_Change option is set to true in GetSpawners config.yml file\n" +
                    "  SuperVanish_Compat_No_Interact: '&cYou can''t change spawners while invisible by &aSuperVanish, &cbecause prevent option is enabled in getspawners config.yml file.'\n" +
                    "\n" +
                    "# This message will appear when players tries to stack more than the limit amount of spawners in just one block\n" +
                    "  Stack_Limit_Warning: '&cYou have reached the maximum of spawners to stack in one block.'\n" +
                    "\n" +
                    "# This message will appear when players have sent gs xdebug command then remove hologram name without spawners\n" +
                    "  Bug_Removed_Announce: '&eBug removed, %hologram_name% name without a spawner had been gone.'\n" +
                    "\n" +
                    "# This message will appear showing the amount of removed hologram name without spawners\n" +
                    "  Bug_Removed_Amount: '&eRemoved &a%amount% &eholograms names without a spawner.'\n" +
                    "\n" +
                    "# Choose if you want to see how many exp mobs have been dropped at their death\n" +
                    "Announce_Dropped_Exp:\n" +
                    "  Enabled: false\n" +
                    "  Message: '&aKilled &6%mob_name% &adropped %dropped_exp% exp.'");
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static void writeEnSpawnersContent(Path spawnersFile) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(spawnersFile.toFile()), StandardCharsets.UTF_8));
            writer.write("# Read with attention\n" +
                    "# If you want to change any line in any file, if the first character is '&' type between \"' '\"  e.g: '&6Blaze Spawner'\n" +
                    "# You're able to change spawners name whatever you want, but 2 not equals spawners names won't stack\n" +
                    "Spawner_Name:\n" +
                    "  Bat: '&fBat Spawner'\n" +
                    "  Bee: '&fBee Spawner'\n" +
                    "  Blaze: '&fBlaze Spawner'\n" +
                    "  Cat: '&fCat Spawner'\n" +
                    "  Cave_Spider: '&fCave_Spider Spawner'\n" +
                    "  Chicken: '&fChicken Spawner'\n" +
                    "  Cod: '&fCod Spawner'\n" +
                    "  Cow: '&fCow Spawner'\n" +
                    "  Creeper: '&fCreeper Spawner'\n" +
                    "  Dolphin: '&fDolphin Spawner'\n" +
                    "  Donkey: '&fDonkey Spawner'\n" +
                    "  Drowned: '&fDrowned Spawner'\n" +
                    "  Elder_Guardian: '&fElder_Guardian Spawner'\n" +
                    "  Ender_Dragon: '&fEnder_Dragon Spawner'\n" +
                    "  Enderman: '&fEnderman Spawner'\n" +
                    "  Endermite: '&fEndermite Spawner'\n" +
                    "  Evoker: '&fEvoker Spawner'\n" +
                    "  Fox: '&fFox Spawner'\n" +
                    "  Ghast: '&fGhast Spawner'\n" +
                    "  Giant: '&fGiant Spawner'\n" +
                    "  Guardian: '&fGuardian Spawner'\n" +
                    "  Hoglin: '&fHoglin Spawner'\n" +
                    "  Horse: '&fHorse Spawner'\n" +
                    "  Husk: '&fHusk Spawner'\n" +
                    "  Illusioner: '&fIllusioner Spawner'\n" +
                    "  Iron_Golem: '&fIron_Golem Spawner'\n" +
                    "  Llama: '&fLlama Spawner'\n" +
                    "  Magma_Cube: '&fMagma_Cube Spawner'\n" +
                    "  Mooshroom: '&fMooshroom Spawner'\n" +
                    "  Mule: '&fMule Spawner'\n" +
                    "  Ocelot: '&fOcelot Spawner'\n" +
                    "  Panda: '&fPanda Spawner'\n" +
                    "  Parrot: '&fParrot Spawner'\n" +
                    "  Phantom: '&fPhantom Spawner'\n" +
                    "  Pig: '&fPig Spawner'\n" +
                    "  Piglin: '&fPiglin Spawner'\n" +
                    "  Piglin_Brute: '&fPiglin_Brute Spawner'\n" +
                    "  Pillager: '&fPillager Spawner'\n" +
                    "  Polar_Bear: '&fPolar_Bear Spawner'\n" +
                    "  Pufferfish: '&fPufferfish Spawner'\n" +
                    "  Rabbit: '&fRabbit Spawner'\n" +
                    "  Ravager: '&fRavager Spawner'\n" +
                    "  Salmon: '&fSalmon Spawner'\n" +
                    "  Sheep: '&fSheep Spawner'\n" +
                    "  Shulker: '&fShulker Spawner'\n" +
                    "  Silverfish: '&fSilverfish Spawner'\n" +
                    "  Skeleton: '&fSkeleton Spawner'\n" +
                    "  Skeleton_Horse: '&fSkeleton_Horse Spawner'\n" +
                    "  Slime: '&fSlime Spawner'\n" +
                    "  Snow_Golem: '&fSnow_Golem Spawner'\n" +
                    "  Spider: '&fSpider Spawner'\n" +
                    "  Squid: '&fSquid Spawner'\n" +
                    "  Stray: '&fStray Spawner'\n" +
                    "  Strider: '&fStrider Spawner'\n" +
                    "  Trader_Llama: '&fTrader_Llama Spawner'\n" +
                    "  Tropical_Fish: '&fTropical_Fish Spawner'\n" +
                    "  Turtle: '&fTurtle Spawner'\n" +
                    "  Vex: '&fVex Spawner'\n" +
                    "  Villager: '&fVillager Spawner'\n" +
                    "  Vindicator: '&fVindicator Spawner'\n" +
                    "  Wandering_Trader: '&fWandering_Trader Spawner'\n" +
                    "  Witch: '&fWitch Spawner'\n" +
                    "  Wither: '&fWither Spawner'\n" +
                    "  Wither_Skeleton: '&fWither_Skeleton Spawner'\n" +
                    "  Wolf: '&fWolf Spawner'\n" +
                    "  Zoglin: '&fZoglin Spawner'\n" +
                    "  Zombie: '&fZombie Spawner'\n" +
                    "  Zombie_Horse: '&fZombie_Horse Spawner'\n" +
                    "  Zombie_Pigman: '&fZombie_Pigman Spawner'\n" +
                    "  Zombie_Villager: '&fZombie_Villager Spawner'\n" +
                    "  Zombified_Piglin: '&fZombified_Piglin Spawner'\n" +
                    "\n" +
                    "# Read with much more attention\n" +
                    "# You're able to change spawners lore whatever you want too\n" +
                    "# but if you already have a spawner in your inventory or chest that's not placed obviously\n" +
                    "# so when you place it, won't work because have a different lore\n" +
                    "# The same thing will happen to the placed spawners, then I've to recommend you edit this in the beginning of your server\n" +
                    "Spawner_Lore:\n" +
                    "  Bat: '&6Type: &aBAT, &eOwner: &f%owner%'\n" +
                    "  Bee: '&6Type: &aBEE, &eOwner: &f%owner%'\n" +
                    "  Blaze: '&6Type: &aBLAZE, &eOwner: &f%owner%'\n" +
                    "  Cat: '&6Type: &aCAT, &eOwner: &f%owner%'\n" +
                    "  Cave_Spider: '&6Type: &aCAVE_SPIDER, &eOwner: &f%owner%'\n" +
                    "  Chicken: '&6Type: &aCHICKEN, &eOwner: &f%owner%'\n" +
                    "  Cod: '&6Type: &aCOD, &eOwner: &f%owner%'\n" +
                    "  Cow: '&6Type: &aCOW, &eOwner: &f%owner%'\n" +
                    "  Creeper: '&6Type: &aCREEPER, &eOwner: &f%owner%'\n" +
                    "  Dolphin: '&6Type: &aDOLPHIN, &eOwner: &f%owner%'\n" +
                    "  Donkey: '&6Type: &aDONKEY, &eOwner: &f%owner%'\n" +
                    "  Drowned: '&6Type: &aDROWNED, &eOwner: &f%owner%'\n" +
                    "  Elder_Guardian: '&6Type: &aELDER_GUARDIAN, &eOwner: &f%owner%'\n" +
                    "  Ender_Dragon: '&6Type: &aENDER_DRAGON, &eOwner: &f%owner%'\n" +
                    "  Enderman: '&6Type: &aENDERMAN, &eOwner: &f%owner%'\n" +
                    "  Endermite: '&6Type: &aENDERMITE, &eOwner: &f%owner%'\n" +
                    "  Evoker: '&6Type: &aEVOKER, &eOwner: &f%owner%'\n" +
                    "  Fox: '&6Type: &aFOX, &eOwner: &f%owner%'\n" +
                    "  Ghast: '&6Type: &aGHAST, &eOwner: &f%owner%'\n" +
                    "  Giant: '&6Type: &aGIANT, &eOwner: &f%owner%'\n" +
                    "  Guardian: '&6Type: &aGUARDIAN, &eOwner: &f%owner%'\n" +
                    "  Hoglin: '&6Type: &aHOGLIN, &eOwner: &f%owner%'\n" +
                    "  Horse: '&6Type: &aHORSE, &eOwner: &f%owner%'\n" +
                    "  Husk: '&6Type: &aHUSK, &eOwner: &f%owner%'\n" +
                    "  Illusioner: '&6Type: &aILLUSIONER, &eOwner: &f%owner%'\n" +
                    "  Iron_Golem: '&6Type: &aIRON_GOLEM, &eOwner: &f%owner%'\n" +
                    "  Llama: '&6Type: &aLLAMA, &eOwner: &f%owner%'\n" +
                    "  Magma_Cube: '&6Type: &aMAGMA_CUBE, &eOwner: &f%owner%'\n" +
                    "  Mooshroom: '&6Type: &aMOOSHROOM, &eOwner: &f%owner%'\n" +
                    "  Mule: '&6Type: &aMULE, &eOwner: &f%owner%'\n" +
                    "  Ocelot: '&6Type: &aOCELOT, &eOwner: &f%owner%'\n" +
                    "  Panda: '&6Type: &aPANDA, &eOwner: &f%owner%'\n" +
                    "  Parrot: '&6Type: &aPARROT, &eOwner: &f%owner%'\n" +
                    "  Phantom: '&6Type: &aPHANTOM, &eOwner: &f%owner%'\n" +
                    "  Pig: '&6Type: &aPIG, &eOwner: &f%owner%'\n" +
                    "  Piglin: '&6Type: &aPIGLIN, &eOwner: &f%owner%'\n" +
                    "  Piglin_Brute: '&6Type: &aPIGLIN_BRUTE, &eOwner: &f%owner%'\n" +
                    "  Pillager: '&6Type: &aPILLAGER, &eOwner: &f%owner%'\n" +
                    "  Polar_Bear: '&6Type: &aPOLAR_BEAR, &eOwner: &f%owner%'\n" +
                    "  Pufferfish: '&6Type: &aPUFFERFISH, &eOwner: &f%owner%'\n" +
                    "  Rabbit: '&6Type: &aRABBIT, &eOwner: &f%owner%'\n" +
                    "  Ravager: '&6Type: &aRAVAGER, &eOwner: &f%owner%'\n" +
                    "  Salmon: '&6Type: &aSALMON, &eOwner: &f%owner%'\n" +
                    "  Sheep: '&6Type: &aSHEEP, &eOwner: &f%owner%'\n" +
                    "  Shulker: '&6Type: &aSHULKER, &eOwner: &f%owner%'\n" +
                    "  Silverfish: '&6Type: &aSILVERFISH, &eOwner: &f%owner%'\n" +
                    "  Skeleton: '&6Type: &aSKELETON, &eOwner: &f%owner%'\n" +
                    "  Skeleton_Horse: '&6Type: &aSKELETON_HORSE, &eOwner: &f%owner%'\n" +
                    "  Slime: '&6Type: &aSLIME, &eOwner: &f%owner%'\n" +
                    "  Snow_Golem: '&6Type: &aSNOW_GOLEM, &eOwner: &f%owner%'\n" +
                    "  Spider: '&6Type: &aSPIDER, &eOwner: &f%owner%'\n" +
                    "  Squid: '&6Type: &aSQUID, &eOwner: &f%owner%'\n" +
                    "  Stray: '&6Type: &aSTRAY, &eOwner: &f%owner%'\n" +
                    "  Strider: '&6Type: &aSTRIDER, &eOwner: &f%owner%'\n" +
                    "  Trader_Llama: '&6Type: &aTRADER_LLAMA, &eOwner: &f%owner%'\n" +
                    "  Tropical_Fish: '&6Type: &aTROPICAL_FISH, &eOwner: &f%owner%'\n" +
                    "  Turtle: '&6Type: &aTURTLE, &eOwner: &f%owner%'\n" +
                    "  Vex: '&6Type: &aVEX, &eOwner: &f%owner%'\n" +
                    "  Villager: '&6Type: &aVILLAGER, &eOwner: &f%owner%'\n" +
                    "  Vindicator: '&6Type: &aVINDICATOR, &eOwner: &f%owner%'\n" +
                    "  Wandering_Trader: '&6Type: &aWANDERING_TRADER, &eOwner: &f%owner%'\n" +
                    "  Witch: '&6Type: &aWITCH, &eOwner: &f%owner%'\n" +
                    "  Wither: '&6Type: &aWITHER, &eOwner: &f%owner%'\n" +
                    "  Wither_Skeleton: '&6Type: &aWITHER_SKELETON, &eOwner: &f%owner%'\n" +
                    "  Wolf: '&6Type: &aWOLF, &eOwner: &f%owner%'\n" +
                    "  Zoglin: '&6Type: &aZOGLIN, &eOwner: &f%owner%'\n" +
                    "  Zombie: '&6Type: &aZOMBIE, &eOwner: &f%owner%'\n" +
                    "  Zombie_Horse: '&6Type: &aZOMBIE_HORSE, &eOwner: &f%owner%'\n" +
                    "  Zombie_Pigman: '&6Type: &aZOMBIE_PIGMAN, &eOwner: &f%owner%'\n" +
                    "  Zombie_Villager: '&6Type: &aZOMBIE_VILLAGER, &eOwner: &f%owner%'\n" +
                    "  Zombified_Piglin: '&6Type: &aZOMBIFIED_PIGLIN, &eOwner: &f%owner%'");
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static void writeEnMobsContent(Path mobsEnFile) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mobsEnFile.toFile()), StandardCharsets.UTF_8));
            writer.write("# Change mob names which have been spawned by a not original spawner (placed by a player spawner)\n" +
                    "Custom_Mob_Name:\n" +
                    "  Bat: '&fBat'\n" +
                    "  Bee: '&fBee'\n" +
                    "  Blaze: '&fBlaze'\n" +
                    "  Cat: '&fCat'\n" +
                    "  Cave_Spider: '&fCave_Spider'\n" +
                    "  Chicken: '&fChicken'\n" +
                    "  Cod: '&fCod'\n" +
                    "  Cow: '&fCow'\n" +
                    "  Creeper: '&fCreeper'\n" +
                    "  Dolphin: '&fDolphin'\n" +
                    "  Donkey: '&fDonkey'\n" +
                    "  Drowned: '&fDrowned'\n" +
                    "  Elder_Guardian: '&fElder_Guardian'\n" +
                    "  Ender_Dragon: '&fEnder_Dragon'\n" +
                    "  Enderman: '&fEnderman'\n" +
                    "  Endermite: '&fEndermite'\n" +
                    "  Evoker: '&fEvoker'\n" +
                    "  Fox: '&fFox'\n" +
                    "  Ghast: '&fGhast'\n" +
                    "  Giant: '&fGiant'\n" +
                    "  Guardian: '&fGuardian'\n" +
                    "  Hoglin: '&fHoglin'\n" +
                    "  Horse: '&fHorse'\n" +
                    "  Husk: '&fHusk'\n" +
                    "  Illusioner: '&fIllusioner'\n" +
                    "  Iron_Golem: '&fIron_Golem'\n" +
                    "  Llama: '&fLlama'\n" +
                    "  Magma_Cube: '&fMagma_Cube'\n" +
                    "  Mooshroom: '&fMooshroom'\n" +
                    "  Mule: '&fMule'\n" +
                    "  Ocelot: '&fOcelot'\n" +
                    "  Panda: '&fPanda'\n" +
                    "  Parrot: '&fParrot'\n" +
                    "  Phantom: '&fPhantom'\n" +
                    "  Pig: '&fPig'\n" +
                    "  Piglin: '&fPiglin'\n" +
                    "  Piglin_Brute: '&fPiglin_Brute'\n" +
                    "  Pillager: '&fPillager'\n" +
                    "  Polar_Bear: '&fPolar_Bear'\n" +
                    "  Pufferfish: '&fPufferfish'\n" +
                    "  Rabbit: '&fRabbit'\n" +
                    "  Ravager: '&fRavager'\n" +
                    "  Salmon: '&fSalmon'\n" +
                    "  Sheep: '&fSheep'\n" +
                    "  Shulker: '&fShulker'\n" +
                    "  Silverfish: '&fSilverfish'\n" +
                    "  Skeleton: '&fSkeleton'\n" +
                    "  Skeleton_Horse: '&fSkeleton_Horse'\n" +
                    "  Slime: '&fSlime'\n" +
                    "  Snow_Golem: '&fSnow_Golem'\n" +
                    "  Spider: '&fSpider'\n" +
                    "  Squid: '&fSquid'\n" +
                    "  Stray: '&fStray'\n" +
                    "  Strider: '&fStrider'\n" +
                    "  Trader_Llama: '&fTrader_Llama'\n" +
                    "  Tropical_Fish: '&fTropical_Fish'\n" +
                    "  Turtle: '&fTurtle'\n" +
                    "  Vex: '&fVex'\n" +
                    "  Villager: '&fVillager'\n" +
                    "  Vindicator: '&fVindicator'\n" +
                    "  Wandering_Trader: '&fWandering_Trader'\n" +
                    "  Witch: '&fWitch'\n" +
                    "  Wither: '&fWither'\n" +
                    "  Wither_Skeleton: '&fWither_Skeleton'\n" +
                    "  Wolf: '&fWolf'\n" +
                    "  Zoglin: '&fZoglin'\n" +
                    "  Zombie: '&fZombie'\n" +
                    "  Zombie_Horse: '&fZombie_Horse'\n" +
                    "  Zombie_Pigman: '&fZombie_Pigman'\n" +
                    "  Zombie_Villager: '&fZombie_Villager'\n" +
                    "  Zombified_Piglin: '&fZombified_Piglin'");
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
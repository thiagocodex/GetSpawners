package me.thiagocodex.getspawners.customconfig;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

abstract class BrazilianPortugueseContent {
    private static Writer writer;

    static void writePtbrMessagesContent(Path messagesEnFile) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(messagesEnFile.toFile()), StandardCharsets.UTF_8));
            writer.write("# Se você quiser alterar qualquer linha de qualquer arquivo desse plugin, se o primeiro caractere\n" +
                    "# for começar com '&', coloque dentro de aspas simples \"' '\" ex: '&aIniciado com sucesso!'\n" +
                    "\n" +
                    "Plugin:\n" +
                    "# Este é o prefíxo que irá aparecer sempre que o plugin enviar uma mensagem\n" +
                    "  Prefix: '&f[&eGet&3Spawners&f]'\n" +
                    "  \n" +
                    "Console_Messages:\n" +
                    "# Mensagem que aparece quando o plugin é iniciado\n" +
                    "  Plugin_Enabled: '&aIniciado com sucesso!'\n" +
                    "  \n" +
                    "# Mensagem enviada para quem recarregou o plugin, quando o mesmo é recarregado\n" +
                    "  Plugin_Reloaded: '&aRecarregado com sucesso!'\n" +
                    "  \n" +
                    "Messages:\n" +
                    "# Esta mensagem aparece quando um jogador quem possui permissões de porcentagem de chance de\n" +
                    "# dropar geradores, minera um gerador e tem a sorte de dropá-lo\n" +
                    "  Lucky: '&bBoa, Sortudo ! ! !'\n" +
                    "  \n" +
                    "# Esta mensagem aparece quando um jogador quem possui permissões de porcentagem de chance de\n" +
                    "# dropar geradores, minera um gerador, é azarado e não dropa um gerador\n" +
                    "  Unlucky: '&cMais sorte da próxima vez.'\n" +
                    "  \n" +
                    "# Esta mensagem irá ser exibida ao jogador que tentar dropar um gerador sem a ferramenta\n" +
                    "# correta permitida\n" +
                    "  Warning: '&cVocê não pode dropar geradores com esse tipo de ferramenta.'\n" +
                    "  \n" +
                    "# Quando o jogador não tiver permissão para realizar uma ação com geradores\n" +
                    "# esta é a mensagem a ser exibida\n" +
                    "  No_Permission: '&cVocê não tem permissão para fazer isso.'\n" +
                    "  \n" +
                    "# Quando o jogador não tiver permissão para dropar um tipo de gerador específico, essa é a\n" +
                    "# mensagem a ser exibida\n" +
                    "  No_Mob_Permission: '&cVocê não tem permissão para dropar um %spawner_name%.'\n" +
                    "  \n" +
                    "# Se você tentar enviar um gerador para um player que não está online no servidor, esta\n" +
                    "# mensagem será enviada\n" +
                    "  Player_Not_Found: '&cO jogador não foi encontrado online no servidor.'\n" +
                    "  \n" +
                    "# Mensagem de comando inválido\n" +
                    "  Invalid_Command: '&cComando inválido: &6Uso: /gs give <jogador> <tipo_de_gerador> <quantidade>'\n" +
                    "  \n" +
                    "# Mensagem de gerador enviado por comando com sucesso\n" +
                    "  Gave: '&aVocê deu &6%amount%&r %spawner_name% &apara &f%player%.'\n" +
                    "  \n" +
                    "# Mensagem de gerador recebido através de comando com sucesso\n" +
                    "  Received: '&aVocê recebeu &6%amount%&r %spawner_name% &ade &f%sender%.'\n" +
                    "  \n" +
                    "# Nomes dos tipos de geradores disponíveis\n" +
                    "  Mob_Names: '&eTipos de geradores:'\n" +
                    "  \n" +
                    "# Dica de comandos disponíveis\n" +
                    "  Commands_Hint: '&eComandos disponíveis:'\n" +
                    "  \n" +
                    "# A mensagem que anuncia a troca de tipo de um gerador através de um ovo\n" +
                    "  Changed_Spawner: '&fAlterado %placed_spawner% &fpara %new_spawner%.'\n" +
                    "  \n" +
                    "# Se a opção de alterar tipos de geradores estiver desativada, essa mensagem irá avisá-lo\n" +
                    "  No_Change_Enabled: '&cVocê não pode fazer isso porque a opção de alterar tipos de geradores com ovo está desativada no arquivo config.yml.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin GriefPrevention instalado, essa mensagem\n" +
                    "# irá aparecer para jogadores que tentarem mudar o tipo de gerador com um ovo, em\n" +
                    "# uma área protegida por GriefPrevention em que não tem permissão\n" +
                    "  GriefPrevention_Compat_No_Interact: '&2Área protegida por GriefPrevention; &cVocê não tem permissão para interagir com este bloco.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin Residence instalado, essa mensagem irá aparecer para jogadores que tentarem\n" +
                    "# mudar o tipo de gerador com um ovo, em uma área protegida por Residence em que não tem permissão\n" +
                    "  Residence_Compat_No_Interact: '&6Área protegida por Residence; &cVocê não tem permissão para interagir com este bloco.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin WorldGuard instalado, essa mensagem irá aparecer para jogadores que tentarem\n" +
                    "# mudar o tipo de gerador com um ovo, em uma área protegida por WorldGuard em que não tem permissão\n" +
                    "  WorldGuard_Compat_No_Interact: '&3Área protegida por WorldGuard; &c&lOpa! &7Desculpe, mas você não pode interagir com este bloco.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin WorldGuard instalado, essa mensagem irá aparecer para jogadores que tentarem\n" +
                    "# quebrar o gerador, em uma área protegida por WorldGuard em que não tem permissão\n" +
                    "  WorldGuard_Compat_No_Break: '&3WorldGuard protected area; &c&lHey! &c&lOpa! &7Desculpe, mas você não pode quebrar este bloco.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin Towny instalado, essa mensagem irá aparecer para jogadores que tentarem\n" +
                    "# mudar o tipo de gerador com um ovo, em uma área protegida por Towny em que não tem permissão\n" +
                    "  Towny_Compat_No_Interact: '&5Área protegida por Towny; &cNão é permitido interação com este bloco.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin SuperVanish instalado, essa mensagem irá aparecer para jogadores\n" +
                    "# invisíveis que tentarem mudar o tipo de gerador com um ovo, enquanto a opção\n" +
                    "# SuperVanish_Prevent_SpawnEgg_Change estiver ativada no aquivo config.yml\n" +
                    "  SuperVanish_Compat_No_Interact: '&cVocê não pode alterar geradores enquanto estiver invisível por &aSuperVanish, &cporque esta opção está ativada no arquivo config.yml.'\n" +
                    "  \n" +
                    "# Esta mensagem irá aparecer para jogadores que tentarem empilhar mais geradores do que o\n" +
                    "# limite máximo em um bloco.\n" +
                    "  Stack_Limit_Warning: '&cVocê alcançou o limite máximo ao empilhar geradores.'\n" +
                    "  \n" +
                    "# Esta mensagem irá aparecer quando um jogador emitir o comando gs debug e remover nomes de geradores bugados sem geradores\n" +
                    "  Bug_Removed_Announce: '&eBug removido, o nome %hologram_name% sem um spawner se foi.'\n" +
                    "  \n" +
                    "# Esta mensagem irá aparecer mostrando a quantidade de nomes bugados removidos\n" +
                    "  Bug_Removed_Amount: '&eRemovido &a%amount% &enomes de geradores bugados sem geradores.'\n" +
                    "  \n" +
                    "# Escolha se quer ver quantos exps um monstro gs dropa em sua morte\n" +
                    "Announce_Dropped_Exp:\n" +
                    "  Enabled: false\n" +
                    "# Mensagem a ser exibida para o jogador que matou uma criatura contendo a quantidade de exp dropado\n" +
                    "  Message: '&aMatou &6%mob_name% &a%dropped_exp% exp dropado.'");
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static void writePtbrSpawnersContent(Path spawnersEnFile) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(spawnersEnFile.toFile()), StandardCharsets.UTF_8));
            writer.write("# Leia com atenção\n" +
                    "# Se você quiser alterar qualquer linha de qualquer arquivo, se o primeiro caractere\n" +
                    "# for começar com '&', coloque dentro de aspas simples \"' '\" ex: '&fGerador de Blaze'\n" +
                    "# Você é capaz de alterar o nome dos geradores, mas 2 geradores do mesmo tipo, porém com nomes diferentes\n" +
                    "# não irão se juntar no seu inventário\n" +
                    "Spawner_Name:\n" +
                    "  Bat: Gerador de Morcego\n" +
                    "  Bee: Gerador de Abelha\n" +
                    "  Blaze: Gerador de Blaze\n" +
                    "  Cat: Gerador de Gato\n" +
                    "  Cave_Spider: Gerador de Aranha das cavernas\n" +
                    "  Chicken: Gerador de Galinha\n" +
                    "  Cod: Gerador de Bacalhau\n" +
                    "  Cow: Gerador de Vaca\n" +
                    "  Creeper: Gerador de Creeper\n" +
                    "  Dolphin: Gerador de Golfinho\n" +
                    "  Donkey: Gerador de Burro\n" +
                    "  Drowned: Gerador de Afogado\n" +
                    "  Elder_Guardian: Gerador de Guardião mestre\n" +
                    "  Ender_Dragon: Gerador de Dragão do end\n" +
                    "  Enderman: Gerador de Enderman\n" +
                    "  Endermite: Gerador de Endermite\n" +
                    "  Evoker: Gerador de Invocador\n" +
                    "  Fox: Gerador de Raposa\n" +
                    "  Ghast: Gerador de Ghast\n" +
                    "  Giant: Gerador de Giant\n" +
                    "  Guardian: Gerador de Guardião\n" +
                    "  Hoglin: Gerador de Hoglin\n" +
                    "  Horse: Gerador de Cavalo\n" +
                    "  Husk: Gerador de Zumbi-Múmia\n" +
                    "  Illusioner: Gerador de Illusioner\n" +
                    "  Iron_Golem: Gerador de Golem de Ferro\n" +
                    "  Lavagante: Gerador de Lavagante\n" +
                    "  Llama: Gerador de Lhama\n" +
                    "  Magma_Cube: Gerador de Cubo de Magma\n" +
                    "  Mooshroom: Gerador de Coguvaca\n" +
                    "  Mule: Gerador de Mula\n" +
                    "  Ocelot: Gerador de Jaguatirica\n" +
                    "  Panda: Gerador de Panda\n" +
                    "  Parrot: Gerador de Papagaio\n" +
                    "  Phantom: Gerador de Phantom\n" +
                    "  Pig: Gerador de Porco\n" +
                    "  Piglin-Zumbi: Gerador de Piglin-Zumbi\n" +
                    "  Piglin: Gerador de Piglin\n" +
                    "  Piglin_Brute: Gerador de Piglin Bárbaro\n" +
                    "  Pillager: Gerador de Saqueador\n" +
                    "  Polar_Bear: Gerador de Urso-Polar\n" +
                    "  Pufferfish: Gerador de Baiacú\n" +
                    "  Rabbit: Gerador de Coelho\n" +
                    "  Ravager: Gerador de Devastador\n" +
                    "  Salmon: Gerador de Salmão\n" +
                    "  Sheep: Gerador de Ovelha\n" +
                    "  Shulker: Gerador de Shulker\n" +
                    "  Silverfish: Gerador de Traça\n" +
                    "  Skeleton: Gerador de Esqueleto\n" +
                    "  Skeleton_Horse: Cavalo-Esqueleto\n" +
                    "  Slime: Gerador de Slime\n" +
                    "  Snow_Golem: Gerador de Snowman\n" +
                    "  Spider: Gerador de Aranha\n" +
                    "  Squid: Gerador de Lula\n" +
                    "  Stray: Gerador de Esqueleto-Errante\n" +
                    "  Trader_Llama: Gerador de Lhama do vendedor\n" +
                    "  Tropical_Fish: Gerador de Peixe-Tropical\n" +
                    "  Turtle: Gerador de Tartaruga\n" +
                    "  Vex: Gerador de Vex\n" +
                    "  Villager: Gerador de Aldeão\n" +
                    "  Vindicator: Gerador de Vingador\n" +
                    "  Wandering_Trader: Gerador de Vendedor Ambulante\n" +
                    "  Witch: Gerador de Bruxa\n" +
                    "  Wither: Gerador de Wither\n" +
                    "  Wither_Skeleton: Gerador de Esqueleto Wither\n" +
                    "  Wolf: Gerador de Lobo\n" +
                    "  Zoglin: Gerador de Zoglin\n" +
                    "  Zombie: Gerador de Zumbi\n" +
                    "  Zombie_Horse: Gerador de Cavalo-Zumbi\n" +
                    "  Zombie_Pigman: Gerador de Homem-Porco-Zumbi\n" +
                    "  Zombie_Villager: Gerador de Aldeão Zumbi\n" +
                    "\n" +
                    "# Leia com muito mais atenção\n" +
                    "# Você pode mudar o Lore dos geradores como quiser, mas se você ja tem geradores no seu inventário\n" +
                    "# ou no seu baú, que não estão colocados obviamente, trocando o lore abaixo, seus geradores não vão funcionar\n" +
                    "# pois eles tem o lore antigo, diferente desses que você mudou abaixo\n" +
                    "# Se você quiser alterar esses lores, recomendo que faça isso no início do seu servidor, enquanto ninguém tem geradores\n" +
                    "Spawner_Lore:\n" +
                    "  Bat: '&eTipo: &aMorcego, &eDono: &f%owner%'\n" +
                    "  Bee: '&eTipo: &aAbelha, &eDono: &f%owner%'\n" +
                    "  Blaze: '&eTipo: &aBlaze, &eDono: &f%owner%'\n" +
                    "  Cat: '&eTipo: &aGato, &eDono: &f%owner%'\n" +
                    "  Cave_Spider: '&eTipo: &aAranha das cavernas, &eDono: &f%owner%'\n" +
                    "  Chicken: '&eTipo: &aGalinha, &eDono: &f%owner%'\n" +
                    "  Cod: '&eTipo: &aBacalhau, &eDono: &f%owner%'\n" +
                    "  Cow: '&eTipo: &aVaca, &eDono: &f%owner%'\n" +
                    "  Creeper: '&eTipo: &aCreeper, &eDono: &f%owner%'\n" +
                    "  Dolphin: '&eTipo: &aGolfinho, &eDono: &f%owner%'\n" +
                    "  Donkey: '&eTipo: &aBurro, &eDono: &f%owner%'\n" +
                    "  Drowned: '&eTipo: &aAfogado, &eDono: &f%owner%'\n" +
                    "  Elder_Guardian: '&eTipo: &aGuardião mestre, &eDono: &f%owner%'\n" +
                    "  Ender_Dragon: '&eTipo: &aDragão do end, &eDono: &f%owner%'\n" +
                    "  Enderman: '&eTipo: &aEnderman, &eDono: &f%owner%'\n" +
                    "  Endermite: '&eTipo: &aEndermite, &eDono: &f%owner%'\n" +
                    "  Evoker: '&eTipo: &aInvocador, &eDono: &f%owner%'\n" +
                    "  Fox: '&eTipo: &aRaposa, &eDono: &f%owner%'\n" +
                    "  Ghast: '&eTipo: &aGhast, &eDono: &f%owner%'\n" +
                    "  Giant: '&eTipo: &aGiant, &eDono: &f%owner%'\n" +
                    "  Guardian: '&eTipo: &aGuardião, &eDono: &f%owner%'\n" +
                    "  Hoglin: '&eTipo: &aHoglin, &eDono: &f%owner%'\n" +
                    "  Horse: '&eTipo: &aCavalo, &eDono: &f%owner%'\n" +
                    "  Husk: '&eTipo: &aZumbi-Múmia, &eDono: &f%owner%'\n" +
                    "  Illusioner: '&eTipo: &aIllusioner, &eDono: &f%owner%'\n" +
                    "  Iron_Golem: '&eTipo: &aGolem de Ferro, &eDono: &f%owner%'\n" +
                    "  Lavagante: '&eTipo: &aLavagante, &eDono: &f%owner%'\n" +
                    "  Llama: '&eTipo: &aLhama, &eDono: &f%owner%'\n" +
                    "  Magma_Cube: '&eTipo: &aCubo de Magma, &eDono: &f%owner%'\n" +
                    "  Mooshroom: '&eTipo: &aCoguvaca, &eDono: &f%owner%'\n" +
                    "  Mule: '&eTipo: &aMula, &eDono: &f%owner%'\n" +
                    "  Ocelot: '&eTipo: &aJaguatirica, &eDono: &f%owner%'\n" +
                    "  Panda: '&eTipo: &aPanda, &eDono: &f%owner%'\n" +
                    "  Parrot: '&eTipo: &aPapagaio, &eDono: &f%owner%'\n" +
                    "  Phantom: '&eTipo: &aPhantom, &eDono: &f%owner%'\n" +
                    "  Pig: '&eTipo: &aPorco, &eDono: &f%owner%'\n" +
                    "  Piglin-Zumbi: '&eTipo: &aPiglin-Zumbi, &eDono: &f%owner%'\n" +
                    "  Piglin: '&eTipo: &aPiglin, &eDono: &f%owner%'\n" +
                    "  Piglin_Brute: '&eTipo: &aPiglin Bárbaro, &eDono: &f%owner%'\n" +
                    "  Pillager: '&eTipo: &aSaqueador, &eDono: &f%owner%'\n" +
                    "  Polar_Bear: '&eTipo: &aUrso-Polar, &eDono: &f%owner%'\n" +
                    "  Pufferfish: '&eTipo: &aBaiacú, &eDono: &f%owner%'\n" +
                    "  Rabbit: '&eTipo: &aCoelho, &eDono: &f%owner%'\n" +
                    "  Ravager: '&eTipo: &aDevastador, &eDono: &f%owner%'\n" +
                    "  Salmon: '&eTipo: &aSalmão, &eDono: &f%owner%'\n" +
                    "  Sheep: '&eTipo: &aOvelha, &eDono: &f%owner%'\n" +
                    "  Shulker: '&eTipo: &aShulker, &eDono: &f%owner%'\n" +
                    "  Silverfish: '&eTipo: &aTraça, &eDono: &f%owner%'\n" +
                    "  Skeleton: '&eTipo: &aEsqueleto, &eDono: &f%owner%'\n" +
                    "  Skeleton_Horse: '&eTipo: &aCavalo-Esqueleto, &eDono: &f%owner%'\n" +
                    "  Slime: '&eTipo: &aSlime, &eDono: &f%owner%'\n" +
                    "  Snow_Golem: '&eTipo: &aSnowman, &eDono: &f%owner%'\n" +
                    "  Spider: '&eTipo: &aAranha, &eDono: &f%owner%'\n" +
                    "  Squid: '&eTipo: &aLula, &eDono: &f%owner%'\n" +
                    "  Stray: '&eTipo: &aEsqueleto-Errante, &eDono: &f%owner%'\n" +
                    "  Trader_Llama: '&eTipo: &aLhama do vendedor, &eDono: &f%owner%'\n" +
                    "  Tropical_Fish: '&eTipo: &aPeixe-Tropical, &eDono: &f%owner%'\n" +
                    "  Turtle: '&eTipo: &aTartaruga, &eDono: &f%owner%'\n" +
                    "  Vex: '&eTipo: &aVex, &eDono: &f%owner%'\n" +
                    "  Villager: '&eTipo: &aAldeão, &eDono: &f%owner%'\n" +
                    "  Vindicator: '&eTipo: &aVingador, &eDono: &f%owner%'\n" +
                    "  Wandering_Trader: '&eTipo: &aVendedor Ambulante, &eDono: &f%owner%'\n" +
                    "  Witch: '&eTipo: &aBruxa, &eDono: &f%owner%'\n" +
                    "  Wither: '&eTipo: &aWither, &eDono: &f%owner%'\n" +
                    "  Wither_Skeleton: '&eTipo: &aEsqueleto Wither, &eDono: &f%owner%'\n" +
                    "  Wolf: '&eTipo: &aLobo, &eDono: &f%owner%'\n" +
                    "  Zoglin: '&eTipo: &aZoglin Zumbi, &eDono: &f%owner%'\n" +
                    "  Zombie: '&eTipo: &aZumbi, &eDono: &f%owner%'\n" +
                    "  Zombie_Horse: '&eTipo: &aCavalo-Zumbi, &eDono: &f%owner%'\n" +
                    "  Zombie_Pigman: '&eTipo: &aHomem-Porco-Zumbi, &eDono: &f%owner%'\n" +
                    "  Zombie_Villager: '&eTipo: &aAldeão Zumbi, &eDono: &f%owner%'");
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static void writePtbrMobsContent(Path mobsPtbrFile) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(mobsPtbrFile.toFile()), StandardCharsets.UTF_8));
            writer.write("# Mude o nome dos mobs que nascerem de um gerador não original (colocado por um jogador)\n" +
                    "Custom_Mob_Name:\n" +
                    "  Bat: Morcego\n" +
                    "  Bee: Abelha\n" +
                    "  Black_Cat: Gato Preto\n" +
                    "  Blaze: Blaze\n" +
                    "  Cat: Gato\n" +
                    "  Cave_Spider: Aranha das cavernas\n" +
                    "  Chicken: Galinha\n" +
                    "  Cod: Bacalhau\n" +
                    "  Cow: Vaca\n" +
                    "  Creeper: Creeper\n" +
                    "  Dolphin: Golfinho\n" +
                    "  Donkey: Burro\n" +
                    "  Drowned: Afogado\n" +
                    "  Elder_Guardian: Guardião mestre\n" +
                    "  Ender_Dragon: Dragão do end\n" +
                    "  Enderman: Enderman\n" +
                    "  Endermite: Endermite\n" +
                    "  Evoker: Invocador\n" +
                    "  Fox: Raposa\n" +
                    "  Ghast: Ghast\n" +
                    "  Giant: Giant\n" +
                    "  Guardian: Guardião\n" +
                    "  Hoglin: Hoglin\n" +
                    "  Horse: Cavalo\n" +
                    "  Husk: Zumbi-Múmia\n" +
                    "  Illusioner: Illusioner\n" +
                    "  Iron_Golem: Golem de Ferro\n" +
                    "  Lavagante: Lavagante\n" +
                    "  Llama: Lhama\n" +
                    "  Magma_Cube: Cubo de Magma\n" +
                    "  Mule: Mula\n" +
                    "  Mushroom_Cow: Coguvaca\n" +
                    "  Ocelot: Jaguatirica\n" +
                    "  Panda: Panda\n" +
                    "  Parrot: Papagaio\n" +
                    "  Phantom: Phantom\n" +
                    "  Pig: Porco\n" +
                    "  Pig_Zombie: Homem-Porco-Zumbi\n" +
                    "  Piglin-Zumbi: Piglin-Zumbi\n" +
                    "  Piglin: Piglin\n" +
                    "  Piglin_Brute: Piglin Bárbaro\n" +
                    "  Pillager: Saqueador\n" +
                    "  Polar_Bear: Urso-Polar\n" +
                    "  Pufferfish: Baiacú\n" +
                    "  Rabbit: Coelho\n" +
                    "  Ravager: Devastador\n" +
                    "  Red_Cat: Gato Vermelho\n" +
                    "  Salmon: Salmão\n" +
                    "  Sheep: Ovelha\n" +
                    "  Shulker: Shulker\n" +
                    "  Siamese_Cat: Gato Siamês\n" +
                    "  Silverfish: Traça\n" +
                    "  Skeleton: Esqueleto\n" +
                    "  Skeleton_Horse: Cavalo-Esqueleto\n" +
                    "  Slime: Slime\n" +
                    "  Snowman: Snowman\n" +
                    "  Spider: Aranha\n" +
                    "  Squid: Lula\n" +
                    "  Stray: Esqueleto-Errante\n" +
                    "  Trader_Llama: Lhama do vendedor\n" +
                    "  Tropical_Fish: Peixe-Tropical\n" +
                    "  Turtle: Tartaruga\n" +
                    "  Vex: Vex\n" +
                    "  Villager: Aldeão\n" +
                    "  Vindicator: Vingador\n" +
                    "  Wandering_Trader: Vendedor Ambulante\n" +
                    "  Witch: Bruxa\n" +
                    "  Wither: Wither\n" +
                    "  Wither_Skeleton: Esqueleto Wither\n" +
                    "  Wolf: Lobo\n" +
                    "  Zoglin: Zoglin\n" +
                    "  Zombie: Zumbi\n" +
                    "  Zombie_Horse: Cavalo-Zumbi\n" +
                    "  Zombie_Villager: Aldeão Zumbi");
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
package me.nikl.cookieclicker;

import me.nikl.cookieclicker.buildings.Buildings;
import me.nikl.cookieclicker.upgrades.UpgradeType;
import me.nikl.gamebox.game.Game;
import me.nikl.gamebox.game.GameLanguage;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CCLanguage extends GameLanguage {

    public List<String> GAME_OVEN_LORE, GAME_BUILDING_LORE;

    public String GAME_TITLE, GAME_TITLE_IDLE, GAME_CLOSED, GAME_COOKIE_NAME, GAME_OVEN_NAME, GAME_BUILDING_NAME;
    public String GAME_PAYED, GAME_NOT_ENOUGH_MONEY, GAME_IDLE, GAME_LUCKY_COOKIE_NAME, GAME_WON_MONEY, GAME_WON_TOKEN;

    public String GAME_OVEN_LORE_BOOST_TITLE, GAME_OVEN_LORE_BOOST_CLICKING, GAME_OVEN_LORE_BOOST_PRODUCTION;

    public HashMap<Buildings, String> buildingName;
    public HashMap<Buildings, List<String>> buildingLore;

    public String GAME_UPGRADE_NAME;
    public List<String> GAME_UPGRADE_LORE;
    public HashMap<Integer, String> upgradeName;
    public HashMap<Integer, List<String>> upgradeDescriptionLore;
    public HashMap<UpgradeType, List<String>> upgradeLore;

    public CCLanguage(Game game) {
        super(game);
    }

    @Override
    public void loadMessages() {
        PREFIX = getString("prefix");
        PLAIN_PREFIX = ChatColor.stripColor(PREFIX);

        NAME = getString("name");
        PLAIN_NAME = ChatColor.stripColor(NAME);

        getGameMessages();
        // saving building language in hash maps
        loadBuildingLanguage();
        // saving upgrade language in hash maps
        loadUpgradeLanguage();
    }

    /**
     * Custom loading of the upgrade language, since
     * the lists are saved in maps with their upgrade type.
     */
    private void loadUpgradeLanguage() {
        this.GAME_UPGRADE_LORE = getStringList("upgrades.upgradeLore");
        this.GAME_UPGRADE_NAME = getString("upgrades.upgradeDisplayName");

        upgradeName = new HashMap<>();
        upgradeLore = new HashMap<>();
        upgradeDescriptionLore = new HashMap<>();

        UpgradeType upgradeType;
        List<String> lore = new ArrayList<>();

        // load middle lore
        if (language.isConfigurationSection("upgrades.types")) {
            for (String key : language.getConfigurationSection("upgrades.types").getKeys(false)) {
                try {
                    upgradeType = UpgradeType.valueOf(key.toUpperCase());
                } catch (IllegalArgumentException exception) {
                    // ignore
                    continue;
                }
                lore.clear();
                lore.addAll(GAME_UPGRADE_LORE);
                lore.addAll(getStringList("upgrades.types." + key));
                upgradeLore.put(upgradeType, new ArrayList<>(lore));
            }
        }
        // check for missing middle lore
        for (String key : defaultLanguage.getConfigurationSection("upgrades.types").getKeys(false)) {
            try {
                upgradeType = UpgradeType.valueOf(key.toUpperCase());
            } catch (IllegalArgumentException exception) {
                // ignore
                continue;
            }
            if (upgradeLore.containsKey(upgradeType)) continue;
            lore.clear();
            lore.addAll(GAME_UPGRADE_LORE);
            lore.addAll(getStringList("upgrades.types." + key));
            upgradeLore.put(upgradeType, new ArrayList<>(lore));
        }


        int id;
        // load description and names
        if (language.isConfigurationSection("upgrades.upgrades")) {
            for (String key : language.getConfigurationSection("upgrades.upgrades").getKeys(false)) {
                try {
                    id = Integer.valueOf(key);
                } catch (NumberFormatException exception) {
                    // ignore
                    continue;
                }
                upgradeDescriptionLore.put(id, getStringList("upgrades.upgrades." + key + ".description"));
                upgradeName.put(id, getString("upgrades.upgrades." + key + ".name"));
            }
        }
        // check for missing description and names
        if (language.isConfigurationSection("upgrades.upgrades")) {
            for (String key : defaultLanguage.getConfigurationSection("upgrades.upgrades").getKeys(false)) {
                try {
                    id = Integer.valueOf(key);
                } catch (NumberFormatException exception) {
                    // ignore
                    continue;
                }
                if (upgradeDescriptionLore.containsKey(id) && upgradeName.containsKey(id)) continue;
                upgradeDescriptionLore.put(id, getStringList("upgrades.upgrades." + key + ".description"));
                upgradeName.put(id, getString("upgrades.upgrades." + key + ".name"));
            }
        }
    }

    private void loadBuildingLanguage() {
        this.GAME_BUILDING_LORE = getStringList("buildings.buildingLore");
        this.GAME_BUILDING_NAME = getString("buildings.buildingDisplayName");

        buildingName = new HashMap<>();
        buildingLore = new HashMap<>();

        Buildings building;
        List<String> lore = new ArrayList<>();

        if (language.isConfigurationSection("buildings")) {
            for (String key : language.getConfigurationSection("buildings").getKeys(false)) {
                try {
                    building = Buildings.valueOf(key.toUpperCase());
                } catch (IllegalArgumentException exception) {
                    // ignore
                    continue;
                }
                lore.clear();
                lore.addAll(GAME_BUILDING_LORE);
                buildingName.put(building, getString("buildings." + key + ".name"));
                lore.addAll(getStringList("buildings." + key + ".description"));
                buildingLore.put(building, new ArrayList<>(lore));
            }
        }

        // check for missing language in default file
        for (String key : defaultLanguage.getConfigurationSection("buildings").getKeys(false)) {
            try {
                building = Buildings.valueOf(key.toUpperCase());
            } catch (IllegalArgumentException exception) {
                // ignore
                continue;
            }
            if (buildingLore.containsKey(building) && buildingName.containsKey(building)) continue;
            lore.clear();
            lore.addAll(GAME_BUILDING_LORE);
            buildingName.put(building, getString("buildings." + key + ".name"));
            lore.addAll(getStringList("buildings." + key + ".description"));
            buildingLore.put(building, new ArrayList<>(lore));
        }
    }

    private void getGameMessages() {
        this.GAME_TITLE = getString("game.inventoryTitles.gameTitle");
        this.GAME_TITLE_IDLE = getString("game.inventoryTitles.gameTitleIdle");
        this.GAME_IDLE = getString("game.idle");

        this.GAME_OVEN_LORE_BOOST_TITLE = getString("game.boosts.ovenBoostTitle");
        this.GAME_OVEN_LORE_BOOST_CLICKING = getString("game.boosts.ovenClickingBoost");
        this.GAME_OVEN_LORE_BOOST_PRODUCTION = getString("game.boosts.ovenProductionBoost");

        this.GAME_COOKIE_NAME = getString("game.cookieName");
        this.GAME_LUCKY_COOKIE_NAME = getString("game.goldenCookieName");

        this.GAME_OVEN_NAME = getString("game.ovenName");
        this.GAME_OVEN_LORE = getStringList("game.ovenLore");

        this.GAME_PAYED = getString("game.econ.payed");
        this.GAME_NOT_ENOUGH_MONEY = getString("game.econ.notEnoughMoney");

        this.GAME_WON_MONEY = getString("game.wonMoney");
        this.GAME_WON_TOKEN = getString("game.wonToken");

        this.GAME_CLOSED = getString("game.closedGame");

        this.GAME_HELP = getStringList("gameHelp");
    }
}

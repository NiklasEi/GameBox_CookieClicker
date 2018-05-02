package me.nikl.cookieclicker.upgrades.farm;

import me.nikl.cookieclicker.CCGame;
import me.nikl.cookieclicker.CookieClicker;
import me.nikl.cookieclicker.buildings.Buildings;
import me.nikl.cookieclicker.upgrades.Upgrade;
import me.nikl.cookieclicker.upgrades.UpgradeType;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

/**
 * @author Niklas Eicker
 */
public class CookieTrees extends Upgrade {

    public CookieTrees(CookieClicker game) {
        super(game, 12);
        this.cost = 550000;
        productionsRequirements.put(Buildings.FARM, 25);

        icon = new MaterialData(Material.DIRT).toItemStack();
        icon.setAmount(1);

        loadLanguage(UpgradeType.CLASSIC, Buildings.FARM);
    }

    @Override
    public void onActivation(CCGame game) {
        game.getBuilding(Buildings.FARM).multiply(game.getGameUuid(), 2);
        game.getBuilding(Buildings.FARM).visualize(game);
    }


}

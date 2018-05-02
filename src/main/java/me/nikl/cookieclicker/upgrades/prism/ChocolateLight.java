package me.nikl.cookieclicker.upgrades.prism;

import me.nikl.cookieclicker.CCGame;
import me.nikl.cookieclicker.CookieClicker;
import me.nikl.cookieclicker.buildings.Buildings;
import me.nikl.cookieclicker.upgrades.Upgrade;
import me.nikl.cookieclicker.upgrades.UpgradeType;

/**
 * @author Niklas Eicker
 */
public class ChocolateLight extends Upgrade {

    public ChocolateLight(CookieClicker game) {
        super(game, 177);
        this.cost = 1050000000000000000.;
        productionsRequirements.put(Buildings.PRISM, 25);

        // for the standard upgrade type the building icon is used
        loadLanguage(UpgradeType.CLASSIC, Buildings.PRISM);
    }

    @Override
    public void onActivation(CCGame game) {
        game.getBuilding(Buildings.PRISM).multiply(game.getGameUuid(), 2);
        game.getBuilding(Buildings.PRISM).visualize(game);
    }
}

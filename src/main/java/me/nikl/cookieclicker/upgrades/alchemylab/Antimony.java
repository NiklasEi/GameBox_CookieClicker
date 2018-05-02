package me.nikl.cookieclicker.upgrades.alchemylab;

import me.nikl.cookieclicker.CCGame;
import me.nikl.cookieclicker.CookieClicker;
import me.nikl.cookieclicker.buildings.Buildings;
import me.nikl.cookieclicker.upgrades.Upgrade;
import me.nikl.cookieclicker.upgrades.UpgradeType;

/**
 * @author Niklas Eicker
 */
public class Antimony extends Upgrade {
    public Antimony(CookieClicker game) {
        super(game, 22);
        this.cost = 750000000000.;
        productionsRequirements.put(Buildings.ALCHEMY_LAB, 1);

        loadLanguage(UpgradeType.CLASSIC, Buildings.ALCHEMY_LAB);
    }

    @Override
    public void onActivation(CCGame game) {
        game.getBuilding(Buildings.ALCHEMY_LAB).multiply(game.getGameUuid(), 2);
        game.getBuilding(Buildings.ALCHEMY_LAB).visualize(game);
    }
}

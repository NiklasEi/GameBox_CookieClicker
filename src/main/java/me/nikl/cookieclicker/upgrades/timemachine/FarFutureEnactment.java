package me.nikl.cookieclicker.upgrades.timemachine;

import me.nikl.cookieclicker.CCGame;
import me.nikl.cookieclicker.CookieClicker;
import me.nikl.cookieclicker.buildings.Buildings;
import me.nikl.cookieclicker.upgrades.Upgrade;
import me.nikl.cookieclicker.upgrades.UpgradeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * @author Niklas Eicker
 */
public class FarFutureEnactment extends Upgrade {

    public FarFutureEnactment(CookieClicker game) {
        super(game, 199);
        this.cost = 7000000000000000000000.;
        productionsRequirements.put(Buildings.TIME_MACHINE, 150);

        icon = new ItemStack(Material.CLOCK, 1);
        icon.setAmount(1);

        loadLanguage(UpgradeType.CLASSIC, Buildings.TIME_MACHINE);
    }

    @Override
    public void onActivation(CCGame game) {
        game.getBuilding(Buildings.TIME_MACHINE).multiply(game.getGameUuid(), 2);
        game.getBuilding(Buildings.TIME_MACHINE).visualize(game);
    }
}

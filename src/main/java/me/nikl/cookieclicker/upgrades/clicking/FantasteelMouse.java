package me.nikl.cookieclicker.upgrades.clicking;

import me.nikl.cookieclicker.CCGame;
import me.nikl.cookieclicker.CookieClicker;
import me.nikl.cookieclicker.upgrades.Upgrade;
import me.nikl.cookieclicker.upgrades.UpgradeType;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

/**
 * @author Niklas Eicker
 */
public class FantasteelMouse extends Upgrade {

    public FantasteelMouse(CookieClicker game) {
        super(game, 366);
        this.cost = 5000000000000000000.;
        setClickCookieReq(100000000000000000.);

        icon = new MaterialData(Material.ARROW).toItemStack();
        icon.setAmount(1);

        gain = "+1%";
        loadLanguage(UpgradeType.GAIN_MOUSE_PER_CPS);
    }

    @Override
    public void onActivation(CCGame game) {
        game.cookiesPerClickPerCPS += 0.01;
    }


}

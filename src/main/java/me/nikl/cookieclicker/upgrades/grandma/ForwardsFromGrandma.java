package me.nikl.cookieclicker.upgrades.grandma;

import me.nikl.cookieclicker.CCGame;
import me.nikl.cookieclicker.CookieClicker;
import me.nikl.cookieclicker.buildings.Buildings;
import me.nikl.cookieclicker.upgrades.Upgrade;
import me.nikl.cookieclicker.upgrades.UpgradeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * @author Niklas Eicker
 */
public class ForwardsFromGrandma extends Upgrade {

    public ForwardsFromGrandma(CookieClicker game) {
        super(game, 7);
        this.cost = 1000;
        productionsRequirements.put(Buildings.GRANDMA, 1);

        icon = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        icon.setAmount(1);
        SkullMeta skullMeta = (SkullMeta) icon.getItemMeta();
        skullMeta.setOwner("MHF_Villager");
        icon.setItemMeta(skullMeta);

        loadLanguage(UpgradeType.CLASSIC, Buildings.GRANDMA);
    }

    @Override
    public void onActivation(CCGame game) {
        game.getBuilding(Buildings.GRANDMA).multiply(game.getGameUuid(), 2);
        game.getBuilding(Buildings.GRANDMA).visualize(game);
    }


}

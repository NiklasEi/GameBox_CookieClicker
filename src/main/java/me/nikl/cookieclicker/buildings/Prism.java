package me.nikl.cookieclicker.buildings;

import me.nikl.cookieclicker.CookieClicker;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author Niklas Eicker
 */
public class Prism extends Building {

    public Prism(CookieClicker plugin, int slot, Buildings building) {
        super(plugin, slot, building);

        icon = new ItemStack(Material.EMERALD, 1);
        icon.setAmount(1);
        ItemMeta meta = icon.getItemMeta();
        meta.setDisplayName(lang.GAME_BUILDING_NAME.replace("%name%", name));
        icon.setItemMeta(meta);

        this.productionPerSecond = 2900000000.;
        this.baseCost = 2100000000000000.;
    }
}

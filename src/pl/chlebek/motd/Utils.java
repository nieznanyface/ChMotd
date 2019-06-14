package pl.chlebek.motd;

import org.bukkit.ChatColor;

public class Utils {

    public static String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

}

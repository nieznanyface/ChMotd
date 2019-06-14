package pl.chlebek.motd;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.chlebek.motd.commands.MotdCommand;
import pl.chlebek.motd.events.PingListener;

public class Main extends JavaPlugin {

    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        getCommand("motd").setExecutor(new MotdCommand());
        Bukkit.getPluginManager().registerEvents(new PingListener(), this);

        if(!new File(getDataFolder(), "config.yml").exists())
            saveDefaultConfig();
    }

}
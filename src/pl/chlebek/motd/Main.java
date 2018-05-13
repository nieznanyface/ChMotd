package pl.chlebek.motd;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	public String color(String str){
		return ChatColor.translateAlternateColorCodes('&', str);
	}

	@Override
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
		if(!new File(getDataFolder(), "config.yml").exists()) saveDefaultConfig();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("motd")){
			if(sender.hasPermission("chmotd.reload")){
				reloadConfig();
				sender.sendMessage("§aReload successfull.");
			} else {
				sender.sendMessage("§a§lChMotd §r§aby §lchlebek");
			}
		}
		return false;
	}

	@EventHandler
	public void onPing(ServerListPingEvent e){
		e.setMaxPlayers(getConfig().getInt("maxPlayers"));
		e.setMotd(color(getConfig().getStringList("motds").get(ThreadLocalRandom.current().nextInt(0, getConfig().getStringList("motds").size()))));
	}

}

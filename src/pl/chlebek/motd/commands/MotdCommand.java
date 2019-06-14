package pl.chlebek.motd.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.chlebek.motd.Main;

public class MotdCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("chmotd.reload")){
            Main.getInstance().reloadConfig();
            sender.sendMessage("§aReload successful.");
        } else sender.sendMessage("§a§lChMotd §r§aby §lchlebek");

        return false;
    }

}

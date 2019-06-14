package pl.chlebek.motd.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import pl.chlebek.motd.Main;
import pl.chlebek.motd.Utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e){
        List<String> motds = Main.getInstance().getConfig().getStringList("motds");
        e.setMaxPlayers(Main.getInstance().getConfig().getInt("maxPlayers"));
        e.setMotd(Utils.color(motds.get(ThreadLocalRandom.current().nextInt(0,motds.size()))));
    }

}

package dk.shadow.listener;

import dk.shadow.Bungee;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import utils.Chat;


import java.util.UUID;

public final class PingListener implements Listener {
    Bungee bungee;
    public PingListener(Bungee plugin) {
        this.bungee = plugin;
    }

    @EventHandler
    public void onPing(final ProxyPingEvent e) {

        final ServerPing response = e.getResponse();

        if (response == null) {
            return;
        }

        final ServerPing.Players players = response.getPlayers();


        System.out.println("Players: " + players);
        players.setSample(new ServerPing.PlayerInfo[] {
                new ServerPing.PlayerInfo(Chat.colored("&c&LCUTE&F&LKAT        "), UUID.randomUUID()),
                new ServerPing.PlayerInfo(Chat.colored("&fStarten på Danmark værste server!"), UUID.randomUUID()),
                new ServerPing.PlayerInfo(Chat.colored(" "), UUID.randomUUID()),
                new ServerPing.PlayerInfo(Chat.colored("&c&LINFOR&f&LMATION: "), UUID.randomUUID()),
                new ServerPing.PlayerInfo(Chat.colored("&8● &7Online ➥ &f" + players.getOnline()), UUID.randomUUID())
        });
        //response.setDescription("and a whole ton of randomt text here"); Det er motd på serveren

    }

}

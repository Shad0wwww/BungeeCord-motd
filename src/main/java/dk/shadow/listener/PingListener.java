package dk.shadow.listener;

import dk.shadow.Bungee;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import dk.shadow.utils.Chat;


import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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


        //System.out.println("Players: " + players);
        players.setSample(new ServerPing.PlayerInfo[] {
                playerinfo("&c&LCUTE&F&LKAT        "),
                playerinfo("&fStarten på Danmarks værste server!"),
                playerinfo(" "),
                playerinfo("&c&LINFOR&f&LMATION: "),
                playerinfo("&8● &7Online ➥ &f" + players.getOnline())

        });
        //response.setDescription("and a whole ton of randomt text here"); Det er motd på serveren


    }
    private static ServerPing.PlayerInfo playerinfo(String message) {
        return new ServerPing.PlayerInfo(Chat.colored(message), UUID.randomUUID());


    }


}

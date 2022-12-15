package dk.shadow.listener;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerDownHandler implements Listener {
    private String servername = "hub";

    @EventHandler
    public void OnKick(ServerKickEvent e) {
        ServerInfo kickedFrom = e.getKickedFrom();

        //Finder hvilken server spilleren er blevet kicked fra
        if(e.getPlayer().getServer().getInfo().getName().equals(servername)) {
            //Laver en component til at gemme dataen, om hvorfor spilleren er blevet kicked
            BaseComponent[] reason = e.getKickReasonComponent();

            //Canceller evented
            e.setCancelled(true);
            //Laver en ny besked
            e.getPlayer().sendMessage(new ComponentBuilder("Failed to connect to the server you requested.").color(ChatColor.RED).create());
            e.getPlayer().sendMessage(reason);
        } else {
            //Hvis den er ikke er sat
            if (kickedFrom != null) {

                if (!kickedFrom.getName().equals(servername)) {
                    BaseComponent[] reason = e.getKickReasonComponent();
                    ServerInfo lobby = ProxyServer.getInstance().getServerInfo(servername);

                    e.setCancelled(true);
                    e.setCancelServer(lobby);

                    e.getPlayer().sendMessage(new ComponentBuilder("You were kicked from the server you were on, so we sent you to the lobby.").color(ChatColor.RED).create());
                    e.getPlayer().sendMessage(reason);
                }
            }
        }
    }
}

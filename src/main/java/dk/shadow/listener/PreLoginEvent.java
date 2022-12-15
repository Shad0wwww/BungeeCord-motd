package dk.shadow.listener;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dk.shadow.Bungee;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

public class PreLoginEvent implements Listener {
    Bungee bungee;

    public PreLoginEvent(Bungee bungee) {
        this.bungee = bungee;
    }


    @EventHandler
    public void onPrelogin(ServerConnectEvent event) throws IOException {
        String ip = event.getPlayer().getSocketAddress().toString();
        System.out.println("ip " + ip);
        String apiURL = String.format("http://ip-api.com/json/%s", ip);
        URL url = new URL(apiURL);
        BufferedReader stream = new BufferedReader(new InputStreamReader(url.openStream()));
        String websiteResponse = stream.readLine();

        // EDITED: Close the stream xD
        stream.close();

        JsonObject resp = new Gson().fromJson(websiteResponse, JsonObject.class);


        if (resp.get("country").getAsString() == "Denmark") {

            event.getPlayer().disconnect(new TextComponent("Du skal bo i Danmark."));
        }


    }
}

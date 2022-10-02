package dk.shadow;

import dk.shadow.listener.PingListener;
import net.md_5.bungee.api.plugin.Plugin;

public class Bungee extends Plugin {
    private Bungee bungee;


    @Override
    public void onEnable() {
        // You should not put an enable message in your plugin.
        // BungeeCord already does so
        getLogger().info("Yay! It loads!");
        this.getProxy().getPluginManager().registerListener(this, new PingListener(this.bungee));


    }
}

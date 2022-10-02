package dk.shadow;

import dk.shadow.listener.PingListener;
import net.md_5.bungee.api.plugin.Plugin;

public class Bungee extends Plugin {
    private Bungee bungee;


    @Override
    public void onEnable() {
        bungee = this;
        getLogger().info("Yay! It loads!");
        this.getProxy().getPluginManager().registerListener(this, new PingListener(this.bungee));


    }
}

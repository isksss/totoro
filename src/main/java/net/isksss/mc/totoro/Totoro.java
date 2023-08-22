package net.isksss.mc.totoro;

import net.isksss.mc.totoro.event.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Totoro extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Enable Totoro Plugin.");
        this.getServer().getPluginManager().registerEvents(new PlayerListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

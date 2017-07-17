package xyz.mglolenstine.jointhunder;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by LifEorDeatH on 17.7.2017.
 */
public class Main extends JavaPlugin {
    public Permission perms;
    public void onEnable(){
        this.getServer().getPluginManager().registerEvents(new MyListener(), this);
        setupPermissions();
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
}

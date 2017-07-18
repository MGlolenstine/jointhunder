package xyz.mglolenstine.jointhunder;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by LifEorDeatH on 17.7.2017.
 */
public class Main extends JavaPlugin {
    Permission perms = null;
    public void onEnable(){
        saveConfig();
        this.getServer().getPluginManager().registerEvents(new MyListener(), this);
        if(setupPermissions()){
            System.out.println("Vault has been initialized successfully!");
        }
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
}

package xyz.mglolenstine.jointhunder;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;

/**
 * Created by LifEorDeatH on 17.7.2017.
 */
public class MyListener implements Listener{
    Main plugin = Main.getPlugin(Main.class);
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Permission permission = plugin.perms;
        Player p = e.getPlayer();
        String group = permission.getPrimaryGroup(p);
        if(group.equalsIgnoreCase("god")){
            e.getPlayer().getWorld().strikeLightningEffect(e.getPlayer().getLocation());
        }
        //e.getPlayer().sendMessage("Your group is "+group);
    }
}

package xyz.mglolenstine.jointhunder;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by LifEorDeatH on 17.7.2017.
 */
public class MyListener implements Listener{
    private Main plugin = Main.getPlugin(Main.class);
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Permission permission = plugin.perms;
        Player p = e.getPlayer();
        String group = "";
        try {
            group = permission.getPrimaryGroup(p);
        }catch(UnsupportedOperationException e1){
            System.out.println("[WARNING] Player "+p.getName()+" is currently not in a group!");
        }
        //Set<String> ss = plugin.getConfig().getConfigurationSection("groups").getKeys(false);
        ArrayList<String> ss = (ArrayList<String>) plugin.getConfig().getStringList("groups");
        for(String groupn : ss){
            if (group.equalsIgnoreCase(groupn)) {
                e.getPlayer().getWorld().strikeLightningEffect(e.getPlayer().getLocation());
                return;
            }
        }
        ss = (ArrayList<String>) plugin.getConfig().getStringList("players");
        for(String name : ss){
            if (e.getPlayer().getName().equals(name)) {
                e.getPlayer().getWorld().strikeLightningEffect(e.getPlayer().getLocation());
            }
        }
        //e.getPlayer().sendMessage("Your group is "+group);
    }
}

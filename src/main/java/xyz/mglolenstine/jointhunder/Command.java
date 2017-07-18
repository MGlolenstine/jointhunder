package xyz.mglolenstine.jointhunder;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

/**
 * Created by notyours on 18.7.2017.
 */
public class Command implements CommandExecutor {
    private Main plugin = Main.getPlugin(Main.class);

    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        if(strings.length == 0){
            help(commandSender);
        }else if(strings.length == 3){
            if(strings[0].equalsIgnoreCase("add")){
                if(strings[1].equalsIgnoreCase("player")){
                    ArrayList<String> ss = (ArrayList<String>) plugin.getConfig().getStringList("players");
                    ss.add(strings[2]);
                    plugin.getConfig().set("players", ss);
                    plugin.saveConfig();
                }else if(strings[1].equalsIgnoreCase("group")){
                    ArrayList<String> ss = (ArrayList<String>) plugin.getConfig().getStringList("groups");
                    ss.add(strings[2]);
                    plugin.getConfig().set("groups", ss);
                    plugin.saveConfig();
                }else{
                    return false;
                }
            }else if(strings[0].equalsIgnoreCase("remove")){
                if(strings[1].equalsIgnoreCase("player")){
                    ArrayList<String> ss = (ArrayList<String>) plugin.getConfig().getStringList("players");
                    ss.remove(strings[2]);
                    plugin.getConfig().set("players", ss);
                    plugin.saveConfig();
                }else if(strings[1].equalsIgnoreCase("group")){
                    ArrayList<String> ss = (ArrayList<String>) plugin.getConfig().getStringList("groups");
                    ss.remove(strings[2]);
                    plugin.getConfig().set("groups", ss);
                    plugin.saveConfig();
                }else{
                    return false;
                }
            }
        }else if(strings.length == 1){
            ArrayList<String> ss = (ArrayList<String>) plugin.getConfig().getStringList("groups");
            if(ss.size() == 0){
                commandSender.sendMessage("No groups set yet");
            }else {
                commandSender.sendMessage("Listing all of the groups:");
                for(String s1 : ss){
                    commandSender.sendMessage(s1);
                }
            }
            ss = (ArrayList<String>) plugin.getConfig().getStringList("players");
            if(ss.size() == 0){
                commandSender.sendMessage("No players set yet");
            }else {
                commandSender.sendMessage("Listing all of the players:");
                for(String s1 : ss){
                    commandSender.sendMessage(s1);
                }
            }
        }
        return false;
    }
    private void help(CommandSender s){
        s.sendMessage("List of JoinThunder commands");
        s.sendMessage("/jt: show this help message");
        s.sendMessage("/jt add player <player>: add a player");
        s.sendMessage("/jt add group <group>: add a group");
        s.sendMessage("/jt remove player <player>: remove a player");
        s.sendMessage("/jt remove group <group>: remove a group");
        s.sendMessage("/jt list: list all players and groups getting stroken");
    }
}

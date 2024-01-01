package com.antho.anthoplugmanager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class AnthoPlugManager extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("disable").setExecutor(this);
        getCommand("enable").setExecutor(this);
        getCommand("rs").setExecutor(this);
        getCommand("disable").setTabCompleter(new enabledisabletab());
        getCommand("enable").setTabCompleter(new enabledisabletab());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String cmdname, String[] arg) {
        if(cmdname.equals("rs")){Player p = (Player) commandSender; p.performCommand("reload confirm");}
        if(cmdname.equals("disable")){Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin(arg[0]));commandSender.sendMessage("disabled plugin");}
        if(cmdname.equals("enable")){
            Bukkit.getServer().getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(arg[0]));
            commandSender.sendMessage("enabled plugin");
        }



        return true;
    }
}

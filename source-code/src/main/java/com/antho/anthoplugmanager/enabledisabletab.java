package com.antho.anthoplugmanager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class enabledisabletab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> c = new ArrayList<>();
        Plugin[] p = Bukkit.getServer().getPluginManager().getPlugins();
        if(s.equals("disable")){
            for (Plugin plugin : p) {
                if (plugin.isEnabled()) {
                    c.add(plugin.getName());
                }
            }
        }
        if(s.equals("enable")){
            for (Plugin plugin : p) {
                if (!(plugin.isEnabled())) {
                    c.add(plugin.getName());
                }
            }

        }


        return c;
    }
}

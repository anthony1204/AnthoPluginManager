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
        for (int i = 0; i < p.length; i++) {
            c.add(p[i].getName());
        }

        return c;
    }
}

package com.thorindev.commands;

import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thorindev.Lucius;

import net.md_5.bungee.api.ChatColor;

public class HelloCommand implements CommandExecutor {
	
	Lucius plugin;
	 
	public HelloCommand(Lucius instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You need to be a player to use the command, " + ChatColor.GREEN + "/" + cmd.getName().toString());
			return true;
		} else {
			Player player = (Player) sender;
			String CommandDisabledMessage = plugin.getConfig().getString("messages.commanddisabled");
			String CDMColor = ChatColor.translateAlternateColorCodes('&', CommandDisabledMessage);
			Boolean isHelloEnabled = plugin.getConfig().getBoolean("commands.hello");
			
			if(isHelloEnabled) {
				Random random = new Random();
				String a;
				String[] HelloMessages = {
					"&aWhy hello there, PLAYER",
					"&aHi PLAYER",
					"&aPeekabo PLAYER",
					"&aBonjour PLAYER",
					"&aHallo PLAYER"
				};
				int i = random.nextInt(HelloMessages.length);
				a = HelloMessages[i];
				a = ChatColor.translateAlternateColorCodes('&', a.replaceAll("PLAYER", player.getDisplayName()));
				player.sendMessage(a);
			
				return true;
			}
			else {
				player.sendMessage(CDMColor);
			}
		}
		return false;
	}
}
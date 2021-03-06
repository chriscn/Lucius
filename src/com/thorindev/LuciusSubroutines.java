package com.thorindev;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class LuciusSubroutines {
	
	Lucius plugin;
	 
	public LuciusSubroutines(Lucius instance) {
		plugin = instance;
	}
	
	public void doStuff() {
		registerConfig();
		saveConfig();
		registerPermissions();
	}

	public void registerConfig() {
		FileConfiguration config = plugin.config;
		getLogger().info("Succesfully accessed the config subroutine.");
		config.options().header(
				"Lucius \n" +
				"All commands can be disbaled and enabled, as well as changing other things such as the firework timeout \n" +
				"You can also change messages for command disabled and no permission, with full formatting support"
		);
		config.addDefault("commands.colorchat", true);
		config.addDefault("commands.fakesay", true);
		config.addDefault("commands.fw", false);
		config.addDefault("commands.fwtimeout",  15);
		config.addDefault("commands.hello", true);
		config.addDefault("commands.vanish", true);
		config.addDefault("messages.noperm", "&cYou do not have permission to use this command");
		config.addDefault("messages.commanddisabled", "&cCommand Disabled");
		config.options().copyDefaults(true);
		config.options().copyHeader(true);
		saveConfig();	
	}

	private void saveConfig() {
		plugin.saveConfig();
	}
	
	public Permission luciusCommandFakesay = new Permission("lucius.fakesay");
	public Permission luciusCommandFakesayOverride = new Permission("lucius.fakesay.override");
	public Permission luciusCommandFakesayExempt = new Permission("lucius.fakesay.exempt");
	public Permission luciusCommandChatColor = new Permission("lucius.chatcolor"); 
	public Permission luciusCommandFW = new Permission("lucius.fw");
	public Permission luciusCommandFWNoTimeout = new Permission("lucius.fw.notimeout");
	public Permission luciusCommandVanish = new Permission("lucius.vanish");
	public Permission luciusCommandLucius = new Permission("lucius.lucius");
		
	Permission[] listOfPerms = {
			luciusCommandFakesay,
			luciusCommandFakesayExempt,
			luciusCommandFakesayOverride,
			luciusCommandChatColor,
			luciusCommandFW,
			luciusCommandFWNoTimeout,
			luciusCommandVanish,
			luciusCommandLucius
	};
	
	public void registerPermissions() {
		getLogger().info("Succesfully accessed the permissions subroutine.");
		PluginManager pm = Bukkit.getServer().getPluginManager();
		for(int i = 0; i < listOfPerms.length; i++) {
			pm.addPermission(listOfPerms[i]);
		}
	}
	
	public Logger getLogger() {
		return plugin.getLogger();
	}
}

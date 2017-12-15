package com.dcman58.TutorialPlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	@Override 
	public void onEnable(){
		System.out.println("Test Plugin Enabled!");
		
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
		getCommand("freeze").setExecutor(new FreezeCommand());
	}
	
	@Override
	public void onDisable(){
		System.out.println("Test Plugin Disabled!");
	}
	
	@EventHandler
	public void onThrow(PlayerEggThrowEvent e){
		Player p = e.getPlayer();
		p.sendMessage("You Are the Father!");
		e.setHatching(true);
		
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
		
		return false;
	}
	
	
}

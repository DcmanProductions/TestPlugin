package com.dcman58.TutorialPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeCommand implements CommandExecutor {

	public boolean shouldFreezeMovement =false;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("freeze")&&!shouldFreezeMovement){
			shouldFreezeMovement = true;
		}else if(cmd.getName().equalsIgnoreCase("freeze")&&shouldFreezeMovement){
			shouldFreezeMovement = false;
		}
		return false;
	}
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player player = e.getPlayer();
		
		if(!player.hasPermission("testplugin.allowmove")){
			e.setCancelled(shouldFreezeMovement);			
		}
		
	}

}

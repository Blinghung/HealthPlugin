package com.fsscripts.bentzilla;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;
public class HPlayerChatListener extends PlayerListener {
	protected Health plugin;

	public HPlayerChatListener(Health plugin) {
		this.plugin = plugin;
	}

	public void onPlayerChat(PlayerChatEvent event) {
		Player player = event.getPlayer();
		for (Player P : plugin.getServer().getOnlinePlayers()) {

			if (Health.enabled(P)) {
				ChatColor c;
				if (player.getHealth() <= 10){
					c = ChatColor.RED;
				} else {
					c = ChatColor.GREEN;
				}
				P.sendMessage("<" + player.getDisplayName() + "> [" + c + player.getHealth() + ChatColor.WHITE + "/" + ChatColor.GREEN + "20" +  ChatColor.WHITE + "]: "  + event.getMessage().toString());
			} else {
				P.sendMessage("<" + player.getDisplayName() + "> " + event.getMessage().toString());
			}	
		}
		System.out.println("<" + player.getDisplayName() + "> " + event.getMessage().toString());
		event.setCancelled(true);
	}
}
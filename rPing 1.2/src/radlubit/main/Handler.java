/*
[rPing v1.2]
Плагин пингов в чате Minecraft!
Разработал - Широков Ярослав (Radlubit) 21.10.2020 г.

Это класс обработчика событий.

(C) Radlubit 2020
*/
package radlubit.main;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import com.google.common.collect.Lists;

public class Handler implements Listener {
	
	private rPing plugin;
	
	public Handler(rPing plugin) {
		
		this.plugin = plugin;
		
	}

	@EventHandler 
	public void onPing(AsyncPlayerChatEvent event) {
		
		Player sender = event.getPlayer();
		
		if(plugin.getConfig().getBoolean("use-permission") == true && sender.hasPermission("rping.use") == false) {
			
			return;
			
		} else {
			
			ArrayList<? extends Player> onlinePlayers = Lists.newArrayList(Bukkit.getOnlinePlayers());
			String message = event.getMessage();
			
			for(int i=0; i<=(onlinePlayers.size()-1); i++) {
				
				Player pinged  = onlinePlayers.get(i);
				
				if(message.contains(pinged.getName())) {
					
					if(plugin.getConfig().getBoolean("colors.use") == true) {
						
						String color = plugin.getConfig().getString("colors.color");
						message = message.replace(pinged.getName(), "\u00a7"+color+pinged.getName()+"\u00a7r");
						
					}
					
					if(plugin.getConfig().getBoolean("enable-sound") == true) {
						
						pinged.playSound(pinged.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1,1);
						
					}
					
				}
				
			}
			
			event.setMessage(message);
			
		}
		
	}
	
}
// Конец кода
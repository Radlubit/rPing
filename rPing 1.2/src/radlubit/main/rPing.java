/*
[rPing v1.2]
Плагин пингов в чате Minecraft!
Разработал - Широков Ярослав (Radlubit) 21.10.2020 г.

Это главный класс плагина.

(C) Radlubit 2020
*/
package radlubit.main;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class rPing extends JavaPlugin {
	
	public final String PREFIX = "§6rPing §8>> ";
	public String LANGUAGE = getConfig().getString("language");
	public final String VERSION = "1.2";
	
	public void onEnable() {
		
		File config = new File(getDataFolder() + File.separator + "config.yml");
		
		if(!config.exists()) {
			
			getLogger().warning("Configuration file isn't found! Creating new one...");
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
			
		}
		PluginCommand command = getCommand("rping");
		if(command!=null) command.setExecutor(new Commands(this));
		Bukkit.getPluginManager().registerEvents(new Handler(this), this);
		getLogger().info("rPing by Radlubit enabled! Hello World!");
		
	}
	
	public void onDisable() {
		
		getLogger().info("rPing by Radlubit disabled! Bye Bye!");
		
	}
}
// Конец кода
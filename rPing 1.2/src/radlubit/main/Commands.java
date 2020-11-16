/*
[rPing v1.2]
������ ������ � ���� Minecraft!
���������� - ������� ������� (Radlubit) 21.10.2020 �.

��� ����� ����������� ������ �������.

(C) Radlubit 2020
*/
package radlubit.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{
	
	private rPing plugin;
	
	public Commands(rPing plugin) {
		
		this.plugin = plugin;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("rping")) {
			
			if(plugin.getConfig().getBoolean("use-permission") && sender instanceof Player) {
				
				if(!((Player) sender).hasPermission("rping.use")) {
				
					switch(plugin.LANGUAGE) {
				
						case "en":
							sender.sendMessage(plugin.PREFIX+"�cSorry, but you are not allowed to use this command!");
							break;
						case "ru":
							sender.sendMessage(plugin.PREFIX+"�c��������, �� � ��� ������������ ���� ��� ������������� ���� �������!");
							break;
						default:
							sender.sendMessage(plugin.PREFIX+"�cSorry, but you are not allowed to use this command!");
						
					}
					
				}
				
				return true;
				
			}
			
			if(args.length == 0 || args[0].equals("version")) {
				
				if(!(sender instanceof Player)) {
					
					switch(plugin.LANGUAGE) {
						
						case "en":
							plugin.getLogger().info("This server uses the rPing plugin version "+plugin.VERSION);
							break;
						case "ru":
							plugin.getLogger().info("���� ������ ���������� ������ rPing ������ "+plugin.VERSION);
							break;
						default:
							plugin.getLogger().info("This server uses the rPing plugin version "+plugin.VERSION);
						
					}
					
					return true;
					
				}
				
				switch(plugin.LANGUAGE) {
					
					case "en":
						sender.sendMessage(plugin.PREFIX+"�7This server uses the �6rPing �7plugin version �6"+plugin.VERSION);
						break;
					case "ru":
						sender.sendMessage(plugin.PREFIX+"�7���� ������ ���������� ������ �6rPing �7������ �6"+plugin.VERSION);
						break;
					default:
						sender.sendMessage(plugin.PREFIX+"�7This server uses the �6rPing �7plugin version �6"+plugin.VERSION);
				
				}
				
				return true;
				
			}
					
			if(args[0].equals("reload")) {
				
				if(sender instanceof Player) {
					
					if(!sender.hasPermission("rping.admin")) {
						
						switch(plugin.LANGUAGE) {
						
							case "en":
								sender.sendMessage(plugin.PREFIX+"�cSorry, but you are not allowed to use this command!");
								break;
							case "ru":
								sender.sendMessage(plugin.PREFIX+"�c��������, �� � ��� ������������ ���� ��� ������������� ���� �������!");
								break;
							default:
								sender.sendMessage(plugin.PREFIX+"�cSorry, but you are not allowed to use this command!");
						
						}
						
					}
					
					return true;
						
				}
				
				plugin.reloadConfig();
				plugin.LANGUAGE = plugin.getConfig().getString("language");
				
				if(!(sender instanceof Player)) {
					
					switch(plugin.LANGUAGE) {
						
						case "en":
							plugin.getLogger().info("Plugin config reloaded successfully!");
							break;
						case "ru":
							plugin.getLogger().info("������������ ������� ������� �������������!");
							break;
						default:
							plugin.getLogger().info("Plugin config reloaded successfully!");
					
					}
					
					return true;
					
				}
				
				switch(plugin.LANGUAGE) {
					
					case "en":
						sender.sendMessage(plugin.PREFIX+"�7Plugin config reloaded successfully!");
						break;
					case "ru":
						sender.sendMessage(plugin.PREFIX+"�7������������ ������� ������� �������������!");
						break;
					default:
						sender.sendMessage(plugin.PREFIX+"�7Plugin config reloaded successfully!");
					
				}
				
				return true;
				
			}
					
		}
		
		return false;
		
	}

}
// ����� ����
package team.fi.slfa;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
//import org.bukkit.plugin.Plugin;
//import org.bukkit.plugin.java.JavaPlugin;

//import team.fi.slfa.Main;

public class Cmd implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length==0) {
				p.sendMessage("§6===== §aSLPA §6=====\n§6/slpa particle");
			}
			else if(args.length > 0) {
				if(args[0].equalsIgnoreCase("particle")) {
					if(sender.hasPermission("slpa.admin") == false) {
						sender.sendMessage("§cYou do not have permissions for do that.");
						return false;
					}
					Player player = (Player)sender;
					//Player player = sender.getPlayer();
					World playerworld = player.getLocation().getWorld();
					Location playerlocation = player.getLocation();
					playerworld.playEffect(playerlocation, Effect.MOBSPAWNER_FLAMES, 20);
					int times = 0;
					for(int i = 0; i < 5; i++) {
						times += 20;
						Bukkit.getScheduler ().runTaskLater (Main.getpl(), () -> playerworld.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 20), times);
					}
					
					
				}
			}
		}
		return true;
	}
}

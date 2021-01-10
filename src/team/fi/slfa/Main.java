package team.fi.slfa;
// 혹시 읽는 분 계시면 패키지 명 무시해주세요.. 귀찮아서 For 넣었다가 Per로 바꿈..
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	ConsoleCommandSender console = Bukkit.getConsoleSender();
	@Override
	public void onEnable() {
		console.sendMessage( ChatColor.AQUA + "SLPA Enabling");
	}
	@Override
	public void onDisable() {
		console.sendMessage( ChatColor.AQUA + "SLPA Disabling");
	}
	@EventHandler()
	public void onPlayerDeath(PlayerDeathEvent event) {
		
		Player player = event.getEntity();
		player.getLocation().getWorld().playEffect(player.getLocation(), Effect.SMOKE, 1);
		if(player.hasPermission("slpa.bypass") == false) {
			Bukkit.getBanList(Type.NAME).addBan(player.getName(), "§c§lYou died!", null, "console");
			player.kickPlayer("§c§lYou have Died!");
			//Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick "+player.getName());
		}
		event.setDeathMessage("§cPlayer §l"+player.getName()+"§c is Died!");
	//Bukkit.getBanlist(Type.NAME).addBan(player.getName(), "You died!", expires, "console");
	}
}

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
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	ConsoleCommandSender console = Bukkit.getConsoleSender();
	private static Main instance;
	public static Main getInstance() {
		return instance;
	}
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		//Bukkit.broadcastMessage("§c§lTEST");
		Player player = e.getEntity();
		if(player instanceof Player) {
			Player player1 = e.getEntity().getPlayer();
			e.setDeathMessage("§cPlayer §l"+player1.getName()+"§c Died!");
			player1.getLocation().getWorld().playEffect(player1.getLocation(), Effect.MOBSPAWNER_FLAMES, 20);
			if(player1.hasPermission("slpa.bypass") == false) {
				Bukkit.getBanList(Type.NAME).addBan(player1.getName(), "§c§lYou died!", null, "console");
				player1.kickPlayer("§c§lYou have Died!");
			}
		}
		else {
			return;
		}

	}
	@EventHandler
	public void join(PlayerJoinEvent e) {
		String plnick = e.getPlayer().getName();
		e.setJoinMessage(ChatColor.GREEN+"[+]"+plnick+ChatColor.GOLD+"님이 접속하셨습니다!");
	}
	@EventHandler
	public void leave(PlayerQuitEvent e) {
		String plnick = e.getPlayer().getName();
		e.setQuitMessage(ChatColor.GREEN+"["+ChatColor.DARK_RED+"-"+ChatColor.GREEN+"]"+plnick+ChatColor.GOLD+"님이 퇴장하셨습니다!");	
	}
	@Override
	public void onEnable() {
		console.sendMessage( ChatColor.AQUA + "SLPA Enabling");
		Main.instance = this;
		getServer().getPluginManager().registerEvents(this, this);
	}
	@Override
	public void onDisable() {
		console.sendMessage( ChatColor.AQUA + "SLPA Disabling");
	}
}

package team.fi.slfa;
//import team.fi.slfa.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Joinquithandler implements Listener {
	private FileConfiguration config = Main.getpl().getConfig();
	@EventHandler
	public void join(PlayerJoinEvent e) {
		String plnick = e.getPlayer().getName();
		String joinmsg = config.getString("joinmessage");
		String joinprefix = config.getString("joinprefix");
		e.setJoinMessage(joinprefix+plnick+ChatColor.GOLD+joinmsg);
	}
	@EventHandler
	public void leave(PlayerQuitEvent e) {
		String plnick = e.getPlayer().getName();
		String quitmsg = config.getString("quitmessage");
		String quitprefix = config.getString("quitprefix");
		e.setQuitMessage(quitprefix+plnick+ChatColor.GOLD+quitmsg);	
	}
}

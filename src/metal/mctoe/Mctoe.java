package metal.mctoe;

import metal.mctoe.game.GameList;
import metal.mctoe.game.RequestList;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.logging.Logger;

/**
 * Manages Starting up and shutting down the plugin, pre-processing commands,
 * and initializing server-wide data structures (eg game list, request list)
 * 
 * @author Nic
 *
 */
public class Mctoe extends JavaPlugin {

	/** Name of this plugin that shows up on log */
	private static String pluginName = "mctoe";
	
	/** Prefix name for all plugin commands */
	private static String pluginPrefix = "ttt";
	
	/** A chopped down tree trunk */
	private Logger log = Logger.getLogger("Minecraft");
	
	private static Server mainServer;
	
	
	@Override
	public void onDisable() {
		conMsg("Shutting down");
	}

	@Override
	public void onEnable() {
		conMsg("Booting up");
		mainServer = this.getServer();
		
		RequestList.construct();
		GameList.construct();
	}
	
	
	/**
	 *  Logs a plugin message
	 *  
	 *  @param msg Console message string
	 */
	public void conMsg(String msg){
		log.info("[" + pluginName + "] " + msg);
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		//this.getServer().broadcastMessage(label);
		String prefix;
		String suffix;
		
		/* Get prefix, should be ttt */
		prefix = command.getLabel().substring(0, 3);
		
		/* Get suffix, should be everything after - */
		suffix = command.getLabel().substring(4);
		
		/* Check to make sure plugin prefix name is called correctly */
		if (!prefix.equalsIgnoreCase(this.pluginPrefix)){
			return false;
		}
		
		
		return false;
	}
	
	
	/*
	 * Returns the server associated with this plugin
	 */
	public static Server getMainServer(){
		return mainServer;
	}

}

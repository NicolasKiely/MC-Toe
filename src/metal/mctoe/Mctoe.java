package metal.mctoe;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.logging.Logger;

/**
 * Manages Starting up and shutting down the plugin
 * 
 * @author Nic
 *
 */
public class Mctoe extends JavaPlugin {

	/** Name of this plugin that shows up on log */
	private String pluginName = "mctoe";
	
	/** Prefix name for all plugin commands */
	private String pluginPrefix = "ttt";
	
	/** A chopped down tree trunk */
	private Logger log = Logger.getLogger("Minecraft");
	
	
	@Override
	public void onDisable() {
		conMsg("Shutting down");
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		conMsg("Booting up");
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

}

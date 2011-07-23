package metal.mctoe;

import org.bukkit.plugin.java.JavaPlugin;
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

}

package metal.mctoe;

import metal.mctoe.command.CommandList;
import metal.mctoe.game.GameList;
import metal.mctoe.game.RequestList;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
		
		CommandList.construct();
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
		String error = "";
		String prefix;
		String suffix;
		Player senderPlayer;
		
		/* Get prefix, should be ttt */
		prefix = command.getLabel().substring(0, 3);
		
		/* Get suffix, should be everything after - */
		suffix = command.getLabel().substring(4);
		
		/* Check to make sure plugin name space is used */
		if (!prefix.equalsIgnoreCase(pluginPrefix)){
			return false;
		}
		
		
		/* Make sure it's a player we're dealing with here */
		if (sender instanceof Player) {
			senderPlayer = (Player) sender;
		} else {
			sender.sendMessage("Error, only players can play");
			return false;
		}
		
		/* Find a matching command */
		metal.mctoe.command.Command cmd = CommandList.get().getCommand(suffix);
		if (cmd == null) {
			error = "Error: command not found";
		}
		
		
		/* Check parameters */
		if (error.equals("")){
			if (cmd.getArgs() != args.length){
				error = "Invalid number of arguments";
			}
		}
		
		/* Check if executable */
		if (error.equals("")){
			String cmdError = "";
			if (cmd.canExecute(senderPlayer, args, cmdError)){
				/* Executable, so go run command */
				cmd.execute(senderPlayer, args);
			} else {
				/* Check error from function */
				if (cmdError.equals("")){
					/* Unknown error */
					error = "Error in attempting to execute command";
				} else {
					/* Pass error from command */
					error = cmdError;
				}
			}
		}
		
		
		if (error.equals("")){
			/* Success */
			return true;
		} else {
			/* An error occurred */
			senderPlayer.sendMessage(error);
			return false;
		}
	}
	
	
	/*
	 * Returns the server associated with this plugin
	 */
	public static Server getMainServer(){
		return mainServer;
	}

}

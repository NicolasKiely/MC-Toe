package metal.mctoe.command;

import java.util.*;

/**
 * Manages the list of different commands
 * 
 * @author Nic
 *
 */
public class CommandList {
	/** Server command-list */
	private static CommandList commandList;
	
	/** List of commands */
	private List<Command> commands;

	/** Initializes the server's list of commands */
	public static void construct(){
		commandList = new CommandList();
	}
	
	
	/**
	 * Gets the server command list
	 * @return list of commands
	 */
	public static CommandList get(){
		return commandList;
	}
	
	
	/**
	 * Add all of the commands to the list
	 */
	private CommandList(){
		commands = new ArrayList<Command>();
		
		commands.add(new Cmdask());
	}
}

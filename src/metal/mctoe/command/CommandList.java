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
		this.commands = new ArrayList<Command>();
		
		this.commands.add(new Cmdask());
	}
	
	
	/**
	 * Looks up a command
	 * @param cmdName name of command
	 * @return Command if it exists, null if none found
	 */
	public Command getCommand(String cmdName){
		for (int i = 0; i < this.commands.size(); i++){
			/* Look at current indexed command */
			Command thisCmd = this.commands.get(i);
			if (thisCmd.getName().equalsIgnoreCase(cmdName)){
				/* Found command */
				return thisCmd;
			}
		}
		
		/* Found no command */
		return null;
	}
}

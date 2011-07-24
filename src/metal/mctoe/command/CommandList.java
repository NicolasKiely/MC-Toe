package metal.mctoe.command;

/**
 * Manages the list of different commands
 * 
 * @author Nic
 *
 */
public class CommandList {
	/** List of commands */
	private Command[] commands;
	
	/** Number of commands */
	private int numCmds = 8;

	
	/**
	 * Add each command to the list
	 */
	public CommandList(){
		commands = new Command[numCmds];
	}
}

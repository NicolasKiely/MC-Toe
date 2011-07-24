package metal.mctoe.command;

import org.bukkit.entity.Player;

/**
 * Represents a command
 * 
 * @author Nic
 *
 */
public interface Command {
	/**
	 * Returns the name of the command
	 * @return Name of command
	 */
	String getName();
	
	/**
	 * Returns the minimum number of args the command must take
	 * @return Number of args
	 */
	int getArgs();
	
	/** 
	 * Returns whether or not the command can execute
	 * @param sender Executor of command
	 * @param args Arguments for command
	 * @param errorMsg Error message if failure
	 * @return True if executable, false otherwise
	 */
	boolean canExecute(Player sender, String[] args, String errorMsg);
	
	/**
	 * Executes command
	 * @param sender Executor of command
	 * @param args Arguments for command
	 */
	void execute(Player sender, String[] args);
	
}

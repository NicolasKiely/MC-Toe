package metal.mctoe.command;

import org.bukkit.entity.Player;

/**
 * Represents a command
 * 
 * @author Nic
 *
 */
public interface Command {
	/** Returns the name of the command
	 * @return Name of command
	 */
	String getName();
	
	/** Returns the minimum number of args the command must take
	 * @return Number of args
	 */
	int getArgs();
	
	/** Returns whether or not the command can execute */
	boolean canExecute(Player sender, String[] args);
	
	/** Executes command */
	void execute(Player sender, String[] args);
	
}

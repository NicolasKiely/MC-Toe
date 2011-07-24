package metal.mctoe.command;

import org.bukkit.entity.Player;

/**
 * Represents a command
 * In hindsight, it probably was an absurdly stupid idea to choose the same name
 * as bukkit's Command class.
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
	 * @return Empty if executable, error message otherwise
	 */
	String canExecute(Player sender, String[] args);
	
	/**
	 * Executes command
	 * @param sender Executor of command
	 * @param args Arguments for command
	 */
	void execute(Player sender, String[] args);
	
}

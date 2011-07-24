package metal.mctoe.command;

import org.bukkit.entity.Player;

/**
 * Command to send request to another player to play a game
 * 
 * @author Nic
 *
 */
public class Cmdask implements Command {

	@Override
	public String getName() {
		return "ask";
	}

	@Override
	public int getArgs() {
		return 1;
	}

	@Override
	public boolean canExecute(Player sender, String[] args) {
		
		
		
		return false;
	}

	@Override
	public void execute(Player sender, String[] args) {
		// TODO Auto-generated method stub

	}

}

package metal.mctoe.command;

import metal.mctoe.Mctoe;

import metal.mctoe.*;
import metal.mctoe.game.RequestList;

import org.bukkit.Server;
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
	public boolean canExecute(Player sender, String[] args, String errorMsg) {
		/* Can only play if:
		 * argument (other player) is another active player,
		 * other player does not have any pending requests from anybody
		 * sender is not currently playing a game
		 * other player is not currently playing a game
		 */
		
		/* First get other player */
		String other = args[0];
		Server server = Mctoe.getMainServer();
		Player otherPlayer = server.getPlayer(other);
		
		/* Make sure player exists on server */
		if (otherPlayer == null){
			errorMsg = "Error, could not find player + '" +other+ "'";
			return false;
		}
		
		/* Check for pending requests targeting other player */
		if (RequestList.get().playerHasPendingRequest(otherPlayer)){
			errorMsg = "Error, player has pending request";
			return false;
		}
		
		
		
		/* Nothing wrong found with sending request */
		errorMsg = "";
		return true;
	}

	@Override
	public void execute(Player sender, String[] args) {
		// TODO Auto-generated method stub

	}

}

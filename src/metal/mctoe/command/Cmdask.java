package metal.mctoe.command;

import metal.mctoe.Mctoe;

import metal.mctoe.game.GameList;
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
	public String canExecute(Player sender, String[] args) {
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
			return "Error, could not find player + '" +other+ "'";
		}
		
		/* Check for pending requests targeting other player */
		if (RequestList.get().getPendingRequest(otherPlayer) != null){
			return "Error, player already has pending request";
		}
		
		/* Check to see if players are already in a game */
		if (GameList.get().isPlaying(sender)){
			return "You are already playing a game, silly :P";
		}
		
		/* Check to see if other player is already in a game */
		if (GameList.get().isPlaying(otherPlayer)){
			return "Other player is playing a game now";
		}
		
		/* Nothing wrong found with sending request */
		return "";
	}

	
	/**
	 * Create a request for a game
	 * @param sender Player responsible for request
	 * @param args Name of target player
	 */
	@Override
	public void execute(Player sender, String[] args) {
		Player target = Mctoe.getMainServer().getPlayer(args[0]);
		
		/* Send request */
		RequestList.get().addRequest(sender, target);
		
		/* Notify both players */
		Mctoe.msgPlayer(sender, "Sent request to " +target.getDisplayName());
		Mctoe.msgPlayer(target, "Received request from "+ sender.getDisplayName());
		
	}

}

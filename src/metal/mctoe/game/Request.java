package metal.mctoe.game;

import org.bukkit.entity.Player;

/**
 * A request from a sender to play a game with a target player
 * 
 * @author Nic
 *
 */
public class Request {
	
	/** Sender of request */
	private Player sender;
	
	/** Target of request */
	private Player target;
	
	
	/** Creates a request link between two players
	 * @param newSender The sender of the request
	 * @param newTarget The target of the request
	 */
	public Request(Player newSender, Player newTarget){
		this.sender = newSender;
		this.target = newTarget;
	}
	
	/**
	 * Gets sender
	 * @return Sender of request
	 */
	public Player getSender(){
		return this.sender;
	}
	
	
	/**
	 * Gets target 
	 * @return Target of request
	 */
	public Player getTarget(){
		return this.target;
	}
	
}

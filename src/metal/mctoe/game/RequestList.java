package metal.mctoe.game;

import java.util.*;

import org.bukkit.entity.Player;

/**
 * Manages the list of requests
 * 
 * @author Nic
 *
 */
public class RequestList {
	/** Server list of requests */
	private static RequestList requestList;
	
	
	/** List of requests */
	private List<Request> requests;
	
	
	/**
	 * Initializes the array of requests
	 */
	private RequestList(){
		this.requests = new ArrayList<Request>();
	}
	
	
	/**
	 * Constructs a new request list for the server
	 */
	public static void construct(){
		requestList = new RequestList();
	}
	
	
	/**
	 * Returns request list
	 * @return
	 */
	public static RequestList get(){
		return requestList;
	}
	
	
	/**
	 * Checks to see if a player is a target of a request
	 * @param player Name of target player
	 * @return True if the target player has a pending request, false otherwise
	 */
	public boolean playerHasPendingRequest(Player player){
		
		for (int i = 0; i < this.requests.size(); i++){
			if (this.requests.get(i).getTarget().getUniqueId() == player.getUniqueId()){
				/* Found request for target */
				return true;
			}
		}
		
		/* No request found */
		return false;
	}
	
}

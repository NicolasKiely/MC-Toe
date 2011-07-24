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
	 * Returns the request for a target, if it exists
	 * @param player Name of target player
	 * @return Request object if the target player has a pending request, null otherwise
	 */
	public Request getPendingRequest(Player target){
		
		for (int i = 0; i < this.requests.size(); i++){
			if (this.requests.get(i).getTarget().getUniqueId() == target.getUniqueId()){
				/* Found request for target */
				return this.requests.get(i);
			}
		}
		
		/* No request found */
		return null;
	}
	
	
	/**
	 * Adds a new request to the list
	 * @param sender Sender of request
	 * @param target Target of request
	 */
	public void addRequest(Player sender, Player target){
		Request newRequest = new Request(sender, target);
		this.requests.add(newRequest);
	}
	
	
	/**
	 * Removes a request for a target
	 * @param target Player to remove from requests
	 */
	public void removeRequest(Player target){
		for (int i = 0; i < this.requests.size(); i++){
			/* Get current request */
			Request thisRequest = this.requests.get(i);
			
			if (thisRequest.getTarget().getUniqueId() == target.getUniqueId()){
				/* Found request, remove it */
				this.requests.remove(i);
			}
		}
	}
}

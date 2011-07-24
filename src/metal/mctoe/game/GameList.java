package metal.mctoe.game;

import java.util.*;

import org.bukkit.entity.Player;

/**
 * List of games running on the server
 * 
 * @author Nic
 *
 */
public class GameList {
	/** Server list of running games */
	private static GameList gameList;
	
	/** List of games */
	private List<Game> games;
	
	
	/**
	 * Constructs a new game list for the server
	 */
	public static void construct(){
		gameList = new GameList();
	}
	
	
	/**
	 * Gets the server's list of games
	 * @return list of games
	 */
	public static GameList get() {
		return gameList;
	}
	
	
	/**
	 * Constructs a new list of games
	 */
	private GameList(){
		this.games = new ArrayList<Game>();
	}
	
	
	/**
	 * Checks to see if player is in a game
	 * @param player The player
	 * @return true if in game, false otherwise
	 */
	public boolean isPlaying(Player player){
		for (int i = 0; i < this.games.size(); i++){
			if (this.games.get(i).isPlaying(player)){
				return true;
			}
		}
		
		return false;
	}
	
}

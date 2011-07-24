package metal.mctoe.game;

import org.bukkit.entity.Player;
import java.util.Random;

/**
 * Instance of a game
 * 
 * @author Nic
 *
 */
public class Game {
	/** First player in the game */
	private Player player1;
	
	/** Second player in the game */
	private Player player2;
	
	
	/** 
	 * Starts up a new game. Order is chosen randomly
	 * @param newPlayerA A player
	 * @param newPlayerB Another player
	 */
	public Game(Player newPlayerA, Player newPlayerB){
		
		/* Randomize who goes first */
		Random rnd = new Random();
		if (rnd.nextInt()%2 == 0){
			this.player1 = newPlayerA;
			this.player2 = newPlayerB;
		} else {
			this.player1 = newPlayerB;
			this.player2 = newPlayerA;
		}
		
	}
	
	
	/**
	 * Returns true if player is in a game
	 * @param player Player tested to see if in game
	 * @return Whether or not player is in game
	 */
	public boolean isPlaying(Player player){
		if (player.getUniqueId() == this.player1.getUniqueId() ||
				player.getUniqueId() == this.player2.getUniqueId()) {
			
			return true;
		} else {
			return false;
		}
	}
}

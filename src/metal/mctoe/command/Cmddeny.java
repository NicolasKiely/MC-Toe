package metal.mctoe.command;

import metal.mctoe.Mctoe;
import metal.mctoe.game.Request;
import metal.mctoe.game.RequestList;

import org.bukkit.entity.Player;

public class Cmddeny implements Command {

	@Override
	public String getName() {
		return "deny";
	}

	@Override
	public int getArgs() {
		return 0;
	}

	/**
	 * Can only execute if sender has a pending request
	 * @param sender Sender of command
	 * @param args Ignored
	 */
	@Override
	public String canExecute(Player sender, String[] args) {
		Request request = RequestList.get().getPendingRequest(sender);
		if (request != null){
			/* Pending request exists */
			return "";
		} else {
			return "No pending requests to deny";
		}
		
	}
	

	/**
	 * Remove sender's pending request from list
	 * @param sender Target of the request
	 * @param args Ignored
	 */
	@Override
	public void execute(Player sender, String[] args) {
		/* Get sender of request */
		Player original = RequestList.get().getPendingRequest(sender).getTarget();
		
		RequestList.get().removeRequest(sender);
		
		Mctoe.msgPlayer(sender, "Denied request to " +original.getDisplayName());
		Mctoe.msgPlayer(original, sender.getDisplayName()+ " denied request to play");
	}

}

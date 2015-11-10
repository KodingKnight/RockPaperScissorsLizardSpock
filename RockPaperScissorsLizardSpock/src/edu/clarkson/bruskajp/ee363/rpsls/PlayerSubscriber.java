package edu.clarkson.bruskajp.ee363.rpsls;

import edu.clarkson.bruskajp.ee363.rpsls.player.Player;

public interface PlayerSubscriber {
	
	/**
	   * This is the subscriber for the publisher subscriber pattern.
	   * This was implemented so that the game play and what classes do with the game information can be separated
	 */
	
	public void handlePlayer(Player player);
	
}

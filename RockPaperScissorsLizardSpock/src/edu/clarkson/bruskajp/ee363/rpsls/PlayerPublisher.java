package edu.clarkson.bruskajp.ee363.rpsls;

import edu.clarkson.bruskajp.ee363.rpsls.player.Player;

public interface PlayerPublisher {
	
	/**
	   * This is the publisher for the publisher subscriber pattern.
	   * This was implemented so that the game play and what classes do with the game information can be separated
	 */
	
	public void notifySubscribers(Player player);
	
	public void register(PlayerSubscriber playerSubscriber);
	
}

package edu.clarkson.bruskajp.ee363.rpsls;

import edu.clarkson.bruskajp.ee363.rpsls.player.Player;

public interface PlayerPublisher {
	
	public void notifySubscribers(Player player);
	
	public void register(PlayerSubscriber playerSubscriber);
	
}

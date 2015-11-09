package edu.clarkson.bruskajp.ee363.rpsls;

import edu.clarkson.bruskajp.ee363.rpsls.player.Player;

public interface PlayerSubscriber {
	
	public void handlePlayer(Player player);
	
}

package edu.clarkson.bruskajp.ee363.rpsls.display;

import edu.clarkson.bruskajp.ee363.rpsls.PlayerSubscriber;
import edu.clarkson.bruskajp.ee363.rpsls.player.Player;

public class PlayerSubscriberDecorator implements PlayerSubscriber, Displayer<Player>{
	
	private Displayer<Player> nestedDisplayer;
	
	public PlayerSubscriberDecorator(Displayer<Player> nestedDisplayer) {
		this.nestedDisplayer = nestedDisplayer;
	}
	
	@Override
	public void handlePlayer(Player player) {	
		this.display(player);
	}

	@Override
	public void display(Player player) {
		nestedDisplayer.display(player);
	}

}

package edu.clarkson.bruskajp.ee363.rpsls.display;

import edu.clarkson.bruskajp.ee363.rpsls.PlayerSubscriber;
import edu.clarkson.bruskajp.ee363.rpsls.player.Player;

public class PlayerSubscriberDisplayerDecorator implements PlayerSubscriber, Displayer<Player>{
	
	private Displayer<Player> nestedDisplayer;
	
	/**
	   * Constructs the PlayerScubscriberDecorator
	   * @param Displayer A type of display module.
	*/ 
	public PlayerSubscriberDisplayerDecorator(Displayer<Player> nestedDisplayer) {
		this.nestedDisplayer = nestedDisplayer;
	}
	
	/**
	   * Handles when a player is added by displaying it.
	   * @param player A player to be displayed.
	*/ 
	@Override
	public void handlePlayer(Player player) {	
		this.display(player);
	}

	
	/**
	   * Passes the displaying of the object to the nested displayer 
	   * @param player A player to be displayed. 
	*/ 
	@Override
	public void display(Player player) {
		nestedDisplayer.display(player);
	}

}

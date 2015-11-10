package edu.clarkson.bruskajp.ee363.rpsls.player;

import java.util.HashSet;
import java.util.Iterator;

public class MainPlayerSource implements PlayerSource{

	private HashSet<Player> players;
	private Iterator<Player> iterator;
	
	public MainPlayerSource(HashSet<Player> players) {
		this.players = players;
		iterator = players.iterator();
	}
	
	/**
	   * Returns the next player and notifies the subscribers 
	   * @return The next player of the set.
	*/ 
	@Override
	public Player getNextPlayer() {
		Player player = (Player) iterator.next();
		return player;
	}

}

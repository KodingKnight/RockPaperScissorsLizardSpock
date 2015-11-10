package edu.clarkson.bruskajp.ee363.rpsls.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import edu.clarkson.bruskajp.ee363.rpsls.PlayerPublisher;
import edu.clarkson.bruskajp.ee363.rpsls.PlayerSubscriber;

public class PlayerPublisherSourceDecorator implements PlayerSource, PlayerPublisher{
	
	/**
	   * This is a decorator for the Source so that any type of player source can be dynamically implemented
	 */
	
	private PlayerSource wrappedPlayerSource;
	private List<PlayerSubscriber> subscribers = new ArrayList<>();
	
	/**
	   * Creates the PlayerPublishedDecorator.
	   * @param wrappedPlayerSource A wrapped PlayerSource.
	*/ 
	public PlayerPublisherSourceDecorator(PlayerSource wrappedPlayerSource) {
		this.wrappedPlayerSource = wrappedPlayerSource;
	}
	
	/**
	   * Notifies the subscribers that there is a new player to handle.
	   * @param player The object passed to the subscribers.
	*/ 
	@Override
	public void notifySubscribers(Player player) {
		for(PlayerSubscriber playerSubscriber : subscribers){
			playerSubscriber.handlePlayer(player);
		}
	}
	
	/**
	   * Registers a PlayerSubscriber with the PlayerPublisher.
	   * @param playerSubscriber The object to be subscribed to the publisher.
	*/ 
	@Override
	public void register(PlayerSubscriber playerSubscriber) {
		subscribers.add(playerSubscriber);
	}

	/**
	   * Returns the next player and notifies the subscribers 
	   * @return The next player of the set.
	*/ 
	@Override
	public Player getNextPlayer() {
		Player player = wrappedPlayerSource.getNextPlayer();
		if( player != null){
			notifySubscribers(player);
		}
		return player;
	}
	
}

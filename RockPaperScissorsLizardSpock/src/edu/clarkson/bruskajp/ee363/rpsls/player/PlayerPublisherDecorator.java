package edu.clarkson.bruskajp.ee363.rpsls.player;

import java.util.ArrayList;
import java.util.List;

import edu.clarkson.bruskajp.ee363.rpsls.PlayerPublisher;
import edu.clarkson.bruskajp.ee363.rpsls.PlayerSubscriber;

public class PlayerPublisherDecorator implements PlayerPublisher{
	
	//private Player 
	private List<PlayerSubscriber> subscribers = new ArrayList<>();
	
	//public PlayerPublisherDecorator() {
	//	this.
	//}
	
	@Override
	public void notifySubscribers(Player player) {
		for(PlayerSubscriber playerSubscriber : subscribers){
			playerSubscriber.handlePlayer(player);
		}
	}

	@Override
	public void register(PlayerSubscriber playerSubscriber) {
		subscribers.add(playerSubscriber);
	}
	
}

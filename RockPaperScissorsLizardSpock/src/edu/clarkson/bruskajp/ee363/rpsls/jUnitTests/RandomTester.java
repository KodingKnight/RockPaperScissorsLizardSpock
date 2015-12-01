package edu.clarkson.bruskajp.ee363.rpsls.jUnitTests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import edu.clarkson.bruskajp.ee363.rpsls.display.CommandLineDisplayer;
import edu.clarkson.bruskajp.ee363.rpsls.display.Displayer;
import edu.clarkson.bruskajp.ee363.rpsls.display.PlayerSubscriberDisplayerDecorator;
import edu.clarkson.bruskajp.ee363.rpsls.player.ComputerPlayer;
import edu.clarkson.bruskajp.ee363.rpsls.player.MainPlayerSource;
import edu.clarkson.bruskajp.ee363.rpsls.player.Player;
import edu.clarkson.bruskajp.ee363.rpsls.player.PlayerPublisherSourceDecorator;
import edu.clarkson.bruskajp.ee363.rpsls.player.PlayerSource;
import edu.clarkson.bruskajp.ee363.rpsls.scoring.RightPriorityScoring;
import edu.clarkson.bruskajp.ee363.rpsls.scoring.Scoring;

public class RandomTester {

	/**
	   * Tests a very large number of computer players to make sure that nothing throws an error.
	*/ 
	
	@Test
	public void test() {
		
		for(int counter = 0; counter < 1000; ++counter){
			Scoring gestureScoring = new RightPriorityScoring();	
			
			Player [] players = new Player[2];
			Player player1 = new ComputerPlayer();
			Player player2 = new ComputerPlayer();
			
			players[0] = player1;
			players[1] = player2;
			
			int[] winningPlayers = gestureScoring.selectWinner(players);
			HashSet<Player> winningPlayersSet = new HashSet<>();
			for(int index = 0; index < winningPlayers.length; ++index){
				Player tempPlayer = players[index];
				winningPlayersSet.add(tempPlayer);
			}
			
			if (winningPlayersSet.isEmpty()) {
				System.out.println("I'm empty");
			}
			
			PlayerSource source = new MainPlayerSource(winningPlayersSet);
			
			
			PlayerPublisherSourceDecorator playerSourcePublisher = new PlayerPublisherSourceDecorator(source);
			
			Displayer<Player> winnerDisplay = new CommandLineDisplayer<>();
			
			playerSourcePublisher.register(new PlayerSubscriberDisplayerDecorator(winnerDisplay));
			 
			playerSourcePublisher.register((Player player) -> {
				if(winningPlayersSet.add(player)){
					winnerDisplay.display(player);
				}
			});
			
			while(playerSourcePublisher.getNextPlayer() != null){}
		}
		
	}

}

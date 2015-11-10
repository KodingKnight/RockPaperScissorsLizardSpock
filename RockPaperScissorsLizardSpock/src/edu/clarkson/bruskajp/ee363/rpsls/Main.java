package edu.clarkson.bruskajp.ee363.rpsls;

import java.util.HashSet;
import java.util.Set;

import edu.clarkson.bruskajp.ee363.rpsls.display.CommandLineDisplayer;
import edu.clarkson.bruskajp.ee363.rpsls.display.Displayer;
import edu.clarkson.bruskajp.ee363.rpsls.display.PlayerSubscriberDisplayerDecorator;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures.*;
import edu.clarkson.bruskajp.ee363.rpsls.jUnitTests.TwoPlayerCombinations;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures.*;
import edu.clarkson.bruskajp.ee363.rpsls.player.ComputerPlayer;
import edu.clarkson.bruskajp.ee363.rpsls.player.HumanPlayer;
import edu.clarkson.bruskajp.ee363.rpsls.player.MainPlayerSource;
import edu.clarkson.bruskajp.ee363.rpsls.player.Player;
import edu.clarkson.bruskajp.ee363.rpsls.player.PlayerPublisherSourceDecorator;
import edu.clarkson.bruskajp.ee363.rpsls.player.PlayerSource;
import edu.clarkson.bruskajp.ee363.rpsls.scoring.Scoring;

public class Main {

	/**
	   * This code implements the Liskov Substitution Principle and the Open Closed Principle.
	   * It could be designed better to make it more dynamic from the command line, 
	   * though things can currently be changed within main.
	 */
	
	/**
	   * Starts the program and controls how the rest of the
	   * program is linked together.
	   * @param args A String array containing 
	   * the arguments of the program.
	*/ 
	public static void main(String args[]) {
		Scoring gestureScoring = new Scoring();	
		
		Player [] players = new Player[2];
		ComputerPlayer computer1 = new ComputerPlayer();
		ComputerPlayer computer2 = new ComputerPlayer();
		players[0] = computer1;
		players[1] = computer2;
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

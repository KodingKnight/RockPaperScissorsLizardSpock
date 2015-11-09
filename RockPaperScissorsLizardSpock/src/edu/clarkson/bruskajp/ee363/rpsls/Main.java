package edu.clarkson.bruskajp.ee363.rpsls;

import java.util.HashSet;
import java.util.Set;

import edu.clarkson.bruskajp.ee363.rpsls.display.CommandLineDisplayer;
import edu.clarkson.bruskajp.ee363.rpsls.display.Displayer;
import edu.clarkson.bruskajp.ee363.rpsls.display.PlayerSubscriberDecorator;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures.*;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures.*;
import edu.clarkson.bruskajp.ee363.rpsls.player.ComputerPlayer;
import edu.clarkson.bruskajp.ee363.rpsls.player.HumanPlayer;
import edu.clarkson.bruskajp.ee363.rpsls.player.Player;
import edu.clarkson.bruskajp.ee363.rpsls.player.PlayerPublisherDecorator;
import edu.clarkson.bruskajp.ee363.rpsls.scoring.Scoring;

public class Main {

	public static void main(String args[]) {
		Scoring gestureScoring = new Scoring();
		Gesture [] rightHandGestures = new Gesture[3];
		Gesture [] leftHandGestures = new Gesture[3];		
		
		//ComputerPlayer computer1 = new ComputerPlayer();
		//ComputerPlayer computer2 = new ComputerPlayer();
		
		
		rightHandGestures[0] = new Spock();
		leftHandGestures[0] = new Infested();
		
		rightHandGestures[1] = new Spock();
		leftHandGestures[1] = new Poisonous();
		
		rightHandGestures[2] = new Rock();
		leftHandGestures[2] = new Radioactive();
		
		
		
		
		PlayerPublisherDecorator playerPublisher = new PlayerPublisherDecorator();
		
		Displayer<Player> winnerDisplay = new CommandLineDisplayer<>();
		Displayer<String> tieDisplay = new CommandLineDisplayer<>();
		
		playerPublisher.register(new PlayerSubscriberDecorator(winnerDisplay));
		/* 
		 * 
		Set<Player> winningPlayersSet = new HashSet<>();
		playerPublisher.register((Player player) -> {
			if(winningPlayersSet.add(player)){
				winnerDisplay.display(player);
			}
		});
		
		*/
		
		//Player [] players = (Player[]) winningPlayersSet.toArray();
		
		
		int[] firstWinners = gestureScoring.selectPartialWinner(rightHandGestures);
		
		
		//if(winners.length == 0){
		//	winnerDisplay.display();
		//}
		
		int[] secondWinners = null;
		if(firstWinners.length == 0) {
			System.out.println("It is a deadlock!");
			return;
		} else if(firstWinners.length == 1) {
			System.out.println(rightHandGestures[firstWinners[0]].getGestureType() + " at position " + firstWinners[0] + " wins");
			return;
		} else {
			Gesture [] newLeftHandGestures = new Gesture[firstWinners.length];
			
			for(int index = 0; index < firstWinners.length; ++index) {
				newLeftHandGestures[index] = leftHandGestures[firstWinners[index]];
			}
			
			secondWinners = gestureScoring.selectPartialWinner(newLeftHandGestures);
		}
		
		if(secondWinners.length == 0) {
			System.out.println("It is a deadlock!");
		} else if(secondWinners.length == 1) {
			System.out.println(rightHandGestures[secondWinners[0]].getGestureType() + " at position " + secondWinners[0] + " wins");
		} else {
			System.out.println("It is a tie");
		}
			
	}
	
}

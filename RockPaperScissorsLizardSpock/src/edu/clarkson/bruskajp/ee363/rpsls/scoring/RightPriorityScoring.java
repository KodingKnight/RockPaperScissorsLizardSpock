package edu.clarkson.bruskajp.ee363.rpsls.scoring;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.player.Player;

public class RightPriorityScoring extends Scoring {
	
	public int[] selectWinner(Player [] players) {
		Gesture[] rightHandGestures = new Gesture[players.length];
		for(int index = 0; index < players.length; ++index) {
			rightHandGestures[index] = players[index].getRightHandGesture();
		}
		
		int[] firstWinners = this.selectPartialWinner(rightHandGestures);
		if(firstWinners == null){
			return null;
		} else if(firstWinners.length == 1) {
			return firstWinners;
		} else {
			Gesture [] leftHandGestures = new Gesture[firstWinners.length];
			
			for(int index = 0; index < firstWinners.length; ++index) {
				leftHandGestures[index] = players[firstWinners[index]].getLeftHandGesture();
			}
			
			int[] secondWinners = this.selectPartialWinner(leftHandGestures);
			
			int[] finalWinners = null;
			
			if(secondWinners != null){
				finalWinners = new int[secondWinners.length];
				for(int index = 0; index < secondWinners.length; ++index){
					finalWinners[index] = firstWinners[secondWinners[index]];
				}
			}
			return finalWinners;
		}
	}
	
}

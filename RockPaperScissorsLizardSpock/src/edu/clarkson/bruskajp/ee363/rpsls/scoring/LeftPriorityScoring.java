package edu.clarkson.bruskajp.ee363.rpsls.scoring;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.player.Player;

public class LeftPriorityScoring extends Scoring {
	
	public int[] selectWinner(Player [] players) {
		Gesture[] leftHandGestures = new Gesture[players.length];
		for(int index = 0; index < players.length; ++index) {
			leftHandGestures[index] = players[index].getLeftHandGesture();
		}
		
		int[] firstWinners = this.selectPartialWinner(leftHandGestures);
		if(firstWinners == null){
			return null;
		} else if(firstWinners.length == 1) {
			return firstWinners;
		} else {
			Gesture [] rightHandGestures = new Gesture[firstWinners.length];
			
			for(int index = 0; index < firstWinners.length; ++index) {
				rightHandGestures[index] = players[firstWinners[index]].getRightHandGesture();
			}
			
			int[] secondWinners = this.selectPartialWinner(rightHandGestures);
			
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

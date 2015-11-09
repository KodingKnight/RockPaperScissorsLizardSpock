package edu.clarkson.bruskajp.ee363.rpsls.scoring;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.LeftHandGesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.RightHandGesture;
import edu.clarkson.bruskajp.ee363.rpsls.player.Player;

public class Scoring {
	
	public int[] selectPartialWinner(Gesture [] objectArray) {
		
		int numberOfWinningObjects = objectArray.length;
		boolean [] objectArrayLosingObjects = new boolean[objectArray.length];
		
		for(int index = 0; index < objectArray.length; ++index){
			for(int index2 = 0; index2 < objectArray.length; ++index2){
				if(objectArray[index].compareGestures(objectArray[index2]) == 2){
					objectArrayLosingObjects[index] = true;
					break;
				}
			}
			if(objectArrayLosingObjects[index] == true){
				--numberOfWinningObjects;
				continue;
			}
		}
		
		// else if only returns the first winning thing
		
		if(numberOfWinningObjects == 0) {
			return null;
		} else if(numberOfWinningObjects >= 1) {
			int [] winningObjects = new int[numberOfWinningObjects];
			int indexOfWinningObjects = 0;
			for(int index = 0; index < objectArrayLosingObjects.length; ++index){
				if(objectArrayLosingObjects[index] != true){
					winningObjects[indexOfWinningObjects] = index;
					++indexOfWinningObjects;
				}
			}
			return winningObjects;
		} else {
			System.out.println("Error in scoring");
			System.exit(1);
		}
		
		return null;
	}
	
	public int[] selectWinner(Player [] players) {
		
		Gesture[] rightHandGestures = new Gesture[players.length];
		for(int index = 0; index < players.length; ++index) {
			rightHandGestures[index] = players[index].getRightHandGesture();
		}
		
		int[] firstWinners = this.selectPartialWinner(rightHandGestures);
		if(firstWinners.length <= 1) {
			return firstWinners;
		} else {
			Gesture [] leftHandGestures = new Gesture[firstWinners.length];
			
			for(int index = 0; index < firstWinners.length; ++index) {
				leftHandGestures[index] = leftHandGestures[firstWinners[index]];
			}
			
			int[] secondWinners = this.selectPartialWinner(leftHandGestures);
		
			return secondWinners;
		}
		
	}
	
}

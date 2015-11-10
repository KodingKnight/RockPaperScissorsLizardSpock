package edu.clarkson.bruskajp.ee363.rpsls.jUnitTests;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures.*;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures.*;
import edu.clarkson.bruskajp.ee363.rpsls.scoring.Scoring;

public class TwoPlayerCombinations {
		
	Scoring gestureScoring = new Scoring();
	Gesture [] rightHandGestures = new Gesture[2];
	Gesture [] leftHandGestures = new Gesture[2];
	
	int[] firstWinners;
	int[] secondWinners;
	
	/**
	   * Tests all of the two player conbinations with distinct results
	   * @return A boolean describing if the program worked correctly.
	*/ 
	public boolean test(){		
		
		rightHandGestures[0] = new Rock();
			
			rightHandGestures[1] = new Paper();
			if(compare() != 1){ return false; }
			
			rightHandGestures[1] = new Scissors();
			if(compare() != 0){ return false; }
			
			rightHandGestures[1] = new Lizzard();
			if(compare() != 0){ return false; }
			
			rightHandGestures[1] = new Spock();
			if(compare() != 1){ return false; }
			
		rightHandGestures[0] = new Paper();
			
			rightHandGestures[1] = new Scissors();
			if(compare() != 1){ return false; }
			
			rightHandGestures[1] = new Lizzard();
			if(compare() != 1){ return false; }
			
			rightHandGestures[1] = new Spock();
			if(compare() != 0){ return false; }
			
		rightHandGestures[0] = new Scissors();
		
			rightHandGestures[1] = new Lizzard();
			if(compare() != 0){ return false; }
			
			rightHandGestures[1] = new Spock();
			if(compare() != 1){ return false; }
			
		rightHandGestures[0] = new Lizzard();
		
			rightHandGestures[1] = new Spock();
			if(compare() != 0){ return false; }
			
		rightHandGestures[0] = new Rock();
		rightHandGestures[1] = new Rock();
		leftHandGestures[0] = new Radioactive();
		leftHandGestures[1] = new Poisonous();
			
			if(compare() != 0){ return false; }
			
			leftHandGestures[1] = new Infested();
			if(compare() != 1){ return false; }
			
		leftHandGestures[0] = new Poisonous();
			
			if(compare() != 0){ return false; }
			
		rightHandGestures[0] = new Rock();
		rightHandGestures[1] = new Rock();
		leftHandGestures[0] = new Radioactive();
		leftHandGestures[1] = new Radioactive();
		
			if(compare() != 2){ return false; }
		
		rightHandGestures[0] = new Paper();
		rightHandGestures[1] = new Paper();
		leftHandGestures[0] = new Poisonous();
		leftHandGestures[1] = new Poisonous();
		
			if(compare() != 2){ return false; }
		
		rightHandGestures[0] = new Scissors();
		rightHandGestures[1] = new Scissors();
		leftHandGestures[0] = new Infested();
		leftHandGestures[1] = new Infested();
		
			if(compare() != 2){ return false; }
		
		rightHandGestures[0] = new Lizzard();
		rightHandGestures[1] = new Lizzard();
		
			if(compare() != 2){ return false; }
		
		rightHandGestures[0] = new Spock();
		rightHandGestures[1] = new Spock();

			if(compare() != 2){ return false; }
			
		System.out.println("It is correct");
		return true;
	}
	
	private int compare(){
		firstWinners = gestureScoring.selectPartialWinner(rightHandGestures);
		
		if(firstWinners.length == 0) {
			return -1;
		} else if(firstWinners.length == 1) {
			return firstWinners[0];
		} else {
			secondWinners = gestureScoring.selectPartialWinner(leftHandGestures);
			
			if(secondWinners.length == 0) {
				return -1;
			} else if(secondWinners.length == 1) {
				return secondWinners[0];
			} else {
				return 2;
			}
		}
	}
	
	
}

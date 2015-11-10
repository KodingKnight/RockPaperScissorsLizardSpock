package edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.RightHandGesture;

public class Scissors extends RightHandGesture {

	/**
	   * Returns a description of the class as a sting 
	*/ 
	@Override
	public String getGestureType() {
		return "Scissors";
	}

	/**
	   * Compares a gesture to itself to see who loses. 
	   * @param objectArray A Gesture to be compared to the this object.
	   * @return An int to describe if this object won, tied or lost.
	*/ 
	@Override
	public int compareGestures(Gesture gesture) {
		
		String gestureType = gesture.getGestureType();
		
		switch (gestureType) {
			case "Paper": case "Lizzard": 
				return 0;
			case "Scissors":
				return 1;
			case "Rock": case "Spock": 
				return 2;
			default:
				System.out.println("Invalid Left Hand Gesture Type");
				System.exit(1);
		}
		
		return -1;
		
	}

}

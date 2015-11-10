package edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.RightHandGesture;

public class Lizzard extends RightHandGesture {

	/**
	   * Returns a description of the class as a sting 
	*/ 
	@Override
	public String getGestureType() {
		return "Lizzard";
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
			case "Paper": case "Spock": 
				return 0;
			case "Lizzard":
				return 1;
			case "Rock": case "Scissors": 
				return 2;
			default:
				System.out.println("Invalid Left Hand Gesture Type");
				System.exit(1);
		}
		
		return -1;
		
	}

}

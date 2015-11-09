package edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.RightHandGesture;

public class Lizzard extends RightHandGesture {

	@Override
	public String getGestureType() {
		return "Lizzard";
	}

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

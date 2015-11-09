package edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.LeftHandGesture;

public class Infested extends LeftHandGesture {

	//Characteristic characteristic;
	
	@Override
	public String getGestureType() {
		return "Infestation";
	}

	@Override
	public int compareGestures(Gesture gesture) {
		
		String gestureType = gesture.getGestureType();
		
		switch (gestureType) {
			case "Radioactivity":
				return 0;
			case "Infestation":
				return 1;
			case "Poison":
				return 2;
			default:
				System.out.println("Invalid Left Hand Gesture Type");
				System.exit(1);
		}
		
		return -1;
		
	}

}

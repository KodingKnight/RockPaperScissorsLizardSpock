package edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.LeftHandGesture;

public class Poisonous extends LeftHandGesture {

	@Override
	public String getGestureType() {
		return "Poison";
	}

	@Override
	public int compareGestures(Gesture gesture) {
		
		String gestureType = gesture.getGestureType();
		
		switch (gestureType) {
			case "Infestation":
				return 0;
			case "Poison":
				return 1;
			case "Radioactivity":
				return 2;
			default:
				System.out.println("Invalid Left Hand Gesture Type");
				System.exit(1);
		}
		
		return -1;
		
	}

}

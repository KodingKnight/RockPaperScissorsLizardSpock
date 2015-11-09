package edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.LeftHandGesture;

public class Radioactive extends LeftHandGesture {

	@Override
	public String getGestureType() {
		return "Radioactivity";
	}

	@Override
	public int compareGestures(Gesture gesture) {
		
		String gestureType = gesture.getGestureType();
		
		switch (gestureType) {
			case "Poison":
				return 0;
			case "Radioactivity":
				return 1;
			case "Infestation":
				return 2;
			default:
				System.out.println("Invalid Left Hand Gesture Type");
				System.exit(1);
		}
		
		return -1;
		
	}

}

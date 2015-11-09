package edu.clarkson.bruskajp.ee363.rpsls.gestures;

public abstract class LeftHandGesture extends Gesture {
	
	@Override
	public abstract String getGestureType();
	
	@Override
	public abstract int compareGestures(Gesture gesture);
	
}

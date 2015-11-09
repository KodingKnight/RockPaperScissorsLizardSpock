package edu.clarkson.bruskajp.ee363.rpsls.gestures;

public abstract class RightHandGesture extends Gesture{
	
	@Override
	public abstract String getGestureType();
	
	@Override
	public abstract int compareGestures(Gesture gesture);
	
}

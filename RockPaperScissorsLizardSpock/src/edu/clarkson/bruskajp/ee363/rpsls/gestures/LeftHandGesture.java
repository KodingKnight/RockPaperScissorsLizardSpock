package edu.clarkson.bruskajp.ee363.rpsls.gestures;

public abstract class LeftHandGesture extends Gesture {
	
	/**
	   * This is an implementation of strategy pattern.
	   * This was done to abstract away the responsibilities of what a left hand gesture can do.
	 */
	
	@Override
	public abstract String getGestureType();
	
	@Override
	public abstract int compareGestures(Gesture gesture);
	
}

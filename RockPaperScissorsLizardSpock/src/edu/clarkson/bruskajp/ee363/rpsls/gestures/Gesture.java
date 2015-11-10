package edu.clarkson.bruskajp.ee363.rpsls.gestures;

public abstract class Gesture {
	
	/**
	   * This is an implementation of strategy pattern.
	   * This was done to abstract away the responsibilities of what a gesture can do.
	 */
	
	public abstract String getGestureType();
	
	public abstract int compareGestures(Gesture gesture);
	
}

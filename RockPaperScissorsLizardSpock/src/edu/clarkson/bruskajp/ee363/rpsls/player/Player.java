package edu.clarkson.bruskajp.ee363.rpsls.player;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.LeftHandGesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.RightHandGesture;

public class Player {
	
	RightHandGesture rightHandGesture;
	LeftHandGesture leftHandGesture;
	
	public RightHandGesture getRightHandGesture() {
		return rightHandGesture;
	}
	public void setRightHandGesture(RightHandGesture rightHandGesture) {
		this.rightHandGesture = rightHandGesture;
	}
	public LeftHandGesture getLeftHandGesture() {
		return leftHandGesture;
	}
	public void setLeftHandGesture(LeftHandGesture leftHandGesture) {
		this.leftHandGesture = leftHandGesture;
	}
	
	@Override
	public String toString() {
		return rightHandGesture.getGestureType() + " and " + leftHandGesture.getGestureType() + " wins";
	}
	
}

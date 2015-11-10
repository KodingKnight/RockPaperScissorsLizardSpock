package edu.clarkson.bruskajp.ee363.rpsls.player;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.LeftHandGesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.RightHandGesture;

public class HumanPlayer extends Player {
	
	/**
	   * Constructs the HumanPlayer and sets its gestures.
	   * @param rightHandGesture The HumanPlayer's right hand gesture.
	   * @param leftHandGesture The HumanPlayer's left hand gesture.
	*/ 
	public HumanPlayer(RightHandGesture rightHandGesture, LeftHandGesture leftHandGesture) {
		this.rightHandGesture = rightHandGesture;
		this.leftHandGesture = leftHandGesture;
	}

}

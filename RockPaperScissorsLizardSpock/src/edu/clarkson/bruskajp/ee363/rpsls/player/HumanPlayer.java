package edu.clarkson.bruskajp.ee363.rpsls.player;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.LeftHandGesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.RightHandGesture;

public class HumanPlayer extends Player {

	public HumanPlayer(RightHandGesture rightHandGesture, LeftHandGesture leftHandGesture) {
		this.rightHandGesture = rightHandGesture;
		this.leftHandGesture = leftHandGesture;
	}

}

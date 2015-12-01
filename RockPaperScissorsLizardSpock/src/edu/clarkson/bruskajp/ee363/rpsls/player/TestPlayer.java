package edu.clarkson.bruskajp.ee363.rpsls.player;

import java.util.Scanner;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.LeftHandGesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.RightHandGesture;

public class TestPlayer extends Player {
	
	/**
	   * Constructs the HumanPlayer and sets its gestures.
	   * @param rightHandGesture The HumanPlayer's right hand gesture.
	   * @param leftHandGesture The HumanPlayer's left hand gesture.
	*/ 
	public TestPlayer(RightHandGesture rightHandGesture, LeftHandGesture leftHandGesture) {
		this.rightHandGesture = rightHandGesture;
		this.leftHandGesture = leftHandGesture;
	}
	
	private static Object getInstanceOf(String classNameString) {
		try {
			Class<?> className = Class.forName(classNameString);
			Object object = className.newInstance();
			return object;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

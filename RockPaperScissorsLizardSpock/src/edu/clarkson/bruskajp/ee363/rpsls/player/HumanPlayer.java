package edu.clarkson.bruskajp.ee363.rpsls.player;

import java.util.Scanner;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.LeftHandGesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.RightHandGesture;

public class HumanPlayer extends Player {
	
	/**
	   * Constructs the HumanPlayer and sets its gestures.
	   * @param rightHandGesture The HumanPlayer's right hand gesture.
	   * @param leftHandGesture The HumanPlayer's left hand gesture.
	*/ 
	public HumanPlayer() {
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("Right Hand Gestures: Lizzard, Paper, Rock, Scissors, Spock");
			System.out.print("Input a right hand gesture: ");
			String rightHandGesture = scanner.next();
			this.rightHandGesture = (RightHandGesture) getInstanceOf("edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures." + rightHandGesture);
			System.out.println("");
		} while(this.rightHandGesture == null);
		
		System.out.println("");
		
		do {
			System.out.println("Left Hand Gestures: Infested, Poisonous, Radioactive");
			System.out.print("Input a left hand gesture: ");
			String leftHandGesture = scanner.next();
			this.leftHandGesture = (LeftHandGesture) getInstanceOf("edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures." + leftHandGesture);
			System.out.println("");
		} while(this.leftHandGesture == null);
		
		System.out.println("");
	}
	
	private static Object getInstanceOf(String classNameString) {
		try {
			Class<?> className = Class.forName(classNameString);
			Object object = className.newInstance();
			return object;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			//e.printStackTrace();
		}
		
		return null;
	}

}

package edu.clarkson.bruskajp.ee363.rpsls.player;

import java.util.Random;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.LeftHandGesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.RightHandGesture;

public class ComputerPlayer extends Player {
	
	String [] rightHandGestures = {"Rock", "Paper", "Scissors", "Lizzard", "Spock"};
	String [] leftHandGestures = {"Infested", "Poisonous", "Radioactive"};
	
	Random randomNumberGenerator;

	public ComputerPlayer() {
		randomNumberGenerator = new Random();
		int randomNumberRight = randomNumberGenerator.nextInt(5);
		int randomNumberLeft = randomNumberGenerator.nextInt(3);
		
		this.rightHandGesture = (RightHandGesture) getInstanceOf("edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures." + rightHandGestures[randomNumberRight]);
		this.leftHandGesture = (LeftHandGesture) getInstanceOf("edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures." + leftHandGestures[randomNumberLeft]);
	}

	public static Object getInstanceOf(String classNameString) {
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

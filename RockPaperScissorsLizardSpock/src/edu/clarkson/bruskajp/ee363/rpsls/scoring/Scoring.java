package edu.clarkson.bruskajp.ee363.rpsls.scoring;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.player.Player;

public abstract class Scoring {
	
	/**
	   * When the game has 2 players the result can either be a single winner or a tie.
	   * 
	   * When the game has more than 2 players then there can be a single winner, 
	   * a tie between multiple players, or no winners (all of the moves cancel).
	 */
	
	/**
	   * Selects the winning Gesture from an array of gestures. 
	   * @param objectArray A Gesture array containing 
	   * the gestures to be compared.
	   * @return An array containing the indexes of the winning gestures.
	*/ 
	public int[] selectPartialWinner(Gesture [] objectArray) {
		int numberOfWinningObjects = objectArray.length;
		boolean [] objectArrayLosingObjects = new boolean[objectArray.length];
		
		for(int index = 0; index < objectArray.length; ++index){
			for(int index2 = 0; index2 < objectArray.length; ++index2){
				if(objectArray[index].compareGestures(objectArray[index2]) == 2){
					objectArrayLosingObjects[index] = true;
					break;
				}
			}
			if(objectArrayLosingObjects[index] == true){
				--numberOfWinningObjects;
				continue;
			}
		}
		
		if(numberOfWinningObjects == 0) {
			return null;
		} else if(numberOfWinningObjects >= 1) {
			int [] winningObjects = new int[numberOfWinningObjects];
			int indexOfWinningObjects = 0;
			for(int index = 0; index < objectArrayLosingObjects.length; ++index){
				if(objectArrayLosingObjects[index] != true){
					winningObjects[indexOfWinningObjects] = index;
					++indexOfWinningObjects;
				}
			}
			return winningObjects;
		} else {
			System.out.println("Error in scoring");
			System.exit(1);
		}
		
		return null;
	}
	
	/**
	   * Selects the winning Player from an array of players. 
	   * @param objectArray A Player array containing 
	   * the players to be compared.
	   * @return An array containing the indexes of the winning players.
	*/ 
	public abstract int[] selectWinner(Player [] players);	
	
}

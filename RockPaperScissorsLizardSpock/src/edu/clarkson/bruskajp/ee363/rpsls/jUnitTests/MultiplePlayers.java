package edu.clarkson.bruskajp.ee363.rpsls.jUnitTests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import edu.clarkson.bruskajp.ee363.rpsls.display.CommandLineDisplayer;
import edu.clarkson.bruskajp.ee363.rpsls.display.Displayer;
import edu.clarkson.bruskajp.ee363.rpsls.display.PlayerSubscriberDisplayerDecorator;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures.*;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures.*;
import edu.clarkson.bruskajp.ee363.rpsls.player.ComputerPlayer;
import edu.clarkson.bruskajp.ee363.rpsls.player.HumanPlayer;
import edu.clarkson.bruskajp.ee363.rpsls.player.MainPlayerSource;
import edu.clarkson.bruskajp.ee363.rpsls.player.Player;
import edu.clarkson.bruskajp.ee363.rpsls.player.PlayerPublisherSourceDecorator;
import edu.clarkson.bruskajp.ee363.rpsls.player.PlayerSource;
import edu.clarkson.bruskajp.ee363.rpsls.scoring.Scoring;

public class MultiplePlayers {

	@Test
	public void test() {
		
		Scoring gestureScoring = new Scoring();	
		
		Player [] players = new Player[3];
		Player player1 = new HumanPlayer(new Spock(), new Infested());
		Player player2 = new HumanPlayer(new Spock(), new Infested());
		Player player3 = new HumanPlayer(new Spock(), new Infested());
		
		players[0] = player1;
		players[1] = player2;
		players[2] = player3;
		
		int[] winningPlayers = gestureScoring.selectWinner(players);
		if(winningPlayers.length != 3){ fail("Invalid Result"); }
		
		players[1].setRightHandGesture(new Rock());
		winningPlayers = gestureScoring.selectWinner(players);
		if(winningPlayers.length != 2){ fail("Invalid Result"); }
		
		players[0].setRightHandGesture(new Paper());
		players[0].setLeftHandGesture(new Radioactive());
		players[2].setRightHandGesture(new Scissors());
		winningPlayers = gestureScoring.selectWinner(players);
		if(winningPlayers != null){ fail("Invalid Result"); }
		
		players[0] = new HumanPlayer(new Lizzard(), new Radioactive());
		players[1] = new HumanPlayer(new Lizzard(), new Infested());
		players[2] = new HumanPlayer(new Paper(), new Poisonous());
		winningPlayers = gestureScoring.selectWinner(players);
		if(winningPlayers.length != 1){ fail("Invalid Result"); }
		
		players[0] = new HumanPlayer(new Lizzard(), new Radioactive());
		players[1] = new HumanPlayer(new Lizzard(), new Radioactive());
		players[2] = new HumanPlayer(new Paper(), new Poisonous());
		winningPlayers = gestureScoring.selectWinner(players);
		if(winningPlayers.length != 2){ fail("Invalid Result"); }
		
	}

}

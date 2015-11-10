package edu.clarkson.bruskajp.ee363.rpsls.jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.clarkson.bruskajp.ee363.rpsls.gestures.Gesture;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures.Infested;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures.Poisonous;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.lefthandgestures.Radioactive;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures.Lizzard;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures.Paper;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures.Rock;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures.Scissors;
import edu.clarkson.bruskajp.ee363.rpsls.gestures.righthandgestures.Spock;
import edu.clarkson.bruskajp.ee363.rpsls.scoring.Scoring;

public class ComparingGesture {
	
	/**
	   * Tests to make sure that two gestures when compared in either direction will return the correct result.
	*/ 
	@Test
	public void test(){		
			// Checks all of Rock's comparisons
			if(new Rock().compareGestures(new Paper()) != 2){ fail("Invalid Result"); }
			if(new Paper().compareGestures(new Rock()) != 0){ fail("Invalid Result"); }
			
			if(new Rock().compareGestures(new Scissors()) != 0){ fail("Invalid Result"); }
			if(new Scissors().compareGestures(new Rock()) != 2){ fail("Invalid Result"); }
			
			if(new Rock().compareGestures(new Lizzard()) != 0){ fail("Invalid Result"); }
			if(new Lizzard().compareGestures(new Rock()) != 2){ fail("Invalid Result"); }
			
			if(new Rock().compareGestures(new Spock()) != 2){ fail("Invalid Result"); }
			if(new Spock().compareGestures(new Rock()) != 0){ fail("Invalid Result"); }
			
			
			// Checks all of Paper's comparisons
			if(new Paper().compareGestures(new Scissors()) != 2){ fail("Invalid Result"); }
			if(new Scissors().compareGestures(new Paper()) != 0){ fail("Invalid Result"); }
			
			if(new Paper().compareGestures(new Lizzard()) != 2){ fail("Invalid Result"); }
			if(new Lizzard().compareGestures(new Paper()) != 0){ fail("Invalid Result"); }
			
			if(new Paper().compareGestures(new Spock()) != 0){ fail("Invalid Result"); }
			if(new Spock().compareGestures(new Paper()) != 2){ fail("Invalid Result"); }
			
			
			// Checks all of Scissor's comparisons
			if(new Scissors().compareGestures(new Lizzard()) != 0){ fail("Invalid Result"); }
			if(new Lizzard().compareGestures(new Scissors()) != 2){ fail("Invalid Result"); }
			
			if(new Scissors().compareGestures(new Spock()) != 2){ fail("Invalid Result"); }
			if(new Spock().compareGestures(new Scissors()) != 0){ fail("Invalid Result"); }
			
			
			// Checks all of Lizzard's comparisons
			if(new Lizzard().compareGestures(new Spock()) != 0){ fail("Invalid Result"); }
			if(new Spock().compareGestures(new Lizzard()) != 2){ fail("Invalid Result"); }
			
			// Checks all of Spock's comparisons
			// They are all done within the other code
			

			
			// Checks all of Infested's comparisons
			if(new Radioactive().compareGestures(new Poisonous()) != 0){ fail("Invalid Result"); }
			if(new Poisonous().compareGestures(new Radioactive()) != 2){ fail("Invalid Result"); }
			
			if(new Radioactive().compareGestures(new Infested()) != 2){ fail("Invalid Result"); }
			if(new Infested().compareGestures(new Radioactive()) != 0){ fail("Invalid Result"); }
			
			
			// Checks all of Poisonous's comparisons
			if(new Poisonous().compareGestures(new Infested()) != 0){ fail("Invalid Result"); }
			if(new Infested().compareGestures(new Poisonous()) != 2){ fail("Invalid Result"); }
			
			// Checks all of Radioactive's comparisons
			// They are all done within the other code
			
	}

}

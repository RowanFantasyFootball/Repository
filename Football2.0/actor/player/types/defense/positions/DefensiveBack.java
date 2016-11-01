package actor.player.types.defense.positions;

import actor.player.POSITION;
import actor.player.types.defense.DefensivePlayer;
import plays.Play;

/**
 * This class will create a defensive back object with the inputted stats
 * This class can be instantiated on its own, unlike player and defensive player.
 * This is one of the objects we are going to use to represent a player on the grid
 * 
 * @author Joe Dunne
 */
public class DefensiveBack extends DefensivePlayer {

	public DefensiveBack(String first, String last, int speed, int strength) {
		super(first, last, speed, strength);
	}

	@Override
	public void act(Play play) {
		// TODO This is where we handle the act method for a defensive back
		//This is just example output for the skeleton
		System.out.println(getFirstName() + " " + getLastName() + " is moving...");
	}

	@Override
	public POSITION getPosition() {
		return POSITION.DEFENSIVE_BACK;
	}
	
}

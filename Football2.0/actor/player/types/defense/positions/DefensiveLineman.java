package actor.player.types.defense.positions;

import actor.player.POSITION;
import actor.player.types.defense.DefensivePlayer;
import plays.Play;

public class DefensiveLineman extends DefensivePlayer {

	public DefensiveLineman(String first, String last, int speed, int strength) {
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
		return POSITION.DEFENSIVE_LINEMAN;
	}
}

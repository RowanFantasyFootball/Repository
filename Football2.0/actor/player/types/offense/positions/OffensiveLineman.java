package actor.player.types.offense.positions;

import actor.player.POSITION;
import actor.player.types.offense.OffensivePlayer;
import plays.Play;

public class OffensiveLineman extends OffensivePlayer {
	
	public OffensiveLineman(String first, String last, int speed, int strength) {
		super(first, last, speed, strength, false);
	}
	
	@Override
	public void act(Play play) {
		//Act here based off of the play type
	}

	@Override
	public POSITION getPosition() {
		return POSITION.OFFENSIVE_LINEMAN;
	}
}

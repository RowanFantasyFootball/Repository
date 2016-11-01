package actor.player.types.offense.positions;

import actor.player.POSITION;
import actor.player.types.offense.OffensivePlayer;
import plays.Play;

public class RunningBack extends OffensivePlayer {

	public RunningBack(String first, String last, int speed, int strength) {
		super(first, last, speed, strength, true);
	}
	
	@Override
	public void act(Play play) {
		//act on the player here
	}

	@Override
	public POSITION getPosition() {
		return POSITION.RUNNINGBACK;
	}
}

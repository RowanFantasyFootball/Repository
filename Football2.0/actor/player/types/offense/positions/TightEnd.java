package actor.player.types.offense.positions;

import actor.player.POSITION;
import actor.player.types.offense.OffensivePlayer;
import plays.Play;

public class TightEnd extends OffensivePlayer {

	public TightEnd(String first, String last, int speed, int strength) {
		super(first, last, speed, strength, true);
	}

	@Override
	public void act(Play play) {
		//acts on the tight end
	}

	@Override
	public POSITION getPosition() {
		return POSITION.TIGHTEND;
	}
}

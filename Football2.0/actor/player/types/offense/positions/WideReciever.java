package actor.player.types.offense.positions;

import actor.player.POSITION;
import actor.player.types.offense.OffensivePlayer;
import plays.Play;

public class WideReciever extends OffensivePlayer {

	public WideReciever(String first, String last, int speed, int strength) {
		super(first, last, speed, strength, false);
	}
	
	@Override
	public void act(Play play) {
		//act on the wide reciever here
	}

	@Override
	public POSITION getPosition() {
		return POSITION.WIDERECIEVER;
	}
}

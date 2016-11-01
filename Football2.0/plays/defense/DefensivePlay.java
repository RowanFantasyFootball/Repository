package plays.defense;

import java.util.ArrayList;

import actor.player.Player;
import plays.Play;

public class DefensivePlay extends Play {

	/**
	 * The maximum value of the defense's potential to stop an offensive play
	 */
	public static final int MAX_STOPPING_POTENTIAL = 500;

	public DefensivePlay(ArrayList<Player> players) {
		super(players);
	}

	@Override
	public void assignPlayerMovements() {
		// TODO Auto-generated method stub
		
	}


}

package plays.defense;

import plays.offense.OFFENSIVE_PLAY_TYPE;
import plays.offense.OffensivePlay;

public class DefensivePlaybook {
	/**
	 * Gets a random offensive play
	 * 
	 * @return
	 */
	public static OffensivePlay getRandomPlay() {
		switch(OFFENSIVE_PLAY_TYPE.getRandomPlayType()) {
		case PASS:
			break;
		case QBSNEAK:
			break;
		case RUN:
			break;
		default:
			break;
		}
		return null;
	}
}

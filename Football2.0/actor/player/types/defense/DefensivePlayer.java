package actor.player.types.defense;

import actor.player.Player;

public abstract class DefensivePlayer extends Player {

	/**
	 * Creates a defensive player object
	 * 
	 * @param first
	 *            - first name
	 * @param last
	 *            - last name
	 * @param speed
	 *            - speed of player
	 * @param strength
	 *            - strength of player
	 */
	public DefensivePlayer(String first, String last, int speed, int strength) {
		super(first, last, speed, strength);
	}
}

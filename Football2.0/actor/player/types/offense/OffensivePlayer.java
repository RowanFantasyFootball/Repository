package actor.player.types.offense;

import actor.player.Player;

public abstract class OffensivePlayer extends Player {

	/**
	 * A boolean that determines if the player is eligible to receive the ball
	 */
	private boolean isEligible;

	/**
	 * A boolean that determines if the player has been tackled
	 */
	private boolean tackled;

	/**
	 * Creates a new Offensive Player
	 * 
	 * @param first
	 *            - the players first name
	 * @param last
	 *            - the players last name
	 * @param speed
	 *            - the players speed level
	 * @param strength
	 *            - the players strength level
	 * @param isEligible
	 *            - if the player is eligible to recieve the ball or not
	 */
	public OffensivePlayer(String first, String last, int speed, int strength, boolean isEligible) {
		super(first, last, speed, strength);
		this.isEligible = isEligible;
	}

	/**
	 * Sets the tackled variable
	 * 
	 * MUST BE SET TO FALSE AFTER EACH TIME A PLAYER IS TACKELD AND A PLAY ENDS
	 * 
	 * @param tackled - true if the player has been tackled, false if resetting the value
	 */
	public void setTackled(boolean tackled) {
		this.tackled = tackled;
	}

	/**
	 * Returns if the player is tackled or not
	 * 
	 * @return true if the player has been tackled
	 */
	public boolean isTackled() {
		return tackled;
	}

	/**
	 * Tells whether or not if the player is eligible to receive the ball in a play
	 * 
	 * @return true if the player can take the ball in his "hands"
	 */
	public boolean isEligible() {
		return isEligible;
	}
}

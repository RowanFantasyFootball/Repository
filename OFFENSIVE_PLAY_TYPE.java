

/**
 * enum
 */
public enum OFFENSIVE_PLAY_TYPE {
	/**
	 * Currently we have 3 offensive play types
	 */
	RUN, PASS, QBSNEAK;

	/**
	 * The variable which stores the potential of successfully completing a play
	 * (gaining yards). The higher the yardageGainPotential, the more powerful
	 * the play will be against the defense, thus meaning more potential the
	 * defense will stop the offense
	 */
	private final int yardageGainPotential;

	/**
	 * Constructor for creating a new offensive play type enum
	 */
	OFFENSIVE_PLAY_TYPE() {
		yardageGainPotential = Randomizer.getRandomNumber(DefensivePlay.MAX_STOPPING_POTENTIAL);
	}

	/**
	 * Gets the potential of the offense successfully completing a play and gain
	 * yards
	 * 
	 * @return the potential of the offense successfully completing a play and
	 *         gain yards
	 */
	public int getOffensiveYardageGainPotential() {
		return yardageGainPotential;
	}

	/**
	 * Gets a random offensive play type
	 * 
	 * @return a random play type for the offense to use
	 */
	public static OFFENSIVE_PLAY_TYPE getRandomPlayType() {
		return values()[Randomizer.getRandomNumber(values().length - 1)];
	}
}

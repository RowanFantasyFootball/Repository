/**
 * An enum for the storage of defensive play types
 * 
 * If you are unfamiliar with enums, look up how to use them they are very
 * useful. With enums you have the ability to create your own variable with its
 * own values
 */
public enum PLAY_TYPE {
	/**
	 * The offensive play types we want to support
	 */
	RUN, PASS, QBSNEAK,
	
	
	/**
	 * The defensive play types we want
	 */
	COVER4, BLITZ, ZONE, MAN;

	/**
	 * The potential of a successful play
	 */
	private final int potential;

	/**
	 * 
	 */
	PLAY_TYPE() {
		potential = Randomizer.getRandomNumber(100);
	}

	/**
	 * Gets the potential that the defense will stop a play
	 * 
	 * @return the potential that the defense will stop a play
	 */
	public int getPotential() {
		return potential;
	}

	/**
	 * Gets a random defensive play type
	 * 
	 * @return a random play type for the defense to use
	 */
	public static PLAY_TYPE getRandomOffensivePlayType() {
		return values()[Randomizer.getRandomNumber(2)];
	}
	
	/**
	 * Gets a random defensive play type
	 * 
	 * @return a random play type for the defense to use
	 */
	public static PLAY_TYPE getRandomDefensivePlayType() {
		return values()[2 + Randomizer.getRandomNumber(4)];
	}
}

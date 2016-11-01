package game;

import java.util.Random;

/**
 * STUB for Randomizer
 * 
 * Made the whole class static so we don't have to pass it though parameters
 * -Joe D
 * 
 * @author (sbw)
 * @version (a version number or a date)
 */
public class Randomizer {

	/**
	 * Returns a random ass number
	 * 
	 * @param upperBoundExclusive
	 *            - the max value of the randomly returned value
	 * @return a random value based off of the given maximum
	 */
	public static int getRandomNumber(int upperBoundExclusive) {
		return new Random().nextInt(upperBoundExclusive);
	}

	/**
	 * Returns a random ass number
	 * 
	 * @param seed
	 *            - a random seed to randomize it even more
	 * @param upperBoundExclusive
	 *            - the max value of the randomly returned value
	 * @return a random value based off of the given maximum and seed
	 */
	public static int getRandomNumber(int seed, int upperBoundExclusive) {
		return new Random(seed).nextInt(upperBoundExclusive);
	}
}

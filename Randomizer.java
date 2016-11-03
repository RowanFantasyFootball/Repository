import java.util.Random;
/**
 * Randomizer.java
 * 
 * Made the whole class static so we don't have to pass it though parameters
 * 
 * 
 * @author Joe D
 * @version 
 */
public class Randomizer
{

	/**
	 * Returns a random number.
	 * 
	 * @param upperBoundExclusive the max value of the randomly returned value.
	 * @return a random value based off of the given maximum.
	 */
	public static int getRandomNumber(int upperBoundExclusive) {
		return new Random().nextInt(upperBoundExclusive);
	}

	/**
	 * Returns a random number.
	 * 
	 * @param seed a random seed to randomize it even more.
	 * @param upperBoundExclusive the max value of the randomly returned value.
	 * @return a random value based off of the given maximum and seed.
	 */
	public static int getRandomNumber(int seed, int upperBoundExclusive)
	{
		return new Random(seed).nextInt(upperBoundExclusive);
	}
}

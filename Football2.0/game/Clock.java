package game;

/**
 * Changed the use of the newQuarter variable. Changed quarter to an int,
 * newQuarter was previously pretty much a duplicate of the quarter variable.
 * Also, all integers are set to 0 be default in java, so no need to do that in
 * the constructor - Joe D
 */
public class Clock {
	/**
	 * The maximum amount of ticks in the game
	 */
	private int maxTicks;

	/**
	 * The ticks that have gone by on the clock
	 */
	private int ticks;

	/**
	 * The current quarter
	 */
	private int quarter;

	/**
	 * A counter to recognize when we are in the next quarter Initially set by
	 * maxTicks / 4
	 */
	private int nextQuarter;

	/**
	 * Creates a game clock for the football simulator
	 * 
	 * @param maxTicks
	 *            - the maximum amount of ticks you want the game to reach
	 */
	public Clock(int maxTicks) {
		this.maxTicks = maxTicks;
		changeQuarter();
	}

	/**
	 * Changes the quarter by incrementing quarter. Also changes the quarter
	 * length
	 */
	public void changeQuarter() {
		quarter++;
		nextQuarter += maxTicks / 4;
	}

	/**
	 * Increments by one tick
	 */
	public void tick() {
		ticks++;
	}

	/**
	 * Returns the current amount of game ticks that have passed
	 * 
	 * @return the current amount of game ticks that have went by in the game
	 */
	public int getTicks() {
		return ticks;
	}

	/**
	 * Gets the current quarter of the game
	 * 
	 * @return the current quarter in the game
	 */
	public int getQuarter() {
		return quarter;
	}

	/**
	 * Gets the game duration in terms of a tick
	 * 
	 * @return the amount of ticks the clock is counting to
	 */
	public int getGameDuration() {
		return maxTicks;
	}

	/**
	 * Returns true if the current quarter is over
	 * 
	 * @return true if the current quarter is over, false if not
	 */
	public boolean isQuarterOver() {
		return ticks >= nextQuarter;
	}

	/**
	 * Determines if the game is over or not
	 * 
	 * @return true if the game is over
	 */
	public boolean isRunning() {
		return ticks < maxTicks;
	}

	/**
	 * Gets the current quarter represented as a string
	 * 
	 * Uses a switch statement to switch through all possible values of quarter
	 * (1-4), then returns the string equivalent
	 * 
	 * @return the string equivalent of the current quarter in the game
	 */
	@Override
	public String toString() {
		switch (quarter) {
		case 1:
			return "Q1";
		case 2:
			return "Q2";
		case 3:
			return "Q3";
		case 4:
			return "Q4";
		}
		return "End of Game";
	}
}

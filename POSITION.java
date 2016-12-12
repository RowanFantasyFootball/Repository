/**
 * 
 * @author
 *
 */
public enum POSITION {

	/**
	 * Offense, has its lineup positons inside if it
	 */
	QUARTERBACK(1, 2, 1, 1), RUNNINGBACK(1, 3, 3, 3), WIDE_RECIEVER(1, 1, 1, 7), OFFENSIVE_LINEMAN(1, 1, 1, 2),

	/**
	 * Defense, has its lineup positons inside of it
	 */
	DEFENSIVE_LINEMAN(1, 2, 1, 6), DEFENSIVE_BACK(3, 8, 1, 5), LINEBACKER(2, 4, 1, 6);

	/**
	 * The lineup values to randomize
	 */
	private int xmin, xmax, ymin, ymax;

	/**
	 * 
	 * @param xmin
	 * @param xmax
	 * @param ymin
	 * @param ymax
	 */
	POSITION(int xmin, int xmax, int ymin, int ymax) {
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
	}

	/**
	 * Generate
	 * 
	 * @return
	 */
	public int getRandomXLocation() {
		return Randomizer.getRandomNumber(xmin, xmax);
	}

	/**
	 * 
	 * @return
	 */
	public int getRandomYLocation() {
		return Randomizer.getRandomNumber(ymin, ymax);
	}
}

package game;

/**
 * A class which keeps track of the drives progress
 * 
 * @author Joe Dunne
 */
public class DriveProgress {

	/**
	 * Starts on the 20 yard line, 30 because you have to account for the 10
	 * yards that the endzone take up
	 */
	public static final int STARTING_LINE_OF_SCRIMAGE = 30;

	/**
	 * The current y location of the current line of scrimage
	 */
	private int lineOfScrimage;

	/**
	 * The current down of the drive
	 */
	private int down;

	/**
	 * Creates a new offensive progress object which keeps track of the current
	 * offenses progress on the current drive
	 */
	public DriveProgress() {
		setLineOfScrimage(STARTING_LINE_OF_SCRIMAGE);
		resetDowns();
	}
	
	/**
	 * Gets the current line of scrimage
	 * 
	 * @return the current line of scrimage
	 */
	public int getLineOfScrimage() {
		return lineOfScrimage;
	}
	
	/**
	 * Tells you if the drive is over or not (down >= 4)
	 * 
	 * @return true if the drive is over
	 */
	public boolean isDriveOver() {
		return down >= 4;
	}
	
	/**
	 * Sets the line of scrimage to the specified line of scrim
	 * 
	 * @param lineOfScrimage - the line of scrimage to set the offenses line of scrimage to
	 */
	public void setLineOfScrimage(int lineOfScrimage) {
		this.lineOfScrimage = lineOfScrimage;
	}

	/**
	 * Resets the downs back to 1
	 */
	public void resetDowns() {
		down = 1;
	}

	/**
	 * Increments the current down
	 */
	public void nextDown() {
		down++;
	}
}

/**
 * A class which keeps track of the drives progress.
 * 
 * @author Joe Dunne
 */
public class DriveProgress 
{
	/**
	 * Starts on the 20 yard line.
	 */
	public static final int STARTING_LINE_OF_SCRIMMAGE = 30;

	/**
	 * The current 'y-axis' location of the current line of scrimmage.
	 */
	private int lineOfScrimage;

	/**
	 * The current down of the drive.
	 */
	private int down;

	/**
	 * Creates a new offensive progress object which keeps track of the current
	 * offenses' progress for the current drive.
	 */
	public DriveProgress() 
	{
		setLineOfScrimage(STARTING_LINE_OF_SCRIMMAGE);
		resetDowns();
	}
	
	/**
	 * Gets the current line of scrimmage.
	 * 
	 * @return the current line of scrimmage.
	 */
	public int getLineOfScrimage() 
	{
		return lineOfScrimage;
	}
	
	/**
	 * Tells you if the drive is over or not (down >= 4).
	 * 
	 * @return true if the drive is over
	 */
	public boolean isDriveOver() 
	{
		return down >= 4;
	}
	
	/**
	 * Sets the line of scrimmage to the specified line of scrimmage.
	 * 
	 * @param lineOfScrimage the line of scrimmage to set the offenses line of scrimmage.
	 */
	public void setLineOfScrimage(int lineOfScrimage) 
	{
		this.lineOfScrimage = lineOfScrimage;
	}

	/**
	 * Resets the downs back to 1.
	 */
	public void resetDowns() 
	{
		down = 1;
	}

	/**
	 * Increments the current down.
	 */
	public void nextDown() 
	{
		down++;
	}
}
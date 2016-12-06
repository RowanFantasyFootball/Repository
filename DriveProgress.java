/**
 * A class which keeps track of the drives progress.
 * 
 * @author Joe Dunne
 */
public class DriveProgress 
{
	/**
	 * Starts on the 30 yard line.
	 */
	public static final int STARTING_LINE_OF_SCRIMMAGE = 30;

	/**
	 * The current 'y-axis' location of the current line of scrimmage.
	 */
	private int lineOfScrimmage;

	/**
	 * The current down of the drive.
	 */
	private int down;
	
	/**
	 * yard on set of downs counter
	 */
	private int yardCounter = 0;

	/**
	 * Creates a new offensive progress object which keeps track of the current
	 * offenses' progress for the current drive.
	 */
	public DriveProgress() 
	{
		setLineOfScrimmage(STARTING_LINE_OF_SCRIMMAGE);
		resetDowns();
	}
	
	/**
	 * Gets the current line of scrimmage.
	 * 
	 * @return the current line of scrimmage.
	 */
	public int getLineOfScrimmage() 
	{
		return lineOfScrimmage;
	}
	
	/**
	 * Tells you if the drive is over or not (down > 4).
	 * 
	 * @return true if the drive is over
	 */
	public boolean isDriveOver() 
	{
		return down > 3; 
	}
	
	/**
	 * Sets the line of scrimmage to the specified line of scrimmage.
	 * 
	 * @param lineOfScrimage the line of scrimmage to set the offenses line of scrimmage.
	 */
	public void setLineOfScrimmage(int lineOfScrimmage) 
	{
		this.lineOfScrimmage = lineOfScrimmage;
	}

	/**
	 * Resets the downs back to 1.
	 */
	public void resetDowns() 
	{
		down = 0;
		yardCounter = 0;
	}

	/**
	 * Increments the current down.
	 */
	public void nextDown() 
	{
		down++;
	}
	
	/**
	 * returns downs
	 */
	public int getDowns()
	{
	    //with the sickness
	    return down;
	}
	
	/**
	 * adds to yard counter and checks if first down
	 */
	public void addToYardCounter(int yardsOnPlay)
	{
	    yardCounter = yardCounter + yardsOnPlay;
	    if(yardCounter > 9)
	    {
	        //first down
	        System.out.println("First Down"); 
	        resetDowns();
	    }
	}
}

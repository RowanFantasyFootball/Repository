import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Write a description of class Controller here.
 * 
 * @John (Jack) Donahue
 * @Gerald Miego
 * @Kevin Santana
 * @revision By: Joe Dunne & Tim McClintock
 */
public class Controller {
	/**
	 * The randomizer object to randomize the game activity.
	 */
	public static final Randomizer randomizer = new Randomizer();

	/**
	 * The delay between each game tick in milliseconds
	 */
	private static final int TICK_DELAY = 100;

	/**
	 * The max amount of game ticks
	 */
	private static final int MAX_GAME_TICKS = 500;

	/**
	 * The delay between each quarter
	 */
	private static final int QUARTER_CHANGE_DELAY = 5000;

	/**
	 * The time clock for the game
	 */
	private Clock clock;

	/**
	 * The home team
	 */
	private NFLTeam home;

	/**
	 * The away team
	 */
	private NFLTeam away;

	/**
	 * The field for the teams to play on
	 */
	//private Field field;

	/**
	 * The progress of the current drive
	 */
	private DriveProgress driveProgress;

	/**
	 * 
	 */
	private PlayerStat stats;

	/**
	 * 
	 */
	private Message msg;

	/**
	 * TODO: Create each individual Player object.
	 */

	/**
	 * Creates a controller instance which simulates a football game between two
	 * different teams
	 */
	public Controller() {
		stats = new PlayerStat();
		rand = new Randomizer();
		clock = new Clock(MAX_GAME_TICKS);
		loadTeams();
		start();
	}

	/**
	 * Runs the game.
	 * 
	 * MAX_GAME_TICKS longer game length.
	 * TICK_DELAY field if you want to have a longer time between each game tick.
	 */
	public void start()
	{
		initialize();

		while (clock.isRunning())
		{
			step();
		}
	}

	/**
	 * Initializes the game
	 * 1. Loads the teams
	 * 2. Flips the coin to determine who gets the ball first
	 * 3. Places the offense
	 * 4. Places the defense
	 */
	private void initialize() {
		loadTeams();
		flipCoin();
	}

	/**
	 * Places the defense onto the specified yard line
	 * 
	 * @param yardline the 'y-axis' location (yardline) that the players will line up on.
	 */
	private void placeDefense(int yardline)
	{
		/**
		 * TODO: Add Body.
		 */
	}

	/**
	 * Places the offense onto the specified yard line
	 * 
	 * @param yardline the 'y-axis' location (yardline) that the players will line up on.
	 */
	private void placeOffense(int yardline)
	{
		/**
		 * TODO: Add body.
		 */
	}

	private void flipCoin()
	{
		// TODO: Add body.

	}

	/**
	 * Where the game operates....
	 * 
	 * TODO:
	 * 1. ) Make sure messages from player stat works.
	 * 2. ) Add collision recognition.
	 * 3. ) (offense.getX() == defense.getX() && offense.getY() == defense.getY())
	 * 4. ) Add counter for downs.
	 * 5. ) If player is open for pass.
	 * 6. ) Keep track of score.
	 * 7. ) Keep track of yardage
	 * 8. ) Add defensive offense recognition (Make defensive paths somewhat mirror offensive paths)
	 * 9. ) Read through the list of Actors and tell each Actor to act accordingly?
	 */
	public void step()
	{
		operateClock();
		movePlayersToLineOfScrimage();
		operateOffense();
		operateDefense();
		operateDriveProgress();
		keepScore();

		/**
		 * TODO: Add More Body.
		 */
		runClock(); // This must always be last
	}

	/**
	 * 
	 */
	private void operateDriveProgress()
	{
		driveProgress.nextDown();

		if (driveProgress.isDriveOver())
		{
			swapOffenseAndDefense();
		}
	}

	/**
	 * 
	 */
	private void swapOffenseAndDefense()
	{
		// TODO: Add body.
	}

	/**
	 * 
	 */
	private void movePlayersToLineOfScrimage()
	{
		placeOffense(driveProgress.getLineOfScrimage());
		placeDefense(driveProgress.getLineOfScrimage() - 1);
	}

	/**
	 * 
	 */
	private void operateOffensiveProgess()
	{
		// TODO: Add body.

	}

	/**
	 * Runs the clock by ticking the clock and waiting the tick delay in
	 * milliseconds
	 */
	private void runClock()
	{
		clock.tick();
		wait(TICK_DELAY);
	}

	/**
	 * 
	 */
	private void keepScore()
	{
		NFLTeam offense;
	}

	/**
	 * Operates the clock
	 */
	private void operateClock()
	{
		/**
		 * Checks if the quarter is over, then changes it and waits for the next
		 * quarter to start
		 */
		if (clock.isQuarterOver())
		{
			clock.changeQuarter();
			wait(QUARTER_CHANGE_DELAY);
		}
	}

	/**
	 * Operates the offense (Calls act method on offensive players)
	 */
	private void operateOffense()
	{
		/**
		 * Gets a random play object which provides each actor with movements
		 */
		OffensivePlay offenseivePlay = OffensivePlaybook.getRandomPlay();
		/**
		 * Cycles through each actor on the field and operates them
		 */
		for (Actor actor : getOffensiveTeam().getOffense())
		{
			actor.act(offenseivePlay);
		}
	}

	/**
	 * Operates the defense (Calls act method on defensive players).
	 */
	private void operateDefense()
	{
		/**
		 * Gets a random defensive play from the Playbook.
		 */
		DefensivePlay defensivePlay = DefensivePlaybook.getRandomPlay();
		/**
		 * Cycles through each actor on the field and operates them.
		 */
		for (Actor actor : getDefensiveTeam().getDefense())
		{
			actor.act(defensivePlay);
		}
	}

	/**
	 * Gets the defensive team based on who has the ball.
	 * 
	 * @return the team currently on defense (Team without the ball).
	 */
	private NFLTeam getDefensiveTeam()
	{
		if (away.hasBall())
		{
			return home;
		}
		return away;
	}

	/**
	 * Gets the offensive team based on who has the ball.
	 * 
	 * @return the team currently on offense (Team with the ball).
	 */
	private NFLTeam getOffensiveTeam()
	{
		if (away.hasBall())
		{
			return away;
		}
		return home;
	}

	/**
	 * Allow the user to comprehend program on screen by waiting and allotted
	 * time.
	 * 
	 * @param millisec
	 *            the amount of time to wait.
	 */
	private void wait(int millisec)
	{
		try
		{
			Thread.sleep(millisec);
		}
		catch (InterruptedException e)
		{

		}
	}

	/**
	 * Simulates a coin flip 0 is heads 1 is tales
	 * 
	 * @param guess
	 *            input 0 or 1
	 * @return if the guess was correct
	 */
	public boolean simulateCoinFlip(int guess)
	{
		return Integer.valueOf(Randomizer.getRandomNumber(1)) == guess;
	}

	/**
	 * Create all player objects for each NFLTeam. Adds each player to their
	 * respective team while also creating a player object.
	 */
	public void loadTeams()
	{
	}
}

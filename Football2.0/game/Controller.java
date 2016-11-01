package game;

import java.util.ArrayList;
import java.util.LinkedList;

import actor.Actor;
import actor.player.Player;
import actor.player.types.defense.positions.DefensiveLineman;
import actor.player.types.offense.positions.OffensiveLineman;
import actor.player.types.offense.positions.QuarterBack;
import game.field.Field;
import plays.defense.DefensivePlay;
import plays.defense.DefensivePlaybook;
import plays.offense.OffensivePlay;
import plays.offense.OffensivePlaybook;
import teams.NFLTeam;

/**
 * Write a description of class Controller here.
 * 
 * @John (Jack) Donahue
 * @Gerald Miego
 * @Kevin Santana
 * @version (a version number or a date)
 */
public class Controller {

	/**
	 * The randomizer object to randomize game activity
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
	private Field field;

	/**
	 * The progress of the current drive
	 */
	private DriveProgress driveProgress;
	
	/**
	 * Player stats? Not sure what this is for, it already exists if the name is
	 * literal
	 */
	private PlayerStat stats;

	/**
	 * Someone explain to me what this is used for so we can get it working -
	 * - Joe D
	 */
	private Message msg;


	/**
	 * private ArrayList<Player> team1PlayerList; // Eagles team list private
	 * ArrayList<Player> team2PlayerList; // Cowboys team list
	 * 
	 * -Joe D Keeping these here as just an example, but they are not necessary
	 * There already exists player lists inside of the NFLTeam object
	 * 
	 * Simply call, NFLTeam.getOffense() or NFLTeam.getDefense() Joe and I have
	 * made it easy for you guys, the NFL Team class already handles the
	 * difference between players on offense and defense Look at the Docs for
	 * NFLTeam please and don't re-implement these they are repetetive
	 * 
	 * Note: Everything that I left in here is perfect for what we need to do,
	 * so leave it and work off that
	 */

	/**
	 * ***** OLD CONSTRUCTO ******
	 * 
	 * The Constructor for the Controller class. Initialize each instance
	 * variable and fill list of Actors. Create team1 and team2 (both default
	 * teams).
	 *
	 * public Controller() { // Instance Variables rand = new Randomizer(); //
	 * NOT an Actor stats = new PlayerStat(); clock = new Clock(); /** We don't
	 * need this -> actors = new ArrayList<Actor>(); NFLPlayer stores a list of
	 * players split by offense & defense, which all extend Actor. We can
	 * iterate over them by doing the following for (Actor a :
	 * NFLTeam.getOffense()) { a.act(); }
	 *
	 * teamSetUp();// Good - Joe D, Create each individual Player object
	 * 
	 * //(Not Necessary - Joe D) Add each Player from each team to list of
	 * Actors //None of the code below would work anyway, but ill leave it here
	 * as examples //actors.add((Actor)stats); // Probably an Actor
	 * //actors.add((Actor)team1.getPlayers()); // DOES NOT WORK!!!
	 * //actors.add((Actor)team2.getPlayers()); // also DOES NOT WORK!!!
	 * //actors.add((Actor)team1); //team // if update position part of skeleton
	 * works //actors.add((Actor)team2); //team // if update position part of
	 * skeleton works
	 * 
	 * run(); //Good }
	 */

	/**
	 * Creates a controller instance which simulates a football game between two
	 * different teams
	 */
	public Controller() {
		stats = new PlayerStat();
		clock = new Clock(MAX_GAME_TICKS);
		start();
	}

	/**
	 * Runs the game!!
	 * 
	 * Alter - MAX_GAME_TICKS if you want to have a longer game length, Alter -
	 * TICK_DELAY field if you want to have a longer time between each game tick
	 */
	public void start() {
		initialize();
		while (clock.isRunning()) {
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
	 * @param yardline
	 *            - the y location (yardline) that the players will line up on
	 */
	private void placeDefense(int yardline) {
		
	}

	/**
	 * Places the offense onto the specified yard line
	 * 
	 * @param yardline
	 *            - the y location (yardline) that the players will line up on
	 */
	private void placeOffense(int yardline) {
		
	}

	private void flipCoin() {
		// TODO Auto-generated method stub

	}

	/**
	 * Where the game operates....
	 * 
	 * TODO: Make sure messages from player stat works Add collision recognition
	 * (offense.getX() == defense.getX() && offense.getY() == defense.getY())
	 * Add counter for downs If player is open for pass Keep track of score Keep
	 * track of yardage Add defensive offense recognition (Make defensive paths
	 * somewhat mirror offensive paths)
	 * 
	 * 
	 * This is also perfect dont change it - Joe D
	 * 
	 * Read through the list of Actors and tell each Actor to act accordingly.
	 */
	public void step() {
		operateClock();
		movePlayersToLineOfScrimage();
		operateOffense();
		operateDefense();
		operateDriveProgress();
		keepScore();
		
		// Continue adding game code here
		
		
		runClock(); //This must always be last
	}

	/**
	 * 
	 */
	private void operateDriveProgress() {
		driveProgress.nextDown();
		if (driveProgress.isDriveOver()) {
			swapOffenseAndDefense();
		}
	}

	/**
	 * 
	 */
	private void swapOffenseAndDefense() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	private void movePlayersToLineOfScrimage() {
		placeOffense(driveProgress.getLineOfScrimage());
		placeDefense(driveProgress.getLineOfScrimage() - 1);
	}

	/**
	 * 
	 */
	private void operateOffensiveProgess() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Runs the clock by ticking the clock and waiting the tick delay in milliseconds
	 */
	private void runClock() {
		clock.tick();
		wait(TICK_DELAY);
	}

	/**
	 * 
	 */
	private void keepScore() {
		NFLTeam offense;
	}

	/**
	 * Operates the clock
	 */
	private void operateClock() {
		/**
		 * Checks if the quarter is over, then changes it and waits for the next
		 * quarter to start
		 */
		if (clock.isQuarterOver()) {
			clock.changeQuarter();
			wait(QUARTER_CHANGE_DELAY);
		}
	}

	/**
	 * Operates the offense (Calls act method on offensive players)
	 */
	private void operateOffense() {
		/**
		 * Gets a random play object which provides each actor with movements
		 */
		OffensivePlay offenseivePlay = OffensivePlaybook.getRandomPlay();
		/**
		 * Cycles through each actor on the field and operates them
		 */
		for (Actor actor : getOffensiveTeam().getOffense()) {
			actor.act(offenseivePlay);
		}
	}

	/**
	 * Operates the defense (Calls act method on defensive players)
	 */
	private void operateDefense() {
		/**
		 * Gets a random defensive play from the Playbook
		 */
		DefensivePlay defensivePlay = DefensivePlaybook.getRandomPlay();
		/**
		 * Cycles through each actor on the field and operates them
		 */
		for (Actor actor : getDefensiveTeam().getDefense()) {
			actor.act(defensivePlay);
		}
	}

	/**
	 * Gets the defensive team based on who has the ball
	 * 
	 * @return the team currently on defense (Team without the ball)
	 */
	private NFLTeam getDefensiveTeam() {
		if (away.hasBall()) {
			return home;
		}
		return away;
	}

	/**
	 * Gets the offensive team based on who has the ball
	 * 
	 * @return the team currently on offense (Team with the ball)
	 */
	private NFLTeam getOffensiveTeam() {
		if (away.hasBall()) {
			return away;
		}
		return home;
	}

	/**
	 * Allow the user to comprehend program on screen by waiting and alotted
	 * time.
	 * 
	 * @param millisec
	 *            - the amount of time to wait
	 */
	private void wait(int millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Simulates a coin flip
	 * 
	 * 0 is heads 1 is tales
	 * 
	 * @param guess
	 *            - input 0 or 1
	 * 
	 * @return if the guess was correct
	 */
	public boolean simulateCoinFlip(int guess) {
		return Integer.valueOf(Randomizer.getRandomNumber(1)) == guess;
	}

	/**
	 * Create all player objects for each NFLTeam OLD NOTE: This does not add
	 * each player to their team. It only creates the player objects. NEW NOTE:
	 * yes it does add each player to their respective team while also creating
	 * a player object
	 */
	public void loadTeams() {
		// home team
		home = new NFLTeam("Eagles");
		// defense
		home.addPlayerToDefense(new DefensiveLineman("Gary", "Shephard", 100, 876));
		home.addPlayerToDefense(new DefensiveLineman("ggg", "Shephard", 100, 100));
		home.addPlayerToDefense(new DefensiveLineman("234", "Shephard", 100, 100));
		home.addPlayerToDefense(new DefensiveLineman("aa", "Shephard", 100, 100));
		home.addPlayerToDefense(new DefensiveLineman("53", "Shephard", 100, 100));
		home.addPlayerToDefense(new DefensiveLineman("53", "Shephard", 100, 100));
		home.addPlayerToDefense(new DefensiveLineman("t3", "Shephard", 100, 100));
		home.addPlayerToDefense(new DefensiveLineman("Ga4ry", "Shephard", 100, 100));
		home.addPlayerToDefense(new DefensiveLineman("gss", "Shephard", 100, 100));
		home.addPlayerToDefense(new DefensiveLineman("Ga5ry", "Shephard", 100, 100));
		home.addPlayerToDefense(new DefensiveLineman("34", "Shephard", 100, 100));
		// offense
		home.addPlayerToOffense(new QuarterBack("Garyf23", "Shephard", 100, 100, 100));
		home.addPlayerToOffense(new OffensiveLineman("G23ary", "Shephard", 100, 100));
		home.addPlayerToOffense(new OffensiveLineman("Gary", "Shephard", 100, 100));
		home.addPlayerToOffense(new OffensiveLineman("Gart3y", "Shephard", 100, 100));
		home.addPlayerToOffense(new OffensiveLineman("Gary2", "Shephard", 100, 100));
		home.addPlayerToOffense(new OffensiveLineman("Ga1ry2", "Shephard", 100, 100));
		home.addPlayerToOffense(new OffensiveLineman("Ga553ry", "Shephard", 100, 100));
		home.addPlayerToOffense(new OffensiveLineman("Gar256 vy", "Shephard", 100, 100));
		home.addPlayerToOffense(new OffensiveLineman("Gary525c", "Shephard", 100, 100));
		home.addPlayerToOffense(new OffensiveLineman("Garc2535y", "Shephard", 100, 100));
		home.addPlayerToOffense(new OffensiveLineman("Gar5225y", "Shephard", 100, 100));

		// away team
		away = new NFLTeam("Cowboys");
		// defense
		away.addPlayerToDefense(new DefensiveLineman("Gary", "Shephard", 100, 100));
		away.addPlayerToDefense(new DefensiveLineman("ggg", "Shephard", 100, 100));
		away.addPlayerToDefense(new DefensiveLineman("234", "Shephard", 100, 100));
		away.addPlayerToDefense(new DefensiveLineman("aa", "Shephard", 100, 100));
		away.addPlayerToDefense(new DefensiveLineman("53", "Shephard", 100, 100));
		away.addPlayerToDefense(new DefensiveLineman("53", "Shephard", 100, 100));
		away.addPlayerToDefense(new DefensiveLineman("t3", "Shephard", 100, 100));
		away.addPlayerToDefense(new DefensiveLineman("Ga4ry", "Shephard", 100, 100));
		away.addPlayerToDefense(new DefensiveLineman("gss", "Shephard", 100, 100));
		away.addPlayerToDefense(new DefensiveLineman("Ga5ry", "Shephard", 100, 100));
		away.addPlayerToDefense(new DefensiveLineman("34", "Shephard", 100, 100));
		// offense
		away.addPlayerToOffense(new OffensiveLineman("Garyf23", "Shephard", 100, 100));
		away.addPlayerToOffense(new OffensiveLineman("G23ary", "Shephard", 100, 100));
		away.addPlayerToOffense(new OffensiveLineman("Gary", "Shephard", 100, 100));
		away.addPlayerToOffense(new OffensiveLineman("Gart3y", "Shephard", 100, 100));
		away.addPlayerToOffense(new OffensiveLineman("Gary2", "Shephard", 100, 100));
		away.addPlayerToOffense(new OffensiveLineman("Ga1ry2", "Shephard", 100, 100));
		away.addPlayerToOffense(new OffensiveLineman("Ga553ry", "Shephard", 100, 100));
		away.addPlayerToOffense(new OffensiveLineman("Gar256 vy", "Shephard", 100, 100));
		away.addPlayerToOffense(new OffensiveLineman("Gary525c", "Shephard", 100, 100));
		away.addPlayerToOffense(new OffensiveLineman("Garc2535y", "Shephard", 100, 100));
		away.addPlayerToOffense(new OffensiveLineman("Gar5225y", "Shephard", 100, 100));
	}
}

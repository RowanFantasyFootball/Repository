import java.util.Iterator;

/**
 * @author Joe Dunne - V2.0 Code implementation, V1.0 Created contructors
 * @author Joe Dementri - V2.0 Flow chart and Modeling, V1.0 Created a beast
 *         amount of accessors, too bad we didn't need them,
 * 
 *         This is an abstract class that will create a new player instance
 *         which will be placed into an NFLTeam object which will then be put
 *         onto the field to play the game.
 * 
 *         If you wish to instantiate a new player object, construct a new class
 *         which extends this class. [Ex.] DefensiveLineman lineman = new
 *         DefensiveLineman(params...);
 * 
 *         Current known classes which extend Player in this Version(2.0): ["->"
 *         stands for "is extended by"] [Ex:] Object (is extended by) -> String
 *         [OffensivePlayer] -> [OffensiveLineman, QuarterBack, RunningBack,
 *         TightEnd, WideReciever] [DefensivePlayer] -> [DefensiveLineman,
 *         DefensiveBack, Linebacker]
 * 
 * 
 * @version 2.0 **** Removed a lot of unnecessary variables **** Removed
 *          unnecessary constructor parameters **** Supplied getters for each
 *          stat that has been requested **** Upgraded the player class to
 *          something more powerful for the controller class
 * 
 *          **** IF YOU HAVE ANY QUESTIONS PLEASE EMAIL ME:
 *          DUNNEJ1@STUDENTS.ROWAN.EDU ****
 */
public class Player implements Actor {

	/**
	 * True if the player has the ball currently
	 */
	private boolean hasBall;

	/**
	 * 
	 */
	private Location lineup;

	/**
	 * 
	 */
	private Location end;

	/**
	 * The speed of the player
	 */
	private final int speed;

	/**
	 * The strength of the player
	 */
	private final int strength;

	/**
	 * The last name
	 */
	private final String last;

	/**
	 * The first name
	 */
	private final String first;

	/**
	 * The players position type
	 */
	private final POSITION TYPE;

	/**
	 * Creates a new player instance to be put into play baby
	 * 
	 * @param first
	 *            - the first name
	 * @param last
	 *            - the last name
	 * @param speed
	 *            - the speed of the player
	 * @param strength
	 *            - the strength of the player
	 * @param TYPE
	 *            - the position type of this player we want to create
	 */
	public Player(String first, String last, int speed, int strength, POSITION TYPE) {
		this.first = first;
		this.last = last;
		this.speed = speed;
		this.strength = strength;
		this.TYPE = TYPE;
	}

	/**
	 * Sets the player to having the ball if the parameter is true
	 * 
	 * @param ball
	 *            - pass in true if you want this player to have the ball
	 */
	public void setBall(boolean ball) {
		hasBall = ball;
	}

	/**
	 * Tells if the player has the ball or not
	 * 
	 * @return true if player has ball
	 */
	public boolean hasBall() {
		return hasBall;
	}

	/**
	 * Gets the first name of the player
	 * 
	 * @return the full name of the player
	 */
	public String getFirstName() {
		return first;
	}

	/**
	 * Gets the last name of the player
	 * 
	 * @return the last name of the player
	 */
	public String getLastName() {
		return last;
	}

	/**
	 * Debugs the player movement
	 * 
	 * @return the debugging string to make sure its working properly
	 */
	public String debug() {
		return toString() + " moved to (" + end.toString() + ")";
	}

	/**
	 * Gets the full name of the player and his overall
	 * 
	 * @return String in this format (First Last : Overall)
	 */
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}

	/**
	 * Gets the overall rank of a player
	 * 
	 * (speed + strength) / 2
	 * 
	 * @return the overall of this player
	 */
	public int getOverall() {
		return (getSpeed() + getStrength()) / 2;
	}

	/**
	 * Get Strength of the player
	 * 
	 * @return strength of player
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * Get Speed of the player
	 * 
	 * @return speed of player as int
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Gets the y position of the player
	 * 
	 * @return the players current y position
	 */
	public Location getEndLocation() {
		return end;
	}

	/**
	 * Gets the y position of the player
	 * 
	 * @return the players current y position
	 */
	public Location getLineupLocation() {
		return lineup;
	}

	/**
	 * Get the position of the player
	 * 
	 * @return the position of the player
	 */
	public POSITION getPosition() {
		return TYPE;
	}

	/**
	 * 
	 * @param lineup
	 */
	public void lineup(Location location) {
		this.lineup = location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Actor#act(Play)
	 */
	@Override
	public void act(Play play) {
		if (play.getBallCarrier() != null && play.getBallCarrier().toString().equals(toString())) {
			hasBall = true;
		}
		end = play.getMovement(this);
		System.out.println("Linedup: " + this.toString() + " @ " + end.toString());
	}
}
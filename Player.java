/**
 * @author Joe Dunne    - V2.0 Code implementation, 
 *                        V1.0 Created contructors
 * @author Joe Dementri - V2.0 Flow chart and Modeling, 
 *                        V1.0 Created a beast amount of accessors, too bad we didn't need them,
 * 
 * This is an abstract class that will create a new player instance which will be placed into an NFLTeam object
 * which will then be put onto the field to play the game.
 * 
 * If you wish to instantiate a new player object, construct a new class which extends this class.
 * [Ex.] DefensiveLineman lineman = new DefensiveLineman(params...);
 * 
 * Current known classes which extend Player in this Version(2.0): 
 * ["->" stands for "is extended by"]
 * [Ex:] Object (is extended by) -> String 
 * [OffensivePlayer] -> [OffensiveLineman, QuarterBack, RunningBack, TightEnd, WideReciever]
 * [DefensivePlayer] -> [DefensiveLineman, DefensiveBack, Linebacker]
 * 
 * 
 * @version 2.0
 * **** Removed a lot of unnecessary variables 
 * **** Removed unnecessary constructor parameters 
 * **** Supplied getters for each stat that has been requested
 * **** Upgraded the player class to something more powerful for the controller class
 * 
 * **** IF YOU HAVE ANY QUESTIONS PLEASE EMAIL ME: DUNNEJ1@STUDENTS.ROWAN.EDU ****
 */
public class Player implements Actor {
    /**
     * The speed of the player
     */
    private int speed;

    /**
     * The strength of the player
     */
    private int strength;

    /**
     * The last name
     */
    private String last;

    /**
     * The first name
     */
    private String first;
    
    /**
     * True if the player has posession of the ball
     */
    private boolean hasBall = false;
    
    /**
     * Coordinates for where player will move to during play
     */
    private int startingXCoordinate = 0;
    private int startingYCoordinate = 0;
    private int endingXCoordinate = 0;
    private int endingYCoordinate = 0;
    
    private POSITION playerPosition;

    /**
     * Creates a new player instance to be put on the field
     * 
     * @param POSITION_TYPE
     *            - the type of player it is
     * @param first
     *            - the first name
     * @param last
     *            - the last name
     * @param speed
     *            - the speed of the player
     * @param strength
     *            - the strength of the player
     */
    public Player(String first, String last, int speed, int strength, POSITION playerPosition)
    {
        this.playerPosition = playerPosition;
        this.last       = last;
        this.first      = first;
        this.speed      = speed;
        this.strength   = strength;
    }

    /**
     * Get the position of the player
     * 
     * @return the position of the player
     */
    public POSITION getPosition()
    {
        return playerPosition;
    }

    /**
     * 
     */
    public void setBall(boolean isTrue)
    {
        hasBall = isTrue;
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
     * Gets the full name of the player and his overall
     * 
     * @return String in this format (First Last : Overall)
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
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
     * Set the starting coordinate of the player to the center of the
     * Line of Scrimmage
     */
    public void setStartCoordinate(int xCoordinate, int yCoordinate) // based off of line of scrimmage
    {
        startingXCoordinate = xCoordinate;
        startingYCoordinate = yCoordinate;
    }
    
    /**
     * Set the movement pattern for the given player
     */
    public void setEndingCoordinate(int xCoordinate, int yCoordinate)
    {
        endingXCoordinate = startingXCoordinate + xCoordinate;
        endingYCoordinate = startingYCoordinate + yCoordinate;
    }

    /**
     * Get the movement pattern for the given player
     * NOTE: THIS WILL BE USED FOR TESTING PURPOSES TO MAKE SURE EACH PLAYER IS SET CORRECTLY
     */
    public String getMovementPattern()
    {
        String info = toString() + " has moved to (" + startingXCoordinate + ", " 
            + startingYCoordinate + ")";
        return info;
    }
    
    /**
     * Return the starting x-coordinate for the player
     * (used for matching offense and defense)
     */
    public int getXCoordinate()
    {
        return startingXCoordinate;
    }
    
    /**
     * Act method override
     */
    public void act(Play play)
    {
        //System.out.println("Using act method.");
        System.out.println(getMovementPattern());
    }
}
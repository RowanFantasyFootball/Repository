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
public abstract class Player implements Actor {
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
     * True if the player has the ball
     */
    private Football football;

    /**
     * Coordinates for where player will move to during play
     */
    private int startingXCoordinate = 0;
    private int startingYCoordinate = 0;
    private int endingXCoordinate = 0;
    private int endingYCoordinate = 0;

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
    public Player(String first, String last, int speed, int strength) {
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
    public abstract POSITION getPosition();

    /**
     * Gives or take a ball from the player
     * 
     * @param football
     *            - the football object being passed to this player
     */
    public void giveBallToPlayer(Football football) {
        this.football = football;
    }

    /**
     * Removes the football from the player
     */
    public void removeBallFromPlayer() {
        this.football = null;
    }

    /**
     * Tells if the player has the ball or not
     * 
     * @return true if player has ball
     */
    public boolean hasBall() {
        return football != null;
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
     * Set the movement pattern for the given player
     */
    public void setMovementPattern(int xCoordinate, int yCoordinate)
    {
        //Move the player to the (x,y) coordinate on the grid
        //NOTE: the (x,y) coordinate should be "x" more than the current spot and "y" more than the 
        //      current spot
        
        //startingXCoordinate = getCurrentXCoordinate();        // Must use the field object!!!
        //startingYCoordinate = getCurrentYCoordinate();        // Must use the field object!!!
        endingXCoordinate = startingXCoordinate + xCoordinate;
        endingYCoordinate = startingYCoordinate + yCoordinate;
    }

    /**
     * Get the movement pattern for the given player
     * NOTE: THIS WILL BE USED FOR TESTING PURPOSES TO MAKE SURE EACH PLAYER IS SET CORRECTLY
     */
    public String getMovementPattern()
    {
        String info = toString() + " will move from (" + startingXCoordinate + ", " 
            + startingYCoordinate + ") to (" + endingXCoordinate + ", " + endingYCoordinate +  ")";
        return info;
    }
}
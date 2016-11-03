import java.util.ArrayList;

/**
 * This is an abstract class (Not to be instantiated on its own) which 
 * creates a new Play object that assigns movements to each player on the team
 * 
 * @author Joe D
 */
public abstract class Play 
{
	/**
	 * The list of players being assigned movements
	 */
	protected ArrayList<Player> players;

	/**
	 * Creates a new play object with the players to assign movements to
	 * 
	 * @param players the list of players we want to assign movements to
	 */
	public Play(ArrayList<Player> players) 
	{
		this.players = players;
	}

	/**
	 * An abstract method to assign player movements to each player on the field
	 */
	public abstract void assignPlayerMovements();
}

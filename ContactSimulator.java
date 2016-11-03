/**
 * A class that contains a method to simulate contact between classes.
 * @author Joe Dunne
 */
public class ContactSimulator 
{
	/**
	 * Determines the victor of a collision between an offensive player and a defensive player
	 * 
	 * TODO: 
	 * 1. ) Needs more if statements to make a tackle more randomized. 
	 * 2. ) Right now, it is set to check a defenders overall against an offenders overall
	 *      to determine the victor of the collision.
	 * 
	 * @param offender the offender colliding with the defender.
	 * @param defender the defender colliding with the offender.
	 * 
	 * @return the player who has overpowered the other player
	 */
	public static Player simulateContact(Player offender, Player defender) 
	{
		if (defender.getOverall() > offender.getOverall()) 
		{
			return defender;
		}
		return offender;
	}
}
/**
 * A class that contains a method to simulate contact between Players
 * 
 * @author Joe Dunne
 * @revision by: John (Jack) Donahue
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
    private static int outcomeInt;
    /**
     * Constructor
     */
    public ContactSimulator()
    {
        //EMPTY JUST FOR OBJECT CREATION PURPOSES
    }
    
    /**
     * Simulate Contact between each player to determine play outcome
     */
    public static int simulateContact(NFLTeam offenseInput, NFLTeam defenseInput) 
    {
        outcomeInt = 0;
        NFLTeam offense = offenseInput;
        NFLTeam defense = defenseInput;
        for (int i = 0; i < offense.getOffense().size(); i++) // go through list of players
        {
            Player offender = offense.getOffense().get(i);
            Player defender = defense.getDefense().get(i);
            if (offender.getOverall() > defender.getOverall()) 
            {
                outcomeInt ++;
            }
        }
        return outcomeInt;
    }
}
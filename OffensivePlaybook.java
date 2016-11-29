import java.util.ArrayList;

/**
 * 
 * 
 * @author John (Jack) Donahue
 */
public class OffensivePlaybook 
{
    public ArrayList<Player> players;
    
    /**
     * Create different Play objects
     */
    private static OffensivePlay runOffense;
    private static OffensivePlay qbsneakOffense;
    private static OffensivePlay passOffense;
    
    /**
     * Constructor for OffensivePlaybook
     */
    public OffensivePlaybook(ArrayList<Player> players)
    {
        /**
         * Instantiate the different play objects
         */
        runOffense = new OffensivePlay(players, "run");
        qbsneakOffense = new OffensivePlay(players, "qbsneak");
        passOffense = new OffensivePlay(players, "pass");
    }
    
    /**
     * Gets a random offensive play.
     * 
     * @return
     */
    public static OffensivePlay getRandomPlay() 
    {
        switch(OFFENSIVE_PLAY_TYPE.getRandomOffensivePlayType()) 
        {
            case PASS:
            return passOffense;
            case QBSNEAK:
            return qbsneakOffense;
            case RUN:
            return runOffense;
            default:
            break;
        }
        return null;
    }
}
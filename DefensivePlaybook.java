import java.util.ArrayList;

/**
 * 
 * @author John (Jack) Donahue
 *
 */
public class DefensivePlaybook 
{
    public ArrayList<Player> players;
    
    /**
     * Create different Play objects
     */
    private static DefensivePlay manDefense;
    private static DefensivePlay zoneDefense;
    private static DefensivePlay cover4Defense;
    private static DefensivePlay blitzDefense;
    
    /**
     * Constructor for DefensivePlaybook
     */
    public DefensivePlaybook(ArrayList<Player> players)
    {
        /**
         * Instantiate the different play objects
         */
        manDefense = new DefensivePlay(players, "man");
        zoneDefense = new DefensivePlay(players, "zone");
        cover4Defense = new DefensivePlay(players, "cover4");
        blitzDefense = new DefensivePlay(players, "blitz");
    }
    
    /**
     * Gets a random offensive play.
     * 
     * @return
     */
    public static DefensivePlay getRandomPlay() 
    {
        switch(DEFENSIVE_PLAY_TYPE.getRandomDefensivePlayType()) 
        {
            case MAN:
            return manDefense;
            break;
            case ZONE:
            return zoneDefense;
            break;
            case COVER4:
            return cover4Defense;
            break;
            case BLITZ:
            return blitzDefense;
            break;
            default:
            break;
        }
        return null;
    }
}

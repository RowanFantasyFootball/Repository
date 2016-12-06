import java.util.ArrayList;

/**
 * A class that determines movements for each position based on the current play
 * 
 * @author John (Jack) Donahue
 */

public class DefensivePlay extends Play 
{
    /**
     * The maximum value of the defense's potential to stop an offensive play
     */
    public static final int MAX_STOPPING_POTENTIAL = 500; // not sure how this will be used???
    public String currentPlay;

    public DefensivePlay(ArrayList<Player> players, String playType) 
    {
        super(players);
        currentPlay = playType;
    }

    @Override
    public void assignPlayerMovements() 
    {
        //determine current play
        switch (currentPlay)
        {
            case "man":
            assignManMovements();
            break;
            case "zone":
            assignZoneMovements();
            break;
            case "cover4":
            assignCover4Movements();
            break;
            case "blitz":
            assignBlitzMovements();
            break;
            default:
            assignManMovements();
        }
    }

    /**
     * Assign player movements for Man Defense
     * NOTE: This is temporary!
     *      Thinking of a way to have the defensive players follow their offenders
     */
    private void assignManMovements()
    {
        for (int i = 0; i < players.size(); i++) // go through list of players
        {
            Player currentPlayer = players.get(i);
            switch(currentPlayer.getPosition()) // find current player's position
            {
                case DEFENSIVE_LINEMAN:
                currentPlayer.setEndingCoordinate(-1,2);
                break;
                case DEFENSIVE_BACK:
                currentPlayer.setEndingCoordinate(1,-3);
                break;
                case LINEBACKER:
                currentPlayer.setEndingCoordinate(3,4);
                break;
                case CORNER:
                currentPlayer.setEndingCoordinate(2,-5);
                break;
                case SAFETY:
                currentPlayer.setEndingCoordinate(6,-2);
                break;
                default:
                break;
            }
        }
    }
    
    /**
     * Assign player movements for Zone Defense
     * NOTE: This is temporary!
     *      Thinking of a way to have the defensive players follow their offenders
     */
    private void assignZoneMovements()
    {
        for (int i = 0; i < players.size(); i++) // go through list of players
        {
            Player currentPlayer = players.get(i);
            switch(currentPlayer.getPosition()) // find current player's position
            {
                case DEFENSIVE_LINEMAN:
                currentPlayer.setEndingCoordinate(-1,2);
                break;
                case DEFENSIVE_BACK:
                currentPlayer.setEndingCoordinate(1,-3);
                break;
                case LINEBACKER:
                currentPlayer.setEndingCoordinate(3,4);
                break;
                case CORNER:
                currentPlayer.setEndingCoordinate(2,-5);
                break;
                case SAFETY:
                currentPlayer.setEndingCoordinate(6,-2);
                break;
                default:
                break;
            }
        }
    }
    
    /**
     * Assign player movements for Cover4 Defense
     * NOTE: This is temporary!
     *      Thinking of a way to have the defensive players follow their offenders
     */
    private void assignCover4Movements()
    {
        for (int i = 0; i < players.size(); i++) // go through list of players
        {
            Player currentPlayer = players.get(i);
            switch(currentPlayer.getPosition()) // find current player's position
            {
                case DEFENSIVE_LINEMAN:
                currentPlayer.setEndingCoordinate(-1,2);
                break;
                case DEFENSIVE_BACK:
                currentPlayer.setEndingCoordinate(1,-3);
                break;
                case LINEBACKER:
                currentPlayer.setEndingCoordinate(3,4);
                break;
                case CORNER:
                currentPlayer.setEndingCoordinate(2,-5);
                break;
                case SAFETY:
                currentPlayer.setEndingCoordinate(6,-2);
                break;
                default:
                break;
            }
        }
    }
    
    /**
     * Assign player movements for Man Defense
     * NOTE: This is temporary!
     *      Thinking of a way to have the defensive players follow their offenders
     */
    private void assignBlitzMovements()
    {
        for (int i = 0; i < players.size(); i++) // go through list of players
        {
            Player currentPlayer = players.get(i);
            switch(currentPlayer.getPosition()) // find current player's position
            {
                case DEFENSIVE_LINEMAN:
                currentPlayer.setEndingCoordinate(-1,2);
                break;
                case DEFENSIVE_BACK:
                currentPlayer.setEndingCoordinate(-1,1);
                break;
                case LINEBACKER:
                currentPlayer.setEndingCoordinate(-1,-2);
                break;
                case CORNER:
                currentPlayer.setEndingCoordinate(-1,3);
                break;
                case SAFETY:
                currentPlayer.setEndingCoordinate(-1,-4);
                break;
                default:
                break;
            }
        }
    }
}
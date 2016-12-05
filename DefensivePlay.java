import java.util.ArrayList;

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
            case "zone":
            assignZoneMovements();
            case "cover4":
            assignCover4Movements();
            case "blitz":
            assignBlitzMovements();
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
                currentPlayer.setMovementPattern(-2,0);
                case DEFENSIVE_BACK:
                currentPlayer.setMovementPattern(-2,0);
                case LINEBACKER:
                currentPlayer.setMovementPattern(-2,0);
                case CORNER:
                currentPlayer.setMovementPattern(-2,0);
                case SAFETY:
                currentPlayer.setMovementPattern(-2,0);
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
                currentPlayer.setMovementPattern(-2,0);
                case DEFENSIVE_BACK:
                currentPlayer.setMovementPattern(-2,0);
                case LINEBACKER:
                currentPlayer.setMovementPattern(-2,0);
                case CORNER:
                currentPlayer.setMovementPattern(-2,0);
                case SAFETY:
                currentPlayer.setMovementPattern(-2,0);
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
                currentPlayer.setMovementPattern(-2,0);
                case DEFENSIVE_BACK:
                currentPlayer.setMovementPattern(-2,0);
                case LINEBACKER:
                currentPlayer.setMovementPattern(-2,0);
                case CORNER:
                currentPlayer.setMovementPattern(-2,0);
                case SAFETY:
                currentPlayer.setMovementPattern(-2,0);
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
                currentPlayer.setMovementPattern(-2,0);
                case DEFENSIVE_BACK:
                currentPlayer.setMovementPattern(-2,0);
                case LINEBACKER:
                currentPlayer.setMovementPattern(-2,0);
                case CORNER:
                currentPlayer.setMovementPattern(-2,0);
                case SAFETY:
                currentPlayer.setMovementPattern(-2,0);
                default:
                break;
            }
        }
    }
}
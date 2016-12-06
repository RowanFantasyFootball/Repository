import java.util.ArrayList;

/**
 * A class that determines movements for each position based on the current play
 * 
 * @author John (Jack) Donahue
 */
public class OffensivePlay extends Play 
{
    public String currentPlay;
    public OffensivePlay(ArrayList<Player> players, String playType) 
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
            case "run":
            assignRunMovements();
            break;
            case "pass":
            assignPassMovements();
            break;
            case "qbsneak":
            assignQBSneakMovements();
            break;
            default:
            assignRunMovements();
        }
    }   

    /**
     * Assign player movements for a Run play
     */
    private void assignRunMovements()
    {
        for (int i = 0; i < players.size(); i++) // go through list of players
        {
            Player currentPlayer = players.get(i);
            switch(currentPlayer.getPosition()) // find current player's position
            {
                case QUARTERBACK:
                currentPlayer.setEndingCoordinate(-2,0); //move QB straight back 2 yards
                break;
                case RUNNINGBACK:
                currentPlayer.setEndingCoordinate(-2,0);
                break;
                case WIDERECIEVER:
                currentPlayer.setEndingCoordinate(-2,0);
                break;
                case TIGHTEND:
                currentPlayer.setEndingCoordinate(-2,0);
                break;
                case OFFENSIVE_LINEMAN:
                currentPlayer.setEndingCoordinate(-2,0);
                break;
                default:
                break;
            }
        }
    }
    
    /**
     * Assign player movements for a Pass play
     */
    private void assignPassMovements()
    {
        // ALL MOVEMENT PATTERNS ARE JUST TEMPORARY VARIABLES!
        // MUST DISCUSS ACTUAL MOVEMENTS (this is just to get the code running
        for (int i = 0; i < players.size(); i++) // go through list of players
        {
            Player currentPlayer = players.get(i);
            switch(currentPlayer.getPosition()) // find current player's position
            {
                case QUARTERBACK:
                currentPlayer.setEndingCoordinate(-2,0); //move QB straight back 2 yards
                break;
                case RUNNINGBACK:
                currentPlayer.setEndingCoordinate(10,5);
                break;
                case WIDERECIEVER:
                currentPlayer.setEndingCoordinate(25,-3);
                break;
                case TIGHTEND:
                currentPlayer.setEndingCoordinate(5,5);
                break;
                case OFFENSIVE_LINEMAN:
                currentPlayer.setEndingCoordinate(0,0);
                break;
                default:
                break;
            }
        }
    }
    
    /**
     * Assign player movements for a QB-Sneak play
     */
    private void assignQBSneakMovements()
    {
        for (int i = 0; i < players.size(); i++) // go through list of players
        {
            Player currentPlayer = players.get(i);
            switch(currentPlayer.getPosition()) // find current player's position
            {
                case QUARTERBACK:
                currentPlayer.setEndingCoordinate(-2,0); //move QB straight back 2 yards
                break;
                case RUNNINGBACK:
                currentPlayer.setEndingCoordinate(-2,0); //move the 
                break;
                case WIDERECIEVER:
                currentPlayer.setEndingCoordinate(-2,0);
                break;
                case TIGHTEND:
                currentPlayer.setEndingCoordinate(-2,0);
                break;
                case OFFENSIVE_LINEMAN:
                currentPlayer.setEndingCoordinate(-2,0);
                break;
                default:
                break;
            }
        }
    }
}

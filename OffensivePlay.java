import java.util.ArrayList;

/**
 * A class that determines movements for each position based on the current play
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
            case "pass":
            assignPassMovements();
            case "qbsneak":
            assignQBSneakMovements();
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
                currentPlayer.setMovementPattern(-2,0); //move QB straight back 2 yards
                case RUNNINGBACK:
                currentPlayer.setMovementPattern(-2,0);
                case WIDERECIEVER:
                currentPlayer.setMovementPattern(-2,0);
                case TIGHTEND:
                currentPlayer.setMovementPattern(-2,0);
                case OFFENSIVE_LINEMAN:
                currentPlayer.setMovementPattern(-2,0);
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
                currentPlayer.setMovementPattern(-2,0); //move QB straight back 2 yards
                case RUNNINGBACK:
                currentPlayer.setMovementPattern(10,5);
                case WIDERECIEVER:
                currentPlayer.setMovementPattern(25,-3);
                case TIGHTEND:
                currentPlayer.setMovementPattern(5,5);
                case OFFENSIVE_LINEMAN:
                currentPlayer.setMovementPattern(0,0);
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
                currentPlayer.setMovementPattern(-2,0); //move QB straight back 2 yards
                case RUNNINGBACK:
                currentPlayer.setMovementPattern(-2,0); //move the 
                case WIDERECIEVER:
                currentPlayer.setMovementPattern(-2,0);
                case TIGHTEND:
                currentPlayer.setMovementPattern(-2,0);
                case OFFENSIVE_LINEMAN:
                currentPlayer.setMovementPattern(-2,0);
                default:
                break;
            }
        }
    }
}

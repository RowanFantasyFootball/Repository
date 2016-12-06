import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * The main controls for the Football game.
 * The Controller class creates instances of Players, Teams, Play Types, etc.
 * Loads each individual player into a given team, loops through actors to represent gameplay, and communicates between classes.
 * 
 * @author John (Jack) Donahue
 * @author Gerald Miego
 * @revision By: Joe Dunne & Tim McClintock
 */
public class Controller {
    /**
     * The randomizer object to randomize the game activity.
     */
    public static final Randomizer randomizer = new Randomizer();

    /**
     * The delay between each game tick in milliseconds
     */
    private static final int TICK_DELAY = 100;

    /**
     * The max amount of game ticks
     */
    private static final int MAX_GAME_TICKS = 500;

    /**
     * The delay between each quarter
     */
    private static final int QUARTER_CHANGE_DELAY = 5000;

    /**
     * The time clock for the game
     */
    private Clock clock;

    /**
     * The home team
     */
    private NFLTeam home;

    /**
     * The away team
     */
    private NFLTeam away;

    /**
     * The field for the teams to play on
     */
    //private Field field;

    /**
     * The progress of the current drive
     */
    private DriveProgress driveProgress;

    /**
     * 
     */
    private PlayerStat stats;

    /**
     * 
     */
    private Message msg;

    /**
     * Contact Simulator for determining play outcome
     */
    private ContactSimulator contactSimulator;

    /**
     * home score
     */
    private int homeScore=0;

    /**
     * away score
     */
    private int awayScore=0;

    //private GUI gui;

    /**
     * TODO:
     * Edit player positions to ACTUAL POSITIONS
     */

    /**
     * Creates a controller instance which simulates a football game between two
     * different teams
     */
    public Controller() {
        stats = new PlayerStat();
        clock = new Clock(MAX_GAME_TICKS);
        contactSimulator = new ContactSimulator();
        loadTeams();
        //gui = new GUI();
        start();
        home.getOffense().get(1).setBall(true);
    }

    /**
     * Runs the game.
     * 
     * MAX_GAME_TICKS longer game length.
     * TICK_DELAY field if you want to have a longer time between each game tick.
     */
    public void start()
    {
        initialize();
        while (clock.isRunning())
        {
            step();
        }
        System.out.println("Final score home team : " + homeScore + " away team :" + awayScore);
    }

    /**
     * Initializes the game
     * 1. Loads the teams
     * 2. Flips the coin to determine who gets the ball first
     * 3. Places the offense
     * 4. Places the defense
     */
    private void initialize() 
    {
        driveProgress = new DriveProgress();
        loadTeams();
        flipCoin();
    }

    /**
     * Places the defense onto the specified yard line
     * 
     * @param yardline the 'y-axis' location (yardline) that the players will line up on.
     */
    private void placeDefense(int yardline)
    {
        System.out.println("Defense placed at " + yardline + " yardline.");
        int los = driveProgress.getLineOfScrimmage();

        for (int i = 0; i < getDefensiveTeam().getDefense().size(); i++) // go through list of players
        {
            Player currentPlayer = getDefensiveTeam().getDefense().get(i);
            switch(currentPlayer.getPosition()) // find current player's position
            {
                case DEFENSIVE_LINEMAN:
                currentPlayer.setStartCoordinate(los+1,0);
                break;
                case DEFENSIVE_BACK:
                currentPlayer.setStartCoordinate(los+1,4);
                break;
                case LINEBACKER:
                currentPlayer.setStartCoordinate(los+1,-1);
                break;
                case CORNER:
                currentPlayer.setStartCoordinate(los+1,-4);
                break;
                case SAFETY:
                currentPlayer.setStartCoordinate(los+1,3);
                break;
                default:
                break;
            }
        }
    }

    /**
     * Places the offense onto the specified yard line
     * 
     * @param yardline the 'y-axis' location (yardline) that the players will line up on.
     */
    private void placeOffense(int yardline)
    {
        System.out.println("Offense placed at " + yardline + " yardline.");
        int los = driveProgress.getLineOfScrimmage();

        for (int i = 0; i < getOffensiveTeam().getOffense().size(); i++) // go through list of players
        {
            Player currentPlayer = getOffensiveTeam().getOffense().get(i);
            switch(currentPlayer.getPosition()) // find current player's position
            {
                case QUARTERBACK:
                currentPlayer.setStartCoordinate(los-1,0);
                break;
                case RUNNINGBACK:
                currentPlayer.setStartCoordinate(los-2,0);
                break;
                case WIDERECIEVER:
                currentPlayer.setStartCoordinate(los,5);
                break;
                case TIGHTEND:
                currentPlayer.setStartCoordinate(los,-3);
                break;
                case OFFENSIVE_LINEMAN:
                currentPlayer.setStartCoordinate(los,-5);
                break;
                default:
                break;
            }
        }
    }

    private void flipCoin()
    {
        randomizer.getRandomNumber(2); // Not sure if this is supposed to be 1 or 2
    }

    /**
     * Where the game operates....
     * 
     * TODO:
     * 1. ) Make sure messages from player stat works.
     * 2. ) Add collision recognition.
     * 3. ) (offense.getX() == defense.getX() && offense.getY() == defense.getY())
     * 4. ) Add counter for downs.
     * 5. ) If player is open for pass.
     * 6. ) Keep track of score.
     * 7. ) Keep track of yardage
     * 8. ) Add defensive offense recognition (Make defensive paths somewhat mirror offensive paths)
     * 9. ) Read through the list of Actors and tell each Actor to act accordingly?
     */
    public void step()
    {
        operateClock();
        movePlayersToLineOfScrimmage();
        operateOffense();
        operateDefense();
        determinePlayOutcome();
        operateDriveProgress();

        runClock(); // This must always be last
    }

    /**
     * Check for next down. If the next down is greater than 4, swap offense and defense
     */
    private void operateDriveProgress()
    {
        driveProgress.nextDown(); // add 1 to the downs (the next down)

        if(driveProgress.getLineOfScrimmage() > 99)
        {
            NFLTeam scoringTeam = getOffensiveTeam();
            //touchdown home team
            if(scoringTeam.equals(home))
            {
                homeScore = homeScore + 7; 
                System.out.println("Yay the home team scored, the score is now " + homeScore + " - " + awayScore);
                //create a new message for this
                //stats.addMessage(new Message(3, *player object*, clock.getTicks(), *yardage*, *ball position*));
            } 
            else
            {
                awayScore = awayScore + 7;
                System.out.println("Yay the home team scored, the score is now " + homeScore + " - " + awayScore);
                //create a new message for this
            }
            swapOffenseAndDefense();
            driveProgress.resetDowns();
            driveProgress.setLineOfScrimmage(30);
        }
        if (driveProgress.isDriveOver())
        {
            swapOffenseAndDefense();
            driveProgress.resetDowns();
        }
        System.out.println("It is now down " + (driveProgress.getDowns() + 1));
    }

    /**
     * Swap the posession of the ball
     */
    private void swapOffenseAndDefense()
    {
        NFLTeam offense = getOffensiveTeam();
        if (home.equals(offense)) // home team is currently offense
        {
            //take ball from offense
            for (int i = 0; i < home.getOffense().size(); i++) // go through list of players
            {
                Player currentPlayer = home.getOffense().get(i);
                currentPlayer.setBall(false);
            }

            for (int i = 0; i < away.getOffense().size(); i++) // go through list of players
            {
                Player currentPlayer = away.getOffense().get(i);
                switch(currentPlayer.getPosition()) // find current player's position
                {
                    case QUARTERBACK:
                    currentPlayer.setBall(true);

                    break;
                    default:
                    break;
                }
            }
            driveProgress.setLineOfScrimmage(100 - driveProgress.getLineOfScrimmage());
        }
        else if(away.equals(offense))// home team is currently defense
        {
            //take ball from offense

            for (int i = 0; i < away.getOffense().size(); i++) // go through list of players
            {
                Player currentPlayer = away.getOffense().get(i);
                currentPlayer.setBall(false);
            }

            for (int i = 0; i < home.getOffense().size(); i++) // go through list of players
            {
                Player currentPlayer = home.getOffense().get(i);
                switch(currentPlayer.getPosition()) // find current player's position
                {
                    case QUARTERBACK:
                    currentPlayer.setBall(true);

                    break;
                    default:
                    break;
                }
            }
            driveProgress.setLineOfScrimmage(100 - driveProgress.getLineOfScrimmage());
        }
    }

    /**
     * Determine the outcome of the current play.
     * If the play outcome number is greater than or equal to the number of players,
     *      move line of scrimmage forward
     *      else, move line of scrimmage backwards or not at all
     */
    private void determinePlayOutcome()
    {
        NFLTeam offense = getOffensiveTeam();
        NFLTeam defense = getDefensiveTeam();
        int los = driveProgress.getLineOfScrimmage();
        int outcome = contactSimulator.simulateContact(offense, defense);
        if (outcome >= 5)
        {
            //move line of scrimmage forward (between 1 and 20 yards)
            int randomAdd = Randomizer.getRandomNumber(10);
            driveProgress.setLineOfScrimmage(los+randomAdd);
            driveProgress.addToYardCounter(randomAdd);
            System.out.println("A " + randomAdd + " yard play.");
        }
        else
        {
            //move line of scrimmage backwards (between zero and 5)
            int randomSub = Randomizer.getRandomNumber(5);
            driveProgress.setLineOfScrimmage(los-randomSub);
            driveProgress.addToYardCounter(-randomSub);
        }
    }

    /**
     * 
     */
    private void movePlayersToLineOfScrimmage()
    {
        placeOffense(driveProgress.getLineOfScrimmage());
        placeDefense(driveProgress.getLineOfScrimmage() - 1);
    }

    /**
     * Runs the clock by ticking the clock and waiting the tick delay in
     * milliseconds
     */
    private void runClock()
    {
        clock.tick();
        wait(TICK_DELAY);
    }

    /**
     * Operates the clock
     */
    private void operateClock()
    {
        /**
         * Checks if the quarter is over, then changes it and waits for the next
         * quarter to start
         */
        if (clock.isQuarterOver())
        {
            clock.changeQuarter();
            wait(QUARTER_CHANGE_DELAY);
        }
    }

    /**
     * Operates the offense (Calls act method on offensive players)
     */
    private void operateOffense()
    {
        /**
         * Gets a random play object which provides each actor with movements
         */
        OffensivePlay offensivePlay = new OffensivePlaybook(getOffensiveTeam().getOffense()).getRandomPlay(); // can be run, pass, qbsneak
        /**
         * Cycles through each offensive actor on the field and operates them
         */
        for (Actor actor : getOffensiveTeam().getOffense())
        {
            actor.act(offensivePlay);
        }
    }

    /**
     * Operates the defense (Calls act method on defensive players).
     */
    private void operateDefense()
    {
        /**
         * Gets a random defensive play from the Playbook.
         */
        DefensivePlay defensivePlay = new DefensivePlaybook(getDefensiveTeam().getDefense()).getRandomPlay();
        /**
         * Cycles through each defensive actor on the field and operates them.
         */
        for (Actor actor : getDefensiveTeam().getDefense())
        {
            actor.act(defensivePlay);
        }
    }

    /**
     * Gets the defensive team based on who has the ball
     * 
     * revision by David Lackey 
     * NFLTeam doesn't have a hasBall() method but Player does.
     * 
     * We need to check the entire away team to see if any of the away 
     * players have the ball (hasBall() = true)
     */
    private NFLTeam getDefensiveTeam()
    {
        ArrayList<Player> awayDefense = away.getDefense();  //arrayList of away Defensive Players
        ArrayList<Player> awayOffense = away.getOffense();  //arrayList of away Offensive Players

        ArrayList<Player> awayTeam = new ArrayList<>();
        awayTeam.addAll(awayDefense);
        awayTeam.addAll(awayOffense);                      //concatenated arrayList of entire away team

        Iterator<Player> it = awayTeam.iterator();

        /**
         * if any away player has the ball, the team on defense is the home team.
         * otherwise the team on defense is the away team
         */
        while (it.hasNext()){
            Player awayPlayer = it.next();
            if (awayPlayer.hasBall()){
                return home;
            }
        }
        return away;
    }

    /**
     * Gets the offensive team based on who has the ball
     * 
     * revision by David Lackey 
     * NFLTeam doesn't have a hasBall() method but Player does.
     * 
     * We need to check the entire away team to see if any of the away 
     * players have the ball (hasBall() = true)
     */
    private NFLTeam getOffensiveTeam()
    {
        ArrayList<Player> awayDefense = away.getDefense();  //arrayList of away Defensive Players
        ArrayList<Player> awayOffense = away.getOffense();  //arrayList of away Offensive Players

        ArrayList<Player> awayTeam = new ArrayList<>();
        awayTeam.addAll(awayDefense);
        awayTeam.addAll(awayOffense);                      //concatenated arrayList of entire away team

        Iterator<Player> it = awayTeam.iterator();

        /**
         * if any away player has the ball, the team on offense is the away team.
         * otherwise the team on offense is the home team
         */
        while (it.hasNext()){
            Player awayPlayer = it.next();
            if (awayPlayer.hasBall()){
                return away;
            }
        }
        return home;
    }

    /**
     * Allow the user to comprehend program on screen by waiting and allotted
     * time.
     * 
     * @param millisec
     *            the amount of time to wait.
     */
    private void wait(int millisec)
    {
        try
        {
            Thread.sleep(millisec);
        }
        catch (InterruptedException e)
        {
            // No statement needed
        }
    }

    /**
     * Simulates a coin flip 0 is heads 1 is tales
     * 
     * @param guess
     *            input 0 or 1
     * @return if the guess was correct
     */
    public boolean simulateCoinFlip(int guess)
    {
        return Integer.valueOf(Randomizer.getRandomNumber(1)) == guess;
    }

    /**
     * Create all player objects for each NFLTeam. Adds each player to their
     * respective team while also creating a player object.
     */
    public void loadTeams()
    {
        // home team

        //Defense
        home = new NFLTeam("Eagles");
        home.addPlayerToDefense(new Player("Connor", "Barwin", 81, 80, POSITION.DEFENSIVE_LINEMAN));            //LE
        home.addPlayerToDefense(new Player("Bennie", "Logan", 68, 88, POSITION.DEFENSIVE_BACK));             //DT           
        home.addPlayerToDefense(new Player("Fletcher", "Cox", 79, 86, POSITION.DEFENSIVE_BACK));             //DT           
        home.addPlayerToDefense(new Player("Brandon", "Graham", 80, 78, POSITION.DEFENSIVE_LINEMAN));           //RE     
        home.addPlayerToDefense(new Player("Jordan", "Hicks", 83, 76, POSITION.DEFENSIVE_LINEMAN));             //MLB 
        home.addPlayerToDefense(new Player("Mychal", "Kendricks",88, 74, POSITION.DEFENSIVE_LINEMAN));          //LOLB
        home.addPlayerToDefense(new Player("Nigel", "Bradham",85, 72, POSITION.DEFENSIVE_LINEMAN));             //ROLB
        home.addPlayerToDefense(new Player("Nolan", "Carroll III",89, 52, POSITION.CORNER));         //CB
        home.addPlayerToDefense(new Player("Leodis", "McKelvin",88, 52, POSITION.CORNER));           //CB
        home.addPlayerToDefense(new Player("Rodney", "McLeod Jr.",86, 56, POSITION.SAFETY));         //SS
        home.addPlayerToDefense(new Player("Malcolm", "Jenkins", 86, 64, POSITION.SAFETY));          //FS

        //Offense
        //Quarter Back?
        home.addPlayerToOffense(new Player("Carson", "Wentz", 82, 72, POSITION.QUARTERBACK));             //QB     
        home.addPlayerToOffense(new Player("Ryan", "Mathews", 89, 73, POSITION.RUNNINGBACK));             //HB      
        home.addPlayerToOffense(new Player("Jordan", "Matthews", 90, 68, POSITION.WIDERECIEVER));          //WR
        home.addPlayerToOffense(new Player("Nelson", "Agholor", 91, 64, POSITION.WIDERECIEVER));           //WR    
        home.addPlayerToOffense(new Player("Josh", "Huff", 90, 60, POSITION.WIDERECIEVER));                //WR         
        home.addPlayerToOffense(new Player("Zach", "Ertz", 80, 73, POSITION.TIGHTEND));                //TE         
        home.addPlayerToOffense(new Player("Jason", "Kelce", 73, 86, POSITION.TIGHTEND));               //C       
        home.addPlayerToOffense(new Player("Jason", "Peters", 67, 96, POSITION.OFFENSIVE_LINEMAN));             //LT      
        home.addPlayerToOffense(new Player("Barrett", "Jones", 56, 82, POSITION.OFFENSIVE_LINEMAN));            //LG     
        home.addPlayerToOffense(new Player("Lane", "Johnson", 80, 86, POSITION.OFFENSIVE_LINEMAN));             //RT      
        home.addPlayerToOffense(new Player("Brandon", "Brooks", 70, 95, POSITION.OFFENSIVE_LINEMAN));           //RG

        // away team
        away = new NFLTeam("Cowboys");

        //Defense
        away.addPlayerToDefense(new Player("Demarcus", "Lawrence",78, 76, POSITION.DEFENSIVE_LINEMAN));         //LE
        away.addPlayerToDefense(new Player("Tyrone", "Crawford", 78, 81, POSITION.DEFENSIVE_BACK));          //DT  
        away.addPlayerToDefense(new Player("Cedric", "Thornton", 61,  88, POSITION.DEFENSIVE_BACK));         //DT  
        away.addPlayerToDefense(new Player("Randy", "Gregory", 84, 78, POSITION.DEFENSIVE_LINEMAN));            //RE    
        away.addPlayerToDefense(new Player("Rolando", "McClain", 80,  77, POSITION.DEFENSIVE_LINEMAN));         //MLB  
        away.addPlayerToDefense(new Player("Justin", "Durant", 83, 64, POSITION.DEFENSIVE_LINEMAN));            //LOLB    
        away.addPlayerToDefense(new Player("Sean", "Lee", 82, 75, POSITION.DEFENSIVE_LINEMAN));                 //ROLB         
        away.addPlayerToDefense(new Player("Orlando", "Scandrick", 90, 52, POSITION.CORNER));        //CB
        away.addPlayerToDefense(new Player("Brandon", "Carr", 86, 51, POSITION.CORNER));             //CB     
        away.addPlayerToDefense(new Player("Barry", "Crunch", 86, 65, POSITION.SAFETY));             //SS     
        away.addPlayerToDefense(new Player("Byron", "Jones", 91, 70, POSITION.SAFETY));              //FS

        //Offense
        //Quarter Back?
        away.addPlayerToOffense(new Player("Dak", "Prescott", 82, 74, POSITION.QUARTERBACK));             //QB     
        away.addPlayerToOffense(new Player("Ezekiel", "Elliot", 92, 75, POSITION.RUNNINGBACK));           //HB   
        away.addPlayerToOffense(new Player("Dez", "Bryant", 90, 74, POSITION.WIDERECIEVER));               //WR       
        away.addPlayerToOffense(new Player("Terrance", "Williams", 92, 57, POSITION.WIDERECIEVER));        //WR
        away.addPlayerToOffense(new Player("Cole", "Beasley", 87, 61, POSITION.WIDERECIEVER));             //WR     
        away.addPlayerToOffense(new Player("Jason", "Witten", 77, 75, POSITION.TIGHTEND));             //TE     
        away.addPlayerToOffense(new Player("Travis", "Frederick", 52, 90, POSITION.TIGHTEND));         //C 
        away.addPlayerToOffense(new Player("Tyron", "Smith", 72, 88, POSITION.OFFENSIVE_LINEMAN));              //LT     
        away.addPlayerToOffense(new Player("La'el", "Collins", 72,  88, POSITION.OFFENSIVE_LINEMAN));           //LG     
        away.addPlayerToOffense(new Player("Doug", "Free", 60, 81, POSITION.OFFENSIVE_LINEMAN));                //RT        
        away.addPlayerToOffense(new Player("Zach", "Martin", 69, 89, POSITION.OFFENSIVE_LINEMAN));              //RG
    }
}

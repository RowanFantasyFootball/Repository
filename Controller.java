import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Write a description of class Controller here.
 * 
 * @John (Jack) Donahue
 * @Gerald Miego
 * @Kevin Santana
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
     * The offensive playbook
     */
    private OffensivePlaybook offensivePlaybook;
    /**
     * The defensive playbook
     */
    private DefensivePlaybook defensivePlaybook;

    /**
     * TODO: Fix each individual Player object.
     */

    /**
     * Creates a controller instance which simulates a football game between two
     * different teams
     */
    public Controller() {
        stats = new PlayerStat();
        clock = new Clock(MAX_GAME_TICKS);
        loadTeams();
        start();
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
    }

    /**
     * Initializes the game
     * 1. Loads the teams
     * 2. Flips the coin to determine who gets the ball first
     * 3. Places the offense
     * 4. Places the defense
     */
    private void initialize() {
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
        /**
         * TODO: Add Body.
         */
    }

    /**
     * Places the offense onto the specified yard line
     * 
     * @param yardline the 'y-axis' location (yardline) that the players will line up on.
     */
    private void placeOffense(int yardline)
    {
        /**
         * TODO: Add body.
         */
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
        operateDriveProgress();
        keepScore();

        /**
         * TODO: Add More Body.
         * ex: What happens if a player catches the ball?
         * ex: What happens if their is a tackle?
         */
        runClock(); // This must always be last
    }

    /**
     * 
     */
    private void operateDriveProgress()
    {
        driveProgress.nextDown();

        if (driveProgress.isDriveOver())
        {
            swapOffenseAndDefense();
        }
    }

    /**
     * 
     */
    private void swapOffenseAndDefense()
    {
        NFLTeam offense = getOffensiveTeam();
        NFLTeam defense = getDefensiveTeam();
        NFLTeam tempTeam = offense;
        offense = defense;
        defense = tempTeam;
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
     * 
     */
    private void operateOffensiveProgess()
    {
        // TODO: Add body.

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
     * 
     */
    private void keepScore()
    {
        NFLTeam offense;
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
        /**
         * ISSUE: The Quarter Backs take in an extra parameter. What stat is this?
         * ISSUE: What are all of the position abbreviations? (commented on side)
         */
        // home team

        //Defense
        //Player connorBarwin = new LINEBACKER("Connor", "Barwin", 81, 80);         //EXAMPLE DOESN'T WORK...?
        home.addPlayerToDefense(new Player("Connor", "Barwin", 81, 80));            //LE
        home.addPlayerToDefense(new Player("Bennie", "Logan", 68, 88));             //DT           
        home.addPlayerToDefense(new Player("Fletcher", "Cox", 79, 86));             //DT           
        home.addPlayerToDefense(new Player("Brandon", "Graham", 80, 78));           //RE     
        home.addPlayerToDefense(new Player("Jordan", "Hicks", 83, 76));             //MLB 
        home.addPlayerToDefense(new Player("Mychal", "Kendricks",88, 74));          //LOLB
        home.addPlayerToDefense(new Player("Nigel", "Bradham",85, 72));             //ROLB
        home.addPlayerToDefense(new Player("Nolan", "Carroll III",89, 52));         //CB
        home.addPlayerToDefense(new Player("Leodis", "McKelvin",88, 52));           //CB
        home.addPlayerToDefense(new Player("Rodney", "McLeod Jr.",86, 56));         //SS
        home.addPlayerToDefense(new Player("Malcolm", "Jenkins", 86, 64));          //FS

        //Offense
        //Quarter Back?
        home.addPlayerToOffense(new Player("Carson", "Wentz", 82, 72));             //QB     
        home.addPlayerToOffense(new Player("Ryan", "Mathews", 89, 73));             //HB      
        home.addPlayerToOffense(new Player("Jordan", "Matthews", 90, 68));          //WR
        home.addPlayerToOffense(new Player("Nelson", "Agholor", 91, 64));           //WR    
        home.addPlayerToOffense(new Player("Josh", "Huff", 90, 60));                //WR         
        home.addPlayerToOffense(new Player("Zach", "Ertz", 80, 73));                //TE         
        home.addPlayerToOffense(new Player("Jason", "Kelce", 73, 86));              //C       
        home.addPlayerToOffense(new Player("Jason", "Peters", 67, 96));             //LT      
        home.addPlayerToOffense(new Player("Barrett", "Jones", 56, 82));            //LG     
        home.addPlayerToOffense(new Player("Lane", "Johnson", 80, 86));             //RT      
        home.addPlayerToOffense(new Player("Brandon", "Brooks", 70, 95));           //RG

        // away team
        away = new NFLTeam("Cowboys");

        //Defense
        away.addPlayerToDefense(new Player("Demarcus", "Lawrence",78, 76));         //LE
        away.addPlayerToDefense(new Player("Tyrone", "Crawford", 78, 81));          //DT  
        away.addPlayerToDefense(new Player("Cedric", "Thornton", 61,  88));         //DT  
        away.addPlayerToDefense(new Player("Randy", "Gregory", 84, 78));            //RE    
        away.addPlayerToDefense(new Player("Rolando", "McClain", 80,  77));         //MLB  
        away.addPlayerToDefense(new Player("Justin", "Durant", 83, 64));            //LOLB    
        away.addPlayerToDefense(new Player("Sean", "Lee", 82, 75));                 //ROLB         
        away.addPlayerToDefense(new Player("Orlando", "Scandrick", 90, 52));        //CB
        away.addPlayerToDefense(new Player("Brandon", "Carr", 86, 51));             //CB     
        away.addPlayerToDefense(new Player("Barry", "Crunch", 86, 65));             //SS     
        away.addPlayerToDefense(new Player("Byron", "Jones", 91, 70));              //FS

        //Offense
        //Quarter Back?
        away.addPlayerToOffense(new Player("Dak", "Prescott", 82, 74));             //QB     
        away.addPlayerToOffense(new Player("Ezekiel", "Elliot", 92, 75));           //HB   
        away.addPlayerToOffense(new Player("Dez", "Bryant", 90, 74));               //WR       
        away.addPlayerToOffense(new Player("Terrance", "Williams", 92, 57));        //WR
        away.addPlayerToOffense(new Player("Cole", "Beasley", 87, 61));             //WR     
        away.addPlayerToOffense(new Player("Jason", "Witten", 77, 75));             //TE     
        away.addPlayerToOffense(new Player("Travis", "Frederick", 52, 90));         //C 
        away.addPlayerToOffense(new Player("Tyron", "Smith", 72, 88));              //LT     
        away.addPlayerToOffense(new Player("La'el", "Collins", 72,  88));           //LG     
        away.addPlayerToOffense(new Player("Doug", "Free", 60, 81));                //RT        
        away.addPlayerToOffense(new Player("Zach", "Martin", 69, 89));              //RG
    }
}

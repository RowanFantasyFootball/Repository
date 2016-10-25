import java.util.ArrayList;
import java.util.LinkedList; // Not sure the use of this or if it is needed. LOOK IT UP!
/**
 * Write a description of class Controller here.
 * 
 * @John (Jack) Donahue
 * @Gerald Miego
 * @Kevin Santana
 * @version (a version number or a date)
 */
public class Controller
{                   
    private Randomizer rand; 
    private PlayerStat stats;
    private Clock clock;
    private int stepCount;  //sbw: does this need to be an instance var??
                            // the int stepCount was kept here just to allow us to track how many cycles of the main loop were completed
    private ArrayList<Actor> actors;
    private NFLTeam team1;  // Eagles
    private NFLTeam team2;  // Cowboys
    
    private Message msg;
    /**
     * The Constructor for the Controller class.
     * Initialize each instance variable and fill list of Actors.
     * Create team1 and team2 (both default teams).
     */
    public Controller()
    {
        //sbw made instance variables private
        //  many will be passed as parameters to other methods
        rand = new Randomizer();
        stats = new PlayerStat();
        clock = new Clock();
        
        teamSetUp();  // Create each individual Player object
        
        //actors.add((Actor)rand);
        //actors.add((Actor)stats);
        //actors.add((Actor)team1.getPlayers());
        //actors.add((Actor)team2.getPlayers());
        //actors.add((Actor)team1); //team
        //actors.add((Actor)team2); //team

    }

    /**
     * Run the program for 500 ticks at a time (subject to change).
     */
    public void run()
    {
        for(int i = 0; i < 500; i++) // Runs for 50 seconds  
        {
            stepCount++;
            step();
            wait(100);
            //Allow the clock to increment one tick for every second that passes (KEEP???)
            if (stepCount == 10) // One second has passed   
            {
                clock.tick(); // Increment Clock    //sbw - bump tick   AFTER EVERY step()  -- move!!
                stepCount = 0;
            }
        }
    }

    /**
     * Read through the list of Actors and tell each Actor to act accordingly.
     */
    public void step()
    {
        for(Actor actor : actors) 
        {
            actor.act();
        }
    }

    /**
     * Allow the user to comprehend program on screen by waiting and alotted time.
     */
    private void wait(int millisec)
    {
        try
        {
            Thread.sleep(millisec);
        } 
        catch (InterruptedException e)
        {
            // no exception
        }
    }
    
    /**
     * Create all player objects for each NFLTeam
     * NOTE: This does not add each player to their team. It only creates the player objects.
     */
    public void teamSetUp()
    {        
        NFLTeam team1 = new NFLTeam("Eagles");
        NFLTeam team2 = new NFLTeam("Cowboys");

        // Each "new String []..." is the stats for each player. TEAM NAME SHOULDN'T BE INCLUDED
        // Player parameters include... Team, Clock, Randomizer, Individual Player Statistics
        
        // Eagles Offense
        Player carsonWentz = new Player(team1, clock, rand, new String [] {"Eagles", "Carson", "Wentz", "QB", " ", "84", "82", "86", "72"});           
        Player ryanMathews = new Player(team1, clock, rand, new String [] {"Eagles", "Ryan", "Mathews", "HB", " ", "82", "89", "91", "73"});            
        Player jordanMatthews = new Player(team1, clock, rand, new String [] {"Eagles", "Jordan", "Matthews", "WR", " ", "78", "90", "91", "68"});     
        Player nelsonAgholor = new Player(team1, clock, rand, new String [] {"Eagles", "Nelson", "Agholor", "WR", " ", "72", "91", "91", "64"});        
        Player joshHuff = new Player(team1, clock, rand, new String [] {"Eagles", "Josh", "Huff", "WR", " ", "70", "90", "92", "60"});                  
        Player zachErtz = new Player(team1, clock, rand, new String [] {"Eagles", "Zach", "Ertz", "TE", " ", "87", "80", "87", "73"});                  
        Player jasonKelce = new Player(team1, clock, rand, new String [] {"Eagles", "Jason", "Kelce", "C", " ", "85", "73", "81", "86"});               
        Player jasonPeters = new Player(team1, clock, rand, new String [] {"Eagles", "Jason", "Peters", "LT", " ", "87", "67", "73", "96"});            
        Player barrettJones = new Player(team1, clock, rand, new String [] {"Eagles", "Barrett", "Jones", "LG", " ", "72", "56", "65", "82"});          
        Player laneJohnson = new Player(team1, clock, rand, new String [] {"Eagles", "Lane", "Johnson", "RT", " ", "86", "80", "87", "86"});            
        Player brandonBrooks = new Player(team1, clock, rand, new String [] {"Eagles", "Brandon", "Brooks", "RG", " ", "80", "70", "81", "95"});       
        
        //Adds a Player to the Eagles Team
         team1.addPlayerToOffense(carsonWentz);
         team1.addPlayerToOffense(ryanMathews);
         team1.addPlayerToOffense(jordanMatthews);
         team1.addPlayerToOffense(nelsonAgholor);
         team1.addPlayerToOffense(joshHuff);
         team1.addPlayerToOffense(zachErtz);
         team1.addPlayerToOffense(jasonKelce);
         team1.addPlayerToOffense(jasonPeters);
         team1.addPlayerToOffense(barrettJones);
         team1.addPlayerToOffense(laneJohnson);
         team1.addPlayerToOffense(brandonBrooks);
        
        // Eagles Defense
        Player connorBarwin = new Player(team1, clock, rand, new String [] {"Eagles", "Connor", "Barwin", "LE", " ", "84", "81", "88", "80"});          
        Player bennieLogan = new Player(team1, clock, rand, new String [] {"Eagles", "Bennie", "Logan", "DT", " ", "78", "68", "79", "88"});            
        Player fletcherCox = new Player(team1, clock, rand, new String [] {"Eagles", "Fletcher", "Cox", "DT", " ", "93", "79", "86", "86"});            
        Player brandonGraham = new Player(team1, clock, rand, new String [] {"Eagles", "Brandon", "Graham", "RE", " ", "92", "80", "87", "78"});        
        Player jordanHicks = new Player(team1, clock, rand, new String [] {"Eagles", "Jordan", "Hicks", "MLB", " ", "74", "83", "90", "76"});           
        Player mychalKendricks = new Player(team1, clock, rand, new String [] {"Eagles", "Mychal", "Kendricks", "LOLB", " ", "85", "88", "88", "74"});  
        Player nigelBradham = new Player(team1, clock, rand, new String [] {"Eagles", "Nigel", "Bradham", "ROLB", " ", "76", "85", "86", "72"});        
        Player nolanCarroll = new Player(team1, clock, rand, new String [] {"Eagles", "Nolan", "Carroll III", "CB", " ", "76", "89", "89", "52"});      
        Player leodisMcKelvin = new Player(team1, clock, rand, new String [] {"Eagles", "Leodis", "McKelvin", "CB", " ", "73", "88", "91", "52"});      
        Player rodneyMcLeod = new Player(team1, clock, rand, new String [] {"Eagles", "Rodney", "McLeod Jr.", "SS", " ", "81", "86", "91", "56"});      
        Player malcolmJenkins = new Player(team1, clock, rand, new String [] {"Eagles", "Malcolm", "Jenkins", "FS", " ", "93", "86", "92", "64"});      

        //Adds a Player to the Eagles Team
        team1.addPlayerToDefense(connorBarwin);
        team1.addPlayerToDefense(bennieLogan);
        team1.addPlayerToDefense(fletcherCox);
        team1.addPlayerToDefense(brandonGraham);
        team1.addPlayerToDefense(jordanHicks);
        team1.addPlayerToDefense(mychalKendricks);
        team1.addPlayerToDefense(nigelBradham);
        team1.addPlayerToDefense(nolanCarroll);
        team1.addPlayerToDefense(leodisMcKelvin);
        team1.addPlayerToDefense(rodneyMcLeod);
        team1.addPlayerToDefense(malcolmJenkins);
        //Displaying all of the players with the relevant attributes for the skeleton
        System.out.println(team1.getTeamName() + "\n\nOffense:\n");
        for (Player p : team1.getOffense()) {
            System.out.println(p+ " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }
        System.out.println("\nDefense:\n");
        for (Player p : team1.getDefense()) {
            System.out.println(p + " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }
        
        // Cowboys Offense
        Player dakPrescott = new Player(team2, clock, rand, new String [] {"Cowboys", "Dak", "Prescott", "QB", " ", "71", "82", "86", "74"});            team2.addPlayerToOffense(dakPrescott);
        Player ezekielElliot = new Player(team2, clock, rand, new String [] {"Cowboys", "Ezekiel", "Elliot", "HB", " ", "80", "92", "90", "75"});        team2.addPlayerToOffense(ezekielElliot);
        Player dezBryant = new Player(team2, clock, rand, new String [] {"Cowboys", "Dez", "Bryant", "WR", " ", "90", "90", "91", "74"});                team2.addPlayerToOffense(dezBryant);
        Player terranceWilliams = new Player(team2, clock, rand, new String [] {"Cowboys", "Terrance", "Williams", "WR", " ", "80", "92", "92", "57"});  team2.addPlayerToOffense(terranceWilliams);
        Player coleBeasley = new Player(team2, clock, rand, new String [] {"Cowboys", "Cole", "Beasley", "WR", " ", "77", "87", "88", "61"});            team2.addPlayerToOffense(coleBeasley);
        Player jasonWitten = new Player(team2, clock, rand, new String [] {"Cowboys", "Jason", "Witten", "TE", " ", "87", "77", "81", "75"});            team2.addPlayerToOffense(jasonWitten);
        Player travisFrederick = new Player(team2, clock, rand, new String [] {"Cowboys", "Travis", "Frederick", "C", " ", "91", "52", "75", "90"});     team2.addPlayerToOffense(travisFrederick);
        Player tyronSmith = new Player(team2, clock, rand, new String [] {"Cowboys", "Tyron", "Smith", "LT", " ", "97", "72", "82", "88"});              team2.addPlayerToOffense(tyronSmith);
        Player laelCollins = new Player(team2, clock, rand, new String [] {"Cowboys", "La'el", "Collins", "LG", " ", "78", "72", "75", "88"});           team2.addPlayerToOffense(laelCollins);
        Player dougFree = new Player(team2, clock, rand, new String [] {"Cowboys", "Doug", "Free", "RT", " ", "80", "60", "76", "81"});                  team2.addPlayerToOffense(dougFree);
        Player zachMartin = new Player(team2, clock, rand, new String [] {"Cowboys", "Zach", "Martin", "RG", " ", "92", "69", "81", "89"});              team2.addPlayerToOffense(zachMartin);

        // Cowboys Defense
        Player demarcusLawrence = new Player(team2, clock, rand, new String [] {"Cowboys", "Demarcus", "Lawrence", "LE", " ", "81", "78", "87", "76"});  team2.addPlayerToDefense(demarcusLawrence);
        Player tyroneCrawford = new Player(team2, clock, rand, new String [] {"Cowboys", "Tyrone", "Crawford", "DT", " ", "80", "78", "83", "81"});      team2.addPlayerToDefense(tyroneCrawford);
        Player cedricThornton = new Player(team2, clock, rand, new String [] {"Cowboys", "Cedric", "Thornton", "DT", " ", "78", "61", "75", "88"});      team2.addPlayerToDefense(cedricThornton);
        Player randyGregory = new Player(team2, clock, rand, new String [] {"Cowboys", "Randy", "Gregory", "RE", " ", "75", "84", "88", "78"});          team2.addPlayerToDefense(randyGregory);
        Player rolandoMcClain = new Player(team2, clock, rand, new String [] {"Cowboys", "Rolando", "McClain", "MLB", " ", "81", "80", "85", "77"});     team2.addPlayerToDefense(rolandoMcClain);
        Player justinDurant = new Player(team2, clock, rand, new String [] {"Cowboys", "Justin", "Durant", "LOLB", " ", "77", "83", "87", "64"});        team2.addPlayerToDefense(justinDurant);
        Player seanLee = new Player(team2, clock, rand, new String [] {"Cowboys", "Sean", "Lee", "ROLB", " ", "89", "82", "89", "75"});                  team2.addPlayerToDefense(seanLee);
        Player orlandoScandrick = new Player(team2, clock, rand, new String [] {"Cowboys", "Orlando", "Scandrick", "CB", " ", "87", "90", "91", "52"});  team2.addPlayerToDefense(orlandoScandrick);
        Player brandonCarr = new Player(team2, clock, rand, new String [] {"Cowboys", "Brandon", "Carr", "CB", " ", "76", "86", "91", "51"});            team2.addPlayerToDefense(brandonCarr);
        Player barryCrunch = new Player(team2, clock, rand, new String [] {"Cowboys", "Barry", "Crunch", "SS", " ", "82", "86", "88", "65"});            team2.addPlayerToDefense(barryCrunch);
        Player byronJones = new Player(team2, clock, rand, new String [] {"Cowboys", "Byron", "Jones", "FS", " ", "81", "91", "93", "70"});              team2.addPlayerToDefense(byronJones);

        //Displaying all of the players with the relevant attributes for the skeleton
        System.out.println(team1.getTeamName() + "\n\nOffense:\n");
        for (Player p : team1.getOffense()) {
            System.out.println(p+ " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }
        System.out.println("\nDefense:\n");
        for (Player p : team1.getDefense()) {
            System.out.println(p + " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }
    }

    /**
     * Make sure that the "main loop" is stopped.
     * Make sure clock is stopped (just in case)
     * Display stats of quarter (score & team stats)
     * If it is the 4th time ending a quarter, end Game (use if statement)
     * ^^^end game as in show whole game stats and team who won
     * Add current stats to final game stats
     * 
     */
    public void endQuarter()
    {

    }

    /**
     * Wait a certain amount of ticks before starting next quarter (final)
     * Set clock to default start time
     * Activate run() method to run program all over again
     * Reset current quarter stats to empty
     */
    public void startNextQuarter()
    {

    }

    /**
     * THIS COIN FLIP METHOD WILL NOT BE PUT TO USE UNTIL FINAL PROJECT IS COMPLETE
     */
    public boolean coinFlip(String guess)
    {
        boolean correctGuess = false; // True if they guessed right, false if wrong
        boolean guessBoolean = false; // Guess boolean is default set to Tails
        boolean answerBoolean = false; // Answer boolean is default set to Tails
        // Flip the coin
        if (guess.equalsIgnoreCase("heads"))
        {
            guessBoolean = true; // Guess boolean is set to Heads if they choose Heads
        }
        if (guessBoolean == answerBoolean) // If the guess matches the actual result
        {
            correctGuess = true;
        }

        return correctGuess;
    }
}

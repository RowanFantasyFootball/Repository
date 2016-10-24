import java.util.List;
import java.util.LinkedList; // Not sure the use of this or if it is needed. LOOK IT UP!
/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller
{                //sbw: huh??  :=)
                    // POSSIBLE manual/auto options for running program
                    // User chooses whether or not to continue to next quarter
                    // Or user chooses to have game run by itself
    
    private Randomizer rand; 
    private Statistics stats; // = new Statistics();
    private Clock clock;  // = new Clock();
    private int stepCount;  //sbw: does this need to be an instance var??
    
    private List<Actor> actors;
    public Controller()
    {
        //sbw made instance variables private
        //  many will be passed as parameters to other methods
        rand = new Randomizer();
        stats = new Statistics();
        clock = new Clock();

       
        //2016 10 22 13:12 sbw-- changed NFLTeam to Team, moved player-load to a method
            
        //"" way of Hard Coding Players and Teams
        private Team eagles;  //sbw: maybe "team1" and "team2"??
        private Team cowboys; 
        
        teamSetUp();  //spin off into sub-method
        
        
        
        actors.add(randomizer);
        actors.add(stats);
        actors.add(eagles.getPlayers());
        actors.add(bears.getPlayers());
        actors.add(eagles); //team
        actors.add(bears); //team

    }

    public void run()
    {
        for(int i = 0; i < 500; i++) // Runs for 50 seconds  
        {
            stepCount++;
            step();
            wait(100);
            if (stepCount == 10) // One second has passed   
            {
                clock.tick(); // Increment Clock    //sbw - bump tick   AFTER EVERY step()  -- move!!
                stepCount = 0;
            }
        }
    }

    public void step()
    {
        for(Actor actor : actors) 
        {
            actor.act();
        }
    }

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
    
    public teamSetUp()
    {
        //NFLTeam eagles = new Team("Eagles");
        //NFLTeam cowboys = new Team("Cowboys");
        
        Team eagles = new Team("Eagles");
        Team cowboys = new Team("Cowboys");

        Player carsonWentz = new Player(new String [] {"Eagles", "Carson", "Wentz", "QB", " ", "84", "82", "86", "72"});            eagles.addPlayerToOffense(carsonWentz);
        Player ryanMathews = new Player(new String [] {"Eagles", "Ryan", "Mathews", "HB", " ", "82", "89", "91", "73"});            eagles.addPlayerToOffense(ryanMathews);
        Player jordanMatthews = new Player(new String [] {"Eagles", "Jordan", "Matthews", "WR", " ", "78", "90", "91", "68"});      eagles.addPlayerToOffense(jordanMatthews);
        Player nelsonAgholor = new Player(new String [] {"Eagles", "Nelson", "Agholor", "WR", " ", "72", "91", "91", "64"});        eagles.addPlayerToOffense(nelsonAgholor);
        Player joshHuff = new Player(new String [] {"Eagles", "Josh", "Huff", "WR", " ", "70", "90", "92", "60"});                  eagles.addPlayerToOffense(joshHuff);
        Player zachErtz = new Player(new String [] {"Eagles", "Zach", "Ertz", "TE", " ", "87", "80", "87", "73"});                  eagles.addPlayerToOffense(zachErtz);
        Player jasonKelce = new Player(new String [] {"Eagles", "Jason", "Kelce", "C", " ", "85", "73", "81", "86"});               eagles.addPlayerToOffense(jasonKelce);
        Player jasonPeters = new Player(new String [] {"Eagles", "Jason", "Peters", "LT", " ", "87", "67", "73", "96"});            eagles.addPlayerToOffense(jasonPeters);
        Player barrettJones = new Player(new String [] {"Eagles", "Barrett", "Jones", "LG", " ", "72", "56", "65", "82"});          eagles.addPlayerToOffense(barrettJones);
        Player laneJohnson = new Player(new String [] {"Eagles", "Lane", "Johnson", "RT", " ", "86", "80", "87", "86"});            eagles.addPlayerToOffense(laneJohnson);
        Player brandonBrooks = new Player(new String [] {"Eagles", "Brandon", "Brooks", "RG", " ", "80", "70", "81", "95"});        eagles.addPlayerToOffense(brandonBrooks);

        Player connorBarwin = new Player(new String [] {"Eagles", "Connor", "Barwin", "LE", " ", "84", "81", "88", "80"});          eagles.addPlayerToDefense(connorBarwin);
        Player bennieLogan = new Player(new String [] {"Eagles", "Bennie", "Logan", "DT", " ", "78", "68", "79", "88"});            eagles.addPlayerToDefense(bennieLogan);
        Player fletcherCox = new Player(new String [] {"Eagles", "Fletcher", "Cox", "DT", " ", "93", "79", "86", "86"});            eagles.addPlayerToDefense(fletcherCox);
        Player brandonGraham = new Player(new String [] {"Eagles", "Brandon", "Graham", "RE", " ", "92", "80", "87", "78"});        eagles.addPlayerToDefense(brandonGraham);
        Player jordanHicks = new Player(new String [] {"Eagles", "Jordan", "Hicks", "MLB", " ", "74", "83", "90", "76"});           eagles.addPlayerToDefense(jordanHicks);
        Player mychalKendricks = new Player(new String [] {"Eagles", "Mychal", "Kendricks", "LOLB", " ", "85", "88", "88", "74"});  eagles.addPlayerToDefense(mychalKendricks);
        Player nigelBradham = new Player(new String [] {"Eagles", "Nigel", "Bradham", "ROLB", " ", "76", "85", "86", "72"});        eagles.addPlayerToDefense(nigelBradham);
        Player nolanCarroll = new Player(new String [] {"Eagles", "Nolan", "Carroll III", "CB", " ", "76", "89", "89", "52"});      eagles.addPlayerToDefense(nolanCarroll);
        Player leodisMcKelvin = new Player(new String [] {"Eagles", "Leodis", "McKelvin", "CB", " ", "73", "88", "91", "52"});      eagles.addPlayerToDefense(leodisMcKelvin);
        Player rodneyMcLeod = new Player(new String [] {"Eagles", "Rodney", "McLeod Jr.", "SS", " ", "81", "86", "91", "56"});      eagles.addPlayerToDefense(rodneyMcLeod);
        Player malcolmJenkins = new Player(new String [] {"Eagles", "Malcolm", "Jenkins", "FS", " ", "93", "86", "92", "64"});      eagles.addPlayerToDefense(malcolmJenkins);

        //Displaying all of the players with the relevant attributes for the skeleton
        System.out.println(eagles.getTeamName() + "\n\nOffense:\n");
        for (NFLPlayer p : eagles.getOffense()) {
            System.out.println(p + " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }
        System.out.println("\nDefense:\n");
        for (NFLPlayer p : eagles.getDefense()) {
            System.out.println(p + " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }

        Player dakPrescott = new Player(new String [] {"Cowboys", "Dak", "Prescott", "QB", " ", "71", "82", "86", "74"});            cowboys.addPlayerToOffense(dakPrescott);
        Player ezekielElliot = new Player(new String [] {"Cowboys", "Ezekiel", "Elliot", "HB", " ", "80", "92", "90", "75"});        cowboys.addPlayerToOffense(ezekielElliot);
        Player dezBryant = new Player(new String [] {"Cowboys", "Dez", "Bryant", "WR", " ", "90", "90", "91", "74"});                cowboys.addPlayerToOffense(dezBryant);
        Player terranceWilliams = new Player(new String [] {"Cowboys", "Terrance", "Williams", "WR", " ", "80", "92", "92", "57"});  cowboys.addPlayerToOffense(terranceWilliams);
        Player coleBeasley = new Player(new String [] {"Cowboys", "Cole", "Beasley", "WR", " ", "77", "87", "88", "61"});            cowboys.addPlayerToOffense(coleBeasley);
        Player jasonWitten = new Player(new String [] {"Cowboys", "Jason", "Witten", "TE", " ", "87", "77", "81", "75"});            cowboys.addPlayerToOffense(jasonWitten);
        Player travisFrederick = new Player(new String [] {"Cowboys", "Travis", "Frederick", "C", " ", "91", "52", "75", "90"});     cowboys.addPlayerToOffense(travisFrederick);
        Player tyronSmith = new Player(new String [] {"Cowboys", "Tyron", "Smith", "LT", " ", "97", "72", "82", "88"});              cowboys.addPlayerToOffense(tyronSmith);
        Player laelCollins = new Player(new String [] {"Cowboys", "La'el", "Collins", "LG", " ", "78", "72", "75", "88"});           cowboys.addPlayerToOffense(laelCollins);
        Player dougFree = new Player(new String [] {"Cowboys", "Doug", "Free", "RT", " ", "80", "60", "76", "81"});                  cowboys.addPlayerToOffense(dougFree);
        Player zachMartin = new Player(new String [] {"Cowboys", "Zach", "Martin", "RG", " ", "92", "69", "81", "89"});              cowboys.addPlayerToOffense(zachMartin);

        Player demarcusLawrence = new Player(new String [] {"Cowboys", "Demarcus", "Lawrence", "LE", " ", "81", "78", "87", "76"});  cowboys.addPlayerToDefense(demarcusLawrence);
        Player tyroneCrawford = new Player(new String [] {"Cowboys", "Tyrone", "Crawford", "DT", " ", "80", "78", "83", "81"});      cowboys.addPlayerToDefense(tyroneCrawford);
        Player cedricThornton = new Player(new String [] {"Cowboys", "Cedric", "Thornton", "DT", " ", "78", "61", "75", "88"});      cowboys.addPlayerToDefense(cedricThornton);
        Player randyGregory = new Player(new String [] {"Cowboys", "Randy", "Gregory", "RE", " ", "75", "84", "88", "78"});          cowboys.addPlayerToDefense(randyGregory);
        Player rolandoMcClain = new Player(new String [] {"Cowboys", "Rolando", "McClain", "MLB", " ", "81", "80", "85", "77"});     cowboys.addPlayerToDefense(rolandoMcClain);
        Player justinDurant = new Player(new String [] {"Cowboys", "Justin", "Durant", "LOLB", " ", "77", "83", "87", "64"});        cowboys.addPlayerToDefense(justinDurant);
        Player seanLee = new Player(new String [] {"Cowboys", "Sean", "Lee", "ROLB", " ", "89", "82", "89", "75"});                  cowboys.addPlayerToDefense(seanLee);
        Player orlandoScandrick = new Player(new String [] {"Cowboys", "Orlando", "Scandrick", "CB", " ", "87", "90", "91", "52"});  cowboys.addPlayerToDefense(orlandoScandrick);
        Player brandonCarr = new Player(new String [] {"Cowboys", "Brandon", "Carr", "CB", " ", "76", "86", "91", "51"});            cowboys.addPlayerToDefense(brandonCarr);
        Player barryCrunch = new Player(new String [] {"Cowboys", "Barry", "Crunch", "SS", " ", "82", "86", "88", "65"});            cowboys.addPlayerToDefense(barryCrunch);
        Player byronJones = new Player(new String [] {"Cowboys", "Byron", "Jones", "FS", " ", "81", "91", "93", "70"});              cowboys.addPlayerToDefense(byronJones);

        //Displaying all of the players with the relevant attributes for the skeleton
        System.out.println(cowboys.getTeamName() + "\n\nOffense:\n");
        for (NFLPlayer p : cowboys.getOffense()) {
            System.out.println(p + " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }
        System.out.println("\nDefense:\n");
        for (NFLPlayer p : cowboys.getDefense()) {
            System.out.println(p + " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }
    }//end teamSetUp()

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

    public void incrementClockMAYBE()
    {

    }

    public void updatePositionMAYBE()
    {

    }

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

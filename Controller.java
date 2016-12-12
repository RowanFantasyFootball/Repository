import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Write a description of class Controller here.
 * 
 * @John (Jack) Donahue
 * @Gerald Miego
 * @Kevin Santana
 * @revision By: Joe Dunne & Tim McClintock
 */
public class Controller {
    /** Variable names are self explanatory */
    private static final int TICK_DELAY = 100;
    private static final int MAX_GAME_TICKS = 100;
    private static final int QUARTER_CHANGE_DELAY = 5000;

    /**
     * The field for the teams to play on private Field field;
     */

    /**
     * The home team (Dont change this, supposed to be final)
     */
    private final NFLTeam home;

    /**
     * The away team (Dont change this, supposed to be final)
     */
    private final NFLTeam away;

    /**
     * The current team on offense
     */
    private NFLTeam offense;

    /**
     * The current team on defense
     */
    private NFLTeam defense;

    /**
     * The time clock for the game
     */
    private Clock clock;

    /**
     * Individual player stats
     */
    private PlayerStat stats;

    /**
     * The progress of the current drive
     */
    private DriveProgress progress;

    /**
     * The gui
     */
    private GUI gui;

    private int fdl;
    /**
     * Creates a controller instance which simulates a football game between two
     * different teams
     */
    public Controller() {
        home = new NFLTeam("Eagles");
        away = new NFLTeam("Cowboys");
        stats = new PlayerStat();
        clock = new Clock(MAX_GAME_TICKS);
        gui = new GUI();
        fdl = 30;
        initialize();
    }

    /**
     * Sets the offensive team to the specified team
     * 
     * @param team
     *            - the team to set to the defense
     */
    public final void setOffense(NFLTeam team) {
        offense = team;
    }

    /**
     * Sets the defensive team to the specified team
     * 
     * @param team
     *            - the team to set to the defense
     */
    public final void setDefense(NFLTeam team) {
        defense = team;
    }

    /**
     * Gets the current team on defense
     * 
     * @return the team on defense
     */
    public final NFLTeam getDefense() {
        return defense;
    }

    /**
     * Gets the current team on offense
     * 
     * @return the team on offense
     */
    public final NFLTeam getOffense() {
        return offense;
    }

    /**
     * Gets the current home team
     * 
     * @return the home team
     */
    public final NFLTeam getHomeTeam() {
        return home;
    }

    /**
     * Gets the current away team
     * 
     * @return the away team
     */
    public final NFLTeam getAwayTeam() {
        return away;
    }

    /**
     * 
     * @return
     */
    public final Clock getClock() {
        return clock;
    }

    /**
     * Gets the drive progress object
     * 
     * @return the drive progress
     */
    public final DriveProgress getDriveProgress() {
        return progress;
    }

    /**
     * Gets the player with the ball
     * 
     * @return the player with the ball
     */
    public final Player getPlayerWithBall() {
        try {
            return getOffense().getOffensivePlayers().stream().filter(p -> p.hasBall()).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * Allow the user to comprehend program on screen by waiting and allotted
     * time.
     * 
     * @param millisec
     *            the amount of time to wait.
     */
    public final void wait(int millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {

        }
    }

    /**
     * Initializes the game 1. Loads the teams 2. Flips the coin to determine
     * who gets the ball first 3. Places the offense 4. Places the defense
     */
    private void initialize() {
        progress = new DriveProgress();
        loadPlayers();
        flipCoin();
        lineupOffense(20, getOffense().getOffensivePlayers());
        lineupDefense(20, getDefense().getDefensivePlayers());
        start();
    }

    public void start() {
        while (getClock().isRunning()) {
            step();
            wait(TICK_DELAY);
        }
    }

    /**
     * Simulates a coin flip 0 is heads 1 is tales
     * 
     * @param guess
     *            input 0 or 1
     * @return if the guess was correct
     */
    public final boolean simulateCoinFlip(int guess) {
        return Integer.valueOf(Randomizer.getRandomNumber(1)) == guess;
    }

    /**
     * Simulate a coin flip where the away team guesses and if they get it they
     * choose to be on the offense first
     */
    public final void flipCoin() {
        if (simulateCoinFlip(Randomizer.getRandomNumber(1))) {
            setOffense(away);
            setDefense(home);
        } else {
            setOffense(home);
            setDefense(away);
        }
    }

    /**
     * Steps and operates progress, determines if a successful play if the
     * offenses play potential success is greater than the defense's
     */
    public final void step() {
        int offense = operateOffense();
        int defense = operateDefense();

        int previousLOS = progress.getLineOfScrimmage();
        int newLineOfScrimage = progress.getLineOfScrimmage() + (offense - defense);
        if (newLineOfScrimage > 99)
            newLineOfScrimage = 100;
        operateProgress(newLineOfScrimage);
        operateClock();
        
        gui.move(previousLOS, fdl-progress.getLineOfScrimmage(), true);
        //gui.setAwayScore(away.getScore());
        //gui.setHomeScore(home.getScore());
        //gui.setYardageToFirst(progress.getLineOfScrimmage() + 10);
        gui.setDown(progress.getDown());
        gui.move(previousLOS, fdl-progress.getLineOfScrimmage(), true);
        gui.setQuarter(clock.getQuarter());
        gui.move(previousLOS, fdl-progress.getLineOfScrimmage(), true);
        if (getOffense().getTeamName().equals("Eagles")) {
            gui.setPossession("home");
        } else {
            gui.setPossession("away");
        }
        gui.move(previousLOS, fdl-progress.getLineOfScrimmage(), true);
        gui.setYardMarker(progress.getLineOfScrimmage()); 
        gui.move(previousLOS, fdl-progress.getLineOfScrimmage(), true);
        gui.animate(previousLOS, newLineOfScrimage, fdl-newLineOfScrimage, true);
        
            
    }

    /**
     * Operates the offense (Calls act method on offensive players)
     * 
     * 1. Gets a random play object which provides each actor with movements 2.
     * Cycles through each offensive actor on the field and operates them
     * 
     * @return gets the potential that the play will be successful
     */
    public final int operateOffense() {
        PLAY_TYPE TYPE = PLAY_TYPE.getRandomOffensivePlayType();
        OffensivePlay play = new OffensivePlay(TYPE);
        for (Actor actor : getOffense().getOffensivePlayers()) {
            actor.act(play);
        }
        return TYPE.getPotential();
    }

    /**
     * Operates the defense (Calls act method on defensive players). 1. Gets a
     * random defensive play from the Playbook. 2. Cycles through each defensive
     * actor on the field and operates them.å
     */
    public final int operateDefense() {
        PLAY_TYPE TYPE = PLAY_TYPE.getRandomDefensivePlayType();
        DefensivePlay play = new DefensivePlay(TYPE);
        for (Actor actor : getDefense().getDefensivePlayers()) {
            actor.act(play);
        }
        return TYPE.getPotential();
    }

    /**
     * Operates the clock. Checks if the quarter is over, then changes it and
     * waits for the next quarter to start. Always ticks and waits per step
     */
    public final void operateClock() {
        if (clock.isQuarterOver()) {
            clock.changeQuarter();
            wait(QUARTER_CHANGE_DELAY);
        }
        clock.tick();
        wait(TICK_DELAY);
    }

    /**
     * Swaps the current offense and defense
     */
    public final void swapTeams() {
        if (getOffense().equals(away)) {
            setDefense(away);
            setOffense(home);
        } else {
            setDefense(home);
            setOffense(away);
        }
    }

    /**
     * Lines up a player random as hell
     * 
     * @param yardline
     *            the 'y-axis' location (yardline) that the players will line up
     *            on.
     */
    public void lineupOffense(int yardline, ArrayList<Player> players) {
        ArrayList<Location> used = new ArrayList<Location>();
        Iterator<Player> it = players.iterator();
        while (it.hasNext()) {
            Player player = it.next();
            Location lineup = null;
            do {
                boolean subtract = Randomizer.getRandomNumber(1) == 1;
                int lineupY = yardline + (subtract ? -player.getPosition().getRandomYLocation()
                        : player.getPosition().getRandomYLocation());
                int lineupX = (-player.getPosition().getRandomXLocation());
                Location random = new Location(lineupX, lineupY);
                if (used.stream().filter(l -> l.equals(random)).count() < 1) {
                    lineup = random;
                }
            } while (lineup == null);
            System.out.println("Linedup: " + player.toString() + " @ " + lineup.toString());
            player.lineup(lineup);
        }
    }

    /**
     * Lines up a player random as hell
     * 
     * @param yardline
     *            the 'y-axis' location (yardline) that the players will line up
     *            on.
     */
    public void lineupDefense(int yardline, ArrayList<Player> players) {
        ArrayList<Location> used = new ArrayList<Location>();
        Iterator<Player> it = players.iterator();
        while (it.hasNext()) {
            Player player = it.next();
            Location lineup = null;
            do {
                boolean subtract = Randomizer.getRandomNumber(1) == 1;
                int lineupY = yardline + (subtract ? -player.getPosition().getRandomYLocation()
                        : player.getPosition().getRandomYLocation());
                int lineupX = (-player.getPosition().getRandomXLocation());
                Location random = new Location(lineupX, lineupY);
                if (used.stream().filter(l -> l.equals(random)).count() < 1) {
                    lineup = random;
                }
            } while (lineup == null);
            System.out.println("Linedup: " + player.toString() + " @ " + lineup.toString());
            player.lineup(lineup);
        }
    }

    /**
     * Operates the drive progress for both team. Keeps track of the score and
     * what happened in the play
     * 
     * @param previous
     *            - the previous yard line
     */
    public void operateProgress(int newLineOfScrimage) {
        System.out.println("Operating progress...");
        /** Handles a play with gained yards */
        if (newLineOfScrimage > progress.getLineOfScrimmage()) {
            /** Handles a touchdown (Message code: 1) */
            if (newLineOfScrimage >= 100) {
                stats.updateMessage(new Message(getPlayerWithBall(), 1, clock.getTicks(), newLineOfScrimage,
                        progress.getLineOfScrimmage()), gui);
                if (getOffense().getTeamName().equals(away.getTeamName())) {
                    away.touchdown();
                    gui.setAwayScore(away.getScore());
                } else {
                    home.touchdown();
                    gui.setHomeScore(home.getScore());
                }
                swapTeams();
                lineupOffense(20, getOffense().getOffensivePlayers());
                lineupDefense(20, getDefense().getDefensivePlayers());
                progress.resetDowns();
                progress.setLineOfScrimmage(20);
                fdl = 30;
                gui.move(progress.getLineOfScrimmage(),fdl-progress.getLineOfScrimmage(),true);
                return;
            }
            /** Handles first downs (Message code: 2) */
            /**
             * Wrong, why isn't their a variable to keep track of where the FDL is????
             */
            else if (newLineOfScrimage > fdl) {
                if (newLineOfScrimage > 90) {
                    fdl = 100;
                } else {
                    fdl = newLineOfScrimage + 10;
                }
                stats.updateMessage(new Message(getPlayerWithBall(), 2, clock.getTicks(), newLineOfScrimage,
                        progress.getLineOfScrimmage()), gui);
                lineupOffense(newLineOfScrimage, getOffense().getOffensivePlayers());
                lineupDefense(newLineOfScrimage, getDefense().getDefensivePlayers());
                progress.resetDowns();
                progress.setLineOfScrimmage(newLineOfScrimage);
                gui.move(progress.getLineOfScrimmage(), fdl-progress.getLineOfScrimmage(), true);
            }
            /** Handles a successful play (Message code: 4) */
            else {
                stats.updateMessage(new Message(getPlayerWithBall(), 4, clock.getTicks(), newLineOfScrimage,
                        progress.getLineOfScrimmage()), gui);
                lineupOffense(newLineOfScrimage, getOffense().getOffensivePlayers());
                lineupDefense(newLineOfScrimage, getDefense().getDefensivePlayers());
                progress.nextDown();
                progress.setLineOfScrimmage(newLineOfScrimage);
                gui.move(progress.getLineOfScrimmage(), fdl-progress.getLineOfScrimmage(), true);
            }
        }
        /** Handles an unsuccessful play (Message code: 5) */
        else {
            stats.updateMessage(new Message(getPlayerWithBall(), 5, clock.getTicks(), newLineOfScrimage,
                    progress.getLineOfScrimmage()), gui);
            progress.nextDown();
            lineupOffense(progress.getLineOfScrimmage(), getOffense().getOffensivePlayers());
            lineupDefense(progress.getLineOfScrimmage(), getDefense().getDefensivePlayers());
            gui.move(progress.getLineOfScrimmage(), fdl-progress.getLineOfScrimmage(), true);
        }

        /** Handles turnovers (Message code: 3) */
        if (progress.isDriveOver()) {
            stats.updateMessage(new Message(getPlayerWithBall(), 3, clock.getTicks(), newLineOfScrimage,
                    progress.getLineOfScrimmage()), gui);
            swapTeams();
            progress.setLineOfScrimmage(20);
            progress.resetDowns();
            lineupOffense(progress.getLineOfScrimmage(), getOffense().getOffensivePlayers());
            lineupDefense(progress.getLineOfScrimmage(), getDefense().getDefensivePlayers());
        }
        stats.showAllOverviews();
    }

    /**
     * Loads the home and away teams offensive and defensive players This method
     * is finished and finalized. Only modify the player of player stats
     */
    private final void loadPlayers() {
        home.addPlayerToDefense(new Player("Connor", "Barwin", 81, 80, POSITION.DEFENSIVE_LINEMAN)); // LE
        home.addPlayerToDefense(new Player("Bennie", "Logan", 68, 88, POSITION.DEFENSIVE_LINEMAN)); // DT
        home.addPlayerToDefense(new Player("Fletcher", "Cox", 79, 86, POSITION.DEFENSIVE_LINEMAN)); // DT
        home.addPlayerToDefense(new Player("Brandon", "Graham", 80, 78, POSITION.DEFENSIVE_LINEMAN)); // RE
        home.addPlayerToDefense(new Player("Jordan", "Hicks", 83, 76, POSITION.LINEBACKER)); // MLB
        home.addPlayerToDefense(new Player("Mychal", "Kendricks", 88, 74, POSITION.LINEBACKER)); // LOLB
        home.addPlayerToDefense(new Player("Nigel", "Bradham", 85, 72, POSITION.LINEBACKER)); // ROLB
        home.addPlayerToDefense(new Player("Nolan", "Carroll III", 89, 52, POSITION.DEFENSIVE_BACK)); // CB
        home.addPlayerToDefense(new Player("Leodis", "McKelvin", 88, 52, POSITION.DEFENSIVE_BACK)); // CB
        home.addPlayerToDefense(new Player("Rodney", "McLeod Jr.", 86, 56, POSITION.DEFENSIVE_BACK)); // SS
        home.addPlayerToDefense(new Player("Malcolm", "Jenkins", 86, 64, POSITION.DEFENSIVE_BACK)); // FS

        // Offense
        // Quarter Back?
        home.addPlayerToOffense(new Player("Carson", "Wentz", 82, 72, POSITION.QUARTERBACK)); // QB
        home.addPlayerToOffense(new Player("Ryan", "Mathews", 89, 73, POSITION.RUNNINGBACK)); // HB
        home.addPlayerToOffense(new Player("Jordan", "Matthews", 90, 68, POSITION.WIDE_RECIEVER)); // WR
        home.addPlayerToOffense(new Player("Nelson", "Agholor", 91, 64, POSITION.WIDE_RECIEVER)); // WR
        home.addPlayerToOffense(new Player("Josh", "Huff", 90, 60, POSITION.WIDE_RECIEVER)); // WR
        home.addPlayerToOffense(new Player("Zach", "Ertz", 80, 73, POSITION.WIDE_RECIEVER)); // TE
        home.addPlayerToOffense(new Player("Jason", "Kelce", 73, 86, POSITION.OFFENSIVE_LINEMAN)); // C
        home.addPlayerToOffense(new Player("Jason", "Peters", 67, 96, POSITION.OFFENSIVE_LINEMAN)); // LT
        home.addPlayerToOffense(new Player("Barrett", "Jones", 56, 82, POSITION.OFFENSIVE_LINEMAN)); // LG
        home.addPlayerToOffense(new Player("Lane", "Johnson", 80, 86, POSITION.OFFENSIVE_LINEMAN)); // RT
        home.addPlayerToOffense(new Player("Brandon", "Brooks", 70, 95, POSITION.OFFENSIVE_LINEMAN)); // RG

        // Defense
        away.addPlayerToDefense(new Player("Demarcus", "Lawrence", 78, 76, POSITION.DEFENSIVE_LINEMAN)); // LE
        away.addPlayerToDefense(new Player("Tyrone", "Crawford", 78, 81, POSITION.DEFENSIVE_LINEMAN)); // DT
        away.addPlayerToDefense(new Player("Cedric", "Thornton", 61, 88, POSITION.DEFENSIVE_LINEMAN)); // DT
        away.addPlayerToDefense(new Player("Randy", "Gregory", 84, 78, POSITION.DEFENSIVE_LINEMAN)); // RE
        away.addPlayerToDefense(new Player("Rolando", "McClain", 80, 77, POSITION.LINEBACKER)); // MLB
        away.addPlayerToDefense(new Player("Justin", "Durant", 83, 64, POSITION.LINEBACKER)); // LOLB
        away.addPlayerToDefense(new Player("Sean", "Lee", 82, 75, POSITION.LINEBACKER)); // ROLB
        away.addPlayerToDefense(new Player("Orlando", "Scandrick", 90, 52, POSITION.DEFENSIVE_BACK)); // CB
        away.addPlayerToDefense(new Player("Brandon", "Carr", 86, 51, POSITION.DEFENSIVE_BACK)); // CB
        away.addPlayerToDefense(new Player("Barry", "Crunch", 86, 65, POSITION.DEFENSIVE_BACK)); // SS
        away.addPlayerToDefense(new Player("Byron", "Jones", 91, 70, POSITION.DEFENSIVE_BACK)); // FS

        // Offense
        // Quarter Back?
        away.addPlayerToOffense(new Player("Dak", "Prescott", 82, 74, POSITION.QUARTERBACK)); // QB
        away.addPlayerToOffense(new Player("Ezekiel", "Elliot", 92, 75, POSITION.RUNNINGBACK)); // HB
        away.addPlayerToOffense(new Player("Dez", "Bryant", 90, 74, POSITION.WIDE_RECIEVER)); // WR
        away.addPlayerToOffense(new Player("Terrance", "Williams", 92, 57, POSITION.WIDE_RECIEVER)); // WR
        away.addPlayerToOffense(new Player("Cole", "Beasley", 87, 61, POSITION.WIDE_RECIEVER)); // WR
        away.addPlayerToOffense(new Player("Jason", "Witten", 77, 75, POSITION.WIDE_RECIEVER)); // TE
        away.addPlayerToOffense(new Player("Travis", "Frederick", 52, 90, POSITION.OFFENSIVE_LINEMAN)); // C
        away.addPlayerToOffense(new Player("Tyron", "Smith", 72, 88, POSITION.OFFENSIVE_LINEMAN)); // LT
        away.addPlayerToOffense(new Player("La'el", "Collins", 72, 88, POSITION.OFFENSIVE_LINEMAN)); // LG
        away.addPlayerToOffense(new Player("Doug", "Free", 60, 81, POSITION.OFFENSIVE_LINEMAN)); // RT
        away.addPlayerToOffense(new Player("Zach", "Martin", 69, 89, POSITION.OFFENSIVE_LINEMAN)); // RG
	}
}

 

/**
 * Write a description of class NFLPlayer here.
 * 
 * @author Joe Dunne (constructor), Joe Dementri (accessors),
 * @version 0.1
 */
public class NFLPlayer {
   
    /**
     * The list of data for the player
     * 
     * Accessed by getters which use hardcoded indicies
     */
    private String[] data;

    /**
     * Creates a new NFLPlayer instance
     * 
     * @param data - the data line for the player
     */
    //Add clock, Stat, Both teams?, 
    public NFLPlayer(String[] data) { 
        this.data = data;
    }
    
    
    public void act() {
        
    }
    
    public void act2() {
        
    }
    
    
    /**
     * START OF ACCESSORS STATS ALL DONE, HAVE FUN SCROLLING
     * 
     * Good shit on the accessors my boy */
    
    /* Returns all of the stats as a string
    
    @Override
    public String toString() {
        String stats = data[1] + " " + data[2];
        stats += ":" + (stats.length() < 15 ? "\t\t" : "\t");
        for (int index = 3; index < data.length; index++) {
            stats += data[index] + "\t";
        }
        return stats;
    }*/
    @Override
    public String toString() {
        return getFullName();
    }
    
    /**
     * Gets the team of the player
     * 
     * @return the team of the player
     */
    public String getTeamName() {
        return data[0];
    }
    
    /**
     * Gets the name of the player
     * 
     * @return the full name of the player
     */
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
    
    /**
     * Gets the first name of the player
     * 
     * @return the full name of the player
     */
    public String getFirstName() {
        return data[1];
    }
    
    /**
     * Gets the last name of the player
     * 
     * @return the last name of the player
     */
    public String getLastName() {
        return data[2];
    }
    
    /**
     * Get the position of the player
     * @return the position of the player
     */
    public String getPosition() {
        return data[3];
    }
    
    /**
     * Get the Jersey # of the player
     * @return Jersey # as string
     */
    public String getJerseyNum() {
        return data[4];
    }
    
    /**
     * Get OVR rank of player
     * @return OVR of player 
     */
    public int getOverall() {
        return Integer.parseInt(data[5]);
    }
    
    /**
     * Get Speed of the player
     * @return speed of player as int
     */
    public int getSpeed() {
        return Integer.parseInt(data[6]);
    }
    
    /**
     * Get Acceleration of the player
     * @return acceleration of player as int
     */
    public int getAcceleration() {
        return Integer.parseInt(data[7]);
    }
    
    /**
     * Get Strength of the player -- mainly linemen stat
     * @return strength of player as int
     */
    public int getStrength() {
        return Integer.parseInt(data[8]);
    }
    
    /**
     * Get Agility of the player
     * @return agility of player as int
     */
    public int getAgility() {
        return Integer.parseInt(data[9]);
    }
    
    /**
     * Get Awareness of the player
     * @return awareness of player as int
     */
    public int getAwareness() {
        return Integer.parseInt(data[10]);
    }
    
    /**
     * Get Catching of the player -- mainly WR,RB, CB, S stat
     * @return catching stat of player as int
     */
    public int getCatching() {
        return Integer.parseInt(data[11]);
    }
    
    /**
     * Get Carrying of the player -- mainly RB stat
     * @return carrying stat of player as int
     */
    public int getCarrying() {
        return Integer.parseInt(data[12]);
    }
    
    /**
     * Get Throw Power of QB
     * @return throw power of QB as int
     */
    public int getThrowPower() {
        return Integer.parseInt(data[13]);
    }
    
    /**
     * Gets the short-throw accuracy of QB
     * @return the short-throw accuracy of QB as int
     */
    public int getShortAccuracy() {
        return Integer.parseInt(data[14]);
    }
    
    /**
     * Gets the mid-throw accuracy of QB
     * @return the mid-throw accuracy of QB as int
     */
    public int getMidAccuracy() {
        return Integer.parseInt(data[15]);
    }
    
    /**
     * Gets the deep-throw accuracy of QB
     * @return the deep-throw accuracy of QB as int
     */
    public int getDeepAccuracy() {
        return Integer.parseInt(data[16]);
    }
    
    /**
     * Gets the kick power of K
     * @return the kick power of K as int
     */
    public int getKickPower() {
        return Integer.parseInt(data[17]);
    }
    
    /**
     * Gets the kick accuracy of K
     * @return the kick accuracy of K as int
     */
    public int getKickAccuracy() {
        return Integer.parseInt(data[18]);
    }
    
    /**
     * Gets the Run Block effectiveness of a player -- Defense
     * @return the run block stat as int
     */
    public int getRunBlock() {
        return Integer.parseInt(data[19]);
    }
    
    /**
     * Get the pass block effectiveness of a player -- Defense
     * @return the pass block stat as int
     */
    public int getPassBlock() {
        return Integer.parseInt(data[20]);
    }
    
    /**
     * Get the tackle effectiveness of a player -- Defense
     * @return the tackle stat as int
     */
    public int getTackle() {
        return Integer.parseInt(data[21]);
    }
    
    /**
     * Get the jumping ability of a player -- For WR, RB, CB, S
     * @return jumping stat as int
     */
    public int getJumping() {
        return Integer.parseInt(data[22]);
    }
    
    /**
     * Get the kick return ability of a player
     * @return kick return stat as int
     */
    public int getKickReturn() {
        return Integer.parseInt(data[23]);
    }
    
    /**
     * Get the injury likeliehood of a player
     * @return injury stat as int
     */
    public int getInjury() {
        return Integer.parseInt(data[24]);
    }
    
    /**
     * Get stamina of a player
     * @return stamina stat as int
     */
    public int getStamina() {
        return Integer.parseInt(data[25]);
    }
    
    /**
     * Get toughness of a player
     * @return toughness stat as int
     */
    public int getToughness() {
        return Integer.parseInt(data[26]);
    }
    
    /**
     * Get trucking ability of a player
     * @return trucking stat as int
     */
    public int getTrucking() {
        return Integer.parseInt(data[27]);
    }
    
    /**
     * Get elusiveness of a player
     * @return elusiveness of player as int
     */
    public int getElusiveness() {
        return Integer.parseInt(data[28]);
    }
    
    /**
     * Get ball carrier ability of a player
     * @return ball carrier stat as int
     */
    public int getBallCarrier() {
        return Integer.parseInt(data[29]);
    }
    
    /**
     * Get Vision of player -- mainly qb stat
     * @return vision stat as int
     */
    public int getVision() {
        return Integer.parseInt(data[30]);
    }
    
    /**
     * Gets stiff arm ability of a player
     * @return stiff arm stat as int
     */
    public int getStiffArm() {
        return Integer.parseInt(data[31]);
    }
    
    /**
     * Gets spin move ability of a player
     * @return spin move stat as int
     */
    public int getSpinMove() {
        return Integer.parseInt(data[32]);
    }
    
    /**
     * Get juke move ability of a player
     * @return juke move stat as int
     */
    public int getJukeMove() {
        return Integer.parseInt(data[33]);
    }
    
    /**
     * Get Impact Block ability of a player
     * @return impact block stat as int
     */
    public int getImpactBlock() {
        return Integer.parseInt(data[34]);
    }
    
    /**
     * Get Power Move ability of a player
     * @return power move stat as int
     */
    public int getPowerMove() {
        return Integer.parseInt(data[35]);
    }
    
    /**
     * Get Finesse Move ability of a player
     * @return finesse move stat as int
     */
    public int getFinesseMove() {
        return Integer.parseInt(data[36]);
    }
    
    /**
     * Get Block Shedding ability of a player
     * @return block shedding stat as int
     */
    public int getBlockSheddding() {
        return Integer.parseInt(data[37]);
    }
    
    /**
     * Get Pursuit ability of a player
     * @return pursuit stat as int
     */
    public int getPursuit() {
        return Integer.parseInt(data[38]);
    }
    
    /**
     * Get Play Recognition ability of a player
     * @return play recognition stat as int
     */
    public int getPlayRecognition() {
        return Integer.parseInt(data[39]);
    }
    
    /**
     * Get Man Coverage ability of a player
     * @return man coverage stat as int
     */
    public int getManCoverage() {
        return Integer.parseInt(data[40]);
    }
    
    /**
     * Get Zone Coverage ability of a player
     * @return zone coverage stat as int
     */
    public int getZoneCoverage() {
        return Integer.parseInt(data[41]);
    }
    
    /**
     * Get Spectacular Catch ability of a player
     * @return spectacular catch stat as int
     */
    public int getSpectacularCatch() {
        return Integer.parseInt(data[42]);
    }
    
    /**
     * Get Catch In Traffic ability of a player
     * @return catch in traffic stat as int
     */
    public int getCatchInTraffic() {
        return Integer.parseInt(data[43]);
    }
    
    /**
     * Get Route Running ability of a player
     * @return route running stat as int
     */
    public int getRouteRunning() {
        return Integer.parseInt(data[44]);
    }
    
    /**
     * Get Hit Power ability of a player
     * @return hit power stat as int
     */
    public int getHitPower() {
        return Integer.parseInt(data[45]);
    }
    
    /**
     * Get Press ability of a player
     * @return press stat as int
     */
    public int getPress() {
        return Integer.parseInt(data[46]);
    }
    
    /**
     * Get Release ability of a player
     * @return release stat as int
     */
    public int getRelease() {
        return Integer.parseInt(data[47]);
    }
    
    /**
     * Get Play Action ability of a player
     * @return play action stat as int
     */
    public int getPlayAction() {
        return Integer.parseInt(data[48]);
    }
    
    /**
     * Get Throw on the Run ability of a player
     * @return throw on the run stat as int
     */
    public int getThrowOnTheRun() {
        return Integer.parseInt(data[49]);
    }
    
    /**
     * Get Height of a player IN INCHES
     * @return height IN INCHES!!!!!!
     */
    public int getHeight() {
        int feet = Integer.parseInt(data[50].substring(0, data[50].indexOf("'")));
        int inches = Integer.parseInt(data[50].substring(data[50].indexOf("'")+1, data[50].indexOf("\"")));
        return (feet*12)+inches;
    }
    
    /**
     * Get Weight of a player IN POUNDS (LBS)
     * @return weight IN POUNDS!!!!!!
     */
    public int getWeight() {
        return Integer.parseInt(data[51]);
    }
    
    /**
     * IF YOU ARE READING THIS COMMENT YOU HAVE HIT THE END OF THE ACCESSORS. HALLELUJAH.
     * OTHER TEAMS, PICK AND CHOOSE WHICH STATS YOU WANT TO USE
     */
}

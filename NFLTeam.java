 import java.util.*;

/**
 * Write a description of class NFLTeam here.
 * 
 * @author Joe Dunne, Joe Dementri, Michael Matthews
 * @Revisions Team IR October 24th, 2016  
 */

//2016 10 22 1329 sbw: started to change Team from NFLTeam
//      but noted many inconsistencies from current Controller Team setup
//      most of the code here can be eliminated!!
//  TO fix:
//    note conflict between current Player and NFLPlayer here
//    Controller builds Teams and loads players 
public class NFLTeam {
    
    /**
     * Team name
     */
    private String team;
       
    /**
     * List of all of the players on the team
     */
    private ArrayList<Player> players;
    private ArrayList<Player> offense;
    private ArrayList<Player> defense;

    /**
     * Constructor for objects of class NFLTeam
     * 
     * @param team - the team name
     */
    public NFLTeam(String team) {
        this.team = team;
        this.players = new ArrayList<Player>();
        offense = new ArrayList<Player>();
        defense = new ArrayList<Player>();
    }
    
    
    //Implement
    public void act() {
    
    }

    /**
     * Adds a player to the list of all players
     * 
     * @param player - the player to add to the list
     */
    public void addPlayer(Player player) {
        players.add(player);
    }
        
    /**
     * Removes a player from the list
     * 
     * @param player - the player to remove from the team list
     */
    public void removePlayer(Player player) {
        Iterator<Player> it = players.iterator();
        while (it.hasNext()) {
            if (it.next().equals(player)) {
                it.remove();
            }
        }
    }
    
    /** 
     * Adds player to offense
     * @param player - the player to add to offense
     */
    public void addPlayerToOffense(Player player)
    {
        offense.add(player);
    }
    
    /**
     * Adds player to defense
     * @param player - the player to add to defense
     */
    public void addPlayerToDefense(Player player)
    {
        defense.add(player);
    }

    /**
     * Gets a player with the specified name
     * 
     * @param name - the name of the player to get
     */
    public Player getPlayer(String name) {
        Iterator<Player> it = players.iterator();
        while (it.hasNext()) {
            Player player = it.next();
            if (player.equals(name)) {
                return player;
            }
        }
        return null;
    }
    
    /**
     * Gets a player by their position first and then by overall
     * 
     * @param pos - the pos of the player to get
     */
    public Player getPlayerByPos(String pos) {
        Iterator<Player> it = players.iterator();
        Player bestAtPos = null;
        while (it.hasNext()) {
            Player p = it.next();
            if (p.equals(pos)) {
                if (bestAtPos == null) {
                    bestAtPos = p;
                }
                if (bestAtPos != null && p != bestAtPos) {
                    bestAtPos = p;
                }
            }
        }
        return bestAtPos;
    }
    
    /**
     * Gets all of the players on the team
     * 
     * @return     the list of players
     */    
    public ArrayList<Player> getPlayers() {
        return players;
    }
    /**
     * Gets all of the players on the team
     * 
     * @return     the list of players
     */    
    public ArrayList<Player> getOffense() {
        return offense;
    }
    /**
     * Gets all of the players on the team
     * 
     * @return     the list of players
     */    
    public ArrayList<Player> getDefense() {
        return defense;
    }
    
    
    /**
     * Gets the team name
     * 
     * @return the team name
     */
    public String getTeamName() {
        return team;
    }
}
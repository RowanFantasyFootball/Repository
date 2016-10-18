 import java.util.*;

/**
 * Write a description of class NFLTeam here.
 * 
 * @author Joe Dunne, Joe Dementri, Michael Matthews
 * @version (a version number or a date)
 */
public class NFLTeam {
    
    /**
     * Team name
     */
    private String team;
       
    /**
     * List of all of the players on the team
     */
    private ArrayList<NFLPlayer> players;
    private ArrayList<NFLPlayer> offense;
    private ArrayList<NFLPlayer> defense;

    /**
     * Constructor for objects of class NFLTeam
     * 
     * @param team - the team name
     */
    public NFLTeam(String team) {
        this.team = team;
        this.players = new ArrayList<NFLPlayer>();
        offense = new ArrayList<NFLPlayer>();
        defense = new ArrayList<NFLPlayer>();
    }
    
    
    //Implement
    public void act() {
    
    }

    /**
     * Adds a player to the list of all players
     * 
     * @param player - the player to add to the list
     */
    public void addPlayer(NFLPlayer player) {
        players.add(player);
    }
        
    /**
     * Removes a player from the list
     * 
     * @param player - the player to remove from the team list
     */
    public void removePlayer(NFLPlayer player) {
        Iterator<NFLPlayer> it = players.iterator();
        while (it.hasNext()) {
            if (it.next().getFullName().equals(player.getFullName())) {
                it.remove();
            }
        }
    }
    
    /** 
     * Adds player to offense
     * @param player - the player to add to offense
     */
    public void addPlayerToOffense(NFLPlayer player)
    {
        offense.add(player);
    }
    
    /**
     * Adds player to defense
     * @param player - the player to add to defense
     */
    public void addPlayerToDefense(NFLPlayer player)
    {
        defense.add(player);
    }

    /**
     * Gets a player with the specified name
     * 
     * @param name - the name of the player to get
     */
    public NFLPlayer getPlayer(String name) {
        Iterator<NFLPlayer> it = players.iterator();
        while (it.hasNext()) {
            NFLPlayer player = it.next();
            if (player.getFullName().equalsIgnoreCase(name)) {
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
    public NFLPlayer getPlayerByPos(String pos) {
        Iterator<NFLPlayer> it = players.iterator();
        NFLPlayer bestAtPos = null;
        while (it.hasNext()) {
            NFLPlayer p = it.next();
            if (p.getPosition().equalsIgnoreCase(pos)) {
                if (bestAtPos == null) {
                    bestAtPos = p;
                }
                if (bestAtPos != null && p.getOverall() > bestAtPos.getOverall()) {
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
    public ArrayList<NFLPlayer> getPlayers() {
        return players;
    }
    /**
     * Gets all of the players on the team
     * 
     * @return     the list of players
     */    
    public ArrayList<NFLPlayer> getOffense() {
        return offense;
    }
    /**
     * Gets all of the players on the team
     * 
     * @return     the list of players
     */    
    public ArrayList<NFLPlayer> getDefense() {
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
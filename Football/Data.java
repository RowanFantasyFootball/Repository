import java.util.*;


/**
 * @author Joe Dunne
 */

public class Data {
	
	public static void main(String[] args) {
		Data data = new Data("NFL Players Master Sheet.xls");
    	for (NFLTeam team : data.getTeams()) {
    		System.out.println("Team: " + team.getTeamName());
    		System.out.println("Players: ");
    		for (NFLPlayer player : team.getPlayers()) {
    			System.out.println(player.toString());
    		}
    		System.out.println();
    	}
	}
	
	/**
	 * Loads data from an excel spreadsheet
	 */
	private Loader loader;
	
    /**
     * The list of NFL teams
     */
    private ArrayList<NFLTeam> teams;
    
    /**
     * Constructor for objects of class Data
     * 
     * @param location - the location of the excel spreadsheet file
     */
    public Data(String location) {
        teams  = new ArrayList<NFLTeam>();
        loader = new Loader(location);
        loadTeamData();
    }

    /**
     * Gets all of the teams in the NFL
     * 
     * @return the teams in the NFL list
     */
    public ArrayList<NFLTeam> getTeams() {
        return teams;
    }
    
    /**
     * Adds the specified team
     * 
     * @param team - the team to add
     */
    public void addTeam(NFLTeam team) {
        teams.add(team);
    }

    /**
     * Removes the specified team
     * 
     * @param team - the team to remove
     */
    public void removeTeam(NFLTeam team) {
        Iterator<NFLTeam> it = teams.iterator();
        while(it.hasNext()) {
            if (it.next().getTeamName().equals(team.getTeamName())) {
                it.remove();
            }
        }
    }
    
    /**
     * Loads the teams and its players from the list at once
     */
    public void loadTeamData() {
    	teams = getLoader().getTeams();
    	Iterator<NFLTeam> it = teams.iterator();
    	while (it.hasNext()) {
    		NFLTeam team = it.next();
    		if (team != null) {
	        	ArrayList<NFLPlayer> players = getLoader().getPlayerData(team.getTeamName());
	        	for (NFLPlayer player : players) {
	        		if (player != null) {
	        			team.addPlayer(player);
	        		}
	        	}
    		}
    	}
    }
    
    /**
     * Gets the loader instance
     * 
     * @return the excel file loader
     */
    public Loader getLoader() {
		return loader;
	}

	/**
     * Gets a specific team with the specified name
     * 
     * @param  name - the name of the team
     * @return the team you want
     */
    public NFLTeam getTeam(String name) {
        Iterator<NFLTeam> it = teams.iterator();
        while(it.hasNext()) {
            NFLTeam team = it.next();
            if (team.getTeamName().equals(name)) {
                return team;
            }
        }
        return null;
    }
}

 

import java.io.File;
import java.io.IOException;
import java.util.*;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Write a description of class Loader here.
 * 
 * @author Joe Dunne
 * @version (a version number or a date)
 */
public class Loader {
	
    /**
     * The path of the file with the player data
     */
    private final String location;
	
	/**
	 * Creates a new data loader
	 * 
	 * @param location the location of the file
	 */
	public Loader(String location) {
		this.location = location;
	}
	
    /**
     * Gets all of the teams in the NFL excel document
     * 
     * (Reads down the first column of an excel spreadsheet
     * 		assuming that its populated with team names only
     * 		from cell 0 to X)
     * 
     * @return all of the NFL teams read from the data cells
     */
    public ArrayList<NFLTeam> getTeams() {
        /**
         * Creates a list of teams to return
         */
        ArrayList<NFLTeam> teams = new ArrayList<NFLTeam>();
        
        try {
        	Sheet sheet = getSheetInstance();
            
            /**
             * Loops through the first column to grab all the team names
             */
            for (int i = 0; i < sheet.getRows(); i++) {
            	/**
            	 * Flag to stop duplicate teams being added
            	 */
                boolean add = true;
                
                /**
                 * Gets the contents of the cell as a string
                 */
                String contents = getContents(sheet, 0, i);
                
                /**
                 * Cycles through the list to make sure we dont add a duplicate
                 */
                for (NFLTeam team : teams) {
                    if (contents.equals(team.getTeamName())) {
                        add = false;
                    }
                }
                
                /**
                 * Adds the team to the list
                 */
                if (add) {
                    teams.add(new NFLTeam(contents));
                }
            }
            return teams;
        } catch (BiffException | IOException | IllegalThreadStateException e) { }
        return teams;
    }
    
	/**
     * 
     */
    public ArrayList<NFLPlayer> getPlayerData(String team) {
		/**
		 * List of players to return
		 */
		ArrayList<NFLPlayer> players = new ArrayList<NFLPlayer>();
		
    	try {
    		/**
    		 * Gets a worksheet to work from
    		 */
        	Sheet sheet = getSheetInstance();
            
            /**
             * Variable to store the contents of a cell in
             */
            String contents;
            
            /**
             * Loops through the first column to grab all the team names
             */
            for (int r = 0; r < sheet.getRows(); r++) {
            	/**
            	 * Grabs the team name
            	 */
            	contents = getContents(sheet, 0, r);
            	
                /**
                 * Creates a list of stats to add to the player
                 */
                ArrayList<String> stats = new ArrayList<String>();
                
            	/**
            	 * Stops reading if its a different team
            	 */
            	if (contents.equals(team)) {
	            	/**
	            	 * Adds every stat into one list
	            	 */
	            	for (int c = 0; c < sheet.getColumns(); c++) {
		                stats.add(getContents(sheet, c, r));
		            }
	
	            	/**
	            	 * Creates a new player with stats
	            	 */
	            	players.add(new NFLPlayer(stringListToArray(stats)));
            	}
            }
        } catch (BiffException | IOException | IllegalThreadStateException e) { }
    	return players;
    }
    
    /**
     * Gets a new excel sheet instance to work with
     * 
     * @return the sheet instance to be read
     * 
     * @throws BiffException - idk doesnt matter
     * @throws IOException	 - idk doesnt matter
     */
	public Sheet getSheetInstance() throws BiffException, IOException {
		/**
    	 * Loads the excel file to be read */
        File data = new File(getFileLocation());
        
        /**
         * Creates a new workbook instance
         */
        Workbook workbook = Workbook.getWorkbook(data);
        
        /**
         * returns a new sheet instance
         */
        return workbook.getSheet(0);
	}

	/**
     * Gets the contents of an excel cell
     * 
     * @param row - the row
     * @param column - the column
     * 
     * @return the contents in the specified cell
     */
    public String getContents(Sheet sheet, int column, int row) {
    	/**
         * Creates a new cell instance so it can be read by our program
         */
        Cell cell = sheet.getCell(column, row);
        /**
         * Gets the contents of the cell as a string
         */
        return cell.getContents();
	}

    /**
     * Turns an array list to an array
     * 
     * @param array - the list to convert to an array
     * 
     * @return the list converted into an array
     */
    public String[] stringListToArray(ArrayList<String> list) {
		String[] array = new String[list.size()];
		for (int x = 0; x < list.size(); x++) {
			array[x] = list.get(x);
		}
		return array;
	}

	/**
     * Gets the excel file location
     * 
     * @return the excel file location
     */
    public String getFileLocation() {
		return location;
	}
}

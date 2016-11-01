package game.field;

import java.util.ArrayList;

import actor.player.Player;

/**
 * This is a class which represents a football field in grid form, from this, we
 * are going to place each player in a respected spot on the grid to make a
 * formation. We are going to use this to represent movements and to recognize
 * collisions between players
 * 
 * What the field will look like
 * 
 * ================== <- Location (y = HEIGHT, x = WIDTH)
 * |	TopEndZone	|
 * |================|
 * |				|
 * |				|
 * |				|
 * |				|
 * |				|
 * |				|
 * |================|
 * | BottomEndZone	|
 * ==================
 * ^
 * | Location (y = 0, x = 0)
 * 
 * @author(Joseph Dunne)
 */
public class Field {
	/**
	 * The default width in 'yards', can be changed
	 */
	private static final int DEFAULT_WIDTH = 50;

	/**
	 * The default height of the field in 'yards', can be changed
	 */
	private static final int DEFAULT_HEIGHT = 100;

	/**
	 * The length of the end zones
	 */
	private static final int ENDZONE_LENGTH = 10;

	/**
	 * The Y Location of the top end zone (height - end zone length)
	 */
	private static final int TOP_ENDZONE_Y = DEFAULT_HEIGHT - ENDZONE_LENGTH;

	/**
	 * The Y Location of the bottom end zone (0 + end zone length)
	 */
	private static final int BOTTOM_ENDZONE_Y = ENDZONE_LENGTH;

	/**
	 * A list of locations which can be occupied by players on the field
	 */
	private ArrayList<Location> locations;

	/**
	 * Creates a field with the default dimension values
	 */
	public Field() {
		createField();
	}

	/**
	 * Tells you whether the input location is in an endzone or not This is
	 * going to be used to see if a player has scored on offense
	 * 
	 * @param location
	 *            - the location to check if in the endzone
	 * 
	 * @return true if the location is in the endzone
	 */
	public boolean isEndzone(Location location) {
		return location.getY() < BOTTOM_ENDZONE_Y || location.getY() > TOP_ENDZONE_Y;
	}

	/**
	 * Gets all of the locations currently on the field, occupied or not
	 * 
	 * @return the list of all locations on the field
	 */
	public ArrayList<Location> getAllLocations() {
		return locations;
	}

	/**
	 * Gets a list of all players on the field by checking if the tile is
	 * occupied and then adding it to the list which gets returned
	 * 
	 * @return the list of all players on the field
	 */
	public ArrayList<Player> getAllPlayersOnField() {
		ArrayList<Player> players = new ArrayList<Player>();
		for (Location loc : getAllLocations()) {
			if (loc.isTileOccupied()) {
				players.add(loc.getPlayer());
			}
		}
		return players;
	}

	/**
	 * Creates a field with the given length and width
	 * 
	 * This works by using two for loops, which represent x and y that both
	 * start from 0 and fills the grid with a new location as the increment.
	 * 
	 * This also keep
	 */
	private void createField() {
		locations = new ArrayList<Location>();
		for (int x = 0; x < DEFAULT_WIDTH; x++) {
			for (int y = 0; y < DEFAULT_HEIGHT; y++) {
				locations.add(new Location(x, y));
			}
		}
	}
}
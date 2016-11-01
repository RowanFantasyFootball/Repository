package game.field;

import actor.player.Player;

public class Location {

	/**
	 * The x co-ordinate of the location
	 */
	private int x;

	/**
	 * The y co-ordinate of the location
	 */
	private int y;

	/**
	 * The player thats currently assigned to this tile, if there is one.
	 * Otherwise it is going to return null
	 */
	private Player player;

	/**
	 * Creates a new location to be placed on the field grid
	 * 
	 * @param x
	 *            - the x co-ord to place the location
	 * @param y
	 *            - the y co-ord to place the location
	 */
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the x location of the tile
	 * 
	 * @return the x co-ordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y location of the tile
	 * 
	 * @return the y co-ordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Returns true if the tile is occupied by null checking the player value on
	 * the location
	 * 
	 * @return true of player != null, false if otherwise
	 */
	public boolean isTileOccupied() {
		return getPlayer() != null;
	}

	/**
	 * Determines if the player on this tile has collided with another player
	 * 
	 * @param location
	 *            - the location to check for a collision
	 * 
	 * @return true if there is a collision, which we will act on
	 */
	public boolean isCollision(Location location) {
		return isTileOccupied() && location.isTileOccupied() && location.getX() == getX() && location.getY() == getY();
	}

	/**
	 * Gets the current player on this location
	 * 
	 * @return the player that exists on the location
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * +1 moves right -1 moves left
	 * 
	 * @param steps
	 *            - the amount of steps to take right or left
	 */
	public void moveX(int steps) {
		this.x += steps;
	}

	/**
	 * +1 moves up -1 moves down
	 * 
	 * @param steps
	 *            - the amount of steps to take forward or backward
	 */
	public void moveY(int steps) {
		this.y += steps;
	}

	/**
	 * Removes the current player set on this location by setting the player
	 * value to null
	 */
	public void removePlayer() {
		player = null;
	}

	/**
	 * Assigns a player to this location
	 * 
	 * @param player
	 *            - the player to add to this tile location
	 */
	public void addPlayerToLocation(Player player) {
		this.player = player;
	}
}

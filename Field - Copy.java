import java.util.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/**
 * Write a description of class Field here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Field
{
    
    // The depth and width of the field.
    private int depth, width;
    // Storage for the animals.
    private Object[][] field;

    public Field(int depth, int width)
    {
        this.depth = depth;
        this.width = width;
        field = new Object[depth][width];
    }
    
        public void clear()
    {
        for(int row = 0; row < depth; row++) {
            for(int col = 0; col < width; col++) {
                field[row][col] = null;
            }
        }
    }
    
    /**
     * Clear the given location.
     * @param location The location to clear.
     */
    public void clearPlayer(Location location)
    {
        field[location.getRow()][location.getCol()] = null;
    }
            /**
     * Place an animal at the given location.
     * If there is already an animal at the location it will
     * be lost.
     * @param animal The animal to be placed.
     * @param row Row coordinate of the location.
     * @param col Column coordinate of the location.
     */
    public void place(String player, int row, int col)
    {
        //place(player, new Location(row, col));
    }
    /**
     * Place an player at the given location.
     * @param animal The animal to be placed.
     * @param row Row coordinate of the location.
     * @param col Column coordinate of the location.
     */
    public void setLocation(String player, Location Location)
    {
        Location newLocation = Location;
        //field.place(player, newLocation);
    }
    
    /**
     * Return the animal at the given location, if any.
     * @param row The desired row.
     * @param col The desired column.
     * @return The animal at the given location, or null if there is none.
     */
    public Object getObjectAt(int row, int col)
    {
        return field[row][col];
    }
    
    public int getDepth()
    {
        return depth;
    }
    
    public int getWidth()
    {
        return width;
    }
}

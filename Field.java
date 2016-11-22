import java.util.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/**
 * Write a description of class Field here.
 * 
 * @author Clinton Conyer
 * @version 11/21/2016
 */
public class Field
{
    
    // The depth and width of the field.
    private int depth, width;
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
    
    
    public int getDepth()
    {
        return depth;
    }
    
    public int getWidth()
    {
        return width;
    }
}

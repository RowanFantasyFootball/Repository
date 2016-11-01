 /**
 * Changed the use of the newQuarter variable. Changed quarter to an int.
 * newQuarter was previously pretty much a duplicate of the quarter variable
 * Also, all integers are set to 0 by default in Java.
 *
 */
public class Clock
{
    /**
     * The maximum amount of ticks in the game.
     */
    private int maxTicks;
    /*
     * The ticks that have gone by on the clock.
     */
    private String ticks;
    /*
     * The current quarter.
     */
    private int quarter;
    /*
     *A counter to recognize when we are in the next quarter.
     */
    private int nextQuarter;
    /**
     * Creates a game clock for the football simulator.
     *
     *@param MAX_TICKS - the maximum amount of ticks you want the game to reach.
     */
    public Clock(int MAX_TICKS)
    {
        this.maxTicks = MAX_TICKS;
        changeQuarter();
    }
    
    /**
     * Changes the quarter by incrementing and setting nextQuarter. 
     * Also, may change the quarter length.
     */
    public void changeQuarter()
    {
        quarter++;
        nextQuarter += maxTicks / 4;
    }
 
    /*
     * Increments by one tick.
     */
    public void tick()
    {
        ticks++;
    }
    
    /**
     * Returns the current amount of game ticks that you have passed.
     * 
     * @return ticks the current amount of game ticks that have went by in the game.
     */
    public int getTicks()
    {
        return ticks;
    }
 
    /**
     * Gets the game duration in terms of a tick.
     *
     *@return the amount of ticks the clock is counting to. 
     */
     public int getGameDuration()
     {
      return maxTicks;
     }
    
    /**
     * Inintializes the quarter for a new game, so that the game starts at quarter one (Q1)
     * 
     * @return NewQuarter returns the newQuarter after it is set to 1.
     */ 
    public int initializeQuarter()
    {
        newQuarter = 1;
        return newQuarter;
    }
    
    /**
     * Changes the quarter by incrementing newQuarter
     * 
     * @return newQuarter an int that determines what quarter that game is currently at.
     */
    public int changeQuarter()
    {
        newQuarter ++;
        return newQuarter;
    }
    
    /**
     * Will return the current quarter based on the field newQuarter.
     * 
     * @return quarter the current quarter.
     */
    public String getQuarter()
    {
         if(newQuarter == 1)
         {
             quarter = "Q1";            
         }
         else if(newQuarter == 2)
         {
             quarter = "Q2";             
         }
         else if(newQuarter == 3)
         {
             quarter = "Q3";             
         }
         else if(newQuarter == 4)
         {
            quarter = "Q4";            
         }
         else if(newQuarter > 4)
         {
             quarter = "End of Game";
         }
         return quarter;
    }
}

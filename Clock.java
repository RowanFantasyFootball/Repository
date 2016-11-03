 /**
  * Changed the use of the newQuarter variable. Changed quarter to an int.
  * newQuarter was previously pretty much a duplicate of the quarter variable
  * Also, all integers are set to 0 by default in Java.
  */
public class Clock
{
    /**
     * The maximum amount of ticks in the game.
     */
    private int maxTicks;
    /**
     * The ticks that have gone by on the clock.
     */
    private int ticks;
    /**
     * The current quarter.
     */
    private int quarter;
    /**
     * A counter to recognize when we are in the next quarter.
     */
    private int nextQuarter;
    /**
     * Creates a game clock for the football simulator.
     *
     * @param MAX_TICKS - the maximum amount of ticks you want the game to reach.
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
  
     /*
      * Returns true if the current quarter is over.
      *
      * @return true if the current quarter is over, false if not.
      */
     public boolean isQuarterOver()
     {
      return ticks >= nextQuarter;
     }
 
     /**
      * Determines whether or not the game is over.
      *
      * @return true if the game is over.
      */
      public boolean isRunning()
      {
       return ticks < maxTicks;
      }
 
      /**
       * Gets the current quarter recorded as a String object.
       *
       * Uses a switch statement to switch through all possible values of a quarter.
       * (1-4), then returns the String equivalent.
       *
       * @return  the String equivalent of the current quarter in the game.
       */
       @Override
       public String toString()
       {
        switch(quarter)
        {
         case 1:
          return "Q1";
         case 2:
          return "Q2";
         case 3: 
          return "Q3";
       }
        return "End of Game";
       } 
}

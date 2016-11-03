public class Clock
{
    private int ticks;
    private String quarter;
    private int newQuarter;
    
    /**
     * Clock constructor that iniliazes ticks and newQuarter to 0.    
     */
    public Clock()
    {
      ticks = 0;
      newQuarter = 0;
    }
    
    /**
     * Increments ticks by one everytime this method is called 
     * 
     */
    public void tick()
    {
        ticks ++;
    }
    
    /**
     * Returns the current int for ticks
     * 
     * @return ticks returns ticks.
     */
    public int getTicks(){
        return ticks;
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

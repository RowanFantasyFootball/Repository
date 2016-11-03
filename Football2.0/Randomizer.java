import java.util.Random;
/**
 * STUB for Randomizer
 * 
 * @author (sbw)   
 * @version (a version number or a date)
 */
public class Randomizer
{
    // instance variables - replace the example below with your own
    private Random rgen;

    /**
     * Constructor for objects of class Randomizer
     */
    public Randomizer()
    {
        // initialise instance variables
       rgen = new Random();
    }

    /**
     *   sbw: not sure what we call the method
     */
    public int getRand(int upperBoundExclusive)
    {
        // put your code here
        return rgen.nextInt(upperBoundExclusive);
    }
}

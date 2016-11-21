

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClockTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClockTest
{
    /**
     * Default constructor for test class ClockTest
     */
    public ClockTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testChangeQuarter()
    {
        Clock clock1 = new Clock(360);
        clock1.changeQuarter();
    }

    @Test
    public void testTick()
    {
        Clock clock1 = new Clock(360);
        clock1.tick();
        assertEquals(1, clock1.getTicks());
    }

    @Test
    public void testGetGameDuration()
    {
        Clock clock1 = new Clock(360);
        assertEquals(360, clock1.getGameDuration());
    }
}




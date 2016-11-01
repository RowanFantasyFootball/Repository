package actor;

import plays.Play;

/**
 * The Actor Interface is used to allow the Controller Class to implement the act() methods for each 
 * individual Actor/Class.
 * 
 * @author (John Donahue) 
 * @version (10/13/2016)
 * 
 */
public interface Actor {
    
    /**
     * Acts a player
     * 
     * @param play - the play to operate
     */
    public void act(Play play);
    
}
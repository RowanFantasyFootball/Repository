package actor.player.types.offense.positions;

import actor.player.POSITION;
import actor.player.types.offense.OffensivePlayer;
import plays.Play;

public class QuarterBack extends OffensivePlayer {

	/**
	 * The Quarter backs accuracy
	 */
	private int accuracy;
	
	/**
	 * Creates an instance of a Quarter Back 
	 * 
	 * @param accuracy - the QB's throwing accuracy
	 */
	public QuarterBack(String first, String last, int speed, int strength, int accuracy) {
		super(first, last, speed, strength, true);
		this.accuracy = accuracy;
	}
	
	@Override
	public void act(Play play) {
		//Act on the player here
	}

	@Override
	public POSITION getPosition() {
		return POSITION.QUATERBACK;
	}
	
	/**
     * Gets the accuracy of this QB
     * 
     * @return the accuracy of this QB
     */
    public int getAccuracy() {
        return accuracy;
    }
}

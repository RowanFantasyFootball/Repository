

/**
 * This is an abstract class (Not to be instantiated on its own) which creates a
 * new Play object that assigns movements to each player on the team
 * 
 * @author Joe D
 */
public abstract class Play {
	/**
	 * The maximum potential for a successful play
	 */
	public static final int MAX_SUCCESS_POTENTIAL = 100;

	/**
	 * The type of play were running
	 */
	private PLAY_TYPE TYPE;
	
	/**
	 * 
	 * @param center
	 */
	public Play(PLAY_TYPE TYPE) {
		this.TYPE = TYPE;
	}
		
	/**
	 * An abstract method to assign player movements to each player on the field
	 * 
	 * @param PLAYER - the player to get the movement pattern for
	 */
	public abstract Location getMovement(Player player);
		
	/**
	 * 
	 * @return
	 */
	public abstract Player getBallCarrier();
	
	/**
	 * 
	 * @return
	 */
	public PLAY_TYPE getType() {
		return TYPE;
	}
	
}

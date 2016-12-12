
public class Message {

	/**
	 * The message code
	 */
	private int code;

	/**
	 * The current tick for the message
	 */
	private int tick;

	/**
	 * The current yardage for the message
	 */
	private int newLine;

	/**
	 * The line of scrimage before the play was executed
	 */
	private int oldLine;

	/**
	 * The player in the message
	 */
	private Player player;

	/**
	 * Creates a new message for the controller
	 * 
	 * @param player
	 *            - the player in the message
	 * @param code
	 *            - the message code
	 * @param tick
	 *            - the tick from the controllers clock
	 * @param newLine
	 *            - the new yardLine we ended up on
	 * @param oldLine
	 *            - the old yardline we were on before the play
	 */
	public Message(Player player, int code, int tick, int newLine, int oldLine) {
		this.tick = tick;
		this.code = code;
		this.player = player;
		this.newLine = newLine;
		this.oldLine = oldLine;
	}

	/**
	 * Doesn't account for touchdowns yet
	 * 
	 * @return the yardaged gained based off the difference of the lines of
	 *         scrimages
	 */
	public int getYardageGained() {
		return newLine - oldLine;
	}

	/**
	 * 
	 * @return
	 */
	public int getMessageCode() {
		return code;
	}

	/**
	 * 
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * 
	 * @return
	 */
	public int getTick() {
		return tick;
	}

	/**
	 * 
	 * @return
	 */
	public String showMessage() {
		return "Gain of: " + getYardageGained() + " yards and just " + PlayerStat.getOV().get(getMessageCode())
				+ " at tick: " + tick;
	}
}
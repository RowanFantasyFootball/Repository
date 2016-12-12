
/**
 * A class that determines movements for each position based on the current play
 */
public class OffensivePlay extends Play {

	/**
	 * The ball carrier on the play
	 */
	private Player ballCarrier;

	/**
	 * Creates a new offensive play
	 * 
	 * @param players
	 *            - the list of players to update their position
	 */
	public OffensivePlay(PLAY_TYPE TYPE) {
		super(TYPE);
	}

	@Override
	public Location getMovement(Player player) {
		setBallCarrier(player);
		switch (player.getPosition()) {
		case OFFENSIVE_LINEMAN:
			return new Location(player.getLineupLocation().getX() + Randomizer.getRandomNumber(10),
					player.getLineupLocation().getY() + Randomizer.getRandomNumber(15));
		case RUNNINGBACK:
			return new Location(player.getLineupLocation().getX() + Randomizer.getRandomNumber(10),
					player.getLineupLocation().getY() + Randomizer.getRandomNumber(15));
		case WIDE_RECIEVER:
			return new Location(player.getLineupLocation().getX() + Randomizer.getRandomNumber(10),
					player.getLineupLocation().getY() + Randomizer.getRandomNumber(15));
		case QUARTERBACK:
			return new Location(player.getLineupLocation().getX() + Randomizer.getRandomNumber(5),
					player.getLineupLocation().getY() + Randomizer.getRandomNumber(10));
		}
		return null;
	}

	/**
	 * Sets the ball carrier on the play
	 * 
	 * @param player
	 *            - the player to potentially give the ball to
	 */
	private void setBallCarrier(Player player) {
		if (getBallCarrier() == null) {
			switch (getType()) {
			case PASS:
				if (player.getPosition().equals(POSITION.WIDE_RECIEVER)) {
					ballCarrier = player;
				}
			case QBSNEAK:
				if (player.getPosition().equals(POSITION.QUARTERBACK)) {
					ballCarrier = player;
				}
			case RUN:
				if (player.getPosition().equals(POSITION.RUNNINGBACK)) {
					ballCarrier = player;
				}
			default:
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Play#getBallCarrier()
	 */
	@Override
	public Player getBallCarrier() {
		return ballCarrier;
	}
}

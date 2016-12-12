
public class DefensivePlay extends Play {

	/**
	 * Creates a new offensive play
	 * 
	 * @param players
	 *            - the list of players to update their position
	 */
	public DefensivePlay(PLAY_TYPE TYPE) {
		super(TYPE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Play#getMovement(Player)
	 */
	@Override
	public Location getMovement(Player player) {
		switch (player.getPosition()) {
		case DEFENSIVE_BACK:
			return new Location(player.getLineupLocation().getX() - Randomizer.getRandomNumber(10),
					player.getLineupLocation().getY() + Randomizer.getRandomNumber(15));
		case DEFENSIVE_LINEMAN:
			return new Location(player.getLineupLocation().getX() - Randomizer.getRandomNumber(10),
					player.getLineupLocation().getY() + Randomizer.getRandomNumber(15));
		case LINEBACKER:
			return new Location(player.getLineupLocation().getX() - Randomizer.getRandomNumber(10),
					player.getLineupLocation().getY() + Randomizer.getRandomNumber(15));
		default:
			break;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Play#getBallCarrier()
	 */
	@Override
	public Player getBallCarrier() {
		return null;
	}
}
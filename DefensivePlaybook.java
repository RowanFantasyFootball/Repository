/**
 *
 */
public class DefensivePlaybook
{
	/**
	 * Gets a random offensive play.
	 * 
	 * @return
	 */
	public static OffensivePlay getRandomPlay()
	{
		switch(DEFENSIVE_PLAY_TYPE.getRandomDefensivePlayType())
		{
		case PASS:
			break;
		case QBSNEAK:
			break;
		case RUN:
			break;
		default:
			break;
		}
		return null;
	}
}


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayerStat implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private ArrayList<Message> messages;

	/**
	 * The overview messages for the GUI
	 */
	private final ArrayList<String> overviews;

	/**
	 * 
	 */
	private static HashMap<Integer, String> ov;

	/**
	 * ov is a HashMap of the pre-made messages that will be displayed when the
	 * Player class sends us the message overviews is an ArrayList that shows
	 * how many of each stat ahs been done
	 */
	public PlayerStat() {
		messages = new ArrayList<Message>();

		ov = new HashMap<Integer, String>();
		ov.put(1, "Touch Downs\n");
		ov.put(2, "First Down\n");
		ov.put(3, "Turn Overs\n");
		ov.put(4, "Successful Plays");
		ov.put(5, "Unsuccessful Plays");

		overviews = new ArrayList<String>();
		overviews.add(" : total touchdowns scored.");
		overviews.add(" : total first downs");
		overviews.add(" : total turn overs");
		overviews.add(" : total successful plays");
		overviews.add(" : total unsuccessful plays");
	}

	/**
	 * @return the messages
	 */
	public ArrayList<Message> getMessages() {
		return messages;
	}

	/**
	 * @return ov returns HashMap of ov(overview messages)
	 */
	public static HashMap<Integer, String> getOV() {
		return ov;
	}

	/**
	 * @return reformatted returns the newly formated String with the characters
	 *         replaces
	 */
	public String overviewToString() {
		return ov.toString().replace(",", "-").replace("{", "-").replace("}", "").trim();
	}
	
	/**
	 * 
	 * @param message
	 * @throws InvalidMessageException
	 */
	public void updateMessage(Message message, GUI gui) {
		if (message.getMessageCode() > getOV().size()) {
			try {
				throw new InvalidMessageException();
			} catch (InvalidMessageException e) {
				e.printStackTrace();
			}
		}
		messages.add(message);
		gui.newMessage(message.showMessage());
	}

	/**
	 * @param messageCode
	 *            - the message code for the play outcome we want to display
	 * 
	 * @return the string value of the amount of plays execeuted with the
	 *         specified message code
	 */
	public String getPlayOverview(int messageCode) {
		return ov.get(messageCode);
	}

	/**
	 * Shows the overview of each player on a team
	 * 
	 * @param team
	 *            - the team to show the overview of
	 */
	public void showPlayerStats(NFLTeam team) {
		team.getOffensivePlayers().forEach(player -> {
			messages.stream().filter(message -> message.getPlayer().equals(player))
					.forEachOrdered(message -> System.out.println(message.showMessage()));
		});
	}

	/**
	 * Shows all of the overviews
	 */
	public void showAllOverviews() {
		for (Message m : messages) {
			System.out.println(m.showMessage());
		}
	}
}

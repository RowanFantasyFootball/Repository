
/**
 * A class used to track the overall progress of a team
 * 
 * Please dont modify this class
 */
public class TeamOverview {

	private int touchdowns;

	private int turnovers;

	private int firstdowns;

	private int successful;

	private int unsuccessful;
	
	private int down;

	private int yardage;

	public int getTouchdowns() {
		return touchdowns;
	}

	public int getTurnovers() {
		return turnovers;
	}

	public int getFirstdowns() {
		return firstdowns;
	}

	public int getSuccessful() {
		return successful;
	}

	public int getUnsuccessful() {
		return unsuccessful;
	}
	
	public int getScore() {
		return touchdowns * 7;
	}
	
	public int getYardage() {
		return yardage;
	}

	public void touchdown() {
		touchdowns++;
	}

	public void turnover() {
		turnovers++;
	}

	public void firstDown() {
		firstdowns++;
	}

	public void successfulPlay() {
		successful++;
	}

	public void unsuccessfulPlay() {
		unsuccessful++;
	}

	public void gainedYardage(int yardage) {
		this.yardage += yardage;
	}
}

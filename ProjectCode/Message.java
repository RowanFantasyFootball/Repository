package v1;

public class Message {

	private int messageCode;
	private Player playerName;
	private int tick;
	private int yardage;
	private int ballPosition;
	
	public Message(int messageCode, Player playerName, int tick, int yardage, int ballPosition) {
		this.messageCode = messageCode;
		this.ballPosition = ballPosition;
		this.playerName = playerName;
		this.yardage = yardage;
		this.tick = tick;
	}
	
	public int getBallPosition()
	{
		return ballPosition;
	}
	
	public int getMessageCode()
	{
		return messageCode;
	}
	
	public Player getPlayerName()
	{
		return playerName;
	}
	
	public int getTick()
	{
		return tick;
	}
	
	public void showMessage()
	{
		System.out.println(playerName.getName() + " at " + yardage +  " just " + PlayerStat.getOV().get(messageCode) + " at " + tick);
	}
}

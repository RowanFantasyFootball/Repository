 

public class Message {

    private int messageCode;
    private Player playerName;
    private int tick;
    private int yardage;
    private int ballPosition;
    
    private String position;
    private int overall;
    private int speed;
    private int strength;
    
    private PlayerStat stat;
    
    public Message(int messageCode, Player playerName, int tick, int yardage, int ballPosition) 
    {
        this.messageCode = messageCode;
        this.ballPosition = ballPosition;
        this.playerName = playerName;
        this.yardage = yardage;
        this.tick = tick;
    }
    
    public Message(String position, int overall, int speed, int strength)
    {
        this.position = position;
        this.overall = overall;
        this.speed = speed;
        this.strength = strength;
    }
    
    public String getPlayerPosition()
    {
        return position;
    }
    
    public int getPlayerOverall()
    {
        return overall;
    }
    
    public int getPlayerSpeed()
    {
        return speed;
    }
    
    public int getPlayerStrength()
    {
        return strength;
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
        System.out.println(yardage +  " just " + stat.getOV().get(messageCode) + " at " + tick);
    }
}

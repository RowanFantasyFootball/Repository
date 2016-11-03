/**
 * 
 * @author 
 *
 */
public class Message 
{
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
    
    /**
     * 
     * @param stat
     * @param messageCode
     * @param playerName
     * @param tick
     * @param yardage
     * @param ballPosition
     */
    public Message(PlayerStat stat, int messageCode, Player playerName, int tick, int yardage, int ballPosition) 
    {
        this.messageCode = messageCode;
        this.ballPosition = ballPosition;
        this.playerName = playerName;
        this.yardage = yardage;
        this.tick = tick;
    }
    
    /**
     * 
     * @return
     */
     public int getMessageCode()
    {
        return messageCode;
    }
    
     /**
      * 
      */
    public void showMessage()
    {
        System.out.println(yardage +  " just " + stat.getOV().get(messageCode) + " at " + tick);
    }
}
 

import java.util.Iterator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayerStat implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Message> messages;
	private static HashMap ov;
	
	public PlayerStat() 
	{
		messages = new ArrayList<Message>();
		ov = new HashMap<Integer, String>();
		ov.put(1, "Successful play");
		ov.put(2, "First Down");
		ov.put(3, "Touchdown");
		ov.put(4, "Turn over");
		ov.put(5, "Injury");
		ov.put(6, "Incomplete Pass");
	}
	
	/**
	 * @return the messages
	 */
	public ArrayList<Message> getMessages() 
	{
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(ArrayList<Message> messages) 
	{
		this.messages = messages;
	}
	
	public static HashMap<Integer, String> getOV()
	{
		return ov;
	}
	
	/**
	 * @param messageNumber What message number are you looking more there are 8 variables right now
	 * @param name The name of the player that performed the action
	 * @param time What time the action happened at
	 * @param goodKick Only used if calling message 4 (Field Goal) used to see if the kick was good
	 * 
	 * This is a method where the Player class can pass the name of the player the message number that they need and 
	 * also the time that the action happened at. The method will go through the int message that they passed to us 
	 * and we will decide if it will turn display a message to the screen or not, but every call will update the spread
	 * sheet and our personal record with how many times the action was called
	 */
	public void updateMessage(int messageCode, int tick, int yardage, int ballPosition, Player player) throws Exception
	{
		if(messageCode > getOV().size())
		{
			System.out.println("Invalid message code. Must be less then 6.");
		}
		else
		{
			Message updatedMessage = new Message(messageCode, player, tick, yardage, ballPosition);
			messages.add(updatedMessage);
			updatedMessage.showMessage();
		}
	}
	
	public void getTouchdownOverview()
	{
		Iterator<Message> it = messages.iterator();
		int td = 0;
		while(it.hasNext())
		{
			Message msg = it.next();
			if(msg.getMessageCode() == 3)
			{
				td++;
			}
		}
		System.out.println(td + " : total touchdowns scored.");
	}
	
	public void getFirstDownOverview()
	{
		Iterator<Message> it = messages.iterator();
		int fd = 0;
		while(it.hasNext())
		{
			Message msg = it.next();
			if(msg.getMessageCode() == 2)
			{
				fd++;
			}
		}
		System.out.println(fd + " : total first downs");
	}
	
	public void getTurnOverOverview()
	{
		Iterator<Message> it = messages.iterator();
		int to = 0;
		while(it.hasNext())
		{
			Message msg = it.next();
			if(msg.getMessageCode() == 4)
			{
				to++;
			}
		}
		System.out.println(to + " : total turn overs");
	}
	
	public void getInjuryOverview()
	{
		Iterator<Message> it = messages.iterator();
		int inj = 0;
		while(it.hasNext())
		{
			Message msg = it.next();
			if(msg.getMessageCode() == 5)
			{
				inj++;
			}
		}
		System.out.println(inj + " : total injuries");
	}
		
	public void getIncomepletePassOverview()
	{
			Iterator<Message> it = messages.iterator();
			int ip = 0;
			while(it.hasNext())
		{
			Message msg = it.next();
			if(msg.getMessageCode() == 6)
			{
				ip++;
			}
		}
		System.out.println(ip + " : total incomeplete passes");
	}
	
	public void getSuccessfulPlayOverview()
	{
			Iterator<Message> it = messages.iterator();
			int sp = 0;
			while(it.hasNext())
		{
			Message msg = it.next();
			if(msg.getMessageCode() == 1)
			{
				sp++;
			}
		}
		System.out.println(sp + " : total successful plays ");
	}
}


 

import java.util.Iterator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayerStat implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Message> messages;
	private static HashMap ov;
	private int score;
	private int down;
	private ArrayList<String> overviews = new ArrayList<>();
	private int totalYardage;
	private int downP;
	
	/**
	 * ov is a HashMap of the pre-made  messages that will be displayed when the Player class sends us the message
	 * overviews is an ArrayList that shows how many of each stat ahs been done
	 */
	public PlayerStat() 
	{
		messages = new ArrayList<Message>();
		ov = new HashMap<Integer, String>();
		ov.put(1, "Touch Downs\n");
		ov.put(2, "First Down\n");
		ov.put(3, "Turn Over\n");
		ov.put(4, "Injury\n");
		ov.put(5, "Incomeplete Passes\n");
		ov.put(6, "Successful Plays");
		overviews.add(" : total touchdowns scored.");
		overviews.add(" : total first downs");
		overviews.add(" : total turn overs");
		overviews.add(" : total injuries");
		overviews.add(" : total incomeplete passes");
		overviews.add(" : total successful plays");
		
	}
	
	/**
	 * @return the messages
	 */
	public ArrayList<Message> getMessages() 
	{
		return messages;
	}
	
	/**
	 * @return ov returns HashMap of ov(overview messages)
	 */
	public static HashMap<Integer, String> getOV()
	{
		return ov;
	}
	
	/**
	 * @return reformatted returns the newly formated String with the characters replaces
	 */
	public String overviewToString()
	{
		String reformatted = ov.toString()
									  .replace(",", "-")
									  .replace("{", "-")
									  .replace("}", "")
									  .trim();
									  
		return reformatted;
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
	
	public int getScore()
	{
		return score;
	}
	
	public void updateMessage(int messageCode, int tick, int yardage, int ballPosition, Player player)
	{
		if(messageCode > getOV().size())
		{
			try 
			{
				throw new Exception();
			}	
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			Message updatedMessage = new Message(messageCode, player, tick, yardage, ballPosition);
			messages.add(updatedMessage);
			updatedMessage.showMessage();
			if(messageCode == 1)
			{
				score = score + 7;
// 				if (Team instanceof home)
// 				{
// 					GUI.setHomeScore(score);
// 				}
// 				else if(Team instanceof away)
// 				{
// 					GUI.setAwayScore(score);
// 				}
			}
			if(messageCode == 2)
			{
				down = 1;
				downP = updatedMessage.getBallPosition() + 10;
				if(downP > 100)
				{
					downP = 100;
				}
			}
			
			if(messageCode == 6)
			{	
				if( down < 4)
				{
					down++;
// 					GUI.setDown(down);
// 					if(downP-ballPosition < downP)
// 					{
// 						GUI.yardageToFirst(downP-ballPosition);
// 						GUI.setYardMarker(ballPosition);
// 					}
				}
				else
				{
// 					down = 1;
// 					GUI.setDown(down);
				}
			}
			totalYardage =+ yardage;
// 			GUI.newMessage(updatedMessage.showMessage());
		}
	}
	
	/**
	 * @param messageCode The play that you are trying to get the overview for in the same format as ov
	 * @return ov Returns the amount of times a play has been done depending on what message you are looking for
	 */
	public String getPlayOverview(int messageCode)
	{
		Iterator<Message> it = messages.iterator();
		int ov = 0;
		while(it.hasNext())
		{
			Message msg = it.next();
			if(msg.getMessageCode() == messageCode)
			{
				ov++;
			}
		}
		return ov + overviews.get(messageCode);
	}
	
    //Shows the overview of each Player and what they have done
 	public void showStatsTeamOne()
	{
		ArrayList<Message> m = null;
// 		ArrayList<Player> p = Team.getTeams(1).getPlayers();
// 		Iterator<Player> it = p.iterator();
		int i = 0;
// 	    while(it.hasNext())
// 	    {
// 	    	Player pl = it.next();
// 	    	if(pl == messages.get(i).getPlayer())
// 	    	{
// 	    		m.add(messages.get(i));
// 	    	    m.get(i).showMessage();
// 	    		i++;
// 	    	}
// 	    	else
// 	    	{
// 	    		i++;
// 	    	}
// 	    }
	}
 	
 	// Shows the overview of each Player on the team and what they have done
 	public void showStatsTeamTwo()
	{
		ArrayList<Message> message = null;
// 		ArrayList<Player> p2 = Team.getTeam(2).getplayers();
// 		Iterator<Player> it = p2.iterator();
		int i = 0;
// 		while(it.hasNext())
// 		{
// 			Player p = it.next();
// 			if(p == messages.get(i).getPlayer())
// 			{
// 				message.add(messages.get(i));
// 				message.get(i).showMessage();
// 				i++;
// 			}
// 			else
// 			{
// 				i++;
// 			}	
// 		}			
	}
 	
 	/**
 	 * Goes through the messages and prints them all this is used for out GUI that we have made
 	 */
 	public void showOverview()
 	{
 		for(Message m : messages)
 		{
 			System.out.println(m.showMessage());
 		}
 	}
}


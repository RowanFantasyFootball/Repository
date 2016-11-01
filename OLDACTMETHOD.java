 

public class OLDACTMETHOD {
	
}
    // String positionWithBall;
    /**
    String qb = "quarterback";
    String wr = "wide-receiver";
    String rb = "running-back";
    String kr = "kick-returner";
    String pr = "punt-returner";
    String k = "kicker";
    String p = "punter";
    String def = "defenseman";
    
    boolean runPlay = false;
    boolean completePass = false;
    boolean tackle = false;
    boolean kickBall = false;
    boolean puntBall = false;
    boolean fieldGoal = false;
    boolean hasBall = false;
    
    int score = 0;
    int yardage = 0;
    int yardsTillEndZone = 30;
    int tickNum = 0;
    int positionOfBall = 0; 

	public void act() {
	/*  
     * START OFFENSIVE PLAYS
     * 
     * quarterback hands ball to running back
     * 
     * act2() will decide how far the running back goes
     *
    
    if (runPlay){
        //change position of the ball to that of rb
        positionWithBall = rb;
    
        //add on a certain amount of yards
        yardage = 0;
        positionOfBall = positionOfBall;
        act2();
    }
  
    
    /*
     * quarterback throws ball to wide receiver for a complete pass
     * if the receiver is good, they'll have caught the ball for more yards
     * if they aren't so good, it will have been a shorter catch
     * 
     * act2() will decide what happens after the wide receiver catches the ball
     * they can get tackled immediately or run for yards after the catch
     *
    
    else if (completePass){
        //change position of the ball to that of wr who caught ball
        positionWithBall = wr;
    
        //add on a certain amount of yards
        if ((getOverall() + getSpeed() + getStrength()) > 210){
            yardage = 15;
            act2();
        }
        
        else {
            yardage = 10;
            act2();
        }
    }
   
    
    /*
     * quarterback throws ball to wide receiver for an incomplete pass
     * this means the ball position stays the same
     * 
     * act2() does not need to do much
     * since the pass was incomplete 
     *
    
     else if (!completePass){
        //keep position of the ball to that of qb
        positionWithBall = qb;
    
        //add on zero yards
        yardage = 0;
        act2();
    }
    
    
    /*START SPECIAL TEAMS PLAYS
     * this statement will cover from from when the kicker has the ball up until the kick
     * returner catches the ball
     * 
     * act2() will decide how far the ball advances up the field
     * when the kick returner returns it
     *
    
    else if (kickBall){
        /*
         * this statement will cover from from when the kicker has the ball up until the kick
         * returner catches the ball
         * act2() will decide how far the ball advances up the field
         *
        //position with the ball is kicker
        positionWithBall = k;
    
        //add on a certain amount of yards depending on the strength and ability of the kicker
         if ((getOverall() + getStrength()) > 120){
            yardage = 50;
            act2();
        }
        
        else {
            yardage = 40;
            act2();
        }
    }
   
    
    /*
     * this statement will cover from from when the kicker has the ball up until the kick
     * returner catches the ball
     * 
     * act2() will decide how far the ball advances up the field
     * when the kick returner returns it
     *
    
    else if (puntBall){
        //position with the ball is punter
        positionWithBall = p;
    
        //add on a certain amount of yards depending on the strength and ability of the punter
        if ((getOverall() + getStrength()) > 120){
            yardage = 40;
            act2();
        }
        
        else {
            yardage = 35;
            act2();
        }
    }
   
    
    /*
     * this statement will cover from from when the kicker has the ball up until he
     * kicks it for an attempted field goal.  Position will stay the same 
     * 
     * act2() will decide if the kick is good.
     * If the kick is good, add three points and restart for a kickoff
     * If the kick is not good, the position of the ball is the same, but possesion switches
     *
    
    else if (fieldGoal){
        //position with the ball is kicker
        positionWithBall = k;
        
        act2();
    }
    
    /*
     * this should be able to be taken out eventually, but this is a blanket else statement
     * in case the previous cases are not yet sufficient for every scenario.
     *
    else {
        act2();
    }
}

/**
 * Act2 will send messages to playerstats and controlls the ball after the Act1
 * updateMessage(int messageCode, int tick, int yardage, int positionOfBall, Player player)
 *
public void act2() {
    /*
     * message code:
     * 1 = successful play
     * 2= first down
     * 3 = touchdown
     * 4 = turnover
     * 5= injury
     * 6 = incomplete pass
     * 7 = feild goal
     *
    
    int msg = 0;
     if (runPlay){
        //add on a certain amount of yards
         if ((getOverall() + getSpeed() + getStrength()) > 210){
            yardage = 10;
            //first down
            msg = 2;
            try{
            tickNum = clock.getTicks();
            //stat.updateMessage(msg, tickNum , yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        else {
            yardage = 5;
            //first down
            msg = 1;
            
          try{
            tickNum = clock.getTicks();
            //stat.updateMessage(msg, tickNum , yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
  
    
    
    
    else if (completePass){
        //change position of the ball to that of wr who caught ball
        positionWithBall = wr;
    
        //add on a certain amount of yards
        if ((getOverall() + getSpeed() + getStrength()) > 210){
            yardage = yardage + 10;
            //first down
            msg = 2;
         try{
            tickNum = clock.getTicks();
            //stat.updateMessage(msg, tickNum , yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        else {
            //first down
           msg = 2;
           yardage = yardage + 5;
           try{
            tickNum = clock.getTicks();
            //stat.updateMessage(msg, tickNum , yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
   
    
    /*
     * quarterback throws ball to wide receiver for an incomplete pass
     * this means the ball position stays the same
     * 
     * act2() does not need to do much
     * since the pass was incomplete 
     *
    
     else if (!completePass){
        //keep position of the ball to that of qb
        positionWithBall = qb;
    
        //add on zero yards
        yardage = 0;
        //incomplete pass
        msg = 6;
        try{
            tickNum = clock.getTicks();
            //stat.updateMessage(msg, tickNum , yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }catch(Exception e)
            {
                System.out.println(e);
            }
    }
    
    
    
    else if (kickBall){
        /*
         * this statement will cover from from when the kicker has the ball up until the kick
         * returner catches the ball
         * act2() will decide how far the ball advances up the field
         *
        //position with the ball is kick-returner
        positionWithBall = kr;
    
        //add on a certain amount of yards depending on the strength and ability of the kicker
         if ((getOverall() + getStrength()) > 120){
            //return for ten yards
            yardage = yardage - 10;
            //turnover
            msg = 4;
            try{
            tickNum = clock.getTicks();
            //stat.updateMessage(msg, tickNum , yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        else {
            //return for five yards
            yardage = yardage - 5;
            //turnover
            msg = 4;
            try{
            tickNum = clock.getTicks();
            //stat.updateMessage(msg, tickNum , yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    
    else if (puntBall){
        /*
         * this statement will cover from from when the kicker has the ball up until the kick
         * returner catches the ball
         * act2() will decide how far the ball advances up the field
         *
        //position with the ball is kick-returner
        positionWithBall = pr;
    
        //add on a certain amount of yards depending on the strength and ability of the kicker
         if ((getOverall() + getStrength()) > 120){
            //return for ten yards
            yardage = yardage - 10;
            //turnover
            msg = 4;
            try{
            tickNum = clock.getTicks();
            //stat.updateMessage(msg, tickNum , yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        else {
            //return for five yards
            yardage = yardage - 5;
            //turnover
            msg = 4;
            try{
            tickNum = clock.getTicks();
            //stat.updateMessage(msg, tickNum , yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    /*
     * this statement will cover from from when the kicker has the ball up until he
     * kicks it for an attempted field goal.  Position will stay the same 
     * 
     * act2() will decide if the kick is good.
     * If the kick is good, add three points and restart for a kickoff
     * If the kick is not good, the position of the ball is the same, but possesion switches
     *
    
    else if (fieldGoal){
        
        //see if kick is good
        if(getOverall()/2 > yardsTillEndZone)//currently hard coded as 30 
        {
            positionWithBall = k;
            //feild goal
            msg = 7;
            try{
            tickNum = clock.getTicks();
            //stat.updateMessage(msg, tickNum , yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }else 
        {
            //Other teams qb
            positionWithBall = qb;
            //turnover
            msg = 4;
            try{
            tickNum = clock.getTicks();
            //stat.updateMessage(msg, tickNum , yardage, (positionOfBall + yardage), player);//this should not compile until shared and commited with Stats message class
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

}
*/

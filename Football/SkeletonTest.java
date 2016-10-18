import java.time.Clock;
import java.util.ArrayList;
/**
 * Write a description of class SkeletonTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkeletonTest
{
    static int LOS;
    static int firstDownMarker;
    static int down;
    final static int offEndzone = 100;
    final static int defEndzone = 0;
    static boolean offHasBall = true;
    
    public static Data data;
    private static NFLTeam fortyNiners, bears;
    private static ArrayList<NFLTeam> teams;
    private static ArrayList<NFLPlayer> daBears;
    private static ArrayList<NFLPlayer> daFortyNiners;
    
    public static void main(String[] args)
    {
        data = new Data("NFL Players Master Sheet.xls");
        teams = data.getTeams();
        fortyNiners = teams.get(1);
        daFortyNiners = new ArrayList<NFLPlayer>();
        daFortyNiners.add(fortyNiners.getPlayerByPos("QB"));
        daFortyNiners.add(fortyNiners.getPlayerByPos("HB"));
        daFortyNiners.add(fortyNiners.getPlayerByPos("WR"));
        daFortyNiners.add(fortyNiners.getPlayer("Torrey Smith"));
        daFortyNiners.add(fortyNiners.getPlayer("Jerome Simpson"));
        daFortyNiners.add(fortyNiners.getPlayerByPos("TE"));
        daFortyNiners.add(fortyNiners.getPlayerByPos("K"));
        daFortyNiners.add(fortyNiners.getPlayerByPos("P"));
        
        bears = teams.get(2);
        daBears = new ArrayList<NFLPlayer>();
        daBears.add(bears.getPlayerByPos("QB"));
        daBears.add(bears.getPlayerByPos("HB"));
        daBears.add(bears.getPlayerByPos("WR"));
        daBears.add(bears.getPlayer("Eddie Royal"));
        daBears.add(bears.getPlayer("Kevin White"));
        daBears.add(bears.getPlayerByPos("TE"));
        daBears.add(bears.getPlayerByPos("K"));
        daBears.add(bears.getPlayerByPos("P"));
        
        
       
        System.out.println("Skeleton Test v3 - Added Player objects for the Bears offense");
        System.out.println(fortyNiners.getTeamName() + " vs. " + bears.getTeamName() + "\n");
        System.out.println("Quarterbacks:\n\t" + fortyNiners.getTeamName() + ":\t" + fortyNiners.getPlayerByPos("QB") + "\n\t" + bears.getTeamName() + ":\t" + bears.getPlayerByPos("QB") + "\n");
        //Start at the 20 yard line
        LOS = 20;
        //first down marker will be ten yards ahead of LOS to start
        firstDownMarker = LOS+10;
        //Set down to first
        down = 1;
        //Go to choose play method, sending the down as a parameter
        choosePlay(down);
    }

    /**
     * 50% chance at run, 50% chance at pass on downs 1-3
     * If its 4th down, then do another thing:
     *      -If inside 35 yard line (65), then take a field goal (didn't feel like adding making/missing field goals)
     *      -If anywhere else, punt and close the program.
     */
    public static void choosePlay(int downNum)
    {
        //Message indicating where the ball is and where the first down marker is before every play
        System.out.println("Ball on " + LOS + ", 1st Down Marker at " + firstDownMarker); 
        //If its 1st down - 3rd down
        if (downNum != 4) {
            //Display football notation for down and yardage until first down
            System.out.println(downNum + " & " + (firstDownMarker-LOS));
            //Message telling what is going on during this method.
            System.out.println(bears.getTeamName() + " in the huddle choosing a play");
            //Make a random integer number between 0-1
            int random = (int)(Math.random()*2);
            //Choose outcomes for one of the two numbers
            if (random == 0) {
                //if its 0, do a pass play - 50% time
                doPassPlay();
            } else {
                //if its 1, do a run play - 50% time
                doRunPlay();
            }
        } else {    //If its 4th down
            //Still display football notation for down and yardage until first down
            System.out.println(downNum + " & " + (firstDownMarker-LOS));
            //if inside opponents 35 (roughly max kick distance)
            if (LOS >= 65) {
                //Take and make the field goal
                System.out.println(daBears.get(6) + " is taking the field goal.\nField Goal Good!");
            } else {    //anywhere else on the field
                //Punt the ball
                System.out.println(daBears.get(7) + " is punting the ball to the other team");
            }
            //Either way, end of drive so end the program
            System.exit(0);
        }
    }
    
    /**
     * Pass play
     */
    public static void doPassPlay() {
        //Tell user which outcome was chosen
        System.out.println("Running a pass play");
        System.out.println(daBears.get(0) + " is waiting in the pocket");
        //The below code just waits to make it seem like the QB is in the pocket about to throw
        try {
            //Wait 3 seconds
            Thread.sleep(3000);
        }
        catch (InterruptedException ie) {
            // Handle the exception
        }
        //Make a random double between 0 and 99.99999999
        double lineBreakthrough = (Math.random()*100);
        //If that double is less than 6.25, which is apparently how often sacks happen per total pass plays
        if (lineBreakthrough <= 6.25) {
            //Notify what happened
            System.out.println("The " + fortyNiners.getTeamName() + " defense broke through the offensive line!");
            //Go to sack method
            sack();
        } else { //If the offensive line holds then...
            //Go to choose reciever method, get a reciever # back.
            NFLPlayer reciever = chooseReciever();
            //1 is WR1, 2 is WR2, 3 is TE, 4 is FLEX, 5 is RB
            System.out.println("Throwing to " + reciever);
            //Go through with the throw ball method to a specified reciever.
            throwBall(reciever);
        }
    }
    
    /**
     * When the QB gets sacked on a pass play
     */
    private static void sack() {
        //Notify
        System.out.println("The QB was sacked on the play!");
        //Randomly lose between 0-10 yards
        int yardLoss = (int)(Math.random()*11);
        //reset the line of scrimmage for the next play
        LOS-=yardLoss;
        //Say how many yards were lost on the sack
        System.out.println(yardLoss + " yard sack by the defense!");
        //Go to the end of play method
        endOfPlay();
    }
    
    /**
     * Dumb method that literally just gets a random number as of now. Eventually this could choose a reciever and return that reciever
     */
    private static NFLPlayer chooseReciever() {
        return daBears.get((int)(Math.random()*((5-1)+1)+1));
    }
    
    /**
     * Go through with the throwing of the ball from the QB to a reciever
     */
    private static void throwBall(NFLPlayer reciever) {
        //Make a double between 0 and 99.999999
        double passCompletionPct = Math.random()*100;
        //65% likely to make a pass
        if (passCompletionPct <= 65) {
            System.out.println("Completed Pass to " + reciever);
            //Go through with a completed pass
            completePass();
        } else if (passCompletionPct > 95) {    //Go through with an intercepted pass (5% time)
            System.out.println("Intercepted by the " + fortyNiners.getTeamName() + "!");
            interception();
        } else {    //Go through with an incomplete pass, ending the play
            System.out.println("Incomplete Pass");
            endOfPlay(); 
        }
    }
    
    /**
     * Figure out yardage gain for a completed pass. The numbers gathered are an average of 5 QB's (AJ McCarron, Derrick Carr, Terry Bridgewater, Marcus Mariota, and Johnny Manziel) pass range %
     */
    private static void completePass() {
        //temp vars for gainage and potential max and min withing the range that is selected
        int yardGainage;
        int max, min;
        //Double between 0 and 99.999999999
        double distanceBracket = (Math.random()*100);
        if (distanceBracket < 17.04) {
            min = 0;
            max = 0;
        } else if (distanceBracket >= 17.04 && distanceBracket < 41.24) {
            min = 1;
            if (offEndzone - LOS < 4) {
                max = offEndzone - LOS;
            } else {
                max = 4;
            }
        } else if (distanceBracket >= 41.24 && distanceBracket < 62.8) {
            if (offEndzone - LOS < 5) { // if endzone is less than the range
                min = 1;
                max = offEndzone - LOS;
            } else if (offEndzone - LOS < 9 && offEndzone - LOS >= 5) { //if endzone is within the range
                min = 5;
                max = offEndzone - LOS;
            } else { //otherwise
                min = 5;
                max = 9;
            }
        } else if (distanceBracket >= 62.8 && distanceBracket < 76) {
            if (offEndzone - LOS < 10) { // if endzone is less than the range
                min = 1;
                max = offEndzone - LOS;
            } else if (offEndzone - LOS < 14 && offEndzone - LOS >= 10) { //if endzone is within the range
                min = 10;
                max = offEndzone - LOS;
            } else { //otherwise
                min = 10;
                max = 14;
            }
        } else if (distanceBracket >= 76 && distanceBracket < 85.64) {
            if (offEndzone - LOS < 15) { // if endzone is less than the range
                min = 1;
                max = offEndzone - LOS;
            } else if (offEndzone - LOS < 19 && offEndzone - LOS >= 15) { //if endzone is within the range
                min = 15;
                max = offEndzone - LOS;
            } else { //otherwise
                min = 15;
                max = 19;
            }
        } else if (distanceBracket >= 85.64 && distanceBracket < 91.12) {
            if (offEndzone - LOS < 20) { // if endzone is less than the range
                min = 1;
                max = offEndzone - LOS;
            } else if (offEndzone - LOS < 24 && offEndzone - LOS >= 20) { //if endzone is within the range
                min = 20;
                max = offEndzone - LOS;
            } else { //otherwise
                min = 20;
                max = 24;
            }
        } else if (distanceBracket >= 91.12 && distanceBracket < 93.98) {
            if (offEndzone - LOS < 25) { // if endzone is less than the range
                min = 1;
                max = offEndzone - LOS;
            } else if (offEndzone - LOS < 29 && offEndzone - LOS >= 25) { //if endzone is within the range
                min = 25;
                max = offEndzone - LOS;
            } else { //otherwise
                min = 25;
                max = 29;
            }
        } else if (distanceBracket >= 93.98 && distanceBracket < 96.54) {
            if (offEndzone - LOS < 30) { // if endzone is less than the range
                min = 1;
                max = offEndzone - LOS;
            } else if (offEndzone - LOS < 34 && offEndzone - LOS >= 30) { //if endzone is within the range
                min = 30;
                max = offEndzone - LOS;
            } else { //otherwise
                min = 30;
                max = 34;
            }
        } else if (distanceBracket >= 96.54 && distanceBracket < 98.42) {
            if (offEndzone - LOS < 35) { // if endzone is less than the range
                min = 1;
                max = offEndzone - LOS;
            } else if (offEndzone - LOS < 39 && offEndzone - LOS >= 35) { //if endzone is within the range
                min = 35;
                max = offEndzone - LOS;
            } else { //otherwise
                min = 35;
                max = 39;
            }
        } else {
            if (offEndzone - LOS < 40) { // if endzone is less than the range
                min = 1;
                max = offEndzone - LOS;
            } else {    //if endzone is within the range
                min = 40;
                max = offEndzone - LOS;
            }
        }
        
        //Choose a number within the selected range to get the yardage gain
        yardGainage = (int)(Math.random()*((max - min) + 1)) + min;
        //Move the line of scrimmage to match the gain
        LOS += yardGainage;
        //Notify the user of what the heck just happened
        System.out.println(yardGainage + " yard gain on the play.");
        //Move on to the end of play method
        endOfPlay();
    }
    private static void interception() {
        //Change instance var of who has ball to false so the end of play method doesn't keep going for offensive plays
        offHasBall = false;
        //Go on to end of play method
        endOfPlay();
    }
    
    /**
     * Run Play
     */
    public static void doRunPlay() {
        //Notify user of the choice selected previously
        System.out.println("Doing a run play");
        System.out.println(daBears.get(0) + " hands the ball off to " + daBears.get(1));
        //The below code just waits to make it seem like the RB is getting the ball and waiting for a hole to open up
        try {
            //Wait 3 seconds
            Thread.sleep(1500);
        }
        catch (InterruptedException ie) {
            // Handle the exception
        }
        //Move on to the findHole method
        findHole();
    }
    /**
     * Name irrelevant, just seeing if the running back can get past the defense or not. If yes, then give a 50% for small run or big run. If no, then lose a few yards
     */
    private static void findHole() {
        //Make a random integer because we are using nice even numbers this time
        int success = (int)(Math.random()*10);
        int yardGainage;
        //I'd say 10% the RB gets stuck behind the line and can't find a hole -- SUBJECT TO CHANGE if running plays become too OP
        if (success <= 1) {
            //Lose 0-4 yards
            yardGainage = (int)(Math.random()*5);
            //Notify user what happened and how many yards were lost
            System.out.println("Bad Run! Rush for a " + yardGainage + " yard loss.");
            //move the line of scrimmage back that many yards
            LOS -= yardGainage;
        } else {    //If the RB finds a hole
            if (success <= 4) { //50% chance at a small gain
                //Yardage between 1-10
                if (offEndzone - LOS < 10) {    //If within the 10
                    yardGainage = (int)(Math.random()*(offEndzone-LOS))+1; //Random between 1-length from endzone if within 10 yards
                } else {    //Otherwise
                    yardGainage = (int)(Math.random()*10)+1;
                }
            } else {    //50% chance at a large gain
                //Yardage between 11-30
                if (offEndzone - LOS < 30 && offEndzone - LOS > 11) {   //If within 30 yards but not inside the 10
                    yardGainage = (int)(Math.random()*(offEndzone-LOS))+11;  //Random between 11-distance to goal
                } else if (offEndzone - LOS < 11) { //if within the 10
                    yardGainage = (offEndzone - LOS);   //Distance to goal because its a TD if a big run happens here
                } else { //otherwise
                    yardGainage = (int)(Math.random()*(30-11))+10;    //11-30 yard gain
                }
            }
            //Notify user what happened and how many yards were gained
            System.out.println("Good Run! Rush for a " + yardGainage + " yard gain");
            //move the line of scrimmage up that many yards
            LOS += yardGainage;
        }
        //move on to the end of the play
        endOfPlay();
    }
    
    
    
    
    /**
     * Deals with stuff after the play is dead and loops if necessary
     */
    public static void endOfPlay() {
        System.out.println("End of the play");
        //If the offense still has the ball (didn't intercept or fumble **TO BE ADDED**
        if (offHasBall) {
            //If they gained enough for the first down
            if (LOS >= firstDownMarker) {
                //But if they are within goal range 
                if (LOS >=90 && LOS < 100) {
                    //Use __ & goal notation
                    System.out.println("1 and goal\n");
                    //set first down marker at endzone becasue why not
                    firstDownMarker = offEndzone;
                } else if (LOS >= 100) {    //If you get into the endzone or beyond
                    //Well thats a TD, end the drive
                    System.out.println("TOUCHDOWN\n");
                    System.exit(0);
                } else {    //First down anywhere else on the field
                    //Push first down marker ten yards ahead of where the play ended
                    firstDownMarker = LOS + 10;
                    //Notify where ^^^ is
                    System.out.println("1st Down! New 1st Down marker on the " + firstDownMarker + "\n");
                }
                //Reset the down if they got a 1st
                down = 1;
            } else {    //Not a first down
                if (LOS >= 100) {
                    //Well thats a TD, end the drive
                    System.out.println("TOUCHDOWN\n");
                    System.exit(0);
                } else {    //Otherwise anywhere else on field
                    System.out.println("Not enough for the first down\n");
                    down++;
                    //Move the down counter up one.
                }
            }
            //If the drive is still going, choose another play with the specified down
            choosePlay(down);
        } else {    //If the defense got the ball
            //Notify again
            System.out.println("Turnover on the play\n");
            //End of drive
            System.exit(0);
        }
    }
}

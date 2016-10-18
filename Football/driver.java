
/**
 * Write a description of class driver here.
 * 
 * @jdementri
 */
public class driver
{
    
    public static void main (String[] args) {
        //"" way of Hard Coding Players and Teams
        //TO BE IMPLEMENTED IN CONTROLLER FOR SKELETON
        NFLTeam eagles = new NFLTeam("Eagles");
        NFLTeam cowboys = new NFLTeam("Cowboys");
        
        NFLPlayer carsonWentz = new NFLPlayer(new String [] {"Eagles", "Carson", "Wentz", "QB", " ", "84", "82", "86", "72"});            eagles.addPlayerToOffense(carsonWentz);
        NFLPlayer ryanMathews = new NFLPlayer(new String [] {"Eagles", "Ryan", "Mathews", "HB", " ", "82", "89", "91", "73"});            eagles.addPlayerToOffense(ryanMathews);
        NFLPlayer jordanMatthews = new NFLPlayer(new String [] {"Eagles", "Jordan", "Matthews", "WR", " ", "78", "90", "91", "68"});      eagles.addPlayerToOffense(jordanMatthews);
        NFLPlayer nelsonAgholor = new NFLPlayer(new String [] {"Eagles", "Nelson", "Agholor", "WR", " ", "72", "91", "91", "64"});        eagles.addPlayerToOffense(nelsonAgholor);
        NFLPlayer joshHuff = new NFLPlayer(new String [] {"Eagles", "Josh", "Huff", "WR", " ", "70", "90", "92", "60"});                  eagles.addPlayerToOffense(joshHuff);
        NFLPlayer zachErtz = new NFLPlayer(new String [] {"Eagles", "Zach", "Ertz", "TE", " ", "87", "80", "87", "73"});                  eagles.addPlayerToOffense(zachErtz);
        NFLPlayer jasonKelce = new NFLPlayer(new String [] {"Eagles", "Jason", "Kelce", "C", " ", "85", "73", "81", "86"});               eagles.addPlayerToOffense(jasonKelce);
        NFLPlayer jasonPeters = new NFLPlayer(new String [] {"Eagles", "Jason", "Peters", "LT", " ", "87", "67", "73", "96"});            eagles.addPlayerToOffense(jasonPeters);
        NFLPlayer barrettJones = new NFLPlayer(new String [] {"Eagles", "Barrett", "Jones", "LG", " ", "72", "56", "65", "82"});          eagles.addPlayerToOffense(barrettJones);
        NFLPlayer laneJohnson = new NFLPlayer(new String [] {"Eagles", "Lane", "Johnson", "RT", " ", "86", "80", "87", "86"});            eagles.addPlayerToOffense(laneJohnson);
        NFLPlayer brandonBrooks = new NFLPlayer(new String [] {"Eagles", "Brandon", "Brooks", "RG", " ", "80", "70", "81", "95"});        eagles.addPlayerToOffense(brandonBrooks);
        
        
        NFLPlayer connorBarwin = new NFLPlayer(new String [] {"Eagles", "Connor", "Barwin", "LE", " ", "84", "81", "88", "80"});          eagles.addPlayerToDefense(connorBarwin);
        NFLPlayer bennieLogan = new NFLPlayer(new String [] {"Eagles", "Bennie", "Logan", "DT", " ", "78", "68", "79", "88"});            eagles.addPlayerToDefense(bennieLogan);
        NFLPlayer fletcherCox = new NFLPlayer(new String [] {"Eagles", "Fletcher", "Cox", "DT", " ", "93", "79", "86", "86"});            eagles.addPlayerToDefense(fletcherCox);
        NFLPlayer brandonGraham = new NFLPlayer(new String [] {"Eagles", "Brandon", "Graham", "RE", " ", "92", "80", "87", "78"});        eagles.addPlayerToDefense(brandonGraham);
        NFLPlayer jordanHicks = new NFLPlayer(new String [] {"Eagles", "Jordan", "Hicks", "MLB", " ", "74", "83", "90", "76"});           eagles.addPlayerToDefense(jordanHicks);
        NFLPlayer mychalKendricks = new NFLPlayer(new String [] {"Eagles", "Mychal", "Kendricks", "LOLB", " ", "85", "88", "88", "74"});  eagles.addPlayerToDefense(mychalKendricks);
        NFLPlayer nigelBradham = new NFLPlayer(new String [] {"Eagles", "Nigel", "Bradham", "ROLB", " ", "76", "85", "86", "72"});        eagles.addPlayerToDefense(nigelBradham);
        NFLPlayer nolanCarroll = new NFLPlayer(new String [] {"Eagles", "Nolan", "Carroll III", "CB", " ", "76", "89", "89", "52"});      eagles.addPlayerToDefense(nolanCarroll);
        NFLPlayer leodisMcKelvin = new NFLPlayer(new String [] {"Eagles", "Leodis", "McKelvin", "CB", " ", "73", "88", "91", "52"});      eagles.addPlayerToDefense(leodisMcKelvin);
        NFLPlayer rodneyMcLeod = new NFLPlayer(new String [] {"Eagles", "Rodney", "McLeod Jr.", "SS", " ", "81", "86", "91", "56"});      eagles.addPlayerToDefense(rodneyMcLeod);
        NFLPlayer malcolmJenkins = new NFLPlayer(new String [] {"Eagles", "Malcolm", "Jenkins", "FS", " ", "93", "86", "92", "64"});      eagles.addPlayerToDefense(malcolmJenkins);

        
        //Displaying all of the players with the relevant attributes for the skeleton
        System.out.println(eagles.getTeamName() + "\n\nOffense:\n");
        for (NFLPlayer p : eagles.getOffense()) {
            System.out.println(p + " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }
        System.out.println("\nDefense:\n");
        for (NFLPlayer p : eagles.getDefense()) {
            System.out.println(p + " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }
        
        
        NFLPlayer dakPrescott = new NFLPlayer(new String [] {"Cowboys", "Dak", "Prescott", "QB", " ", "71", "82", "86", "74"});            cowboys.addPlayerToOffense(dakPrescott);
        NFLPlayer ezekielElliot = new NFLPlayer(new String [] {"Cowboys", "Ezekiel", "Elliot", "HB", " ", "80", "92", "90", "75"});        cowboys.addPlayerToOffense(ezekielElliot);
        NFLPlayer dezBryant = new NFLPlayer(new String [] {"Cowboys", "Dez", "Bryant", "WR", " ", "90", "90", "91", "74"});                cowboys.addPlayerToOffense(dezBryant);
        NFLPlayer terranceWilliams = new NFLPlayer(new String [] {"Cowboys", "Terrance", "Williams", "WR", " ", "80", "92", "92", "57"});  cowboys.addPlayerToOffense(terranceWilliams);
        NFLPlayer coleBeasley = new NFLPlayer(new String [] {"Cowboys", "Cole", "Beasley", "WR", " ", "77", "87", "88", "61"});            cowboys.addPlayerToOffense(coleBeasley);
        NFLPlayer jasonWitten = new NFLPlayer(new String [] {"Cowboys", "Jason", "Witten", "TE", " ", "87", "77", "81", "75"});            cowboys.addPlayerToOffense(jasonWitten);
        NFLPlayer travisFrederick = new NFLPlayer(new String [] {"Cowboys", "Travis", "Frederick", "C", " ", "91", "52", "75", "90"});     cowboys.addPlayerToOffense(travisFrederick);
        NFLPlayer tyronSmith = new NFLPlayer(new String [] {"Cowboys", "Tyron", "Smith", "LT", " ", "97", "72", "82", "88"});              cowboys.addPlayerToOffense(tyronSmith);
        NFLPlayer laelCollins = new NFLPlayer(new String [] {"Cowboys", "La'el", "Collins", "LG", " ", "78", "72", "75", "88"});           cowboys.addPlayerToOffense(laelCollins);
        NFLPlayer dougFree = new NFLPlayer(new String [] {"Cowboys", "Doug", "Free", "RT", " ", "80", "60", "76", "81"});                  cowboys.addPlayerToOffense(dougFree);
        NFLPlayer zachMartin = new NFLPlayer(new String [] {"Cowboys", "Zach", "Martin", "RG", " ", "92", "69", "81", "89"});              cowboys.addPlayerToOffense(zachMartin);
        
        
        NFLPlayer demarcusLawrence = new NFLPlayer(new String [] {"Cowboys", "Demarcus", "Lawrence", "LE", " ", "81", "78", "87", "76"});  cowboys.addPlayerToDefense(demarcusLawrence);
        NFLPlayer tyroneCrawford = new NFLPlayer(new String [] {"Cowboys", "Tyrone", "Crawford", "DT", " ", "80", "78", "83", "81"});      cowboys.addPlayerToDefense(tyroneCrawford);
        NFLPlayer cedricThornton = new NFLPlayer(new String [] {"Cowboys", "Cedric", "Thornton", "DT", " ", "78", "61", "75", "88"});      cowboys.addPlayerToDefense(cedricThornton);
        NFLPlayer randyGregory = new NFLPlayer(new String [] {"Cowboys", "Randy", "Gregory", "RE", " ", "75", "84", "88", "78"});          cowboys.addPlayerToDefense(randyGregory);
        NFLPlayer rolandoMcClain = new NFLPlayer(new String [] {"Cowboys", "Rolando", "McClain", "MLB", " ", "81", "80", "85", "77"});     cowboys.addPlayerToDefense(rolandoMcClain);
        NFLPlayer justinDurant = new NFLPlayer(new String [] {"Cowboys", "Justin", "Durant", "LOLB", " ", "77", "83", "87", "64"});        cowboys.addPlayerToDefense(justinDurant);
        NFLPlayer seanLee = new NFLPlayer(new String [] {"Cowboys", "Sean", "Lee", "ROLB", " ", "89", "82", "89", "75"});                  cowboys.addPlayerToDefense(seanLee);
        NFLPlayer orlandoScandrick = new NFLPlayer(new String [] {"Cowboys", "Orlando", "Scandrick", "CB", " ", "87", "90", "91", "52"});  cowboys.addPlayerToDefense(orlandoScandrick);
        NFLPlayer brandonCarr = new NFLPlayer(new String [] {"Cowboys", "Brandon", "Carr", "CB", " ", "76", "86", "91", "51"});            cowboys.addPlayerToDefense(brandonCarr);
        NFLPlayer barryCrunch = new NFLPlayer(new String [] {"Cowboys", "Barry", "Crunch", "SS", " ", "82", "86", "88", "65"});            cowboys.addPlayerToDefense(barryCrunch);
        NFLPlayer byronJones = new NFLPlayer(new String [] {"Cowboys", "Byron", "Jones", "FS", " ", "81", "91", "93", "70"});              cowboys.addPlayerToDefense(byronJones);
        
        //Displaying all of the players with the relevant attributes for the skeleton
        System.out.println("\n");
        System.out.println(cowboys.getTeamName() + "\n\nOffense:\n");
        for (NFLPlayer p : cowboys.getOffense()) {
            System.out.println(p + " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }
        System.out.println("\nDefense:\n");
        for (NFLPlayer p : cowboys.getDefense()) {
            System.out.println(p + " - " + p.getPosition() + "\n\tOverall: " + p.getOverall() + "\n\tSpeed: " + p.getSpeed() + "\n\tStrength: " + p.getStrength());
        }
    }
    
}

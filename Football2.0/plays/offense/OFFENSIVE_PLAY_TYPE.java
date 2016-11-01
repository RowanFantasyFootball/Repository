package plays.offense;

import game.Controller;
import game.Randomizer;
import plays.defense.DefensivePlay;

/**
 * An enum containing all of the offensive play types
 * 
 * If you are unfamiliar with enums, look up how to use them they are very
 * useful. With enums you have the ability to create your own variable with its
 * own values
 */
public enum OFFENSIVE_PLAY_TYPE {
	/**
	 * Currently we have 3 offensive play types, anyone can add more to create
	 * more to add more diversity and randomization in the game. To implement a
	 * new play, think of a name, put a comma next to the last enum and type in
	 * the name you want. Thats it!
	 */
	RUN, PASS, QBSNEAK;

	/**
	 * The variable which stores the potential of successfully completing a play
	 * (gaining yards). The higher the yardageGainPotential, the more powerful
	 * the play will be against the defense, thus meaning more potential the
	 * defense will stop the offense
	 */
	private final int yardageGainPotential;

	/**
	 * Constructor for creating a new offensive play type enum
	 * 
	 * however!!!, This can be subject to change. The potential values are set
	 * randomly, WE NEED IDEAS if we want to change this!!! So, implement your
	 * own ideas and upload them to the github so everyone can see. If you feel
	 * confident with what you've came up with, definitely bring it up to the
	 * teams, we had really some good ideas in class that I would like to get
	 * implemented.
	 * 
	 * Don't feel bad if you think you have a better idea, because you
	 * definitely can have a better idea. Implement them (but don't delete old
	 * code, comment it out so we see what has changed). If it is good, we will
	 * keep it! Don't worry about neatness or repetetive code. I will fix that
	 * up for everyone if it becomes a problem, which I don't think it will. The
	 * code looked good overall before I added some new ideas
	 * 
	 * - Joe D
	 */
	OFFENSIVE_PLAY_TYPE() {
		yardageGainPotential = Randomizer.getRandomNumber(DefensivePlay.MAX_STOPPING_POTENTIAL);
	}

	/**
	 * Gets the potential of the offense successfully completing a play and gain
	 * yards
	 * 
	 * @return the potential of the offense successfully completing a play and
	 *         gain yards
	 */
	public int getOffensiveYardageGainPotential() {
		return yardageGainPotential;
	}

	/**
	 * Gets a random offensive play type
	 * 
	 * @return a random play type for the offense to use
	 */
	public static OFFENSIVE_PLAY_TYPE getRandomPlayType() {
		return values()[Randomizer.getRandomNumber(values().length - 1)];
	}
}

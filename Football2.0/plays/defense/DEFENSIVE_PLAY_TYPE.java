package plays.defense;

import game.Randomizer;

/**
 * An enum for the storage of defensive play types
 * 
 * If you are unfamiliar with enums, look up how to use them they are very
 * useful. With enums you have the ability to create your own variable with its
 * own values
 */
public enum DEFENSIVE_PLAY_TYPE {
	/**
	 * Currently we have 4 defensive play types, anyone can add more to create
	 * more to add more diversity and randomization in the game. To implement a
	 * new play, think of a name, put a comma next to the last enum and type in
	 * the name you want. Thats it!
	 */
	COVER4, BLITZ, ZONE, MAN;

	/**
	 * The variable which stores the potential of successfully stopping a play
	 * attempting to be executed by the offense. The higher the
	 * stoppingPotential, the more powerful the play will be against the
	 * defense, thus meaning more potential the defense will stop the offenseThe
	 * variable which stores the skill level of the play The higher the skill
	 * level, the more powerful the play will be, thus meaning more potential
	 * the defense will stop the offense
	 */
	private final int playStoppingPotential;

	/**
	 * Constructor for creating a new defensive play type enum
	 * 
	 * Currently: sets randomized values relative to a maximum for the potential
	 * that the defense's play will stop the offenses play....
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
	 * 
	 * @param stoppingPotential
	 *            - the potential that a play will stop the offense
	 */
	DEFENSIVE_PLAY_TYPE() {
		playStoppingPotential = Randomizer.getRandomNumber(DefensivePlay.MAX_STOPPING_POTENTIAL);
	}

	/**
	 * Gets the potential that the defense will stop a play
	 * 
	 * @return the potential that the defense will stop a play
	 */
	public int getPlayStoppingPotential() {
		return playStoppingPotential;
	}

	/**
	 * Gets a random defensive play type
	 * 
	 * @return a random play type for the defense to use
	 */
	public static DEFENSIVE_PLAY_TYPE getRandomDefensivePlayType() {
		return values()[Randomizer.getRandomNumber(values().length - 1)];
	}
}

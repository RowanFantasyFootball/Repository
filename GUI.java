import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.awt.image.*;
import java.io.File;

public class GUI {

	private JFrame main;
	private Scoreboard scoreboard;
	private Field field;
	private Feed feed;
	private Actions actions;
	private JMenuBar menubar;

	/**
	 * Set up GUI
	 */
	public GUI() {
		// Make sure the look and feel is set to windows
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
		// Initialize everything
		initComponents();
	}

	/**
	 * Initialize Every Component in the GUI
	 */
	private void initComponents() {
		// Construct the JFrame
		main = new JFrame("Football Simulation");

		// Create a Container and set the layout to BoxLayout (Top->Bottom)
		Container pane = main.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

		// Go Create a Menu Bar
		createMenuBar(main);

		// Create a Scoreboard Panel
		scoreboard = new Scoreboard();

		pane.add(scoreboard);

		// Create a Field panel
		field = new Field();
		// field.add(new JButton("This is where the field will go"));
		pane.add(field);

		// Create a Feed panel
		feed = new Feed();

		// feed.add(new JButton("This is where the message feed will go"));
		pane.add(feed);

		// Create an Actions panel
		actions = new Actions(this);
		pane.add(actions);

		// Set the size of the JFrame
		// Don't allow resizing because it messes everything up
		main.setResizable(false);
		main.pack();
		// Show it
		main.setVisible(true);
	}

	private void createMenuBar(JFrame main) {
		// For shortcut keys
		final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

		// Create a menubar and add it to Frame
		menubar = new JMenuBar();
		main.setJMenuBar(menubar);

		JMenu menu;
		JMenuItem item;

		// Create file menu
		menu = new JMenu("File");
		menubar.add(menu);

		item = new JMenuItem("Action 1");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, SHORTCUT_MASK));
		// item.addActionListener(e -> action1());
		menu.add(item);

		menu.addSeparator();

		item = new JMenuItem("Action 2");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, SHORTCUT_MASK));
		// item.addActionListener(e -> action2());
		menu.add(item);

		menu.addSeparator();
		menu.addSeparator();

		item = new JMenuItem("Quit");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
		// item.addActionListener(e-> quit());
		menu.add(item);

		menu = new JMenu("Help");
		menubar.add(menu);

		item = new JMenuItem("About");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, SHORTCUT_MASK));
		// item.addActionListener(e -> about());
		menu.add(item);
	}

	/**
	 * Sends message to GUI to be displayed Sent as full string, will appear in
	 * Feed box.
	 * 
	 * @param message
	 *            - message to be sent in
	 */
	public void newMessage(String message) {
		feed.setMessage(message);
	}

	/**
	 * Sets the score for the home team
	 * 
	 * @param score
	 *            - total score of home team
	 */
	public void setHomeScore(int score) {
		scoreboard.setHomeScore(score);
	}

	/**
	 * Sets the score for the away team
	 * 
	 * @param score
	 *            - total score of away team
	 */
	public void setAwayScore(int score) {
		scoreboard.setAwayScore(score);
	}

	/**
	 * Sets the name of the home team (by city)
	 * 
	 * @param name
	 *            - city of home team
	 */
	public void setHomeTeamName(String name) {
		scoreboard.setHomeTeamName(name);
	}

	/**
	 * Sets the name of the away team (by city)
	 * 
	 * @param name
	 *            - city of away team
	 */
	public void setAwayTeamName(String name) {
		scoreboard.setAwayTeamName(name);
	}

	/**
	 * Sets the down number (1-4)
	 * 
	 * @param downNum
	 *            - number of the current down
	 */
	public void setDown(int downNum) {
		scoreboard.setDown(downNum);
	}

	/**
	 * Sets the distance to the first down marker
	 * 
	 * @param yardage
	 *            - distance to first down
	 */
	public void setYardageToFirst(int yardage) {
		scoreboard.setYardageToFirst(yardage);
	}

	/**
	 * Sets the position of the ball on the field
	 * 
	 * @param yardMarker
	 *            - position of line of scrimmage
	 */
	public void setYardMarker(int yardMarker) {
		scoreboard.setFieldYardage(yardMarker);
	}

	/**
	 * sets the possession for the scoreboard only
	 * 
	 * @param team
	 *            - TYPE "home" or "away" to flip it respectively
	 */
	public void setPossession(String team) {
		scoreboard.setPossession(team);
	}

	/**
	 * Sets the quarter of the game
	 * 
	 * @param quarter
	 *            - Quarter (1-4) of the current game
	 */
	public void setQuarter(int quarter) {
		scoreboard.setQuarter(quarter);
	}

	/**
	 * Moves the team to a certain yard marker and sets the distance to the
	 * first down line
	 * 
	 * @param yardage
	 *            - position on field on Line of Scrimmage
	 * @param yardToFirst
	 *            - distance in yards to first down line
	 */
	public void move(int yardage, int yardToFirst) {
		field.move(yardage, yardToFirst);
	}

	/**
	 * Flips the possession on the scoreboard (like flipping a light switch)
	 */
	public void changePossession() {
		scoreboard.switchPossession();
	}

	/**
	 * Test method that glides the team back and forth, flipping when it gets to
	 * the endzone
	 */
	public void glide() {
		field.glide(0);
	}

	/**
	 * Animates a movement from one location to the other
	 * 
	 * @param start
	 *            - start yard line
	 * @param end
	 *            - end yard line
	 * @param goingRight
	 *            - true for home team, false for away team.
	 */
	public void animate(int start, int end, int distanceToFDL, boolean goingRight) {
		field.animate(start, end, distanceToFDL, goingRight);
	}

}
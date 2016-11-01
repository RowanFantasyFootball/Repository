package game;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;

import actor.player.Player;

public class GUI extends JFrame {
	
	private ArrayList<Player> players;
	
	private ArrayList<JLabel> tiles;
	
	private boolean run;

	private int GAME_WIDTH  = 500;
	private int GAME_HEIGHT = 500;
	
	public GUI() {
		setVisible(true);
		setSize(GAME_WIDTH, GAME_HEIGHT);
		GridLayout grid = new GridLayout();
		grid.setColumns(GAME_HEIGHT);
		grid.setRows(GAME_WIDTH);
		setLayout(grid);
		System.out.println("Setup layout");
		fillGrid();
		System.out.println("Filled grid");
		//pack();
		System.out.println("Packed");
		System.out.println("Set visible");
	}
	
	private void fillGrid() {
		for (int x = 0; x < GAME_WIDTH; x++) {
			for (int y = 0; y < GAME_HEIGHT; y++) {
				JLabel tile = new JLabel();
				tile.setLocation(x, y);
				tile.setVisible(true);
				add(tile);
			}
		}
	}

	public void startttttttt() {
		new Thread() {
			@Override
			public void run() {
				run = true;
				while (run) {
					render();
				}
			}
		}.start();
	}

	/**
	 * Renders the game
	 */
	public void render() {
		remove();
		update();
	}
	
	/**
	 * Clears the grid of any previous players
	 */
	private void remove() {
		for (Player player : players) {
			Iterator<JLabel> it = tiles.iterator();
			while (it.hasNext()) {
				if ((player.getPosition() + " " + player.getLastName()).equals(it.next().getText())) {
					it.remove();
					break;
				}
			}
		}
	}

	/**
	 * Updates the players to their new location
	 */
	private void update() {
		for (JLabel tile : tiles) {
			for (Player player : players) {
				if (tile.getX() == player.getX()
				&&  tile.getY() == player.getY()) {
					tile.setText(player.getPosition() + " " + player.getLastName());
				}
			}
		}
	}

	/**
	 * Updates the grid with the current location of the player
	 * 
	 * @param player - the player to add
	 */
	public void updateGrid(Player player) {
		Iterator<Player> it = players.iterator();
		while (it.hasNext()) {
			if (it.next().getFullName().equals(player.getFullName())) {
				it.remove();
				break;
			}
		}
		players.add(player);
	}

}

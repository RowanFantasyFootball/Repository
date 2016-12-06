import javax.swing.*;
import java.awt.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

import java.io.File;
public class GUI {

    private JFrame main;
    private Scoreboard scoreboard; private Field field; private Feed feed; private Actions actions;
    private JMenuBar menubar;
    
    /**
     * Set up GUI
     */
    public GUI() {
        //Make sure the look and feel is set to windows
        try 
        { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        } 
            catch(Exception e){ 
        }
        //Initialize everything
        initComponents();
    }
    
    /**
     * Initialize Every Component in the GUI
     */
    private void initComponents() {
        //Construct the JFrame
        main = new JFrame("Football Simulation");
        
        //Create a Container and set the layout to BoxLayout (Top->Bottom)
        Container pane = main.getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        
        //Go Create a Menu Bar
        createMenuBar(main);
        
        //Create a Scoreboard Panel
        scoreboard = new Scoreboard();
        
        pane.add(scoreboard);
        
        //Create a Field panel
        field = new Field();
        //field.add(new JButton("This is where the field will go"));
        pane.add(field);
        
        //Create a Feed panel
        feed = new Feed();
        
        //feed.add(new JButton("This is where the message feed will go"));
        pane.add(feed);
        
        //Create an Actions panel
        actions = new Actions(this);
        pane.add(actions);
        
       
        //Set the size of the JFrame
        //Don't allow resizing because it messes everything up
        main.setResizable(false);
        main.pack();
        //Show it
        main.setVisible(true);
    }
    
    private void createMenuBar(JFrame main) {
        //For shortcut keys
        final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        
        //Create a menubar and add it to Frame
        menubar = new JMenuBar();
        main.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;
        
        //Create file menu
        menu = new JMenu("File");
        menubar.add(menu);
        
        item = new JMenuItem("Action 1");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, SHORTCUT_MASK));
        //item.addActionListener(e -> action1());
        menu.add(item);
        
        menu.addSeparator();
        
        item = new JMenuItem("Action 2");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, SHORTCUT_MASK));
        //item.addActionListener(e -> action2());
        menu.add(item);
        
        menu.addSeparator();
        menu.addSeparator();
        
        item = new JMenuItem("Quit");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
        //item.addActionListener(e-> quit());
        menu.add(item);
        
        menu = new JMenu("Help");
        menubar.add(menu);
        
        item = new JMenuItem("About");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, SHORTCUT_MASK));
        //item.addActionListener(e -> about());
        menu.add(item);
    }
    
    public void newMessage(String message) {
        feed.setMessage(message);
    }
    
    public void setHomeScore(int score) {
        scoreboard.setHomeScore(score);
    }
    
    public void setAwayScore(int score) {
        scoreboard.setAwayScore(score);
    }
    
    public void setHomeTeamName(String name) {
        scoreboard.setHomeTeamName(name);
    }
    
    public void setAwayTeamName(String name) {
        scoreboard.setAwayTeamName(name);
    }
    
    public void setDown(int downNum) {
        scoreboard.setDown(downNum);
    }
    
    public void setYardageToFirst(int yardage) {
        scoreboard.setYardageToFirst(yardage);
    }
    
    public void setYardMarker(int yardMarker) {
        scoreboard.setFieldYardage(yardMarker);
    }
    
    public void setPossession(String team) {
        scoreboard.setPossession(team);
    }
    
    public void setQuarter(int quarter) {
        scoreboard.setQuarter(quarter);
    }
    
    public void move(int pix) {
        field.move(pix);
    }
    
    public void changePossession() {
        scoreboard.switchPossession();
    }
    
    public void glide() {
        field.glide(0);
    }
    
    public void animate (int start, int end, boolean goingRight) {
        field.animate(start,end,goingRight);
    }
    
}    
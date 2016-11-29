
import javax.swing.*;
import java.awt.*;

public class Actions extends JPanel {
    
    JButton setHomeTeamName, setAwayTeamName, setHomeScore, setAwayScore, setDown, setYardageToFirst;
    JButton setYardMarker, setQuarter;
    
    GUI main;
    public Actions(GUI manager) {
        super();
        main = manager;
        initComponents();
    }
    
    private void initComponents() {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        setHomeTeamName = new JButton("Set Home Team Name");
        setHomeTeamName.addActionListener(e -> main.setHomeTeamName(
            JOptionPane.showInputDialog(this, "Type in Team Name (In Caps):")));
            
        setAwayTeamName = new JButton("Set Away Team Name");
        setAwayTeamName.addActionListener(e -> main.setAwayTeamName(
            JOptionPane.showInputDialog(this, "Type in Team Name (In Caps):")));
            
        setHomeScore = new JButton("Set Home Score");
        setHomeScore.addActionListener(e -> main.setHomeScore(
            Integer.parseInt(JOptionPane.showInputDialog(this, "Type in Score:"))));
            
        setAwayScore = new JButton("Set Away Score");
        setAwayScore.addActionListener(e -> main.setAwayScore(
            Integer.parseInt(JOptionPane.showInputDialog(this, "Type in Score:"))));
            
        setDown = new JButton("Set Down");
        setDown.addActionListener(e -> main.setDown(
            Integer.parseInt(JOptionPane.showInputDialog(this, "Type in Down #:"))));
            
        setYardageToFirst = new JButton("Set Yardage Until 1st Down");
        setYardageToFirst.addActionListener(e -> main.setYardageToFirst(
            Integer.parseInt(JOptionPane.showInputDialog(this, "Type in Yardage Until 1st Down:"))));
        
        
        add(setHomeTeamName); add(setAwayTeamName); add(setHomeScore); add(setAwayScore);
        add(setDown); add(setYardageToFirst);
    }
}
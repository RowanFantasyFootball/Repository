
import javax.swing.*;
import java.awt.*;

public class Actions extends JPanel {
    
    JButton setHomeTeamName, setAwayTeamName, setHomeScore, setAwayScore, setDown, setYardageToFirst;
    JButton setYardMarker, setQuarter, test, changePos;
    
    GUI main;
    public Actions(GUI manager) {
        super();
        main = manager;
        initComponents();
    }
    
    private void initComponents() {
        this.setLayout(new GridLayout(2,1));
        JPanel first = new JPanel();
        JPanel second = new JPanel();
        first.setLayout(new FlowLayout());
        second.setLayout(new FlowLayout());
        
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
        
        setYardMarker = new JButton("Set Yard Marker");
        setYardMarker.addActionListener(e -> main.setYardMarker(
            Integer.parseInt(JOptionPane.showInputDialog(this, "Type in Yard Marker of Ball:"))));
        
        setQuarter = new JButton("Set Quarter");
        setQuarter.addActionListener(e -> main.setQuarter(
            Integer.parseInt(JOptionPane.showInputDialog(this, "Type in Quarter Number:"))));
            
        //test = new JButton("Draw Yardage");
        //test.addActionListener(e -> main.move(
            //Integer.parseInt(JOptionPane.showInputDialog(this, "Type in Yard Marker:"))));
            
        changePos = new JButton("Change Possession");
        changePos.addActionListener(e -> main.changePossession());
            
        first.add(setHomeTeamName); first.add(setAwayTeamName); 
        first.add(setHomeScore); first.add(setAwayScore); 
        second.add(setDown); second.add(setYardageToFirst); 
        second.add(setYardMarker); //second.add(test); 
        second.add(setQuarter); first.add(changePos);
        this.add(first); this.add(second);
    }
}
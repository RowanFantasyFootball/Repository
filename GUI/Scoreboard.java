import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JPanel {
    
    private JLabel home, away, hScore, aScore, down;
    public Scoreboard() {
        super();
        initComponents();
    }
    
    private void initComponents() {
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        home = new JLabel();
        away = new JLabel();
        hScore = new JLabel(" 0 ");
        aScore = new JLabel(" 0 ");
        
        setHomeTeamName("PHILADELPHIA");
        home.setFont(new java.awt.Font("Impact", 0, 48));
        home.setForeground(new Color(0,59,72)); //EAGLES GREEN
        home.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        hScore.setFont(new java.awt.Font("Arial", Font.BOLD, 48));
        hScore.setBorder(BorderFactory.createLineBorder(Color.black));
        
        setAwayTeamName("DALLAS");
        away.setFont(new java.awt.Font("Impact", 0, 48));
        away.setForeground(new Color(13,37,76));    //COWBOYS NAVY
        away.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        aScore.setFont(new java.awt.Font("Arial", Font.BOLD, 48));
        aScore.setBorder(BorderFactory.createLineBorder(Color.black));
        
        down = new JLabel();
        down.setFont(new java.awt.Font("Dialog", 1, 40));
        down.setText("1 & 10");
        
        add(home); add(hScore); add(away); add(aScore); add(Box.createHorizontalStrut(20)); add(down);
        
    }
    
    public void setHomeTeamName(String name) {
        if (name.indexOf(" ") != -1) { //Teams with spaces
            home.setText("  " + name.substring(0,1) + name.substring(name.indexOf(" ")+1, name.indexOf(" ")+2) + "  ");
        } else {
            home.setText("  " + name.substring(0,3) + "  ");
        }
        
    }
    
    public void setAwayTeamName(String name) {
        if (name.indexOf(" ") != -1) { //Teams with spaces
            away.setText("  " + name.substring(0,1) + name.substring(name.indexOf(" ")+1, name.indexOf(" ")+2) + "  ");
        } else {
            away.setText("  " + name.substring(0,3) + "  ");
        }
        
    }
    
        public void setHomeScore(int score) {
        hScore.setText("  " + score + "  ");
    }
    
    public void setAwayScore(int score) {
        aScore.setText("  " + score + "  ");
    }
    
    public void setDown(int down) {
        String yardage = this.down.getText().substring(1);
        this.down.setText(down + yardage);
    }
    
    public void setYardageToFirst(int yardageToFirst) {
        String downMarker = down.getText().substring(0,4);
        down.setText(downMarker + yardageToFirst);
    }
    
}

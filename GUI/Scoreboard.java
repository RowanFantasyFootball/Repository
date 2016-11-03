import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JPanel {
    
    public Scoreboard() {
        super();
        initComponents();
    }
    
    private void initComponents() {
        
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        this.add(new JLabel("Test"));
    }
}

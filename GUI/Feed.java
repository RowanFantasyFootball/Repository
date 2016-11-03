import javax.swing.*;
import java.awt.*;

public class Feed extends JPanel {

    public Feed() {
        super();
        initComponents();
    }
    
    private void initComponents() {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        this.add(new JLabel("Test"));
    }
}
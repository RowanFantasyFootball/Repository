
import javax.swing.*;
import java.awt.*;

public class Actions extends JPanel {

    public Actions() {
        super();
        initComponents();
    }
    
    private void initComponents() {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        this.add(new JLabel("Test"));
    }
}
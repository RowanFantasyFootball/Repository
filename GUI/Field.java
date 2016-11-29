import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {

    public Field() {
        super();
        initComponents();
    }
    
    private void initComponents() {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        ImageIcon img = new ImageIcon("field.png");
        
        JLabel background = new JLabel();
        background.setIcon(img);
        background.setLayout(new BorderLayout());
        this.add(background);
    }
}
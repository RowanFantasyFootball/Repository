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
        
        this.add(new JLabel(new ImageIcon("field.png")));
        /**
         * This is the 'To Be Added' Content Pane data.
         */
        //this.add();
    }
}
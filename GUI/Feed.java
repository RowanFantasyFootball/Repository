import javax.swing.*;
import java.awt.*;

public class Feed extends JPanel {

    JTextArea messageFeed;
    JScrollPane scrollPane;
    public Feed() {
        super();
        initComponents();
        
    }
    
    private void initComponents() {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        messageFeed = new javax.swing.JTextArea();
        scrollPane = new javax.swing.JScrollPane();
        
        //setPreferredSize(new Dimension(1920,2000));
        
        //messageFeed.setSize(84,1233);
        messageFeed.setColumns(20);
        messageFeed.setRows(5);
        messageFeed.setFont(new java.awt.Font("Calibri", 0, 18));
        messageFeed.setText("Message Line 1\nMessage Line 2\nMessage Line 3\nMessage Line 4\nMessage Line 5\nEtc.");
        messageFeed.setEditable(false);
        
        scrollPane.setViewportView(messageFeed);
        
        //this.add(messageFeed);
        fixLayout();
    }
    
    private void fixLayout() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
    
    public void setMessage(String message) {
        messageFeed.setText(messageFeed.getText() + "\n" + message);
    }
    
    public String toString() {
        return messageFeed.getText();
    }
}
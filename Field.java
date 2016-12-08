import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class Field extends JPanel {
    ImageIcon img;
    ImageIcon eagles;
    ImageIcon cowboys;
    ImageIcon firstDown;
    JLabel background;
    JLabel poss;
    JLabel firstD;
    
    private final int rightEndzoneArea = 49 + (int)(90*7.4);
    private final int leftEndzoneArea = 49 + (int)(10*7.4);
    
    
    public Field() {
        super();
        img = new ImageIcon("field.png");
        eagles = new ImageIcon("Eagles Possession.png");
        cowboys = new ImageIcon("Cowboys Possession.png");
        firstDown = new ImageIcon("FirstDownLine.png");
        background = new JLabel();
        poss = new JLabel();
        firstD = new JLabel();
        initComponents();
    }
    
    private void initComponents() {

        this.setBorder(BorderFactory.createLineBorder(Color.black));

        background.setIcon(img);
        background.setLayout(new BorderLayout());
        this.add(background);
        
        poss.setIcon(eagles);
        poss.setLayout(new BorderLayout());
        background.add(poss);
        
        firstD.setIcon(firstDown);
        firstD.setLayout(new BorderLayout());
        poss.add(firstD);
        //firstD.setBounds(150, firstD.getY(), firstD.getWidth(), firstD.getHeight());
        
    }
    
    public void move(int yardMarker, int yardageToFirst) {
          //EVERY 74 PIXELS IS 10 YDS
          //Convert
          int pix = 49 + (int)(yardMarker*7.4);
          poss.setBounds(pix,poss.getY(),poss.getWidth(), poss.getHeight());
          int fdl = 74 + (int)(yardageToFirst*7.4);
          firstD.setBounds(fdl, firstD.getY(), firstD.getWidth(), firstD.getHeight());
        
    }
    
    public void flipPossessionImage() {
        if (background.getIcon().equals(eagles)) {
            background.setIcon(cowboys);
        } else {
            background.setIcon(eagles);
        }
    }
    
    public void animate(int startYard, int endYard, int distanceToFDL, boolean goingRight) {
        if (goingRight) {
            poss.setIcon(eagles);
            for (int i = startYard; i <= endYard; i++) {
                int pix = 49 + (int)(i*7.4);
                int currentFDL = firstD.getX();
                
                poss.setBounds(pix, poss.getY(), poss.getWidth(), poss.getHeight());
                try {
                    Thread.sleep(50);
                } catch (Exception e) {} 
            }
        } else {
            poss.setIcon(cowboys);
            for (int i = startYard; i >= endYard; i--) {
                int pix = 49 + (int)(i*7.4);
                poss.setBounds(pix, poss.getY(), poss.getWidth(), poss.getHeight());
                try {
                    Thread.sleep(50);
                } catch (Exception e) {} 
            }
        }
        int loc = 74 + (int)(distanceToFDL*7.4);
        firstD.setBounds(loc, firstD.getY(), firstD.getWidth(), firstD.getHeight());

    }
    
    public void glide(int startLocation) {
        boolean goLeft = false;
        if (startLocation > 50) {
            goLeft = true;
        }
        boolean loop = true;
        while (loop) {
            if (goLeft) {
                poss.setIcon(cowboys);
                for (int i = startLocation; i >= 0; i--) {
                    int pix = 49 + (int)(i*7.4);
                    poss.setBounds(pix, poss.getY(), poss.getWidth(), poss.getHeight());
                    try {
                        Thread.sleep(50);
                    } catch (Exception e) {}                    
                }
                startLocation = 0;
                goLeft = false;
            } else {
                poss.setIcon(eagles);
                for (int i = startLocation; i <= 100; i++) {
                    int pix = 49 + (int)(i*7.4);
                    poss.setBounds(pix, poss.getY(), poss.getWidth(), poss.getHeight());
                    try {
                        Thread.sleep(50);
                    } catch (Exception e) {}   
                }
                startLocation = 100;
                goLeft = true;
            }
            try {
                        Thread.sleep(100);
            } catch (Exception e) {} 
            
        }
    }
}
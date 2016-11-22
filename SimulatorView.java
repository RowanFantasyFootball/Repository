import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A graphical view of the simulation grid.
 * The view displays a colored rectangle for each location 
 * representing its contents. It uses a default background color.
 * Colors for each type of species can be defined using the
 * setColor method.
 * 
 * @author Clinton Conyer
 * @version 11/21/2016
 */
public class SimulatorView extends JFrame
{

    // Colors used for empty locations.
    private static final Color EMPTY_COLOR = Color.green;

    // Color used for objects that have no defined color.
    private static final Color UNKNOWN_COLOR = Color.gray; 
    private final String STEP_PREFIX = "";
    private final String POPULATION_PREFIX = "";
    private JLabel stepLabel, population;
    private FieldView fieldView;

    // A map for storing colors for participants in the simulation
    private Map<Class, Color> colors;
    // A statistics object computing and storing simulation information
    //private FieldStats stats;
    public int yard;
    public SimulatorView(int height, int width)
    {
        //stats = new FieldStats();
        colors = new LinkedHashMap<>();

        setTitle("OOPDA FOOTBALL 2K16");
        stepLabel = new JLabel(STEP_PREFIX, JLabel.CENTER);
        population = new JLabel(POPULATION_PREFIX, JLabel.CENTER);

        setLocation(100, 50);

        fieldView = new FieldView(height, width);

        Container contents = getContentPane();
        contents.add(stepLabel, BorderLayout.NORTH);
        contents.add(fieldView, BorderLayout.CENTER);
        contents.add(population, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    /**
     * Define a color to be used for a given class of team.
     * @param team The team's Class object.
     * @param color The color to be used for the given class.
     */
    public void setColor(Class team, Color color)
    {
        colors.put(team, color);
    }

    /**
     * Show the current status of the field.
     * @param step Which iteration step it is.
     * @param field The field whose status is to be displayed.
     */
    public void showStatus(int yar)
    {
        
        yard = 10+yar;
        if(!isVisible()) {
            setVisible(true);
        }
        //stepLabel.setText(STEP_PREFIX + step);
        fieldView.preparePaint();

        for(int row = 0; row < 50; row++) {
            for(int col = 0; col < 120; col++) {
                {
                    fieldView.drawMark(col, row, EMPTY_COLOR);
                }
            }
        }
        //population.setText(POPULATION_PREFIX + stats.getPopulationDetails(field));
        for(int row = 0; row < 50; row++) {
            fieldView.drawMark(9, row, Color.white);
        }
        for(int row = 0; row < 50; row++) {
            fieldView.drawMark(109, row, Color.white);
        }
        for(int row = 0; row < 50; row++) {
            fieldView.drawMark(59, row, Color.white);
        }
        fieldView.drawMark(yard, 10, Color.red); //left wide reciever *yard
        fieldView.drawMark(yard, 22, Color.red); //tight end *yard
        fieldView.drawMark(yard, 23, Color.red); //left tackle *yard
        fieldView.drawMark(yard, 24, Color.red); //left guard *yard
        fieldView.drawMark(yard, 25, Color.red); //center *yard
        fieldView.drawMark(yard, 26, Color.red); //right guard *yard
        fieldView.drawMark(yard, 27, Color.red); //right tackle *yard
        fieldView.drawMark(yard, 32, Color.red); //slot reciever *yard
        fieldView.drawMark(yard, 40, Color.red); //right wide reciever *yard
        fieldView.drawMark(yard-1, 25, Color.red); //quarterback *yard-1
        fieldView.drawMark(yard-4, 25, Color.red); //runningback *yard-4
        //defense
        fieldView.drawMark(yard+5, 10, Color.blue); //left corner                   *yard+5         *left wide reciever
        fieldView.drawMark(yard+1, 23, Color.blue); //left defensive end            *yard+1         *left tackle
        fieldView.drawMark(yard+1, 24, Color.blue); //left defensive tackle         *yard+1         *left guard
        fieldView.drawMark(yard+1, 26, Color.blue); //right defensive tackle        *yard+1         *right guard    
        fieldView.drawMark(yard+1, 27, Color.blue); //right defensive end           *yard+1         *right tackle
        fieldView.drawMark(yard+10, 25, Color.blue); //left saftey                   *yard+10        *center
        fieldView.drawMark(yard+7, 32, Color.blue); //right saftey                  *yard+7         *slot reciever
        fieldView.drawMark(yard+5, 40, Color.blue); //right corner                  *yard+5         *right wide reciever
        fieldView.drawMark(yard+5, 22, Color.blue); //left linebacker               *yard+5         *tight end
        fieldView.drawMark(yard+5, 25, Color.blue); //middle linebacker             *yard+5         *runningback
        fieldView.drawMark(yard+5, 27, Color.blue); //right linebacker              *yard+5         *right tackle(spy qb)
        
        fieldView.repaint();
    }

    public void placePlayerA(Object TeamplayerA, int column, int ro)
    {
        int col =column;
        int row = ro;

        fieldView.drawMark(col, row, Color.blue);
        fieldView.repaint();
    }

    public void placePlayerB(Object TeamplayerB, int column, int ro)
    {
        int col =column;
        int row = ro;

        fieldView.drawMark(col, row, Color.red);
        fieldView.repaint();
    }
    /**
     * Provide a graphical view of a rectangular field. This is 
     * a nested class (a class defined inside a class) which
     * defines a custom component for the user interface. This
     * component displays the field.
     * This is rather advanced GUI stuff - you can ignore this 
     * for your project if you like.
     */
    private class FieldView extends JPanel
    {
        private final int GRID_VIEW_SCALING_FACTOR = 6;

        private int gridWidth, gridHeight;
        private int xScale, yScale;
        Dimension size;
        private Graphics g;
        private Image fieldImage;

        /**
         * Create a new FieldView component.
         */
        public FieldView(int height, int width)
        {
            gridHeight = height;
            gridWidth = width;
            size = new Dimension(0, 0);
        }

        /**
         * Tell the GUI manager how big we would like to be.
         */
        public Dimension getPreferredSize()
        {
            return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                gridHeight * GRID_VIEW_SCALING_FACTOR);
        }

        /**
         * Prepare for a new round of painting. Since the component
         * may be resized, compute the scaling factor again.
         */
        public void preparePaint()
        {
            if(! size.equals(getSize())) {  // if the size has changed...
                size = getSize();
                fieldImage = fieldView.createImage(size.width, size.height);
                g = fieldImage.getGraphics();

                xScale = size.width / gridWidth;
                if(xScale < 1) {
                    xScale = GRID_VIEW_SCALING_FACTOR;
                }
                yScale = size.height / gridHeight;
                if(yScale < 1) {
                    yScale = GRID_VIEW_SCALING_FACTOR;
                }
            }
        }

        /**
         * Paint on grid location on this field in a given color.
         */
        public void drawMark(int x, int y, Color color)
        {
            g.setColor(color);
            g.fillRect(x * xScale, y * yScale, xScale-1, yScale-1);
        }

        /**
         * The field view component needs to be redisplayed. Copy the
         * internal image to screen.
         */
        public void paintComponent(Graphics g)
        {
            if(fieldImage != null) {
                Dimension currentSize = getSize();
                if(size.equals(currentSize)) {
                    g.drawImage(fieldImage, 0, 0, null);
                }
                else {
                    // Rescale the previous image.
                    g.drawImage(fieldImage, 0, 0, currentSize.width, currentSize.height, null);
                }
            }
        }
    }

}

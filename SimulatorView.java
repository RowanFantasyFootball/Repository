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
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
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
    public void showStatus(int step, Field field)
    {
        if(!isVisible()) {
            setVisible(true);
        }
        stepLabel.setText(STEP_PREFIX + step);
        fieldView.preparePaint();

        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                {
                    fieldView.drawMark(col, row, EMPTY_COLOR);
                }
            }
        }
        //population.setText(POPULATION_PREFIX + stats.getPopulationDetails(field));
        for(int row = 0; row < field.getDepth(); row++) {
            fieldView.drawMark(9, row, Color.white);
        }
        for(int row = 0; row < field.getDepth(); row++) {
            fieldView.drawMark(109, row, Color.white);
        }
        for(int row = 0; row < field.getDepth(); row++) {
            fieldView.drawMark(59, row, Color.white);
        }
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

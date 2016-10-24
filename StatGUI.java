 

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class StatGUI extends JFrame
{
	public StatGUI()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(1,1);
		this.setLayout(grid);
		this.setOpacity(1.0f);
		this.setTitle("Statistic");
		this.setBackground(Color.white);
		this.pack();
		this.setSize(750, 300);
		this.setLocationRelativeTo(null);
		this.add(new MessageBoardGUI());
		this.setVisible(true);
	}
}

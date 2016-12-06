import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessageBoardGUI extends JPanel
{
	public MessageBoardGUI()
	{
		this.setLayout(new BorderLayout());
		JPanel topP = new JPanel(new BorderLayout());
		JPanel centerP = new JPanel(new BorderLayout());
		JPanel bottomP = new JPanel(new BorderLayout());
		//////////////////////////////////////////////////////
		JLabel title = new JLabel("Message Board");
		title.setFont(new Font("Monospaced", Font.BOLD, 20));
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(JLabel.CENTER);
		//////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////
		JTextArea jt = new JTextArea("Welcome to the OOPDA Fall 2016 Class Football Simulation");
		jt.setFont(new Font("Monospaced", Font.PLAIN, 15));
		jt.setForeground(Color.BLUE);
		jt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		jt.setLineWrap(true);
		jt.setEditable(false);
		//////////////////////////////////////////////////////
	
		//////////////////////////////////////////////////////
		JButton displayStat = new JButton("Show Stat Number Code");
		class DisplayStatListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e) 
			{
					PlayerStat ps = new PlayerStat();
					jt.setText("The number corresponds with the stat"
							+ " is the number code for you to look up"
							+ " in the search bar to search for the stat you"
							+ "	would like to look know.\n" 
							);
			}
		}
		displayStat.addActionListener(new DisplayStatListener());
		//////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////
		JButton disStat = new JButton ("Display");
		JTextField jt1 = new JTextField("Enter here which stat you want to see");
		jt1.setSize(getMaximumSize());
		jt1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		jt1.setForeground(Color.RED);
		jt1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		class UpdateStatListerner implements ActionListener
		{
			public void actionPerformed(ActionEvent e) 
			{
				String s = jt1.getText();
				int i = Integer.parseInt(s);
				PlayerStat ps = new PlayerStat();
				jt.setText("Message");
			}
		}
		disStat.addActionListener(new UpdateStatListerner());
			
		//////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////
		//////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////
		topP.add(title);
		topP.add(jt1, BorderLayout.AFTER_LINE_ENDS);
		centerP.add(jt);
		bottomP.add(displayStat, BorderLayout.BEFORE_LINE_BEGINS);
		bottomP.add(disStat, BorderLayout.AFTER_LINE_ENDS);
		this.add(topP, BorderLayout.NORTH);
		this.add(centerP, BorderLayout.CENTER);
		this.add(bottomP, BorderLayout.SOUTH);
		//////////////////////////////////////////////////////
		
	}	
}
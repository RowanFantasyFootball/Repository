 

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
		JTextArea jt = new JTextArea("Message will be display here later on. This text area will be modofied as progress");
		jt.setFont(new Font("Monospaced", Font.PLAIN, 15));
		jt.setForeground(Color.BLUE);
		jt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		jt.setLineWrap(true);
		jt.setEditable(false);
		//////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////
		JButton displayStat = new JButton("Display Stat");
		class DisplayStatListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e) 
			{
					PlayerStat ps = new PlayerStat();
					jt.setText(ps.getOV().toString());
			}
		}
		displayStat.addActionListener(new DisplayStatListener());
		//////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////
		JButton updateStat = new JButton ("Update Stat");
		//////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////
		//////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////
		topP.add(title);
		centerP.add(jt);
		bottomP.add(displayStat, BorderLayout.BEFORE_LINE_BEGINS);
		bottomP.add(updateStat, BorderLayout.AFTER_LINE_ENDS);
		this.add(topP, BorderLayout.NORTH);
		this.add(centerP, BorderLayout.CENTER);
		this.add(bottomP, BorderLayout.SOUTH);
		//////////////////////////////////////////////////////
		
		
	}	
}

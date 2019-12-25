//********************************************************************
//
// File: 	PeriodicTablePanel.java
// Purpose:	Displays PeriodicTable
//
//********************************************************************
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PeriodicTablePanel extends JPanel
{
	JPanel panel = new JPanel();
	JLabel label = new JLabel("PERIODIC TABLE");
	public PeriodicTablePanel() throws IOException
	{
		label.setFocusable(true);
		panel.setBackground(Color.cyan);
		panel.add(label);
		panel.setPreferredSize(new Dimension(1000, 50));
		setLayout(new BorderLayout());
		add(new PeriodicTable(), BorderLayout.CENTER);
		add(panel, BorderLayout.NORTH);
		add(new ColourSchemePanel(), BorderLayout.WEST);
	}
}

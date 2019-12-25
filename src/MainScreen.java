//********************************************************************
//
// File: 	MainScreen.java
// Purpose:	Displays PeriodicTablePanel and SearchPanel
//
//********************************************************************
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class MainScreen extends JPanel
{
	public static void main(String[] args)throws IOException
	{
		JFrame frame = new JFrame("Chemistry");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1500, 700));
		
		JTabbedPane tb = new JTabbedPane();
		tb.add(new PeriodicTablePanel(), "Periodic Table");
		tb.add(new Searchpanel(), "Search");
		frame.getContentPane().add(tb);
		
		frame.pack();
		frame.setVisible(true);
	}
}

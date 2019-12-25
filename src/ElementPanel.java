//********************************************************************
//
// File: 	ElementPanel.java
// Purpose:	Displays information about the element selected in
//			Periodic table
//
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class ElementPanel extends JPanel 
{
	ArrayList <String> labelList =  new ArrayList<>();
	ImageIcon icon;
	
	public ElementPanel(Element E) throws IOException
	{
		String iconString = E.getZ()+ ".jpg";
		icon = new ImageIcon(iconString);
		Scanner scan = new Scanner(E.toString());		
		while (scan.hasNext())
		{
			String s = scan.nextLine();
			labelList.add(s);
		}			
		
		setBackground(Color.white);
		setPreferredSize(new Dimension (350, 620));
	}
	
	public void paintComponent(Graphics page)
	{
		for (int i=0; i<labelList.size(); i++)
		{
			page.drawString(labelList.get(i), 60, i*20+20);
		}
		
		icon.paintIcon(this, page, 30, 200);
	}
}

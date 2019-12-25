//********************************************************************
//
// File: 	ColourSchemePanel.java
// Purpose:	Displays information of the colour code used for 
//			the periodic table
//
//******************************************************************
import java.awt.*;
import javax.swing.*;

public class ColourSchemePanel extends JPanel
{
	public ColourSchemePanel()
	{
		setBackground(Color.white);
		setPreferredSize(new Dimension(70,700));
	}
	
	public void paintComponent(Graphics page)
	{
		setBackground(Color.white);
		//Solid
		page.setColor(Color.black);
		page.drawString("Metals", 20, 100);
		page.setColor(Color.yellow);
		page.fillRect(20, 115, 30, 30);
		//Liquid
		page.setColor(Color.black);
		page.drawString("Non-Metals", 5, 170);
		page.setColor(Color.cyan);
		page.fillRect(20, 185, 30, 30);
		//Gases
		page.setColor(Color.black);
		page.drawString("Metalloids", 5, 240);
		page.setColor(Color.green);
		page.fillRect(20, 255, 30, 30);
		
		//Solids
		page.setColor(Color.black);
		page.drawString("Solids", 10, 500);
		//Liquids
		page.setColor(Color.blue);
		page.drawString("Liquids", 10, 530);
		//Gases
		page.setColor(Color.red);
		page.drawString("Gases", 10, 560);
	}
}

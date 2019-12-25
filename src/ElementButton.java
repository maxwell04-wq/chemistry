//********************************************************************
//
// File: 	ElementButton.java
// Purpose:	Aggregates an Element an JButton to form a box
//			of periodic table
//
//********************************************************************
import java.awt.Color;

import javax.swing.JButton;

public class ElementButton
{	
	Element E;
	public JButton button;
	
	public ElementButton(Element E)
	{
		this.E = E;
		button = new JButton(E.getSymbol());
		
		//Button Background
		if (E.physicalState.equals("Solid"))
			button.setForeground(Color.black);
		else if (E.physicalState.equals("Liquid"))
			button.setForeground(Color.blue);
		else if (E.physicalState.equals("Gas"))
			button.setForeground(Color.red);
		else
			button.setForeground(Color.MAGENTA);
		
		//Button Text Font
		if (E.getMetallic().equals("Metal"))
			button.setBackground(Color.yellow);
		else if (E.getMetallic().equals("Non-Metal"))
			button.setBackground(Color.cyan);
		else if (E.getMetallic().equals("Metalloid"))
			button.setBackground(Color.green);
			
	}
	public String getName() // Name Getter
	{
		return E.getName();
	}
	
	public int getZ() // Atomic Number Getter
	{
		return E.Z;
	}
	
	public int getA() // Atomic mass Getter
	{
		return E.A;
	}
	
	public String getSymbol() //Symbol Getter
	{
		return E.symbol;
	}
}
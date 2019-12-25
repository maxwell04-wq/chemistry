//********************************************************************
//
// File: 	SearchPanel.java
// Purpose:	Displays BalanceChemicalEqPanel
//
//********************************************************************
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Searchpanel extends JPanel
{
	public Searchpanel()throws IOException
	{
		BalanceChemicalEqPanel bPanel = new BalanceChemicalEqPanel();		
		add(bPanel);
	}
}

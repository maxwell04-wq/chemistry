//********************************************************************
//
// File: 	PeriodicTable.java
// Purpose:	Displays a periodic table and the colour scheme used in it
//
//********************************************************************
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.io.*;

// Periodic Table
public class PeriodicTable extends JPanel
{
	ElementPanel p;
	ArrayList <ElementButton> elementArray;
	public PeriodicTable() throws IOException	// Constructor
	{
		Scanner elementScan = new Scanner(new File("ChemistryPhysical.dat"));
		// Array of ElementButtons
		elementArray = new ArrayList<ElementButton> ();		
		//Instantiation of ElementButtons
		for (int i=1; i<=118; i++)
		{
			String elementLine = elementScan.nextLine();
			Scanner data = new Scanner(elementLine);
			String name = data.next();
			String symbol = data.next();
			int Z= data.nextInt();
			int A = data.nextInt();
			String pS = data.next();
			String m = data.next();
			double e = data.nextDouble();
			elementArray.add(new ElementButton(new Element(name,symbol,Z, A ,pS, m , e)));
		}
		// ElementButton GridLayout Panel
		setLayout(new GridLayout(0,19,0,0));
		setBackground(Color.WHITE);
		int i=0;
		//First row
		add(new JLabel());
		add(new JLabel("1"));
		for (int j=0; j<16; j++)
			add(new JLabel(""));
		add(new JLabel("18"));
		// First Period
		add(new JLabel("1"));
		add(elementArray.get(i).button);
		i++;
		add(new JLabel("2"));
		add(new JLabel(""));
		for (int j=0; j<9; j++)
			add(new JLabel(""));
		for (int j=13; j<18; j++)
			add(new JLabel(""+j));
		add(elementArray.get(i).button);
		i++;
		//Second Period 
		add(new JLabel("2"));
		for(;i<4;i++)
			add(elementArray.get(i).button);
		for (int j=0; j<10; j++)
			add(new JLabel(""));
		for (; i<10; i++)
			add(elementArray.get(i).button);
		i++;
		//Third Period
		add(new JLabel("3"));
		for(;i<=12;i++)
			add(elementArray.get(i-1).button);
		for (int j=3; j<13; j++)
			add(new JLabel(""+j));
		for (; i<=18; i++)
			add(elementArray.get(i-1).button);
		//Fourth Period
		add(new JLabel("4"));
		for( ; i<=36 ; i++)
			add(elementArray.get(i-1).button);
		//Fifth Period
		add(new JLabel("5"));
		for( ; i<=54 ; i++)
			add(elementArray.get(i-1).button);
		//Sixth Period
		add(new JLabel("6"));
		for( ; i<58 ; i++)
			add(elementArray.get(i-1).button);
		for( i=72; i<=86 ; i++)
			add(elementArray.get(i-1).button);
		//Seventh Period
		add(new JLabel("7"));
		for( ; i<=89 ; i++)
			add(elementArray.get(i-1).button);
		for( i=104; i<=118 ; i++)
			add(elementArray.get(i-1).button);
		//Space
		for (int j=0; j<19;j++)
			add(new JLabel(""));
		//Lanthanides
		add(new JLabel("Lanthanides"));
		add(new JLabel(""));
		add(new JLabel(""));
		for (i=58; i<=71; i++)
			add(elementArray.get(i-1).button);
		add(new JLabel(""));
		add(new JLabel(""));
		//Actinides
		add(new JLabel("Actinides"));
		add(new JLabel(""));
		add(new JLabel(""));
		for (i=90; i<=103; i++)
			add(elementArray.get(i-1).button);
		//Space
		for (int j=0; j<19;j++)
			add(new JLabel(""));
		
		SymbolListener listener = new SymbolListener();
		for (int k=0; k<118; k++)
			elementArray.get(k).button.addActionListener(listener);
		
		setPreferredSize(new Dimension(1500,700));
	}
	
	class SymbolListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			for (int x=0; x<118; x++)
			{
				ElementButton ex = elementArray.get(x);
				if (event.getSource() == ex.button )
				{
					JFrame frame = new JFrame(ex.E.getName());
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					frame.setBackground(Color.WHITE);
					
					try 
					{
						p = new ElementPanel(ex.E);
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
					frame.getContentPane() .add(p);
					frame.pack();
					frame.setVisible(true);
				}
			}
		}
	}
}

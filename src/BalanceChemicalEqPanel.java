//********************************************************************
//
// File: 	BalanceChemicalEqPanel.java
// Purpose:	Takes two Elements from user, determines the type of
//			reaction, and displays the product
//
//********************************************************************
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class BalanceChemicalEqPanel extends JPanel
{
	// Member Declaration
	JTextField cation, anion;
	JLabel product = new JLabel();
	JButton button = new JButton("Go"); 
	ArrayList <Element> elementArray;
	ArrayList <Ion> anionArray;
	ArrayList <Ion> cationArray;
	ArrayList <Ion> unreactiveArray;
	ArrayList <Atom> atomArray;
	Element leftElement= new Element();
	Element rightElement = new Element();
	Element matchElement;
	Product p;
	JPanel DetailPanel = new detailPanel("Details:");
	JPanel rightPanel = new JPanel();
	
	//Constructor
	public BalanceChemicalEqPanel()throws IOException
	{
		// Element Array Declaration and Instantiation
		elementArray = new ArrayList <> ();
		anionArray = new ArrayList <Ion>();
		cationArray = new ArrayList <Ion>();
		unreactiveArray = new ArrayList <Ion>();
		atomArray = new ArrayList <>();
		
		//Heading
		JLabel IntroLabel =  (new JLabel("LET'S FORM BONDS!"));
		IntroLabel.setFont(new Font("Arial", Font.BOLD, 36));
		
	    //Instantiation of Variables
		Scanner elementChemicalScan = new Scanner(new File ("IonList.dat"));
		for (int j=0; j<118; j++)
		{
			String element = elementChemicalScan.nextLine();
			Scanner dataScan = new Scanner (element);
			String name = dataScan.next();
			String symbol = dataScan.next();
			int Z = dataScan.nextInt();
			int A = dataScan.nextInt();
			String PhysicalState = dataScan.next(); 
			String m = dataScan.next();
			double e = dataScan.nextDouble();
			String valency = dataScan.next();
			String ionName = dataScan.next();
			Ion i = new Ion(name, symbol, Z, A, PhysicalState ,m, e, valency, ionName);
			Atom a = new Atom(name, symbol, Z, A, PhysicalState, m ,e,valency);
			Element E = new Element(name, symbol, Z, A, PhysicalState, m ,e);
			// IonArray Instantiation
			if (i.getValency().equals("x") || i.getValency().equals("0") )
				unreactiveArray.add(i);
			else if (i.getValency().equals("1")	|| i.getValency().equals("2") || i.getValency().equals("3"))
				cationArray.add(i);
			else
				anionArray.add(i);
			//AtomArrayInstantiation
			atomArray.add(a);	
			//Element Array Instantiation
			elementArray.add(E);
		}
		//LabelPanel
		JPanel labelPanel = new JPanel();
		labelPanel.add(IntroLabel);
		labelPanel.setBackground(Color.yellow);
		
		//Equation Panel
		cation = new JTextField(3);
		anion = new JTextField(3);
		JPanel eqPanel= new JPanel();
		eqPanel.add(cation);
		eqPanel.add (cation);
		eqPanel.add (new JLabel(" + "));
		eqPanel.add(anion);
		eqPanel.add (new JLabel(" = "));
		eqPanel.add(product);
		eqPanel.setBackground(Color.yellow);
		product.setText("");
		eqPanel.add(Box.createRigidArea(new Dimension (100, 100)));
		eqPanel.add(button);
		
		//Right Panel
		rightPanel.setLayout(new GridLayout(0,1,1,0));
		rightPanel.add(labelPanel);
		rightPanel.add(eqPanel);
		add(DetailPanel);
		rightPanel.setPreferredSize(new Dimension(500,100));		
		
		//ActonListeners
		ionListener listener = new ionListener();
		button.addActionListener(listener);		
		//anion.addActionListener(listener);
		
		//Final Panel
		setLayout (new GridLayout(0,2,2,0));
		setPreferredSize(new Dimension(1350,700));
		add(rightPanel);
		add(DetailPanel);
	}
	
	class ionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			remove(DetailPanel);
			String inputLeft = cation.getText();
			String inputRight = anion.getText();
		
			for (int x=0; x<elementArray.size(); x++)
			{
				matchElement = elementArray.get(x);
				if (inputLeft.equals(matchElement.getSymbol()))
				{
					leftElement = new Element (matchElement);
				}
			}
								
			for (int y=0; y<elementArray.size(); y++)
			{
				matchElement = elementArray.get(y);
				if (inputRight.equals(matchElement.getSymbol()))
				{
					rightElement = new Element (matchElement);
				}
			}				
			Reactant r1 = null , r2 = null;
			Product p = null;
			
			
			//Molecular Bond
			if ( ((rightElement.EN - leftElement.EN ) < 1.5 && (rightElement.EN - leftElement.EN ) >= 0 )|| rightElement.getEN()==0 || leftElement.getEN()==0)
			{
				for (int i=0; i<atomArray.size(); i++)
					if(inputLeft.equals(atomArray.get(i).getSymbol()))
							r1 = atomArray.get(i);
				for (int j=0; j<atomArray.size(); j++)
					if (inputRight.equals(atomArray.get(j).getSymbol()))
						r2 = atomArray.get(j);
				if (r1.getEN()< r2.getEN())
					p = r1.bond(r2);
				else 
					p = r2.bond(r1);
				Molecule m = (Molecule) p;	
				product.setText(m.toString());
			}
			//Ionic Bond
			else 
			{
				if (rightElement.getEN() < leftElement.getEN())
				{
					Element hold = new Element(leftElement);
					leftElement = new Element (rightElement);
					rightElement = new Element (hold);					
				}
				for (int i=0; i<cationArray.size(); i++)
				{
					if (leftElement.getSymbol().equals(cationArray.get(i).getSymbol()))
						r1 = cationArray.get(i);
				}
				for (int j=0; j<anionArray.size(); j++)
				{
					if (rightElement.getSymbol().equals(anionArray.get(j).getSymbol()))
							 r2 = anionArray.get(j);
				}
				//Ion Type Determination
				
				p = r1.bond(r2);
				Compound c = (Compound)p;
				
				product.setText(c.toString());
			}
			
			// Detail Setting
			add(DetailPanel = new detailPanel(p.getInfo()));
		} 
	}
}

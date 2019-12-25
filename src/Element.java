//********************************************************************
//
// File: 	Element.java
// Purpose:	A class representing an element
//
//******************************************************************
public class Element 
{
	// Attributes
	String name;
	String symbol;
	int Z; // atomic number
	int A; // atomic mass
	String physicalState;
	String metallic;
	double EN; //Electronegativity Value
	
	//Default Constructor	
		public Element()
		{
		}
	
	//Parametrised Constructor	
	public Element(String name, String symbol, int Z, int A, String physicalState, String metallic, double EN)
	{
		this.name = name;
		this.symbol = symbol;
		this.Z = Z;
		this.A = A;
		this.physicalState = physicalState;
		this.metallic = metallic; //Metallic Character
		this.EN = EN;
	}
	
	//Copy Constructor
	public Element(Element other)
	{
		this.name = other.name;
		this.symbol = other.symbol;
		this.Z = other.Z;
		this.A = other.A;
		this.physicalState = other.physicalState;
		this.metallic = other.metallic; //Metallic Character
		this.EN = other.EN;
	}
	
	// Getters
	public String getName() // Name Getter
	{
		return this.name;
	}
	
	public int getZ() // Atomic Number Getter
	{
		return this.Z;
	}
	
	public int getA() // Atomic mass Getter
	{
		return this.A;
	}
	
	public String getSymbol() //Symbol Getter
	{
		return symbol;
	}
	public String getPhysicalState()	//Physical State Getter
	{
		return physicalState;
	}
	
	public String getMetallic() //Metallic Character Getter
	{
		return metallic;
	}
	
	public double getEN() //Electronegativity Getter
	{
		return EN;
	}
	
	//Setters
	public void setZ(int z) // Atomic Number Setter
	{
		this.Z = z;
	}
	
	public void settA(int a) // Atomic mass Setter
	{
		this.A = a;
	}
	
	public void setSymbol(String s) //Symbol Setter
	{
		symbol = s;
	}
	public void setPhysicalState(String p)	//Physical State Setter
	{
		physicalState = p;
	}
	
	public void setMetallic(String metallic) //Metallic Character Getter
	{
		this.metallic = metallic;
	}
	
	public void setEN(double EN) //Electronegativity Getter
	{
		this.EN = EN;
	}
	//toString
	public String toString()
	{
		return "                 " + this.getName().toUpperCase() + "\n" + "Symbol : "+ this.getSymbol()+"\n" 
				+ "Atomic Number : "+ this.getZ() + "\n" + "Atomic Mass : "+ this.getA() + 
				"\n" + "Physical State : "+ this.getPhysicalState()+"\n" 
				+ "Metallic Character : "+ this.getMetallic() + "\n" + "Electronegativity Value : "+ this.getEN();
	}
}

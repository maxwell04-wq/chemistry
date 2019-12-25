//********************************************************************
//
// File: 	Reactant.java
// Purpose:	A general form of an element which takes part in a reaction
//
//********************************************************************
public abstract class Reactant extends Element
{
	// Attributes
	String valency;
	
	//Default Constructor
	public Reactant()
	{		
	}
	//Parametrised Constructor
	public Reactant(String name, String symbol, int Z, int A, String physicalState, String metallic, double EN, String valency)
	{
		super(name, symbol, Z, A, physicalState, metallic, EN);
		
		this.valency = valency;
	}	
	// Getter
	public String getValency()
	{
		return valency;
	}
	//Setter
	public void setValency(String v)
	{
		valency = v;
	}
	//Abstract Method
	public abstract Product bond(Reactant other);
}

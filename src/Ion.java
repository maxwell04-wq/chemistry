//********************************************************************
//
// File: 	Ion.java
// Purpose:	A generalization of an reactant which takes part in a 
//			ionic reaction
//
//********************************************************************

public class Ion extends Reactant
{
	// Members
	String valency;
	String ionName;
	Compound product;
	
	//Default Constructor
	public Ion()
	{
		super();
	}
	
	// Parametrised Constructor
	public Ion(String name, String symbol, int Z, int A, String physicalState, String metallic, double EN, String valency, String ionName)
	{
		super(name, symbol, Z, A, physicalState, metallic, EN, valency);

		this.ionName = ionName;
	}
	//Copy Constructor
	public Ion(Ion i)
	{
		super(i.getName(), i.getSymbol(), i.getZ(), i.getA(), i.getPhysicalState(), i.getMetallic(), i.getEN(), i.getValency());
		this.ionName = i.getIonName();
	}	
	
	//Getter
	public String getIonName()
	{
		return this.ionName;
	}
	//Setters
	public void setIonName(String name)
	{
		ionName = name;
	}
	//toString Method
	public String toString()
	{
		return this.name + " " + this.symbol + " " + this.valency;
	}
	//Bonding
	public Product bond(Reactant other)
	{
		Compound product = new Compound(this, (Ion)other);		
		return product;
	}
}

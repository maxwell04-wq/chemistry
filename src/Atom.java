//********************************************************************
//
// File: 	Atom.java
// Purpose:	A generalization of an reactant which takes part in a 
//			molecular reaction
//
//******************************************************************
public class Atom extends Reactant
{
	int capacity;
	
	public Atom(String name, String symbol, int Z, int A, String physicalState, String metallic, double EN, String valency)
	{
		super(name, symbol, Z, A, physicalState, metallic, EN, valency);
		//Capacity Calculation
		capacity = Z;
		if (capacity <=2)
			capacity = 2-capacity;
		else 
			while (capacity >=8)
			{
				capacity = capacity- 8;
			}
	}
	
	public int getCapacity ()
	{
		return capacity;
	}

	public Product bond(Reactant other) 
	{
		Molecule m = new Molecule(this, (Atom)other);
		return m;
	}
}

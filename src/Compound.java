//*****************************************************************************
//
// File: 	Compound.java
// Purpose:	A well-defined product which combines two ions to form a compound.
//
//****************************************************************************
public class Compound extends Product
{
	// Attributes
	Ion cation, anion;
	String name;
	
	//Default Constructor
	public Compound()
	{		
	}
	//Parametrised Constructor
	public Compound(Ion cation, Ion anion)
	{
		this.cation = cation;
		this.anion = anion;
		name = cation.getIonName() + " " + anion.getIonName();
	}
	
	public String toString()
	{
		String CationValency = cation.getValency();
		int cValency = Integer.parseInt(CationValency);
									
		String AnionValency = anion.getValency().substring(1);
		int aValency = Integer.parseInt(AnionValency);		
		
		if (Integer.parseInt(CationValency)%2==0 && Integer.parseInt(AnionValency)%2==0)
		{
			cValency /=2;
			aValency /=2;
		}
		if (Integer.parseInt(CationValency)%3==0 && Integer.parseInt(AnionValency)%3==0)
		{
			cValency /=3;
			aValency /=3;
		}
		
		CationValency = "" + cValency;
		AnionValency = "" + aValency;
		
		if(AnionValency.equals("1"))
			AnionValency = "";
		if(CationValency.equals("1"))
			CationValency = "";		
		
		return (cation.getSymbol() +  AnionValency +
				anion.getSymbol() + CationValency);
	}
	
	public String getInfo()
	{
		{
			String s = "\n Type of Bond : Ionic";
			s += "\n Name : " + name;
			s += "\n Electronegative Difference : " + (anion.getEN() -  cation.getEN());
			s += "\n Cation : " +  cation.getIonName();
			s += "\n Anion : " + anion.getIonName();
			return s;
		}
		
	}
}

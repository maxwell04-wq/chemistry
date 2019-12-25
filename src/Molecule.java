//*****************************************************************************
//
// File: 	Molecule.java
// Purpose:	A well-defined product which combines two atoms to form a molecule
//
//*****************************************************************************
public class Molecule extends Product {
	String formula;
	String r1Name;
	String r2Name;
	String ProductType;
	String AdditionalDetails;
	Atom a, b;

	public Molecule(Atom a, Atom b) {
		this.a = a;
		this.b = b;
		r1Name = a.getName();
		r2Name = b.getName();

		// Incompatible Reactions
		if (a.getEN() == 0 || b.getEN() == 0) {
			formula = "xxx";
			ProductType = "No porduct formed.";
			AdditionalDetails = "The reaction is not Compatible.";
		}

		// Both Atoms are of the same Element
		else if (a.name.equals(b.name)) {
			formula = a.getSymbol() + 2;
			ProductType = "Homoatomic Molecule";
			AdditionalDetails = "When atoms of the same element react together, \n                                    "
					+ " they form  a homoatomic molecule.";
		}

		// Both Reactants are Metals
		else if (a.getMetallic().equals("Metal") && b.getMetallic().equals("Metal")) {
			formula = "" + a.getSymbol() + b.getSymbol();
			ProductType = "Alloy";
			AdditionalDetails = "The combination of one metal with another does not form a\n                                    "
					+ "molecule. The product is an alloy,\n                                    "
					+ "which is categorised as a mixture. ";
		}

		else {
			String CationValency = a.getValency();
			int cValency = Integer.parseInt(CationValency);

			String AnionValency = b.getValency().substring(1);
			int aValency = Integer.parseInt(AnionValency);

			if (Integer.parseInt(CationValency) % 2 == 0 && Integer.parseInt(AnionValency) % 2 == 0) {
				cValency /= 2;
				aValency /= 2;
			}
			if (Integer.parseInt(CationValency) % 3 == 0 && Integer.parseInt(AnionValency) % 3 == 0) {
				cValency /= 3;
				aValency /= 3;
			}

			CationValency = "" + cValency;
			AnionValency = "" + aValency;

			if (AnionValency.equals("1"))
				AnionValency = "";
			if (CationValency.equals("1"))
				CationValency = "";

			formula = a.getSymbol() + AnionValency + b.getSymbol() + CationValency;
			ProductType = "Heteroatomic Molecule";
			AdditionalDetails = "When atoms of the different elements react together,\n                                    "
					+ " they form  a heteroatomic molecule.";
		}
	}

	// Interface Implementation
	public String getInfo() {
		String info = "Atom 1 : \t\t" + r1Name;
		info += "\n Atom 2 : \t\t" + r2Name;
		info += "\n Electronegativity Difference : \t\t" + (b.getEN() - a.getEN());
		info += "\n Product Type : \t\t" + ProductType;
		info += "\n Additional Details : \t\t" + AdditionalDetails;

		return info;
	}

	// toString Method
	public String toString() {
		return formula;
	}
}

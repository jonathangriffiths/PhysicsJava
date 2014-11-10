package exam1;

public class Planet {
	//variables will be made public and final
	//this keeps them user-safe, but removes the need to write many 'getYear()' etc. methods which take extra keystrokes to use.
	//We don't want to change any of these variables after they are made (planets won't magically change), so we don't lose functionality
	public final String name;
	public final int year; //could use year class but doesn't add any functionality that we need, unnecessary complication
	public final String discMeth;
	public final double mass;//jupiter masses
	public final double planStar; //distance to planet's star in AU
	public final double planEarth; //distance to earth in parsecs, does default to null

	//Constructor WITH Earth distance
	public Planet(String Name, int Year, String DiscMeth, double Mass, double PlanStar, double PlanEarth){
		name=Name;
		year=Year;
		discMeth=DiscMeth;
		mass=Mass;
		planStar=PlanStar;
		planEarth=PlanEarth;
	}
	//Constructor WITHOUT Earth distance
	//leave earth distance as an NaN
	public Planet(String Name, int Year, String DiscMeth, double Mass, double PlanStar){
		name=Name;
		year=Year;
		discMeth=DiscMeth;
		mass=Mass;
		planStar=PlanStar;
		planEarth=Double.NaN;
	}
	//toString method for nice printing
	public String toString(){
		StringBuilder stb = new StringBuilder();
		stb.append("The planet name is: ");
		stb.append(this.name);
		stb.append("\n");
		stb.append("The planet year of discovery is: ");
		stb.append(this.year);
		stb.append("\n");
		stb.append("The planet discovery method is: ");
		stb.append(this.discMeth);
		stb.append("\n");
		stb.append("The planet-star distance is (in AU): ");
		stb.append(this.planStar);
		stb.append("\n");
		stb.append("The planet mass is (in Jupiter masses): ");
		stb.append(this.mass);
		stb.append("\n");
		if(!Double.isNaN(this.planEarth)){
			stb.append("The planet-earth distance is (in parsecs): ");
			stb.append(this.planEarth);
		}
		else{stb.append("The planet-earth distance is unknown");}
		String str = stb.toString();
		return str;
	}
}

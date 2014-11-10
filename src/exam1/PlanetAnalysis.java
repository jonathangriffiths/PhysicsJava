package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class PlanetAnalysis {

	//Produce bufferedreader from URL
	public static BufferedReader brFromURL(String url) throws IOException{
		URL u = new URL (url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}

	//Collects the whole set of data into one ArrayList of Planet objects
	public static ArrayList<Planet> collectData(BufferedReader br) throws IOException{
		//init var
		ArrayList<Planet> planets = new ArrayList<Planet>();
		String line ="";
		//skip descriptive line
		br.readLine(); 
		while((line = br.readLine()) != null){
			//while we have lines, scan lines
			Scanner s = new Scanner(line);
			//use appropriate delim
			s.useDelimiter(",");
			//collect variables from scanner:
			String PlanName = s.next();
			int PlanYear = s.nextInt();
			String PlanMeth = s.next();
			double PlanMass = s.nextDouble();
			double PlanStar = s.nextDouble();
			//IF we have earth distance, put it into the object
			//and add to ArrayList
			if(s.hasNextDouble()){
				double PlanEarth = s.nextDouble();
				Planet tempPlanet = new Planet(PlanName, PlanYear, PlanMeth, PlanMass, PlanStar, PlanEarth);
				planets.add(tempPlanet);
			}
			//Otherwise, use alternate constructor (no PlanEarth) and have NaN for PlanEarth
			//and add to ArrayList
			else{
				Planet tempPlanet = new Planet(PlanName, PlanYear, PlanMeth, PlanMass, PlanStar);
				planets.add(tempPlanet);
			}
			s.close();//avoid memory leaks
		}
		return planets;
	}
	//return an array list of only those planets which match a method
	public static ArrayList<Planet> arrayListFromMethod(ArrayList<Planet> allData, String Method){
		//init
		ArrayList<Planet> methodList = new ArrayList<Planet>();
		//loop over all planets
		for(int i=0; i<allData.size(); i++){
			//key equals - if method equals Method.
			if (Method.equals(allData.get(i).discMeth)){
				methodList.add(allData.get(i));
			}
		}
		return methodList;
	}

	public static void main(String[] args) {

		try {
			//collecting all data into one ArrayList
			BufferedReader b = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/exoplanets.txt");
			ArrayList<Planet> list = collectData(b);


			//let's find the closest exoplanet out of all of them:
			double closestDistance=Double.MAX_VALUE;
			int closestIndex = -1; //should produce an error if the code doesn't work
			//loop through the ArrayList updating when we find a closer planet
			//Could have used a Comparator but we son't want to just sort by mass
			for(int i=0; i<list.size(); i++){
				if(list.get(i).planEarth!=Double.NaN && list.get(i).planEarth < closestDistance){//discount NaNs
					closestDistance = list.get(i).planEarth;
					closestIndex = i;
				}
			}
			System.out.println("THE CLOSEST EXOPLANET TO EARTH IS:");
			System.out.println(list.get(closestIndex).toString()+"\n");

			//let's separate out planets by method
			//first we want to build up knowledge of what the methods are
			//we will make the ArrayList of methods which contains the methods
			//We can do this generally so it doesn't break if a new method is put in
			ArrayList<String> methods = new ArrayList<String>();
			for(int i=0; i<list.size(); i++){
				String tempMethod = list.get(i).discMeth;
				//if the method is not contained in methods, add it in
				if(!methods.contains(tempMethod)){methods.add(tempMethod);}
			}
			System.out.println("Our methods are:"+methods.toString());

			//Let us loop through the methods, printing the information that we want
			//master loop does one method at a time
			for(int i =0; i<methods.size(); i++){
				ArrayList<Planet> methodData = arrayListFromMethod(list, methods.get(i));
				System.out.println("\nWe are looking at the method "+methods.get(i));
				System.out.println("There are "+methodData.size()+" planets found by this method");

				//sub loop does smallest year for a single method
				int holdingYear =Integer.MAX_VALUE;
				int yearIndex=-1; //error for debugging
				for(int j=0; j<methodData.size(); j++){
					if(methodData.get(j).year<holdingYear){
						holdingYear = methodData.get(j).year;
						yearIndex = j;
					}
				}
				System.out.println("The earliest year for this method was " + methodData.get(yearIndex).year);

				//sub loop does lightest planet for a single method
				double holdingMass=Double.MAX_VALUE;
				int massIndex=-1;//error for debugging
				for(int j=0; j<methodData.size(); j++){
					if(methodData.get(j).mass<holdingMass){
						holdingMass = methodData.get(j).mass;
						massIndex = j;
					}
				}
				System.out.println("The lightest planet from this method follows:\n"+methodData.get(massIndex).toString());
			}


		} catch (IOException e) {
			System.out.println("Getting the BR from URL has failed. See the message:\n"+e.getMessage());
			//I appreciate it's not ideal to lump it all into one try/catch but had a bit of a panic over equals() vs. == so lost time
		}
		

	}

}

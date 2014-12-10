package exam2LastYear;

/**
 * Class runs analysis over data files listed within
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OrganismAnalysis{

	/** Function provides a bufferedreader object from a URL
	 * @param URL as string
	 * @return buffered reader from URL
	 * @throws IOException for URL issues
	 */
	public static BufferedReader brFromURL(String url) throws IOException{
		URL u = new URL (url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}


	public static Map<String, String> getIDNameMap(BufferedReader names) throws IOException{
		String line="";
		//create map to hold ID/names
		Map<String, String> IDNameMap = new HashMap<String, String>();
		//fill map one by one
		while((line=names.readLine()) != null){
			Scanner s = new Scanner(line);
			String ID = s.next();
			String name1 = s.next();
			String name2 = s.next();
			String name = name1+" "+name2;
			IDNameMap.put(ID, name);
			s.close();
		}
		return IDNameMap;
	}


	/**
	 * Function takes the data from the URLs supplied for the exercise.
	 * It returns a list of Organism subclass instances (Plant or Animal)
	 * @param takes the bufferedReader of the data and of the names
	 * @returns an arraylist of the Organism objects
	 * @throws IOException from the readlines.
	 */
	public static ArrayList<Organism> collectData(BufferedReader data, BufferedReader names) throws IOException{
		//init var
		ArrayList<Organism> orgs = new ArrayList<Organism>();
		String line ="";
		//equate IDs to names

		Map<String, String> IDNameMap=getIDNameMap(names);

		//read in the data line by line from the bufferedreader
		while((line = data.readLine()) != null){
			//while we have lines, scan lines
			Scanner s = new Scanner(line);
			//collect variables from scanner:
			double latitude = s.nextDouble();
			double longitude = s.nextDouble();
			String code = s.next();
			String taxName = IDNameMap.get(code);

			//if there is a height, it's a plant
			if(s.hasNextDouble()){
				double height = s.nextDouble(); 
				Plant tempOrganism = new Plant(latitude, longitude, code, taxName, height);
				orgs.add(tempOrganism);
			}
			//otherwise it is an animal
			else{
				Animal tempOrganism = new Animal(latitude, longitude, code, taxName);
				orgs.add(tempOrganism);
			}

			s.close();//avoid memory leaks
		}
		return orgs;
	}
	
	public List<Organism> betweenLong(ArrayList<Organism> dataset, double minLong, double maxLong){
		List<Organism> result = new ArrayList<Organism>();
		for(Organism i : dataset){
			if(i.getLong()<maxLong && i.getLong()>minLong){result.add(i);}
		}
		return result;
	}
	
	public List<Organism> betweenLat(ArrayList<Organism> dataset, double minLat, double maxLat){
		List<Organism> result = new ArrayList<Organism>();
		for(Organism i : dataset){
			if(i.getLat()<maxLat && i.getLat()>minLat){result.add(i);}
		}
		return result;
	}
	


	public double haversin(double angle){return (1-Math.cos(angle))/2;}

	public static void main(String[] args) {
		String plant_data_url="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-plants.txt";
		String plant_names_url = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-plants.txt";
		String animal_data_url="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-animals.txt";
		String animal_names_url="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-animals.txt";

		try {
			BufferedReader plant_names_reader = brFromURL(plant_names_url);
			BufferedReader plant_data_reader=brFromURL(plant_data_url);
			BufferedReader animal_names_reader=brFromURL(animal_names_url);
			BufferedReader animal_data_reader=brFromURL(animal_data_url);

			ArrayList<Organism> plant_list = collectData(plant_data_reader, plant_names_reader);
			ArrayList<Organism> animal_list = collectData(animal_data_reader, animal_names_reader);

			//NOW WE DO THE TOTAL NUMBER PER SPECIES
			//count up the total number of samples per organism
			Map<String, String> plant_names = getIDNameMap(plant_names_reader);
			System.out.println(plant_names.size());
			//get access to keys
			Set<String> IDs = plant_names.keySet();
			//use iterator to go through key set
			Iterator<String> iterator = IDs.iterator();
			while(iterator.hasNext()){
				int counter=0;
				String ID = iterator.next();
				//loop through the plant list, counting up the number which share the key selected
				for(Organism i : plant_list){
					if(i.getID().equals(ID)){counter++;}
				}
				//print results
				System.out.println("There were "+counter+" samples for the organism "+plant_names.get(ID));
			}
			//NOW WE DO TALLEST/SHORTEST
			String smallName=null;
			String tallName=null;
			double smallHeight=Double.MAX_VALUE;
			double tallHeight=Double.MIN_VALUE;
			for(Organism i : plant_list){
				if(i instanceof Plant){
					Plant p = (Plant) i;
					if(p.getHeight()>tallHeight){
						tallHeight=p.getHeight();
						tallName=p.getName();
					}
					if(p.getHeight()<smallHeight){
						smallHeight=p.getHeight();
						smallName=p.getName();
					}
				}
			}
			System.out.println("The smallest plant is "+smallName+" at a height of "+smallHeight);
			System.out.println("The tallest plant is "+tallName+" at a height of "+tallHeight);
			
			

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}

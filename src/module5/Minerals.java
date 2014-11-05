package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Minerals {

	public static BufferedReader brFromURL(String url) throws IOException{
		URL u = new URL (url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}


	public static void main(String[] args) {
		try {
			BufferedReader originData = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");
			BufferedReader massData = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
			Scanner originScanner = new Scanner(originData);
			Scanner massScanner = new Scanner(massData);
			//Integers save storage space compared to string codes.
			HashMap<Integer, String> origins = new HashMap<Integer, String>();
			HashMap<Integer, Double> masses = new HashMap<Integer, Double>();
			//init variable variables
			String originTemp;
			int codeTemp;
			double massTemp;

			//populate origin information
			while(originScanner.hasNextLine()){
				originTemp=originScanner.next();
				codeTemp=originScanner.nextInt();
				origins.put(codeTemp, originTemp);
				originScanner.nextLine();
			}
			originScanner.close();

			double smallestMass = Double.POSITIVE_INFINITY;
			double largestMass = Double.NEGATIVE_INFINITY;
			int smallestCode=0;
			int largestCode=0;

			while(massScanner.hasNextLine()){
				codeTemp=massScanner.nextInt();
				massTemp=massScanner.nextDouble();
				masses.put(codeTemp, massTemp);
				massScanner.nextLine();
				//The most efficient way to find the values we want is in this loop
				//not to reloop through the formed hashmap
				if(massTemp<smallestMass){
					smallestMass = massTemp;
					smallestCode = codeTemp;
				}
				if(massTemp>largestMass){
					largestMass = massTemp;
					largestCode = codeTemp;
				}
			}
			massScanner.close();
			//An alternative to loop through the HashMaps is:

			int sKey=0;
			int lKey=0;
			double min =Double.POSITIVE_INFINITY;
			double max = Double.NEGATIVE_INFINITY;
			for(Map.Entry<Integer,Double> e:masses.entrySet()){
				if(e.getValue()<min){
					sKey=e.getKey();
					min=e.getValue();
				}
				if(e.getValue()>max){
					lKey=e.getKey();
					max=e.getValue();
				}
			}

			System.out.println("The smallest mass rock has ID "+smallestCode);
			System.out.println("The smallest mass rock has origin "+origins.get(smallestCode));
			System.out.println("The smallest mass rock has mass "+masses.get(smallestCode));
			System.out.println("ID by second method is: "+sKey+"\n");

			System.out.println("The largest mass rock has ID "+largestCode);
			System.out.println("The largest mass rock has origin "+origins.get(largestCode));
			System.out.println("The largest mass rock has mass "+masses.get(largestCode));
			System.out.println("ID by second method is: "+lKey+"\n");




		} catch (IOException e) {
			System.out.println("Exception!");
			System.out.println(e.getMessage());
		}
	}

}

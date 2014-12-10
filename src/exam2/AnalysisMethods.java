package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * Class creates methods needed for data analysis of exam2
 * @author Jonathan Griffiths
 *
 */

public class AnalysisMethods {
	/** 
	 * brFromURL returns a BufferedReader from a webpage
	 * @param url is a string of the URL that the function will read
	 * @return BufferedReader of the URL's page
	 * @throws IOException if the URL is faulty
	 */
	public static BufferedReader brFromURL(String url) throws IOException{
		URL u = new URL (url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}

	/**
	 * getSitesMap returns a map of IDs and sites from the data provided for exam2
	 * @param siteURL is the URL for the data with port information
	 * @return a Map<String, String> of ID keys and port values.
	 * @throws IOException if the URL is faulty
	 */
	public static Map<String, String> getSitesMap(String siteURL) throws IOException{
		//init variables
		String line;
		Map<String, String> output = new HashMap<String, String>();
		BufferedReader reader = brFromURL(siteURL);
		//skip the first line (column identifiers)
		reader.readLine();
		//while we have lines...
		while((line = reader.readLine()) != null){
			//...scan lines
			Scanner s = new Scanner(line);
			//first is the ID
			String ID = s.next();
			//then the port
			String name = s.next();
			//then we add to the Map.
			output.put(name, ID);
			s.close();
		}
		return output;
	}
	/**
	 * Function reads in data to a List.
	 * @param dataURL is the URL of the data source as given in exam2
	 * @param siteURL is the URL of the dock/ID breakdown as given in exam2
	 * @return a List<Tide> of all the data given at the dataURL
	 * @throws IOException is the URL's are messed up.
	 */
	public static List<Tide> readInData(String dataURL, String siteURL) throws IOException{
		//init var
		Map<String, String> site_codes = getSitesMap(siteURL);
		BufferedReader data = brFromURL(dataURL);
		String line;
		List<Tide> tides = new ArrayList<Tide>();
		while((line = data.readLine()) != null){
			//...scan lines
			Scanner s = new Scanner(line);
			//first is the ID
			String ID = s.next();
			//then the Year
			int year = s.nextInt();
			//then the month
			int month = s.nextInt();
			//then etc. etc.
			int day = s.nextInt();
			int hours = s.nextInt();
			int minutes = s.nextInt();
			double sea_level = s.nextDouble();
			double predicted_level = s.nextDouble();
			//get port name from ID
			String port = site_codes.get(ID);

			//create Tide object
			Tide tempTide=new Tide(ID, port, year, month, day, hours, minutes, sea_level, predicted_level);
			//then we add to the List.
			tides.add(tempTide);
			//stop memory leaks
			s.close();
		}
		return tides;
	}
	/**
	 * 	A modified function for reading in data with a slightly different layout.
	 * @param dataURL is the URL of the data source as given in exam2
	 * @param siteURL is the URL of the dock/ID breakdown as given in exam2
	 * @return a List<Tide> of all the data given at the dataURL
	 * @throws IOException is the URL's are messed up.
	 */
	public static List<Tide> readInDataPart3(String dataURL, String siteURL) throws IOException{
		//init var
		Map<String, String> site_codes = getSitesMap(siteURL);
		BufferedReader data = brFromURL(dataURL);
		String line;
		List<Tide> tides = new ArrayList<Tide>();
		while((line = data.readLine()) != null){
			//...scan lines
			Scanner s = new Scanner(line);
			//Year first
			int year = s.nextInt();
			//then the month
			int month = s.nextInt();
			//then etc. etc.
			int day = s.nextInt();
			int hours = s.nextInt();
			int minutes = s.nextInt();
			String ID = s.next();
			double sea_level = s.nextDouble();
			double predicted_level = s.nextDouble();
			//get port name from ID
			String port = site_codes.get(ID);
			//create Tide object
			Tide tempTide=new Tide(ID, port, year, month, day, hours, minutes, sea_level, predicted_level);
			//then we add to the List.
			tides.add(tempTide);
			//stop memory leaks
			s.close();
		}
		return tides;
	}
	/**
	 * Function identifies highest sea_level Tide from a List
	 * @param data is a List<Tide> of data for analysis
	 * @return the Tide object with the highest sea_level
	 * @throws Exception if the data is empty
	 */
	public static Tide getHighestTide(List<Tide> data) throws Exception{
		if(data.size()==0){throw new Exception("Data is empty");}
		Tide highest = data.get(0);
		double value = Double.MIN_VALUE;
		for(Tide t : data){
			if(t.getLevel() > value){
				highest=t;
				value = highest.getLevel();
			}
		}
		return highest;
	}
	/**
	 * Function identifies lowest sea_level Tide from a List
	 * @param data is a List<Tide> of data for analysis
	 * @return the Tide object with the lowest sea_level
	 * @throws Exception if the data is empty
	 */
	public static Tide getLowestTide(List<Tide> data) throws Exception{
		if(data.size()==0){throw new Exception("Data is empty");}
		Tide highest = data.get(0);
		double value = Double.MAX_VALUE;
		for(Tide t : data){
			if(t.getLevel() < value){
				highest=t;
				value = t.getLevel();
			}

		}
		return highest;
	}

	/**
	 * Function identifies highest tidal_surge Tide from a List
	 * @param data is a List<Tide> of data for analysis
	 * @return the Tide object with the highest todal_surge
	 * @throws Exception if the data is empty
	 */
	public static Tide getHighestSurge(List<Tide> data) throws Exception{
		if(data.size()==0){throw new Exception("Data is empty");}
		Tide highest = data.get(0);
		double value = Double.MIN_VALUE;
		for(Tide t : data){
			if(t.getTidalSurge() > value){
				highest=t;
				value = highest.getTidalSurge();
			}

		}
		return highest;
	}

	/**
	 * 
	 * @param data is List<Tide> for subsetting
	 * @param ID is the ID that will be used to subset
	 * @return a List<Tide> for only those Tide objects which have an ID that matches the ID given
	 */
	public static List<Tide> subsetByPort(List<Tide> data, String ID){
		List<Tide> output = new ArrayList<Tide>();
		for(Tide t : data){
			if(t.getID().equals(ID)){output.add(t);}
		}
		return output;
	}
}

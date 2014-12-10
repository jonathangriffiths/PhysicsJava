package exam2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Class uses methods from exam2 package to perform analysis over data provided
 * @author Jonathan Griffiths
 *
 */
public class Analysis {
	//init var

	static List<Tide> data1999;
	static 	List<Tide> data2000;
	static	List<Tide> data2001;
	static List<Tide> data2004;
	static 	List<Tide> data2005;
	static	List<Tide> data2006;
	static List<Tide> allData = new ArrayList<Tide>();
	static List<Tide> allDataPart3 = new ArrayList<Tide>();

	static Map<String, String> locations = new HashMap<String, String>();

	static String siteURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt";
	static String dataURL1999 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt";
	static	String dataURL2000 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2000.txt";
	static	String dataURL2001 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2001.txt";
	static String siteURLpart3 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/sites.txt";
	static String dataURLpart32004="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2004.txt";
	static String dataURLpart32005="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2005.txt";
	static String dataURLpart32006="http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2006.txt";

	public static void main(String[] args) {

		//Read in all the data
		try {
			System.out.println("Starting read-in");
			List<Tide> data1999 = AnalysisMethods.readInData(dataURL1999, siteURL);
			System.out.println("Read in 1999");
			List<Tide> data2000 = AnalysisMethods.readInData(dataURL2000, siteURL);
			System.out.println("Read in 2000");
			List<Tide> data2001 = AnalysisMethods.readInData(dataURL2001, siteURL);
			System.out.println("Read in 2001");
			allData.addAll(data1999);
			System.out.println("Added 1999 to master list");
			allData.addAll(data2000);
			System.out.println("Added 2000 to master list");
			allData.addAll(data2001);
			System.out.println("Added 2001 to master list");
			System.out.println("All data was correctly read in and combined");

		} catch (IOException e) {
			System.out.println("There was an error reading in data");
			System.out.println(e.getMessage());
		}

		//find the highest tide on record
		try {
			System.out.println("\nThe highest tide recorded was:");
			System.out.println(AnalysisMethods.getHighestTide(allData).toString());
		} catch (Exception e) {
			System.out.println("There was an error getting the highest tide");
			System.out.println(e.getMessage());
		}

		//do some summary stats on each location:
		try {
			//generate map of locations
			Map<String, String> locations = AnalysisMethods.getSitesMap(siteURL);
			//for each location,
			for (Map.Entry<String, String> entry : locations.entrySet())
			{ 
				//create instances of the implementations (Java does not support static methods in interfaces yet)
				MeanStat mean = new MeanStat();
				TidalRangeStat range = new TidalRangeStat();
				//intro line
				System.out.println("\nFor: "+entry.getValue());
				//methods subset the data and then perform their calculations.
				System.out.println("The mean sea level is: "+ mean.statistic(allData, entry.getKey()));
				System.out.println("The tidal range is: "+range.statistic(allData, entry.getKey()));
			}
		} catch (IOException e) {
			System.out.println("There was an error getting the site map");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("There was doing the stat analysis");
			System.out.println(e.getMessage());
		}
		//Find highest surge
		try {
			System.out.println("\nThe highest surge was:");
			System.out.println(AnalysisMethods.getHighestSurge(allData).toString());
		} catch (Exception e) {
			System.out.println("There was an error getting the surge");
			System.out.println(e.getMessage());
		}

		//Part 3 data readin
		try {
			System.out.println("Starting extra data read-in");
			List<Tide> data2004 = AnalysisMethods.readInDataPart3(dataURLpart32004, siteURLpart3);
			System.out.println("Read in 2004");
			List<Tide> data2005 = AnalysisMethods.readInDataPart3(dataURLpart32005, siteURLpart3);
			System.out.println("Read in 2005");
			List<Tide> data2006 = AnalysisMethods.readInDataPart3(dataURLpart32006, siteURLpart3);
			System.out.println("Read in 2006");
			allDataPart3.addAll(data2004);
			System.out.println("Added 2004 to extra data master list");
			allDataPart3.addAll(data2005);
			System.out.println("Added 2005 to extra data master list");
			allDataPart3.addAll(data2006);
			System.out.println("Added 2006 to extra data master list");
			System.out.println("All extra data read in and combined.");
		} catch (IOException e) {
			System.out.println("There was an error reading in the extra data");
			System.out.println(e.getMessage());
		}
		//Part 3 data analysis
		try {
			System.out.println("\nThe largest surge in the extra data was:");
			System.out.println(AnalysisMethods.getHighestSurge(allDataPart3).toString());
		} catch (Exception e) {
			System.out.println("There was an error getting the surge in the extra data");
			System.out.println(e.getMessage());
		}
	}
}

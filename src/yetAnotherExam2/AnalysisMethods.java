package yetAnotherExam2;

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

public class AnalysisMethods {

	public static BufferedReader brFromURL(String url) throws IOException{
		URL u = new URL (url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}

	public static Map<String, String> getRegionMap(String regionsURL) throws IOException{
		String line;
		Map<String, String> output = new HashMap<String, String>();
		BufferedReader reader = brFromURL(regionsURL);
		while((line = reader.readLine()) != null){
			//while we have lines, scan lines
			Scanner s = new Scanner(line);
			s.useDelimiter(",");
			String ID = s.next();
			String name = s.next();
			output.put(ID, name);
			s.close();
		}
		return output;
	}

	public static Map<String, Integer> getPopMap(String popURL) throws IOException{
		String line;
		Map<String, Integer> output = new HashMap<String, Integer>();
		BufferedReader reader = brFromURL(popURL);
		//skip descriptor
		reader.readLine();
		while((line = reader.readLine()) != null){
			//while we have lines, scan lines
			Scanner s = new Scanner(line);
			String ID = s.next();
			Integer pop = s.nextInt();
			output.put(ID, pop);
			s.close();

		}
		return output;
	}

	public static Map<String, Integer> getDiseaseMap(String URL, int term) throws IOException{
		String line;
		Map<String, Integer> output = new HashMap<String, Integer>();
		BufferedReader reader = brFromURL(URL);
		while((line = reader.readLine()) != null){
			//while we have lines, scan lines
			Scanner s = new Scanner(line);
			String ID = s.next();
			//skip as many terms as needed i.e. 1 for y, 2 for z
			for(int i = 1; i<term; i++){s.next();}
			Integer num = s.nextInt();
			output.put(ID, num);
			s.close();
		}
		return output;
	}



	public static List<Location> harvestData(String regionsURL, String populationsURL, String xyzURL, String abURL) throws IOException{
		
		List<Location> data = new ArrayList<Location>();
		
		Map<String, String> names = getRegionMap(regionsURL);
		Map<String, Integer> pops = getPopMap(populationsURL);
		Map<String, Integer> x = getDiseaseMap(xyzURL, 1);
		Map<String, Integer> y = getDiseaseMap(xyzURL, 2);
		Map<String, Integer> z = getDiseaseMap(xyzURL, 3);
		Map<String, Integer> a = getDiseaseMap(abURL, 1);
		Map<String, Integer> b = getDiseaseMap(abURL, 2);
		
		//for each ID
		for(String id : names.keySet()){
			//if it does  have AB:
			if(a.containsKey(id)){
				String name = names.get(id);
				Integer pop = pops.get(id);
				Integer A = a.get(id);
				Integer B = b.get(id);
				Integer X = x.get(id);
				Integer Y = y.get(id);
				Integer Z = z.get(id);
				Location tempLocation = new LocationAB(pop, id, name, X, Y, Z, A, B);
				data.add(tempLocation);
			}
			//or if it does not have AB:
			if(!a.containsKey(id)){
				String name = names.get(id);
				Integer pop = pops.get(id);

				Integer X = x.get(id);
				Integer Y = y.get(id);
				Integer Z = z.get(id);
				Location tempLocation = new Location(pop, id, name, X, Y, Z);
				data.add(tempLocation);
			}		
		}
		return data;
	}

}

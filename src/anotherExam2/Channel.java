package anotherExam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Container class for a channel for exam2
 * @author Jonathan Griffiths
 *
 */
public class Channel {



	HashMap<Integer, Double> bins;
	HashMap<Integer, Double> predicted;
	ArrayList<Double> events;
	String channelName;

	public static BufferedReader brFromURL(String url) throws IOException{
		URL u = new URL (url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}

	public Channel(String dataURL, String predictedURL, String channelName) throws IOException{
		String line;
		BufferedReader dataBR = brFromURL(dataURL);
		BufferedReader predictedBR = brFromURL(predictedURL);
		this.channelName = channelName;

		//skip title line
		dataBR.readLine();
		predictedBR.readLine();

		//populate actual event list
		while((line=dataBR.readLine())!=null){
			Scanner s = new Scanner(line);
			if(s.next().equals(channelName)){
				//clear the channel name
				s.next();
				//add the data point
				events.add(s.nextDouble());
			}
			s.close();
		}

		//populate predicted map
		while((line=predictedBR.readLine())!=null){
			Scanner s = new Scanner(line);
			if(s.next().equals(channelName)){
				//read in lower value of bin
				int key = s.nextInt();
				//skip higher value of bin
				s.next();
				//read in predicted value
				double value = s.nextDouble();
				//add to map of predicteds
				predicted.put(key, value);
			}
			s.close();
		}
		
		//count over events to fill up bins
		//loop through all bins
		for(int bin : predicted.keySet()){
			//then loop through each event
			for(double event : events){
				int eventInt=(int) event;
				//if the event fits the bin and is not yet in the map, add it to the map
				if(eventInt==bin && !bins.containsKey(bin)){
					bins.put(bin, 1.0);
				}
				//if the event fits the bin and it is already in the map, update the frequency by 1
				if(eventInt==bin && bins.containsKey(bin)){
					bins.put(bin, bins.get(bin) + 1);
				}
			}
		}
		
	}

}

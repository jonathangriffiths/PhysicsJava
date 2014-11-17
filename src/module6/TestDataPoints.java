package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TestDataPoints {
	public static List<DataPoint> dataFromURL(String urlName) throws IOException{
		//init readers, scanner, empty List, empty string
		URL u = new URL (urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		String line;
		List<DataPoint> points = new ArrayList<DataPoint>();
		//read buffered reader line by line
		while((line = b.readLine()) != null){
			//scan the line
			Scanner s = new Scanner(line);
			//Populate List
			double xTemp=s.nextDouble();
			double yTemp=s.nextDouble();
			double eyTemp=s.nextDouble();
			//If there is the label, make a LabelledDataPoint:
			if(s.hasNext()){
				String name = s.next();
				DataPoint pointTemp = new LabelledDataPoint(xTemp, yTemp, eyTemp, name);
				points.add(pointTemp);
			}
			//Otherwise, just a DataPoint
			else{
				DataPoint pointTemp = new DataPoint(xTemp, yTemp, eyTemp);
				points.add(pointTemp);
			}
			//Stop resource leaks:
			s.close();
		}
		return points;
	}

	public static void main(String[] args) {

		try {
			List<DataPoint> data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			//for(int i=0; i<data.size(); i++){System.out.println(data.get(i).toString());}
			//Commented out 'formal' loop, using shortcut below:
			for(DataPoint point : data){System.out.println(point.toString());}

		} catch (IOException e) {
			System.out.println("The URL probably has issues. Exception message:");
			System.out.println(e.getMessage());
		}


	}

}

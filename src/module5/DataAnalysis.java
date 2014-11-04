package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {

	public static ArrayList<DataPoint> dataFromURL(String urlName) throws IOException{
		//init readers + scanner
		URL u = new URL (urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		Scanner s = new Scanner(b);
		//init ArrayList
		ArrayList<DataPoint> points = new ArrayList<DataPoint>();
		//Loop to populate list
		while(s.hasNextLine()){
			double xTemp=s.nextDouble();
			double yTemp=s.nextDouble();
			double eyTemp=s.nextDouble();
			DataPoint pointTemp = new DataPoint(xTemp, yTemp, eyTemp);
			points.add(pointTemp);
			s.nextLine();
		}
		return points;
	}
	
	public static double goodnessOfFit(Theory order, ArrayList<DataPoint> values){
		
		int arraySize=values.size();
		double GOFtotal=0;
		
		for(int i = 0; i<arraySize; i++){
			double xVal = (values.get(i)).getX();
			double theoryVal=order.y(xVal);
			double yVal = (values.get(i)).getY();
			double eyVal = (values.get(i)).getEY();
			double GOFpoint = (yVal - theoryVal) * (yVal - theoryVal) / (eyVal * eyVal);
			GOFtotal+=GOFpoint;
		}
		return GOFtotal;
		
	}
	

	public static void main(String[] args) {
		try {
			Theory two = new Theory(2);
			Theory four = new Theory(4);
			ArrayList<DataPoint> dataset = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
			double powertwo=goodnessOfFit(two, dataset);
			double powerfour=goodnessOfFit(four, dataset);
			
			System.out.format("The chi statistic for X^2 is: %.3f \n", powertwo);
			System.out.format("The chi statistic for X^4 is: %.3f \n", powerfour);
			
			if(powertwo>powerfour){System.out.println("The X^4 model fits better than the X^2 model");}
			else if(powertwo<powerfour){System.out.println("The X^2 model fits better than the X^4 model");}
			else if(powertwo==powerfour){System.out.println("The X^2 model fits (unbelievably) identically with the X^4 model");}
			else{System.out.println("The comparison between the two models has not quite worked here");}

		} catch (IOException e) {
			System.out.println("BALLS");
			e.printStackTrace();
		}

	}

}

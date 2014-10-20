package module4;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class NumericalReader {
	private double minValue;
	private double maxValue;
	private double nValues;
	private double sumValues;
	private File fileName=new File("~/Users/Jono/Dropbox/Work/Java/sampleData/module4_data2.txt");
	private String fileNameString=fileName.toString();
	private URL url;
	public NumericalReader(){}
	//returns buffered reader from a URL
	public static BufferedReader brFromURL(String urlName) throws IOException{
		URL u;
		u = new URL (urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}

	public static BufferedReader brFromFile(String filename) throws FileNotFoundException{
		FileReader fr;
		fr = new FileReader(filename);
		BufferedReader b = new BufferedReader(fr);
		return b;
	}

	public void analysisStart() throws IOException{
		minValue=0;
		maxValue=0;
		nValues=0;
		sumValues=0;
		File outputFile = new File("~/Users/Jono/Dropbox/Work/Java/PHAS3459/sampleData/module4output.txt"); //osx file formatting, hardcoded for now
		FileWriter f = new FileWriter (outputFile);
		f.close();
	}
	
	public void analyseData(String s){
		if(!s.isEmpty() && Character.isDigit(s.charAt(0))){//non empty, numeric starting row
			Scanner scan = new Scanner(s); //values separated by whitespace
			while (scan.hasNext()){
				//read and print to screen one per line
				float token=scan.nextFloat();
				System.out.println(token);
				//print to file, one per line
				//TODO
				//Update the tracking values
				nValues++;
				if(token>maxValue){maxValue=token;}
				sumValues+=token;
				//how to do min value?
			}
			
			
			
		}
	
	}
	
	public void analysisEnd(){
		System.out.println("Number of values: "+nValues);
		System.out.println("Sum of values: "+sumValues);
		System.out.println("Max value: "+maxValue);
		System.out.println("Min value: "+minValue);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
